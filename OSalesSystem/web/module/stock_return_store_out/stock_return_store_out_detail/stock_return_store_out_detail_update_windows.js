function stock_return_store_out_detail_update_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();

	var mainMGrid = params.mainMGrid;

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

	var baseUnitBoxUnit = new Ext.form.ERPShowTextField({

		fieldLabel : '单位',
		xtype : 'ERPShowText',
		name : "baseUnitBoxUnit",
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var productInfo = new Ext.form.ERPShowTextField({
		id : 'stockreturnstoreoutdetail.productInfo.name',
		name : 'stockreturnstoreoutdetail.productInfo.name',
		fieldLabel : '退货产品',
		xtype : 'ERPShowText',
		blankText : '不能为空！',
		allowBlank : false,
		// value : initOrder.number,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var taxPriceMoneyShow = new Ext.form.ERPShowTextField({
		id : 'stockreturnstoreoutdetail.taxPriceMoneyShow',
		name : 'stockreturnstoreoutdetail.taxPriceMoneyShow',
		fieldLabel : '退货单价',
		xtype : 'ERPShowText',
		vtype : 'money',

		enableKeyEvents : true,
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'keyup' : function(field, e) {
				computeCountMoney();
			}
		}
	});

	var taxMoneyMoneyShow = new Ext.form.ERPShowTextField({
		fieldLabel : '退货金额',
		xtype : 'ERPShowText',
		name : "stockreturnstoreoutdetail.taxMoneyMoneyShow",
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {

			}
		}
	});

	var noTaxPriceMoneyShow = new Ext.form.ERPShowTextField({
		id : 'stockreturnstoreoutdetail.noTaxPriceMoneyShow',
		name : 'stockreturnstoreoutdetail.noTaxPriceMoneyShow',
		fieldLabel : '末税单价',
		xtype : 'ERPShowText',
		vtype : 'money',

		enableKeyEvents : true,
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'keyup' : function(field, e) {
				computeCountMoney();
			}
		}
	});

	var noTaxMoneyMoneyShow = new Ext.form.ERPShowTextField({
		fieldLabel : '末税金额',
		xtype : 'ERPShowText',
		name : "stockreturnstoreoutdetail.noTaxMoneyMoneyShow",
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {

			}
		}
	});

	var taxRateTaxRateShow = new Ext.form.ERPShowTextField({
		id : 'stockreturnstoreoutdetail.taxRateTaxRateShow',
		name : 'stockreturnstoreoutdetail.taxRateTaxRateShow',
		fieldLabel : '税率',
		xtype : 'ERPShowText',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var orderCount = new Ext.form.TextField(

	{
		id : 'stockreturnstoreoutdetail.orderCount',
		name : 'stockreturnstoreoutdetail.orderCount',
		fieldLabel : '退货数量',
		xtype : 'textfield',
		style : NoAllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		allowBlank : false,
		readOnly : true,
		enableKeyEvents : true,
		listeners : {
			'keyup' : function(field, e) {
				computeCountMoney()
			}
		}
	});
	var orderBox = new Ext.form.TextField({
		id : 'stockreturnstoreoutdetail.orderBox',
		name : 'stockreturnstoreoutdetail.orderBox',
		fieldLabel : '退货箱数',
		xtype : 'textfield',
		style : NoAllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		allowBlank : false,
		readOnly : true,
		enableKeyEvents : true,
		listeners : {
			'keyup' : function(field, e) {
				computeCountMoney()
			}
		}
	});

	var storeInfoId = createERPcombo({
		id : 'stockreturnstoreoutdetail.storeInfoId',
		name : 'stockreturnstoreoutdetail.storeInfoId',
		fieldLabel : '出库仓库',
		url : "./StoreInfo_combo.do?searchBean.status=有效",
		style : NoAllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		select : function(combo, record, index) {
			id = record.id;
			storePosition.load({
				params : {
					'searchBean.storeInfoId' : id
				}

			});
		},
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var storePositionId = createERPcombo({
		id : 'stockreturnstoreoutdetail.storePositionId',
		name : 'stockreturnstoreoutdetail.storePositionId',
		fieldLabel : '出库库位',
		url : "./StorePosition_combo.do?searchBean.status=有效",
		style : NoAllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	storeInfoId.load({
		params : {
			'searchBean.id' : selection_rows[0].storeInfoId
		},
		success : function() {
			storePositionId.load({
				params : {
					'searchBean.id' : selection_rows[0].storePositionId,
					'searchBean.storeInfoId' : selection_rows[0].storeInfoId
				}
			});
		}
	});

	var stock_return_store_out_detail_params = {
		title : "编辑" + moduleName,
		action : "update",
		grid : grid,
		mainMGrid : mainMGrid,
		// 结果路径
		pojo : "result",
		// url
		url : './simple_StockReturnStoreOutDetail_saveUpdate.do',
		params : {
			optType : "update",
			"stockreturnstoreoutdetail.id" : selectId
		},
		reader : new Ext.data.JsonReader({
			successProperty : 'success',
			root : 'result',
			totalProperty : 'totalProperty'
		}, [{
			name : 'stockreturnstoreoutdetail.productInfo.name',
			mapping : 'productInfo.name'
		}, {
			name : "baseUnitBoxUnit",
			mapping : 'productInfo.baseUnitBoxUnit'
		}, {
			name : "stockreturnstoreoutdetail.productInfo.barCode",
			mapping : 'productInfo.barCode'
		}, {
			name : "stockreturnstoreoutdetail.taxPriceMoneyShow",
			mapping : 'taxPriceMoneyShow'
		}, {
			name : "stockreturnstoreoutdetail.taxMoneyMoneyShow",
			mapping : 'taxMoneyMoneyShow'
		}, {
			name : "stockreturnstoreoutdetail.noTaxPriceMoneyShow",
			mapping : 'noTaxPriceMoneyShow'
		}, {
			name : "stockreturnstoreoutdetail.noTaxMoneyMoneyShow",
			mapping : 'noTaxMoneyMoneyShow'
		}, {
			name : "stockreturnstoreoutdetail.orderCount",
			mapping : "orderCount"
		}, {
			name : "stockreturnstoreoutdetail.orderBox",
			mapping : "orderBox"
		}, {
			name : "stockreturnstoreoutdetail.taxRateTaxRateShow",
			mapping : "taxRateTaxRateShow"
		}, {
			name : "stockreturnstoreoutdetail.storeInfoId",
			mapping : "storeInfoId"
		}, {
			name : "stockreturnstoreoutdetail.storePositionId",
			mapping : "storePositionId"
		}]),
		// 字段
		field : [{
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 70,
			items : [{
				columnWidth : .66,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 432
				},
				items : [productInfo]
			}, {
				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 179
				},
				items : [{
					id : 'stockreturnstoreoutdetail.productInfo.barCode',
					name : 'stockreturnstoreoutdetail.productInfo.barCode',
					fieldLabel : '条形码',
					xtype : 'ERPShowText',
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
			labelWidth : 70,
			items : [{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 140
				},
				items : [taxPriceMoneyShow]
			}, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 145
				},
				items : [taxMoneyMoneyShow]
			}, {
				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 179
				},
				items : [taxRateTaxRateShow]
			}]

		}, {
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 70,
			items : [{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 140
				},
				items : [noTaxPriceMoneyShow]
			}, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 145
				},
				items : [noTaxMoneyMoneyShow]
			}, {
				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 179
				},
				items : [baseUnitBoxUnit]
			}]

		}, {
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 70,
			items : [{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 140
				},
				items : [orderCount]
			}, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 145
				},
				items : [orderBox]
			}, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 179
				},
				items : []
			}]

		}, {
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 70,
			items : [{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 140
				},
				items : [storeInfoId]
			}, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 145
				},
				items : [storePositionId]
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
					width : 750
				},
				items : [{
					// id : 'stockorderdetail.taxPriceMoneyShow',
					// name : 'stockorderdetail.taxPriceMoneyShow',
					fieldLabel : '备注',
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
		}]

	}

	var stock_return_store_out_detail_create_window = new stock_return_store_out_detail_save_update_form_panel_windows(stock_return_store_out_detail_params);

	stock_return_store_out_detail_create_window.load({
		url : './simple_StockReturnStoreOutDetail_get.do?uuid=' + selectId,
		success : function(result) {
			json = result.result.result;
			productInfo.productInfo = json.productInfo;
			if (productInfo.productInfo.isBox) {
				orderCount.setReadOnly(true);
				orderCount.getEl().setStyle("background", showBlankColor);
				orderBox.setReadOnly(false);
				orderBox.getEl().setStyle("background", NoAllowBlankColor);
			} else {
				orderCount.setReadOnly(false);
				orderCount.getEl().setStyle("background", NoAllowBlankColor);
				orderBox.setReadOnly(true);
				orderBox.getEl().setStyle("background", showBlankColor);
			}
		}
	});

	function computeCountMoney() {
		if (productInfo.getValue() == null || productInfo.getValue() == "请输入查询值")
			return;
		{
			var productInfo_ = productInfo.productInfo;
			var orderCount_;
			if (productInfo_.isBox) {
				box = orderBox.getValue();
				orderCount_ = productInfo.productInfo.boxCount * box;
				orderCount.setValue(orderCount_);
			} else {
				orderCount_ = orderCount.getValue();
				if (orderCount_ != null && orderCount_ != "") {
					boxCount = switchBoxCount(orderCount_, productInfo_);
					orderBox.setValue(boxCount);
				}

			}

			// 计算不含税单价//
			var taxRateTaxRate = taxRateTaxRateShow.getValue();
			var taxPriceMoney = taxPriceMoneyShow.getValue();
			if (taxRateTaxRate === '' || taxPriceMoney === '')
				noTaxPriceMoneyShow.setValue(null);
			else {
				var xx = taxPriceMoney * ( 100 - taxRateTaxRate ) / 100;
				noTaxPriceMoneyShow.setValue(retention_accuracy(xx));
			}

			if (orderCount_ != null && orderCount_ != "") {

				boxMoney = taxPriceMoneyShow.getValue() * orderCount_;

				noboxMoney = noTaxPriceMoneyShow.getValue() * orderCount_;

				taxMoneyMoneyShow.setValue(retention_accuracy(boxMoney));

				noTaxMoneyMoneyShow.setValue(retention_accuracy(noboxMoney));
			}

		}
	}

}