function create_stock_payment_reconcile_window(moduleId, moduleName) {

	var checkButton = new Ext.Toolbar.Button({
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
		url : "./list_StockPaymentReconcile_list.do",
		// grid_column.record
		record : stock_payment_reconcile_grid_column.record,
		// grid_column.column
		column : stock_payment_reconcile_grid_column.column,
		tbar : {
			// plugins : new Ext.ux.ToolbarKeyMap(),
			items : [{
				// id : moduleId + '_add',
				key : "reconciliation",
				xtype : "tbbutton",
				text : "对帐",
				// keyBinding : createCreateKey(),
				handler : function(bt) {
					stock_payment_reconcile_handle_windows(moduleId, "对帐", {
						grid : mainGridModule,
//						 reStockInvoice : reStockInvoice

					});
				}
			},]

		},
		init : {
			// 行被选择
			select : function(rowDataId, data, sm, rowIdx, r) {
				stockSelect(data, checkButton, detailGrid);
				detailGrid.load({
					params : {
						'searchBean.stockPaymentId' : rowDataId
					}
				});

			},
			// 返回这一行的状态 1:OK -1 NO OK checkName:
			status : function(data) {

			}
		}
	});

	var mainGrid = mainGridModule.getGrid();

	var detailModule = new create_stock_payment_reconcile_detail_window(moduleId + "_detail", "明细", {
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
			"searchBean.reconciliation" : "查询非全部对帐"
		}
	});

	function stock_payment_reconcile_delete_windows(moduleId, moduleName, params) {
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
						mainGrid.reload();
					}
				});
			}
		});
	}

}