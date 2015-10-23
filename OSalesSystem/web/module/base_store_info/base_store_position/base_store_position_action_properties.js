var base_store_position_grid_column = {
	record : [{
		name : 'storeInfo.name',
		mapping : 'storeInfo'
	}, {
		name : 'name',
		mapping : 'name'
	}, {
		name : 'status',
		mapping : 'status'
	}, {
		name : 'text',
		mapping : 'text'
	}],

	// ///////////////////////////////////////////////////////////////////////////////////////////
	column : [new Ext.grid.ERPRowNumberer(), {
		header : '库位',
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
	}, {
		header : '备注',
		width : 400,
		dataIndex : 'text',
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

