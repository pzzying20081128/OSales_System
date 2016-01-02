//
//	      {
//			name : 'stockadjustbill.providerInfo',
//			mapping : 'providerInfo'
//		},
//		            		 	      		 	      {
//			name : 'stockadjustbill.stockMan',
//			mapping : 'stockMan'
//		},
//		            		 	      		 	      {
//			name : 'stockadjustbill.adjustSubject',
//			mapping : 'adjustSubject'
//		},
//		            		 	      {
//			name : 'stockadjustbill.adjustType',
//			mapping : 'adjustType'
//		},
//		            		 	      {
//			name : 'stockadjustbill.adjustDate',
//			mapping : 'adjustDate'
//		},
//		            		 	      {
//			name : 'stockadjustbill.adjustSum',
//			mapping : 'adjustSum'
//		},
//		            		 	      {
//			name : 'stockadjustbill.adjustSumMoneyShow',
//			mapping : 'adjustSumMoneyShow'
//		},
//		            		 	      {
//			name : 'stockadjustbill.adjustSumMoneyHide',
//			mapping : 'adjustSumMoneyHide'
//		},
//		            		 	      {
//			name : 'stockadjustbill.text',
//			mapping : 'text'
//		},
//		            		 	      {
//			name : 'stockadjustbill.checkMan',
//			mapping : 'checkMan'
//		},
//		            		 	      		 	      {
//			name : 'stockadjustbill.recordMan',
//			mapping : 'recordMan'
//		},
//		            		 	      {
//			name : 'stockadjustbill.status',
//			mapping : 'status'
//		},
//		            		 
//
//	      	      // ----------------------------------------------------------------------//
//			  {
//                columnWidth : .33,
//				layout : 'form',
//				defaultType : 'textfield',
//				baseCls : 'x-plain',
//				defaults : {
//					width : 250
//				},
//				items : [{
//					id : 'stockadjustbill.providerInfo',
//					name : 'stockadjustbill.providerInfo',
//					fieldLabel : ' 供应商',
//					xtype : 'textfield',
//					style : NoAllowBlankStyle,
//					blankText : '不能为空！',
//					allowBlank : false,
//					listeners : {
//						'specialkey' : function(field, e) {
//						}
//					}
//				}]
//			  },
//            		 	      		 	      	      // ----------------------------------------------------------------------//
//			  {
//                columnWidth : .33,
//				layout : 'form',
//				defaultType : 'textfield',
//				baseCls : 'x-plain',
//				defaults : {
//					width : 250
//				},
//				items : [{
//					id : 'stockadjustbill.stockMan',
//					name : 'stockadjustbill.stockMan',
//					fieldLabel : ' 采购员',
//					xtype : 'textfield',
//					style : NoAllowBlankStyle,
//					blankText : '不能为空！',
//					allowBlank : false,
//					listeners : {
//						'specialkey' : function(field, e) {
//						}
//					}
//				}]
//			  },
//            		 	      		 	      	      // ----------------------------------------------------------------------//
//			  {
//                columnWidth : .33,
//				layout : 'form',
//				defaultType : 'textfield',
//				baseCls : 'x-plain',
//				defaults : {
//					width : 250
//				},
//				items : [{
//					id : 'stockadjustbill.adjustSubject',
//					name : 'stockadjustbill.adjustSubject',
//					fieldLabel : ' 调整科目',
//					xtype : 'textfield',
//					style : NoAllowBlankStyle,
//					blankText : '不能为空！',
//					allowBlank : false,
//					listeners : {
//						'specialkey' : function(field, e) {
//						}
//					}
//				}]
//			  },
//            		 	      	      // ----------------------------------------------------------------------//
//			  {
//                columnWidth : .25,
//				layout : 'form',
//				defaultType : 'textfield',
//				baseCls : 'x-plain',
//				defaults : {
//					width : 250
//				},
//				items : [{
//					id : 'stockadjustbill.adjustType',
//					name : 'stockadjustbill.adjustType',
//					fieldLabel : ' 调整类型',
//					xtype : 'textfield',
//					style : NoAllowBlankStyle,
//					blankText : '不能为空！',
//					allowBlank : false,
//					listeners : {
//						'specialkey' : function(field, e) {
//						}
//					}
//				}]
//			  },
//            		 	      	      // ----------------------------------------------------------------------//
//			  {
//                columnWidth : .25,
//				layout : 'form',
//				defaultType : 'textfield',
//				baseCls : 'x-plain',
//				defaults : {
//					width : 250
//				},
//				items : [{
//					id : 'stockadjustbill.adjustDate',
//					name : 'stockadjustbill.adjustDate',
//					fieldLabel : ' 调整日期',
//					xtype : 'textfield',
//					style : NoAllowBlankStyle,
//					blankText : '不能为空！',
//					allowBlank : false,
//					listeners : {
//						'specialkey' : function(field, e) {
//						}
//					}
//				}]
//			  },
//            		 	      	      // ----------------------------------------------------------------------//
//			  {
//                columnWidth : .25,
//				layout : 'form',
//				defaultType : 'textfield',
//				baseCls : 'x-plain',
//				defaults : {
//					width : 250
//				},
//				items : [{
//					id : 'stockadjustbill.adjustSum',
//					name : 'stockadjustbill.adjustSum',
//					fieldLabel : ' 调整金额',
//					xtype : 'textfield',
//					style : NoAllowBlankStyle,
//					blankText : '不能为空！',
//					allowBlank : false,
//					listeners : {
//						'specialkey' : function(field, e) {
//						}
//					}
//				}]
//			  },
//            		 	      	      // ----------------------------------------------------------------------//
//			  {
//                columnWidth : .25,
//				layout : 'form',
//				defaultType : 'textfield',
//				baseCls : 'x-plain',
//				defaults : {
//					width : 250
//				},
//				items : [{
//					id : 'stockadjustbill.adjustSumMoneyShow',
//					name : 'stockadjustbill.adjustSumMoneyShow',
//					fieldLabel : ' 调整金额',
//					xtype : 'textfield',
//					style : NoAllowBlankStyle,
//					blankText : '不能为空！',
//					allowBlank : false,
//					listeners : {
//						'specialkey' : function(field, e) {
//						}
//					}
//				}]
//			  },
//            		 	      	      // ----------------------------------------------------------------------//
//			  {
//                columnWidth : .25,
//				layout : 'form',
//				defaultType : 'textfield',
//				baseCls : 'x-plain',
//				defaults : {
//					width : 250
//				},
//				items : [{
//					id : 'stockadjustbill.adjustSumMoneyHide',
//					name : 'stockadjustbill.adjustSumMoneyHide',
//					fieldLabel : ' 调整金额',
//					xtype : 'textfield',
//					style : NoAllowBlankStyle,
//					blankText : '不能为空！',
//					allowBlank : false,
//					listeners : {
//						'specialkey' : function(field, e) {
//						}
//					}
//				}]
//			  },
//            		 	      	      // ----------------------------------------------------------------------//
//			  {
//                columnWidth : .25,
//				layout : 'form',
//				defaultType : 'textfield',
//				baseCls : 'x-plain',
//				defaults : {
//					width : 250
//				},
//				items : [{
//					id : 'stockadjustbill.text',
//					name : 'stockadjustbill.text',
//					fieldLabel : ' 备注',
//					xtype : 'textfield',
//					style : NoAllowBlankStyle,
//					blankText : '不能为空！',
//					allowBlank : false,
//					listeners : {
//						'specialkey' : function(field, e) {
//						}
//					}
//				}]
//			  },
//            		 	      	      // ----------------------------------------------------------------------//
//			  {
//                columnWidth : .25,
//				layout : 'form',
//				defaultType : 'textfield',
//				baseCls : 'x-plain',
//				defaults : {
//					width : 250
//				},
//				items : [{
//					id : 'stockadjustbill.checkMan',
//					name : 'stockadjustbill.checkMan',
//					fieldLabel : ' 采购员',
//					xtype : 'textfield',
//					style : NoAllowBlankStyle,
//					blankText : '不能为空！',
//					allowBlank : false,
//					listeners : {
//						'specialkey' : function(field, e) {
//						}
//					}
//				}]
//			  },
//            		 	      		 	      	      // ----------------------------------------------------------------------//
//			  {
//                columnWidth : .25,
//				layout : 'form',
//				defaultType : 'textfield',
//				baseCls : 'x-plain',
//				defaults : {
//					width : 250
//				},
//				items : [{
//					id : 'stockadjustbill.recordMan',
//					name : 'stockadjustbill.recordMan',
//					fieldLabel : ' 录入人',
//					xtype : 'textfield',
//					style : NoAllowBlankStyle,
//					blankText : '不能为空！',
//					allowBlank : false,
//					listeners : {
//						'specialkey' : function(field, e) {
//						}
//					}
//				}]
//			  },
//            		 	      	      // ----------------------------------------------------------------------//
//			  {
//                columnWidth : .25,
//				layout : 'form',
//				defaultType : 'textfield',
//				baseCls : 'x-plain',
//				defaults : {
//					width : 250
//				},
//				items : [{
//					id : 'stockadjustbill.status',
//					name : 'stockadjustbill.status',
//					fieldLabel : ' 状态',
//					xtype : 'textfield',
//					style : NoAllowBlankStyle,
//					blankText : '不能为空！',
//					allowBlank : false,
//					listeners : {
//						'specialkey' : function(field, e) {
//						}
//					}
//				}]
//			  },
//            		 
//
//// 1-1
