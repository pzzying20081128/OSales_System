
	      {
			name : 'stockpayment.num',
			mapping : 'num'
		},
		            		 	      {
			name : 'stockpayment.otherSideReceiveNum',
			mapping : 'otherSideReceiveNum'
		},
		            		 	      {
			name : 'stockpayment.providerInfo',
			mapping : 'providerInfo'
		},
		            		 	      {
			name : 'stockpayment.providerInfoId',
			mapping : 'providerInfoId'
		},
		            		 	      {
			name : 'stockpayment.stockMan',
			mapping : 'stockMan'
		},
		            		 	      {
			name : 'stockpayment.stockManId',
			mapping : 'stockManId'
		},
		            		 	      {
			name : 'stockpayment.isPrePayment',
			mapping : 'isPrePayment'
		},
		            		 	      {
			name : 'stockpayment.paymentDate',
			mapping : 'paymentDate'
		},
		            		 	      {
			name : 'stockpayment.paymentSum',
			mapping : 'paymentSum'
		},
		            		 	      {
			name : 'stockpayment.paymentSumMoneyShow',
			mapping : 'paymentSumMoneyShow'
		},
		            		 	      {
			name : 'stockpayment.paymentSumMoneyHide',
			mapping : 'paymentSumMoneyHide'
		},
		            		 	      {
			name : 'stockpayment.text',
			mapping : 'text'
		},
		            		 	      {
			name : 'stockpayment.checkMan',
			mapping : 'checkMan'
		},
		            		 	      {
			name : 'stockpayment.checkManId',
			mapping : 'checkManId'
		},
		            		 	      {
			name : 'stockpayment.checkedDate',
			mapping : 'checkedDate'
		},
		            		 	      		 	      {
			name : 'stockpayment.killSumMoneyShow',
			mapping : 'killSumMoneyShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockpayment.noKillSumMoneyShow',
			mapping : 'noKillSumMoneyShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockpayment.reconciliationSumMoneyShow',
			mapping : 'reconciliationSumMoneyShow'
		},
		            		 	      		 	      {
			name : 'stockpayment.otherSideBank',
			mapping : 'otherSideBank'
		},
		            		 	      {
			name : 'stockpayment.ourBank',
			mapping : 'ourBank'
		},
		            		 	      {
			name : 'stockpayment.paymentType',
			mapping : 'paymentType'
		},
		            		 	      {
			name : 'stockpayment.recordMan',
			mapping : 'recordMan'
		},
		            		 	      		 	      {
			name : 'stockpayment.status',
			mapping : 'status'
		},
		            		 

	      	      // ----------------------------------------------------------------------//
			  {
                columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 250
				},
				items : [{
					id : 'stockpayment.num',
					name : 'stockpayment.num',
					fieldLabel : ' 付款单号',
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
					width : 250
				},
				items : [{
					id : 'stockpayment.otherSideReceiveNum',
					name : 'stockpayment.otherSideReceiveNum',
					fieldLabel : ' 对方收款单号',
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
					width : 250
				},
				items : [{
					id : 'stockpayment.providerInfo',
					name : 'stockpayment.providerInfo',
					fieldLabel : ' 付款商',
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
					width : 250
				},
				items : [{
					id : 'stockpayment.providerInfoId',
					name : 'stockpayment.providerInfoId',
					fieldLabel : ' 付款商',
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
					width : 250
				},
				items : [{
					id : 'stockpayment.stockMan',
					name : 'stockpayment.stockMan',
					fieldLabel : ' 采购员',
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
					width : 250
				},
				items : [{
					id : 'stockpayment.stockManId',
					name : 'stockpayment.stockManId',
					fieldLabel : ' 采购员',
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
					width : 250
				},
				items : [{
					id : 'stockpayment.isPrePayment',
					name : 'stockpayment.isPrePayment',
					fieldLabel : ' 是否预付',
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
					width : 250
				},
				items : [{
					id : 'stockpayment.paymentDate',
					name : 'stockpayment.paymentDate',
					fieldLabel : ' 付款日期',
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
					width : 250
				},
				items : [{
					id : 'stockpayment.paymentSum',
					name : 'stockpayment.paymentSum',
					fieldLabel : ' 付款金额',
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
					width : 250
				},
				items : [{
					id : 'stockpayment.paymentSumMoneyShow',
					name : 'stockpayment.paymentSumMoneyShow',
					fieldLabel : ' 付款金额',
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
					width : 250
				},
				items : [{
					id : 'stockpayment.paymentSumMoneyHide',
					name : 'stockpayment.paymentSumMoneyHide',
					fieldLabel : ' 付款金额',
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
					width : 250
				},
				items : [{
					id : 'stockpayment.text',
					name : 'stockpayment.text',
					fieldLabel : ' 备注',
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
					width : 250
				},
				items : [{
					id : 'stockpayment.checkMan',
					name : 'stockpayment.checkMan',
					fieldLabel : ' 采审核人',
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
					width : 250
				},
				items : [{
					id : 'stockpayment.checkManId',
					name : 'stockpayment.checkManId',
					fieldLabel : ' 采审核人',
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
					width : 250
				},
				items : [{
					id : 'stockpayment.checkedDate',
					name : 'stockpayment.checkedDate',
					fieldLabel : ' 采审时间',
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
					width : 250
				},
				items : [{
					id : 'stockpayment.killSumMoneyShow',
					name : 'stockpayment.killSumMoneyShow',
					fieldLabel : ' 抵消金额',
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
					width : 250
				},
				items : [{
					id : 'stockpayment.noKillSumMoneyShow',
					name : 'stockpayment.noKillSumMoneyShow',
					fieldLabel : ' 未抵消金额',
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
					width : 250
				},
				items : [{
					id : 'stockpayment.reconciliationSumMoneyShow',
					name : 'stockpayment.reconciliationSumMoneyShow',
					fieldLabel : ' 对账余额',
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
					width : 250
				},
				items : [{
					id : 'stockpayment.otherSideBank',
					name : 'stockpayment.otherSideBank',
					fieldLabel : ' 对方银行',
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
					width : 250
				},
				items : [{
					id : 'stockpayment.ourBank',
					name : 'stockpayment.ourBank',
					fieldLabel : ' 我方银行',
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
					width : 250
				},
				items : [{
					id : 'stockpayment.paymentType',
					name : 'stockpayment.paymentType',
					fieldLabel : ' 付款方式',
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
					width : 250
				},
				items : [{
					id : 'stockpayment.recordMan',
					name : 'stockpayment.recordMan',
					fieldLabel : ' 录入人',
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
					width : 250
				},
				items : [{
					id : 'stockpayment.status',
					name : 'stockpayment.status',
					fieldLabel : ' 状态',
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
            		 

// 1-1