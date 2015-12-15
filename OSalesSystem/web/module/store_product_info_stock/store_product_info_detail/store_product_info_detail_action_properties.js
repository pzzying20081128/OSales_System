var store_product_info_detail_grid_column = {
	record : [{
		name : 'purchaseSum',
		mapping : 'purchaseSum'
	}, {
		name : 'purchaseMoneyMoneyShow',
		mapping : 'purchaseMoneyMoneyShow'
	}, {
		name : 'planInStoreSum',
		mapping : 'planInStoreSum'
	}, {
		name : 'planInStoreMoneyMoneyShow',
		mapping : 'planInStoreMoneyMoneyShow'
	}, {
		name : 'planOutStoreSum',
		mapping : 'planOutStoreSum'
	}, {
		name : 'planOutStoreMoneyMoneyShow',
		mapping : 'planOutStoreMoneyMoneyShow'
	}, {
		name : 'approvalSum',
		mapping : 'approvalSum'
	}, {
		name : 'approvalMoneyMoneyShow',
		mapping : 'approvalMoneyMoneyShow'
	}, {
		name : 'reserveSum',
		mapping : 'reserveSum'
	}, {
		name : 'reserveMoneyMoneyShow',
		mapping : 'reserveMoneyMoneyShow'
	}, {
		name : 'storePosition.name',
		mapping : 'storePosition'
	}, {
		name : 'storePositionId',
		mapping : 'storePositionId'
	}],

	// ///////////////////////////////////////////////////////////////////////////////////////////
	column : [new Ext.grid.ERPRowNumberer(), {
		header : '库位',
		width : 200,
		dataIndex : 'storePosition.name',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value.name;
		}
	}, {
		header : '库存数量',
		width : 200,
		dataIndex : 'purchaseSum',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '库存金额',
		width : 200,
		dataIndex : 'purchaseMoneyMoneyShow',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '计划入库数量',
		width : 200,
		dataIndex : 'planInStoreSum',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : ' 计划入库金额',
		width : 200,
		dataIndex : 'planInStoreMoneyMoneyShow',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '计划出库数量',
		width : 200,
		dataIndex : 'planOutStoreSum',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '计划出库金额',
		width : 200,
		dataIndex : 'planOutStoreMoneyMoneyShow',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '审批出库数量',
		width : 200,
		dataIndex : 'approvalSum',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '审批出库金额',
		width : 200,
		dataIndex : 'approvalMoneyMoneyShow',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '预留数量',
		width : 200,
		dataIndex : 'reserveSum',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '预留金额',
		width : 200,
		dataIndex : 'reserveMoneyMoneyShow',
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

