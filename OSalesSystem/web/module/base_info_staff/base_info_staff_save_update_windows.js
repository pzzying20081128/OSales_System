function base_info_staff_save_update_form_panel_windows(params, actionParams) {

	var userPowerPanel_ = new UserPowerPanel({
		height : 500
	});

	var form_panel = new Ext.form.ERPFormPanel({
		labelWidth : 55,
		frame : true,
		// bodyStyle : 'padding:5px 5px 0',
		height : 400,
		autoHeight : false,
		items : params.field,
		reader : params.reader
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
			autoScroll : false,
			items : [userPowerPanel_.getPanel()]
		}],
		listeners : {
			'tabchange' : function() {// tabchange
				var tab = tabs.getActiveTab();

				if (tab.id == 'user_info_power') {
					if (typeof ( actionParams ) != "undefined" && typeof ( actionParams.selectId ) != "undefined") {
						userPowerPanel_.load({
							url : "./listPowerByUserId.do",
							params : {
								uuid : actionParams.selectId
							}
						});
					}

				} else if (tab.id == 'user_info') {

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
					userPowerMenus = userPowerPanel_.getUserPowerMenus();
					params.params.power = Ext.encode(userPowerMenus);
					form_panel.submit({
						url : params.url,
						waitMsg : '正在提交...',
						submitEmptyText : false,
						params : params.params,
						success : function(result) {
							json = result.result;
							if (params.action == "save") {
								params.grid.insertRow(json[params.pojo]);
								userPowerPanel_.clearPower();
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

	// loadPower = function(userid) {
	// userPowerPanel_.load({
	// url : "./listPowerByUserId.do",
	// params : {
	// uuid : userid
	// }
	// });
	// }

	this.closeWindow = function() {
		window.close();
	}

	// return form_panel;
}