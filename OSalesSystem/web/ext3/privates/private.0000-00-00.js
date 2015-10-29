Ext.apply(Ext.form.VTypes, {
	password : function(val, field) {
		if (field.initialPassField) {
			var pwd = Ext.getCmp(field.initialPassField);
			return val == pwd.getValue()
		}
		return true
	},
	passwordText : "两次输入的密码不一致！",
	chinese : function(val, field) {
		var reg = /^[\u4e00-\u9fa5]+$/i;
		if (!reg.test(val))
			return false;
		return true
	},
	chineseText : "请输入中文", 
	age : function(val, field) {
		try {
			if (parseInt(val) >= 18 && parseInt(val) <= 100)
				return true;
			return false
		} catch (err) {
			return false
		}
	},
	ageText : "年龄输入有误",
	alphanum : function(val, field) {
		try {
			if (!/\W/.test(val))
				return true;
			return false
		} catch (e) {
			return false
		}
	},
	alphanumText : "请输入英文字母或是数字,其它字符是不允许的.",
	url : function(val, field) {
		try {
			if (/^(http|https|ftp):\/\/(([A-Z0-9][A-Z0-9_-]*)(\.[A-Z0-9][A-Z0-9_-]*)+)(:(\d+))?\/?/i.test(val))
				return true;
			return false
		} catch (e) {
			return false
		}
	},
	urlText : "请输入有效的URL地址.",
	max : function(val, field) {
		try {
			if (parseFloat(val) <= parseFloat(field.max))
				return true;
			return false
		} catch (e) {
			return false
		}
	},
	maxText : "超过最大值",
	min : function(val, field) {
		try {
			if (parseFloat(val) >= parseFloat(field.min))
				return true;
			return false
		} catch (e) {
			return false
		}
	},
	minText : "小于最小值",
	datecn : function(val, field) {
		try {
			var regex = /^(\d{4})-(\d{2})-(\d{2})$/;
			if (!regex.test(val))
				return false;
			var d = new Date(val.replace(regex, "$1/$2/$3"));
			return parseInt(RegExp.$2, 10) == 1 + d.getMonth() && parseInt(RegExp.$3, 10) == d.getDate() && parseInt(RegExp.$1, 10) == d.getFullYear()
		} catch (e) {
			return false
		}
	},
	datecnText : "请使用这样的日期格式: yyyy-mm-dd. 例如:2008-06-20.",
	integer : function(val, field) {
		try {
			if (/^[-+]?[\d]+$/.test(val))
				return true;
			return false
		} catch (e) {
			return false
		}
	},
	integerText : "请输入正确的整数",
	minlength : function(val, field) {
		try {
			if (val.length >= parseInt(field.minlen))
				return true;
			return false
		} catch (e) {
			return false
		}
	},
	minlengthText : "长度过小",
	maxlength : function(val, field) {
		try {
			if (val.length <= parseInt(field.maxlen))
				return true;
			return false
		} catch (e) {
			return false
		}
	},
	maxlengthText : "长度过大",
	ip : function(val, field) {
		try {
			if (/^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/.test(val))
				return true;
			return false
		} catch (e) {
			return false
		}
	},
	ipText : "请输入正确的IP地址",
	phone : function(val, field) {
		try {
			if (/^((0[1-9]{3})?(0[12][0-9])?[-])?\d{6,8}$/.test(val))
				return true;
			return false
		} catch (e) {
			return false
		}
	},
	phoneText : "请输入正确的电话号码,如:0920-29392929",
	phoneormobilephone : function(val, field) {
		try {
			if (/(^[0-9]{3,4}\-[0-9]{7,8}$)|(^[0-9]{7,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}1[0-9]{10}$)/.test(val))
				return true;
			return false
		} catch (e) {
			return false
		}
	},
	phoneormobilephoneText : "请输入正确的手机号码或电话号码 例如:13916752109或0712-3614072",
	mobilephone : function(val, field) {
		try {
			if (/(^0{0,1}1[0-9]{10}$)/.test(val))
				return true;
			return false
		} catch (e) {
			return false
		}
	},
	mobilephoneText : "请输入正确的手机号码例如:13916752109",
	alpha : function(val, field) {
		try {
			if (/^[a-zA-Z]+$/.test(val))
				return true;
			return false
		} catch (e) {
			return false
		}
	},
	alphaText : "请输入英文字母",
	money : function(val, field) {
		try {
			if (/^(?:[1-9]\d{0,3}|0)(?:\.\d+)?$/.test(val))
				return true;
			else
				return false
		} catch (e) {
			return false
		}
	},
	moneyText : "请输入正确的金额,例如:5.0000",
	tax : function(val, field) {
		try {
			if (/^\d+\.\d{2}$/.test(val))
				return true;
			return false
		} catch (e) {
			return false
		}
	},
	taxText : "请输入正确的税率,例如:17.00"
});
function money_format(v) {
	return v == Math.floor(v) ? v + ".00" : v * 10 == Math.floor(v * 10) ? v + "0" : v
}
function fmoney(s, n) {
	n = n > 0 && n <= 20 ? n : 2;
	s = parseFloat( ( s + "" ).replace(/[^\d\.-]/g, "")).toFixed(n) + "";
	var l = s.split(".")[0].split("").reverse(), r = s.split(".")[1];
	t = "";
	for (i = 0; i < l.length; i++)
		t += l[i] + ( ( i + 1 ) % 3 == 0 && i + 1 != l.length ? "" : "" );
	return t.split("").reverse().join("") + "." + r
};
Ext.ERPDefaultsWindow = Ext.extend(Ext.Window, {
	closable : true,
	plain : true,
	resizable : false,
	layout : "fit",
	modal : true,
	closeAction : "close",
	draggable : true,
	closable : true,
	constrain : true,
	autoDestroy : true,
	maximized : false,
	maximizable : false,
	autoHeight : true,
	split : true,
	listeners : {
		"maximize" : function(e) {
		},
		"minimize" : function(e) {
		},
		"bodyresize" : function(el, w, h) {
		},
		"beforeclose" : function() {
			if (typeof this.grids == "undefined")
				return;
			var grids = this.grids;
			for (var i = 0; i < grids.length; i++)
				grids[i].saveColModule()
		}
	},
	showWin : function() {
		var windows = this;
		windows.show()
	}
});
Ext.ERPWindow = Ext.extend(Ext.Window, {
	closable : true,
	plain : true,
	resizable : true,
	layout : "fit",
	maximizable : true,
	modal : true,
	maximized : true,
	closeAction : "close",
	maximizable : true,
	draggable : true,
	minimizable : true,
	closable : true,
	constrain : true,
	width : 700,
	height : 400,
	listeners : {
		"minimize" : function(e) {
			this.hide()
		},
		"bodyresize" : function(el, w, h) {
		},
		"beforeclose" : function() {
			if (typeof this.grids == "undefined")
				return;
			var grids = this.grids;
			for (var i = 0; i < grids.length; i++)
				grids[i].saveColModule()
		}
	},
	showWin : function(params) {
		var grids = this.grids;
		if (typeof this.moduleId == "undefined")
			showErrorMsg("系统错误", "windows not find moduleId ! moduleId:TREEID");
		var TREEID = null;
		var windows = this;
		var grids = this.grids;
		if (typeof grids != "undefined")
			for (var i = 0; i < grids.length; i++)
				if (typeof params == "undefined")
					grids[i].setPower();
				else if (typeof params.modulePower != "undefined")
					grids[i].setPower(params.modulePower);
		Ext.getCmp("center_panel").removeAll();
		Ext.getCmp("center_panel").add(windows);
		Ext.getCmp("center_panel").doLayout();
		windows.show();
		if (typeof grids != "undefined")
			for (var i = 0; i < grids.length; i++)
				grids[i].removeOptBt()
	}
});
Ext.form.ERPFormPanel = Ext.extend(Ext.form.FormPanel, {
	layout : "form",
	border : false,
	autoWidth : true,
	autoHeight : true,
	plain : true,
	frame : true,
	labelAlign : "center",
	bodyStyle : "border:0 0 0 0;",
	style : "border:0 0 0 0;",
	sync : true,
	fileUpload : false,
	reset : function() {
		this.getForm().reset()
	},
	load : function(properties) {
		var fileUpload_ = this.isfileUpload();
		this.getForm().load({
			url : properties.url,
			waitMsg : "正在载入数据...",
			success : function(form, action) {
				var imageUpload = false;
				if (typeof properties.imageUpload != "undefined")
					imageUpload = properties.imageUpload;
				if (imageUpload == false)
					imageUpload = fileUpload_;
				if (imageUpload == true) {
					var str = action.response.responseText;
					var json = Ext.decode(str);
					var success = json.success;
					if (success) {
						if (typeof properties.success == "function") {
							var responseJSON = action.response.responseJSON;
							properties.success({
								"form" : form,
								"action" : action,
								"result" : responseJSON
							})
						}
					} else {
						var errormsg = json.msg;
						if (typeof properties.errors == "function")
							properties.errors({
								"form" : form,
								"action" : action,
								"errormsg" : errormsg,
								"msgcode" : msgcode
							});
						else
							showErrorMsg("错误提示", errormsg)
					}
				} else {
					var success = action.response.responseJSON.success;
					if (success) {
						if (typeof properties.success == "function") {
							var responseJSON = action.response.responseJSON;
							properties.success({
								"form" : form,
								"action" : action,
								"result" : responseJSON
							})
						}
					} else
						showErrorMsg("错误提示", "提交请求操作失败")
				}
			},
			failure : function(form, action) {
				var failureType = action.failureType;
				var errormsg = action.response.responseJSON.msg;
				if (errormsg == null || errormsg == "")
					showErrorMsg("错误提示", "提交请求操作失败【系统错误[" + failureType + "]】");
				else if (jsonData.msg == 1001 || jsonData.msg == "1001")
					Ext.MessageBox.alert("标题", "用户没有登录/用户超时，请重新登录系统！ ", function() {
						window.location.href = "./"
					});
				else if (typeof properties.errors == "function")
					properties.errors({
						"form" : form,
						"action" : action,
						"errormsg" : errormsg
					});
				else
					showErrorMsg("错误提示", errormsg)
			}
		})
	},
	isfileUpload : function() {
		return this.fileUpload
	},
	submit : function(properties) {
		var imageUpload = false;
		if (typeof properties.imageUpload != "undefined")
			imageUpload = properties.imageUpload;
		if (imageUpload == false) {
			var fileUpload_ = this.isfileUpload();
			imageUpload = fileUpload_
		}
		if (typeof properties.waitMsg == "undefined")
			properties.waitMsg = "正在提交数据...";
		thisForm = this.getForm();
		if (this.getForm().isValid()) {
			var submitValues1 = thisForm.getValues();
			for (var param in submitValues1)
				if (thisForm.findField(param) && thisForm.findField(param).emptyText == submitValues1[param])
					thisForm.findField(param).setValue("")
		} else {
			showErrorMsg("提交错误", "系统错误");
			return
		}
		thisForm.submit({
			timeout : timeout,
			url : properties.url,
			waitMsg : properties.waitMsg,
			submitEmptyText : false,
			params : properties.params,
			success : function(form, action) {
				if (imageUpload == true) {
					var str = action.response.responseText;
					var json = Ext.decode(str);
					if (json.success) {
						if (typeof properties.success == "function")
							properties.success({
								"form" : form,
								"action" : action,
								"result" : json
							})
					} else {
						var errormsg = json.msg;
						if (typeof properties.errors == "function")
							properties.errors({
								"form" : form,
								"action" : action,
								"errormsg" : errormsg,
								"msgcode" : msgcode
							});
						else
							showErrorMsg("错误提示", errormsg)
					}
				} else if (typeof properties.success == "function") {
					var json = action.response.responseJSON;
					properties.success({
						"form" : form,
						"action" : action,
						"result" : json
					})
				}
			},
			failure : function(form, action) {
				if (action.failureType == "client")
					showErrorMsg("错误提示", "请检查要保存的信息是否正确!");
				else if (action.failureType == "connect")
					showErrorMsg("错误提示", "系统错误【链接错误】");
				else {
					var result = action.result;
					var errormsg = result.msg;
					var msgcode = result.msgcode;
					if (errormsg == null || errormsg == "")
						showErrorMsg("错误提示", "提交请求操作失败");
					else if (typeof properties.errors == "function")
						properties.errors({
							"form" : form,
							"errormsg" : errormsg,
							"msgcode" : msgcode
						});
					else
						showErrorMsg("错误提示", errormsg)
				}
			}
		})
	}
});
function updateUserPasswd() {
	updateUserPasswdWindows()
}
function IndexPanel(userId, userName, loginUser, regGUest, properties) {
	Ext.Msg.buttonText.yes = "确定";
	Ext.Msg.buttonText.no = "取消";
	Ext.QuickTips.init();
	Ext.form.Field.prototype.msgTarget = "side";
	var win, wp, window, tabs, grid;
	var north = new Ext.Panel({
		region : "north",
		margins : "3 3 0 3",
		height : 68,
		html : '\x3ctable id\x3d"img"  width\x3d"100%" height\x3d"68" border\x3d"0" cellpadding\x3d"0" cellspacing\x3d"0" \x3e' + '\x3ctr\x3e\x3ctd width\x3d"30%"\x3e\x26nbsp;\x3c/td\x3e\x3ctd width\x3d"70%" valign\x3d"bottom"\x3e' + '\x3cdiv align\x3d"right" style\x3d"font-size: 16px;color: #0FFFFF;font-weight: bold;padding-bottom: 15px"  id\x3d"welcome"\x3e' + regGUest + " 欢迎：" + loginUser + "（" + userName + "） " + '\x3ca style\x3d"cursor: pointer;"  onclick\x3d"updateUserPasswd()" \x3e修改密码\x3c/a\x3e\x26nbsp; \x3ca style\x3d"cursor: pointer;"  onclick\x3d"unlogin()" \x3e退出 \x3c/a\x3e  \x26nbsp;\x26nbsp;\x26nbsp;\x3c/div\x3e\x3c/td\x3e\x3c/tr\x3e\x3c/table\x3e',
		bodyStyle : "background:url(ext3/privates/images/top.gif)  left top no-repeat;filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod\x3d'scale');-moz-background-size:100% 100%;background-size:100% 100%"
	});
	var center = new Ext.Panel({
		id : "center_panel",
		region : "center",
		margins : "3 3 3 0",
		width : "100%",
		bodyStyle : "background:url(ext3/privates/images/work_area.gif)  left top no-repeat;filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod\x3d'scale');-moz-background-size:100% 100%;background-size:100% 100%"
	});
	var root = new Ext.tree.AsyncTreeNode({
		id : "root",
		text : "根节点",
		loader : new Ext.tree.TreeLoader({
			preloadChildren : true,
			dataUrl : "./showUserPowerMeuns.do",
			listeners : {
				"load" : function(this_, node, response) {
					var responseText = response.responseText;
					var json = Ext.decode(responseText);
					if (json.success == false && json.msg == 1001)
						tohome()
				}
			}
		})
	});
	var tree = new Ext.tree.TreePanel({
		root : root,
		animate : true,
		rootVisible : false,
		autoWidth : true,
		autoHeigth : true,
		listeners : {
			"dblclick" : function(node) {
			},
			"click" : function(node) {
				properties.openModule(node, userId)
			}
		}
	});
	var west = new Ext.Panel({
		region : "west",
		split : true,
		width : 200,
		minSize : 200,
		maxSize : 200,
		collapsible : false,
		margins : "2 0 2 2",
		cmargins : "0 0 0 0",
		rootVisible : false,
		lines : false,
		autoScroll : true,
		animCollapse : false,
		animate : false,
		bodyStyle : "background:#f1f1f1",
		title : "功能菜单",
		layout : "fit",
		items : [tree],
		listeners : {
			"collapse" : function() {
			},
			"expand" : function() {
			}
		}
	});
	west.on("render", function() {
		west.getEl().on("dblclick", function() {
		})
	}, this);
	var createWin = function() {
		win = new Ext.Viewport({
			layout : "border",
			items : [north, west, center]
		});
		Ext.EventManager.onWindowResize(function() {
			center.width = "100%";
			center.doLayout()
		});
		tree.getRootNode().expand(true);
		return
	};
	createWin();
	win.show()
};
Ext.data.ERPStore = Ext.extend(Ext.data.Store, {
	remoteSort : true,
	listeners : {
		"beforeload" : function(store, options) {
			var o = store.baseParams;
			Ext.apply(o, options.params);
			this.baseParams = o
		}
	}
});
Ext.grid.ERPGridPanel = Ext.extend(Ext.grid.GridPanel, {
	region : "north",
	split : true,
	height : "100%",
	width : "100%",
	columnLines : true,
	stripeRows : true,
	loadMask : true,
	inits : false,
	savecol : false,
	checkboxColumn : null,
	rowdblclickKey : null,
	powerMap : null,
	isAdmin : false,
	setPowerList : function(powerList_) {
		var map = new Map;
		if (powerList_ == null)
			return;
		for (var i = 0; i < powerList_.length; i++)
			map.put(powerList_[i].powerName, powerList_[i]);
		this.powerMap = map
	},
	setIsAdmin : function(isAdmin_) {
		this.isAdmin = isAdmin_
	},
	getPowerMap : function() {
		var grid = this.getGrid();
		return grid.powerMap
	},
	getisAdmin : function() {
		var grid = this.getGrid();
		return grid.isAdmin
	},
	searchPower : function(key) {
		var _map_ = this.getPowerMap();
		power = _map_.get(key);
		return power
	},
	openAllButton : function(isOpen) {
		var _map_ = this.getPowerMap();
		var tbar = this.getTopToolbar();
		var items = tbar.items.items;
		for (var i = 0; i < items.length; i++) {
			var opt = items[i];
			if (isOpen == true)
				opt.enable();
			else
				opt.disable()
		}
	},
	openButton : function(isOpen) {
		var grid = this.getGrid();
		var isAdmin = grid.isAdmin;
		if (isAdmin == 1)
			this.openAllButton(true);
		else {
			var _map_ = this.getPowerMap();
			var tbar = this.getTopToolbar();
			var items = tbar.items.items;
			for (var i = 0; i < items.length; i++) {
				var opt = items[i];
				var power = _map_.get(opt.key);
				if (power == null)
					alert(opt.text + "  is set error ! ");
				else if (power.isUse == 1 && isOpen == true)
					opt.enable();
				else
					opt.disable()
			}
		}
	},
	isHavePower : function(optName) {
		if (this.powerList == null)
			return false;
		for (var i = 0; i < this.powerList.length; i++)
			if (this.powerList[i].optName == optName)
				return this.powerList[i].use === 1;
		return false
	},
	setCheckboxColumn : function(checkboxColumn) {
		this.checkboxColumn = checkboxColumn
	},
	getCheckboxColumn : function() {
		return this.checkboxColumn
	},
	getGrid : function() {
		return this
	},
	updateRowfieldValue : function(filedName, value) {
		var record = this.getGrid().getSelectionModel().getSelected();
		record.set(filedName, value)
	},
	insertRow : function(object) {
		var grid = this.getGrid();
		var record = new grid.store.recordType(object, object.id);
		grid.getStore().insert(0, record);
		var fieldses = record.fields;
		for (var j = 0; j < fieldses.keys.length; j++) {
			var field_ = fieldses.items[j];
			var fieldName;
			if (field_.mapping != null && typeof field_.mapping != "undefined")
				fieldName = field_.mapping;
			else
				fieldName = field_.name;
			var value = object[fieldName];
			record.set(field_.name, value)
		}
		record.commit()
	},
	updateRow : function(object) {
		var record = this.getGrid().getSelectionModel().getSelected();
		var fieldses = record.fields;
		for (var j = 0; j < fieldses.keys.length; j++) {
			var field_ = fieldses.items[j];
			var fieldName;
			if (field_.mapping != null && typeof field_.mapping != "undefined")
				fieldName = field_.mapping;
			else
				fieldName = field_.name;
			var value = object[fieldName];
			record.set(field_.name, value)
		}
		record.commit()
	},
	viewConfig : {
		forceFit : false,
		autoScroll : true
	},
	onRowDblClick : function(g, rowIndex, e) {
		var rowdblclickKey_ = this.rowdblclickKey;
		var moduleId = this.moduleId;
		if (rowdblclickKey_ == null || typeof rowdblclickKey_ == "undefined")
			rowdblclickKey_ = moduleId + "_edit";
		if (!this.isHavePower(rowdblclickKey_))
			return;
		var toolbar = this.getTopToolbar();
		var edittoolbar = toolbar.getComponent(rowdblclickKey_);
		if (typeof edittoolbar != "undefined")
			edittoolbar.handler.call(edittoolbar)
	},
	initComponent : function() {
		Ext.grid.ERPGridPanel.superclass.initComponent.call(this);
		this.on("rowdblclick", this.onRowDblClick, this);
		var cmConfigs = this.colModel.config;
		for (var j = 0; j < cmConfigs.length; j++) {
			var cmConfig_ = cmConfigs[j];
			if (typeof cmConfig_.id != "undefined" && cmConfig_.id == "isSelect") {
				this.setCheckboxColumn(cmConfig_);
				this.on("headerclick", function(ct, column, e, t, opts) {
					var cmConfig_ = this.getCheckboxColumn();
					var selectAllParmas = cmConfig_.selectAll;
					var isSelect_ = selectAllParmas.isSelect;
					selectAllParmas.params.isSelect = isSelect_;
					selectAllParmas.params.type = "all";
					this.selectAction(selectAllParmas, this.getColumnModel(), this.store)
				})
			}
		}
	},
	selectAction : function(selectAllParmas, columnModel, store_) {
		var selectAll_ = this.selectAll;
		ERPAjaxRequest({
			url : selectAllParmas.url,
			params : selectAllParmas.params,
			success : function(result) {
				var isSelect = result.result.isSelect;
				selectAllParmas.isSelect = isSelect;
				if (isSelect == 0)
					columnModel.setColumnHeader(1, '\x3cimg  src\x3d"./images/js/checkbox_no.png"\x3e');
				else
					columnModel.setColumnHeader(1, '\x3cimg  src\x3d"./images/js/checkbox_yes.png"\x3e');
				selectAll_(isSelect, store_)
			}
		})
	},
	selectAll : function(isSelect, store_) {
		for (var i = 0; i < store_.getCount(); i++) {
			var record = store_.getAt(i);
			record.set("isSelect", isSelect)
		}
	},
	getSelectCount : function() {
		var s = 0;
		for (var i = 0; i < this.store.getCount(); i++) {
			var record = this.store.getAt(i);
			if (record.get("isSelect") == 1)
				s = s + 1
		}
		return s
	},
	getSelectRow : function() {
		var list_id = new Array(0);
		for (var i = 0; i < this.store.getCount(); i++) {
			var record = this.store.getAt(i);
			if (record.get("isSelect") == 1)
				list_id.push(record)
		}
		return list_id
	},
	removeAll : function() {
		this.store.removeAll()
	},
	saveColModule : function() {
		var colModel_ = this.colModel;
		var moduleId = this.moduleId;
		if (typeof moduleId == "undefined") {
			showErrorMsg("系统错误", "ERPGridPanel saveColModule not find moduleId ! moduleId:TREEID");
			return
		}
		var cmConfigs = colModel_.config;
		var data_indexs = null;
		var col_indexs = null;
		var col_names = null;
		var col_hiddens = null;
		var col_widths = null;
		for (var i = 1; i < cmConfigs.length; i++) {
			var cmConfig = cmConfigs[i];
			if (typeof cmConfig.dataIndex == "undefined" || cmConfig.dataIndex == "")
				continue;
			var hidden = cmConfig.hidden == null ? "0" : cmConfig.hidden == true ? 1 : 0;
			var dataIndex_ = cmConfig.dataIndex;
			if (data_indexs != null)
				data_indexs = data_indexs + ";" + dataIndex_;
			else
				data_indexs = dataIndex_;
			if (col_names != null)
				col_names = col_names + ";" + cmConfig.header;
			else
				col_names = cmConfig.header;
			if (col_widths != null)
				col_widths = col_widths + ";" + cmConfig.width;
			else
				col_widths = cmConfig.width;
			if (col_hiddens != null)
				col_hiddens = col_hiddens + ";" + hidden;
			else
				col_hiddens = hidden;
			if (col_indexs != null)
				col_indexs = col_indexs + ";" + i;
			else
				col_indexs = i
		}
		Ext.Ajax.request({
			url : "sysuser/col_chonig_opt.action",
			params : {
				module_name : moduleId,
				data_indexs : data_indexs,
				col_names : col_names,
				col_hiddens : col_hiddens,
				col_widths : col_widths,
				col_indexs : col_indexs
			},
			success : function(response, options) {
			}
		});
		for (var i = 1; i < cmConfigs.length; i++) {
			var cmConfig = cmConfigs[i];
			var hidden = cmConfig.hidden == null ? "0" : cmConfig.hidden == true ? 1 : 0;
			var dataIndex_ = cmConfig.dataIndex;
			Ext.Ajax.request({
				url : "sysuser/col_move_opt.action",
				params : {
					module_name : moduleId,
					old_colIndex : 0,
					new_colIndex : i,
					dataIndex : dataIndex_,
					col_name : cmConfig.header,
					is_hidden : hidden
				},
				success : function(response, options) {
				}
			})
		}
	},
	removeOptBt : function() {
	},
	setPower : function(modulePower_) {
		var moduleId = this.moduleId;
		var grid = this.getGrid();
		ERPAjaxRequest({
			url : "./power.do",
			params : {
				moduleId : moduleId
			},
			success : function(result) {
				var json = result.result;
				var powerMap = json.powerMap;
				var power = powerMap[moduleId];
				var isAdmin_ = json.isroot;
				grid.setIsAdmin(isAdmin_);
				if (power == null || typeof power == "undefined")
					grid.setPowerList(null);
				else {
					grid.setPowerList(power);
					for (var ij = 0; ij < power.length; ij++) {
						var buttonCmp = Ext.getCmp(moduleId + "_" + power[ij].powerName);
						if (typeof buttonCmp != "undefined")
							if (power[ij].isUse == 1)
								buttonCmp.show();
							else
								buttonCmp.hide()
					}
					if (modulePower_ != null && typeof modulePower_ != "undefined")
						modulePower_.modulePower(moduleId, power)
				}
				return json
			}
		})
	},
	initPanel : function(prams) {
		var moduleId = this.moduleId;
		if (typeof moduleId == "undefined") {
			showErrorMsg("系统错误", "ERPGridPanel  initPanel not find moduleId ! moduleId:TREEID");
			return
		}
		var colModel_ = this.colModel;
		var checkName_ = this.checkName;
		var selModule = this.selModel;
		var thisGrid = this;
		var setInits = this.setInits;
		colModel_.on("hiddenchange", function(cm, columnIndex, hidden) {
		});
		colModel_.on("columnmoved", function(cm, oldIndex, newIndex) {
		});
		this.getSelectionModel().on("rowselect", function(sm, rowIdx, r) {
			if (typeof prams == "undefined")
				return;
			dataJson = typeof r.json == "undefined" ? r.data : r.json;
			if (typeof prams.select != "undefined" && typeof prams.select == "function")
				prams.select(r.id, dataJson, sm, rowIdx, r)
		})
	},
	load : function(loadParams) {
		var store_ = this.store;
		store_.removeAll();
		store_.baseParams = {};
		if (typeof loadParams === "undefined")
			loadParams = {
				params : {
					limit : erp_grid_panel_limit,
					start : 0
				}
			};
		else if (typeof loadParams.params === "undefined")
			loadParams.params = {
				limit : erp_grid_panel_limit,
				start : 0
			};
		else {
			loadParams.params.limit = erp_grid_panel_limit;
			loadParams.params.start = 0
		}
		if (typeof loadParams.sortInfo == "undefined")
			loadParams.sortInfo = {
				sort : "id",
				dir : "desc"
			};
		if (typeof store_.sortInfo == "undefined")
			store_.sortInfo = {
				field : loadParams.sortInfo.sort,
				direction : loadParams.sortInfo.dir
			};
		else {
			store_.sortInfo.field = loadParams.sortInfo.sort;
			store_.sortInfo.direction = loadParams.sortInfo.dir
		}
		store_.load({
			params : loadParams.params,
			callback : function(r, options, success, action) {
				if (success == false)
					if (loadParams != null) {
						var jsonData = store_.reader.jsonData;
						if (typeof loadParams.errors == "function")
							if (typeof jsonData === "undefined" || typeof jsonData.msg === "undefined")
								showErrorMsg("失败", "数据请求失败【未知错误  -1 】！");
							else if (jsonData.msg == 1001 || jsonData.msg == "1001")
								Ext.MessageBox.alert("标题", "用户没有登录/用户超时，请重新登录系统！ ", function() {
									window.location.href = "./"
								});
							else if (jsonData.msg == 1E4 || jsonData.msg == "10000")
								showErrorMsg("失败", "数据请求失败【系统错误 10000 】！");
							else if (jsonData.msg == null)
								showErrorMsg("失败", "数据请求失败【未知错误 -2 】！");
							else
								loadParams.errors({
									"r" : r,
									"options" : options,
									"result" : jsonData
								});
						else if (typeof jsonData === "undefined" || typeof jsonData.msg === "undefined")
							showErrorMsg("失败", "数据请求失败【未知错误  -1 】！");
						else if (jsonData.msg == 1001 || jsonData.msg == "1001")
							Ext.MessageBox.alert("标题", "用户没有登录/用户超时，请重新登录系统！ ", function() {
								window.location.href = "./"
							});
						else
							Ext.MessageBox.alert("失败", "数据请求失败【系统错误 -3 】！")
					} else
						showErrorMsg("失败", "数据请求失败【未知错误 -4】！");
				else if (typeof loadParams.success == "function") {
					var jsonData = store_.reader.jsonData;
					loadParams.success({
						"r" : r,
						"options" : options,
						"result" : jsonData
					})
				}
			}
		})
	},
	reload : function(loadParams) {
		var store = this.store;
		store.removeAll();
		store.reload({
			callback : function(r, options, success) {
				if (!success)
					if (loadParams != null) {
						if (typeof loadParams.errors == "function") {
							var jsonData = store_.reader.jsonData;
							if (typeof jsonData === "undefined" || typeof jsonData.msg === "undefined")
								showErrorMsg("失败", "数据请求失败【未知错误  -1 】！");
							else if (jsonData.msg == 1001 || jsonData.msg == "1001")
								Ext.MessageBox.alert("标题", "用户没有登录/用户超时，请重新登录系统！ ", function() {
									window.location.href = "./"
								});
							else if (jsonData.msg == 1E4 || jsonData.msg == "10000")
								showErrorMsg("失败", "数据请求失败【系统错误 10000 】！");
							else if (jsonData.msg == null)
								showErrorMsg("失败", "数据请求失败【未知错误 -2 】！");
							else
								loadParams.errors({
									"r" : r,
									"options" : options,
									"result" : jsonData
								})
						}
					} else
						showErrorMsg("信息提示", "加载数据失败！");
				else if (loadParams != null) {
					if (typeof loadParams.success == "function")
						var jsonData = store.reader.jsonData;
					loadParams.success({
						"r" : r,
						"options" : options,
						"result" : jsonData
					})
				} else
					;
			}
		})
	}
});
Ext.grid.ERPRowNumberer = Ext.extend(Ext.grid.RowNumberer, {
	width : 40,
	sortable : false,
	resizable : true,
	draggable : false,
	hideable : false,
	menuDisabled : true,
	renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		var gridTotalType = record.get("gridTotalType");
		if (gridTotalType == "PageTotal") {
			cellmeta.attr = 'style\x3d"background-color: #C9D8FC"';
			return "合计"
		} else if (gridTotalType == "AllTotal") {
			cellmeta.attr = 'style\x3d"background-color: #C9D8FC"';
			return "总计"
		} else if (store.lastOptions != null && store.lastOptions.params != null) {
			var pageindex = store.lastOptions.params.start;
			return pageindex + rowIndex + 1
		} else
			return rowIndex + 1
	}
});
var timeout = 1E4 * 8E3;
var erp_grid_panel_limit = 40;
var NoAllowBlankStyle = "background:#fff1a4;";
var AllowBlankStyle = "background:#ffffff;";
var NoAllowBlankColor = "#fff1a4";
var AllowBlankColor = "#ffffff";
function updateUserPasswdWindows() {
	var form_panel = new Ext.form.ERPFormPanel({
		labelWidth : 55,
		frame : true,
		height : 400,
		autoHeight : false,
		items : [{
			layout : "column",
			baseCls : "x-plain",
			items : [{
				columnWidth : 1,
				layout : "form",
				baseCls : "x-plain",
				defaultType : "textfield",
				defaults : {
					width : 300
				},
				items : [{
					id : "systemUserInfo.accessPassword1",
					name : "systemUserInfo.accessPassword",
					fieldLabel : " 新密码",
					xtype : "textfield",
					inputType : "password",
					style : "background:#fff1a4;",
					blankText : "不能为空！",
					allowBlank : false,
					listeners : {
						"specialkey" : function(field, e) {
						}
					}
				}]
			}]
		}, {
			layout : "column",
			baseCls : "x-plain",
			items : [{
				columnWidth : 1,
				layout : "form",
				baseCls : "x-plain",
				defaultType : "textfield",
				defaults : {
					width : 300
				},
				items : [{
					id : "systemUserInfo.accessPassword2",
					fieldLabel : " 重复密码",
					xtype : "textfield",
					inputType : "password",
					style : "background:#fff1a4;",
					blankText : "不能为空！",
					allowBlank : false,
					listeners : {
						"specialkey" : function(field, e) {
						}
					}
				}]
			}]
		}],
		buttons : [{
			text : "提交",
			listeners : {
				"click" : function() {
					var p2 = Ext.getCmp("systemUserInfo.accessPassword2").getValue();
					var p1 = Ext.getCmp("systemUserInfo.accessPassword1").getValue();
					if (p1 != p2) {
						showErrorMsg("错误", "两次输入的密码不一样");
						return
					}
					form_panel.submit({
						url : "./updatePassword.do",
						waitMsg : "正在提交...",
						submitEmptyText : false,
						success : function(json) {
							window.close();
							showErrorMsg("成功", "修改密码成功")
						}
					})
				}
			}
		}, {
			text : "关闭",
			listeners : {
				"click" : function() {
					window.close()
				}
			}
		}]
	});
	var window = new Ext.ERPDefaultsWindow({
		title : "修改密码",
		closable : true,
		width : 300,
		height : 200,
		autoHeight : false,
		items : [form_panel]
	});
	window.showWin();
	this.load = function(params) {
		form_panel.load(params)
	};
	this.closeWindow = function() {
		window.close()
	}
};
Array.prototype.del = function(index) {
	if (isNaN(index) || index >= this.length)
		return false;
	for (var i = 0, n = 0; i < this.length; i++)
		if (this[i] != this[index])
			this[n++] = this[i];
	this.length -= 1
};
function UserPowerPanel(params) {
	var height = params.height;
	var powerMenus = {};
	var oldUserPowerMenus = [];
	var userPowerMenus = {};
	var left_tree_id = "";
	var right_tree_id = "";
	var update_power = false;
	var update_provider = false;
	var update_guest = false;
	var userPowerMenus = {};
	this.getUserPowerMenus = function() {
		return userPowerMenus
	};
	var root = new Ext.tree.AsyncTreeNode({
		text : "根节点",
		loader : new Ext.tree.TreeLoader({
			preloadChildren : false,
			dataUrl : "./filterUserPowerTree.do",
			listeners : {
				load : function(thiz, node, response) {
					powerMenus = Ext.decode(response.responseText)
				}
			}
		})
	});
	var left_tree = new Ext.tree.TreePanel({
		border : false,
		root : root,
		animate : false,
		autoScroll : true,
		width : 500,
		rootVisible : false,
		listeners : {
			"click" : function(node, e) {
				left_tree_id = node.id
			}
		}
	});
	this.clearPower = function() {
		power_manage_remove_all_node()
	};
	var root2 = new Ext.tree.AsyncTreeNode({
		text : "根节点",
		loader : new Ext.tree.TreeLoader({
			preloadChildren : false,
			dataUrl : "myStruts/ShowTree_showExistPowerTree.do"
		})
	});
	var right_tree = new Ext.tree.TreePanel({
		id : "system_user_right_tree",
		border : false,
		root : new Ext.tree.TreeLoader,
		animate : false,
		rootVisible : false,
		width : 500,
		listeners : {
			"click" : function(node, e) {
				right_tree_id = node.id;
				redrawCheckPanel(null)
			},
			"afterlayout" : function(node, e) {
			}
		}
	});
	var power_check_panel = new Ext.Panel({
		title : "已选权限",
		region : "center",
		layout : "fit",
		border : false,
		bodyBorder : false,
		height : height,
		items : [{
			autoScroll : true,
			items : [],
			xtype : "panel",
			height : height,
			border : false,
			bodyBorder : false
		}]
	});
	var userPowerPanel = new Ext.Panel({
		layout : "column",
		autoScroll : false,
		border : false,
		bodyBorder : false,
		height : height,
		items : [{
			width : 400,
			autoScroll : false,
			items : [new Ext.Panel({
				region : "center",
				layout : "fit",
				border : false,
				bodyBorder : false,
				items : [{
					title : "可选模块",
					autoScroll : true,
					items : [left_tree],
					xtype : "panel",
					height : height,
					border : false,
					bodyBorder : false
				}]
			})]
		}, {
			width : 50,
			autoWidth : true,
			baseCls : "x-plain",
			defaults : {
				style : "margin:30px 0"
			},
			items : [{
				xtype : "button",
				width : 40,
				text : "\x3c",
				style : "margin-top:80px",
				handler : function() {
					power_manage_remove_right_select_node()
				}
			}, {
				xtype : "button",
				width : 40,
				text : "\x3e",
				handler : function() {
					power_manage_add_selected_module()
				}
			}, {
				xtype : "button",
				width : 40,
				text : "\x3c\x3c",
				handler : function() {
					power_manage_remove_all_node()
				}
			}, {
				xtype : "button",
				width : 40,
				text : "\x3e\x3e",
				handler : function() {
					power_manage_add_all_module()
				}
			}]
		}, {
			width : 400,
			baseCls : "x-plain",
			autoScroll : true,
			items : [new Ext.Panel({
				region : "center",
				layout : "fit",
				title : "已选模块",
				items : [{
					autoScroll : true,
					items : [right_tree],
					xtype : "panel",
					height : height,
					border : false,
					bodyBorder : false
				}]
			})]
		}, {
			width : 242,
			autoScroll : true,
			items : [power_check_panel]
		}]
	});
	this.getPanel = function() {
		return userPowerPanel
	};
	function cloneObj(obj) {
		return Ext.decode(Ext.encode(obj))
	}
	function setOldUserPowerMenus_(oldUserPowerMenus_) {
		oldUserPowerMenus = oldUserPowerMenus_
	}
	function getUserPowerJson(myUserPowerMenus) {
		for (var i = 0; i < myUserPowerMenus.children.length; i++)
			if (typeof myUserPowerMenus.children[i]["id"] != "undefined")
				if (right_tree_id == myUserPowerMenus.children[i]["id"])
					return myUserPowerMenus.children[i]["powers"];
				else {
					var res = getUserPowerJson(myUserPowerMenus.children[i]);
					if (res != null)
						return res
				}
		return null
	}
	function setUserPowerJson(myUserPowerMenus, powerText) {
		for (var i = 0; i < myUserPowerMenus.children.length; i++)
			if (typeof myUserPowerMenus.children[i]["id"] != "undefined")
				if (right_tree_id == myUserPowerMenus.children[i]["id"]) {
					myUserPowerMenus.children[i]["powers"] = powerText;
					return 1
				} else {
					var res = setUserPowerJson(myUserPowerMenus.children[i], powerText);
					if (res != null)
						return
				}
		return null
	}
	var isAllCheckedEnable = false;
	var isSingleCheckedEnable = false;
	function redrawCheckPanel(data) {
		if (data != null)
			setUserPowerJson(userPowerMenus, Ext.encode(data));
		var powerCheckPanel = power_check_panel;
		powerCheckPanel.items.items[0].removeAll();
		var data = Ext.decode(getUserPowerJson(userPowerMenus));
		if (data.length > 0) {
			var power_all = new Ext.form.Checkbox({
				boxLabel : "全选",
				tvalue : tmp_key,
				handler : function(f, c) {
					if (isAllCheckedEnable) {
						isAllCheckedEnable = false;
						isSingleCheckedEnable = false;
						checkedAll(powerCheckPanel, data, c)
					}
				}
			});
			powerCheckPanel.items.items[0].add(power_all);
			var is_check_all = true;
			for (var i = 0; i < data.length; i++) {
				var tmp_key = "";
				for (var key in data[i])
					if (key != "label") {
						tmp_key = key;
						if (data[i][key] != 1 && is_check_all)
							is_check_all = false;
						break
					}
				powerCheckPanel.items.items[0].add(new Ext.form.Checkbox({
					xtype : "checkbox",
					boxLabel : data[i].label,
					tvalue : tmp_key,
					checked : data[i][tmp_key] == 1 ? true : false,
					handler : function(f, c) {
						if (isSingleCheckedEnable) {
							isAllCheckedEnable = false;
							isSingleCheckedEnable = false;
							resetData(powerCheckPanel, data, f.tvalue, c)
						}
					}
				}))
			}
			if (is_check_all)
				power_all.setValue(true);
			isAllCheckedEnable = true;
			isSingleCheckedEnable = true
		}
		powerCheckPanel.doLayout()
	}
	function checkedAll(panel, data, isCheck) {
		for (var i = 0; i < data.length; i++)
			for (var key in data[i])
				if (key != "label") {
					data[i][key] = isCheck == true ? 1 : 0;
					break
				}
		redrawCheckPanel(data)
	}
	function resetData(panel, data, check_key, isCheck) {
		for (var i = 0; i < data.length; i++)
			for (var key in data[i])
				if (key == check_key) {
					data[i][key] = isCheck == true ? 1 : 0;
					break
				}
		redrawCheckPanel(data)
	}
	function addSelectGuestToSelectPanel(listTree, selectTree, guest_left_menus) {
		var root = listTree.getRootNode();
		var selectTreeRoot = selectTree.getRootNode();
		root.eachChild(function(child) {
			if (child.attributes.checked == true) {
				copyNode(child, selectTreeRoot, true);
				child.remove()
			}
		})
	}
	function copyNode(node, parent, join) {
		var parentNode = new Ext.tree.TreeNode({
			id : node.attributes.id,
			text : node.attributes.text,
			draggable : false,
			leaf : node.attributes.leaf,
			cls : node.attributes.cls,
			checked : node.checked,
			attributes : {
				checked : node.attributes.checked,
				seltype : node.attributes.seltype,
				id : node.attributes.id,
				text : node.attributes.text,
				leaf : node.attributes.leaf,
				cls : node.attributes.cls
			}
		});
		if (join)
			parent.appendChild(parentNode);
		node.eachChild(function(child) {
			copyNode(child, parentNode, true)
		})
	}
	function addGuestToSelectPanel(listTree, selectTree) {
		var root = listTree.getRootNode();
		var selectTreeRoot = selectTree.getRootNode();
		var records = new Array;
		var index = 0;
		root.eachChild(function(child) {
			if (child.attributes.checked == true) {
				records[index] = child;
				index++
			}
		});
		for (var i = 0; i < index; i++)
			selectTreeRoot.appendChild(records[i])
	}
	function removeGuestfromSelectPanel(listTree, selectTree) {
		var root = selectTree.getRootNode();
		var selectTreeRoot = listTree.getRootNode();
		var records = new Array;
		var index = 0;
		root.eachChild(function(child) {
			if (child.attributes.checked == false) {
				records[index] = child;
				index++
			}
		});
		for (var i = 0; i < index; i++)
			selectTreeRoot.appendChild(records[i])
	}
	function addAllGuestToSelectPanel(listTree, selectTree) {
		var root = listTree.getRootNode();
		var selectTreeRoot = selectTree.getRootNode();
		var records = new Array;
		var index = 0;
		root.eachChild(function(child) {
			records[index] = child;
			index++
		});
		for (var i = 0; i < index; i++)
			selectTreeRoot.appendChild(records[i])
	}
	function removeAllGuestfromSelectPanel(listTree, selectTree) {
		var root = selectTree.getRootNode();
		var selectTreeRoot = listTree.getRootNode();
		var records = new Array;
		var index = 0;
		root.eachChild(function(child) {
			records[index] = child;
			index++
		});
		for (var i = 0; i < index; i++)
			selectTreeRoot.appendChild(records[i])
	}
	function copyValue(records, selGuestDatas) {
		selGuestDatas.seltype = records.attributes.seltype;
		selGuestDatas.checked = records.attributes.checked;
		var children = selGuestDatas.children;
		var index = 0;
		records.eachChild(function(child) {
			var selGuestData = children[index];
			selGuestData.seltype = child.attributes.seltype;
			selGuestData.checked = child.attributes.checked;
			copyValue(child, selGuestData);
			index++
		})
	}
	function getSelectGuetPanelInfo(selectTree) {
		var selGuestData = new Array;
		var root = selectTree.getRootNode();
		root.eachChild(function(child) {
			if (child.attributes.checked == true && ( child.attributes.seltype == 1 || child.attributes.seltype == 0 ))
				traversalNode(child, selGuestData)
		});
		return selGuestData
	}
	function traversalNode(node, selGuestData) {
		if (node.attributes.checked == true && ( node.attributes.seltype == 1 || node.attributes.seltype == 0 )) {
			if (node.attributes.seltype == 1) {
				var guest = {
					id : node.attributes.id
				};
				selGuestData.push(guest)
			}
			node.eachChild(function(child) {
				if (child.attributes.checked == true && ( child.attributes.seltype == 1 || child.attributes.seltype == 0 ))
					traversalNode(child, selGuestData)
			})
		}
	}
	function initGuestselRightNode(root) {
		root.eachChild(function(child) {
			if (child.attributes.seltype == 0) {
				child.attributes.checked = true;
				child.getUI().checkbox.indeterminate = true
			}
			child.expand(true);
			initGuestselRightNode(child)
		})
	}
	function power_manage_remove_all_node() {
		right_tree_id = "";
		userPowerMenus = {};
		var root = right_tree.getRootNode();
		root.removeAll(true);
		var powerCheckPanel = power_check_panel;
		powerCheckPanel.items.items[0].removeAll()
	}
	function power_manage_add_all_module() {
		var powerMenuLineArr = [];
		function powerMenuToLineArray(node) {
			if (typeof node.children != "undefined") {
				powerMenuLineArr.push(node);
				for (var i = 0; i < node.children.length; i++)
					if (typeof node.children[i]["id"] != "undefined")
						powerMenuToLineArray(node.children[i])
			}
		}
		var tmpMenus = cloneObj(userPowerMenus);
		powerMenuToLineArray(tmpMenus);
		userPowerMenus.children = cloneObj(powerMenus.children);
		pushOldPowerMenuToUserPowerMenus(userPowerMenus, powerMenuLineArr);
		powerMenuDraw(right_tree, right_tree.getRootNode(), userPowerMenus)
	}
	function power_manage_remove_right_select_node() {
		if (right_tree_id != "") {
			remove_right_select(userPowerMenus, right_tree_id);
			powerMenuDraw(right_tree, right_tree.getRootNode(), userPowerMenus);
			var powerCheckPanel = power_check_panel;
			powerCheckPanel.items.items[0].removeAll()
		} else
			Ext.MessageBox.show({
				title : "提示信息",
				msg : "请选择左边的权限模块",
				width : 200,
				icon : Ext.MessageBox.INFO,
				closable : false,
				buttons : {
					"ok" : "确定"
				}
			})
	}
	function pushOldPowerMenuToUserPowerMenus(myUserPowerMenus, existLinePowerMenu) {
		for (var j = 0; j < existLinePowerMenu.length; j++)
			setPowerData(myUserPowerMenus, existLinePowerMenu[j].id, existLinePowerMenu[j].powers)
	}
	function power_manage_add_selected_module() {
		if (left_tree_id != "") {
			var root = right_tree.getRootNode();
			root.removeAll(true);
			getChainNodesMain(cloneObj(powerMenus), left_tree_id);
			powerMenuDraw(right_tree, root, userPowerMenus)
		} else
			Ext.MessageBox.show({
				title : "提示信息",
				msg : "请选择左边的权限模块",
				width : 200,
				icon : Ext.MessageBox.INFO,
				closable : false,
				buttons : {
					"ok" : "确定"
				}
			})
	}
	function setPowerData(menus, id, powers) {
		for (var i = 0; i < menus.children.length; i++)
			if (typeof menus.children[i]["id"] != "undefined")
				if (menus.children[i]["id"] == id) {
					menus.children[i].powers = powers;
					return 1
				} else {
					var res = setPowerData(menus.children[i], id, powers);
					if (res != null)
						return
				}
		return null
	}
	function pushOldPowerMenuToUserPowerMenus(myUserPowerMenus, existLinePowerMenu) {
		for (var j = 0; j < existLinePowerMenu.length; j++)
			setPowerData(myUserPowerMenus, existLinePowerMenu[j].id, existLinePowerMenu[j].powers)
	}
	function power_manage_remove_all_node() {
		right_tree_id = "";
		userPowerMenus = {};
		var root = right_tree.getRootNode();
		root.removeAll(true);
		var powerCheckPanel = power_check_panel;
		powerCheckPanel.items.items[0].removeAll()
	}
	function power_manage_add_all_module() {
		var powerMenuLineArr = [];
		function powerMenuToLineArray(node) {
			if (typeof node.children != "undefined") {
				powerMenuLineArr.push(node);
				for (var i = 0; i < node.children.length; i++)
					if (typeof node.children[i]["id"] != "undefined")
						powerMenuToLineArray(node.children[i])
			}
		}
		var tmpMenus = cloneObj(userPowerMenus);
		powerMenuToLineArray(tmpMenus);
		userPowerMenus.children = cloneObj(powerMenus.children);
		pushOldPowerMenuToUserPowerMenus(userPowerMenus, powerMenuLineArr);
		powerMenuDraw(right_tree, right_tree.getRootNode(), userPowerMenus)
	}
	function powerMenuDraw(right_tree, node, menus) {
		node.removeAll(true);
		for (var i = 0; i < menus.children.length; i++)
			if (typeof menus.children[i]["id"] != "undefined") {
				var new_node = new Ext.tree.TreeNode({
					id : menus.children[i]["id"],
					text : menus.children[i]["text"],
					draggable : false,
					leaf : menus.children[i]["leaf"],
					cls : menus.children[i]["cls"]
				});
				node.appendChild(new_node);
				if (menus.children[i]["id"] == left_tree_id)
					expandNode(right_tree, node);
				powerMenuDraw(right_tree, new_node, menus.children[i])
			}
	}
	function expandNode(right_tree, node) {
		if (node != null) {
			var nodes = [node];
			var root = right_tree.getRootNode();
			var tmpnode = node.parentNode;
			while (tmpnode != null) {
				nodes.push(tmpnode);
				tmpnode = tmpnode.parentNode;
				if (tmpnode == root)
					break
			}
			nodes.reverse();
			for (var i = 0; i < nodes.length; i++)
				nodes[i].expand()
		}
	}
	function getChainNodesMain(myPowerMenus, id) {
		lineArr = [];
		getAllParentNodes(myPowerMenus, id, 0);
		lineArr.reverse();
		getAllChildrenNodes(myPowerMenus, id);
		var s = lineArr;
		var powerMenuLineArr = pushUserPowerMenus(lineArr);
		userPowerMenus = {};
		genNewUserPowerTree(powerMenuLineArr)
	}
	function remove_right_select(menus, id) {
		for (var i = 0; i < menus.children.length; i++)
			if (typeof menus.children[i]["id"] != "undefined")
				if (menus.children[i]["id"] == id) {
					menus.children.del(i);
					return 1
				} else {
					var res = remove_right_select(menus.children[i], id);
					if (res != null)
						return
				}
	}
	function getAllParentNodes(myPowerMenus, id, arr_len) {
		getParentObjById(null, myPowerMenus, id);
		if (lineArr.length > arr_len && lineArr.length > 0 && typeof lineArr[lineArr.length - 1].id != "undefined")
			getAllParentNodes(myPowerMenus, lineArr[lineArr.length - 1].id, lineArr.length)
	}
	var lineArr = [];
	function getParentObjById(parentObj, nodeObj, id) {
		if (parentObj != null && typeof parentObj.id != "undefined" && nodeObj.id == id)
			lineArr.push(parentObj);
		else
			for (var i = 0; i < nodeObj.children.length; i++)
				if (typeof nodeObj.children[i]["id"] != "undefined")
					getParentObjById(nodeObj, nodeObj.children[i], id)
	}
	function getAllChildrenNodes(myPowerMenus, id) {
		var node = findNodeByid(myPowerMenus, id);
		if (node != null)
			toLineArray(node)
	}
	function findNodeByid(myPowerMenus, id) {
		for (var i = 0; i < myPowerMenus.children.length; i++)
			if (typeof myPowerMenus.children[i]["id"] != "undefined" && myPowerMenus.children[i]["id"] == id)
				return myPowerMenus.children[i];
			else {
				var obj = getAllChildrenNodes(myPowerMenus.children[i], id);
				if (obj != null)
					return obj
			}
		return null
	}
	function toLineArray(node) {
		lineArr.push(node);
		for (var i = 0; i < node.children.length; i++)
			if (typeof node.children[i]["id"] != "undefined")
				toLineArray(node.children[i])
	}
	function pushUserPowerMenus(newPowerArr) {
		var powerMenuLineArr = [];
		function powerMenuToLineArray(node) {
			if (typeof node.children != "undefined") {
				powerMenuLineArr.push(node);
				for (var i = 0; i < node.children.length; i++)
					if (typeof node.children[i]["id"] != "undefined")
						powerMenuToLineArray(node.children[i])
			}
		}
		var tmp_arr = [];
		for (var i = 0; i < newPowerArr.length; i++)
			if (!powerMenuCompare(newPowerArr[i].id, userPowerMenus))
				tmp_arr.push(newPowerArr[i]);
		powerMenuToLineArray(userPowerMenus);
		powerMenuLineArr = powerMenuLineArr.concat(tmp_arr);
		return powerMenuLineArr
	}
	function powerMenuCompare(newPowerArrayId, powerArr) {
		var compareIsAdd = false;
		if (typeof powerArr.children != "undefined")
			for (var i = 0; i < powerArr.children.length; i++)
				if (typeof powerArr.children[i]["id"] != "undefined")
					if (newPowerArrayId == powerArr.children[i]["id"])
						return true;
					else if (powerMenuCompare(newPowerArrayId, powerArr.children[i]))
						return true;
		return false
	}
	function genNewUserPowerTree(powerMenuLineArr) {
		userPowerMenus.children = cloneObj(powerMenus.children);
		while (true) {
			var r = filterUserPowerMenus(userPowerMenus, powerMenuLineArr);
			if (!r)
				break
		}
	}
	function filterUserPowerMenus(myUserPowerMenus, existLinePowerMenu) {
		for (var i = 0; i < myUserPowerMenus.children.length; i++)
			if (typeof myUserPowerMenus.children[i]["id"] != "undefined") {
				var b = true;
				for (var j = 0; j < existLinePowerMenu.length; j++)
					if (myUserPowerMenus.children[i]["id"] == existLinePowerMenu[j].id) {
						b = false;
						var t = Ext.decode(existLinePowerMenu[j].powers);
						var oldPowers = Ext.decode(myUserPowerMenus.children[i].powers);
						var newPowers = Ext.decode(existLinePowerMenu[j].powers);
						for (var ii = 0; ii < oldPowers.length; ii++)
							for (var key in oldPowers[ii])
								if (key != "label")
									for (var jj = 0; jj < newPowers.length; jj++)
										for (var key2 in newPowers[jj])
											if (key == key2) {
												oldPowers[ii][key] = newPowers[jj][key2];
												if (newPowers[jj][key2] == 0)
													var sds = existLinePowerMenu[j]
											}
						myUserPowerMenus.children[i].powers = Ext.encode(oldPowers)
					}
				if (b) {
					myUserPowerMenus.children.del(i);
					return true
				} else if (filterUserPowerMenus(myUserPowerMenus.children[i], existLinePowerMenu))
					return true
			}
		return false
	}
	function genNewUserPowerTree(powerMenuLineArr) {
		userPowerMenus.children = cloneObj(powerMenus.children);
		while (true)
			if (!filterUserPowerMenus(userPowerMenus, powerMenuLineArr))
				break
	}
	function userPowerMenuDraw() {
		powerMenuDraw(right_tree, right_tree.getRootNode(), userPowerMenus)
	}
	this.load = function(params) {
		Ext.Ajax.request({
			url : params.url,
			params : params.params,
			success : function(response, options) {
				update_power = true;
				isPowerTabClick = 1;
				var json = Ext.decode(response.responseText);
				if (json.children.length > 0) {
					oldUserPowerMenus = cloneObj(json.children);
					setOldUserPowerMenus_(oldUserPowerMenus);
					genNewUserPowerTree(json.children);
					userPowerMenuDraw()
				}
			}
		})
	}
};
Ext.form.ERPComboBox = Ext.extend(Ext.form.ComboBox, {
	valueField : "id",
	displayField : "name",
	mode : "remote",
	triggerAction : "all",
	blankText : "不能为空！",
	emptyText : "请输入查询值",
	allowBlank : false,
	triggerAction : "all",
	queryParam : "name",
	editable : true,
	readOnly : false,
	forceSelection : true,
	minChars : 1,
	initComponent : function() {
		var comboBox = this;
		Ext.form.ERPComboBox.superclass.initComponent.call(this);
		this.store.on("beforeload", function(store, options) {
			var o = store.baseParams;
			Ext.apply(o, options.params);
			this.baseParams = o
		})
	},
	load : function(params) {
		this.store.loads(params)
	},
	clear : function() {
		this.clearValue()
	},
	listeners : {
		keyup : function(textField, e) {
		}
	},
	listeners : {
		load : function(textField, e) {
			this.setValue(null)
		}
	},
	listeners : {
		expand : function(textField, e) {
			this.store.on("beforeload", function(store, options) {
				var o = store.baseParams;
				Ext.apply(o, options.params);
				this.baseParams = o
			})
		}
	}
});
Ext.reg("ERPcombo", Ext.form.ERPComboBox);
Ext.data.ERPComboStore = Ext.extend(Ext.data.Store, {
	autoLoad : false,
	remoteSort : true,
	listeners : {
		"beforeload" : function(store, options) {
			var o = store.baseParams;
			Ext.apply(o, options.params);
			this.baseParams = o
		}
	},
	reloads : function(properties) {
		this.reload({
			params : properties.params,
			callback : function(r, options, success) {
				if (success) {
					if (typeof properties.success == "function")
						properties.success(r, options)
				} else
					Ext.MessageBox.alert("提示", "加载相关数据失败(no success)！")
			},
			failure : function(form, action) {
				Ext.MessageBox.alert("提示", "加载相关数据失败(failure)！")
			}
		})
	},
	loads : function(properties) {
		this.load({
			params : properties.params,
			callback : function(r, options, success) {
				if (success) {
					if (typeof properties.success == "function")
						properties.success(r, options, true)
				} else
					Ext.MessageBox.alert("提示", "加载相关数据失败(no success)！")
			},
			failure : function(form, action) {
				Ext.MessageBox.alert("提示", "加载相关数据失败(failure)！")
			}
		})
	}
});
function createERPcombo(params) {
	var xx = {
		id : params.id,
		hiddenName : params.name,
		fieldLabel : params.fieldLabel,
		valueField : "id",
		displayField : "name",
		width : typeof params.width == "undefined" ? 200 : params.width,
		forceSelection : typeof params.forceSelection == "undefined" ? true : params.forceSelection,
		allowBlank : typeof params.allowBlank == "undefined" ? false : params.allowBlank,
		style : typeof params.allowBlank == "undefined" ? NoAllowBlankStyle : params.allowBlank == true ? AllowBlankStyle : NoAllowBlankStyle,
		store : new Ext.data.ERPComboStore({
			autoLoad : typeof params.autoLoad == "undefined" ? false : params.autoLoad,
			baseParams : params.params,
			proxy : new Ext.data.HttpProxy({
				url : params.url
			}),
			reader : new Ext.data.JsonReader({
				id : "id",
				root : "results"
			}, Ext.data.Record.create([{
				name : "id"
			}, {
				name : "name"
			}])),
			listeners : {
				"load" : function() {
					if (typeof params.load != "undefined")
						params.load()
				}
			}
		}),
		listeners : {
			"select" : function(combo, record, index) {
				if (typeof params.select != "undefined")
					params.select(combo, record, index)
			}
		}
	};
	sss = new Ext.form.ERPComboBox(xx);
	return sss
};
function showErrorMsg(title, message) {
	var msg = Ext.MessageBox.show({
		title : title,
		buttons : Ext.MessageBox.OK,
		msg : message,
		width : 350,
		modal : true,
		icon : Ext.Msg.ERROR
	})
}
function showMsg(title, messages) {
	Ext.MessageBox.show({
		title : title,
		buttons : Ext.MessageBox.OK,
		msg : message,
		width : 500,
		modal : true,
		icon : Ext.Msg.INFO
	})
}
function showMsgYN(params) {
	Ext.MessageBox.confirm("消息", params.msg, function(btn) {
		if (btn == "yes")
			params.yes();
		else if (typeof params.no == "function")
			params.no()
	})
}
Ext.form.ERPShowTextField = Ext.extend(Ext.form.TextField, {
	disabled : true,
	disabledClass : "my-disabled",
	xtype : "textfield",
	blankText : "不能为空!",
	allowBlank : false,
	style : AllowBlankStyle
});
Ext.reg("ERPShowText", Ext.form.ERPShowTextField);
Ext.form.ERPShowEditText = Ext.extend(Ext.form.TextField, {
	disabled : true,
	disabledClass : "my-disabled",
	xtype : "textfield",
	blankText : "不能为空!",
	allowBlank : false,
	style : AllowBlankStyle,
	editable : true,
	readOnly : false
});
Ext.reg("ERPShowEditText", Ext.form.ERPShowTextField);
function ERPAjaxRequest(reqParams) {
	var myMask = new Ext.LoadMask(Ext.getBody(), {
		msg : "正在处理数据..."
	});
	Ext.Ajax.request({
		timeout : timeout,
		url : reqParams.url,
		params : reqParams.params,
		async : typeof reqParams.async == "undefined" ? false : reqParams.async,
		success : function(response, options) {
			var json = Ext.util.JSON.decode(response.responseText);
			if (typeof json.success == "undefined") {
				if (typeof reqParams.success == "function")
					reqParams.success(response, options)
			} else {
				var success_ = json.success;
				if (success_ == false)
					if (typeof json.msg == "undefined") {
						if (typeof reqParams.errors == "function")
							reqParams.errors({
								"response" : response,
								"options" : options,
								"result" : null,
								"msg" : null
							})
					} else if (json.msg == 1001 || json.msg == "1001")
						Ext.MessageBox.alert("标题", "用户没有登录/用户超时，请重新登录系统！ ", function() {
							window.location.href = "./"
						});
					else if (json.msg == 1E4 || json.msg == "10000")
						showErrorMsg("错误提示", "请求操作失败【系统错误】");
					else if (json.msg == null)
						showErrorMsg("错误提示", "请求操作失败【未知错误】");
					else if (typeof reqParams.errors == "function")
						reqParams.errors({
							"response" : response,
							"options" : options,
							"msg" : json.msg,
							"result" : null
						});
					else
						showErrorMsg("错误提示", "请求操作失败【" + json.msg + "】");
				else if (typeof reqParams.success == "function")
					reqParams.success({
						"response" : response,
						"options" : options,
						"result" : response.responseJSON
					})
			}
		},
		failure : function(resp, opts) {
			if (typeof reqParams.error != "undefined") {
				reqParams.error(resp, opts);
				reqParams.errors({
					"response" : resp,
					"options" : opts,
					"result" : null,
					"msg" : null
				})
			} else
				showErrorMsg("失败", "请求数据失败！")
		}
	})
}
function createLocalCombo(params) {
	var xx = {
		id : params.id,
		name : params.name,
		hiddenName : params.name,
		fieldLabel : params.fieldLabel,
		xtype : "combo",
		mode : "local",
		valueField : "id",
		displayField : "value",
		triggerAction : "all",
		editable : false,
		defaultValue : typeof params.defaultValue == "undefined" ? null : params.defaultValue,
		reset : function() {
			if (this.clearFilterOnReset && this.mode == "local")
				this.store.clearFilter();
			Ext.form.ComboBox.superclass.reset.call(this);
			this.setValue(this.defaultValue)
		},
		allowBlank : typeof params.allowBlank == "undefined" ? false : params.allowBlank,
		style : typeof params.allowBlank == "undefined" ? NoAllowBlankStyle : params.allowBlank == true ? AllowBlankStyle : NoAllowBlankStyle,
		value : typeof params.defaultValue == "undefined" ? null : params.defaultValue,
		store : new Ext.data.SimpleStore({
			fields : ["id", "value"],
			data : params.storeData,
			listeners : params.listeners
		})
	};
	return xx
}
function mainGridWindow(properties) {
	var isBbar = typeof properties.isBbar == "undefined" ? true : properties.isBbar;
	var moduleId = properties.moduleId;
	var store = new Ext.data.ERPStore({
		proxy : new Ext.data.HttpProxy({
			url : properties.url
		}),
		reader : new Ext.data.JsonReader({
			totalProperty : "selectPage.count",
			root : "selectPage.result"
		}, new Ext.data.Record.create(properties.record))
	});
	var grid = new Ext.grid.ERPGridPanel({
		id : moduleId + "_GRID",
		width : "100%",
		height : typeof properties.height != "undefined" ? properties.height : "100%",
		region : "center",
		cm : new Ext.grid.ColumnModel(properties.column),
		store : store,
		moduleId : moduleId,
		bbar : isBbar == true ? new Ext.PagingToolbar({
			store : store,
			pageSize : erp_grid_panel_limit,
			displayInfo : true,
			displayMsg : "本页显示第{0}条到第{1}条的记录，一共{2}条。",
			emptyMsg : "没有记录",
			doRefresh : function() {
				this.store.reload({
					callback : function(r, options, success) {
						if (!success)
							Ext.MessageBox.alert("提示", "加载相关数据失败【系统错误】！");
						else
							;
					},
					failure : function(form, action) {
						Ext.MessageBox.alert("提示", "加载相关数据失败(failure)！")
					}
				})
			}
		}) : null,
		rowdblclickKey : this.moduleId + "_edit",
		tbar : properties.tbar
	});
	grid.initPanel(properties.init);
	this.getGrid = getGrid_;
	function getGrid_() {
		return grid
	}
	this.load = function(params) {
		grid.load(params)
	}
}
var Map = function() {
	this._entrys = new Array;
	this.put = function(key, value) {
		if (key == null || key == undefined)
			return;
		var index = this._getIndex(key);
		if (index == -1) {
			var entry = new Object;
			entry.key = key;
			entry.value = value;
			this._entrys[this._entrys.length] = entry
		} else
			this._entrys[index].value = value
	};
	this.get = function(key) {
		var index = this._getIndex(key);
		return index != -1 ? this._entrys[index].value : null
	};
	this.remove = function(key) {
		var index = this._getIndex(key);
		if (index != -1)
			this._entrys.splice(index, 1)
	};
	this.clear = function() {
		this._entrys.length = 0
	};
	this.contains = function(key) {
		var index = this._getIndex(key);
		return index != -1 ? true : false
	};
	this.getCount = function() {
		return this._entrys.length
	};
	this.getEntrys = function() {
		return this._entrys
	};
	this._getIndex = function(key) {
		if (key == null || key == undefined)
			return -1;
		var _length = this._entrys.length;
		for (var i = 0; i < _length; i++) {
			var entry = this._entrys[i];
			if (entry == null || entry == undefined)
				continue;
			if (entry.key === key)
				return i
		}
		return -1
	}
};