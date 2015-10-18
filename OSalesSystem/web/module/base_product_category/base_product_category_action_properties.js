var base_product_category_grid_column = {
	record : [{
		name : 'parent.name',
		mapping : 'parent'
	}, {
		name : 'parentId',
		mapping : 'parentId'
	}, {
		name : 'childs',
		mapping : 'childs'
	}, {
		name : 'name',
		mapping : 'name'
	}, {
		name : 'text',
		mapping : 'text'
	}, {
		name : 'isChild',
		mapping : 'isChild'
	}, {
		name : 'status',
		mapping : 'status'
	}],

	// ///////////////////////////////////////////////////////////////////////////////////////////
	column : [new Ext.grid.ERPRowNumberer(), {
		header : '类别',
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
		header : '父类类别',
		width : 200,
		dataIndex : 'parent.name',
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
		header : '是否有子类别',
		width : 200,
		dataIndex : 'isChild',
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

