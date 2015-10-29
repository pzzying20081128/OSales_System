
	      {
			name : 'stockinstoredetail.productInfo',
			mapping : 'productInfo'
		},
		            		 	      		 	      {
			name : 'stockinstoredetail.taxPriceMoneyShow',
			mapping : 'taxPriceMoneyShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockinstoredetail.taxRateTaxRateShow',
			mapping : 'taxRateTaxRateShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockinstoredetail.taxMoneyMoneyShow',
			mapping : 'taxMoneyMoneyShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockinstoredetail.noTaxPriceMoneyShow',
			mapping : 'noTaxPriceMoneyShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockinstoredetail.noTaxMoneyMoneyShow',
			mapping : 'noTaxMoneyMoneyShow'
		},
		            		 	      		 	      {
			name : 'stockinstoredetail.orderCount',
			mapping : 'orderCount'
		},
		            		 	      {
			name : 'stockinstoredetail.orderBox',
			mapping : 'orderBox'
		},
		            		 	      {
			name : 'stockinstoredetail.text',
			mapping : 'text'
		},
		            		 	      {
			name : 'stockinstoredetail.storeInfo',
			mapping : 'storeInfo'
		},
		            		 	      {
			name : 'stockinstoredetail.storePosition',
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
					id : 'stockinstoredetail.productInfo',
					name : 'stockinstoredetail.productInfo',
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
					id : 'stockinstoredetail.taxPriceMoneyShow',
					name : 'stockinstoredetail.taxPriceMoneyShow',
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
					id : 'stockinstoredetail.taxRateTaxRateShow',
					name : 'stockinstoredetail.taxRateTaxRateShow',
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
					id : 'stockinstoredetail.taxMoneyMoneyShow',
					name : 'stockinstoredetail.taxMoneyMoneyShow',
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
					id : 'stockinstoredetail.noTaxPriceMoneyShow',
					name : 'stockinstoredetail.noTaxPriceMoneyShow',
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
					id : 'stockinstoredetail.noTaxMoneyMoneyShow',
					name : 'stockinstoredetail.noTaxMoneyMoneyShow',
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
					id : 'stockinstoredetail.orderCount',
					name : 'stockinstoredetail.orderCount',
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
					id : 'stockinstoredetail.orderBox',
					name : 'stockinstoredetail.orderBox',
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
					id : 'stockinstoredetail.text',
					name : 'stockinstoredetail.text',
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
					id : 'stockinstoredetail.storeInfo',
					name : 'stockinstoredetail.storeInfo',
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
					id : 'stockinstoredetail.storePosition',
					name : 'stockinstoredetail.storePosition',
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
