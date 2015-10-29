/**
 * 主要用户设置查询的一些参数
 */
var sys_opt_history_search_params = {
	verification : function() {
		// if (Ext.getCmp('staffSearchBean.selectName').getValue() == true && (
		// Ext.getCmp('staffSearchBean.name').getValue() == null ||
		// Ext.getCmp('staffSearchBean.name').getValue() == "" )) {
		// showErrorMsg("提示", "请输入员工姓名信息！");
		// return false;
		// }

		return true;
	},
	params : function() {
		var params = {
			optType : "search"
			,
			// 'searchBean.startTime' :
			// Ext.getCmp('searchBean.startTime').getValue(),
			// 'searchBean.endTime' :
			// Ext.getCmp('searchBean.endTime').getValue(),
			// 'searchBean.classification' :
			// Ext.getCmp('searchBean.classification').getValue(),
			// 'searchBean.module' : Ext.getCmp('searchBean.module').getValue(),
			// 'searchBean.sysStaffUserId' :
			// Ext.getCmp('searchBean.sysStaffUserId').getValue(),
			// 'searchBean.text' : Ext.getCmp('searchBean.text').getValue()
		}
		return params;
	}

}