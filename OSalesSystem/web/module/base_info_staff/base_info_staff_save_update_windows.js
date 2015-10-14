function base_info_staff_save_update_form_panel_windows(params) {

	var form_panel = new Ext.form.ERPFormPanel({
		labelWidth : 55,
		frame : true,
		// bodyStyle : 'padding:5px 5px 0',
		height : 400,
		autoHeight : false,
		items : params.field,
		reader : params.reader
		,
		// buttons : [{
		// text : '提交',
		// listeners : {
		// 'click' : function() {
		// form_panel.submit({
		// url : params.url,
		// waitMsg : '正在提交...',
		// submitEmptyText : false,
		// params : params.params,
		// success : function(json) {
		// if (params.action == "save") {
		// params.grid.insertRow(json[params.pojo]);
		// form_panel.reset();
		// } else {
		// params.grid.updateRow(json[params.pojo]);
		// window.close();
		// }
		//
		// }
		// });
		// }
		// }
		// }, {
		// text : '关闭',
		// listeners : {
		// 'click' : function() {
		// window.close();
		// }
		// }
		// }]
	});

	var tabs = new Ext.TabPanel({
		region : 'center',
		activeTab : 0,
		width : '100%',
		height : '100%',
		plain : true,
		frame : true,
		defaults : {
			autoScroll : false
		},
		items : [{
			id : 'user_info',
			title : '用户信息',
			layout : 'fit',
			border : false,
			bodyStyle : 'background:#dfe8f6;border:0;',
			items : [form_panel]
		}, {
			id : 'user_info_power',
			title : '权限信息',
			layout : 'fit',
			border : false,
			bodyStyle : 'background:#dfe8f6;border:0;',
			autoScroll : false
			,
			// items : [panel]
		}],
		listeners : {
			'tabchange' : function() {// tabchange
				var tab = tabs.getActiveTab();
				if (tab.id == 'user_info_power') {

					// var userId = Ext.getCmp('user.id').getValue();
					// if (userId != 0) {
					// Ext.Ajax.request({
					// url :
					// 'myStruts/SystemUserPowerAction_listPowerByUserId.do',
					// params : {
					// 'user.id' : userId
					// },
					// success : function(response, options) {
					// update_power = true;
					// isPowerTabClick = 1;
					// var json = Ext.decode(response.responseText);
					// if (json.userPowerList.length > 0) {
					// oldUserPowerMenus = cloneObj(json.userPowerList);
					// genNewUserPowerTree(json.userPowerList);
					// powerMenuDraw(right_tree, right_tree.getRootNode(),
					// userPowerMenus);
					// }
					// }
					// });
					// }
				} else if (tab.id == 'user_info') {
					// update_provider = true;
					// authorizeproviderGrid.store.load({
					// params : {
					// start : 0,
					// searchtype : 2
					// }
					// });
					// authorizeproviderGrid.getStore().reload();
				} // end
			}
		}
	});

	var window = new Ext.ERPDefaultsWindow({
		title : params.title,
		closable : true,
		width : 1100,
		height : 500,
		autoHeight : false,
		items : [tabs],
		buttons : [{
			text : '提交',
			listeners : {
				'click' : function() {
					form_panel.submit({
						url : params.url,
						waitMsg : '正在提交...',
						submitEmptyText : false,
						params : params.params,
						success : function(json) {
							if (params.action == "save") {
								params.grid.insertRow(json[params.pojo]);
								form_panel.reset();
							} else {
								params.grid.updateRow(json[params.pojo]);
								window.close();
							}

						}
					});
				}
			}
		}, {
			text : '关闭',
			listeners : {
				'click' : function() {
					window.close();
				}
			}
		}]
	});
	window.showWin();

	this.load = function(params) {
		form_panel.load(params);
	}

	this.closeWindow = function() {
		window.close();
	}

	// return form_panel;
}