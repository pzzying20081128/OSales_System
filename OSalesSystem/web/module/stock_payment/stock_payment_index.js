function create_stock_payment_window(moduleId, moduleName) {

	var checkButton = new Ext.Toolbar.Button({
		// id : moduleId + '_search',
		xtype : "tbbutton",
		text : "审核",
		key : "check",
		// keyBinding : createSearchKey(),
		handler : function() {

			stock_payment_check_windows(moduleId, moduleName, {
				grid : mainGridModule
			});
		}

	});

	var mainGridModule = new mainGridWindow({
		moduleId : moduleId,
		// list grid
		url : "./list_StockPayment_list.do",
		// grid_column.record
		record : stock_payment_grid_column.record,
		// grid_column.column
		column : stock_payment_grid_column.column,
		tbar : {
			// plugins : new Ext.ux.ToolbarKeyMap(),
			items : [{
				// id : moduleId + '_add',
				key : "add",
				xtype : "tbbutton",
				text : "增加",
				// keyBinding : createCreateKey(),
				handler : function(bt) {
					stock_payment_create_windows(moduleId, moduleName, {
						grid : mainGridModule

					});
				}
			}, {
				// id : moduleId + '_edit',
				xtype : "tbbutton",
				text : "编辑",
				key : "edit",
				// keyBinding : createEditKey(),
				handler : function(bt) {
					stock_payment_update_windows(moduleId, moduleName, {
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
					stock_payment_delete_windows(moduleId, moduleName, {
						grid : mainGridModule

					});
				}
			}, {
				// id : moduleId + '_search',
				xtype : "tbbutton",
				text : "查询",
				key : "search",
				// keyBinding : createSearchKey(),
				handler : function() {
					var searchWindex = stock_payment_search_windows(moduleId, moduleName, {
						grid : mainGridModule,
						searchParams : stock_payment_search_params
					});
				}
			}, {
				// id : moduleId + '_search',
				xtype : "tbbutton",
				text : "对帐",
				key : "reconcile",
				// keyBinding : createSearchKey(),
				handler : function() {
					stock_payment_reconcile_handle_windows(moduleId, "对帐", {
						grid : mainGridModule

					});
				}
			},

			checkButton]

		},
		init : {
			// 行被选择
			select : function(rowDataId, data, sm, rowIdx, r) {
				stockSelect(data, checkButton, null);
				// detailGrid.load({
				// params : {
				// // 'searchBean.combinedProductId' : rowDataId
				// }
				// });
			},
			// 返回这一行的状态 1:OK -1 NO OK checkName:
			status : function(data) {

			}
		}
	});

	var mainGrid = mainGridModule.getGrid();

	var window = new Ext.ERPWindow({
		title : moduleName,
		items : [mainGrid],// 里面所包含的组件
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

	function stock_payment_check_windows(moduleId, moduleName, params) {
		var mainGridModule = params.grid;
		var mainGrid = mainGridModule.getGrid();
		var selection_rows = mainGrid.getSelectionModel().getSelections();

		if (selection_rows == null) {
			showErrorMsg('提示信息', '请选择要审核的付款单');
			return false;
		}

		if (selection_rows.length != 1) {
			showErrorMsg('提示信息', '只能选择一行审核的付款单');
			return false;
		}

		if (selection_rows[0].data.reconciliation != "全部对帐") {
			showErrorMsg('提示信息', '付款单没有对帐完成,不能审核');
			return false;
		}

		var selectId = selection_rows[0].id;
		showMsgYN({
			msg : "是否要审核该付款单",
			yes : function(YN) {
				ERPAjaxRequest({
					url : "./simple_StockPayment_check.do",
					params : {
						"stockpayment.id" : selectId
					},
					// async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
					success : function(response, options) {
						mainGrid.reload();
					}
				});
			}
		});
	}

	function stock_payment_delete_windows(moduleId, moduleName, params) {
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
					url : "./simple_StockPayment_remove.do",
					params : {
						"stockpayment.id" : selectId
					},
					// async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
					success : function(response, options) {
						mainGrid.reload();
					}
				});
			}
		});
	}

}