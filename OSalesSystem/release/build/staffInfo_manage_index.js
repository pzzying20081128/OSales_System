function create_staffInfo_manage_window(moduleId, moduleName) {
 
	var mainGridModule = new mainGridWindow({
		moduleId : moduleId,
		// list grid
		url : "ssssssssss",
		// grid_column.record
		record : staffInfo_manage_grid_column.record,
		// grid_column.column
		column : staffInfo_manage_grid_column.column,
		tbar : {
			plugins : new Ext.ux.ToolbarKeyMap(),
			items : [{
				id : moduleId + '_add',
				xtype : "tbbutton",
				text : "增加",
				//keyBinding : createCreateKey(),
				handler : function(bt) {
					staffInfo_manage_create_windows(moduleId, moduleName, {
					grid : mainGridModule,
				
				 });
				}
			}, {
				id : moduleId + '_edit',
				xtype : "tbbutton",
				text : "编辑",
				//keyBinding : createEditKey(),
				handler : function(bt) {
					 staffInfo_manage_update_windows(moduleId, moduleName, {
					 grid : mainGridModule,
					 searchParams:test_search_params
					 });
				}
			}, {
				id : moduleId + '_delete',
				xtype : "tbbutton",
				text : "删除",
				//keyBinding : createDeleteKey(),
				handler : function(bt) {
					  staffInfo_manage_delete_windows(moduleId, moduleName, {
					 grid : mainGridModule,
					 });
				}
			}, {
				id : moduleId + '_search',
				xtype : "tbbutton",
				text : "查询",
				//keyBinding : createSearchKey(),
				handler : function() {
					var searchWindex = staffInfo_manage_search_windows(moduleId, moduleName, {
					grid : mainGridModule,
					searchParams: staffInfo_manage_search_params
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

	var window = new Ext.ERPWindow({
		title : moduleName,
		items : [mainGrid],// 里面所包含的组件
		// 用于权限
		// grids:[mainGrid],
		moduleId : moduleId,
		listeners : {}
	});
	window.showWin();
	
	
		function   staffInfo_manage_delete_windows(moduleId, moduleName, params) {
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
	ERPAjaxRequest({
		url : "./removeUserInfo.jhtml",
		params : {
			uuid : selectId
		},
		// async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
		success : function(response, options) {
			mainGrid.reload();
		}
	});
}

}