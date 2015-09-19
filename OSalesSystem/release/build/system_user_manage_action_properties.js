var system_user_manage_grid_column = {
	// record : [{
	// name : 'id'
	// }, {
	// name : 'name'
	// }, {
	// name : 'job'
	// }, {
	// name : 'sex'
	// }, {
	// name : 'access'
	// }, {
	// name : 'departmentParents.name',
	// mapping : "departmentParents"
	// }],

	record : [{
		name : 'id',
		mapping : 'id'
	}, {
		name : 'account',
		mapping : 'account'
	}, {
		name : 'pwd',
		mapping : 'pwd'
	}, {
		name : 'staffInfo.staffInfo.name',
		mapping : 'staffInfo'
	}, {
		name : 'isAdmin',
		mapping : 'isAdmin'
	}, {
		name : 'isBizMan',
		mapping : 'isBizMan'
	}, {
		name : 'isGoodsMan',
		mapping : 'isGoodsMan'
	}, {
		name : 'isStockMan',
		mapping : 'isStockMan'
	}, {
		name : 'isTransportMan',
		mapping : 'isTransportMan'
	}, {
		name : 'text',
		mapping : 'text'
	},],

	// ///////////////////////////////////////////////////////////////////////////////////////////
	column : [new Ext.grid.ERPRowNumberer(), {
		header : '是否管理员',
		width : 200,
		dataIndex : 'account',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
			if (value == null) {
				return value;
			} else {
				value;
			}
		}
	}, {
		header : '员工',
		width : 200,
		dataIndex : 'staffInfo.staffInfo.name',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
			if (value == null) {
				return value;
			} else {
				if (value.staffInfo == null)
					return null
				else if (value.staffInfo.name == null)
					return null
				else
					return value.staffInfo.name;
			}
		}
	}, {
		header : '是否管理员',
		width : 200,
		dataIndex : 'isAdmin',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
			if (value == null) {
				return value;
			} else {
				value;
			}
		}
	}, {
		header : '是否业务员',
		width : 200,
		dataIndex : 'isBizMan',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
			if (value == null) {
				return value;
			} else {
				value;
			}
		}
	}, {
		header : '是否理货员',
		width : 200,
		dataIndex : 'isGoodsMan',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
			if (value == null) {
				return value;
			} else {
				value;
			}
		}
	}, {
		header : '是否采购员',
		width : 200,
		dataIndex : 'isStockMan',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
			if (value == null) {
				return value;
			} else {
				value;
			}
		}
	}, {
		header : ' 是否运输人',
		width : 200,
		dataIndex : 'isTransportMan',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
			if (value == null) {
				return value;
			} else {
				value;
			}
		}
	}, {
		header : '备注',
		width : 200,
		dataIndex : 'text',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
			if (value == null) {
				return value;
			} else {
				value;
			}
		}
	},

	]
};
// //////////////////////////////////////////////////////////////////////////////////

