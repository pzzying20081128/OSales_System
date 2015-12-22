
	      {
			name : 'stockinvoicedetail.providerInfo',
			mapping : 'providerInfo'
		},
		            		 	      		 	      {
			name : 'stockinvoicedetail.billType',
			mapping : 'billType'
		},
		            		 	      {
			name : 'stockinvoicedetail.billNum',
			mapping : 'billNum'
		},
		            		 	      {
			name : 'stockinvoicedetail.billDate',
			mapping : 'billDate'
		},
		            		 	      {
			name : 'stockinvoicedetail.text',
			mapping : 'text'
		},
		            		 	      		 	      {
			name : 'stockinvoicedetail.billSumMoneyShow',
			mapping : 'billSumMoneyShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockinvoicedetail.killSumMoneyShow',
			mapping : 'killSumMoneyShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockinvoicedetail.noKillSumMoneyShow',
			mapping : 'noKillSumMoneyShow'
		},
		            		 	      		 	      {
			name : 'stockinvoicedetail.billInfo',
			mapping : 'billInfo'
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
					id : 'stockinvoicedetail.providerInfo',
					name : 'stockinvoicedetail.providerInfo',
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
					id : 'stockinvoicedetail.billType',
					name : 'stockinvoicedetail.billType',
					fieldLabel : ' 单据类型',
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
					id : 'stockinvoicedetail.billNum',
					name : 'stockinvoicedetail.billNum',
					fieldLabel : ' 单据编号',
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
					id : 'stockinvoicedetail.billDate',
					name : 'stockinvoicedetail.billDate',
					fieldLabel : ' 单据日期',
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
					id : 'stockinvoicedetail.text',
					name : 'stockinvoicedetail.text',
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
					id : 'stockinvoicedetail.billSumMoneyShow',
					name : 'stockinvoicedetail.billSumMoneyShow',
					fieldLabel : ' 单据金额',
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
					id : 'stockinvoicedetail.killSumMoneyShow',
					name : 'stockinvoicedetail.killSumMoneyShow',
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
					id : 'stockinvoicedetail.noKillSumMoneyShow',
					name : 'stockinvoicedetail.noKillSumMoneyShow',
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
					id : 'stockinvoicedetail.billInfo',
					name : 'stockinvoicedetail.billInfo',
					fieldLabel : ' 单据信息',
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