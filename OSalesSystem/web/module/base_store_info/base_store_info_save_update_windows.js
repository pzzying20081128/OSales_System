function base_store_info_save_update_form_panel_windows(params,positonParams) {

	var form_panel = new Ext.form.ERPFormPanel({
		labelWidth : 55,
		frame : true,
		// bodyStyle : 'padding:5px 5px 0',
		// height : 100,
		autoHeight : false,
		items : params.field,
		reader : params.reader,
		buttons : [{
			text : '提交',
			listeners : {
				'click' : function() {
					form_panel.submit({
						url : params.url,
						waitMsg : '正在提交...',
						submitEmptyText : false,
						params : params.params,
						success : function(result) {
							json = result.result;
							params.grid.insertRow(json[params.pojo]);
							if (params.action == "save") {

								showMsgYN({
									msg : "是否要同时增加库位",
									yes : function(YN) {
										   
											window.close();
										base_store_position_create_windows(positonParams.moduleId, positonParams.moduleName, {
											grid : positonParams.positonGrid,
											storeId:json[params.pojo].id
										});
									},
									no : function() {
									
										// form_panel.reset();
										window.close();
									}
								});

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
	var window = new Ext.ERPDefaultsWindow({
		title : params.title,
		closable : true,
		width : 900,
		height : 300,
		autoHeight : false,
		items : [form_panel]
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