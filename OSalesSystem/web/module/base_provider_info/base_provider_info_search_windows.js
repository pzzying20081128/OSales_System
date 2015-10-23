function base_provider_info_search_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();
	var search_params = params.searchParams;
	var form_panel = new Ext.form.ERPFormPanel({
		height : 400,
		// autoHeight : false,
		labelWidth : 60,
		items : [{// 第一排
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
					id : 'searchBean.name',
					name : 'searchBean.name',
					fieldLabel : ' 供应商',
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
					id : 'searchBean.shortName',
					name : 'searchBean.shortName',
					fieldLabel : ' 助记符',
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
				items : [createERPcombo({
					id : 'searchBean.stockManId',
					name : 'searchBean.stockManId',
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
					id : 'searchBean.status',
					name : 'searchBean.status',
					fieldLabel : ' 状态',
					storeData : [['全部', "全部"],['有效', "有效"], ['无效', '无效']],
					defaultValue : "全部",
					allowBlank : true
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
					id : 'searchBean.paymentMethod',
					name : 'searchBean.paymentMethod',
					fieldLabel : ' 付款方式', // 月结, 到付, 预付
					storeData : [['全部', "全部"],['到付', '到付'], ['月结', '月结'], ['预付', '预付']],
					defaultValue : "全部",
					allowBlank : true
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
					id : 'searchBean.returnType',
					name : 'searchBean.returnType',
					fieldLabel : ' 退货类型', // 不确定, 开票前退货, 开票后退货
					storeData : [['全部', "全部"],['不确定', "不确定"], ['开票前退货', '开票前退货'], ['开票后退货', '开票后退货']],
					defaultValue : "全部",
					allowBlank : true
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
					id : 'searchBean.contactMan',
					name : 'searchBean.contactMan',
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
					id : 'searchBean.phone',
					name : 'searchBean.phone',
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
					id : 'searchBean.fax',
					name : 'searchBean.fax',
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
					id : 'searchBean.web',
					name : 'searchBean.web',
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
					id : 'searchBean.qq',
					name : 'searchBean.qq',
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
					id : 'searchBean.mail',
					name : 'searchBean.mail',
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
					id : 'searchBean.bank1',
					name : 'searchBean.bank1',
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
					id : 'searchBean.bank2',
					name : 'searchBean.bank2',
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
					id : 'searchBean.text',
					name : 'searchBean.text',
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
					id : 'searchBean.settleTime',
					name : 'searchBean.settleTime',
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
					id : 'searchBean.address',
					name : 'searchBean.address',
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

		],
		buttons : [{
			text : '提交',
			listeners : {
				'click' : function() {
					from = form_panel.getForm();
					if (!search_params.verification(from))
						return;
					grid.removeAll();
					if (from.isValid()) {
						var submitValues1 = from.getValues();
						// 对将要提交的参数进行过滤，去掉emptyText文字
						for (var param in submitValues1) {
							if (from.findField(param) && from.findField(param).emptyText == submitValues1[param]) {
								submitValues1[param] = '';
								// thisForm.findField(param).setValue("");
							}
						}

						Ext.apply(submitValues1, search_params.params());
						grid.load({
							params : submitValues1,
							success : function() {
								window.close();
							}
						});
						window.close();
					} else {
						showErrorMsg("错误", "请检查查询数据的正确性");
					}
				}
			}

		}, {
			text : '关闭',
			listeners : {
				'click' : function() {
					window.close();
				}
			}

		}]
	});

	var window = new Ext.ERPDefaultsWindow({
		title : "查询工单",
		closable : true,
		width : 1100,
		// height : 400,
		// autoHeight : false,

		items : [form_panel]
	});
	window.showWin();

}