function base_info_staff_create_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();

	var base_info_staff_params = {
		title : "新增" + moduleName,
		action : "save",
		grid : grid,
		// 结果路径
		pojo : "sss",
		// url
		url : './saveUpdateMaterialManage.action',
		params : {
			optType : "save"
		},
		// 字段
		field : [{// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			items : [

			{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'systemUserInfo.name',
					name : 'systemUserInfo.name',
					fieldLabel : ' 姓名',
					xtype : 'textfield',
					style : 'background:#fff1a4;',
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			},

			{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'systemUserInfo.account',
					name : 'systemUserInfo.account',
					fieldLabel : ' 系统用户',
					xtype : 'textfield',
					// style : 'background:#fff1a4;',
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			},

			{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{

					id : 'systemUserInfo.pwd',
					name : 'systemUserInfo.pwd',
					fieldLabel : '登录密码',
					xtype : 'textfield',
					// style : 'background:#fff1a4;',
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}

				}]
			},

			{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{

					id : 'password',
					name : 'password',
					fieldLabel : '登录密码',
					xtype : 'textfield',
					// style : 'background:#fff1a4;',
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}

				}]
			}]

		}// end
		, {

			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'systemUserInfo.isStockMan',
					name : 'systemUserInfo.isStockMan',
					fieldLabel : ' 采购员',
					xtype : 'textfield',
					style : 'background:#fff1a4;',
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			},

			{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'systemUserInfo.isTransportMan',
					name : 'systemUserInfo.isTransportMan',
					fieldLabel : '  运输员',
					xtype : 'textfield',
					style : 'background:#fff1a4;',
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			},

			{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'systemUserInfo.isBizMan',
					name : 'systemUserInfo.isBizMan',
					fieldLabel : ' 业务员',
					xtype : 'textfield',
					style : 'background:#fff1a4;',
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, {

				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'systemUserInfo.isGoodsMan',
					name : 'systemUserInfo.isGoodsMan',
					fieldLabel : ' 理货员',
					xtype : 'textfield',
					style : 'background:#fff1a4;',
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}
			]
		}

		, {// start 2
			layout : 'column',
			baseCls : 'x-plain',
			items : [

			{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'systemUserInfo.phone',
					name : 'systemUserInfo.phone',
					fieldLabel : ' 手机',
					xtype : 'textfield',
					// style : 'background:#fff1a4;',
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			},

			{
				columnWidth : .75,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 715
				},
				items : [{
					id : 'systemUserInfo.address',
					name : 'systemUserInfo.address',
					fieldLabel : ' 地址',
					xtype : 'textfield',
					// style : 'background:#fff1a4;',
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}

			]
		}// end
		, {
			// start 2
			layout : 'column',
			baseCls : 'x-plain',
			items : [

			{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'systemUserInfo.sex',
					name : 'systemUserInfo.sex',
					fieldLabel : ' 性别',
					xtype : 'textfield',
					//style : 'background:#fff1a4;',
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}

				}]
			},

			{
				columnWidth : .75,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 715
				},
				items : [{
					id : 'systemUserInfo.text',
					name : 'systemUserInfo.text',
					fieldLabel : ' 备注',
					xtype : 'textfield',
					// style : 'background:#fff1a4;',
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}

			]

		}

		]

	}

	var base_info_staff_create_window = new base_info_staff_save_update_form_panel_windows(base_info_staff_params);

}