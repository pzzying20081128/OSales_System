function create_stock_return_detail_window(moduleId, moduleName, params) {

	var main_Grid = params.mainGrid;

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

	function openCreateWin_() {

		var selection_rows = main_Grid.getSelectionModel().getSelections();
		if (selection_rows == null) {
			showErrorMsg('提示信息', '请选择要添加明细的采购订单');
			return;
		}

		if (selection_rows.length != 1) {
			showErrorMsg('提示信息', '只能选择一行数据记录');
			return;
		}
		var returnOrder = selection_rows[0].data;
		returnOrder.id = selection_rows[0].id;
		// stock_order_detail_create_windows(this.moduleId, this.moduleName +
		// "明细", {
		// grid : mainGridModule.getGrid(),
		// orderGrid : orderGrid,
		// stockOrder : stockOrder
		// });
		stock_return_detail_create_windows(moduleId, moduleName, {
			mainGrid : main_Grid,
			detailGrid : mainGrid,
			returnOrder : returnOrder
		});
	};

	var mainGridModule = new mainGridWindow({
		moduleId : moduleId,
		// list grid
		url : "./list_StockReturnDetail_list.do",
		// grid_column.record
		record : stock_return_detail_grid_column.record,
		// grid_column.column
		column : stock_return_detail_grid_column.column,
		tbar : {
			// plugins : new Ext.ux.ToolbarKeyMap(),
			items : [{
				// id : moduleId + '_add',
				key : "add",
				xtype : "tbbutton",
				text : "增加",
				// keyBinding : createCreateKey(),
				disabled : true,
				handler : function(bt) {
					openCreateWin_();
				}
			}, {
				// id : moduleId + '_edit',
				xtype : "tbbutton",
				text : "编辑",
				key : "edit",
				// keyBinding : createEditKey(),
				disabled : true,
				handler : function(bt) {

					var selection_rows = main_Grid.getSelectionModel().getSelections();
					if (selection_rows == null) {
						showErrorMsg('提示信息', '请选择要编辑的退货单');
						return;
					}

					if (selection_rows.length != 1) {
						showErrorMsg('提示信息', '只能选择一行数据记录');
						return;
					}
					var returnOrder = selection_rows[0].data;
					returnOrder.id = selection_rows[0].id;

					stock_return_detail_update_windows(moduleId, moduleName, {
						grid : mainGridModule,
						main_Grid : main_Grid,
						returnOrder : returnOrder

					});
				}
			}, {
				// id : moduleId + '_delete',
				xtype : "tbbutton",
				text : "删除",
				key : "delete",
				disabled : true,
				// keyBinding : createDeleteKey(),
				handler : function(bt) {
					stock_return_detail_delete_windows(moduleId, moduleName, {
						grid : mainGridModule,
						main_Grid : main_Grid
						,
					});
				}
			}, {
				// id : moduleId + '_search',
				xtype : "tbbutton",
				text : "查询",
				key : "search",
				disabled : true,
				// keyBinding : createSearchKey(),
				handler : function() {
					var searchWindex = stock_return_detail_search_windows(moduleId, moduleName, {
						grid : mainGridModule,
						searchParams : stock_return_detail_search_params
					});
				}
			}]

		},
		init : {
			// 行被选择
			select : function(rowDataId, data, sm, rowIdx, r) {
				// stockSelect(data, checkButton, detailGrid);
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

	this.getGrid = function() {
		return mainGrid;
	}

	function stock_return_detail_delete_windows(moduleId, moduleName, params) {
		var main_Grid = params.main_Grid;
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
					url : "./simple_StockReturnDetail_remove.do",
					params : {
						"stockreturndetail.id" : selectId
					},
					// async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
					success : function(result) {
						var result = result.result;
						main_Grid.updateRow(result.result.stockReturn);
						mainGrid.reload();
					}
				});
			}
		});
	}

}