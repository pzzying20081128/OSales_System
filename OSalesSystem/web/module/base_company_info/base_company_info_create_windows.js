function base_company_info_create_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();

	var base_company_info_params = {
		title : "新增" + moduleName,
		action : "save",
		grid : grid,
		// 结果路径
		pojo : "result",
		// url
		url : './simple_CompanyInfo_save.do',
		params : {
			optType : "save"
		},
		// 字段
		field : [{// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 545
				},
				items : [{
					id : 'companyinfo.name',
					name : 'companyinfo.name',
					fieldLabel : ' 单位名字',
					xtype : 'textfield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, // 1-1 e
			]
		}, {// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 230
				},
				items : [{
					id : 'companyinfo.shortName',
					name : 'companyinfo.shortName',
					fieldLabel : ' 简称',
					xtype : 'textfield',
					// style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, // 1-1 end
			{
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 230
				},
				items : [{
					id : 'companyinfo.phone',
					name : 'companyinfo.phone',
					fieldLabel : ' 联系电话',
					xtype : 'textfield',
					// style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}// 1-2end
			, {

			}// 1-3 end
			, {

			}// 1-3 end
			]
		}, {// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 230
				},
				items : [{
					id : 'companyinfo.orderPhone',
					name : 'companyinfo.orderPhone',
					fieldLabel : ' 订货电话',
					xtype : 'textfield',
					// style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, // 1-1 end
			{
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 230
				},
				items : [{
					id : 'companyinfo.fax',
					name : 'companyinfo.fax',
					fieldLabel : ' 传真',
					xtype : 'textfield',
					// style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}// 1-2end

			]
		}, {// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 230
				},
				items : [{
					id : 'companyinfo.web',
					name : 'companyinfo.web',
					fieldLabel : ' 网页',
					xtype : 'textfield',
					// style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, // 1-1 end
			{
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 230
				},
				items : [{
					id : 'companyinfo.mail',
					name : 'companyinfo.mail',
					fieldLabel : ' 电子邮箱',
					xtype : 'textfield',
					// style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}// 1-2end
			]
		}, {
			// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 230
				},
				items : [{
					id : 'companyinfo.bank',
					name : 'companyinfo.bank',
					fieldLabel : ' 银行',
					xtype : 'textfield',
					// style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, // 1-1 end
			{
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 230
				},
				items : [{
					id : 'companyinfo.bankNum',
					name : 'companyinfo.bankNum',
					fieldLabel : ' 银行帐号',
					xtype : 'textfield',
					// style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}// 1-2end
			]

		}, {
			// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .5,
				layout : 'form',
				// defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 230
				},
				items : [createLocalCombo({
					id : 'companyinfo.isDefault',
					name : 'companyinfo.isDefault',
					fieldLabel : ' 是否默认',
					storeData : [['1', "是"], ['0', '否']],
					defaultValue : 0,
					allowBlank : true
				})

				]
			}, // 1-1 end

			]

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
					width : 545
				},
				items : [{
					id : 'companyinfo.address',
					name : 'companyinfo.address',
					fieldLabel : ' 单位地址',
					xtype : 'textfield',
		
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, // 1-1 e
			]

		}

		]

	}

	var base_company_info_create_window = new base_company_info_save_update_form_panel_windows(base_company_info_params);

}