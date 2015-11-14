var base_combined_product_grid_column = {
	record : [{
		name : 'productCategory.name',
		mapping : 'productCategory'
	}, {
		name : 'productCategoryId',
		mapping : 'productCategoryId'
	}, {
		name : 'shortName',
		mapping : 'shortName'
	}, {
		name : 'name',
		mapping : 'name'
	}, {
		name : 'model',
		mapping : 'model'
	}, {
		name : 'barCode',
		mapping : 'barCode'
	}, {
		name : 'baseUnit',
		mapping : 'baseUnit'
	}, {
		name : 'boxCount',
		mapping : 'boxCount'
	}, {
		name : 'boxUnit',
		mapping : 'boxUnit'
	}, {
		name : 'isBox',
		mapping : 'isBox'
	}, {
		name : 'providerInfo.name',
		mapping : 'providerInfo'
	}, {
		name : 'providerInfoId',
		mapping : 'providerInfoId'
	}, {
		name : 'maxStockPrice',
		mapping : 'maxStockPrice'
	}, {
		name : 'maxStockPriceMoneyShow',
		mapping : 'maxStockPriceMoneyShow'
	}, {
		name : 'maxStockPriceMoneyHide',
		mapping : 'maxStockPriceMoneyHide'
	}, {
		name : 'salesTaxPrice',
		mapping : 'salesTaxPrice'
	}, {
		name : 'salesTaxPriceMoneyShow',
		mapping : 'salesTaxPriceMoneyShow'
	}, {
		name : 'salesTaxPriceMoneyHide',
		mapping : 'salesTaxPriceMoneyHide'
	}, {
		name : 'grossProfitRate',
		mapping : 'grossProfitRate'
	}, {
		name : 'grossProfitRateTaxRateShow',
		mapping : 'grossProfitRateTaxRateShow'
	}, {
		name : 'grossProfitRateTaxRateHide',
		mapping : 'grossProfitRateTaxRateHide'
	}, {
		name : 'stockTaxRate',
		mapping : 'stockTaxRate'
	}, {
		name : 'stockTaxRateTaxRateShow',
		mapping : 'stockTaxRateTaxRateShow'
	}, {
		name : 'stockTaxRateTaxRateHide',
		mapping : 'stockTaxRateTaxRateHide'
	}, {
		name : 'salesTaxRate',
		mapping : 'salesTaxRate'
	}, {
		name : 'salesTaxRateTaxRateShow',
		mapping : 'salesTaxRateTaxRateShow'
	}, {
		name : 'salesTaxRateTaxRateHide',
		mapping : 'salesTaxRateTaxRateHide'
	}, {
		name : 'salesNoTaxPrice',
		mapping : 'salesNoTaxPrice'
	}, {
		name : 'salesNoTaxPriceMoneyShow',
		mapping : 'salesNoTaxPriceMoneyShow'
	}, {
		name : 'salesNoTaxPriceMoneyHide',
		mapping : 'salesNoTaxPriceMoneyHide'
	}, {
		name : 'salesBoxTaxPrice',
		mapping : 'salesBoxTaxPrice'
	}, {
		name : 'salesBoxTaxPriceMoneyShow',
		mapping : 'salesBoxTaxPriceMoneyShow'
	}, {
		name : 'salesBoxTaxPriceMoneyHide',
		mapping : 'salesBoxTaxPriceMoneyHide'
	}, {
		name : 'salesBoxNoTaxPrice',
		mapping : 'salesBoxNoTaxPrice'
	}, {
		name : 'salesBoxNoTaxPriceMoneyShow',
		mapping : 'salesBoxNoTaxPriceMoneyShow'
	}, {
		name : 'salesBoxNoTaxPriceMoneyHide',
		mapping : 'salesBoxNoTaxPriceMoneyHide'
	}, {
		name : 'shelfLife',
		mapping : 'shelfLife'
	}, {
		name : 'productBrand.name',
		mapping : 'productBrand'
	}, {
		name : 'productBrandId',
		mapping : 'productBrandId'
	}, {
		name : 'storeInfo.name',
		mapping : 'storeInfo'
	}, {
		name : 'storeInfoId',
		mapping : 'storeInfoId'
	}, {
		name : 'storePosition.name',
		mapping : 'storePosition'
	}, {
		name : 'storePositionId',
		mapping : 'storePositionId'
	}, {
		name : 'productInfoType',
		mapping : 'productInfoType'
	}, {
		name : 'text',
		mapping : 'text'
	}, {
		name : 'status',
		mapping : 'status'
	},],

	// ///////////////////////////////////////////////////////////////////////////////////////////
	column : [new Ext.grid.ERPRowNumberer(), {
		header : '产品名称',
		width : 200,
		dataIndex : 'name',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	},

	{
		header : '品牌',
		width : 200,
		dataIndex : 'productBrand.name',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else if (value.name == null || typeof ( value.name ) == 'undefined')
				return null
			else
				return value.name;

		}
	},

	{
		header : '类别',
		width : 200,
		dataIndex : 'productCategory.name',
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
		header : '助记符',
		width : 200,
		dataIndex : 'shortName',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '规格',
		width : 200,
		dataIndex : 'model',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '条码',
		width : 200,
		dataIndex : 'barCode',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '基本单位',
		width : 200,
		dataIndex : 'baseUnit',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '箱/件裝量',
		width : 200,
		dataIndex : 'boxCount',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '箱/件裝单位',
		width : 200,
		dataIndex : 'boxUnit',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '是否以箱下单',
		width : 200,
		dataIndex : 'isBox',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '供应商',
		width : 200,
		dataIndex : 'providerInfo.name',
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
		header : '供应商',
		width : 200,
		dataIndex : 'providerInfo.name',
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
		header : '最大采购价',
		width : 200,
		dataIndex : 'maxStockPriceMoneyShow',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '销售价',
		width : 200,
		dataIndex : 'salesTaxPriceMoneyShow',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '毛利率',
		width : 200,
		dataIndex : 'grossProfitRateTaxRateShow',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '采购税率',
		width : 200,
		dataIndex : 'stockTaxRateTaxRateShow',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '销售税率',
		width : 200,
		dataIndex : 'salesTaxRateTaxRateShow',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '末含税销售单价',
		width : 200,
		dataIndex : 'salesNoTaxPriceMoneyShow',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '含税销售箱/件价格',
		width : 200,
		dataIndex : 'salesBoxTaxPriceMoneyShow',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '没含税销售箱/件价格',
		width : 200,
		dataIndex : 'salesBoxNoTaxPriceMoneyShow',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '保质期',
		width : 200,
		dataIndex : 'shelfLife',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '品牌',
		width : 200,
		dataIndex : 'productBrand.name',
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
		header : '仓库',
		width : 200,
		dataIndex : 'storeInfo.name',
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
		header : '库位',
		width : 200,
		dataIndex : 'storePosition.name',
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
		header : '备注',
		width : 200,
		dataIndex : 'text',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '状态',
		width : 200,
		dataIndex : 'status',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}]
};
// //////////////////////////////////////////////////////////////////////////////////

