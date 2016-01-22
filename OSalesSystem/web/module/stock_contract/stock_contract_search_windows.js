function stock_contract_search_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();
	var search_params = params.searchParams;
	var form_panel = new Ext.form.ERPFormPanel({
		height : 400,
		// autoHeight : false,
		labelWidth : 60,
		items : [{// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .70,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 500
				},
				items : [createERPBoxSelect({
					id : 'searchBean.providerInfoIds',
					name : 'searchBean.providerInfoIds',
					fieldLabel : ' 供应商',
					url : "./ProviderInfo_combo.do?searchBean.status=有效",
					allowBlank : true,
					forceSelection : false
				})]
			}, // 1-1 end
			{
				columnWidth : .28,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 160
				},
				items : [createERPBoxSelect({
					id : 'searchBean.stockManIds',
					name : 'searchBean.stockManIds',
					fieldLabel : ' 采购员',
					url : "./SysStaff_combo.do?searchBean.status=全部",
					allowBlank : true,
					forceSelection : false,
					width : 160
				})]
			}// 1-2end
			]
		}, {// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .70,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 500
				},
				items : [createERPBoxSelect({
					id : 'searchBean.companyInfoIds',
					name : 'searchBean.companyInfoIds',
					fieldLabel : ' 公司名称',
					url : "./CompanyInfo_combo.do?searchBean.status=有效",
					allowBlank : true,
					forceSelection : false
				})

				]
			}, // 1-1 end
			{
				columnWidth : .28,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 160
				},
				items : [createERPlocalBoxSelect({
					id : 'searchBean.contractStatuses',
					name : 'searchBean.contractStatuses',
					fieldLabel : ' 合同类型',
					localdata : [['未启用合同', "未启用合同"], ['执行合同', '执行合同'], ['历史合同', '历史合同'], ['待定', '待定']],

					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					defaultValue : "未启用合同",
					allowBlank : true
				})]
			}// 1-2end
			]
		}, {// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .70,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 492
				},
				items : [{
					id : 'searchBean.text',
					name : 'searchBean.text',
					fieldLabel : ' 备注',
					xtype : 'textfield',
					// style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}]
		}, // 1-1 end
		{

			layout : 'column',
			baseCls : 'x-plain',
			items : [{// 1-1
				columnWidth : 0.33,
				layout : 'form',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'searchBean.startTime',
					name : 'searchBean.startTime',
					fieldLabel : ' 签订日期',
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
				columnWidth : 0.33,
				layout : 'form',
				baseCls : 'x-plain',
				format : 'Y-m-d',
				labelWidth : 20,
				defaults : {
					width : 245
				},
				items : [{
					id : 'searchBean.endTime',
					name : 'searchBean.endTime',
					fieldLabel : '     到',
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
		width : 900,
		// height : 400,
		// autoHeight : false,

		items : [form_panel]
	});
	window.showWin();

}