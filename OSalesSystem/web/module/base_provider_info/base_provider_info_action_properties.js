var base_provider_info_grid_column = {
	record : [{
		name : 'name',
		mapping : 'name'
	}, {
		name : 'shortName',
		mapping : 'shortName'
	}, {
		name : 'stockMan.name',
		mapping : 'stockMan'
	}, {
		name : 'stockManId',
		mapping : 'stockManId'
	}, {
		name : 'settleTime',
		mapping : 'settleTime'
	}, {
		name : 'paymentMethod',
		mapping : 'paymentMethod'
	}, {
		name : 'address',
		mapping : 'address'
	}, {
		name : 'contactMan',
		mapping : 'contactMan'
	}, {
		name : 'phone',
		mapping : 'phone'
	}, {
		name : 'fax',
		mapping : 'fax'
	}, {
		name : 'web',
		mapping : 'web'
	}, {
		name : 'qq',
		mapping : 'qq'
	}, {
		name : 'mail',
		mapping : 'mail'
	}, {
		name : 'returnType',
		mapping : 'returnType'
	}, {
		name : 'bank1',
		mapping : 'bank1'
	}, {
		name : 'bank2',
		mapping : 'bank2'
	}, {
		name : 'text',
		mapping : 'text'
	}, {
		name : 'status',
		mapping : 'status'
	},],

	// ///////////////////////////////////////////////////////////////////////////////////////////
	column : [new Ext.grid.ERPRowNumberer(), {
		header : '供应商',
		width : 200,
		dataIndex : 'name',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

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
		header : '付款方式',
		width : 200,
		dataIndex : 'paymentMethod',
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
		header : '帐期',
		width : 200,
		dataIndex : 'settleTime',
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
		dataIndex : 'payment',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '地址',
		width : 200,
		dataIndex : 'address',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '联系人',
		width : 200,
		dataIndex : 'contactMan',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '联系电话',
		width : 200,
		dataIndex : 'phone',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '传真',
		width : 200,
		dataIndex : 'fax',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '网址',
		width : 200,
		dataIndex : 'web',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : 'qq',
		width : 200,
		dataIndex : 'qq',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '电子邮箱',
		width : 200,
		dataIndex : 'mail',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '退货类型',
		width : 200,
		dataIndex : 'returnType',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '银行帐号',
		width : 200,
		dataIndex : 'bank1',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '银行帐号',
		width : 200,
		dataIndex : 'bank2',
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

