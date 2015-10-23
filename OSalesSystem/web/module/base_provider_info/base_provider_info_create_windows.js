function base_provider_info_create_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();

	var base_provider_info_params = {
		title : "新增" + moduleName,
		action : "save",
		grid : grid,
		// 结果路径
		pojo : "result",
		// url
		url : './simple_ProviderInfo_save.do',
		params : {
			optType : "save"
		},
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
				items : [createERPcombo({
					id : 'providerinfo.stockManId',
					name : 'providerinfo.stockManId',
					fieldLabel : ' 采购员',
					url : "./SysStaff_combo.do?searchBean.status=有效",
					allowBlank : true,
					forceSelection : false,
					width : 160
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
					fieldLabel : ' 退货类型', //不确定, 开票前退货, 开票后退货
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

}