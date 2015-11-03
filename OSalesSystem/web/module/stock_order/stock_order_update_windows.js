function stock_order_update_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();

	var selection_rows = grid.getSelectionModel().getSelections();
	
	if(!stockOpptCheck(selection_rows, "编辑","有效"))return ;

//	if (selection_rows == null) {
//		showErrorMsg('提示信息', '请选择要编辑的数据记录！！');
//		return false;
//	}
//
//	if (selection_rows.length != 1) {
//		showErrorMsg('提示信息', '编辑只能选择一行数据记录！！');
//		return false;
//	}
//	
//	if ( selection_rows[0].data.status !='有效') {
//		showErrorMsg('提示信息', '本条信息的状态是['+selection_rows[0].data.status+']不能编辑'  );
//		return false;
//	}
	
	var selectId = selection_rows[0].id;

	providerInfo = createERPcombo({
		id : 'stockorder.providerInfoId',
		name : 'stockorder.providerInfoId',
		fieldLabel : ' 供应商',
		url : "./ProviderInfo_combo.do?searchBean.status=有效",
		allowBlank : false,
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
	});
	providerInfo.load({
		params : {
			"searchBean.id" : selection_rows[0].data.providerInfoId
		}
	});

	stockMan = createERPcombo({
		id : 'stockorder.stockManId',
		name : 'stockorder.stockManId',
		fieldLabel : ' 采购员',
		url : "./SysStaff_combo.do?searchBean.status=有效",
		allowBlank : true,
		forceSelection : false,
		width : 160
	});
	stockMan.load({
		params : {
			"searchBean.id" : selection_rows[0].data.stockManId
		}
	});

	var stock_order_params = {
		title : "编辑" + moduleName,
		action : "update",
		grid : grid,
		// 结果路径
		pojo : "result",
		// url
		url : './simple_StockOrder_save.do',
		params : {
			optType : "update",
			'stockorder.id' : selectId
		},
		reader : new Ext.data.JsonReader({
			successProperty : 'success',
			root : 'result',
			totalProperty : 'totalProperty'
		}, [{
			name : 'stockorder.number',
			mapping : 'number'
		}, {
			name : 'stockorder.providerInfo',
			mapping : 'providerInfo'
		}, {
			name : 'stockorder.providerInfoId',
			mapping : 'providerInfoId'
		}, {
			name : 'stockorder.stockMan',
			mapping : 'stockMan'
		}, {
			name : 'stockorder.stockManId',
			mapping : 'stockManId'
		}, {
			name : 'stockorder.orderDate',
			mapping : 'orderDate'
		}, {
			name : 'stockorder.stockDate',
			mapping : 'stockDate'
		}, {
			name : 'stockorder.taxSumMoneyMoneyShow',
			mapping : 'taxSumMoneyMoneyShow'
		}, {
			name : 'stockorder.noTaxSumMoneyMoneyShow',
			mapping : 'noTaxSumMoneyMoneyShow'
		}, {
			name : 'stockorder.orderCount',
			mapping : 'orderCount'
		}, {
			name : 'stockorder.text',
			mapping : 'text'
		}, {
			name : 'stockorder.checkMan',
			mapping : 'checkMan'
		}, {
			name : 'stockorder.checkManId',
			mapping : 'checkManId'
		}, {
			name : 'stockorder.checkDate',
			mapping : 'checkDate'
		}, {
			name : 'stockorder.stockType',
			mapping : 'stockType'
		}, {
			name : 'stockorder.recordMan',
			mapping : 'recordMan'
		}, {
			name : 'stockorder.recordManId',
			mapping : 'recordManId'
		}, {
			name : 'stockorder.status',
			mapping : 'status'
		},]),
		// 字段
		field : [{// 第一排
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
					id : 'stockorder.number',
					name : 'stockorder.number',
					fieldLabel : ' 订单编号',
					xtype : 'textfield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
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
					width : 180
				},
				items : [createLocalCombo({
					id : 'stockorder.stockType',
					name : 'stockorder.stockType',
					fieldLabel : ' 订单类型',
					storeData : [['采购订单', "采购订单"], ['直营采购订单', '直营采购订单']],
					defaultValue : null,
					allowBlank : false
				})]
			}, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'stockorder.orderDate',
					name : 'stockorder.orderDate',
					fieldLabel : ' 订单日期',
					xtype : 'datefield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					format : 'Y-m-d',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {

						}
					}
				}]
			},]
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
					width : 455
				},
				items : [providerInfo]
			},

			{
				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [stockMan]
			}]
		}, {// 第二排
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
					id : 'stockorder.taxSumMoneyMoneyShow',
					name : 'stockorder.taxSumMoneyMoneyShow',
					fieldLabel : ' 含税总金额',
					xtype : 'ERPShowText',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'stockorder.noTaxSumMoneyMoneyShow',
					name : 'stockorder.noTaxSumMoneyMoneyShow',
					fieldLabel : ' 没税总金额',
					xtype : 'ERPShowText',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, {

				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'stockorder.stockDate',
					name : 'stockorder.stockDate',
					fieldLabel : ' 采购日期',
					xtype : 'datefield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					format : 'Y-m-d',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {

						}
					}
				}]
			}]
		}, {// 第二排
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
					id : 'stockorder.orderCount',
					name : 'stockorder.orderCount',
					fieldLabel : ' 订购数量',
					xtype : 'ERPShowText',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
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
					width : 180
				},
				items : [{
					id : 'stockorder.stockManId1',
					name : 'stockorder.stockManId1',
					fieldLabel : ' 合同',
					xtype : 'ERPShowText',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}// 1-2end
			]
		}, {
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 70,
			items : [{
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 725
				},
				items : [{
					id : 'stockorder.text',
					name : 'stockorder.text',
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

		]

	}

	var stock_order_create_window = new stock_order_save_update_form_panel_windows(stock_order_params);

	// stock_order_create_window.loadform(selection_rows[0].data);

	stock_order_create_window.load({
		url : './simple_StockOrder_get.do?uuid=' + selectId,
		success : function(result) {
			json = result.result;
		}
	});

}