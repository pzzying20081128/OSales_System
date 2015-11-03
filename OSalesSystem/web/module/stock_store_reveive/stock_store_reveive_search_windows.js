function stock_store_reveive_search_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();
	var search_params = params.searchParams;
	var form_panel = new Ext.form.ERPFormPanel({
		// height : 400,
		// autoHeight : false,
		labelWidth : 60,
		items : [

		{ // 第一排
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 570
				},
				items : [{
					id : 'searchBean.number',
					name : 'searchBean.number',
					fieldLabel : ' 采购进货单号',
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
		}// end
		, {
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{
				columnWidth : 0.5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 230
				},
				items : [{
					id : 'searchBean.stockOrderNumber',
					name : 'searchBean.stockOrderNumber',
					fieldLabel : ' 采购订单号',
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
				columnWidth : 0.5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 235
				},
				items : [{
					id : 'searchBean.stockInStoreNumber',
					name : 'searchBean.stockInStoreNumber',
					fieldLabel : ' 采购入库单号',
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
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 570
				},
				items : [createERPcombo({
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
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 570
				},
				items : [createERPcombo({
					id : 'searchBean.productInfoIds',
					name : 'searchBean.productInfoIds',
					fieldLabel : ' 产品',
					url : "./ProductInfo_detailscombo.do?selectype=productInfo",
					params : {
						'searchBean.status' : '有效'
					},
					allowBlank : true,
					forceSelection : false
				})]
			}]
		}

		, {
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{
				columnWidth : 0.5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 230
				},
				items : [createERPlocalBoxSelect({
					id : 'searchBean.stockTypes',
					name : 'searchBean.stockTypes',
					fieldLabel : '订单类型',
					defaultValue : null,
					localdata : [['采购订单', "采购订单"], ['直营采购订单', '直营采购订单']],
					defaultValue : null,
					allowBlank : true
				})]
			}, {
				columnWidth : 0.5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 242
				},
				items : [createERPlocalBoxSelect({
					id : 'searchBean.statuses',
					name : 'searchBean.statuses',
					fieldLabel : '订单状态',
					defaultValue : null,
					localdata : [['有效', "有效"], ['删除', '删除'], ["已审核", "已审核"]],
					defaultValue : null,
					allowBlank : true
				})]
			}]
		}, {
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 80,
			items : [{// 1-1
				columnWidth : 0.5,
				layout : 'form',
				defaultType : 'checkbox',
				baseCls : 'x-plain',
				defaults : {
					width : 230
				},
				items : [{
					id : 'searchBean.startTime',
					name : 'searchBean.startTime',
					fieldLabel : ' 进货时间',
					xtype : 'datefield',
					format : 'Y-m-d',
					// style : NoAllowBlankStyle,
					// blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			},

			{// 1-1
				columnWidth : 0.5,
				layout : 'form',
				defaultType : 'checkbox',
				baseCls : 'x-plain',
				format : 'Y-m-d',
				// labelWidth : 120,
				defaults : {
					width : 235
				},
				items : [{
					id : 'searchBean.endTime',
					name : 'searchBean.endTime',
					fieldLabel : ' 到',
					xtype : 'datefield',
					format : 'Y-m-d',
					// style : NoAllowBlankStyle,
					// blankText : '不能为空！',
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
//							    var     field =   from.findField(param);
//							    var    v =field.getValue();
							if (from.findField(param) && from.findField(param).emptyText == submitValues1[param]) {
								submitValues1[param] = null ;
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
		width : 700,
		// height : 400,
		// autoHeight : false,

		items : [form_panel]
	});
	window.showWin();

}