function base_combined_product_search_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();
	var search_params = params.searchParams;

	var storePosition = createERPcombo({
		id : 'searchBean.storePositionId',
		name : 'searchBean.storePositionId',
		fieldLabel : ' 库位',
		url : "./StorePosition_combo.do",
		allowBlank : true,
		forceSelection : false,
		select : function(combo, record, index) {

		}
	});

	var form_panel = new Ext.form.ERPFormPanel({
		height : 400,
		// autoHeight : false,
		labelWidth : 60,
		items : [{
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'searchBean.name',
					name : 'searchBean.name',
					fieldLabel : ' 产品名称',
					xtype : 'textfield',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'searchBean.shortName',
					name : 'searchBean.shortName',
					fieldLabel : ' 助记符',
					xtype : 'textfield',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, {
				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				labelWidth : 80,
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [{
					id : 'searchBean.barCode',
					name : 'searchBean.barCode',
					fieldLabel : ' 条码',
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
		}, {

			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 187
				},
				items : [createERPBoxSelect({
					id : 'searchBean.productCategoryIds',
					name : 'searchBean.productCategoryIds',
					fieldLabel : ' 产品类型',
					url : "./ProductCategory_combo.do?searchBean.status=有效",
					allowBlank : true,
					forceSelection : false
				})]
			}, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [createERPcombo({
					id : 'searchBean.storeInfoId',
					name : 'searchBean.storeInfoId',
					fieldLabel : ' 仓库',
					url : "./StoreInfo_combo.do?searchBean.status=有效",
					allowBlank : true,
					forceSelection : false,
					select : function(result) {
						id = result.record.id;
						storePosition.load({
							params : {
								'searchBean.storeInfoId' : id,
								'searchBean.status' : '有效'
							}

						});
					}
				})]
			}, {
				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				labelWidth : 80,
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [storePosition]
			}]

		},

		// /////////////////////////////
		{
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{
				columnWidth : .66,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 478
				},
				items : [{
					id : 'searchBean.model',
					name : 'searchBean.model',
					fieldLabel : ' 规格',
					xtype : 'textfield',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, {
				columnWidth : .34,
				labelWidth : 80,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [

				]
			}]
		}, {
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{
				columnWidth : .66,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 486
				},
				items : [createERPBoxSelect({
					id : 'searchBean.providerInfoIds',
					name : 'searchBean.providerInfoIds',
					fieldLabel : ' 供应商',
					url : "./ProviderInfo_combo.do?searchBean.status=有效",
					allowBlank : true,
					forceSelection : false

					// select : function(combo, record, index) {
					// id = record.id;
					// storePosition.load({
					// params : {
					// 'searchBean.storeInfoId' : id,
					// 'searchBean.status' : '有效'
					// }
					//
					// });
					// }
				})]
			}, {

				columnWidth : .34,
				labelWidth : 80,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 208
				},
				items : [createERPBoxSelect({
					id : 'searchBean.productBrandIds',
					name : 'searchBean.productBrandIds',
					fieldLabel : ' 品牌',
					url : "./ProductBrand_combo.do?searchBean.status=有效",
					allowBlank : true,
					forceSelection : false,
					select : function(combo, record, index) {
						id = record.id;
						storePosition.load({
							params : {
								'searchBean.storeInfoId' : id,
								'searchBean.status' : '有效'
							}

						});
					}
				})]

			}

			]
		},
		// //////////////////////////////////////////////////////////////////////////////////////////////
		 {// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 795
				},
				items : [{
					id : 'searchBean.text',
					name : 'searchBean.text',
					fieldLabel : ' 备注',
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
		width : 930,
		// height : 400,
		// autoHeight : false,

		items : [form_panel]
	});
	window.showWin();

}