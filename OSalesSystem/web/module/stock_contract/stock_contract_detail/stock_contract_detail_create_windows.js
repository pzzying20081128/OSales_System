function stock_contract_detail_create_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();

	var mainGrid = params.mainGrid;

	var selection_rows = mainGrid.getSelectionModel().getSelections();
	if (selection_rows == null) {
		showErrorMsg('提示信息', '请选择采购合同');
		return;
	}
	if (selection_rows.length != 1) {
		showErrorMsg('提示信息', '只能选择一行采购合同');
		return;
	}

	var stock_contract_id = selection_rows[0].id;

	var productInfo = createERPcombo({
		id : 'stockcontractdetail.productInfoId',
		name : 'stockcontractdetail.productInfoId',
		fieldLabel : ' 产品',
		url : "./ProductInfo_detailscombo.do?selectype=productInfo",
		params : {
			'searchBean.status' : '有效'
		},
		allowBlank : false,
		forceSelection : false,

		select : function(results) {
			productInfoSelect = results.record.json;
			ProductInfobarCode.setValue(productInfoSelect.barCode);
			baseUnitBoxUnit.setValue(productInfoSelect.baseUnitBoxUnit);
			isbox.setValue(productInfoSelect.isBox);
			taxRateTaxRateShow.setValue(productInfoSelect.stockTaxRateTaxRateShow);
			taxPriceMoneyShow.setValue(productInfoSelect.maxStockPriceMoneyShow);
			if(productInfoSelect.maxNoTaxStockPriceMoneyShow ==null){
			computeCountMoney();	
			}else{
			noTaxPriceMoneyShow.setValue(productInfoSelect.maxNoTaxStockPriceMoneyShow);		
			}
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

	var isbox = createLocalCombo({
		id : 'stockcontractdetail.isBox',
		name : 'stockcontractdetail.isBox',
		fieldLabel : '以箱下单',
		storeData : [['1', "是"], ['0', '否']],
		defaultValue : null,
		allowBlank : false
	})

	var taxPriceMoneyShow = new Ext.form.TextField({
		id : 'stockcontractdetail.taxPriceMoneyShow',
		name : 'stockcontractdetail.taxPriceMoneyShow',
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

	var noTaxPriceMoneyShow = new Ext.form.ERPShowEditText({
		id : 'stockcontractdetail.noTaxPriceMoneyShow',
		name : 'stockcontractdetail.noTaxPriceMoneyShow',
		fieldLabel : '末税单价',
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
		id : 'stockcontractdetail.taxRateTaxRateShow',
		name : 'stockcontractdetail.taxRateTaxRateShow',
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

	var stock_contract_detail_params = {
		title : "新增" + moduleName,
		action : "save",
		grid : grid,
		// 结果路径
		pojo : "result",
		// url
		url : './simple_StockContractDetail_saveUpdate.do',
		params : {
			optType : "save",
			"stockcontractdetail.stockContractId" : stock_contract_id
		},
		// 字段
		field : [{
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 60,
			items : [{
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 500
				},
				items : [productInfo]
			}]
		},

		{

			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 60,
			items : [{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 110
				},
				items : [ProductInfobarCode]
			}, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 110
				},
				items : [baseUnitBoxUnit]
			}, {

				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 110
				},
				items : [isbox]

			}]

		}, {

			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 60,
			items : [{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 110
				},
				items : [taxPriceMoneyShow]
			}, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 110
				},
				items : [taxRateTaxRateShow]
			}, {

				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 110
				},
				items : [noTaxPriceMoneyShow]

			}]

		}

		]

	}

	var stock_contract_detail_create_window = new stock_contract_detail_save_update_form_panel_windows(stock_contract_detail_params);

	function computeCountMoney() {

		var taxPriceMoneyShow_ = taxPriceMoneyShow.getValue();
		var taxRateTaxRateShow_ = taxRateTaxRateShow.getValue();
		if (taxPriceMoneyShow_ === '' || taxRateTaxRateShow_ === '')
			noTaxPriceMoneyShow.setValue(null);
		else {
			var xx = ( Math.round(taxPriceMoneyShow_ * ( 100 - taxRateTaxRateShow_ )) / 100.00 ); // 小数点后两位百分比
			noTaxPriceMoneyShow.setValue(xx);
		}

	}
}