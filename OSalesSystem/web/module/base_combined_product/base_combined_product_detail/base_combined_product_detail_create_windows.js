function base_combined_product_detail_create_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();

	var mainPojo = params.mainPojo;

	var mainTopGrid = params.mainTopGrid;

	productInfo = createERPcombo({
		id : 'combinedproductdetails.productInfoId',
		name : 'combinedproductdetails.productInfoId',
		fieldLabel : ' 产品',
		url : "./ProductInfo_detailscombo.do?selectype=productInfo",
		params : {
			'searchBean.status' : '有效'
		},
		allowBlank : false,
		forceSelection : false,
		select : function(results) {
			productInfoSelect = results.record.json;
			stockPiceShow.setValue(productInfoSelect.maxStockPriceMoneyShow);
			salesPiceShow.setValue(productInfoSelect.salesTaxPriceMoneyShow);
		}
	});

	stockPiceShow = new Ext.form.ERPShowTextField({

		fieldLabel : ' 最大采购单价',
		xtype : 'ERPShowText',
		style : AllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}

	});

	salesPiceShow = new Ext.form.ERPShowTextField({
		fieldLabel : ' 含税销售单价',
		xtype : 'ERPShowText',
		style : AllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}

	});

	stockPiceSumShow = new Ext.form.ERPShowEditText({
		id : "combinedproductdetails.stockMoneyPriceMoneyShow",
		id : "combinedproductdetails.stockMoneyPriceMoneyShow",
		fieldLabel : ' 采购价格',
		// xtype : 'ERPShowText',
		style : AllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}

	});

	salesPiceSumShow = new Ext.form.ERPShowEditText({
		id : "combinedproductdetails.salesMoneyPriceMoneyShow",
		id : "combinedproductdetails.salesMoneyPriceMoneyShow",
		fieldLabel : ' 采购价格',
		// xtype : 'ERPShowText',
		style : AllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}

	});

	var base_combined_product_detail_params = {
		title : "新增" + moduleName,
		action : "save",
		grid : grid,
		mainTopGrid : mainTopGrid,
		// 结果路径
		pojo : "result",
		// url
		url : './simple_CombinedProductDetails_save.do',
		params : {
			optType : "save",
			"combinedproductdetails.combinedProductId" : mainPojo.id
		},
		// 字段
		field : [{// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 420
				},
				items : [productInfo]
			}]
		}, {// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 160
				},
				items : [stockPiceShow]
			},

			{
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 160
				},
				items : [salesPiceShow

				]
			}]
		}, {// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 160
				},
				items : [{
					id : 'combinedproductdetails.number',
					name : 'combinedproductdetails.number',
					fieldLabel : ' 产品数量',
					xtype : 'textfield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
					enableKeyEvents : true,
					listeners : {
						'keyup' : function(field, e) {
							var pice = stockPiceShow.getValue();
							var sumPice = this.getValue() * pice;
							var sumSales = this.getValue() * salesPiceShow.getValue();
							stockPiceSumShow.setValue(retention_accuracy(sumPice));
							salesPiceSumShow.setValue(retention_accuracy(sumSales));
						}
					}
				}]
			}, {
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 160
				},
				items : [stockPiceSumShow]
			}]

		}, {// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 160
				},
				items : [salesPiceSumShow]
			}]

		}]

	}

	var base_combined_product_detail_create_window = new base_combined_product_detail_save_update_form_panel_windows(base_combined_product_detail_params);

}