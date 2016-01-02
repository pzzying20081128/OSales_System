function stock_adjust_bill_search_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();
	var search_params = params.searchParams;
	var form_panel = new Ext.form.ERPFormPanel({
		// height : 400,
		// autoHeight : false,
		labelWidth : 60,
		items : [{// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [{
					id : 'stockadjustbill.adjustNum',
					name : 'stockadjustbill.adjustNum',
					fieldLabel : '调整单号',
					xtype : 'textfield',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, // 1-1 end
			{
				columnWidth : .67,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 500
				},
				items : [createERPBoxSelect({
					id : 'stockadjustbill.providerInfoIds',
					name : 'stockadjustbill.providerInfoIds',
					fieldLabel : ' 供应商',
					url : "./ProviderInfo_combo.do?searchBean.status=有效",
					allowBlank : true,
					forceSelection : false
				})]
			}// 1-2end
			]
		}, {// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 208
				},
				items : [createERPlocalBoxSelect({
					id : 'stockadjustbill.adjustTypes',
					name : 'stockadjustbill.adjustTypes',
					fieldLabel : ' 调整类型',
					defaultValue : null,
					localdata : [['票前', "票前"], ['票后', "票后"]],
					allowBlank : true
				})]
			}, // 1-1 end
			{
				columnWidth : .67,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 500
				},
				items : [createERPBoxSelect({
					id : 'stockadjustbill.adjustSubjects',
					name : 'stockadjustbill.adjustSubjects',
					fieldLabel : ' 调整科目',
					url : "./AdjustSubject_combo.do",
					allowBlank : true,
					forceSelection : false
				})]
			}// 1-2end

			]
		}, {// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			items : [ // 1-1 end
			{
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 780
				},
				items : [{
					id : 'stockadjustbill.text',
					name : 'stockadjustbill.text',
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
			}// 1-3 end
			]
		}, {// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{// 1-1
				columnWidth : 0.33,
				layout : 'form',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [{
					id : 'searchBean.startTime',
					name : 'searchBean.startTime',
					fieldLabel : ' 调整日期',
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

				defaults : {
					width : 200
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
			}, {
				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 212
				},
				items : [createERPlocalBoxSelect({
					id : 'searchBean.statusses',
					name : 'searchBean.statuses',
					fieldLabel : ' 状态', // 无效, 删除, 有效, 全部, 初始化, 已审核, 等待其他审核
					localdata : [['删除', "删除"], ['有效', '有效'], ['已审核', '已审核']],
					defaultValue : null,
					allowBlank : true
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