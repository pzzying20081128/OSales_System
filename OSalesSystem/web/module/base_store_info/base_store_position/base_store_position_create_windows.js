function base_store_position_create_windows(moduleId, moduleName, params) {

	var grid = params.grid;

	var storeGrid = params.storeGrid;

	var base_store_position_params = {
		storeGrid : storeGrid,
		title : "新增" + moduleName,
		action : "save",
		grid : grid,
		// 结果路径
		pojo : "result",
		// url
		url : './simple_StorePosition_save.do',
		params : {
			optType : "save",
			"storeposition.storeInfoId" : params.storeId
		},
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
					width : 430
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

		}

		]

	}

	var base_store_position_create_window = new base_store_position_save_update_form_panel_windows(base_store_position_params

	);

}