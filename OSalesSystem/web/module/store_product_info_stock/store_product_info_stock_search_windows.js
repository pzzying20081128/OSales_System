function store_product_info_stock_search_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();
	var search_params = params.searchParams;
	var form_panel = new Ext.form.ERPFormPanel({
		height : 400,
		// autoHeight : false,
		labelWidth : 60,
		items : [{

			// 1-1
			columnWidth : 1,
			layout : 'form',
			defaultType : 'textfield',
			baseCls : 'x-plain',
			defaults : {
				width : 460
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

		}, {// 第一排
			layout : 'column',
			baseCls : 'x-plain',
		
			items : [{
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 190
				},
				items : [createERPlocalBoxSelect({
					id : 'searchBean.storeTypes',
					name : 'searchBean.storeTypes',
					fieldLabel : ' 库存类型', // 一般仓库, 专柜, 样品
					localdata : [['一般仓库', "一般仓库"]],
					defaultValue : "一般仓库",
					allowBlank : true
					,

				})]
			}, {
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 195
				},
				items : [createERPBoxSelect({
					id : 'searchBean.storeInfoIds',
					name : 'searchBean.storeInfoIds',
					fieldLabel : ' 仓库',
					url : "./StoreInfo_combo.do",
					params : {
						'searchBean.status' : '有效'
					},
					allowBlank : true,
					forceSelection : false
				})]
			}]
		}

		],
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
						submitValues1["searchBean.temp"]=-1;
						
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
		width : 560,
		// height : 400,
		// autoHeight : false,

		items : [form_panel]
	});
	window.showWin();

}