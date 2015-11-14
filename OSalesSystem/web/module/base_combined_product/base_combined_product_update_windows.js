function base_combined_product_update_windows(moduleId, moduleName, params) {

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

	var

	productCategory = createERPcombo({
		id : 'combinedproduct.productCategoryId',
		name : 'combinedproduct.productCategoryId',
		fieldLabel : ' 产品类型',
		url : "./ProductCategory_combo.do?searchBean.status=有效",
		allowBlank : false,
		forceSelection : false
	});
	productCategory.load({
		params : {
			'searchBean.id' : selection_rows[0].data.productCategoryId
		}
	});

	var storeInfoId = createERPcombo({
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
	})

	var storePosition = createERPcombo({
		id : 'combinedproduct.storePositionId',
		name : 'combinedproduct.storePositionId',
		fieldLabel : ' 库位',
		url : "./StorePosition_combo.do",
		allowBlank : false,
		forceSelection : false,
		select : function(result) {

		}
	});

	storeInfoId.load({
		params : {
			'searchBean.id' : selection_rows[0].data.storeInfoId,
			'searchBean.status' : '有效'
		},
		success : function() {
			storePosition.load({
				params : {
					'searchBean.storeInfoId' : selection_rows[0].data.storeInfoId,
					'searchBean.status' : '有效',
					'searchBean.id' : selection_rows[0].data.id
				}

			});
		}
	});

	var providerInfoId = createERPcombo({
		id : 'combinedproduct.providerInfoId',
		name : 'combinedproduct.providerInfoId',
		fieldLabel : ' 供应商',
		url : "./ProviderInfo_combo.do?searchBean.status=有效",
		allowBlank : false,
		forceSelection : false
	});
	providerInfoId.load({
		params : {
			'searchBean.status' : '有效',
			'searchBean.id' : selection_rows[0].data.providerInfoId
		}
	});

	var productBrandId = createERPcombo({
		id : 'combinedproduct.productBrandId',
		name : 'combinedproduct.productBrandId',
		fieldLabel : ' 品牌',
		url : "./ProductBrand_combo.do?searchBean.status=有效",
		allowBlank : false,
		forceSelection : false,
		select : function(combo, record, index) {
		}
	});

	productBrandId.load({
		params : {
			"searchBean:id" : selection_rows[0].data.productBrandId,
			'searchBean.status' : '有效'
		}
	});

	var maxStockPriceMoneyShow = new Ext.form.ERPShowEditText({
		id : 'combinedproduct.maxStockPriceMoneyShow',
		name : 'combinedproduct.maxStockPriceMoneyShow',
		fieldLabel : ' 采购总价',
		// xtype : 'textfield',
		// style : AllowBlankStyle,
		blankText : '不能为空！',
		enableKeyEvents : false,
		allowBlank : true,
		vtype : 'money',
		listeners : {
			keyup : function() {

				// var maxStockPriceMoney = maxStockPriceMoneyShow.getValue();
				// var salesTaxPriceMoney = salesTaxPriceMoneyShow.getValue();
				// if (maxStockPriceMoney === '' || salesTaxPriceMoney === '')
				// grossProfitRateTaxRateShow.setValue(null);
				// else {
				// var xx = ( Math.round( ( salesTaxPriceMoney -
				// maxStockPriceMoney ) / salesTaxPriceMoney * 10000) / 100.00
				// ); // 小数点后两位百分比
				// grossProfitRateTaxRateShow.setValue(xx);
				// }
			}
		}
	});

	var salesTaxPriceMoneyShow = new Ext.form.ERPShowEditText({
		id : 'combinedproduct.salesTaxPriceMoneyShow',
		name : 'combinedproduct.salesTaxPriceMoneyShow',
		fieldLabel : ' 销售总价',
		xtype : 'textfield',
		blankText : '不能为空！',
		enableKeyEvents : false,
		allowBlank : true,
		vtype : 'money'
//		,
		// listeners : {
		// keyup : function(field, e) {
		//
		// var maxStockPriceMoney = maxStockPriceMoneyShow.getValue();
		// var salesTaxPriceMoney = salesTaxPriceMoneyShow.getValue();
		// if (maxStockPriceMoney === '' || salesTaxPriceMoney === '')
		// grossProfitRateTaxRateShow.setValue(null);
		// else {
		// var xx1 = ( Math.round( ( salesTaxPriceMoney - maxStockPriceMoney ) /
		// salesTaxPriceMoney * 10000) / 100.00 ); // 小数点后两位百分比
		// grossProfitRateTaxRateShow.setValue(xx1);
		//
		// }
		// //
		// //////////////////////////////////////////////////////////////////////
		// var salesTaxRateTaxRate = this.getValue();
		// var salesTaxPriceMoney = salesTaxPriceMoneyShow.getValue();
		// if (salesTaxRateTaxRate === '' || salesTaxPriceMoney === '')
		// salesNoTaxPriceMoneyShow.setValue(null);
		// else {
		// var xx = salesTaxPriceMoney * ( 100 - salesTaxRateTaxRate ) / 100;
		// salesNoTaxPriceMoneyShow.setValue(xx.toFixed(2));
		// }
		//
		// //
		// /////////////////////////////////////////////////////////////////////
		// boxCount_ = boxCount.getValue();
		// {
		//
		// salesTaxPriceMoney = salesTaxPriceMoneyShow.getValue();
		//
		// if (salesTaxPriceMoney === '' || boxCount_ === '') {
		// salesBoxTaxPriceMoneyShow.setValue(null);
		// } else {
		// salesBoxTaxPriceMoney = boxCount_ * salesTaxPriceMoney;
		// salesBoxTaxPriceMoneyShow.setValue(salesBoxTaxPriceMoney.toFixed(2));
		// }
		//
		// }
		// {
		// salesNoTaxPriceMoney = salesNoTaxPriceMoneyShow.getValue();
		//
		// if (salesNoTaxPriceMoney === '' || boxCount_ === '') {
		// salesBoxNoTaxPriceMoneyShow.setValue(null);
		// } else {
		// salesBoxNoTaxMoney = ( boxCount_ * salesNoTaxPriceMoney );
		// salesBoxNoTaxPriceMoneyShow.setValue(salesBoxNoTaxMoney.toFixed(2));
		// }
		// }
		//
		// //
		// ///////////////////////////////////////////////////////////////////////
		// }
		// }
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
					salesNoTaxPriceMoneyShow.setValue(retention_accuracy(xx));
					var xxSum = xx * boxCount.getValue();
					salesBoxNoTaxPriceMoneyShow.setValue(retention_accuracy(xxSum));
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

	var salesBoxNoTaxPriceMoneyShow = new Ext.form.ERPShowEditText({
		id : 'combinedproduct.salesBoxNoTaxPriceMoneyShow',
		name : 'combinedproduct.salesBoxNoTaxPriceMoneyShow',
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
						salesBoxNoTaxPriceMoneyShow.setValue(null);
					} else {
						salesBoxNoTaxMoney = ( boxCount_ * salesNoTaxPriceMoney );
						salesBoxNoTaxPriceMoneyShow.setValue(salesBoxNoTaxMoney.toFixed(2));
					}
				}

			}
		}
	});

	var base_combined_product_params = {
		title : "编辑" + moduleName,
		action : "update",
		grid : grid,
		// 结果路径
		pojo : "result",
		// url
		url : './simple_CombinedProduct_save.do',
		params : {
			optType : "update",
			"combinedproduct.id" : selection_rows[0].id
		},
		reader : new Ext.data.JsonReader({
			successProperty : 'success',
			root : 'result',
			totalProperty : 'totalProperty'
		}, [{

			name : 'combinedproduct.productCategory',
			mapping : 'productCategoryId'

		}, {
			name : 'combinedproduct.productCategoryId',
			mapping : 'productCategoryId'
		}, {
			name : 'combinedproduct.shortName',
			mapping : 'shortName'
		}, {
			name : 'combinedproduct.name',
			mapping : 'name'
		}, {
			name : 'combinedproduct.model',
			mapping : 'model'
		}, {
			name : 'combinedproduct.barCode',
			mapping : 'barCode'
		}, {
			name : 'combinedproduct.baseUnit',
			mapping : 'baseUnit'
		}, {
			name : 'combinedproduct.boxCount',
			mapping : 'boxCount'
		}, {
			name : 'combinedproduct.boxUnit',
			mapping : 'boxUnit'
		}, {
			name : 'combinedproduct.isBox',
			mapping : 'isBox'
		}, {
			name : 'combinedproduct.providerInfo',
			mapping : 'providerInfo'
		}, {
			name : 'combinedproduct.providerInfoId',
			mapping : 'providerInfoId'
		}, {
			name : 'combinedproduct.maxStockPriceMoneyShow',
			mapping : 'maxStockPriceMoneyShow'
		}, {
			name : 'combinedproduct.salesTaxPriceMoneyShow',
			mapping : 'salesTaxPriceMoneyShow'
		}, {
			name : 'combinedproduct.grossProfitRateTaxRateShow',
			mapping : 'grossProfitRateTaxRateShow'
		}, {
			name : 'combinedproduct.stockTaxRateTaxRateShow',
			mapping : 'stockTaxRateTaxRateShow'
		}, {
			name : 'combinedproduct.salesTaxRateTaxRateShow',
			mapping : 'salesTaxRateTaxRateShow'
		}, {
			name : 'combinedproduct.salesNoTaxPriceMoneyShow',
			mapping : 'salesNoTaxPriceMoneyShow'
		}, {
			name : 'combinedproduct.salesBoxTaxPriceMoneyShow',
			mapping : 'salesBoxTaxPriceMoneyShow'
		}, {
			name : 'combinedproduct.salesBoxNoTaxPriceMoneyShow',
			mapping : 'salesBoxNoTaxPriceMoneyShow'
		}, {
			name : 'combinedproduct.shelfLife',
			mapping : 'shelfLife'
		}, {
			name : 'combinedproduct.productBrand',
			mapping : 'productBrand'
		}, {
			name : "combinedproduct.productBrandId",
			mapping : 'productBrandId'
		}, {
			name : 'combinedproduct.storeInfo',
			mapping : 'storeInfo'
		}, {
			name : 'combinedproduct.storeInfoId',
			mapping : 'storeInfoId'
		}, {
			name : 'combinedproduct.storePosition',
			mapping : 'storePosition'
		}, {
			name : 'combinedproduct.storePositionId',
			mapping : 'storePositionId'
		}, {
			name : 'combinedproduct.productInfoType',
			mapping : 'productInfoType'
		}, {
			name : 'combinedproduct.text',
			mapping : 'text'
		}, {
			name : 'combinedproduct.status',
			mapping : 'status'
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
				items : [productCategory]
			}, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [storeInfoId]
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
				items : [providerInfoId]
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
				items : [productBrandId]

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
				items : [salesBoxNoTaxPriceMoneyShow]

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
		}]
	}

	var base_combined_product_create_window = new base_combined_product_save_update_form_panel_windows(base_combined_product_params);

	base_combined_product_create_window.load({
		url : './simple_CombinedProduct_get.do?uuid=' + selectId,
		success : function(result) {
			json = result.result;
		}
	});

}