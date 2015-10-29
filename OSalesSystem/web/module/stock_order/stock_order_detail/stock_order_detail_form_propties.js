
	      {
			name : 'stockorderdetail.productInfo',
			mapping : 'productInfo'
		},
		            		 	      		 	      {
			name : 'stockorderdetail.taxPriceMoneyShow',
			mapping : 'taxPriceMoneyShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockorderdetail.taxRateTaxRateShow',
			mapping : 'taxRateTaxRateShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockorderdetail.taxMoneyMoneyShow',
			mapping : 'taxMoneyMoneyShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockorderdetail.noTaxPriceMoneyShow',
			mapping : 'noTaxPriceMoneyShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockorderdetail.noTaxMoneyMoneyShow',
			mapping : 'noTaxMoneyMoneyShow'
		},
		            		 	      		 	      {
			name : 'stockorderdetail.count',
			mapping : 'count'
		},
		            		 	      {
			name : 'stockorderdetail.orderBox',
			mapping : 'orderBox'
		},
		            		 	      {
			name : 'stockorderdetail.text',
			mapping : 'text'
		},
		            		 	      {
			name : 'stockorderdetail.storeInfo',
			mapping : 'storeInfo'
		},
		            		 	      {
			name : 'stockorderdetail.storePosition',
			mapping : 'storePosition'
		},
		            		 

	      	      // ----------------------------------------------------------------------//
			
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
					id : 'stockorderdetail.taxPriceMoneyShow',
					name : 'stockorderdetail.taxPriceMoneyShow',
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
					id : 'stockorderdetail.taxRateTaxRateShow',
					name : 'stockorderdetail.taxRateTaxRateShow',
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
					id : 'stockorderdetail.taxMoneyMoneyShow',
					name : 'stockorderdetail.taxMoneyMoneyShow',
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
					id : 'stockorderdetail.noTaxPriceMoneyShow',
					name : 'stockorderdetail.noTaxPriceMoneyShow',
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
					id : 'stockorderdetail.noTaxMoneyMoneyShow',
					name : 'stockorderdetail.noTaxMoneyMoneyShow',
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
					id : 'stockorderdetail.count',
					name : 'stockorderdetail.count',
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
					id : 'stockorderdetail.orderBox',
					name : 'stockorderdetail.orderBox',
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
					id : 'stockorderdetail.text',
					name : 'stockorderdetail.text',
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
					id : 'stockorderdetail.storeInfo',
					name : 'stockorderdetail.storeInfo',
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
					id : 'stockorderdetail.storePosition',
					name : 'stockorderdetail.storePosition',
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
