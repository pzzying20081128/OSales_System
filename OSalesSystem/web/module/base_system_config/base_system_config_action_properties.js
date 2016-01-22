var base_system_config_grid_column = {
	record : [{
		name : 'title',
		mapping : 'title'
	}, {
		name : 'configKey',
		mapping : 'configKey'
	}, {
		name : 'configValue',
		mapping : 'configValue'
	}, {
		name : 'configDesc',
		mapping : 'configDesc'
	},],

	// ///////////////////////////////////////////////////////////////////////////////////////////
	column : [new Ext.grid.ERPRowNumberer(), {
		header : '配置项',
		width : 200,
		dataIndex : 'title',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '配置描述',
		width : 200,
		dataIndex : 'configValue',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	},{
		header : '配置',
		width : 200,
		dataIndex : 'configDesc',
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

