function create_sys_print_template_window(moduleId, moduleName) {

	var checkButton = new Ext.Toolbar.Button({
		// id : moduleId + '_search',
		xtype : "tbbutton",
		text : " 确定 ",
		key : "check",
		// keyBinding : createSearchKey(),
		handler : function() {
			var moduleKey = 模块.getValue();
			mainGrid.load({
				sortInfo : {
					sort : "colIndex",
					dir : "asc"
				},
				params : {
					moduleKey : moduleKey
					,
				}
			});
		}

	});

	var 模块 = createERPcombo({
		width : 350,
		// id : 'stockorder.providerInfoId',
		// name : 'stockorder.providerInfoId',
		url : "./ModuleName_combo.do",
		allowBlank : true,
		forceSelection : false
	});

	var mainGridModule = new mainGridWindow({
		moduleId : moduleId,
		// list grid
		url : "./list_SysPrintTemplate_list.do",
		// grid_column.record
		record : sys_print_template_grid_column.record,
		// grid_column.column
		column : sys_print_template_grid_column.column,
		tbar : {
			// plugins : new Ext.ux.ToolbarKeyMap(),
			items : [{
				// id : moduleId + '_edit',
				xtype : "tbbutton",
				text : "编辑",
				key : "edit",
				// keyBinding : createEditKey(),
				handler : function(bt) {
					sys_print_template_update_windows(moduleId, moduleName, {
						grid : mainGridModule
					});
				}
			}, {
				// id : moduleId + '_search',
				xtype : "tbbutton",
				text : "打印模板设置",
				key : "search",
				// keyBinding : createSearchKey(),
				handler : function() {
					var searchWindex = sys_print_template_search_windows(moduleId, moduleName, {
						grid : mainGridModule,
						searchParams : sys_print_template_search_params
					});
				}
			}, "->", {
				text : '模块名:'
			}, 模块, checkButton]

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
		grids : [mainGrid],
		moduleId : moduleId,
		listeners : {}
	});
	window.showWin();

	function sys_print_template_delete_windows(moduleId, moduleName, params) {
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