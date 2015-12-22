
	      {
			name : 'stockinvoice.num',
			mapping : 'num'
		},
		            		 	      {
			name : 'stockinvoice.invoiceNum',
			mapping : 'invoiceNum'
		},
		            		 	      {
			name : 'stockinvoice.providerInfo',
			mapping : 'providerInfo'
		},
		            		 	      		 	      {
			name : 'stockinvoice.invoiceDate',
			mapping : 'invoiceDate'
		},
		            		 	      {
			name : 'stockinvoice.paymentDate',
			mapping : 'paymentDate'
		},
		            		 	      		 	      {
			name : 'stockinvoice.invoiceSumMoneyShow',
			mapping : 'invoiceSumMoneyShow'
		},
		            		 	      		 	      {
			name : 'stockinvoice.text',
			mapping : 'text'
		},
		            		 	      {
			name : 'stockinvoice.recordMan',
			mapping : 'recordMan'
		},
		            		 	      		 	      {
			name : 'stockinvoice.checkMan',
			mapping : 'checkMan'
		},
		            		 	      		 	      {
			name : 'stockinvoice.checkedDate',
			mapping : 'checkedDate'
		},
		            		 	      		 	      {
			name : 'stockinvoice.killSumMoneyShow',
			mapping : 'killSumMoneyShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockinvoice.noKillSumMoneyShow',
			mapping : 'noKillSumMoneyShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockinvoice.reconciliationSumMoneyShow',
			mapping : 'reconciliationSumMoneyShow'
		},
		            		 	      		 	      {
			name : 'stockinvoice.status',
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
					id : 'stockinvoice.num',
					name : 'stockinvoice.num',
					fieldLabel : ' 发票编号',
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
					id : 'stockinvoice.invoiceNum',
					name : 'stockinvoice.invoiceNum',
					fieldLabel : ' 发票号',
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
					id : 'stockinvoice.providerInfo',
					name : 'stockinvoice.providerInfo',
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
					width : 250
				},
				items : [{
					id : 'stockinvoice.invoiceDate',
					name : 'stockinvoice.invoiceDate',
					fieldLabel : ' 发票日期',
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
					id : 'stockinvoice.paymentDate',
					name : 'stockinvoice.paymentDate',
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
					id : 'stockinvoice.invoiceSumMoneyShow',
					name : 'stockinvoice.invoiceSumMoneyShow',
					fieldLabel : ' 发票金额',
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
					id : 'stockinvoice.text',
					name : 'stockinvoice.text',
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
					id : 'stockinvoice.recordMan',
					name : 'stockinvoice.recordMan',
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
					id : 'stockinvoice.checkMan',
					name : 'stockinvoice.checkMan',
					fieldLabel : ' 审核人',
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
					id : 'stockinvoice.checkedDate',
					name : 'stockinvoice.checkedDate',
					fieldLabel : ' 审核日期',
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
					id : 'stockinvoice.killSumMoneyShow',
					name : 'stockinvoice.killSumMoneyShow',
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
					id : 'stockinvoice.noKillSumMoneyShow',
					name : 'stockinvoice.noKillSumMoneyShow',
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
					id : 'stockinvoice.reconciliationSumMoneyShow',
					name : 'stockinvoice.reconciliationSumMoneyShow',
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
					id : 'stockinvoice.status',
					name : 'stockinvoice.status',
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