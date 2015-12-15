function stock_return_search_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();
	var detailGrid =params.detailGrid;
	var search_params = params.searchParams;

	var stockType = createERPlocalBoxSelect({
		id : 'stockreturn.stockType',
		name : 'stockreturn.stockType',
		fieldLabel : ' 退货单类别',
		localdata : [['采购退货单', "采购退货单"], ['直营采购退货单', '直营采购退货单']],
		defaultValue : null,
		allowBlank : true
		,

		// disabled:true
	});

	var form_panel = new Ext.form.ERPFormPanel({
		height : 400,
		// autoHeight : false,
		labelWidth : 60,
		items : [{// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 70,
			items : [{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'stockreturn.number',
					name : 'stockreturn.number',
					fieldLabel : ' 退货单编号',
					xtype : 'textfield',
					// style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					// value : initOrder.number,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, // 1-1 end
			{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 188
				},
				items : [

				createERPlocalBoxSelect({
					id : 'stockreturn.stockProductType',
					name : 'stockreturn.stockProductType',
					fieldLabel : ' 产品类型',
					localdata : [['普通产品', "普通产品"], ['组合产品', '组合产品']],
					defaultValue : null,
					allowBlank : true

				})

				]
			}, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 189
				},
				items : [stockType]
			}]
		},
		// ////////////////////////////////////////////////////////
		{// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 70,
			items : [{
				columnWidth : .66,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 461
				},
				items : [createERPBoxSelect({
					id : 'stockreturn.providerInfoId',
					name : 'stockreturn.providerInfoId',
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
			},

			{
				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 188
				},
				items : [

				createERPlocalBoxSelect({
					id : 'stockreturn.returnType',
					name : 'stockreturn.returnType',
					fieldLabel : ' 退货类型', // 不确定, 开票前退货, 开票后退货
					localdata : [['不确定', "不确定"], ['开票前退货', '开票前退货'], ['开票后退货', '开票后退货']],
					defaultValue : null,
					allowBlank : true

				})

				]
			}]
		}, {// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 70,
			items : [{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [createERPcombo({
					id : 'stockreturn.stockManId',
					name : 'stockreturn.stockManId',
					fieldLabel : ' 采购员',
					url : "./SysStaff_combo.do?searchBean.status=全部",
					allowBlank : true,
					forceSelection : false,
					width : 160
				})]
			}, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 188
				},
				items : [createERPlocalBoxSelect({
					id : 'searchBean.statuses',
					name : 'searchBean.statuses',
					fieldLabel : ' 状态', // 无效, 删除, 有效, 全部, 初始化, 已审核, 等待其他审核
					localdata : [['删除', "删除"], ['有效', '有效'], ['已审核', '已审核']],
					defaultValue : null,
					allowBlank : true
				})]
			}, {

				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'stockreturn.stockManId1',
					name : 'stockreturn.stockManId1',
					fieldLabel : ' 合同',
					xtype : 'textfield',
					// style : AllowBlankStyle,
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
				labelWidth : 70,
			items : [{
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 735
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
		}

		, {
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 70,
			items : [{
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 727
				},
				items : [{
					id : 'stockreturn.text',
					name : 'stockreturn.text',
					fieldLabel : '  备注',
					xtype : 'textfield',
					// style : AllowBlankStyle,
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
			labelWidth : 70,
			items : [{
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 727
				},
				items : [{
					id : 'stockreturn.remarks',
					name : 'stockreturn.remarks',
					fieldLabel : '说明',
					xtype : 'textfield',
					// style : AllowBlankStyle,
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
					detailGrid.removeAll();
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
		width : 860,
		// height : 400,
		// autoHeight : false,

		items : [form_panel]
	});
	window.showWin();

}