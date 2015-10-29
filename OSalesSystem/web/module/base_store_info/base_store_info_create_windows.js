function base_store_info_create_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();

	var positonParams = params.positonParams;

	var base_store_info_params = {
		title : "新增" + moduleName,
		action : "save",
		grid : grid,
		// 结果路径
		pojo : "result",
		// url
		url : './simple_StoreInfo_save.do',
		params : {
			optType : "save"
		},
		// 字段
		field : [{// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [{
					id : 'storeinfo.name',
					name : 'storeinfo.name',
					fieldLabel : ' 仓库名称',
					xtype : 'textfield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			},
			// ----------------------------------------------------------------------//
			{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [createLocalCombo({
					id : 'storeinfo.storeType',
					name : 'storeinfo.storeType',
					fieldLabel : ' 仓库类型', // 一般仓库;专柜;样品
					storeData : [['一般仓库', "一般仓库"]],
					defaultValue : "一般仓库",
					allowBlank : true
				})

				]
			}, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [createLocalCombo({
					id : 'storeinfo.status',
					name : 'storeinfo.status',
					fieldLabel : ' 状态',
					storeData : [['有效', "有效"], ['无效', '无效']],
					defaultValue : "有效",
					allowBlank : true
				})

				]
			}]
		}, {// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .66,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 488
				},
				items : [{
					id : 'storeinfo.address',
					name : 'storeinfo.address',
					fieldLabel : ' 仓库地址',
					xtype : 'textfield',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [{
					id : 'storeinfo.phone',
					name : 'storeinfo.phone',
					fieldLabel : ' 联系电话',
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

		},

		{// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 776
				},
				items : [{
					id : 'storeinfo.text',
					name : 'storeinfo.text',
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
			}
			// ----------------------------------------------------------------------//
			]
		}

		]

	}

	var base_store_info_create_window = new base_store_info_save_update_form_panel_windows(base_store_info_params, positonParams);

}