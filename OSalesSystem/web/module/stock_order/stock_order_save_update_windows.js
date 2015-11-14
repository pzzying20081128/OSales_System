function stock_order_save_update_form_panel_windows(params, attachesParams) {

	// detailParams : {
	// stockdetail:stockdetail
	// //create_stock_order_detail_window
	// }

	// attachesParams:{
	// detailParams : {
	// stockdetail : stockdetail
	// }
	// }

	var detailParams = attachesParams.detailParams;

	this.loadform = function(data) {
		form_panel.getForm().loadRecord(data);
	}

	var form_panel = new Ext.form.ERPFormPanel({
		labelWidth : 55,
		frame : true,
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
								params.grid.getSelectionModel().selectFirstRow();
								window.close();
								detailParams.stockdetail.openCreateWin();
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