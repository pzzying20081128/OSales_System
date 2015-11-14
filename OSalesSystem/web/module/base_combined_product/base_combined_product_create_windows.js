function base_combined_product_create_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();
    var detailGrid = params.grid.getDetailGrid();
	var storePosition = createERPcombo({
		id : 'combinedproduct.storePositionId',
		name : 'combinedproduct.storePositionId',
		fieldLabel : ' 库位',
		url : "./StorePosition_combo.do",
		allowBlank : false,
		forceSelection : false,
		select : function(combo, record, index) {

		}
	});

	var maxStockPriceMoneyShow = new Ext.form.ERPShowEditText({
		id : 'combinedproduct.maxStockPriceMoneyShow',
		name : 'combinedproduct.maxStockPriceMoneyShow',
		fieldLabel : ' 采购总价',
		// xtype : 'textfield',
//		style : AllowBlankStyle,
		blankText : '不能为空！',
		enableKeyEvents : false,
		allowBlank : true,
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

	var salesTaxPriceMoneyShow = new  Ext.form.ERPShowEditText({
		id : 'combinedproduct.salesTaxPriceMoneyShow',
		name : 'combinedproduct.salesTaxPriceMoneyShow',
		fieldLabel : ' 销售总价',
		xtype : 'textfield',
		blankText : '不能为空！',
		enableKeyEvents : false,
		allowBlank : true,
		vtype : 'money',
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
		id : 'combinedproduct.salesTaxRateTaxRateShow',
		name : 'combinedproduct.salesTaxRateTaxRateShow',
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

	var grossProfitRateTaxRateShow = new Ext.form.ERPShowEditText({

		id : 'combinedproduct.grossProfitRateTaxRateShow',
		name : 'combinedproduct.grossProfitRateTaxRateShow',
		fieldLabel : ' 毛利率',
		blankText : '不能为空！',
		enableKeyEvents : false,
		allowBlank : true,
		vtype : 'money',
		listeners : {
			'specialkey' : function(field, e) {
			}
		}

	});

	var salesNoTaxPriceMoneyShow = new Ext.form.ERPShowEditText({
		id : 'combinedproduct.salesNoTaxPriceMoneyShow',
		name : 'combinedproduct.salesNoTaxPriceMoneyShow',
		fieldLabel : ' 末税总单价',
		blankText : '不能为空！',
		allowBlank : true,
		listeners : {
			'keyup' : function(field, e) {

			}
		}
	});

	var salesBoxTaxPriceMoneyShow = new Ext.form.ERPShowEditText({
		id : 'combinedproduct.salesBoxTaxPriceMoneyShow',
		name : 'combinedproduct.salesBoxTaxPriceMoneyShow',
		fieldLabel : ' 含税箱销售价',
		xtype : 'ERPShowEditText',
		vtype : 'money',
		labelStyle : "font-size:12px",
		blankText : '不能为空！',
		allowBlank : true,
		enableKeyEvents : true,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var salesBoxNoTaxMoneyShow = new Ext.form.ERPShowEditText({
		id : 'combinedproduct.salesBoxNoTaxMoneyShow',
		name : 'combinedproduct.salesBoxNoTaxMoneyShow',
		fieldLabel : ' 末税箱销售价',
		labelStyle : "font-size:10px",
		xtype : 'ERPShowEditText',
		blankText : '不能为空！',
		allowBlank : true,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var boxCount = new Ext.form.TextField({
		id : 'combinedproduct.boxCount',
		name : 'combinedproduct.boxCount',
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

	var base_combined_product_params = {
		title : "新增" + moduleName,
		action : "save",
		grid : grid,
		// 结果路径
		pojo : "result",
		detailGrid:detailGrid,
		// url
		url : './simple_CombinedProduct_save.do',
		params : {
			optType : "save"
		},
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
					id : 'combinedproduct.name',
					name : 'combinedproduct.name',
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
					id : 'combinedproduct.shortName',
					name : 'combinedproduct.shortName',
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
					id : 'combinedproduct.barCode',
					name : 'combinedproduct.barCode',
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
				items : [createERPcombo({
					id : 'combinedproduct.productCategoryId',
					name : 'combinedproduct.productCategoryId',
					fieldLabel : ' 产品类型',
					url : "./ProductCategory_combo.do?searchBean.status=有效",
					allowBlank : false,
					forceSelection : false
				})]
			}, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [createERPcombo({
					id : 'combinedproduct.storeInfoId',
					name : 'combinedproduct.storeInfoId',
					fieldLabel : ' 仓库',
					url : "./StoreInfo_combo.do?searchBean.status=有效",
					allowBlank : false,
					forceSelection : false,
					select : function(result) {
						id = result.record.id;
						storePosition.load({
							params : {
								'searchBean.storeInfoId' : id,
								'searchBean.status' : '有效'
							}

						});
					}
				})]
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
					id : 'combinedproduct.model',
					name : 'combinedproduct.model',
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
					id : 'combinedproduct.isBox',
					name : 'combinedproduct.isBox',
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
				items : [createERPcombo({
					id : 'combinedproduct.providerInfoId',
					name : 'combinedproduct.providerInfoId',
					fieldLabel : ' 供应商',
					url : "./ProviderInfo_combo.do?searchBean.status=有效",
					allowBlank : false,
					forceSelection : false
					,
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
					id : 'combinedproduct.baseUnit',
					name : 'combinedproduct.baseUnit',
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
				items : [createERPcombo({
					id : 'combinedproduct.productBrandId',
					name : 'combinedproduct.productBrandId',
					fieldLabel : ' 品牌',
					url : "./ProductBrand_combo.do?searchBean.status=有效",
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
				})]

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
					id : 'combinedproduct.boxUnit',
					name : 'combinedproduct.boxUnit',
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
					id : 'combinedproduct.stockTaxRateTaxRateShow',
					name : 'combinedproduct.stockTaxRateTaxRateShow',
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
					id : 'combinedproduct.shelfLife',
					name : 'combinedproduct.shelfLife',
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

		, {// 第二排
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
					id : 'combinedproduct.text',
					name : 'combinedproduct.text',
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

	var base_combined_product_create_window = new base_combined_product_save_update_form_panel_windows(base_combined_product_params);

}