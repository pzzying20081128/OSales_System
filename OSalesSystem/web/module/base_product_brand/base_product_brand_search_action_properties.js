/**
 * 主要用户设置查询的一些参数
 */
var base_product_brand_search_params = {
	formField : [{// 第一排
		layout : 'column',
		baseCls : 'x-plain',
		items : [{
			columnWidth : 1,
			layout : 'form',
			defaultType : 'textfield',
			baseCls : 'x-plain',
			defaults : {
				width : 300
			},
			items : [{
				id : 'searchBean.name',
				name : 'searchBean.name',
				fieldLabel : ' 品牌',
				xtype : 'textfield',
				style : AllowBlankStyle,
				blankText : '不能为空！',
				allowBlank : true,
				listeners : {
					'specialkey' : function(field, e) {
					}
				}
			}]
		}, // 1-1 end
		{
			columnWidth : 1,
			layout : 'form',
			defaultType : 'textfield',
			baseCls : 'x-plain',
			defaults : {
				width : 300
			},
			items : [createLocalCombo({
				id : 'searchBean.status',
				name : 'searchBean.status',
				fieldLabel : ' 状态',
				storeData : [["无效", "无效"], ["删除", "删除"], ["有效", "有效"], ["全部", "全部"]],
				defaultValue : "全部",
				allowBlank : true
			})]
		}// 1-2end
		]
	}],
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