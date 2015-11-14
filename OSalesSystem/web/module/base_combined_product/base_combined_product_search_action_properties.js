/**
 * 主要用户设置查询的一些参数
 */
var  base_combined_product_search_params = {
	
	verification : function(from) {
		return true;
	},
	params : function() {
		var params = {
			optType : "search"
		}
		return params;
	}

}