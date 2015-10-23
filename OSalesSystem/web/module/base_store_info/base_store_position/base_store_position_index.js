function create_base_store_position_window(moduleId, moduleName, params) {

	var storeGrid = params.storeGrid;

	function returnSelectGridId(storeGrid) {
		var selection_rows = storeGrid.getSelectionModel().getSelections();

		if (selection_rows == null) {
			showErrorMsg('提示信息', '请选择要增加库位的仓库');
			return false;
		}

		if (selection_rows.length != 1) {
			showErrorMsg('提示信息', '只能选择一行数据记录');
			return false;
		}
		return selection_rows[0].id;
	}

	var mainGridModule = new mainGridWindow({
		moduleId : moduleId,
		// list grid
		url : "./list_StorePosition_list.do",
		// grid_column.record
		record : base_store_position_grid_column.record,
		// grid_column.column
		column : base_store_position_grid_column.column,
		tbar : {
			// plugins : new Ext.ux.ToolbarKeyMap(),
			items : [{
				id : moduleId + '_add',
				xtype : "tbbutton",
				text : "增加",
				// keyBinding : createCreateKey(),
				handler : function(bt) {
					// grid : positonParams.positonGrid,
					// storeId:json[params.pojo].id
					var selectionId = returnSelectGridId(storeGrid);
					if (selectionId == false)
						return;

					base_store_position_create_windows(moduleId, moduleName, {

						grid : mainGridModule.getGrid(),

						storeGrid : storeGrid,

						storeId : selectionId

					});
				}
			}, {
				id : moduleId + '_edit',
				xtype : "tbbutton",
				text : "编辑",
				// keyBinding : createEditKey(),
				handler : function(bt) {
					var selectionId = returnSelectGridId(storeGrid);
					if (selectionId == false)
						return;

					base_store_position_update_windows(moduleId, moduleName, {
						grid : mainGridModule,
						storeGrid : storeGrid,
						storeId : selectionId

					});
				}
			}, {
				id : moduleId + '_delete',
				xtype : "tbbutton",
				text : "删除",
				// keyBinding : createDeleteKey(),
				handler : function(bt) {
					base_store_position_delete_windows(moduleId, moduleName, {
						grid : mainGridModule

					});
				}
			}
//			, 
//				{
//				id : moduleId + '_search',
//				xtype : "tbbutton",
//				text : "查询",
//				// keyBinding : createSearchKey(),
//				handler : function() {
//					var selectionId = returnSelectGridId(storeGrid);
//					if (selectionId == false)
//						return;
//					var searchWindex = base_store_position_search_windows(moduleId, moduleName, {
//						grid : mainGridModule,
//						storeGrid : storeGrid,
//						storeId : selectionId
//					});
//				}
//			}
			
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

	function base_store_position_delete_windows(moduleId, moduleName, params) {
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
					url : "./simple_StorePosition_remove.do",
					params : {
						"storeposition.id" : selectId
					},
					// async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
					success : function(response, options) {
						mainGrid.reload();
					}
				});
			}
		});
	}
	return mainGrid;
}