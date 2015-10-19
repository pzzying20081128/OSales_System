function base_info_staff_update_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();

	var selection_rows = grid.getSelectionModel().getSelections();

	if (selection_rows == null) {
		showErrorMsg('提示信息', '请选择要编辑的数据记录！！');
		return false;
	}

	if (selection_rows.length != 1) {
		showErrorMsg('提示信息', '编辑只能选择一行数据记录！！');
		return false;
	}
	var selectId = selection_rows[0].id;

	var base_info_staff_params = {
		title : "编辑" + moduleName,
		action : "update",
		grid : grid,
		// 结果路径
		pojo : "systemUserInfo",
		// url
		url : './saveSysStaffinfo.do',
		params : {
			optType : "update",
	   "systemUserInfo.id":selectId
		},
		reader : new Ext.data.JsonReader({
			successProperty : 'success',
			root : 'systemUserInfo',
			totalProperty : 'totalProperty'
		}, [{
			name : 'systemUserInfo.name',
			mapping : 'name'
		}, {
			name : 'systemUserInfo.account',
			mapping : 'account'
		}, {
			name : 'systemUserInfo.sex',
			mapping : 'sex'
		}, {
			name : 'systemUserInfo.phone',
			mapping : 'phone'
		}, {
			name : 'systemUserInfo.cell',
			mapping : 'cell'
		}, {
			name : 'systemUserInfo.address',
			mapping : 'address'
		}, {
			name : 'systemUserInfo.isAdmin',
			mapping : 'isAdmin'
		}, {
			name : 'systemUserInfo.isBizMan',
			mapping : 'isBizMan'
		}, {
			name : 'systemUserInfo.isGoodsMan',
			mapping : 'isGoodsMan'
		}, {
			name : 'systemUserInfo.isStockMan',
			mapping : 'isStockMan'
		}, {
			name : 'systemUserInfo.isTransportMan',
			mapping : 'isTransportMan'
		}, {
			name : 'systemUserInfo.text',
			mapping : 'text'
		}]),
		// 字段
		field : [{// 第一排
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
					id : 'systemUserInfo.name',
					name : 'systemUserInfo.name',
					fieldLabel : ' 姓名',
					xtype : 'textfield',
					style : 'background:#fff1a4;',
					blankText : '不能为空！',
					allowBlank : false,
					editable : false,
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
					id : 'systemUserInfo.account',
					name : 'systemUserInfo.account',
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
				items : [{
					id : 'systemUserInfo.pwd',
					name : 'systemUserInfo.pwd',
					fieldLabel : '登录密码',
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
				items : [{

					id : 'password',
					name : 'password',
					fieldLabel : '登录密码',
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
					id : 'systemUserInfo.isStockMan',
					name : 'systemUserInfo.isStockMan',
					fieldLabel : ' 采购员',
					storeData : [[1, "是"], [0, "否"]],
					defaultValue : 1,
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
					id : 'systemUserInfo.isTransportMan',
					name : 'systemUserInfo.isTransportMan',
					fieldLabel : '  运输员',
					storeData : [[1, "是"], [0, "否"]],
					defaultValue : 1,
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
					id : 'systemUserInfo.isBizMan',
					name : 'systemUserInfo.isBizMan',
					fieldLabel : ' 业务员',
					storeData : [[1, "是"], [0, "否"]],
					defaultValue : 1,
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
					id : 'systemUserInfo.isGoodsMan',
					name : 'systemUserInfo.isGoodsMan',
					fieldLabel : ' 理货员',
					storeData : [[1, "是"], [0, "否"]],
					defaultValue : 1,
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
					id : 'systemUserInfo.phone',
					name : 'systemUserInfo.phone',
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
					id : 'systemUserInfo.address',
					name : 'systemUserInfo.address',
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
					id : 'systemUserInfo.sex',
					name : 'systemUserInfo.sex',
					fieldLabel : ' 性别',
					storeData : [[1, "男"], [0, "女"]],
					defaultValue : null,
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
					id : 'systemUserInfo.text',
					name : 'systemUserInfo.text',
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
		}]

	}

	var base_info_staff_create_window = new base_info_staff_save_update_form_panel_windows(
	base_info_staff_params,{
	  selectId:selectId
	});

	base_info_staff_create_window.load({
		url : './getSysStaffinfo.do?uuid=' + selectId,
		success : function(result) {
//        base_info_staff_create_window.loadPower(selectId);
		}
	});

}