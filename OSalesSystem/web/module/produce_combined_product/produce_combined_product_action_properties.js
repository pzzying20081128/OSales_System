var produce_combined_product_grid_column = {
	record : [{
		name : 'productInfo.name',
		mapping : 'productInfo'
	}, {
		name : 'productInfoId',
		mapping : 'productInfoId'
	}, {
		name : 'produceDate',
		mapping : 'produceDate'
	}, {
		name : 'produceCount',
		mapping : 'produceCount'
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
		name : 'stockInStore.number',
		mapping : 'stockInStore'
	}, {
		name : 'stockInStoreId',
		mapping : 'stockInStoreId'
	}, {
		name : 'stockOrder.number',
		mapping : 'stockOrder'
	}, {
		name : 'stockOrderId',
		mapping : 'stockOrderId'
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
	}],

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
	}, {
		header : '组合产品',
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
		header : '生产数量',
		width : 200,
		dataIndex : 'produceCount',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '生产日期',
		width : 200,
		dataIndex : 'produceDate',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;
		}
	}, {
		header : '入库仓库',
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
		header : '入库库位',
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
	},  {
		header : '采购单',
		width : 200,
		dataIndex : 'stockOrder.number',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else if (value.number == null || typeof ( value.number ) == 'undefined')
				return null
			else
				return value.number;

		}
	}, {
		header : '采购入库单',
		width : 200,
		dataIndex : 'stockInStore.number',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else if (value.number == null || typeof ( value.number ) == 'undefined')
				return null
			else
				return value.number;

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

