function stock_return_detail_create_windows(moduleId, moduleName, params) {

	var mainGrid = params.mainGrid;

	var detailGrid = params.detailGrid;

	var mainGridData = mainGrid.getSelectionModel().getSelections()[0].data;
	mainGridData.id = mainGrid.getSelectionModel().getSelections()[0].id;

	function computeCountMoney() {
		if (productInfo.getValue() == null || productInfo.getValue() == "请输入查询值")
			return;
		{
			productInfo_ = productInfo.productInfo;
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

	// var productInfo_e;

	var productInfo = createERPcombo({
		id : 'stockreturndetail.productInfoId',
		name : 'stockreturndetail.productInfoId',
		fieldLabel : ' 退货产品',
		url : "./ProductInfo_detailscombo.do?selectype=productInfo",
		params : {
			'searchBean.status' : '有效',
			'searchBean.providerInfoId' : mainGridData.providerInfoId,
			'searchBean.productInfoType' : mainGridData.stockProductType
		},
		allowBlank : false,
		forceSelection : false,

		select : function(results) { // combo, record, index

			var productInfoSelect = results.record.json;
			ERPAjaxRequest({
				url : "./simple_ProductInfo_selectStockPrice.do",
				params : {
					'providerInfoId' : mainGridData.providerInfoId,
					'uuid' : productInfoSelect.id
				},
				// async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
				success : function(result) {
					productInfo_e = result.result.result;
					productInfo.productInfo = productInfo_e;
					storeInfoId.load({
						params : {
							'searchBean.id' : productInfo_e.storeInfoId
						},
						success : function() {
							storeInfoId.setValue(productInfo_e.storeInfoId);
							storePositionId.load({
								params : {
									'searchBean.storeInfoId' : productInfo_e.storeInfoId
								},
								success : function() {
									storePositionId.setValue(productInfo_e.storePositionId);
								}
							});
						}
					})
					// /////////////////////////////////////////////////////////////////
					ProductInfobarCode.setValue(productInfo_e.barCode);
					maxStockPrice.setValue(productInfo_e.maxStockPriceMoneyShow);
					baseUnitBoxUnit.setValue(productInfo_e.baseUnitBoxUnit);
					taxPriceMoneyShow.setValue(productInfo_e.stockPriceMoneyShow);
					noTaxPriceMoneyShow.setValue(productInfo_e.stockNoTaxPriceMoneyShow);
					taxRateTaxRateShow.setValue(productInfo_e.stockTaxRateTaxRateShow);
					orderCount.setValue(null);
					orderBox.setValue(null);
					if (productInfo_e.isBox) {
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

					// ///////////////////////////////////////////////////////////////
				}
			});

		}
	});

	var ProductInfobarCode = new Ext.form.ERPShowTextField({

		fieldLabel : ' 条形码',
		xtype : 'ERPShowText',
		// style : AllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}

	});

	var maxStockPrice = new Ext.form.ERPShowTextField({

		fieldLabel : '最高采购价',
		xtype : 'ERPShowText',
		style : showBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var baseUnitBoxUnit = new Ext.form.ERPShowTextField({

		fieldLabel : '单位',
		xtype : 'ERPShowText',
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var storeInfoId = createERPcombo({
		id : 'stockreturndetail.storeInfoId',
		name : 'stockreturndetail.storeInfoId',
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
		id : 'stockreturndetail.storePositionId',
		name : 'stockreturndetail.storePositionId',
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

	var taxPriceMoneyShow = new Ext.form.TextField({
		id : 'stockreturndetail.taxPriceMoneyShow',
		name : 'stockreturndetail.taxPriceMoneyShow',
		fieldLabel : '退货单价',
		xtype : 'textfield',
		vtype : 'money',
		style : NoAllowBlankStyle,
		enableKeyEvents : true,
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'keyup' : function(field, e) {
				computeCountMoney();
			}
		}
	});

	var noTaxPriceMoneyShow = new Ext.form.ERPShowEditText({
		id : 'stockreturndetail.noTaxPriceMoneyShow',
		name : 'stockreturndetail.noTaxPriceMoneyShow',
		fieldLabel : '末税采购单价',
		vtype : 'money',
		blankText : '不能为空！',
		labelStyle : "font-size:11px",
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var taxRateTaxRateShow = new Ext.form.TextField({
		id : 'stockreturndetail.taxRateTaxRateShow',
		name : 'stockreturndetail.taxRateTaxRateShow',
		fieldLabel : '税率',
		xtype : 'textfield',
		vtype : 'money',
		style : showBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		readOnly : true,
		editable : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var orderCount = new Ext.form.TextField(

	{
		id : 'stockreturndetail.orderCount',
		name : 'stockreturndetail.orderCount',
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
		id : 'stockreturndetail.orderBox',
		name : 'stockreturndetail.orderBox',
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

	var taxMoneyMoneyShow = new Ext.form.ERPShowTextField({
		fieldLabel : '退货金额',
		xtype : 'ERPShowText',
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {

			}
		}
	});
	var noTaxMoneyMoneyShow = new Ext.form.ERPShowTextField({
		fieldLabel : '未税金额',
		xtype : 'ERPShowText',
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var stock_return_detail_params = {
		title : "新增" + moduleName,
		action : "save",
		grid : detailGrid,
		mainGrid : mainGrid,
		// 结果路径
		pojo : "result",
		// url
		url : './simple_StockReturnDetail_saveUpdate.do',
		params : {
			optType : "save",
			'stockreturndetail.stockReturnId' : mainGridData.id

		},
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
					width : 412
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
				items : [ProductInfobarCode]
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
				items : [maxStockPrice]
			}, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 145
				},
				items : [taxPriceMoneyShow]
			}, {
				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 179
				},
				items : [noTaxPriceMoneyShow]
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
				items : [taxRateTaxRateShow]
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
				items : [noTaxMoneyMoneyShow]
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
					width : 688
				},
				items : [{
					id : 'stockreturndetail.text',
					name : 'stockreturndetail.text',
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

	var stock_return_detail_create_window = new stock_return_detail_save_update_form_panel_windows(stock_return_detail_params);

}