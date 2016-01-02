
/**
 * 
 * 手工对帐
 * 
 * @param {}
 *            moduleId
 * @param {}
 *            moduleName
 * @param {}
 *            params
 */

function stock_invoice_reconcile_handle_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();

	var selection_rows = grid.getSelectionModel().getSelections();

	if (selection_rows == null) {
		showErrorMsg('提示信息', '请选择要删除的数据记录！！');
		return false;
	}

	if (selection_rows.length != 1) {
		showErrorMsg('提示信息', '只能选择一行数据记录！！');
		return false;
	}

	var stock_invoice = selection_rows[0].data;

	var selectId = selection_rows[0].id;

	stock_invoice.id = selectId;

	var stock_invoice_reconcile_handle_column = {
		record : [{
			name : 'billType',
			mapping : 'billType'
		}, {
			name : "billNum",
			mapping : "billNum"
		}, {
			name : "billSumMoneyShow",
			mapping : "billSumMoneyShow"
		}, {
			name : "noKillSumMoneyShow",
			mapping : "noKillSumMoneyShow"
		}, {
			name : "stockInvoiceDetail.killSumMoneyShow",
			mapping : "stockInvoiceDetail"
		}],

		// ///////////////////////////////////////////////////////////////////////////////////////////
		column : [new Ext.grid.ERPRowNumberer(), {
			header : '单据类型',
			width : 200,
			dataIndex : 'billType',
			sortable : true,
			renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

				if (value == null || typeof ( value ) == 'undefined')
					return null
				else
					return value;

			}
		}, {
			header : '单据号',
			width : 200,
			dataIndex : 'billNum',
			sortable : true,
			renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

				if (value == null || typeof ( value ) == 'undefined')
					return null
				else
					return value;

			}
		}, {
			header : '单据金额',
			width : 200,
			dataIndex : 'billSumMoneyShow',
			sortable : true,
			renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

				if (value == null || typeof ( value ) == 'undefined')
					return null
				else
					return value;

			}
		}, {
			header : '剩余金额',
			width : 200,
			dataIndex : 'noKillSumMoneyShow',
			sortable : true,
			renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

				if (value == null || typeof ( value ) == 'undefined')
					return null
				else
					return value;

			}
		}, {
			header : '对帐金额',
			width : 200,
			dataIndex : 'stockInvoiceDetail.killSumMoneyShow',
			sortable : true,
			renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {

				if (value == null || typeof ( value ) == 'undefined')
					return null
				else
					return value.killSumMoneyShow;

			}
		}]
	};
	// //////////////////////////////////////////////////////////////////////////////////

	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	var mainGridModule = new mainGridWindow({
		moduleId : moduleId,
		height : 300,
		// list grid
		url : './list_StockInvoiceBillDetail_listAllBill.do',
		// grid_column.record
		record : stock_invoice_reconcile_handle_column.record,
		// grid_column.column
		column : stock_invoice_reconcile_handle_column.column,
		tbar : {
			// plugins : new Ext.ux.ToolbarKeyMap(),
			items : [{
				// id : moduleId + '_add',
				key : "autoAllReconciliation",
				xtype : "tbbutton",
				text : "自动全部对帐",
				// keyBinding : createCreateKey(),
				handler : function(bt) {
					stock_invoice_reconcile_auto_all_windows(moduleId, "全部对帐");
				}
			}, {
				// id : moduleId + '_add',
				key : "cancelAllReconciliation",
				xtype : "tbbutton",
				text : "取消全部对帐",
				// keyBinding : createCreateKey(),
				handler : function(bt) {
					stock_invoice_reconcile_cancel_all_windows(moduleId, "全部取消对帐");
				}
			},

			{
				// id : moduleId + '_add',
				key : "autoReconciliation",
				xtype : "tbbutton",
				text : "自动对帐",
				// keyBinding : createCreateKey(),
				handler : function(bt) {
					stock_invoice_reconcile_handle_auto_windows(moduleId, "自动对帐", {
						grid : mainGridModule

					});
				}
			}, {
				// id : moduleId + '_add',
				key : "manualReconciliation",
				xtype : "tbbutton",
				text : "手工对帐",
				// keyBinding : createCreateKey(),
				handler : function(bt) {
					var reconciliationSumMoneyShow = mainGridModule.stockInvoice.reconciliationSumMoneyShow;
					if (reconciliationSumMoneyShow == 0) {
						showErrorMsg("错误", "改发票对账余额为零,已对帐完成");
						return;
					}
					stock_invoice_reconcile_bill_handle_windows(moduleId, "手工对帐", {
						grid : mainGridModule,
						setStockInvoiceFormValue : setStockInvoiceFormValue

					});
				}
			}, {
				// id : moduleId + '_search',
				xtype : "tbbutton",
				text : "取消对帐",
				key : "search",
				// keyBinding : createSearchKey(),
				handler : function() {
					var searchWindex = stock_invoice_reconcile_handle_cancel_windows(moduleId, moduleName, {
						grid : mainGridModule
					});
				}
			}]

		},
		init : {
			// 行被选择
			select : function(rowDataId, data, sm, rowIdx, r) {
				// stockSelect(data, null, null);

				// detailGrid.load({
				// params : {
				// 'searchBean.stockInvoiceId' : rowDataId
				// }
				// });

			},
			// 返回这一行的状态 1:OK -1 NO OK checkName:
			status : function(data) {

			}
		}
	});

	var mainGrid = mainGridModule.getGrid();
	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	var reconciliationSumMoneyShow = new Ext.form.ERPShowTextField({
		id : 'stockinvoice.reconciliationSumMoneyShow',
		name : 'stockinvoice.reconciliationSumMoneyShow',
		fieldLabel : ' 对账余额',
		xtype : 'ERPShowText',
		// style : NoAllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var noKillSumMoneyShow = new Ext.form.ERPShowTextField({
		id : 'stockinvoice.noKillSumMoneyShow',
		name : 'stockinvoice.noKillSumMoneyShow',
		fieldLabel : ' 未抵消金额',
		xtype : 'ERPShowText',
		// style : NoAllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var killSumMoneyShow = new Ext.form.ERPShowTextField({
		id : 'stockinvoice.killSumMoneyShow',
		name : 'stockinvoice.killSumMoneyShow',
		fieldLabel : ' 抵消金额',
		xtype : 'ERPShowText',
		// style : NoAllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var invoiceSumMoneyShow = new Ext.form.ERPShowTextField({
		id : 'stockinvoice.invoiceSumMoneyShow',
		name : 'stockinvoice.invoiceSumMoneyShow',
		fieldLabel : ' 发票金额',
		xtype : 'ERPShowText',
		// style : NoAllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var providerInfoId = new Ext.form.ERPShowTextField({
		id : 'providerInfo.name',
		name : 'providerInfo.name',
		fieldLabel : ' 供应商',
		xtype : 'ERPShowText',
		// style : NoAllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var num = new Ext.form.ERPShowTextField({
		id : 'stockinvoice.num',
		name : 'stockinvoice.num',
		fieldLabel : ' 发票编号',
		xtype : 'ERPShowText',
		// style : NoAllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var invoiceNum = new Ext.form.ERPShowTextField({

		id : 'stockinvoice.invoiceNum',
		name : 'stockinvoice.invoiceNum',
		fieldLabel : ' 发票号',
		xtype : 'ERPShowText',
		// style : NoAllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}

	});

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	var stock_invoice_reconcile_handle_params = {
		title : moduleName,
		action : "save",
		grid : grid,
		// 结果路径
		pojo : "sss",
		// url
		// url : './list_StockInvoiceBillDetail_list.do',
		params : {
			optType : "save"
		},
		reader : new Ext.data.JsonReader({
			successProperty : 'success',
			root : 'result',
			totalProperty : 'totalProperty'
		}, [{
			name : 'providerInfo.name',
			mapping : 'providerInfo.name'
		}, {
			name : 'stockinvoice.num',
			mapping : 'num'
		}, {
			name : 'stockinvoice.invoiceNum',
			mapping : 'invoiceNum'
		}, {
			name : 'stockinvoice.invoiceSumMoneyShow',
			mapping : 'invoiceSumMoneyShow'
		}, {
			name : 'stockinvoice.killSumMoneyShow',
			mapping : 'killSumMoneyShow'
		}, {
			name : 'stockinvoice.noKillSumMoneyShow',
			mapping : 'noKillSumMoneyShow'
		}, {

			name : 'stockinvoice.reconciliationSumMoneyShow',
			mapping : 'reconciliationSumMoneyShow'

		}]),
		// 字段
		field : [{// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 70,
			items : [{
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 448
				},
				items : [providerInfoId]
			}, // 1-1 end
			{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [num]
			}, {
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [invoiceNum]
			}

			]
		}, {// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 70,
			items : [{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [invoiceSumMoneyShow]
			}, // 1-1 end
			{
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [killSumMoneyShow]
			}, {
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [noKillSumMoneyShow]
			}, {
				columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [reconciliationSumMoneyShow]
			}

			]
		},

		mainGrid]

	}

	var stock_invoice_reconcile_handle_params_form = new Ext.form.ERPFormPanel({
		labelWidth : 55,
		frame : true,
		items : stock_invoice_reconcile_handle_params.field,
		reader : stock_invoice_reconcile_handle_params.reader,
		buttons : [{
			text : '提交',
			listeners : {
				'click' : function() {
					window.close();
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
		title : params.title,
		closable : true,
		width : 1100,
		// height : 400,
		// autoHeight : false,
		items : [stock_invoice_reconcile_handle_params_form]
	});

	window.showWin();

	stock_invoice_reconcile_handle_params_form.load({
		url : './simple_StockInvoice_get.do?uuid=' + selectId,
		success : function(result) {
			var stockInvoice_ = result.result.result;
			mainGridModule.stockInvoice = stockInvoice_;
			mainGrid.load({
				params : {
					"searchBean.providerInfoId" : stock_invoice.providerInfoId,
					"searchBean.stockInvoiceId" : stock_invoice.id
				}
			});
		}
	});

	function setStockInvoiceFormValue(stockInvoice) {
		mainGridModule.stockInvoice = stockInvoice;
		killSumMoneyShow.setValue(stockInvoice.killSumMoneyShow);
		noKillSumMoneyShow.setValue(stockInvoice.noKillSumMoneyShow);
		reconciliationSumMoneyShow.setValue(stockInvoice.reconciliationSumMoneyShow);
		grid.updateRow(stockInvoice);
	}

	// ////////////////////////////////////////////////////////////////////////////////////////////////

	function stock_invoice_reconcile_handle_cancel_windows(moduleId, moduleName, params) {
		var grid = params.grid.getGrid();

		var selection_rows = grid.getSelectionModel().getSelections();

		if (selection_rows == null) {
			showErrorMsg('提示信息', '请选择要取消对帐的单据');
			return false;
		}

		if (selection_rows.length != 1) {
			showErrorMsg('提示信息', '只能选择一行要取消对帐的单据');
			return false;
		}
		var billDetailId = selection_rows[0].id;

		var stockInvoiceDetail = selection_rows[0].data["stockInvoiceDetail.killSumMoneyShow"];

		if (stockInvoiceDetail == null) {
			showErrorMsg("错误", "操作失败[该单据的对帐金额为空]");
			return;
		}

		showMsgYN({
			msg : "是否要取消对帐",
			yes : function(YN) {
				ERPAjaxRequest({
					url : "./simple_StockInvoiceBillDetail_cancelReconcile.do",
					params : {
						"stockinvoicebilldetail.stockInvoiceId" : selectId,
						"stockinvoicebilldetail.stockInvoiceDetailId" : stockInvoiceDetail.id,
						"stockinvoicebilldetail.id" : billDetailId
					},
					// async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
					success : function(result) {
						var stockinvoicebilldetail = result.result.result;
						grid.updateRow(stockinvoicebilldetail);
						var stockInvoice = stockinvoicebilldetail.stockInvoice;
						setStockInvoiceFormValue(stockInvoice);
					}
				});
			}
		});
	}

	function stock_invoice_reconcile_cancel_all_windows(moduleId, moduleName) {

		showMsgYN({
			msg : "是否要取消全部对帐",
			yes : function(YN) {
				ERPAjaxRequest({
					url : "./simple_StockInvoiceBillReconcile_cancelReconcile.do",
					params : {
						"stockinvoice.id" : selectId
					},
					// async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
					success : function(result) {
						var stockInvoice = result.result.result;

						mainGrid.reload({
							success : function() {
								mainGridModule.stockInvoice = stockInvoice;
								setStockInvoiceFormValue(stockInvoice);
							}
						});
					}
				});
			}
		});

	}

	// /////////////////////////////////////////////////////////////////////////////////////////////////////

	function stock_invoice_reconcile_auto_all_windows(moduleId, moduleName) {
		var selectId = selection_rows[0].id;
		showMsgYN({
			msg : "是否要自动完全对帐",
			yes : function(YN) {
				ERPAjaxRequest({
					url : "./simple_StockInvoiceBillReconcile_autoReconcile.do",
					params : {
						"stockinvoice.id" : selectId
					},
					// async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
					success : function(result) {
						var stockInvoice = result.result.result;
						mainGrid.reload({
							success : function() {
								mainGridModule.stockInvoice = stockInvoice;
								setStockInvoiceFormValue(stockInvoice);
							}
						});
					}
				});
			}
		});

	}

	function stock_invoice_reconcile_handle_auto_windows(moduleId, moduleName, params) {

		var grid = params.grid.getGrid();

		var selection_rows = grid.getSelectionModel().getSelections();

		if (selection_rows == null) {
			showErrorMsg('提示信息', '请选择要自动对帐的单据');
			return false;
		}

		if (selection_rows.length != 1) {
			showErrorMsg('提示信息', '只能选择一行要自动对帐的单据');
			return false;
		}
		var billDetailId = selection_rows[0].id;

		showMsgYN({
			msg : "是否要自动对帐",
			yes : function(YN) {
				ERPAjaxRequest({
					url : "./simple_StockInvoiceBillDetail_autoReconcile.do",
					params : {
						"stockinvoicebilldetail.stockInvoiceId" : selectId,
						"stockinvoicebilldetail.id" : billDetailId
					},
					// async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
					success : function(result) {
						var stockinvoicebilldetail = result.result.result;
						grid.updateRow(stockinvoicebilldetail);
						var stockInvoice = stockinvoicebilldetail.stockInvoice;
						mainGridModule.stockInvoice = stockInvoice;
						setStockInvoiceFormValue(stockInvoice);
					}
				});
			}
		});
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}