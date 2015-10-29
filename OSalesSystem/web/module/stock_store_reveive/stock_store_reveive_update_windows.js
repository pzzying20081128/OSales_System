function stock_store_reveive_update_windows(moduleId, moduleName, params) {

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

	var stock_store_reveive_params = {
		title : "编辑" + moduleName,
		action : "update",
		grid : grid,
		// 结果路径
		pojo : "result",
		// url
		url : './simple_StockStoreReceive_update.do',
		params : {
			optType : "update",
			"stockstorereceive.id" : selectId
		},
		reader : new Ext.data.JsonReader({
			successProperty : 'success',
			root : 'result',
			totalProperty : 'totalProperty'
		}, [{
			name : 'stockstorereceive.providerInfo',
			mapping : 'providerInfo'
		}, 
		{
		    name:"stockstorereceive.providerInfo.name",
		    mapping : 'providerInfo.name'
		    
		},
				{
			name : 'stockstorereceive.providerInfoId',
			mapping : 'providerInfoId'
		}, {
			name : 'stockstorereceive.taxSumMoneyMoneyShow',
			mapping : 'taxSumMoneyMoneyShow'
		}, {
			name : 'stockstorereceive.noTaxSumMoneyMoneyShow',
			mapping : 'noTaxSumMoneyMoneyShow'
		}, {
			name : 'stockstorereceive.orderCount',
			mapping : 'orderCount'
		}, {
			name : 'stockstorereceive.stockType',
			mapping : 'stockType'
		}, {
			name : 'stockstorereceive.remarks',
			mapping : 'remarks'
		}, {
			name : 'stockstorereceive.text',
			mapping : 'text'
		}, {
			name : 'stockstorereceive.checkMan',
			mapping : 'checkMan'
		}, {
			name : 'stockstorereceive.checkManId',
			mapping : 'checkManId'
		}, {
			name : 'stockstorereceive.checkDate',
			mapping : 'checkDate'
		}, {
			name : 'stockstorereceive.recordMan',
			mapping : 'recordMan'
		}, {
			name : 'stockstorereceive.recordManId',
			mapping : 'recordManId'
		}, {
			name : 'stockstorereceive.recordDate',
			mapping : 'recordDate'
		}, {
			name : 'stockstorereceive.number',
			mapping : 'number'
		}, {
			name : 'stockstorereceive.status',
			mapping : 'status'
		}, {
			name : 'stockstorereceive.stockInStore',
			mapping : "stockInStore"
		}, {
			name : 'stockstorereceive.stockInStore.number',
			mapping : "stockInStore.number"
		}]),
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

					id : 'stockstorereceive.stockInStore.number',
					name : 'stockstorereceive.stockInStore.number',
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
					id : 'stockstorereceive.number',
					name : 'stockstorereceive.number',
					fieldLabel : ' 采购进货单号',
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
					id : 'stockstorereceive.providerInfo.name',
					name : 'stockstorereceive.providerInfo.name',
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

					id : 'stockstorereceive.orderCount',
					name : 'stockstorereceive.orderCount',
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
					id : 'stockstorereceive.taxSumMoneyMoneyShow',
					name : 'stockstorereceive.taxSumMoneyMoneyShow',
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
					id : 'stockstorereceive.noTaxSumMoneyMoneyShow',
					name : 'stockstorereceive.noTaxSumMoneyMoneyShow',
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
					id : 'stockstorereceive.status',
					name : 'stockstorereceive.status',
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
					id : 'stockstorereceive.text',
					name : 'stockstorereceive.text',
					fieldLabel : '  备注',
					xtype : 'textfield',
					style : NoAllowBlankStyle,
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
					id : 'stockstorereceive.remarks',
					name : 'stockstorereceive.remarks',
					fieldLabel : ' 说明',
					xtype : 'textfield',
					style : NoAllowBlankStyle,
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

	var stock_store_reveive_create_window = new stock_store_reveive_save_update_form_panel_windows(stock_store_reveive_params);

	stock_store_reveive_create_window.load({
		url : './simple_StockStoreReceive_get.do?uuid=' + selectId,
		success : function(result) {
			json = result.result;
		}
	});

}