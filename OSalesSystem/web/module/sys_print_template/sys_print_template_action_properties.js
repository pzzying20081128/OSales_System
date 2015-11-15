var sys_print_template_grid_column = {
	record : [{
		name : 'colDataIndex',
		mapping : 'colDataIndex'
	}, {
		name : 'colName',
		mapping : 'colName'
	}, {
		name : 'printName',
		mapping : 'printName'
	}, {
		name : 'colIndex',
		mapping : 'colIndex'
	}, {
		name : 'isPrint',
		mapping : 'isPrint'
	}, {
		name : 'istotal',
		mapping : 'istotal'
	}, {
		name : 'isExcelExPorts',
		mapping : 'isExcelExPorts'
	},],

	// ///////////////////////////////////////////////////////////////////////////////////////////
	column : [new Ext.grid.ERPRowNumberer(), {
		header : '列名',
		width : 150,
		dataIndex : 'colName',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '打印名',
		width : 100,
		dataIndex : 'printName',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '排序',
		width : 80,
		dataIndex : 'colIndex',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	},{
		header : '是否打印',
		width : 100,
		dataIndex : 'isPrint',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value == 0 ? "否" : "是";

		}
	}, {
		header : '是否求和',
		width : 100,
		dataIndex : 'istotal',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value == 0 ? "否" : "是";

		}
	}, {
		header : '是否excel导出',
		width : 100,
		dataIndex : 'isExcelExPorts',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value == 0 ? "否" : "是";

		}
	}, {
		header : '数据索引',
		width : 200,
		dataIndex : 'colDataIndex',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}]
};
// //////////////////////////////////////////////////////////////////////////////////

