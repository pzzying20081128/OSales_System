function create_stock_in_store_detail_window(moduleId, moduleName, params) {

	main_Grid = params.mainGrid;

	function selectMainGrid(msg) {
		var selection_rows = main_Grid.getSelectionModel().getSelections();

		if (selection_rows == null) {
			showErrorMsg('提示信息', msg);
			return null;
		}

		if (selection_rows.length != 1) {
			showErrorMsg('提示信息', '只能选择一行数据记录');
			return null;
		}
		// var selectId = selection_rows[0].id;
		return selection_rows[0];
	}

	var mainGridModule = new mainGridWindow({
		moduleId : moduleId,
		// list grid
		url : "./list_StockInStoreDetail_list.do",
		// grid_column.record
		record : stock_in_store_detail_grid_column.record,
		// grid_column.column
		column : stock_in_store_detail_grid_column.column,
		tbar : {
			// plugins : new Ext.ux.ToolbarKeyMap(),
			items : [
			// {
			// id : moduleId + '_add',
			// xtype : "tbbutton",
			// text : "增加",
			// // keyBinding : createCreateKey(),
			// handler : function(bt) {
			// stock_in_store_detail_create_windows(moduleId, moduleName, {
			// grid : mainGridModule
			//
			// });
			// }
			// },

			{
				id : moduleId + '_edit',
				xtype : "tbbutton",
				text : "编辑",
				// keyBinding : createEditKey(),
				handler : function(bt) {
					select_rows = selectMainGrid("选择一条要编辑的详情");
					if (select_rows == null)
						return;
					stock_in_store_detail_update_windows(moduleId, moduleName, {
						grid : mainGridModule,
						mainData : select_rows,
						mainGrid : main_Grid
					});
				}
			}, {
				id : moduleId + '_delete',
				xtype : "tbbutton",
				text : "删除",
				// keyBinding : createDeleteKey(),
				handler : function(bt) {
					stock_in_store_detail_delete_windows(moduleId, moduleName, {
						grid : mainGridModule

					});
				}
			}, {
				id : moduleId + '_search',
				xtype : "tbbutton",
				text : "查询",
				// keyBinding : createSearchKey(),
				handler : function() {
					var searchWindex = stock_in_store_detail_search_windows(moduleId, moduleName, {
						grid : mainGridModule,
						searchParams : stock_in_store_detail_search_params
					});
				}
			}]

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

	return mainGrid;

	// var window = new Ext.ERPWindow({
	// title : moduleName,
	// items : [mainGrid],// 里面所包含的组件
	// // 用于权限
	// // grids:[mainGrid],
	// moduleId : moduleId,
	// listeners : {}
	// });
	// window.showWin();

	function stock_in_store_detail_delete_windows(moduleId, moduleName, params) {
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
					url : "./simple_StockInStoreDetail_remove.do",
					params : {
						"stockInstoredetail.id" : selectId
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