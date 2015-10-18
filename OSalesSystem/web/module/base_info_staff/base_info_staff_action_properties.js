var base_info_staff_grid_column = {
	record : [{
		name : 'id',
		mapping : 'id'
	}, {
		name : 'pwd',
		mapping : 'pwd'
	}, {
		name : 'name',
		mapping : 'name'
	}, {
		name : 'account',
		mapping : 'account'
	}, {
		name : 'sex',
		mapping : 'sex'
	}, {
		name : 'phone',
		mapping : 'phone'
	}, {
		name : 'address',
		mapping : 'address'
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
	}, {
		name : 'status',
		mapping : 'status'
	},],

	// ///////////////////////////////////////////////////////////////////////////////////////////
	column : [new Ext.grid.ERPRowNumberer(), {
		header : '姓名',
		width : 200,
		dataIndex : 'name',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null) {
				return value;
			} else {
				return value;
			}
		}
	}, {
		header : '状态',
		width : 80,
		dataIndex : 'status',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
			if (value == null) {
				return value;
			} else {
				return value;
			}
		}
	}, {
		header : '系统用户',
		width : 200,
		dataIndex : 'account',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
			if (value == null) {
				return value;
			} else {
				return value;
			}
		}
	}, {
		header : '性别',
		width : 200,
		dataIndex : 'sex',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
			if (value == null) {
				return value;
			} else {
				return value == 1 ? "男" : "女";
			}
		}
	}, {
		header : '手机',
		width : 200,
		dataIndex : 'phone',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
			if (value == null) {
				return value;
			} else {
				return value;
			}
		}
	}, {
		header : '地址',
		width : 200,
		dataIndex : 'address',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
			if (value == null) {
				return value;
			} else {
				return value;
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
				return value == 1 ? "是" : "否";
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
				return value == 1 ? "是" : "否";
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
				return value == 1 ? "是" : "否";
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
				return value == 1 ? "是" : "否";
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
				return value;
			}
		}
	},

	]
};
// //////////////////////////////////////////////////////////////////////////////////

