function stock_order_detail_save_update_form_panel_windows(params, detailParams) {
	orderGrid = detailParams.orderGrid;
	var form_panel = new Ext.form.ERPFormPanel({
		labelWidth : 55,
		frame : true,
		// bodyStyle : 'padding:5px 5px 0',
		// height : 400,
		// autoHeight : false,
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
							var json = result.result;
							if (params.action == "save") {
								params.grid.insertRow(json[params.pojo]);
								orderGrid.updateRow(json[params.pojo].stockOrder);
								form_panel.reset();
							} else {
								params.grid.updateRow(json[params.pojo]);
								orderGrid.updateRow(json[params.pojo].stockOrder);
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
		width : 840,
		// height : 400,
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