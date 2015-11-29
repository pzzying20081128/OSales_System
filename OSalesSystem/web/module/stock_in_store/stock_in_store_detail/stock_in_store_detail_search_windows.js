function stock_in_store_detail_search_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();
	var main_Grid = params.main_Grid;
	var search_params = params.searchParams;

	// main_Grid

	var selection_rows = main_Grid.getSelectionModel().getSelections();

	var stockInStoreId = selection_rows[0].id;

	var form_panel = new Ext.form.ERPFormPanel({
		height : 400,
		// autoHeight : false,
		labelWidth : 60,
		items : [{

			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{
				// 1-1
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 380
				},
				items : [createERPBoxSelect({
					id : 'searchBean.productInfoIds',
					name : 'searchBean.productInfoIds',
					fieldLabel : ' 采购产品',
					url : "./ProductInfo_detailscombo.do?selectype=productInfo",
					params : {
						'searchBean.status' : '有效'
					},
					allowBlank : true,
					forceSelection : false
				})]
			}]

		}],
		buttons : [{
			text : '提交',
			listeners : {
				'click' : function() {
					from = form_panel.getForm();
					if (!search_params.verification(from))
						return;
					grid.removeAll();
					if (from.isValid()) {
						var submitValues1 = from.getValues();
						// 对将要提交的参数进行过滤，去掉emptyText文字
						for (var param in submitValues1) {
							if (from.findField(param) && from.findField(param).emptyText == submitValues1[param]) {
								submitValues1[param] = '';
								// thisForm.findField(param).setValue("");
							}
						}

						Ext.apply(submitValues1, search_params.params());
						submitValues1["searchBean.stockInStoreId"] = stockInStoreId;
						grid.load({
							params : submitValues1,
							success : function() {
								window.close();
							}
						});
						window.close();
					} else {
						showErrorMsg("错误", "请检查查询数据的正确性");
					}
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
		title : "查询",
		closable : true,
		width : 500,
		// height : 400,
		// autoHeight : false,

		items : [form_panel]
	});
	window.showWin();

}