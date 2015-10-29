
	      {
			name : 'stockstorereceive.providerInfo',
			mapping : 'providerInfo'
		},
		            		 	      {
			name : 'stockstorereceive.providerInfoId',
			mapping : 'providerInfoId'
		},
		            		 	      		 	      {
			name : 'stockstorereceive.taxSumMoneyMoneyShow',
			mapping : 'taxSumMoneyMoneyShow'
		},
		            		 	      		 	      		 	      {
			name : 'stockstorereceive.noTaxSumMoneyMoneyShow',
			mapping : 'noTaxSumMoneyMoneyShow'
		},
		            		 	      		 	      {
			name : 'stockstorereceive.orderCount',
			mapping : 'orderCount'
		},
		            		 	      {
			name : 'stockstorereceive.stockType',
			mapping : 'stockType'
		},
		            		 	      {
			name : 'stockstorereceive.remarks',
			mapping : 'remarks'
		},
		            		 	      {
			name : 'stockstorereceive.text',
			mapping : 'text'
		},
		            		 	      {
			name : 'stockstorereceive.checkMan',
			mapping : 'checkMan'
		},
		            		 	      {
			name : 'stockstorereceive.checkManId',
			mapping : 'checkManId'
		},
		            		 	      {
			name : 'stockstorereceive.checkDate',
			mapping : 'checkDate'
		},
		            		 	      {
			name : 'stockstorereceive.recordMan',
			mapping : 'recordMan'
		},
		            		 	      {
			name : 'stockstorereceive.recordManId',
			mapping : 'recordManId'
		},
		            		 	      {
			name : 'stockstorereceive.recordDate',
			mapping : 'recordDate'
		},
		            		 	      {
			name : 'stockstorereceive.number',
			mapping : 'number'
		},
		            		 	      {
			name : 'stockstorereceive.status',
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
					id : 'stockstorereceive.providerInfo',
					name : 'stockstorereceive.providerInfo',
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
					id : 'stockstorereceive.providerInfoId',
					name : 'stockstorereceive.providerInfoId',
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
					id : 'stockstorereceive.taxSumMoneyMoneyShow',
					name : 'stockstorereceive.taxSumMoneyMoneyShow',
					fieldLabel : ' 含税总金额',
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
					id : 'stockstorereceive.noTaxSumMoneyMoneyShow',
					name : 'stockstorereceive.noTaxSumMoneyMoneyShow',
					fieldLabel : ' 没税总金额',
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
					id : 'stockstorereceive.orderCount',
					name : 'stockstorereceive.orderCount',
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
					id : 'stockstorereceive.stockType',
					name : 'stockstorereceive.stockType',
					fieldLabel : ' 订单类型',
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
					id : 'stockstorereceive.remarks',
					name : 'stockstorereceive.remarks',
					fieldLabel : ' 说明',
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
					id : 'stockstorereceive.text',
					name : 'stockstorereceive.text',
					fieldLabel : '  备注',
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
					id : 'stockstorereceive.checkMan',
					name : 'stockstorereceive.checkMan',
					fieldLabel : ' 审核员',
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
					id : 'stockstorereceive.checkManId',
					name : 'stockstorereceive.checkManId',
					fieldLabel : ' 审核员',
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
					id : 'stockstorereceive.checkDate',
					name : 'stockstorereceive.checkDate',
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
					id : 'stockstorereceive.recordMan',
					name : 'stockstorereceive.recordMan',
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
					id : 'stockstorereceive.recordManId',
					name : 'stockstorereceive.recordManId',
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
					id : 'stockstorereceive.recordDate',
					name : 'stockstorereceive.recordDate',
					fieldLabel : ' 录入日期',
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
					id : 'stockstorereceive.number',
					name : 'stockstorereceive.number',
					fieldLabel : ' 单号',
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
					id : 'stockstorereceive.status',
					name : 'stockstorereceive.status',
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
