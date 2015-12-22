function base_company_info_update_windows(moduleId, moduleName, params) {

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
	var selectId = selection_rows[0].id;

	var base_company_info_params = {
		title : "编辑" + moduleName,
		action : "update",
		grid : grid,
		// 结果路径
		pojo : "result",
		// url
		url : './simple_CompanyInfo_save.do',
		params : {
			optType : "update",
			"companyinfo.id" : selectId
		},
		reader : new Ext.data.JsonReader({
			successProperty : 'success',
			root : 'result',
			totalProperty : 'totalProperty'
		}, [{
			name : 'companyinfo.shortName',
			mapping : 'shortName'
		}, {
			name : 'companyinfo.name',
			mapping : 'name'
		}, {
			name : 'companyinfo.address',
			mapping : 'address'
		}, {
			name : 'companyinfo.phone',
			mapping : 'phone'
		}, {
			name : 'companyinfo.orderPhone',
			mapping : 'orderPhone'
		}, {
			name : 'companyinfo.fax',
			mapping : 'fax'
		}, {
			name : 'companyinfo.web',
			mapping : 'web'
		}, {
			name : 'companyinfo.mail',
			mapping : 'mail'
		}, {
			name : 'companyinfo.bank',
			mapping : 'bank'
		}, {
			name : 'companyinfo.bankNum',
			mapping : 'bankNum'
		}, {
			name : 'companyinfo.status',
			mapping : 'status'
		}, {
			name : 'companyinfo.address',
			mapping : 'address'
		},{
			name:"companyinfo.isDefault",
			mapping : 'isDefault'
		}

		]),
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
//					defaultValue : selection_rows[0].data.isDefault,
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
		}]
	}

	var base_company_info_create_window = new base_company_info_save_update_form_panel_windows(base_company_info_params);

	base_company_info_create_window.load({
		url : './simple_CompanyInfo_get.do?uuid='+selectId,
		success : function(result) {
			json = result.result;
		}
	});

}