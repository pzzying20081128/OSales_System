function create_stock_order_detail_window(moduleId, moduleName, params) {

	var orderGrid = params.orderGrid;

	addDetailButton = new Ext.Toolbar.Button({
		id : moduleId + '_add',
		xtype : "tbbutton",
		text : "增加",
		disabled : true,
		// keyBinding : createCreateKey(),
		handler : function(bt) {

			var selection_rows = orderGrid.getSelectionModel().getSelections();

			if (selection_rows == null) {
				showErrorMsg('提示信息', '请选择要添加明细的采购订单');
				return false;
			}

			if (selection_rows.length != 1) {
				showErrorMsg('提示信息', '只能选择一行数据记录');
				return false;
			}
			stock_order_detail_create_windows(moduleId, moduleName, {
				grid : mainGridModule.getGrid(),
				stockOrder : selection_rows[0].json,
				orderGrid : orderGrid

			});
		}
	});

	editDetailButton = new Ext.Toolbar.Button({
		id : moduleId + '_edit',
		xtype : "tbbutton",
		text : "编辑",
		disabled : true,
		// keyBinding : createEditKey(),
		handler : function(bt) {
			stock_order_detail_update_windows(moduleId, moduleName, {
				grid : mainGridModule,
				orderGrid : orderGrid
			});
		}
	});

	deleteDetailButton = new Ext.Toolbar.Button({
		id : moduleId + '_delete',
		xtype : "tbbutton",
		text : "删除",
		disabled : true,
		// keyBinding : createDeleteKey(),
		handler : function(bt) {
			stock_order_detail_delete_windows(moduleId, moduleName, {
				grid : mainGridModule
			});
		}
	});

	var mainGridModule = new mainGridWindow({
		moduleId : moduleId,
		// list grid
		url : "./list_StockOrderDetail_list.do",
		// grid_column.record
		record : stock_order_detail_grid_column.record,
		// grid_column.column
		column : stock_order_detail_grid_column.column,
		tbar : {
			// plugins : new Ext.ux.ToolbarKeyMap(),
			items : [addDetailButton, editDetailButton, deleteDetailButton,
			// {
			// id : moduleId + '_search',
			// xtype : "tbbutton",
			// text : "查询",
			// // keyBinding : createSearchKey(),
			// handler : function() {
			// var searchWindex = stock_order_detail_search_windows(moduleId,
			// moduleName, {
			// grid : mainGridModule,
			// searchParams : stock_order_detail_search_params
			// });
			// }
			// }
			]

		},
		init : {
			// 行被选择
			select : function(rowDataId, data, sm, rowIdx, r) {
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

	function stock_order_detail_delete_windows(moduleId, moduleName, params) {
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
					url : "./simple_StockOrderDetail_remove.do",
					params : {
						"stockorderdetail.id" : selectId
					},
					// async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
					success : function(result) {

						mainGrid.reload();

						json = result.result.result;

						orderGrid.updateRow(json.stockOrder);

					}
				});
			}
		});
	}

}