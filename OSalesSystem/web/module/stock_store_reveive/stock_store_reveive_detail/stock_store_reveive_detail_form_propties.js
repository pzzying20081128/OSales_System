
	      {
			name : 'stockstorereceivedetail.productInfo',
			mapping : 'productInfo'
		},
		            		 	      		 	      {
			name : 'stockstorereceivedetail.taxPriceMoneyShow',
			mapping : 'taxPriceMoneyShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockstorereceivedetail.taxRateTaxRateShow',
			mapping : 'taxRateTaxRateShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockstorereceivedetail.taxMoneyMoneyShow',
			mapping : 'taxMoneyMoneyShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockstorereceivedetail.noTaxPriceMoneyShow',
			mapping : 'noTaxPriceMoneyShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockstorereceivedetail.noTaxMoneyMoneyShow',
			mapping : 'noTaxMoneyMoneyShow'
		},
		            		 	      		 	      {
			name : 'stockstorereceivedetail.orderCount',
			mapping : 'orderCount'
		},
		            		 	      {
			name : 'stockstorereceivedetail.orderBox',
			mapping : 'orderBox'
		},
		            		 	      {
			name : 'stockstorereceivedetail.text',
			mapping : 'text'
		},
		            		 	      {
			name : 'stockstorereceivedetail.storeInfo',
			mapping : 'storeInfo'
		},
		            		 	      {
			name : 'stockstorereceivedetail.storePosition',
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
					id : 'stockstorereceivedetail.productInfo',
					name : 'stockstorereceivedetail.productInfo',
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
					id : 'stockstorereceivedetail.taxPriceMoneyShow',
					name : 'stockstorereceivedetail.taxPriceMoneyShow',
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
					id : 'stockstorereceivedetail.taxRateTaxRateShow',
					name : 'stockstorereceivedetail.taxRateTaxRateShow',
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
					id : 'stockstorereceivedetail.taxMoneyMoneyShow',
					name : 'stockstorereceivedetail.taxMoneyMoneyShow',
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
					id : 'stockstorereceivedetail.noTaxPriceMoneyShow',
					name : 'stockstorereceivedetail.noTaxPriceMoneyShow',
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
					id : 'stockstorereceivedetail.noTaxMoneyMoneyShow',
					name : 'stockstorereceivedetail.noTaxMoneyMoneyShow',
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
					id : 'stockstorereceivedetail.orderCount',
					name : 'stockstorereceivedetail.orderCount',
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
					id : 'stockstorereceivedetail.orderBox',
					name : 'stockstorereceivedetail.orderBox',
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
					id : 'stockstorereceivedetail.text',
					name : 'stockstorereceivedetail.text',
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
					id : 'stockstorereceivedetail.storeInfo',
					name : 'stockstorereceivedetail.storeInfo',
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
					id : 'stockstorereceivedetail.storePosition',
					name : 'stockstorereceivedetail.storePosition',
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