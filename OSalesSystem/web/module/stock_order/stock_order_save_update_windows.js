function stock_order_save_update_form_panel_windows(params, detailParams) {

	this.loadform = function(data) {
		form_panel.getForm().loadRecord(data);
	}

	var form_panel = new Ext.form.ERPFormPanel({
		labelWidth : 55,
		frame : true,
		// bodyStyle : 'padding:5px 5px 0',
		// height : 300,
		// autoHeight : true,
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
							if (params.action == "save") {
								params.grid.insertRow(json[params.pojo]);
								window.close();
								// showMsgYN({
								// msg : "是否要同时增加订单明细",
								// yes : function(YN) {
								//										   
								// window.close();
								// stock_order_detail_create_windows(detailParams.moduleId,
								// detailParams.moduleName, {
								// grid : detailParams.detailGrid,
								// orderGrid: detailParams.orderGrid,
								// stockOrder:json[params.pojo]
								// });
								// },
								// no : function() {
								//									
								// // form_panel.reset();
								// window.close();
								// }
								// });

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
		width : 860,
		// height : 300,
		// autoHeight : false,
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