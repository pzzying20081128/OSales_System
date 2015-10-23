/**
 * 主要用户设置查询的一些参数
 */
var base_product_brand_search_params = {
	
	verification : function() {
		// if (Ext.getCmp('staffSearchBean.selectName').getValue() == true &&
		// ( Ext.getCmp('staffSearchBean.name').getValue() == null
		// ||Ext.getCmp('staffSearchBean.name').getValue() == "" )) {
		// showErrorMsg("提示", "请输入员工姓名信息！");
		// return false;
		// }

		return true;
	},
	params : function() {
		var params = {
			optType : "search",
//			'searchBean.name' : Ext.getCmp('searchBean.name').getValue(),
//			'searchBean.status' : Ext.getCmp('searchBean.status').getValue()
		}
		return params;
	}

}