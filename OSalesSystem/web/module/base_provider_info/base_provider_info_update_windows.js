function base_provider_info_update_windows(moduleId, moduleName, params) {

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

	var stockMan = createERPcombo({
		id : 'providerinfo.stockManId',
		name : 'providerinfo.stockManId',
		fieldLabel : ' 采购员',
		url : "./SysStaff_combo.do",
		allowBlank : true,
		forceSelection : false,
		width : 160,
		autoLoad : true,
		params : {
			'searchBean.status' : "有效",
			'searchBean.id' : selection_rows[0].data.stockManId
		}
		,
	});

	var base_provider_info_params = {
		title : "编辑" + moduleName,
		action : "update",
		grid : grid,
		pojo : "result",
		// url
		url : './simple_ProviderInfo_save.do',
		params : {
			optType : "update",
			"providerinfo.id" : selectId
		},
		reader : new Ext.data.JsonReader({
			successProperty : 'success',
			root : 'result',
			totalProperty : 'totalProperty'
		}, [{
			name : 'providerinfo.name',
			mapping : 'name'
		}, {
			name : 'providerinfo.shortName',
			mapping : 'shortName'
		}, {
			name : 'providerinfo.stockManId',
			mapping : 'stockManId'
		}, {
			name : 'providerinfo.settleTime',
			mapping : 'settleTime'
		}, {
			name : 'providerinfo.paymentMethod',
			mapping : 'paymentMethod'
		}, {
			name : 'providerinfo.address',
			mapping : 'address'
		}, {
			name : 'providerinfo.contactMan',
			mapping : 'contactMan'
		}, {
			name : 'providerinfo.phone',
			mapping : 'phone'
		}, {
			name : 'providerinfo.fax',
			mapping : 'fax'
		}, {
			name : 'providerinfo.web',
			mapping : 'web'
		}, {
			name : 'providerinfo.qq',
			mapping : 'qq'
		}, {
			name : 'providerinfo.mail',
			mapping : 'mail'
		}, {
			name : 'providerinfo.returnType',
			mapping : 'returnType'
		}, {
			name : 'providerinfo.bank1',
			mapping : 'bank1'
		}, {
			name : 'providerinfo.bank2',
			mapping : 'bank2'
		}, {
			name : 'providerinfo.text',
			mapping : 'text'
		}, {
			name : 'providerinfo.status',
			mapping : 'status'
		},]),
		// 字段
		field : [{// 第一排
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
					id : 'providerinfo.name',
					name : 'providerinfo.name',
					fieldLabel : ' 供应商',
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
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'providerinfo.shortName',
					name : 'providerinfo.shortName',
					fieldLabel : ' 助记符',
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
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [stockMan]
			},
			// ----------------------------------------------------------------------//
			{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [

				createLocalCombo({
					id : 'providerinfo.status',
					name : 'providerinfo.status',
					fieldLabel : ' 状态',
					storeData : [['有效', "有效"], ['无效', '无效']],
					defaultValue : "有效",
					allowBlank : false
				})]
			}]
		}, {// 第二排
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
				items : [

				createLocalCombo({
					id : 'providerinfo.paymentMethod',
					name : 'providerinfo.paymentMethod',
					fieldLabel : ' 付款方式', // 月结, 到付, 预付
					storeData : [['到付', '到付'], ['月结', '月结'], ['预付', '预付']],
					defaultValue : null,
					allowBlank : false
				})]
			},
			// ----------------------------------------------------------------------//
			{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [

				createLocalCombo({
					id : 'providerinfo.returnType',
					name : 'providerinfo.returnType',
					fieldLabel : ' 退货类型', // 不确定, 开票前退货, 开票后退货
					storeData : [['不确定', "不确定"], ['开票前退货', '开票前退货'], ['开票后退货', '开票后退货']],
					defaultValue : null,
					allowBlank : false
				})

				]
			},
			// ----------------------------------------------------------------------//
			{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'providerinfo.contactMan',
					name : 'providerinfo.contactMan',
					fieldLabel : ' 联系人',
					xtype : 'textfield',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			},
			// ----------------------------------------------------------------------//
			{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'providerinfo.phone',
					name : 'providerinfo.phone',
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
		}

		, {
			// 第二排
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
					id : 'providerinfo.fax',
					name : 'providerinfo.fax',
					fieldLabel : ' 传真',
					xtype : 'textfield',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			},
			// ----------------------------------------------------------------------//
			{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'providerinfo.web',
					name : 'providerinfo.web',
					fieldLabel : ' 网址',
					xtype : 'textfield',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			},
			// ----------------------------------------------------------------------//
			{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'providerinfo.qq',
					name : 'providerinfo.qq',
					fieldLabel : ' qq',
					xtype : 'textfield',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			},
			// ----------------------------------------------------------------------//
			{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'providerinfo.mail',
					name : 'providerinfo.mail',
					fieldLabel : ' 电子邮箱',
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
		}, {

			// 第二排
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
				items : [

				]
			},
			// ----------------------------------------------------------------------//
			{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'providerinfo.bank1',
					name : 'providerinfo.bank1',
					fieldLabel : ' 银行帐号',
					xtype : 'textfield',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			},
			// ----------------------------------------------------------------------//
			{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'providerinfo.bank2',
					name : 'providerinfo.bank2',
					fieldLabel : ' 银行帐号',
					xtype : 'textfield',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			},
			// ----------------------------------------------------------------------//
			{
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 448
				},
				items : [{
					id : 'providerinfo.text',
					name : 'providerinfo.text',
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
		}, {

			// 第二排
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
					id : 'providerinfo.settleTime',
					name : 'providerinfo.settleTime',
					fieldLabel : ' 帐期',
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

				columnWidth : .75,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 715
				},
				items : [{
					id : 'providerinfo.address',
					name : 'providerinfo.address',
					fieldLabel : ' 地址',
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

	var base_provider_info_create_window = new base_provider_info_save_update_form_panel_windows(base_provider_info_params);

	base_provider_info_create_window.load({
		url : './simple_ProviderInfo_get.do?uuid=' + selectId,
		success : function(result) {
			// json = result.result.result;
			// stockMan.load({
			// params : {
			// 'searchBean.status' : "有效",
			// 'searchBean.id' : json.stockManId
			// },
			// success : function() {
			// stockMan.setValue(json.stockManId);
			// }
			// });
		}
	});

}