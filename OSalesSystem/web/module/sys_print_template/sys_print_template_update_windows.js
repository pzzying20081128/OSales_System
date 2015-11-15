function sys_print_template_update_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();

	var selection_rows = grid.getSelectionModel().getSelections();

	if (selection_rows == null) {
		showErrorMsg('提示信息', '请选择要编辑的数据记录！！');
		return false;
	}

	if (selection_rows.length != 1) {
		showErrorMsg('提示信息', '编辑只能选择一行数据记录！！');
		return false;
	}

	var data = selection_rows[0].data;
	var selectId = selection_rows[0].id;

	var sys_print_template_params = {
		title : "编辑" + moduleName,
		action : "update",
		grid : grid,
		// 结果路径
		pojo : "result",
		// url
		url : './simple_SysPrintTemplate_save.do',
		params : {
			optType : "update",
			"sysgridconfigs.id" : selectId
		},
		reader : new Ext.data.JsonReader({
			successProperty : 'success',
			root : 'result',
			totalProperty : 'totalProperty'
		}, [{
			name : 'sysgridconfigs.colDataIndex',
			mapping : 'colDataIndex'
		}, {
			name : 'sysgridconfigs.colName',
			mapping : 'colName'
		}, {
			name : 'sysgridconfigs.printName',
			mapping : 'printName'
		}, {
			name : 'sysgridconfigs.colIndex',
			mapping : 'colIndex'
		}, {
			name : 'sysgridconfigs.printWidth',
			mapping : 'printWidth'
		}, {
			name : 'sysgridconfigs.isPrint',
			mapping : 'isPrint'
		}, {
			name : 'sysgridconfigs.istotal',
			mapping : 'istotal'
		}, {
			name : 'sysgridconfigs.isExcelExPorts',
			mapping : 'isExcelExPorts'
		}

		]),
		// 字段
		field : [{// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{// 1-1
				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [{
					id : 'sysgridconfigs.colName',
					name : 'sysgridconfigs.colName',
					fieldLabel : '列名',
					xtype : 'ERPShowText',
					blankText : '不能为空！',
					value : data.colName,
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, // 1-1 end writeObjectService.intToPrpertiesUnits(this.result) ;
			{// 1-2
				columnWidth : .33,
				layout : 'form',
				baseCls : 'x-plain',
				defaultType : 'textfield',
				defaults : {
					width : 200
				},
				items : [{
					id : 'sysgridconfigs.printName',
					name : 'sysgridconfigs.printName',
					fieldLabel : ' 打印名',
					xtype : 'textfield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					value : data.printName,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}// 1-2end
			, {// 1-3
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [{
					id : 'sysgridconfigs.colIndex',
					name : 'sysgridconfigs.colIndex',
					fieldLabel : ' 排序',
					xtype : 'textfield',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					value : data.colIndex,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}// 1-3 end
			]
		}, {
			// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{// 1-1
				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [createLocalCombo({
					id : 'sysgridconfigs.isPrint',
					name : 'sysgridconfigs.isPrint',
					fieldLabel : ' 是否打印',
					storeData : [[1, "是"], [0, "否"]],
					defaultValue : data.isPrint,
					allowBlank : false
				})]
			}, // 1-1 end
			{// 1-2
				columnWidth : .33,
				layout : 'form',
				baseCls : 'x-plain',
				defaultType : 'textfield',
				defaults : {
					width : 200
				},
				items : [createLocalCombo({
					id : 'sysgridconfigs.istotal',
					name : 'sysgridconfigs.istotal',
					fieldLabel : ' 是否求和',
					storeData : [[1, "是"], [0, "否"]],
					defaultValue : data.istotal,
					allowBlank : false
				})]
			}// 1-2end
			, {// 1-3
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [createLocalCombo({
					id : 'sysgridconfigs.isExcelExPorts',
					name : 'sysgridconfigs.isExcelExPorts',
					fieldLabel : ' 是否导出',
					storeData : [[1, "是"], [0, "否"]],
					defaultValue : data.isExcelExPorts,
					allowBlank : false
				})]
			}// 1-3 end
			]

		}]

	}

	var sys_print_template_create_window = new sys_print_template_save_update_form_panel_windows(sys_print_template_params);

	// sys_print_template_create_window.load({
	// url : './simple_SysPrintTemplate_get.do?uuid=' + selectId,
	// success : function(result) {
	// json = result.result;
	// }
	// });

}