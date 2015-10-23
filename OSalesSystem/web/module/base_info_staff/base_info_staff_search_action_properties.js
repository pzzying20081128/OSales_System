/**
 * 主要用户设置查询的一些参数
 */
var base_info_staff_search_params = {
	
	verification : function() {
//		if (Ext.getCmp('staffSearchBean.selectName').getValue() == true && ( Ext.getCmp('staffSearchBean.name').getValue() == null || Ext.getCmp('staffSearchBean.name').getValue() == "" )) {
//			showErrorMsg("提示", "请输入员工姓名信息！");
//			return false;
//		}

		return true;
	},
	params : function() {
		var params = {
			optType : "search",
			
//			'searchBean.status' : Ext.getCmp('searchBean.status').getValue(),
//			'searchBean.name' : Ext.getCmp('searchBean.name').getValue(),
//			'searchBean.account' : Ext.getCmp('searchBean.account').getValue(),
//			
//			'searchBean.isStockMan' : Ext.getCmp('searchBean.isStockMan').getValue(),
//			'searchBean.isTransportMan' : Ext.getCmp('searchBean.isTransportMan').getValue(),
//			'searchBean.isBizMan' : Ext.getCmp('searchBean.isBizMan').getValue(),
//			'searchBean.isGoodsMan' : Ext.getCmp('searchBean.isGoodsMan').getValue(),
//			'searchBean.phone' : Ext.getCmp('searchBean.phone').getValue(),
//			'searchBean.address' : Ext.getCmp('searchBean.address').getValue(),
//			'searchBean.sex' : Ext.getCmp('searchBean.sex').getValue(),
//			'searchBean.text' : Ext.getCmp('searchBean.text').getValue()
			
		}
		return params;
	}

}