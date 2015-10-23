function base_store_position_update_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();

	var storeGrid = params.storeGrid;

	var selection_rows = grid.getSelectionModel().getSelections();

	if (selection_rows == null) {
		showErrorMsg('提示信息', '请选择要编辑的数据记录！！');
		return false;
	}

	if (selection_rows.length != 1) {
		showErrorMsg('提示信息', '编辑只能选择一行数据记录！！');
		return false;
	}
	var selectId = selection_rows[0].id;

	var base_store_position_params = {
		title : "编辑" + moduleName,
		action : "update",
		grid : grid,
		// 结果路径
		pojo : "result",
		// url
		url : './simple_StorePosition_save.do',
		params : {
			optType : "update",
			"storeposition.id":selectId
		},
		reader : new Ext.data.JsonReader({
			successProperty : 'success',
			root : 'result',
			totalProperty : 'totalProperty'
		}, [{
			name : 'storeposition.name',
			mapping : 'name'
		}, {
			name : 'storeposition.status',
			mapping : 'status'
		}, {
			name : 'storeposition.text',
			mapping : 'text'
		}]),
		// 字段
		field : [{// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'storeposition.name',
					name : 'storeposition.name',
					fieldLabel : ' 库位',
					xtype : 'textfield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, {
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [

				createLocalCombo({
					id : 'storeposition.status',
					name : 'storeposition.status',
					fieldLabel : ' 状态',
					storeData : [['有效', "有效"], ['无效', '无效']],
					defaultValue : "有效",
					allowBlank : false
				})]
			}]
		}, {
			// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 435
				},
				items : [{
					id : 'storeposition.text',
					name : 'storeposition.text',
					fieldLabel : ' 备注',
					xtype : 'textfield',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}]

		}]

	}

	var base_store_position_create_window = new base_store_position_save_update_form_panel_windows(base_store_position_params);

	base_store_position_create_window.load({
		url : './simple_StorePosition_get.do?uuid=' + selectId,
		success : function(result) {
			json = result.result;
		}
	});

}