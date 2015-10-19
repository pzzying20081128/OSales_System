/**
 * 主要用户设置查询的一些参数
 */
var base_info_staff_search_params = {
	formField : [{// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'searchBean.name',
					name : 'searchBean.name',
					fieldLabel : ' 姓名',
					xtype : 'textfield',
					style : 'background:#fff1a4;',
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, {
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'searchBean.account',
					name : 'searchBean.account',
					fieldLabel : ' 系统用户',
					xtype : 'textfield',
					// style : 'background:#fff1a4;',
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, {
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [createLocalCombo({
					id : 'searchBean.status',
					name : 'searchBean.status',
					fieldLabel : ' 状态', //删除, 有效, 全部
					storeData : [["全部", "全部"], ["有效", "有效"],["删除", "删除"]],
					defaultValue : "全部",
					allowBlank : false
				})]
			}, {}]
		}// end
		, {
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [createLocalCombo({
					id : 'searchBean.isStockMan',
					name : 'searchBean.isStockMan',
					fieldLabel : ' 采购员',
					storeData : [[-1,"全部"],[1, "是"], [0, "否"]],
					defaultValue : -1,
					allowBlank : false
				})]
			}, {
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [createLocalCombo({
					id : 'searchBean.isTransportMan',
					name : 'searchBean.isTransportMan',
					fieldLabel : '  运输员',
					storeData : [[-1,"全部"],[1, "是"], [0, "否"]],
					defaultValue : -1,
					allowBlank : false
				})]
			}, {
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [createLocalCombo({
					id : 'searchBean.isBizMan',
					name : 'searchBean.isBizMan',
					fieldLabel : ' 业务员',
					storeData : [[-1,"全部"],[1, "是"], [0, "否"]],
					defaultValue : -1,
					allowBlank : false
				})]
			}, {

				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [createLocalCombo({
					id : 'searchBean.isGoodsMan',
					name : 'searchBean.isGoodsMan',
					fieldLabel : ' 理货员',
					storeData : [[-1,"全部"],[1, "是"], [0, "否"]],
					defaultValue : -1,
					allowBlank : false,
					listeners : {
						'load' : function(field, e) {

							// this.setValue(1);
						}
					}
				})]
			}]
		}

		, {// start 2
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'searchBean.phone',
					name : 'searchBean.phone',
					fieldLabel : ' 手机',
					xtype : 'textfield',
					// style : 'background:#fff1a4;',
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, {
				columnWidth : .75,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 715
				},
				items : [{
					id : 'searchBean.address',
					name : 'searchBean.address',
					fieldLabel : ' 地址',
					xtype : 'textfield',
					// style : 'background:#fff1a4;',
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}]
		}// end
		, {
			// start 2
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [

				createLocalCombo({
					id : 'searchBean.sex',
					name : 'searchBean.sex',
					fieldLabel : ' 性别',
					storeData : [[-1, "全部"],[1, "男"], [0, "女"]],
					defaultValue : -1,
					allowBlank : true
				})]
			}, {
				columnWidth : .75,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 715
				},
				items : [{
					id : 'searchBean.text',
					name : 'searchBean.text',
					fieldLabel : ' 备注',
					xtype : 'textfield',
					// style : 'background:#fff1a4;',
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}]
		}],
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