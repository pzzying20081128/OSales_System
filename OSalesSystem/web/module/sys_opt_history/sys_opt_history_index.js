function create_sys_opt_history_window(moduleId, moduleName) {
 
	var mainGridModule = new mainGridWindow({
		moduleId : moduleId,
		// list grid
		url : "./listSysOptHistory.do",
		// grid_column.record
		record : sys_opt_history_grid_column.record,
		// grid_column.column
		column : sys_opt_history_grid_column.column,
		tbar : {
			//plugins : new Ext.ux.ToolbarKeyMap(),
			items : [{
				id : moduleId + '_search',
				xtype : "tbbutton",
				text : "查询",
				//keyBinding : createSearchKey(),
				handler : function() {
					var searchWindex = sys_opt_history_search_windows(moduleId, moduleName, {
					grid : mainGridModule,
					searchParams: sys_opt_history_search_params
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
	mainGrid.load();
	window.showWin();
	
	
		function   sys_opt_history_delete_windows(moduleId, moduleName, params) {
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