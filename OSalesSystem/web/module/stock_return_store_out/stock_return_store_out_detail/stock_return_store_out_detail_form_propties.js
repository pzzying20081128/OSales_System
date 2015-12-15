
	      {
			name : 'stockreturnstoreoutdetail.productInfo',
			mapping : 'productInfo'
		},
		            		 	      		 	      {
			name : 'stockreturnstoreoutdetail.taxPriceMoneyShow',
			mapping : 'taxPriceMoneyShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockreturnstoreoutdetail.taxRateTaxRateShow',
			mapping : 'taxRateTaxRateShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockreturnstoreoutdetail.taxMoneyMoneyShow',
			mapping : 'taxMoneyMoneyShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockreturnstoreoutdetail.noTaxPriceMoneyShow',
			mapping : 'noTaxPriceMoneyShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockreturnstoreoutdetail.noTaxMoneyMoneyShow',
			mapping : 'noTaxMoneyMoneyShow'
		},
		            		 	      		 	      {
			name : 'stockreturnstoreoutdetail.orderCount',
			mapping : 'orderCount'
		},
		            		 	      {
			name : 'stockreturnstoreoutdetail.orderBox',
			mapping : 'orderBox'
		},
		            		 	      {
			name : 'stockreturnstoreoutdetail.text',
			mapping : 'text'
		},
		            		 	      {
			name : 'stockreturnstoreoutdetail.storeInfo',
			mapping : 'storeInfo'
		},
		            		 	      {
			name : 'stockreturnstoreoutdetail.storePosition',
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
					id : 'stockreturnstoreoutdetail.productInfo',
					name : 'stockreturnstoreoutdetail.productInfo',
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
					id : 'stockreturnstoreoutdetail.taxPriceMoneyShow',
					name : 'stockreturnstoreoutdetail.taxPriceMoneyShow',
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
					id : 'stockreturnstoreoutdetail.taxRateTaxRateShow',
					name : 'stockreturnstoreoutdetail.taxRateTaxRateShow',
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
					id : 'stockreturnstoreoutdetail.taxMoneyMoneyShow',
					name : 'stockreturnstoreoutdetail.taxMoneyMoneyShow',
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
					id : 'stockreturnstoreoutdetail.noTaxPriceMoneyShow',
					name : 'stockreturnstoreoutdetail.noTaxPriceMoneyShow',
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
					id : 'stockreturnstoreoutdetail.noTaxMoneyMoneyShow',
					name : 'stockreturnstoreoutdetail.noTaxMoneyMoneyShow',
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
					id : 'stockreturnstoreoutdetail.orderCount',
					name : 'stockreturnstoreoutdetail.orderCount',
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
					id : 'stockreturnstoreoutdetail.orderBox',
					name : 'stockreturnstoreoutdetail.orderBox',
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
					id : 'stockreturnstoreoutdetail.text',
					name : 'stockreturnstoreoutdetail.text',
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
					id : 'stockreturnstoreoutdetail.storeInfo',
					name : 'stockreturnstoreoutdetail.storeInfo',
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
					id : 'stockreturnstoreoutdetail.storePosition',
					name : 'stockreturnstoreoutdetail.storePosition',
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