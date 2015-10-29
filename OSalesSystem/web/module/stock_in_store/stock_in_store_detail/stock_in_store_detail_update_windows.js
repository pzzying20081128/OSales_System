function stock_in_store_detail_update_windows(moduleId, moduleName, params) {

	var mainData = params.mainData;

	var grid = params.grid.getGrid();

	var mainGrid = params.mainGrid;

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

	productInfo = createERPcombo({
		id : 'stockInstoredetail.productInfoId',
		name : 'stockInstoredetail.productInfoId',
		fieldLabel : '入库产品',
		url : "./ProductInfo_detailscombo.do?selectype=productInfo",
		params : {
			'searchBean.status' : '有效'
		},
		allowBlank : false,
		forceSelection : false,

		select : function(combo, record, index) {
			orderCount.setValue(null);
			orderBox.setValue(null);
			taxMoneyMoneyShow.setValue(null);
			noTaxMoneyMoneyShow.setValue(null);
			productInfoSelect = record.json;
			ERPAjaxRequest({
				url : "./simple_ProductInfo_selectStockPrice.do",
				params : {
					'providerInfoId' : mainData.data.providerInfoId,
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
					orderCount.productInfo = productInfo;
					orderBox.productInfo = productInfo;
					if (productInfo_e.isBox) {
						orderCount.setReadOnly(true);
						orderCount.getEl().setStyle("background", AllowBlankColor);
						orderBox.setReadOnly(false);
						orderBox.getEl().setStyle("background", NoAllowBlankColor);
					} else {
						orderCount.setReadOnly(false);
						orderCount.getEl().setStyle("background", NoAllowBlankColor);
						orderBox.setReadOnly(true);
						orderBox.getEl().setStyle("background", AllowBlankColor);
					}

					// ///////////////////////////////////////////////////////////////
				}
			});

		}
	});

	productInfo.load({
		params : {
			'searchBean.id' : selection_rows[0].data.productInfoId
		},
		success : function(data) {
			var productInfo_ = data[0].json;
			productInfo.productInfo = productInfo_;
			ProductInfobarCode.setValue(productInfo_.barCode);
			maxStockPrice.setValue(productInfo_.maxStockPriceMoneyShow);
			baseUnitBoxUnit.setValue(productInfo_.baseUnitBoxUnit);
		}
	});

	ProductInfobarCode = new Ext.form.ERPShowTextField({

		fieldLabel : ' 条形码',
		xtype : 'ERPShowText',
		style : AllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}

	});

	maxStockPrice = new Ext.form.ERPShowTextField({

		fieldLabel : '最高采购价',
		xtype : 'ERPShowText',
		style : AllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	baseUnitBoxUnit = new Ext.form.ERPShowTextField({

		fieldLabel : '单位',
		xtype : 'ERPShowText',
		style : AllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	storeInfoId = createERPcombo({
		id : 'stockInstoredetail.storeInfoId',
		name : 'stockInstoredetail.storeInfoId',
		fieldLabel : '入库仓库',
		url : "./StoreInfo_combo.do?searchBean.status=有效",
		style : NoAllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		select : function(combo, record, index) {
			id = record.id;
			storePositionId.clear();
			storePositionId.load({
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

	storePositionId = createERPcombo({
		id : 'stockInstoredetail.storePositionId',
		name : 'stockInstoredetail.storePositionId',
		fieldLabel : '入库库位',
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
			'searchBean.id' : selection_rows[0].data.storeInfoId
		},
		success : function() {
			storePositionId.load({
				params : {
					'searchBean.id' : selection_rows[0].data.storePositionId,
					"searchBean.storeInfoId" : selection_rows[0].data.storeInfoId
				}
			});
		}
	});

	taxPriceMoneyShow = new Ext.form.TextField({
		id : 'stockInstoredetail.taxPriceMoneyShow',
		name : 'stockInstoredetail.taxPriceMoneyShow',
		fieldLabel : '采购单价',
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

	noTaxPriceMoneyShow = new Ext.form.TextField({
		id : 'stockInstoredetail.noTaxPriceMoneyShow',
		name : 'stockInstoredetail.noTaxPriceMoneyShow',
		fieldLabel : '末税采购单价',
		xtype : 'textfield',
		vtype : 'money',
		style : NoAllowBlankStyle,
		blankText : '不能为空！',
		labelStyle : "font-size:11px",
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	taxRateTaxRateShow = new Ext.form.TextField({
		id : 'stockInstoredetail.taxRateTaxRateShow',
		name : 'stockInstoredetail.taxRateTaxRateShow',
		fieldLabel : '税率',
		xtype : 'textfield',
		vtype : 'money',
		style : AllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		readOnly : true,
		editable : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	orderCount = new Ext.form.TextField(

	{
		id : 'stockInstoredetail.orderCount',
		name : 'stockInstoredetail.orderCount',
		fieldLabel : '订购数量',
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
	orderBox = new Ext.form.TextField({
		id : 'stockInstoredetail.orderBox',
		name : 'stockInstoredetail.orderBox',
		fieldLabel : '订购箱数',
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

	taxMoneyMoneyShow = new Ext.form.ERPShowTextField({
		id : 'stockInstoredetail.taxMoneyMoneyShow',
		name : 'stockInstoredetail.taxMoneyMoneyShow',
		fieldLabel : '采购金额',
		xtype : 'ERPShowText',
		style : NoAllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {

			}
		}
	});
	noTaxMoneyMoneyShow = new Ext.form.ERPShowTextField({
		id : 'stockInstoredetail.noTaxMoneyMoneyShow',
		name : 'stockInstoredetail.noTaxMoneyMoneyShow',
		fieldLabel : '未税金额',
		xtype : 'ERPShowText',
		style : NoAllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var stock_in_store_detail_params = {
		title : "编辑" + moduleName,
		action : "update",
		grid : grid,
		mainGrid : mainGrid,
		// 结果路径
		pojo : "result",
		// url
		url : './simple_StockInStoreDetail_saveUpdate.do',
		params : {
			optType : "update",
			"stockInstoredetail.id" : selectId
		},
		reader : new Ext.data.JsonReader({
			successProperty : 'success',
			root : 'result',
			totalProperty : 'totalProperty'
		}, [{
			name : 'stockinstoredetail.stockOrder.productInfoName',
			mapping : 'stockOrderDetail.productInfo.name'
		}, {
			name : 'stockInstoredetail.productInfoId',
			mapping : 'productInfoId'
		}, {
			name : 'stockInstoredetail.taxPriceMoneyShow',
			mapping : 'taxPriceMoneyShow'
		}, {
			name : 'stockInstoredetail.taxRateTaxRateShow',
			mapping : 'taxRateTaxRateShow'
		}, {
			name : 'stockInstoredetail.taxMoneyMoneyShow',
			mapping : 'taxMoneyMoneyShow'
		}, {
			name : 'stockInstoredetail.noTaxPriceMoneyShow',
			mapping : 'noTaxPriceMoneyShow'
		}, {
			name : 'stockInstoredetail.noTaxMoneyMoneyShow',
			mapping : 'noTaxMoneyMoneyShow'
		}, {
			name : 'stockInstoredetail.orderCount',
			mapping : 'orderCount'
		}, {
			name : 'stockInstoredetail.orderBox',
			mapping : 'orderBox'
		}, {
			name : 'stockInstoredetail.text',
			mapping : 'text'
		}, {
			name : 'stockInstoredetail.storeInfoId',
			mapping : 'storeInfoId'
		}, {
			name : 'stockInstoredetail.storePositionId',
			mapping : 'storePositionId'
		}

		]),
		// 字段
		field : [{// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 70,
			items : [{// 1-1
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 412
				},
				items : [{
					id : 'stockinstoredetail.stockOrder.productInfoName',
					// name : 'stockinstoredetail.productInfo',
					fieldLabel : '采购产品',
					xtype : 'ERPShowText',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}]
		},

		{
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
					width : 710
				},
				items : [{
					id : 'stockInstoredetail.text',
					name : 'stockInstoredetail.text',
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

		}

		]

	}

	var stock_in_store_detail_create_window = new stock_in_store_detail_save_update_form_panel_windows(stock_in_store_detail_params);

	stock_in_store_detail_create_window.load({
		url : './simple_StockInStoreDetail_get.do?uuid=' + selectId,
		success : function(result) {
			json = result.result.result;
			taxPriceMoneyShow.setValue(json.taxPriceMoneyShow);
			noTaxPriceMoneyShow.setValue(json.noTaxPriceMoneyShow);
			taxRateTaxRateShow.setValue(json.taxRateTaxRateShow);
			productInfo.productInfo = json.productInfo;

			if (productInfo.productInfo.isBox) {
				orderCount.setReadOnly(true);
				orderCount.getEl().setStyle("background", AllowBlankColor);
				orderBox.setReadOnly(false);
				orderBox.getEl().setStyle("background", NoAllowBlankColor);
			} else {
				orderCount.setReadOnly(false);
				orderCount.getEl().setStyle("background", NoAllowBlankColor);
				orderBox.setReadOnly(true);
				orderBox.getEl().setStyle("background", AllowBlankColor);
			}
		}
	});

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
}