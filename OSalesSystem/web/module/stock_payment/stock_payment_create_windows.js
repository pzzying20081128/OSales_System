function stock_payment_create_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();

	var stock_payment_params = {
		title : "新增" + moduleName,
		action : "save",
		grid : grid,
		// 结果路径
		pojo : "result",
		// url
		url : './simple_StockPayment_save.do',
		params : {
			optType : "save"
		},
		// 字段
		field : [{// 第一排
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
				items : [createERPcombo({
					id : 'stockpayment.providerInfoId',
					name : 'stockpayment.providerInfoId',
					fieldLabel : ' 付款商',
					url : "./ProviderInfo_combo.do?searchBean.status=有效",
					allowBlank : false,
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
					id : 'stockpayment.num',
					name : 'stockpayment.num',
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
					id : 'stockpayment.otherSideReceiveNum',
					name : 'stockpayment.otherSideReceiveNum',
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
				items : [{
					id : 'stockpayment.paymentSumMoneyShow',
					name : 'stockpayment.paymentSumMoneyShow',
					fieldLabel : ' 付款金额',
					xtype : 'textfield',
					vtype : "money",
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
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
				items : [createLocalCombo({
					id : 'stockpayment.isPrePayment',
					name : 'stockpayment.isPrePayment',
					fieldLabel : ' 是否预付',
					defaultValue : null,
					storeData : [[1, "是"], [0, '否']],
					defaultValue : 0,
					allowBlank : false
				})]

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
					id : 'stockpayment.paymentDate',
					name : 'stockpayment.paymentDate',
					fieldLabel : ' 付款日期',
					xtype : 'datefield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					format : 'Y-m-d',
					value : new Date()
				}]
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
					width : 250
				},
				items : [{
					id : 'stockpayment.otherSideBank',
					name : 'stockpayment.otherSideBank',
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
					id : 'stockpayment.ourBank',
					name : 'stockpayment.ourBank',
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
				items : [createLocalCombo({
					id : 'stockpayment.paymentType',
					name : 'stockpayment.paymentType',
					fieldLabel : ' 付款方式',
					defaultValue : null,
					storeData : [["现金", "现金"], ["银行转账", '银行转账'], ["支票", '支票']],

					allowBlank : false
				})]

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

					id : 'stockpayment.text',
					name : 'stockpayment.text',
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
			}, // 1-1 end

			]

		}

		]

	}

	var stock_payment_create_window = new stock_payment_save_update_form_panel_windows(stock_payment_params);

}