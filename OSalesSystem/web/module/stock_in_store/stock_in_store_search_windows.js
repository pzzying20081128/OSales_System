function stock_in_store_search_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();
	var search_params = params.searchParams;
	var detail_grid = params.detail_grid;
	var form_panel = new Ext.form.ERPFormPanel({
		height : 400,
		// autoHeight : false,
		labelWidth : 60,
		items : [{// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{// 1-1
				columnWidth : 0.5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [{
					id : 'searchBean.stockOrderNumber',
					name : 'searchBean.stockOrderNumber',
					fieldLabel : ' 采购订单号',
					xtype : 'textfield',
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			} // 1-1 end
			, {// 1-1
				columnWidth : 0.5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [{
					id : 'searchBean.stockInStoreNumber',
					name : 'searchBean.stockInStoreNumber',
					fieldLabel : ' 采购入库单号',
					xtype : 'textfield',
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}]
		}, {// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{// 1-1
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 505
				},
				items : [createERPBoxSelect({
					id : 'searchBean.providerInfoIds',
					name : 'searchBean.providerInfoIds',
					fieldLabel : ' 供应商',
					url : "./ProviderInfo_combo.do?searchBean.status=有效",
					allowBlank : true,
					forceSelection : false
				})]
			}]
		}, {
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
					width : 505
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
		}, {
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{
				// 1-1
				columnWidth : 0.5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 205
				},
				items : [createERPBoxSelect({
					id : 'searchBean.recordManIds',
					name : 'searchBean.recordManIds',
					fieldLabel : ' 录入人',
					url : "./SysStaff_combo.do?searchBean.status=全部",
					allowBlank : true,
					forceSelection : false
				})

				]
			}, {
				columnWidth : 0.5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 208
				},
				items : [createERPlocalBoxSelect({
					id : 'searchBean.statuses',
					name : 'searchBean.statuses',
					fieldLabel : ' 状态', // 无效, 删除, 有效, 全部, 初始化, 已审核, 等待其他审核
					localdata : [['删除', "删除"], ['有效', '有效'], ['已审核', '已审核']],
					defaultValue : null,
					allowBlank : true
				})]
			}]
		}, {// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{// 1-1
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 496
				},
				items : [{
					id : 'searchBean.text',
					name : 'searchBean.text',
					fieldLabel : '  备注',
					xtype : 'textfield',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}]
		}, {// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{// 1-1
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 496
				},
				items : [{
					id : 'searchBean.remarks',
					name : 'searchBean.remarks',
					fieldLabel : ' 说明',
					xtype : 'textfield',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
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
						grid.load({
							params : submitValues1,
							success : function() {
								detail_grid.removeAll();
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
		width : 620,
		// height : 400,
		// autoHeight : false,

		items : [form_panel]
	});
	window.showWin();

}