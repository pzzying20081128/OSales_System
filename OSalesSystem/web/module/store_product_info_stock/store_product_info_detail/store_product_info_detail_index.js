function create_store_product_info_detail_window(moduleId, moduleName) {

	var mainGridModule = new mainGridWindow({
		moduleId : moduleId,
		// list grid
		url : "./listStockDetail.do",

		reader_totalProperty : "selectDetailPage.count",

		reader_root : "selectDetailPage.result",
		// grid_column.record
		record : store_product_info_detail_grid_column.record,
		// grid_column.column
		column : store_product_info_detail_grid_column.column,

		init : {
			// 行被选择
			select : function(rowDataId, data, sm, rowIdx, r) {
				stockSelect(data, checkButton, detailGrid);
				detailGrid.load({
					params : {
				// 'searchBean.combinedProductId' : rowDataId
					}
				});

			},
			// 返回这一行的状态 1:OK -1 NO OK checkName:
			status : function(data) {

			}
		}
	});

	this.getDetailGrid = function() {
		return mainGridModule.getGrid();
	}
}