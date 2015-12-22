function stock_invoice_search_windows(moduleId, moduleName, params) {

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
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 250
				},
				items : [{
					id : 'searchBean.num',
					name : 'searchBean.num',
					fieldLabel : ' 发票编号',
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
					width : 250
				},
				items : [{
					id : 'searchBean.invoiceNum',
					name : 'searchBean.invoiceNum',
					fieldLabel : ' 发票号',
					xtype : 'textfield',

					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}// 1-2en
			]
		}, {
			// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 258
				},
				items : [createERPlocalBoxSelect({
					id : 'searchBean.statuses',
					name : 'searchBean.statuses',
					fieldLabel : '发票状态',
					defaultValue : null,
					localdata : [['有效', "有效"], ['删除', '删除'], ["已审核", "已审核"]],
					defaultValue : null,
					allowBlank : true
				})]
			}, // 1-1 end
			]

		},

		{// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 595
				},
				items : [createERPBoxSelect({
					id : 'searchBean.providerInfoIds',
					name : 'searchBean.providerInfoIds',
					fieldLabel : ' 供应商',
					url : "./ProviderInfo_combo.do?searchBean.status=有效",
					allowBlank : true,
					forceSelection : false
				})]
			} // 1-1 end

			]
		},// 第一排
		{
			layout : 'column',
			baseCls : 'x-plain',
			items : [{// 1-1
				columnWidth : 0.5,
				layout : 'form',
				baseCls : 'x-plain',
				defaults : {
					width : 250
				},
				items : [{
					id : 'searchBean.openStartTime',
					name : 'searchBean.openStartTime',
					fieldLabel : ' 发票日期',
					xtype : 'datefield',
					format : 'Y-m-d',
					// style : NoAllowBlankStyle,
					// blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			},

			{// 1-1
				columnWidth : 0.5,
				layout : 'form',
				baseCls : 'x-plain',
				format : 'Y-m-d',

				defaults : {
					width : 250
				},
				items : [{
					id : 'searchBean.openEndTime',
					name : 'searchBean.openEndTime',
					fieldLabel : '     到',
					xtype : 'datefield',
					format : 'Y-m-d',
					// style : NoAllowBlankStyle,
					// blankText : '不能为空！',
					allowBlank : true,

					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}]
		}, {

			layout : 'column',
			baseCls : 'x-plain',
			items : [{// 1-1
				columnWidth : 0.5,
				layout : 'form',
				baseCls : 'x-plain',
				defaults : {
					width : 250
				},
				items : [{
					id : 'searchBean.paymentStartTime',
					name : 'searchBean.paymentStartTime',
					fieldLabel : ' 付款日期',
					xtype : 'datefield',
					format : 'Y-m-d',
					// style : NoAllowBlankStyle,
					// blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			},

			{// 1-1
				columnWidth : 0.5,
				layout : 'form',
				baseCls : 'x-plain',
				format : 'Y-m-d',

				defaults : {
					width : 250
				},
				items : [{
					id : 'searchBean.paymentEndTime',
					name : 'searchBean.paymentEndTime',
					fieldLabel : '     到',
					xtype : 'datefield',
					format : 'Y-m-d',
					// style : NoAllowBlankStyle,
					// blankText : '不能为空！',
					allowBlank : true,

					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}]

		}, {
			columnWidth : 1,
			layout : 'form',
			defaultType : 'textfield',
			baseCls : 'x-plain',
			defaults : {
				width : 585
			},
			items : [{
				id : 'searchBean.text',
				name : 'searchBean.text',
				fieldLabel : '  备注',
				xtype : 'textfield',
				style : AllowBlankStyle,
				blankText : '不能为空！',
				allowBlank : true,
				listeners : {
					'specialkey' : function(field, e) {
					}
				}
			}]
		}// 1-2en
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
		title : "查询",
		closable : true,
		width : 700,
		// height : 400,
		// autoHeight : false,

		items : [form_panel]
	});
	window.showWin();

}