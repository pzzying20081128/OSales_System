
	      {
			name : 'stockreturndetail.productInfo',
			mapping : 'productInfo'
		},
		            		 	      		 	      {
			name : 'stockreturndetail.taxPriceMoneyShow',
			mapping : 'taxPriceMoneyShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockreturndetail.taxRateTaxRateShow',
			mapping : 'taxRateTaxRateShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockreturndetail.taxMoneyMoneyShow',
			mapping : 'taxMoneyMoneyShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockreturndetail.noTaxPriceMoneyShow',
			mapping : 'noTaxPriceMoneyShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockreturndetail.noTaxMoneyMoneyShow',
			mapping : 'noTaxMoneyMoneyShow'
		},
		            		 	      		 	      {
			name : 'stockreturndetail.orderCount',
			mapping : 'orderCount'
		},
		            		 	      {
			name : 'stockreturndetail.orderBox',
			mapping : 'orderBox'
		},
		            		 	      {
			name : 'stockreturndetail.text',
			mapping : 'text'
		},
		            		 	      {
			name : 'stockreturndetail.storeInfo',
			mapping : 'storeInfo'
		},
		            		 	      {
			name : 'stockreturndetail.storePosition',
			mapping : 'storePosition'
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
					id : 'stockreturndetail.productInfo',
					name : 'stockreturndetail.productInfo',
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
					id : 'stockreturndetail.taxPriceMoneyShow',
					name : 'stockreturndetail.taxPriceMoneyShow',
					fieldLabel : ' 含税单价',
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
					id : 'stockreturndetail.taxRateTaxRateShow',
					name : 'stockreturndetail.taxRateTaxRateShow',
					fieldLabel : ' 税率',
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
					id : 'stockreturndetail.taxMoneyMoneyShow',
					name : 'stockreturndetail.taxMoneyMoneyShow',
					fieldLabel : ' 含税金额',
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
					id : 'stockreturndetail.noTaxPriceMoneyShow',
					name : 'stockreturndetail.noTaxPriceMoneyShow',
					fieldLabel : ' 未税单价',
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
					id : 'stockreturndetail.noTaxMoneyMoneyShow',
					name : 'stockreturndetail.noTaxMoneyMoneyShow',
					fieldLabel : ' 未税金额',
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
					id : 'stockreturndetail.orderCount',
					name : 'stockreturndetail.orderCount',
					fieldLabel : ' 订购数量',
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
					id : 'stockreturndetail.orderBox',
					name : 'stockreturndetail.orderBox',
					fieldLabel : ' 订购箱数量',
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
					id : 'stockreturndetail.text',
					name : 'stockreturndetail.text',
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
					id : 'stockreturndetail.storeInfo',
					name : 'stockreturndetail.storeInfo',
					fieldLabel : ' 入库仓库',
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
					id : 'stockreturndetail.storePosition',
					name : 'stockreturndetail.storePosition',
					fieldLabel : ' 入库库位',
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