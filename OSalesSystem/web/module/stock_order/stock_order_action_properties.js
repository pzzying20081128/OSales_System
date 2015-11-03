var stock_order_grid_column = {
	record : [{
		name : 'number',
		mapping : 'number'
	}, {
		name : 'providerInfo.name',
		mapping : 'providerInfo'
	}, {
		name : 'providerInfoId',
		mapping : 'providerInfoId'
	}, {
		name : 'stockMan.name',
		mapping : 'stockMan'
	}, {
		name : 'stockManId',
		mapping : 'stockManId'
	}, {
		name : 'orderDate',
		mapping : 'orderDate'
	}, {
		name : 'stockDate',
		mapping : 'stockDate'
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
		name : 'stockType',
		mapping : 'stockType'
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
		name : 'status',
		mapping : 'status'
	}, {
		name : "stockProductType",
		mapping : "stockProductType"
	} //
	],

	// ///////////////////////////////////////////////////////////////////////////////////////////
	column : [new Ext.grid.ERPRowNumberer(), {
		header : '订单编号',
		width : 200,
		dataIndex : 'number',
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
		header : '采购员',
		width : 200,
		dataIndex : 'stockMan.name',
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
		header : '订单日期',
		width : 200,
		dataIndex : 'orderDate',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '采购日期',
		width : 200,
		dataIndex : 'stockDate',
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
	}, { // 采购类型 

		header : '采购类型',
		width : 200,
		dataIndex : 'stockProductType',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}

	},

	{
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
	}

	]
};
// //////////////////////////////////////////////////////////////////////////////////

