function create_base_combined_product_window(moduleId, moduleName) {

	checkButton = new Ext.Toolbar.Button({
		// id : moduleId + '_search',
		xtype : "tbbutton",
		text : "审核",
		key : "check",
		// keyBinding : createSearchKey(),
		handler : function() {
			base_combined_product_check_windows(moduleId, moduleName, {
				grid : mainGridModule
			});
		}

	});

	var mainGridModule = new mainGridWindow({
		moduleId : moduleId,
		// list grid
		url : "./list_CombinedProduct_list.do",
		// grid_column.record
		record : base_combined_product_grid_column.record,
		// grid_column.column
		column : base_combined_product_grid_column.column,
		tbar : {
			// plugins : new Ext.ux.ToolbarKeyMap(),
			items : [{
				// id : moduleId + '_add',
				xtype : "tbbutton",
				text : "增加",
				key : "add",
				// keyBinding : createCreateKey(),
				handler : function(bt) {
					base_combined_product_create_windows(moduleId, moduleName, {
						grid : mainGridModule
						,

					});
				}
			}, {
				// id : moduleId + '_edit',
				xtype : "tbbutton",
				text : "编辑",
				key : "edit",
				// keyBinding : createEditKey(),
				handler : function(bt) {
					base_combined_product_update_windows(moduleId, moduleName, {
						grid : mainGridModule
					});
				}
			}, {
				// id : moduleId + '_delete',
				xtype : "tbbutton",
				text : "删除",
				key : "delete",
				// keyBinding : createDeleteKey(),
				handler : function(bt) {
					base_combined_product_delete_windows(moduleId, moduleName, {
						grid : mainGridModule
						,
					});
				}
			}, {
				// id : moduleId + '_search',
				xtype : "tbbutton",
				text : "查询",
				key : "search",
				// keyBinding : createSearchKey(),
				handler : function() {
					var searchWindex = base_combined_product_search_windows(moduleId, moduleName, {
						grid : mainGridModule,
						searchParams : base_combined_product_search_params
					});
				}
			}, checkButton

			]

		},
		init : {
			// 行被选择
			select : function(rowDataId, data, sm, rowIdx, r) {
				stockSelect(data, checkButton, detailGrid);
				// //////////////////////////////////////////
				detailGrid.load({
					params : {
						'searchBean.combinedProductId' : rowDataId
					}
				});
			},
			// 返回这一行的状态 1:OK -1 NO OK checkName:
			status : function(data) {

			}
		}
	});

	var mainGrid = mainGridModule.getGrid();

	var detailModule = new create_base_combined_product_detail_window(moduleId + "_detail", "明细", {
		mainGrid : mainGrid
	});
	var detailGrid = detailModule.getGrid();

	mainGridModule.setDetailGrid(detailGrid);

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
			"searchBean.status" : '有效'
		}
	});

	function base_combined_product_delete_windows(moduleId, moduleName, params) {
		var mainGridModule = params.grid;
		var mainGrid = mainGridModule.getGrid();
		var selection_rows = mainGrid.getSelectionModel().getSelections();

		if (selection_rows == null) {
			showErrorMsg('提示信息', '请选择要删除的数据记录');
			return false;
		}

		if (selection_rows.length != 1) {
			showErrorMsg('提示信息', '只能选择一行数据记录');
			return false;
		}
		var selectId = selection_rows[0].id;
		showMsgYN({
			msg : "是否要删除该条信息",
			yes : function(YN) {
				ERPAjaxRequest({
					url : "./simple_CombinedProduct_remove.do",
					params : {
						"combinedproduct.id" : selectId,
						"optType" : "delete"
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

	function base_combined_product_check_windows(moduleId, moduleName, params) {
		var mainGridModule = params.grid;
		var mainGrid = mainGridModule.getGrid();
		var selection_rows = mainGrid.getSelectionModel().getSelections();

		if (selection_rows == null) {
			showErrorMsg('提示信息', '请选择要审核的数据记录');
			return false;
		}

		if (selection_rows.length != 1) {
			showErrorMsg('提示信息', '只能选择一行数据记录');
			return false;
		}
		var selectId = selection_rows[0].id;
		showMsgYN({
			msg : "是否要审核该条信息",
			yes : function(YN) {
				ERPAjaxRequest({
					url : "./simple_CombinedProduct_check.do",
					params : {
						uuid : selectId
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