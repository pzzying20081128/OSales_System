function create_stock_store_reveive_window(moduleId, moduleName) {

	checkButton = new Ext.Toolbar.Button({
		// id : moduleId + '_check',
		xtype : "tbbutton",
		key : "check",
		text : "审核",
		disabled : true,
		check : "check",
		// keyBinding : createSearchKey(),
		handler : function() {
			var searchWindex = stock_store_reveive_check_windows(moduleId, moduleName, {
				grid : mainGridModule,
				detailGrid : detailGrid

			});
		}
	});

	searchButton = new Ext.Toolbar.Button({
		// id : moduleId + '_search',
		xtype : "tbbutton",
		text : "查询",
		key : "search",
		disabled : false,
//		check : "show",
		// keyBinding : createSearchKey(),
		handler : function() {
			detailGrid.removeAll();
			var searchWindex = stock_store_reveive_search_windows(moduleId, moduleName, {
				grid : mainGridModule,
				searchParams : stock_store_reveive_search_params
			});
		}
	});

	printButton = new Ext.Toolbar.Button({
		// id : moduleId + '_search',
		xtype : "tbbutton",
		text : "打印",
		key : "print",
		disabled : true,
		check : "show",
		// keyBinding : createSearchKey(),
		handler : function() {
		}
	});

	var mainGridModule = new mainGridWindow({

		moduleId : moduleId,
		// list grid
		url : "./list_StockStoreReceive_list.do",
		// grid_column.record
		record : stock_store_reveive_grid_column.record,
		// grid_column.column
		column : stock_store_reveive_grid_column.column,
		tbar : {
			// plugins : new Ext.ux.ToolbarKeyMap(),
			items : [{
				// id : moduleId + '_edit',
				xtype : "tbbutton",
				text : "编辑",
				key : "edit",
				disabled : true,
				check : "hide",
				// keyBinding : createEditKey(),
				handler : function(bt) {
					stock_store_reveive_update_windows(moduleId, moduleName, {
						grid : mainGridModule
					});
				}
			}, {
				// id : moduleId + '_delete',
				xtype : "tbbutton",
				text : "删除",
				key : "delete",
				disabled : true,
				check : "hide",
				// keyBinding : createDeleteKey(),
				handler : function(bt) {
					stock_store_reveive_delete_windows(moduleId, moduleName, {
						grid : mainGridModule
					});
				}
			}, searchButton, checkButton, printButton]
		},
		init : {
			// 行被选择
			select : function(rowDataId, data) {
				status = data.status;
				if (status == '已审核') {
					checkButton.setText("取消审核");
					mainGrid.openButton({
						check : true
					});
				} else if (status == '有效') {
					checkButton.setText("审核");
					mainGrid.openButton({
						check : false
					});
				}else{
					
				}
				// //////////////////////////////////////////

				detailGrid.load({
					params : {
						"searchBean.stockStoreReceiveId" : rowDataId
					}
				});

			},
			// 返回这一行的状态 1:OK -1 NO OK checkName:
			status : function(data) {

			}
		}
	});

	var mainGrid = mainGridModule.getGrid();

	var detailGrid = new create_stock_store_reveive_detail_window(moduleId + "_detail", moduleName, {

		mainGrid : mainGridModule.getGrid()

	});
	
	mainGrid.addSetButton({
	addSet:{
		grids : [mainGrid, detailGrid]
	}
	});

	var layout = new Ext.Panel({
		layout : 'border',
		width : 600,
		height : 600,
		minHeight : 100,
		maxHeight : 500,
		items : [new Ext.Panel({
			id : "111",
			layout : 'fit',
			region : 'north',
			margins : '0 0 0 0',
			split : true,
			height : 300,
			items : mainGrid
			// items : sales_order_store_out_panel_print
		})

		, new Ext.Panel({
			id : "222",
			layout : 'fit',
			region : 'center',
			margins : '0 0 0 0',

			// height : "atuo",
			title : '明细',
			items : detailGrid

			// items : sales_order_store_out_panel_print
		})

		]
	});

	var window = new Ext.ERPWindow({
		title : moduleName,
		items : [layout],// 里面所包含的组件
		// 用于权限
		grids : [mainGrid, detailGrid],
		moduleId : moduleId,
		listeners : {}
	});
	window.showWin();

	mainGrid.load({
		params : {
			'searchBean.status' : '有效'
		}
	});

	function stock_store_reveive_delete_windows(moduleId, moduleName, params) {
		var mainGridModule = params.grid;
		var mainGrid = mainGridModule.getGrid();
		var selection_rows = mainGrid.getSelectionModel().getSelections();

		if (selection_rows == null) {
			showErrorMsg('提示信息', '请选择要删除的数据记录！！');
			return false;
		}

		if (selection_rows.length != 1) {
			showErrorMsg('提示信息', '只能选择一行数据记录！！');
			return false;
		}
		var selectId = selection_rows[0].id;
		showMsgYN({
			msg : "是否要删除该条信息",
			yes : function(YN) {
				ERPAjaxRequest({
					url : "./simple_StockStoreReceive_remove.do",
					params : {
						"stockstorereceive.id" : selectId
					},
					// async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
					success : function(response, options) {
						mainGrid.reload({
							success : function() {
								detailGrid.removeAll();
							}
						});
					}
				});
			}
		});
	}

	function stock_store_reveive_check_windows(moduleId, moduleName, params) {

		var mainGridModule = params.grid;

		var mainGrid = mainGridModule.getGrid();

		var detailGrid = params.detailGrid;

		var selection_rows = mainGrid.getSelectionModel().getSelections();

		if (selection_rows == null) {
			showErrorMsg('提示信息', '请选择要审核的数据记录');
			return false;
		}

		if (selection_rows.length != 1) {
			showErrorMsg('提示信息', '只能选择一行数据记录！！');
			return false;
		}
		var selectId = selection_rows[0].id;
		showMsgYN({
			msg : "是否要审核该条信息",
			yes : function(YN) {
				ERPAjaxRequest({
					url : "./simple_StockStoreReceive_check.do",
					params : {
						"uuid" : selectId
					},
					// async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
					success : function(response, options) {
						mainGrid.reload({
							success : function() {
								detailGrid.removeAll();
							}
						});
					}
				});
			}
		});
	}

}