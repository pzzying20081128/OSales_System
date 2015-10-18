var sys_opt_history_grid_column = {
	record : [{
		name : 'id',
		mapping : 'id'
	}, {
		name : 'classification',
		mapping : 'classification'
	}, {
		name : 'module',
		mapping : 'module'
	}, {
		name : 'optTime',
		mapping : 'optTime'
	}, {
		name : 'text',
		mapping : 'text'
	}, {
		name : 'sysStaffUser.name',
		mapping : 'sysStaffUser'
	}, {
		name : 'sysStaffUserId',
		mapping : 'sysStaffUserId'
	},],

	// ///////////////////////////////////////////////////////////////////////////////////////////
	column : [new Ext.grid.ERPRowNumberer(), {
		header : '类别',
		width : 200,
		dataIndex : 'classification',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
			if (value == null) {
				return value;
			} else {
				return value;
			}
		}
	}, {
		header : '模块',
		width : 200,
		dataIndex : 'module',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
			if (value == null) {
				return value;
			} else {
				return value;
			}
		}
	}, {
		header : '操作人员',
		width : 200,
		dataIndex : 'sysStaffUser.name',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
			if (value == null) {
				return value;
			} else {
				
				if (value == null)
					return null
				else if (value.name == null)
					return null
				else
					return value.name;
			}
		}
	}, {
		header : '操作时间',
		width : 200,
		dataIndex : 'optTime',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
			if (value == null) {
				return value;
			} else {
				return value;
			}
		}
	}, {
		header : '操作内容',
		width : 200,
		dataIndex : 'text',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
			if (value == null) {
				return value;
			} else {
				return value;
			}
		}
	},

	]
};
// //////////////////////////////////////////////////////////////////////////////////

