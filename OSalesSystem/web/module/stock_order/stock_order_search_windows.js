function stock_order_search_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();
	var search_params = params.searchParams;
	var form_panel = new Ext.form.ERPFormPanel({
		// height : 400,
		// autoHeight : false,
// labelWidth : 60,
		items : [{// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 70,
			items : [{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'searchBean.OrderNumber',
					name : 'searchBean.OrderNumber',
					fieldLabel : ' 订单编号',
					xtype : 'textfield',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					// value:order.orderNumber,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, // 1-1 end
			{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 188
				},
				items : [createERPlocalBoxSelect({
					id : 'searchBean.stockTypes',
					name : 'searchBean.stockTypes',
					fieldLabel : ' 订单类型',
					localdata : [['采购订单', "采购订单"], ['直营采购订单', '直营采购订单']],
					defaultValue : null,
					allowBlank : true
				})]
			}, {
			 columnWidth : .33,
			 layout : 'form',
			 defaultType : 'textfield',
			 baseCls : 'x-plain',
			 defaults : {
			 width : 188
			 },
			 items : [
			 createERPlocalBoxSelect({
					id : 'searchBean.stockProductTypes',
					name : 'searchBean.stockProductTypes',
					fieldLabel : ' 采购类型',
					defaultValue : null,
					localdata :[['普通产品', "普通产品"], ['组合产品', '组合产品']],
					defaultValue : null,
					allowBlank : true
				})
			 ]
			}]
		},
		// ////////////////////////////////////////////////////////
		{// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 70,
			items : [{
				columnWidth : .66,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 462
				},
				items : [createERPBoxSelect({
					id : 'searchBean.providerInfoIds',
					name : 'searchBean.providerInfoIds',
					fieldLabel : ' 供应商',
					url : "./ProviderInfo_combo.do?searchBean.status=有效",
					allowBlank : true,
					forceSelection : false
					// select : function(combo, record, index) {
					// id = record.id;
					// storePosition.load({
					// params : {
					// 'searchBean.storeInfoId' : id,
					// 'searchBean.status' : '有效'
					// }
					//
					// });
					// }
				})]
			},

			{
				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'searchBean.stockManId1',
					name : 'searchBean.stockManId1',
					fieldLabel : ' 合同',
					xtype : 'ERPShowText',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				
			 
				}
				]
			}]
		}, {
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 70,
			items : [{// 1-1
				columnWidth : 0.33,
				layout : 'form',
				defaultType : 'checkbox',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'searchBean.startTime',
					name : 'searchBean.startTime',
					fieldLabel : ' 采购时间',
					xtype : 'datefield',
					format : 'Y-m-d',
					// style : NoAllowBlankStyle,
					// blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			},

			{// 1-1
				columnWidth : 0.33,
				layout : 'form',
				defaultType : 'checkbox',
				baseCls : 'x-plain',
				format : 'Y-m-d',
				 labelWidth : 70,
				defaults : {
					width : 180
				},
				items : [{
					id : 'searchBean.endTime',
					name : 'searchBean.endTime',
					fieldLabel : '     到',
					xtype : 'datefield',
					format : 'Y-m-d',
					// style : NoAllowBlankStyle,
					// blankText : '不能为空！',
					allowBlank : true,

					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}
			,{
				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [createERPcombo({
					id : 'searchBean.stockManId',
					name : 'searchBean.stockManId',
					fieldLabel : ' 采购员',
					url : "./SysStaff_combo.do?searchBean.status=全部",
					allowBlank : true,
					forceSelection : false,
					width : 160
				})]
			
			}
			
			]
		},  {
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 70,
			items : [{
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 727
				},
				items : [{
					id : 'searchBean.text',
					name : 'searchBean.text',
					fieldLabel : '  备注',
					xtype : 'textfield',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}]
		}

		],
		buttons : [{
			text : '提交',
			listeners : {
				'click' : function() {
					from = form_panel.getForm();
					if (!search_params.verification(from))
						return;
					grid.removeAll();
					if (from.isValid()) {
						var submitValues1 = from.getValues();
						// 对将要提交的参数进行过滤，去掉emptyText文字
						for (var param in submitValues1) {
							if (from.findField(param) && from.findField(param).emptyText == submitValues1[param]) {
								submitValues1[param] = '';
								// thisForm.findField(param).setValue("");
							}
						}

						Ext.apply(submitValues1, search_params.params());
						grid.load({
							params : submitValues1,
							success : function() {
								window.close();
							}
						});
						window.close();
					} else {
						showErrorMsg("错误", "请检查查询数据的正确性");
					}
				}
			}

		}, {
			text : '关闭',
			listeners : {
				'click' : function() {
					window.close();
				}
			}

		}]
	});

	var window = new Ext.ERPDefaultsWindow({
		title : "查询",
		closable : true,
		width : 860,
		height : 400,
		// autoHeight : false,

		items : [form_panel]
	});
	window.showWin();

}