var stock_payment_reconcile_grid_column = {
	record : [{
		name : 'num',
		mapping : 'num'
	}, {
		name : 'otherSideReceiveNum',
		mapping : 'otherSideReceiveNum'
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
		name : 'isPrePayment',
		mapping : 'isPrePayment'
	}, {
		name : 'paymentDate',
		mapping : 'paymentDate'
	}, {
		name : 'paymentSum',
		mapping : 'paymentSum'
	}, {
		name : 'paymentSumMoneyShow',
		mapping : 'paymentSumMoneyShow'
	}, {
		name : 'paymentSumMoneyHide',
		mapping : 'paymentSumMoneyHide'
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
		name : 'otherSideBank',
		mapping : 'otherSideBank'
	}, {
		name : 'ourBank',
		mapping : 'ourBank'
	}, {
		name : 'paymentType',
		mapping : 'paymentType'
	}, {
		name : 'recordMan.name',
		mapping : 'recordMan'
	}, {
		name : 'recordManId',
		mapping : 'recordManId'
	}, {
		name : 'status',
		mapping : 'status'
	},],

	// ///////////////////////////////////////////////////////////////////////////////////////////
	column : [new Ext.grid.ERPRowNumberer(), {
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
		header : '付款单号',
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
		header : '对方收款单号',
		width : 200,
		dataIndex : 'otherSideReceiveNum',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '是否预付',
		width : 200,
		dataIndex : 'isPrePayment',
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
		header : '付款金额',
		width : 200,
		dataIndex : 'paymentSumMoneyShow',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '付款方式',
		width : 200,
		dataIndex : 'paymentType',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	},{
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
		header : '采审核人',
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
		header : '采审时间',
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
		header : '对方银行',
		width : 200,
		dataIndex : 'otherSideBank',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '我方银行',
		width : 200,
		dataIndex : 'ourBank',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	},  {
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

