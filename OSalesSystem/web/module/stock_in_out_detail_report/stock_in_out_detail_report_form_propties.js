
	      {
			name : 'stocksummarybill.billType',
			mapping : 'billType'
		},
		            		 	      {
			name : 'stocksummarybill.billNum',
			mapping : 'billNum'
		},
		            		 	      {
			name : 'stocksummarybill.providerInfo',
			mapping : 'providerInfo'
		},
		            		 	      		 	      {
			name : 'stocksummarybill.productInfo',
			mapping : 'productInfo'
		},
		            		 	      		 	      {
			name : 'stocksummarybill.stockTaxSumMoneyMoneyShow',
			mapping : 'stockTaxSumMoneyMoneyShow'
		},
		            		 	      		 	      		 	      {
			name : 'stocksummarybill.stockNoTaxSumMoneyMoneyShow',
			mapping : 'stockNoTaxSumMoneyMoneyShow'
		},
		            		 	      		 	      {
			name : 'stocksummarybill.stockCount',
			mapping : 'stockCount'
		},
		            		 	      		 	      {
			name : 'stocksummarybill.returnGoodsTaxSumMoneyMoneyShow',
			mapping : 'returnGoodsTaxSumMoneyMoneyShow'
		},
		            		 	      		 	      		 	      {
			name : 'stocksummarybill.returnGoodsNoTaxSumMoneyMoneyShow',
			mapping : 'returnGoodsNoTaxSumMoneyMoneyShow'
		},
		            		 	      		 	      {
			name : 'stocksummarybill.returnGoodsCount',
			mapping : 'returnGoodsCount'
		},
		            		 	      		 	      {
			name : 'stocksummarybill.stockAdjustSumMoneyMoneyShow',
			mapping : 'stockAdjustSumMoneyMoneyShow'
		},
		            		 	      		 	      {
			name : 'stocksummarybill.status',
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
					id : 'stocksummarybill.billType',
					name : 'stocksummarybill.billType',
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
					id : 'stocksummarybill.billNum',
					name : 'stocksummarybill.billNum',
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
					id : 'stocksummarybill.providerInfo',
					name : 'stocksummarybill.providerInfo',
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
					id : 'stocksummarybill.productInfo',
					name : 'stocksummarybill.productInfo',
					fieldLabel : ' 产品',
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
					id : 'stocksummarybill.stockTaxSumMoneyMoneyShow',
					name : 'stocksummarybill.stockTaxSumMoneyMoneyShow',
					fieldLabel : ' 进货含税总金额',
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
					id : 'stocksummarybill.stockNoTaxSumMoneyMoneyShow',
					name : 'stocksummarybill.stockNoTaxSumMoneyMoneyShow',
					fieldLabel : ' 进货末税总金额',
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
					id : 'stocksummarybill.stockCount',
					name : 'stocksummarybill.stockCount',
					fieldLabel : ' 进货数量',
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
					id : 'stocksummarybill.returnGoodsTaxSumMoneyMoneyShow',
					name : 'stocksummarybill.returnGoodsTaxSumMoneyMoneyShow',
					fieldLabel : ' 退货含税总金额',
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
					id : 'stocksummarybill.returnGoodsNoTaxSumMoneyMoneyShow',
					name : 'stocksummarybill.returnGoodsNoTaxSumMoneyMoneyShow',
					fieldLabel : ' 退货末税总金额',
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
					id : 'stocksummarybill.returnGoodsCount',
					name : 'stocksummarybill.returnGoodsCount',
					fieldLabel : ' 退货数量',
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
					id : 'stocksummarybill.stockAdjustSumMoneyMoneyShow',
					name : 'stocksummarybill.stockAdjustSumMoneyMoneyShow',
					fieldLabel : ' 采购调整金额',
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
					id : 'stocksummarybill.status',
					name : 'stocksummarybill.status',
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
