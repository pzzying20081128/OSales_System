var base_combined_product_detail_grid_column = {
	record : [{
		name : 'productInfo.name',
		mapping : 'productInfo'
	}, {
		name : 'number',
		mapping : 'number'
	}, {
		name : 'stockMoneyPrice',
		mapping : 'stockMoneyPrice'
	}, {
		name : 'stockMoneyPriceMoneyShow',
		mapping : 'stockMoneyPriceMoneyShow'
	}, {
		name : 'stockMoneyPriceMoneyHide',
		mapping : 'stockMoneyPriceMoneyHide'
	},{
	    name:"salesMoneyPriceMoneyShow",
	    mapping:"salesMoneyPriceMoneyShow"
	},{
	    name:"salesMoneyPriceMoneyHide",
	    mapping:"salesMoneyPriceMoneyHide"
	},{
	    name:"salesMoneyPrice",
	    mapping:"salesMoneyPrice"
	}
	
	
	],

	// ///////////////////////////////////////////////////////////////////////////////////////////
	column : [new Ext.grid.ERPRowNumberer(), {
		header : '产品',
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
		header : '产品数量',
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
		header : '最大采购价',
		width : 200,
		dataIndex : 'stockMoneyPriceMoneyShow',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '销售价',
		width : 200,
		dataIndex : 'salesMoneyPriceMoneyShow',
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

