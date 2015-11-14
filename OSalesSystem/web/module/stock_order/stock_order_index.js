function create_stock_order_window(moduleId, moduleName) {

	var addButton = new Ext.Toolbar.Button({
		// id : moduleId + '_add',
		key : 'add',
		xtype : "tbbutton",
		text : "增加",

		disabled : true,
		// keyBinding : createCreateKey(),
		handler : function(bt) {
			ERPAjaxRequest({
				url : "./simple_StockOrder_initStockOrder.do",
				// async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
				success : function(result) {
					// init order 都到订单编号
					order = result.result.result;
					logger("创建采购订单");
					var stock_order_create_win = new stock_order_create_windows(moduleId, moduleName, {
						grid : mainGridModule,
						order : order
					});
					stock_order_create_win.openWin({
						detailParams : {
							stockdetail : stockdetail
						}
					});
				}

			});
		}
	});

	var editButton = new Ext.Toolbar.Button({
		// id : moduleId + '_edit',
		xtype : "tbbutton",
		text : "编辑",
		key : 'edit',
		disabled : true,
		// keyBinding : createEditKey(),
		handler : function(bt) {
			var stock_order_update_win = new stock_order_update_windows(moduleId, moduleName, {
				grid : mainGridModule
			});

			stock_order_update_win.openWin({
				detailParams : {
					stockdetail : stockdetail
				}
			});
		}
	});

	var checkButton = new Ext.Toolbar.Button({
		// id : moduleId + '_check',
		xtype : "tbbutton",
		text : "审核",
		key : 'check',
		disabled : true,
		// keyBinding : createSearchKey(),
		handler : function() {
			var searchWindex = stock_order_check_windows(moduleId, moduleName, {
				grid : mainGridModule
			});
		}
	});

	deleteButton = new Ext.Toolbar.Button({
		// id : moduleId + '_delete',
		xtype : "tbbutton",
		text : "删除",
		key : 'delete',

		disabled : true,
		// keyBinding : createDeleteKey(),
		handler : function(bt) {
			stock_order_delete_windows(moduleId, moduleName, {
				grid : mainGridModule
			});
		}
	});

	var mainGridModule = new mainGridWindow({
		isPrint : true,
		moduleId : moduleId,
		// list grid
		url : "./list_StockOrder_list.do",
		// grid_column.record
		record : stock_order_grid_column.record,
		// grid_column.column
		column : stock_order_grid_column.column,
		tbar : {
			// plugins : new Ext.ux.ToolbarKeyMap(),
			items : [addButton, editButton, deleteButton, {
				// id : moduleId + '_search',
				xtype : "tbbutton",
				key : "search",
				text : "查询",

				// keyBinding : createSearchKey(),
				disabled : true,
				handler : function() {
					stockdetailGrid.openAllButton(false);
					var searchWindex = stock_order_search_windows(moduleId, moduleName, {
						grid : mainGridModule,
						searchParams : stock_order_search_params
					});
				}
			}, checkButton]
		},
		init : {
			// 行被选择
			select : function(rowDataId, data) {
				stockSelect(data, checkButton, stockdetailGrid);
				stockdetailGrid.load({
					params : {
						'searchBean.stockOrderId' : rowDataId
					}
				});
			},
			// 返回这一行的状态 1:OK -1 NO OK checkName:
			status : function(data) {

			}
		}
	});

	var mainGrid = mainGridModule.getGrid();

	var stockdetail = new create_stock_order_detail_window(moduleId + "_store_order_detail", moduleName, {
		mainOrderGrid : mainGrid
	});

	stockdetailGrid = stockdetail.getGrid();

	var layout = new Ext.Panel({
		layout : 'border',
		width : 600,
		height : 600,
		minHeight : 100,
		maxHeight : 500,
		items : [new Ext.Panel({
			layout : 'fit',
			region : 'north',
			margins : '0 0 0 0',
			split : true,
			height : 300,
			items : mainGrid
		})

		, new Ext.Panel({
			layout : 'fit',
			region : 'center',
			margins : '0 0 0 0',
			title : '明细',
			items : stockdetailGrid
		})

		]
	});

	var window = new Ext.ERPWindow({
		title : moduleName,
		items : [layout],// 里面所包含的组件
		// 用于权限
		grids : [mainGrid],
		moduleId : moduleId,
		listeners : {}
	});
	window.showWin();

	mainGrid.load({
		params : {
			"searchBean.status" : "有效"
		}
	});

	function stock_order_check_windows(moduleId, moduleName, params) {
		var mainGridModule = params.grid;
		var mainGrid = mainGridModule.getGrid();
		var selection_rows = mainGrid.getSelectionModel().getSelections();
		if (!stockOpptCheck(selection_rows, "审核", null))
			return;
		// if ( selection_rows[0].data.status =="删除") {
		// showErrorMsg('提示信息',
		// '本条信息的状态是['+selection_rows[0].data.status+']不能'+opt );
		// return false;
		// }
		var selectId = selection_rows[0].id;
		showMsgYN({
			msg : "是否要审核该条订单",
			yes : function(YN) {
				ERPAjaxRequest({
					url : "./simple_StockOrder_check.do",
					params : {
						"stockorder.id" : selectId
					},
					success : function(response, options) {
						mainGrid.reload({
							success : function() {
								stockdetailGrid.removeAll();
								stockdetailGrid.openAllButton(false);
							}

						});
					}
				});
			}
		});
	}

	function stock_order_delete_windows(moduleId, moduleName, params) {
		var mainGridModule = params.grid;
		var mainGrid = mainGridModule.getGrid();
		var selection_rows = mainGrid.getSelectionModel().getSelections();

		if (!stockOpptCheck(selection_rows, "删除", "有效"))
			return;
		// if (selection_rows == null) {
		// showErrorMsg('提示信息', '请选择要删除的数据记录！！');
		// return false;
		// }
		//
		// if (selection_rows.length != 1) {
		// showErrorMsg('提示信息', '只能选择一行数据记录！！');
		// return false;
		// }
		//
		// if (selection_rows[0].data.status != '有效') {
		// showErrorMsg('提示信息', '本条信息的状态是[' + selection_rows[0].data.status +
		// ']不能删除');
		// return false;
		// }

		var selectId = selection_rows[0].id;
		showMsgYN({
			msg : "是否要删除该条信息",
			yes : function(YN) {
				ERPAjaxRequest({
					url : "./simple_StockOrder_remove.do",
					params : {
						"stockorder.id" : selectId
					},
					// async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
					success : function(response, options) {
						mainGrid.reload({
							success : function() {
								stockdetailGrid.removeAll();
								stockdetailGrid.openAllButton(false);
							}
						});
					}
				});
			}
		});
	}

}