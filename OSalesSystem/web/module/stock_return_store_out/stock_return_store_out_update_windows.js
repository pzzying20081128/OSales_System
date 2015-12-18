function stock_return_store_out_update_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();

	var selection_rows = grid.getSelectionModel().getSelections();

	if (selection_rows == null) {
		showErrorMsg('提示信息', '请选择要编辑的数据记录！！');
		return false;
	}

	if (selection_rows.length != 1) {
		showErrorMsg('提示信息', '编辑只能选择一行数据记录！！');
		return false;
	}
	var selectId = selection_rows[0].id;

	var stock_return_store_out_params = {
		title : "编辑" + moduleName,
		action : "update",
		grid : grid,
		// 结果路径
		pojo : "result",
		// url
		url : './simple_StockReturnStoreOut_save.do',
		params : {
			optType : "update",
			"stockreturnstoreout.id" : selectId
		},
		reader : new Ext.data.JsonReader({
			successProperty : 'success',
			root : 'result',
			totalProperty : 'totalProperty'
		}, [{
			name : 'stockreturnstoreout.number',
			mapping : 'number'
		}, {
			name : 'stockreturnstoreout.stockReturn.number',
			mapping : 'stockReturn.number'
		}, {
			name : 'stockreturnstoreout.stockType',
			mapping : 'stockReturn.stockType'
		}, {
			name : "stockreturnstoreout.providerInfo.name",
			mapping : "providerInfo.name"
		}, {
			name : "stockreturnstoreout.outStoreDate",
			mapping : "outStoreDate"
		}, {
			name : "stockreturnstoreout.taxSumMoneyMoneyShow",
			mapping : "taxSumMoneyMoneyShow"
		}, {
			name : "stockreturnstoreout.noTaxSumMoneyMoneyShow",
			mapping : "noTaxSumMoneyMoneyShow"
		}, {
			name : "stockreturnstoreout.orderCount",
			mapping : "orderCount"
		}, {
			name : "stockreturnstoreout.remarks",
			mapping : "remarks"
		}, 
		{
			name : "stockreturnstoreout.text",
			mapping : "text" 
		},
				{
			name : 'stockreturnstoreout.stockMan.name',
			mapping : 'stockMan.name'
		}]),
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
					id : 'stockreturnstoreout.number',
					name : 'stockreturnstoreout.number',
					fieldLabel : ' 出库单编号',
					xtype : 'textfield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
					// value : initOrder.number,
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
					id : 'stockreturnstoreout.stockReturn.number',
					name : 'stockreturnstoreout.stockReturn.number',
					fieldLabel : '退货单编号',
					xtype : 'ERPShowText',
					blankText : '不能为空！',
					allowBlank : false,
					// value : initOrder.number,
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

					id : 'stockreturnstoreout.stockType',
					name : 'stockreturnstoreout.stockType',
					fieldLabel : ' 退货单类型',
					xtype : 'ERPShowText',
					blankText : '不能为空！',
					allowBlank : false,
					// value : initOrder.number,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}

				}]
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
					width : 468
				},
				items : [{
					id : 'stockreturnstoreout.providerInfo.name',
					name : 'stockreturnstoreout.providerInfo.name',
					fieldLabel : '供应商',
					xtype : 'ERPShowText',
					blankText : '不能为空！',
					allowBlank : false,
					// value : initOrder.number,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}

				}]
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
					id : 'stockreturnstoreout.outStoreDate',
					name : 'stockreturnstoreout.outStoreDate',
					fieldLabel : ' 退货日期',
					xtype : 'datefield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					format : 'Y-m-d',
					allowBlank : false,
					// value : new Date(),
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
					id : 'stockreturnstoreout.taxSumMoneyMoneyShow',
					name : 'stockreturnstoreout.taxSumMoneyMoneyShow',
					fieldLabel : ' 含税总金额',
					xtype : 'ERPShowText',
					// style : AllowBlankStyle,
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
					id : 'stockreturnstoreout.noTaxSumMoneyMoneyShow',
					name : 'stockreturnstoreout.noTaxSumMoneyMoneyShow',
					fieldLabel : ' 没税总金额',
					xtype : 'ERPShowText',
					// style : AllowBlankStyle,
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
					id : 'stockreturnstoreout.stockMan.name',
					name : 'stockreturnstoreout.stockMan.name',
					fieldLabel : '采购员',
					xtype : 'ERPShowText',
					blankText : '不能为空！',
					allowBlank : false,
					// value : initOrder.number,
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
					id : 'stockreturnstoreout.orderCount',
					name : 'stockreturnstoreout.orderCount',
					fieldLabel : ' 退货数量',
					xtype : 'ERPShowText',
					// style : AllowBlankStyle,
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
					id : 'stockreturnstoreout.stockManId1',
					name : 'stockreturnstoreout.stockManId1',
					fieldLabel : ' 合同',
					xtype : 'ERPShowText',
					// style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}// 1-2end
			, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : []
			}]
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
					width : 758
				},
				items : [{
					id : 'stockreturnstoreout.text',
					name : 'stockreturnstoreout.text',
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
					width : 758
				},
				items : [{
					id : 'stockreturnstoreout.remarks',
					name : 'stockreturnstoreout.remarks',
					fieldLabel : '说明',
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

	var stock_return_store_out_create_window = new stock_return_store_out_save_update_form_panel_windows(stock_return_store_out_params);

	stock_return_store_out_create_window.load({
		url : './simple_StockReturnStoreOut_get.do?uuid=' + selectId,
		success : function(result) {
			json = result.result;
		}
	});

}