var stock_contract_detail_grid_column = {
	record : [{
		name : 'productInfo.name',
		mapping : 'productInfo'
	}, {
		name : "productInfo.barCode",
		mapping : 'productInfo'
	}, {
		name : "productInfo.baseUnitBoxUnit",
		mapping : 'productInfo'
	}, {
		name : 'productInfoId',
		mapping : 'productInfoId'
	}, {
		name : 'taxPrice',
		mapping : 'taxPrice'
	}, {
		name : 'taxPriceMoneyShow',
		mapping : 'taxPriceMoneyShow'
	}, {
		name : 'taxPriceMoneyHide',
		mapping : 'taxPriceMoneyHide'
	}, {
		name : 'taxRate',
		mapping : 'taxRate'
	}, {
		name : 'taxRateTaxRateShow',
		mapping : 'taxRateTaxRateShow'
	}, {
		name : 'taxRateTaxRateHide',
		mapping : 'taxRateTaxRateHide'
	}, {
		name : 'noTaxPrice',
		mapping : 'noTaxPrice'
	}, {
		name : 'noTaxPriceMoneyShow',
		mapping : 'noTaxPriceMoneyShow'
	}, {
		name : 'noTaxPriceMoneyHide',
		mapping : 'noTaxPriceMoneyHide'
	}, {
		name : 'isBox',
		mapping : 'isBox'
	},],

	// ///////////////////////////////////////////////////////////////////////////////////////////
	column : [new Ext.grid.ERPRowNumberer(), {
		header : '产品',
		width : 200,
		dataIndex : 'productInfo.name',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else if (value.name == null || typeof ( value.name ) == 'undefined')
				return null
			else
				return value.name;

		}
	}, {
		header : '条形码',
		width : 200,
		dataIndex : 'productInfo.barCode',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else if (value.barCode == null || typeof ( value.barCode ) == 'undefined')
				return null
			else
				return value.barCode;

		}
	}, {
		header : '条形码',
		width : 200,
		dataIndex : 'productInfo.baseUnitBoxUnit',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else if (value.baseUnitBoxUnit == null || typeof ( value.baseUnitBoxUnit ) == 'undefined')
				return null
			else
				return value.baseUnitBoxUnit;

		}
	},

	{
		header : '含税单价',
		width : 200,
		dataIndex : 'taxPriceMoneyShow',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '税率',
		width : 200,
		dataIndex : 'taxRateTaxRateShow',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '未税单价',
		width : 200,
		dataIndex : 'noTaxPriceMoneyShow',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '已箱下单',
		width : 200,
		dataIndex : 'isBox',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value ==1 ? "是":"否";

		}
	},

	]
};
// //////////////////////////////////////////////////////////////////////////////////

