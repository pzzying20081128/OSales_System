function create_stock_invoice_reconcile_window(moduleId, moduleName) {

	// var checkButton = new Ext.Toolbar.Button({
	// // id : moduleId + '_search',
	// xtype : "tbbutton",
	// text : "审核",
	// key : "check",
	// // keyBinding : createSearchKey(),
	// handler : function() {
	// base_combined_product_check_windows(moduleId, moduleName, {
	// grid : mainGridModule
	// });
	// }
	//
	// });

	var mainGridModule = new mainGridWindow({
		moduleId : moduleId,
		// list grid
		url : "./list_StockInvoiceBillReconcile_list.do",
		// grid_column.record
		record : stock_invoice_reconcile_grid_column.record,
		// grid_column.column
		column : stock_invoice_reconcile_grid_column.column,
		tbar : {
			// plugins : new Ext.ux.ToolbarKeyMap(),
			items : [
//				{
//				// id : moduleId + '_add',
//				key : "autoReconciliation",
//				xtype : "tbbutton",
//				text : "自动对帐",
//				// keyBinding : createCreateKey(),
//				handler : function(bt) {
//					stock_invoice_reconcile_auto_windows(moduleId, "手工对帐", {
//						grid : mainGridModule
//					});
//				}
//			}, 
				{
				// id : moduleId + '_add',
				key : "manualReconciliation",
				xtype : "tbbutton",
				text : "对帐",
				// keyBinding : createCreateKey(),
				handler : function(bt) {
					stock_invoice_reconcile_handle_windows(moduleId, "对帐", {
						grid : mainGridModule,
						reStockInvoice:reStockInvoice
						
					});
				}
			},
//			{
//				// id : moduleId + '_edit',
//				xtype : "tbbutton",
//				text : "取消对帐",
//				key : "cancelReconciliation",
//				// keyBinding : createEditKey(),
//				handler : function(bt) {
//					stock_invoice_reconcile_cancel_windows(moduleId, moduleName, {
//						grid : mainGridModule
//					});
//				}
//			},
			{
				// id : moduleId + '_search',
				xtype : "tbbutton",
				text : "查询",
				key : "search",
				// keyBinding : createSearchKey(),
				handler : function() {
					var searchWindex = stock_invoice_reconcile_search_windows(moduleId, moduleName, {
						grid : mainGridModule,
						searchParams : stock_invoice_reconcile_search_params
					});
				}
			}]

		},
		init : {
			// 行被选择
			select : function(rowDataId, data, sm, rowIdx, r) {
				// stockSelect(data, null, null);

				detailGrid.load({
					params : {
						'searchBean.stockInvoiceId' : rowDataId
					}
				});

			},
			// 返回这一行的状态 1:OK -1 NO OK checkName:
			status : function(data) {

			}
		}
	});
	
	

	var mainGrid = mainGridModule.getGrid();

	var detailModule = new create_stock_invoice_reconcile_detail_window(moduleId + "_detail", "明细", {
		mainGrid : mainGrid
	});
	var detailGrid = detailModule.getDetailGridModule().getGrid();

	mainGridModule.setDetailGrid(detailGrid);
	
	function reStockInvoice(stockInvoice){
		mainGrid.updateRow(stockInvoice);
			detailGrid.load({
					params : {
						'searchBean.stockInvoiceId' : stockInvoice.id
					}
				});
	}

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
			"searchBean.reconciliation" : "查询非全部对帐"
		}
	});

//	function stock_invoice_reconcile_cancel_windows(moduleId, moduleName, params) {
//		var mainGridModule = params.grid;
//		var mainGrid = mainGridModule.getGrid();
//		var selection_rows = mainGrid.getSelectionModel().getSelections();
//		if (selection_rows == null) {
//			showErrorMsg('提示信息', '请选择要取消对帐的采购发票');
//			return false;
//		}
//
//		if (selection_rows.length != 1) {
//			showErrorMsg('提示信息', '只能选择一张采购发票,取消对帐');
//			return false;
//		}
//		var selectId = selection_rows[0].id;
//		showMsgYN({
//			msg : "是否要取消对帐",
//			yes : function(YN) {
//				ERPAjaxRequest({
//					url : "./simple_StockInvoiceBillReconcile_cancelReconcile.do",
//					params : {
//						"stockinvoice.id" : selectId
//					},
//					// async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
//					success : function(response, options) {
//						mainGrid.reload({
//						   success:function(){
//						   	detailGrid.removeAll();
//						   }
//						});
//					}
//				});
//			}
//		});
//
//	}

//	function stock_invoice_reconcile_auto_windows(moduleId, moduleName, params) {
//		var mainGridModule = params.grid;
//		var mainGrid = mainGridModule.getGrid();
//		var selection_rows = mainGrid.getSelectionModel().getSelections();
//
//		if (selection_rows == null) {
//			showErrorMsg('提示信息', '请选择要自动对帐的采购发票');
//			return false;
//		}
//
//		if (selection_rows.length != 1) {
//			showErrorMsg('提示信息', '只能选择一张采购发票');
//			return false;
//		}
//		var selectId = selection_rows[0].id;
//		showMsgYN({
//			msg : "是否要自动对帐",
//			yes : function(YN) {
//				ERPAjaxRequest({
//					url : "./simple_StockInvoiceBillReconcile_autoReconcile.do",
//					params : {
//						"stockinvoice.id" : selectId
//					},
//					// async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
//					success : function(response, options) {
//						mainGrid.reload({
//							success : function() {
//								detailGrid.removeAll();
//							}
//						});
//					}
//				});
//			}
//		});
//
//	}

	function stock_invoice_reconcile_delete_windows(moduleId, moduleName, params) {
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
					url : "./simple_ProductBrand_remove.do",
					params : {
						"productBrand.id" : selectId
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