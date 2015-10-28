function stock_in_store_update_windows(moduleId, moduleName, params) {

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

	var stock_in_store_params = {
		title : "编辑" + moduleName,
		action : "update",
		grid : grid,
		// 结果路径
		pojo : "result",
		// url
		url : "./simple_StockInStore_update.do",
		params : {
			optType : "update",
			'stockinstore.id' : selectId
		},
		reader : new Ext.data.JsonReader({
			successProperty : 'success',
			root : 'result',
			totalProperty : 'totalProperty'
		}, [{
			name : 'stockinstore.stockOrder.orderNumber',
			mapping : 'stockOrder.orderNumber'
		}, {
			name : 'stockinstore.number',
			mapping : 'number'
		}, {
			name : "stockinstore.providerInfo.name",
			mapping : 'providerInfo.name'

		}, {
			name : 'stockinstore.providerInfo',
			mapping : 'providerInfo'
		}, {
			name : 'stockinstore.providerInfoId',
			mapping : 'providerInfoId'
		}, {
			name : 'stockinstore.taxSumMoneyMoneyShow',
			mapping : 'taxSumMoneyMoneyShow'
		}, {
			name : 'stockinstore.noTaxSumMoneyMoneyShow',
			mapping : 'noTaxSumMoneyMoneyShow'
		}, {
			name : 'stockinstore.orderCount',
			mapping : 'orderCount'
		}, {
			name : 'stockinstore.remarks',
			mapping : 'remarks'
		}, {
			name : 'stockinstore.text',
			mapping : 'text'
		}, {
			name : 'stockinstore.checkMan',
			mapping : 'checkMan'
		}, {
			name : 'stockinstore.checkManId',
			mapping : 'checkManId'
		}, {
			name : 'stockinstore.checkDate',
			mapping : 'checkDate'
		}, {
			name : 'stockinstore.recordMan',
			mapping : 'recordMan'
		}, {
			name : 'stockinstore.recordManId',
			mapping : 'recordManId'
		}, {
			name : 'stockinstore.recordDate',
			mapping : 'recordDate'
		}, {
			name : 'stockinstore.status',
			mapping : 'status'
		},

		]),
		// 字段
		field : [{// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{// 1-1
				columnWidth : 0.5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [{

					id : 'stockinstore.stockOrder.orderNumber',
					name : 'stockinstore.stockOrder.orderNumber',
					fieldLabel : ' 采购订单号',
					xtype : 'ERPShowText',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			} // 1-1 end
			, {// 1-1
				columnWidth : 0.5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [{
					id : 'stockinstore.number',
					name : 'stockinstore.number',
					fieldLabel : ' 采购入库单号',
					xtype : 'ERPShowText',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}]
		}, {// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{// 1-1
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 496
				},
				items : [{
					id : 'stockinstore.providerInfo.name',
					name : 'stockinstore.providerInfo.name',
					fieldLabel : ' 供应商',
					xtype : 'ERPShowText',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}]
		}, {
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{
				// 1-1
				columnWidth : 0.5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [{

					id : 'stockinstore.orderCount',
					name : 'stockinstore.orderCount',
					fieldLabel : ' 订购数量',
					xtype : 'ERPShowText',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, {
				columnWidth : 0.5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [{
					id : 'stockinstore.taxSumMoneyMoneyShow',
					name : 'stockinstore.taxSumMoneyMoneyShow',
					fieldLabel : ' 含税总金额',
					xtype : 'ERPShowText',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}

			]

		}, {
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{
				// 1-1
				columnWidth : 0.5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [{
					id : 'stockinstore.noTaxSumMoneyMoneyShow',
					name : 'stockinstore.noTaxSumMoneyMoneyShow',
					fieldLabel : ' 没税总金额',
					xtype : 'ERPShowText',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, {
				columnWidth : 0.5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [{
					id : 'stockinstore.status',
					name : 'stockinstore.status',
					fieldLabel : ' 状态',
					xtype : 'ERPShowText',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}]
		}, {// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{// 1-1
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 496
				},
				items : [{
					id : 'stockinstore.text',
					name : 'stockinstore.text',
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
		}, {// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{// 1-1
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 496
				},
				items : [{
					id : 'stockinstore.remarks',
					name : 'stockinstore.remarks',
					fieldLabel : ' 说明',
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

	var stock_in_store_create_window = new stock_in_store_save_update_form_panel_windows(stock_in_store_params);

	stock_in_store_create_window.load({
		url : './simple_StockInStore_get.do?uuid=' + selectId,
		success : function(result) {
			json = result.result;
		}
	});

}