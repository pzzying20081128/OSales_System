function sys_opt_history_search_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();
	var search_params = params.searchParams;
	var form_panel = new Ext.form.ERPFormPanel({
		height : 400,
		// autoHeight : false,
		labelWidth : 60,
		items : [

		{ // 第一排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				// defaults : {
				// width : 250
				// },
				items : [createERPcombo({
					id : 'searchBean.classification',
					name : 'searchBean.classification',
					fieldLabel : ' 类别',
					url : "./SysOptHistoryClassificationModule_combo.do?type=classification",
					allowBlank : true,
					forceSelection : false,
					width : 160
				})]
			}, {
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				// defaults : {
				// width : 250
				// },
				items : [

				createERPcombo({
					id : 'searchBean.module',
					name : 'searchBean.module',
					fieldLabel : ' 模块',
					url : "./SysOptHistoryClassificationModule_combo.do?type=module",
					allowBlank : true,
					forceSelection : false,
					width : 158
				})]
			}]
		}// end
		, {
			layout : 'column',
			baseCls : 'x-plain',
			items : [{// 1-1
				columnWidth : 0.5,
				layout : 'form',
				defaultType : 'checkbox',
				baseCls : 'x-plain',
				defaults : {
					width : 160
				},
				items : [{
					id : 'searchBean.startTime',
					name : 'searchBean.startTime',
					fieldLabel : ' 操作时间',
					xtype : 'datefield',
					format : 'Y-m-d',
					// style : NoAllowBlankStyle,
					// blankText : '不能为空！',
					allowBlank : true,
					width : 160,
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
					width : 160
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
					width : 158,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}]
		}, {

			// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 394
				},
				items : [{
					id : 'searchBean.text',
					name : 'searchBean.text',
					fieldLabel : ' 操作内容',
					xtype : 'textfield',
					// style : NoAllowBlankStyle,
					// blankText : '不能为空！',
					// allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}]

		}, {
			// defaults : {
			// width : 250
			// },

			// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 394
				},
				items : [createERPcombo({
					id : 'searchBean.sysStaffUserId',
					name : 'searchBean.sysStaffUserId',
					fieldLabel : ' 操作人员',
					url : "./SysStaff_combo.do?searchBean.status=全部",
					allowBlank : true,
					forceSelection : false,
					width : 160
				})]
			}]
		}],
		buttons : [{
			text : '提交',
			listeners : {
				'click' : function() {

					if (!search_params.verification())return;
					grid.removeAll();
					from = form_panel.getForm();
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
						// window.close();
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