/**
 * 主要用户设置查询的一些参数
 */
var base_product_category_search_params = {

	verification : function() {

		return true;
	},
	params : function() {
		var params = {
			optType : "search"
			,
			// 'staffSearchBean.selectName' :
			// Ext.getCmp('staffSearchBean.selectName').getValue(),
			// 'staffSearchBean.name' :
			// Ext.getCmp('staffSearchBean.name').getValue()
		}
		return params;
	}

}