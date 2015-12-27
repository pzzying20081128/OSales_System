function stock_payment_search_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();
	var search_params = params.searchParams;
	var form_panel = new Ext.form.ERPFormPanel({
		labelWidth : 60,
		width : 1000,
		items : [{// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 250
				},
				items : [createERPBoxSelect({
					id : 'searchBean.providerInfoId',
					name : 'searchBean.providerInfoId',
					fieldLabel : ' 付款商',
					url : "./ProviderInfo_combo.do?searchBean.status=有效",
					allowBlank : true,
					forceSelection : false
					// select : function(combo, record, index) {
					// id = record.id;
					// storePosition.load({
					// params : {
					// 'searchBean.storeInfoId' : id,
					// 'searchBean.status' : '有效'
					// }
					//
					// });
					// }
				})]
			}// 1-3 end
			, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 210
				},
				items : [{
					id : 'searchBean.num',
					name : 'searchBean.num',
					fieldLabel : ' 付款单号',
					xtype : 'textfield',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, // 1-1 end
			{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 210
				},
				items : [{
					id : 'searchBean.otherSideReceiveNum',
					name : 'searchBean.otherSideReceiveNum',
					fieldLabel : ' 对方单号',
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
		}, {// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 250
				},
				items : [createERPlocalBoxSelect({
					id : 'searchBean.paymentTypes',
					name : 'searchBean.paymentTypes',
					fieldLabel : ' 付款方式',
					defaultValue : null,
					localdata : [["现金", "现金"], ["银行转账", '银行转账'], ["支票", '支票']],

					allowBlank : true
				})]
			}, // 1-1 end
			{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 218
				},
				items : [createERPlocalBoxSelect({
					id : 'searchBean.isPrePayments',
					name : 'searchBean.isPrePayments',
					fieldLabel : ' 是否预付',
					defaultValue : null,
					localdata : [[1, "是"], [0, '否']],
					defaultValue : 0,
					allowBlank : true
				})]

			}// 1-2end
			, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 218
				},
				items : [createERPlocalBoxSelect({
					id : 'searchBean.statuses',
					name : 'searchBean.statuses',
					fieldLabel : ' 状态', // 无效, 删除, 有效, 全部, 初始化, 已审核, 等待其他审核
					localdata : [['删除', "删除"], ['有效', '有效'], ['已审核', '已审核']],
					defaultValue : null,
					allowBlank : true
				})]
			}// 1-3 end
			// 1-3 end
			]
		}, {// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 242
				},
				items : [{
					id : 'searchBean.otherSideBank',
					name : 'searchBean.otherSideBank',
					fieldLabel : ' 对方银行',
					xtype : 'textfield',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}// 1-2end
			, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 210
				},
				items : [{
					id : 'searchBean.ourBank',
					name : 'searchBean.ourBank',
					fieldLabel : ' 我方银行',
					xtype : 'textfield',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}// 1-3 end
			, {

				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 210
				},
				items : []

			}]

		}, {

			//
			layout : 'column',
			baseCls : 'x-plain',
			
			items : [{// 1-1
				columnWidth : 0.34,
				layout : 'form',
				defaultType : 'checkbox',
				baseCls : 'x-plain',
				defaults : {
					width : 242
				},
				items : [{
					id : 'searchBean.startTime',
					name : 'searchBean.startTime',
					fieldLabel : ' 付款时间',
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
				columnWidth : 0.33,
				layout : 'form',
				defaultType : 'checkbox',
				baseCls : 'x-plain',
				format : 'Y-m-d',
//				labelWidth : 70,
				defaults : {
					width : 210
				},
				items : [{
					id : 'searchBean.endTime',
					name : 'searchBean.endTime',
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
			// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : 1,
				layout : 'form',
				// defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 860
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
			} // 1-1 end

			]

		},

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
		width : 1000,
		// height : 400,
		// autoHeight : false,

		items : [form_panel]
	});
	window.showWin();

}