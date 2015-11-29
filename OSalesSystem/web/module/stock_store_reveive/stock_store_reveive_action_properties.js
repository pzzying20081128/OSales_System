var stock_store_reveive_grid_column = {
	record : [{
		name : 'providerInfo.name',
		mapping : 'providerInfo'
	}, {
		name : 'providerInfoId',
		mapping : 'providerInfoId'
	}, {
		name : 'taxSumMoney',
		mapping : 'taxSumMoney'
	}, {
		name : 'taxSumMoneyMoneyShow',
		mapping : 'taxSumMoneyMoneyShow'
	}, {
		name : 'taxSumMoneyMoneyHide',
		mapping : 'taxSumMoneyMoneyHide'
	}, {
		name : 'noTaxSumMoney',
		mapping : 'noTaxSumMoney'
	}, {
		name : 'noTaxSumMoneyMoneyShow',
		mapping : 'noTaxSumMoneyMoneyShow'
	}, {
		name : 'noTaxSumMoneyMoneyHide',
		mapping : 'noTaxSumMoneyMoneyHide'
	}, {
		name : 'orderCount',
		mapping : 'orderCount'
	}, {
		name : 'stockType',
		mapping : 'stockType'
	}, {
		name : 'remarks',
		mapping : 'remarks'
	}, {
		name : 'text',
		mapping : 'text'
	}, {
		name : 'checkMan.name',
		mapping : 'checkMan'
	}, {
		name : 'checkManId',
		mapping : 'checkManId'
	}, {
		name : 'checkDate',
		mapping : 'checkDate'
	}, {
		name : 'recordMan.name',
		mapping : 'recordMan'
	}, {
		name : 'recordManId',
		mapping : 'recordManId'
	}, {
		name : 'recordDate',
		mapping : 'recordDate'
	}, {
		name : 'number',
		mapping : 'number'
	}, {
		name : 'status',
		mapping : 'status'
	},
	 {
		name : 'stockInStore.stockOrder.number',
		mapping : 'stockInStore.stockOrder'
		
	}, 
	 {
		name : 'stockInStore.stockOrder.stockType',
		mapping : 'stockInStore.stockOrder'
		
	}, 
	 {
		name : 'stockInStore.stockOrder.stockProductType',
		mapping : 'stockInStore.stockOrder'
		
	}, 
	],

	// ///////////////////////////////////////////////////////////////////////////////////////////
	column : [new Ext.grid.ERPRowNumberer(), {
		header : '单号',
		width : 200,
		dataIndex : 'number',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	},
	{
		header : '采购单',
		width : 200,
		dataIndex : 'stockInStore.stockOrder.number',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value.number;

		}
	},
	{
		header : '订单类型',
		width : 200,
		dataIndex : 'stockInStore.stockOrder.stockType',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value.stockType;

		}
	},
		{
		header : '采购类型',
		width : 200,
		dataIndex : 'stockInStore.stockOrder.stockProductType',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value.stockProductType;

		}
	},
		
		
			{
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
	},  {
		header : '含税总金额',
		width : 200,
		dataIndex : 'taxSumMoneyMoneyShow',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '没税总金额',
		width : 200,
		dataIndex : 'noTaxSumMoneyMoneyShow',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '订购数量',
		width : 200,
		dataIndex : 'orderCount',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '订单类型',
		width : 200,
		dataIndex : 'stockType',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '说明',
		width : 200,
		dataIndex : 'remarks',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : ' 备注',
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
		header : '审核员',
		width : 200,
		dataIndex : 'checkMan.name',
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
		header : '审核员',
		width : 200,
		dataIndex : 'checkManId',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '审核日期',
		width : 200,
		dataIndex : 'checkDate',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '录入人',
		width : 200,
		dataIndex : 'recordMan.name',
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
		header : '录入人',
		width : 200,
		dataIndex : 'recordManId',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '录入日期',
		width : 200,
		dataIndex : 'recordDate',
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
	},

	]
};
// //////////////////////////////////////////////////////////////////////////////////

