function base_info_staff_search_windows(moduleId, moduleName, params) {

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
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'searchBean.name',
					name : 'searchBean.name',
					fieldLabel : ' 姓名',
					xtype : 'textfield',
					style : 'background:#fff1a4;',
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, {
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'searchBean.account',
					name : 'searchBean.account',
					fieldLabel : ' 系统用户',
					xtype : 'textfield',
					// style : 'background:#fff1a4;',
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, {
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [createLocalCombo({
					id : 'searchBean.status',
					name : 'searchBean.status',
					fieldLabel : ' 状态', // 删除, 有效, 全部
					storeData : [["全部", "全部"], ["有效", "有效"], ["删除", "删除"]],
					defaultValue : "全部",
					allowBlank : false
				})]
			}, {}]
		}// end
		, {
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [createLocalCombo({
					id : 'searchBean.isStockMan',
					name : 'searchBean.isStockMan',
					fieldLabel : ' 采购员',
					storeData : [[-1, "全部"], [1, "是"], [0, "否"]],
					defaultValue : -1,
					allowBlank : false
				})]
			}, {
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [createLocalCombo({
					id : 'searchBean.isTransportMan',
					name : 'searchBean.isTransportMan',
					fieldLabel : '  运输员',
					storeData : [[-1, "全部"], [1, "是"], [0, "否"]],
					defaultValue : -1,
					allowBlank : false
				})]
			}, {
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [createLocalCombo({
					id : 'searchBean.isBizMan',
					name : 'searchBean.isBizMan',
					fieldLabel : ' 业务员',
					storeData : [[-1, "全部"], [1, "是"], [0, "否"]],
					defaultValue : -1,
					allowBlank : false
				})]
			}, {

				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [createLocalCombo({
					id : 'searchBean.isGoodsMan',
					name : 'searchBean.isGoodsMan',
					fieldLabel : ' 理货员',
					storeData : [[-1, "全部"], [1, "是"], [0, "否"]],
					defaultValue : -1,
					allowBlank : false,
					listeners : {
						'load' : function(field, e) {

							// this.setValue(1);
						}
					}
				})]
			}]
		}

		, {// start 2
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'searchBean.phone',
					name : 'searchBean.phone',
					fieldLabel : ' 手机',
					xtype : 'textfield',
					// style : 'background:#fff1a4;',
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, {
				columnWidth : .75,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 715
				},
				items : [{
					id : 'searchBean.address',
					name : 'searchBean.address',
					fieldLabel : ' 地址',
					xtype : 'textfield',
					// style : 'background:#fff1a4;',
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
			// start 2
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [

				createLocalCombo({
					id : 'searchBean.sex',
					name : 'searchBean.sex',
					fieldLabel : ' 性别',
					storeData : [[-1, "全部"], [1, "男"], [0, "女"]],
					defaultValue : -1,
					allowBlank : true
				})]
			}, {
				columnWidth : .75,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 715
				},
				items : [{
					id : 'searchBean.text',
					name : 'searchBean.text',
					fieldLabel : ' 备注',
					xtype : 'textfield',
					// style : 'background:#fff1a4;',
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}]
		}],
		buttons : [{
			text : '提交',
			listeners : {
				'click' : function() {

					if (!search_params.verification())
						return;
					grid.removeAll();

					// ////////////////////////////////////////////
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
						window.close();
					} else {
						showErrorMsg("错误", "请检查查询数据的正确性");
					}

					// /////////////////////////////////////////////
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
		width : 1100,
		// height : 400,
		// autoHeight : false,

		items : [form_panel]
	});
	window.showWin();

}