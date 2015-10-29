function create_stock_order_window(moduleId, moduleName) {

	var addButton = new Ext.Toolbar.Button({
		id : moduleId + '_add',
		key : 'add',
		xtype : "tbbutton",
		text : "增加",
		// keyBinding : createCreateKey(),
		handler : function(bt) {
			ERPAjaxRequest({
				url : "./simple_StockOrder_initStockOrder.do",
				// async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
				success : function(result) {
					order = result.result.result;
					stock_order_create_windows(moduleId, moduleName, {
						grid : mainGridModule,
						order : order,
						detailParams : detailParams
					});
				}
			});
		}
	});

	var editButton = new Ext.Toolbar.Button({
		id : moduleId + '_edit',
		xtype : "tbbutton",
		text : "编辑",
		key : 'edit',
		disabled : true,
		// keyBinding : createEditKey(),
		handler : function(bt) {
			stock_order_update_windows(moduleId, moduleName, {
				grid : mainGridModule

			});
		}
	});

	var checkButton = new Ext.Toolbar.Button({
		id : moduleId + '_check',
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
		id : moduleId + '_delete',
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
				id : moduleId + '_search',
				xtype : "tbbutton",
				key : "search",
				text : "查询",
				// keyBinding : createSearchKey(),
				handler : function() {
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
				status = data.status;
				if (status == '已审核') {
					mainGrid.openButton(false);
					checkButton.setText("取消审核");
					checkButton.enable();
					stockdetailGrid.openAllButton(false);
				} else {
					checkButton.setText("审核");
					mainGrid.openButton(true);
					// ///////////////////////////////
                    if(  mainGrid.getisAdmin() ==1 ||  mainGrid.searchPower("add").isUse ==1 ||  mainGrid.searchPower("edit").isUse ==1  || mainGrid.searchPower("delete").isUse ==1   ){
                    	stockdetailGrid.openAllButton(true);
                    }else{
                    	stockdetailGrid.openAllButton(false);
                    }
				}
                ////////////////////////////////////////////
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

		orderGrid : mainGrid

	});

	stockdetailGrid = stockdetail.getGrid();

	var detailParams = {
		detailGrid : stockdetailGrid,
		orderGrid : mainGrid,
		moduleId : moduleId + "_stock_detail",
		moduleName : moduleName + "明细"
	}

	// var positonParams={
	// positonGrid:store_position_grid,
	// moduleId:moduleId + "_store_position",
	// moduleName:moduleName
	// }

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
			title : '库位',
			items : stockdetailGrid

			// items : sales_order_store_out_panel_print
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

		if (selection_rows == null) {
			showErrorMsg('提示信息', '请选择要审核的订单');
			return false;
		}

		if (selection_rows.length != 1) {
			showErrorMsg('提示信息', '只能选择一条数据记录');
			return false;
		}
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

								stock_detail_grid.removeAll();
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
					url : "./simple_StockOrder_remove.do",
					params : {
						"stockorder.id" : selectId
					},
					// async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
					success : function(response, options) {
						mainGrid.reload({
							success : function() {
								stock_detail_grid.removeAll();
							}
						});
					}
				});
			}
		});
	}

}