var produce_combined_product_detail_grid_column = {
	record : [{
		name : 'productInfo.name',
		mapping : 'productInfo'
	}, {
		name : "productInfo.baseUnitBoxUnit",
		mapping : 'productInfo'

	},

	{
		name : 'productInfoId',
		mapping : 'productInfoId'
	}, {
		name : 'needunitQuantity',
		mapping : 'needunitQuantity'
	}, {
		name : 'productInfoQuantity',
		mapping : 'productInfoQuantity'
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
		name : 'text',
		mapping : 'text'
	},],

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
		header : '单位',
		width : 200,
		dataIndex : 'productInfo.baseUnitBoxUnit',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else if (value.name == null || typeof ( value.name ) == 'undefined')
				return null
			else
				return value.baseUnitBoxUnit;

		}
	},

	{
		header : '单位产品数量',
		width : 200,
		dataIndex : 'needunitQuantity',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '需要的产品数量',
		width : 200,
		dataIndex : 'productInfoQuantity',
		sortable : true,
		renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

			if (value == null || typeof ( value ) == 'undefined')
				return null
			else
				return value;

		}
	}, {
		header : '出库仓库',
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
		header : '出库仓位',
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
	},

	]
};
// //////////////////////////////////////////////////////////////////////////////////

