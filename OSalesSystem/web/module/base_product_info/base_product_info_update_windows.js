function base_product_info_update_windows(moduleId, moduleName, params) {

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

	providerInfoId = selection_rows[0].data.providerInfoId;

	var providerInfoCombo = createERPcombo({
		id : 'productinfo.providerInfoId',
		name : 'productinfo.providerInfoId',
		fieldLabel : ' 供应商',
		url : "./ProviderInfo_combo.do?searchBean.status=有效",
		allowBlank : false,
		forceSelection : false
	});

	providerInfoCombo.load({
		params : {
			"searchBean.id" : providerInfoId
		}
	});

	storeInfo = createERPcombo({
		id : 'productinfo.storeInfoId',
		name : 'productinfo.storeInfoId',
		fieldLabel : ' 仓库',
		url : "./StoreInfo_combo.do?searchBean.status=有效",
		allowBlank : false,
		forceSelection : false,
		select : function(combo, record, index) {
			id = record.id;
			storePosition.load({
				params : {
					'searchBean.storeInfoId' : id,
					'searchBean.status' : '有效'
				}

			});
		}
	});
	storeInfo.load({
		params : {
			"searchBean.id" : selection_rows[0].data.storeInfoId
		}
	});

	var storePosition = createERPcombo({
		id : 'productinfo.storePositionId',
		name : 'productinfo.storePositionId',
		fieldLabel : ' 库位',
		url : "./StorePosition_combo.do",
		allowBlank : false,
		forceSelection : false,
		select : function(combo, record, index) {

		}
	});
	storePosition.load({
		params : {
			'searchBean.storeInfoId' : selection_rows[0].data.storeInfoId,
			'searchBean.status' : '有效',
			'searchBean.id' : selection_rows[0].data.storePositionId
		}
	});

	var productBrand = createERPcombo({
		id : 'productinfo.productBrandId',
		name : 'productinfo.productBrandId',
		fieldLabel : ' 品牌',
		url : "./ProductBrand_combo.do?searchBean.status=有效",
		allowBlank : false,
		forceSelection : false,
		select : function(combo, record, index) {
		}
	});

	productBrand.load({
		params : {
			'searchBean.status' : '有效',
			'searchBean.id' : selection_rows[0].data.productBrandId
		}
	});

	var productCategory = createERPcombo({
		id : 'productinfo.productCategoryId',
		name : 'productinfo.productCategoryId',
		fieldLabel : ' 产品类型',
		url : "./ProductCategory_combo.do?searchBean.status=有效",
		allowBlank : false,
		forceSelection : false
	});

	productCategory.load({
		params : {
			'searchBean.status' : '有效',
			'searchBean.id' : selection_rows[0].data.productCategoryId
		}
	});

	var maxStockPriceMoneyShow = new Ext.form.TextField({
		id : 'productinfo.maxStockPriceMoneyShow',
		name : 'productinfo.maxStockPriceMoneyShow',
		fieldLabel : ' 采购价',
		// xtype : 'textfield',
		style : NoAllowBlankStyle,
		blankText : '不能为空！',
		enableKeyEvents : true,
		allowBlank : false,
		vtype : 'money',
		listeners : {
			keyup : function() {

				var maxStockPriceMoney = maxStockPriceMoneyShow.getValue();
				var salesTaxPriceMoney = salesTaxPriceMoneyShow.getValue();
				if (maxStockPriceMoney === '' || salesTaxPriceMoney === '')
					grossProfitRateTaxRateShow.setValue(null);
				else {
					var xx = ( Math.round( ( salesTaxPriceMoney - maxStockPriceMoney ) / salesTaxPriceMoney * 10000) / 100.00 ); // 小数点后两位百分比
					grossProfitRateTaxRateShow.setValue(xx);
				}
			}
		}
	});

	var salesTaxPriceMoneyShow = new Ext.form.TextField({
		id : 'productinfo.salesTaxPriceMoneyShow',
		name : 'productinfo.salesTaxPriceMoneyShow',
		fieldLabel : ' 销售价',
		xtype : 'textfield',
		style : NoAllowBlankStyle,
		blankText : '不能为空！',
		vtype : 'money',
		enableKeyEvents : true,
		allowBlank : false,
		listeners : {
			keyup : function(field, e) {

				var maxStockPriceMoney = maxStockPriceMoneyShow.getValue();
				var salesTaxPriceMoney = salesTaxPriceMoneyShow.getValue();
				if (maxStockPriceMoney === '' || salesTaxPriceMoney === '')
					grossProfitRateTaxRateShow.setValue(null);
				else {
					var xx1 = ( Math.round( ( salesTaxPriceMoney - maxStockPriceMoney ) / salesTaxPriceMoney * 10000) / 100.00 ); // 小数点后两位百分比
					grossProfitRateTaxRateShow.setValue(xx1);

				}
				// //////////////////////////////////////////////////////////////////////
				var salesTaxRateTaxRate = this.getValue();
				var salesTaxPriceMoney = salesTaxPriceMoneyShow.getValue();
				if (salesTaxRateTaxRate === '' || salesTaxPriceMoney === '')
					salesNoTaxPriceMoneyShow.setValue(null);
				else {
					var xx = salesTaxPriceMoney * ( 100 - salesTaxRateTaxRate ) / 100;
					salesNoTaxPriceMoneyShow.setValue(xx.toFixed(2));
				}

				// /////////////////////////////////////////////////////////////////////
				boxCount_ = boxCount.getValue();
				{

					salesTaxPriceMoney = salesTaxPriceMoneyShow.getValue();

					if (salesTaxPriceMoney === '' || boxCount_ === '') {
						salesBoxTaxPriceMoneyShow.setValue(null);
					} else {
						salesBoxTaxPriceMoney = boxCount_ * salesTaxPriceMoney;
						salesBoxTaxPriceMoneyShow.setValue(salesBoxTaxPriceMoney.toFixed(2));
					}

				}
				{
					salesNoTaxPriceMoney = salesNoTaxPriceMoneyShow.getValue();

					if (salesNoTaxPriceMoney === '' || boxCount_ === '') {
						salesBoxNoTaxMoneyShow.setValue(null);
					} else {
						salesBoxNoTaxMoney = ( boxCount_ * salesNoTaxPriceMoney );
						salesBoxNoTaxMoneyShow.setValue(salesBoxNoTaxMoney.toFixed(2));
					}
				}

				// ///////////////////////////////////////////////////////////////////////
			}
		}
	});

	var salesTaxRateTaxRateShow = new Ext.form.TextField({
		id : 'productinfo.salesTaxRateTaxRateShow',
		name : 'productinfo.salesTaxRateTaxRateShow',
		fieldLabel : ' 销售税率',
		xtype : 'textfield',
		vtype : 'money',
		style : NoAllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		value : '17.00',
		enableKeyEvents : true,
		listeners : {
			'keyup' : function(field, e) {
				var salesTaxRateTaxRate = this.getValue();
				var salesTaxPriceMoney = salesTaxPriceMoneyShow.getValue();
				if (salesTaxRateTaxRate === '' || salesTaxPriceMoney === '')
					salesNoTaxPriceMoneyShow.setValue(null);
				else {
					var xx = salesTaxPriceMoney * ( 100 - salesTaxRateTaxRate ) / 100;
					salesNoTaxPriceMoneyShow.setValue(xx.toFixed(2));
				}
			}
		}
	});

	var grossProfitRateTaxRateShow = new Ext.form.TextField({

		id : 'productinfo.grossProfitRateTaxRateShow',
		name : 'productinfo.grossProfitRateTaxRateShow',
		fieldLabel : ' 毛利率',
		vtype : 'money',
		xtype : 'textfield',
		style : AllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : true,
		editable : false,
		readOnly : true,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}

	});

	var salesNoTaxPriceMoneyShow = new Ext.form.TextField({
		id : 'productinfo.salesNoTaxPriceMoneyShow',
		name : 'productinfo.salesNoTaxPriceMoneyShow',
		fieldLabel : ' 末含税单价',
		xtype : 'textfield',
		style : AllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : true,
		editable : false,
		readOnly : true,

		listeners : {
			'keyup' : function(field, e) {

			}
		}
	});

	var salesBoxTaxPriceMoneyShow = new Ext.form.ERPShowTextField({
		id : 'productinfo.salesBoxTaxPriceMoneyShow',
		name : 'productinfo.salesBoxTaxPriceMoneyShow',
		fieldLabel : ' 含税箱销售价',
		xtype : 'textfield',
		vtype : 'money',
		style : AllowBlankStyle,
		labelStyle : "font-size:12px",
		blankText : '不能为空！',
		allowBlank : false,
		enableKeyEvents : true,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var salesBoxNoTaxMoneyShow = new Ext.form.ERPShowTextField({
		id : 'productinfo.salesBoxNoTaxPriceMoneyShow',
		name : 'productinfo.salesBoxNoTaxPriceMoneyShow',
		fieldLabel : ' 末税箱销售价',
		xtype : 'ERPShowText',
		style : AllowBlankStyle,
		labelStyle : "font-size:12px",
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var boxCount = new Ext.form.TextField({
		id : 'productinfo.boxCount',
		name : 'productinfo.boxCount',
		fieldLabel : ' 箱/件裝量',
		xtype : 'textfield',
		style : NoAllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		enableKeyEvents : true,
		listeners : {
			'keyup' : function(field, e) {
				boxCount_ = boxCount.getValue();
				{
					salesTaxPriceMoney = salesTaxPriceMoneyShow.getValue();

					if (salesTaxPriceMoney === '' || boxCount_ === '') {
						salesBoxTaxPriceMoneyShow.setValue(null);
					} else {
						salesBoxTaxPriceMoney = ( boxCount_ * salesTaxPriceMoney );
						salesBoxTaxPriceMoneyShow.setValue(salesBoxTaxPriceMoney.toFixed(2));
					}
				}

				{
					salesNoTaxPriceMoney = salesNoTaxPriceMoneyShow.getValue();

					if (salesNoTaxPriceMoney === '' || boxCount_ === '') {
						salesBoxNoTaxMoneyShow.setValue(null);
					} else {
						salesBoxNoTaxMoney = ( boxCount_ * salesNoTaxPriceMoney );
						salesBoxNoTaxMoneyShow.setValue(salesBoxNoTaxMoney.toFixed(2));
					}
				}

			}
		}
	});

	var base_product_info_params = {
		title : "编辑" + moduleName,
		action : "update",
		grid : grid,
		// 结果路径
		// 结果路径
		pojo : "result",
		// url
		url : './simple_ProductInfo_save.do',
		params : {
			optType : "update",
			"productinfo.id" : selectId
		},
		reader : new Ext.data.JsonReader({
			successProperty : 'success',
			root : 'result',
			totalProperty : 'totalProperty'
		}, [{
			name : 'productinfo.productCategoryId',
			mapping : 'productCategoryId'
		}, {
			name : 'productinfo.shortName',
			mapping : 'shortName'
		}, {
			name : 'productinfo.name',
			mapping : 'name'
		}, {
			name : 'productinfo.model',
			mapping : 'model'
		}, {
			name : 'productinfo.barCode',
			mapping : 'barCode'
		}, {
			name : 'productinfo.baseUnit',
			mapping : 'baseUnit'
		}, {
			name : 'productinfo.boxCount',
			mapping : 'boxCount'
		}, {
			name : 'productinfo.boxUnit',
			mapping : 'boxUnit'
		}, {
			name : 'productinfo.isBox',
			mapping : 'isBox'
		}, {
			name : 'productinfo.providerInfoId',
			mapping : 'providerInfoId'
		}, {
			name : 'productinfo.maxStockPriceMoneyShow',
			mapping : 'maxStockPriceMoneyShow'
		}, {
			name : 'productinfo.salesTaxPriceMoneyShow',
			mapping : 'salesTaxPriceMoneyShow'
		}, {
			name : 'productinfo.grossProfitRateTaxRateShow',
			mapping : 'grossProfitRateTaxRateShow'
		}, {
			name : 'productinfo.stockTaxRateTaxRateShow',
			mapping : 'stockTaxRateTaxRateShow'
		}, {
			name : 'productinfo.salesTaxRateTaxRateShow',
			mapping : 'salesTaxRateTaxRateShow'
		}, {
			name : 'productinfo.salesNoTaxPriceMoneyShow',
			mapping : 'salesNoTaxPriceMoneyShow'
		}, {
			name : 'productinfo.salesBoxTaxPriceMoneyShow',
			mapping : 'salesBoxTaxPriceMoneyShow'
		}, {
			name : 'productinfo.salesBoxNoTaxPriceMoneyShow',
			mapping : 'salesBoxNoTaxPriceMoneyShow'
		}, {
			name : 'productinfo.shelfLife',
			mapping : 'shelfLife'
		}, {
			name : 'productinfo.lastStockTaxPriceMoneyShow',
			mapping : 'lastStockTaxPriceMoneyShow'
		}, {
			name : 'productinfo.lastSalesTaxPriceMoneyShow',
			mapping : 'lastSalesTaxPriceMoneyShow'
		}, {
			name : 'productinfo.text',
			mapping : 'text'
		}, {
			name : 'productinfo.productBrandId',
			mapping : 'productBrandId'
		}, {
			name : 'productinfo.storeInfoId',
			mapping : 'storeInfoId'
		}, {
			name : 'productinfo.storePositionId',
			mapping : 'storePositionId'
		}, {
			name : 'productinfo.productInfoType',
			mapping : 'productInfoType'
		}]),
		// 字段
		field : [{
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'productinfo.name',
					name : 'productinfo.name',
					fieldLabel : ' 产品名称',
					xtype : 'textfield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
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
					id : 'productinfo.shortName',
					name : 'productinfo.shortName',
					fieldLabel : ' 助记符',
					xtype : 'textfield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, {
				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				labelWidth : 80,
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [{
					id : 'productinfo.barCode',
					name : 'productinfo.barCode',
					fieldLabel : ' 条码',
					xtype : 'textfield',
					style : NoAllowBlankStyle,
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
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [productCategory]
			}, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [storeInfo]
			}, {
				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				labelWidth : 80,
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [storePosition]
			}]

		},

		// /////////////////////////////
		{
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{
				columnWidth : .66,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 478
				},
				items : [{
					id : 'productinfo.model',
					name : 'productinfo.model',
					fieldLabel : ' 规格',
					xtype : 'textfield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, {
				columnWidth : .34,
				labelWidth : 80,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [createLocalCombo({
					id : 'productinfo.isBox',
					name : 'productinfo.isBox',
					fieldLabel : ' 是否以箱下单',
					storeData : [['1', "是"], ['0', '否']],
					defaultValue : 1,
					allowBlank : true
				})]
			}]
		}, {
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{
				columnWidth : .66,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 478
				},
				items : [providerInfoCombo]
			}, {

				columnWidth : .34,
				labelWidth : 80,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [

				createERPcombo({
					id : 'productinfo.baseUnit',
					name : 'productinfo.baseUnit',
					fieldLabel : ' 基本单位',
					url : "./ProductInfo_combo.do?selectype=baseUnit",
					allowBlank : false,
					forceSelection : false,
					select : function(combo, record, index) {
					}
				})

				]

			}

			]
		},
		// //////////////////////////////////////////////////////////////////////////////////////////////
		{
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [productBrand]
			}, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [boxCount]
			},
			// ----------------------------------------------------------------------//
			{
				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [createERPcombo({
					id : 'productinfo.boxUnit',
					name : 'productinfo.boxUnit',
					fieldLabel : ' 箱/件裝单位',
					url : "./ProductInfo_combo.do?selectype=boxUnit",
					allowBlank : false,
					forceSelection : false,
					select : function(combo, record, index) {
					}
				})]
			}]

		},

		{// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{

				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [maxStockPriceMoneyShow]

			}, {

				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [salesTaxPriceMoneyShow]

			}, {
				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [grossProfitRateTaxRateShow]
			}]
		}, {
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'productinfo.stockTaxRateTaxRateShow',
					name : 'productinfo.stockTaxRateTaxRateShow',
					fieldLabel : ' 采购税率',
					xtype : 'textfield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
					value : '17.00',
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
				items : [salesTaxRateTaxRateShow]
			}, {

				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [salesNoTaxPriceMoneyShow]

			}]
		}, {
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{

				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [salesBoxTaxPriceMoneyShow]

			}, {

				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [salesBoxNoTaxMoneyShow]

			}, {

				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [{
					id : 'productinfo.shelfLife',
					name : 'productinfo.shelfLife',
					fieldLabel : ' 保质期',
					xtype : 'textfield',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]

			}

			]

		}

		, {
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{

				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'productinfo.lastStockTaxPriceMoneyShow',
					name : 'productinfo.lastStockTaxPriceMoneyShow',
					fieldLabel : ' 最后采购价',
					xtype : 'ERPShowText',
					style : AllowBlankStyle,
//					labelStyle : "font-size:10px",
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
					id : 'productinfo.lastSalesTaxPriceMoneyShow',
					name : 'productinfo.lastSalesTaxPriceMoneyShow',
					fieldLabel : ' 最后销售价',
					xtype : 'ERPShowText',
					style : AllowBlankStyle,
//					labelStyle : "font-size:10px",
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]

			},
			{
				
				

				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
						width : 200
				},
				items : [{
					id : 'productinfo.productInfoType',
					name : 'productinfo.productInfoType',
					fieldLabel : '产品类型',
					xtype : 'ERPShowText',
					style : AllowBlankStyle,
//					labelStyle : "font-size:11px",
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]

			
			
			}

			]
		}, {// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 795
				},
				items : [{
					id : 'productinfo.text',
					name : 'productinfo.text',
					fieldLabel : ' 备注',
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

	var base_product_info_create_window = new base_product_info_save_update_form_panel_windows(base_product_info_params);

	base_product_info_create_window.load({
		url : './simple_ProductInfo_get.do?uuid=' + selectId,
		success : function(result) {
			json = result.result;
		}
	});

}