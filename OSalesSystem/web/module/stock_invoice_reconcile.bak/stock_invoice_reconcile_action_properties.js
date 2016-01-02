var stock_invoice_reconcile_grid_column = {
	record : [{
		name : 'num',
		mapping : 'num'
	}, {
		name : 'invoiceNum',
		mapping : 'invoiceNum'
	}, {
		name : 'providerInfo.name',
		mapping : 'providerInfo'
	}, {
		name : 'providerInfoId',
		mapping : 'providerInfoId'
	}, {
		name : 'invoiceDate',
		mapping : 'invoiceDate'
	}, {
		name : 'paymentDate',
		mapping : 'paymentDate'
	}, {
		name : 'invoiceSum',
		mapping : 'invoiceSum'
	}, {
		name : 'invoiceSumMoneyShow',
		mapping : 'invoiceSumMoneyShow'
	}, {
		name : 'invoiceSumMoneyHide',
		mapping : 'invoiceSumMoneyHide'
	}, {
		name : 'text',
		mapping : 'text'
	}, {
		name : 'recordMan.name',
		mapping : 'recordMan'
	}, {
		name : 'recordManId',
		mapping : 'recordManId'
	}, {
		name : 'checkMan.name',
		mapping : 'checkMan'
	}, {
		name : 'checkManId',
		mapping : 'checkManId'
	}, {
		name : 'checkedDate',
		mapping : 'checkedDate'
	}, {
		name : 'killSum',
		mapping : 'killSum'
	}, {
		name : 'killSumMoneyShow',
		mapping : 'killSumMoneyShow'
	}, {
		name : 'killSumMoneyHide',
		mapping : 'killSumMoneyHide'
	}, {
		name : 'noKillSum',
		mapping : 'noKillSum'
	}, {
		name : 'noKillSumMoneyShow',
		mapping : 'noKillSumMoneyShow'
	}, {
		name : 'noKillSumMoneyHide',
		mapping : 'noKillSumMoneyHide'
	}, {
		name : 'reconciliationSum',
		mapping : 'reconciliationSum'
	}, {
		name : 'reconciliationSumMoneyShow',
		mapping : 'reconciliationSumMoneyShow'
	}, {
		name : 'reconciliationSumMoneyHide',
		mapping : 'reconciliationSumMoneyHide'
	}, {
		name : 'reconciliation',
		mapping : 'reconciliation'
	},],

	// ///////////////////////////////////////////////////////////////////////////////////////////
	column : [new Ext.grid.ERPRowNumberer(), {
		header : '发票编号',
		width : 200,
		dataIndex : 'num',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '发票号',
		width : 200,
		dataIndex : 'invoiceNum',
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
		header : '发票日期',
		width : 200,
		dataIndex : 'invoiceDate',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '付款日期',
		width : 200,
		dataIndex : 'paymentDate',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '发票金额',
		width : 200,
		dataIndex : 'invoiceSumMoneyShow',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

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
		header : '审核人',
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
		dataIndex : 'checkedDate',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '抵消金额',
		width : 200,
		dataIndex : 'killSumMoneyShow',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '未抵消金额',
		width : 200,
		dataIndex : 'noKillSumMoneyShow',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '对账余额',
		width : 200,
		dataIndex : 'reconciliationSumMoneyShow',
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
		dataIndex : 'reconciliation',
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

