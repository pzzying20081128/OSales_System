var stock_invoice_reconcile_detail_grid_column = {
	record : [{
		name : 'stockInvoiceBillDetail.providerInfo.name',
		mapping : 'stockInvoiceBillDetail.providerInfo'
	}, {
		name : 'stockInvoiceBillDetail.providerId',
		mapping : 'stockInvoiceBillDetail.providerId'
	}, {
		name : 'stockInvoiceBillDetail.billType',
		mapping : 'stockInvoiceBillDetail.billType'
	}, {
		name : 'stockInvoiceBillDetail.billNum',
		mapping : 'stockInvoiceBillDetail.billNum'
	}, {
		name : 'stockInvoiceBillDetail.billDate',
		mapping : 'stockInvoiceBillDetail.billDate'
	}, {
		name : 'stockInvoiceBillDetail.billSum',
		mapping : 'stockInvoiceBillDetail.billSum'
	}, {
		name : 'stockInvoiceBillDetail.billSumMoneyShow',
		mapping : 'stockInvoiceBillDetail.billSumMoneyShow'
	}, {
		name : 'killSum',
		mapping : 'killSum'
	}, {
		name : 'killSumMoneyShow',
		mapping : 'killSumMoneyShow'
	}, {
		name : 'killSumMoneyHide',
		mapping : 'killSumMoneyHide'
	}],

	// ///////////////////////////////////////////////////////////////////////////////////////////
	column : [new Ext.grid.ERPRowNumberer(), {
		header : '单据类型',
		width : 200,
		dataIndex : 'stockInvoiceBillDetail.billType',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '单据编号',
		width : 200,
		dataIndex : 'stockInvoiceBillDetail.billNum',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}

	// , {
	// header : '供应商',
	// width : 200,
	// dataIndex : 'stockInvoiceBillDetail.providerInfo.name',
	// sortable : true,
	// renderer : function(value, cellmeta, record, rowIndex, columnIndex,
	// store) {
	//
	// if (value == null || typeof ( value ) == 'undefined')
	// return null
	// else if (value.name == null || typeof ( value.name ) == 'undefined')
	// return null
	// else
	// return value.name;
	//
	// }
	// }

	,

	{
		header : '单据日期',
		width : 200,
		dataIndex : 'stockInvoiceBillDetail.billDate',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '单据金额',
		width : 200,
		dataIndex : 'stockInvoiceBillDetail.billSumMoneyShow',
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
	}

	]
};
// //////////////////////////////////////////////////////////////////////////////////

