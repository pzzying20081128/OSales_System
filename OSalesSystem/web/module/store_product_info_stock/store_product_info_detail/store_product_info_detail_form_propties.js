
	      {
			name : 'storeproductinfodetail.purchaseSum',
			mapping : 'purchaseSum'
		},
		            		 	      {
			name : 'storeproductinfodetail.purchaseMoneyMoneyShow',
			mapping : 'purchaseMoneyMoneyShow'
		},
		            		 	      {
			name : 'storeproductinfodetail.planInStoreSum',
			mapping : 'planInStoreSum'
		},
		            		 	      {
			name : 'storeproductinfodetail.planInStoreMoneyMoneyShow',
			mapping : 'planInStoreMoneyMoneyShow'
		},
		            		 	      {
			name : 'storeproductinfodetail.planOutStoreSum',
			mapping : 'planOutStoreSum'
		},
		            		 	      {
			name : 'storeproductinfodetail.planOutStoreMoneyMoneyShow',
			mapping : 'planOutStoreMoneyMoneyShow'
		},
		            		 	      {
			name : 'storeproductinfodetail.approvalSum',
			mapping : 'approvalSum'
		},
		            		 	      {
			name : 'storeproductinfodetail.approvalMoneyMoneyShow',
			mapping : 'approvalMoneyMoneyShow'
		},
		            		 	      {
			name : 'storeproductinfodetail.reserveSum',
			mapping : 'reserveSum'
		},
		            		 	      {
			name : 'storeproductinfodetail.reserveMoneyMoneyShow',
			mapping : 'reserveMoneyMoneyShow'
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
					id : 'storeproductinfodetail.purchaseSum',
					name : 'storeproductinfodetail.purchaseSum',
					fieldLabel : ' 库存数量',
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
					id : 'storeproductinfodetail.purchaseMoneyMoneyShow',
					name : 'storeproductinfodetail.purchaseMoneyMoneyShow',
					fieldLabel : ' 库存金额',
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
					id : 'storeproductinfodetail.planInStoreSum',
					name : 'storeproductinfodetail.planInStoreSum',
					fieldLabel : ' 计划入库数量',
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
					id : 'storeproductinfodetail.planInStoreMoneyMoneyShow',
					name : 'storeproductinfodetail.planInStoreMoneyMoneyShow',
					fieldLabel : '  计划入库金额',
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
					id : 'storeproductinfodetail.planOutStoreSum',
					name : 'storeproductinfodetail.planOutStoreSum',
					fieldLabel : ' 计划出库数量',
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
					id : 'storeproductinfodetail.planOutStoreMoneyMoneyShow',
					name : 'storeproductinfodetail.planOutStoreMoneyMoneyShow',
					fieldLabel : ' 计划出库金额',
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
					id : 'storeproductinfodetail.approvalSum',
					name : 'storeproductinfodetail.approvalSum',
					fieldLabel : ' 审批出库数量',
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
					id : 'storeproductinfodetail.approvalMoneyMoneyShow',
					name : 'storeproductinfodetail.approvalMoneyMoneyShow',
					fieldLabel : ' 审批出库金额',
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
					id : 'storeproductinfodetail.reserveSum',
					name : 'storeproductinfodetail.reserveSum',
					fieldLabel : ' 预留数量',
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
					id : 'storeproductinfodetail.reserveMoneyMoneyShow',
					name : 'storeproductinfodetail.reserveMoneyMoneyShow',
					fieldLabel : ' 预留金额',
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