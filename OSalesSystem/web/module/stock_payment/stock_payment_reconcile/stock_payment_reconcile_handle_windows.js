
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

function stock_payment_reconcile_handle_windows(moduleId, moduleName, params) {

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
	var selectId = selection_rows[0].id;

	var stock_payment_reconcile_handle_column = {
		record : [{
			name : 'billType',
			mapping : 'billType'
		}, {
			name : "billNum",
			mapping : "billNum"
		}, {
			name : "paymentSumMoneyShow",
			mapping : "paymentSumMoneyShow"
		}, {
			name : "noKillSumMoneyShow",
			mapping : "noKillSumMoneyShow"
		}, {
			name : "stockPaymentDetail.killSumMoneyShow",
			mapping : "stockPaymentDetail"
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
			dataIndex : 'paymentSumMoneyShow',
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
			dataIndex : 'stockPaymentDetail.killSumMoneyShow',
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

	function setFormValue(stockPayment) {
		mainGridModule.payment = stockPayment;
		killSumMoneyShow.setValue(stockPayment.killSumMoneyShow);
		noKillSumMoneyShow.setValue(stockPayment.noKillSumMoneyShow);
		reconciliationSumMoneyShow.setValue(stockPayment.reconciliationSumMoneyShow);
		grid.updateRow(stockPayment);
	}

	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	var mainGridModule = new mainGridWindow({
		moduleId : moduleId,
		height : 300,
		// list grid
		url : './list_StockPaymentReconcileBillDetail_searchAllReconcileBillDetail.do',
		// grid_column.record
		record : stock_payment_reconcile_handle_column.record,
		// grid_column.column
		column : stock_payment_reconcile_handle_column.column,
		tbar : {
			// plugins : new Ext.ux.ToolbarKeyMap(),
			items : [{
				// id : moduleId + '_add',
				key : "autoAllReconciliation",
				xtype : "tbbutton",
				text : "自动全部对帐",
				// keyBinding : createCreateKey(),
				handler : function(bt) {
					stock_payment_reconcile_auto_all_windows(moduleId, "全部对帐");
				}
			}, {
				// id : moduleId + '_add',
				key : "cancelAllReconciliation",
				xtype : "tbbutton",
				text : "取消全部对帐",
				// keyBinding : createCreateKey(),
				handler : function(bt) {
					stock_payment_reconcile_cancel_all_windows(moduleId, "全部取消对帐");
				}
			},

			{
				// id : moduleId + '_add',
				key : "autoReconciliation",
				xtype : "tbbutton",
				text : "自动对帐",
				// keyBinding : createCreateKey(),
				handler : function(bt) {
					stock_payment_reconcile_handle_auto_windows(moduleId, "自动对帐", {
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
					var reconciliationSumMoneyShow = mainGridModule.payment.reconciliationSumMoneyShow;
					if (reconciliationSumMoneyShow == 0) {
						showErrorMsg("错误", "改发票对账余额为零,已对帐完成");
						return;
					}
					stock_payment_reconcile_bill_handle_windows(moduleId, "手工对帐", {
						grid : mainGridModule,
						setFormValue : setFormValue

					});
				}
			}, {
				// id : moduleId + '_search',
				xtype : "tbbutton",
				text : "取消对帐",
				key : "search",
				// keyBinding : createSearchKey(),
				handler : function() {
					stock_payment_reconcile_handle_cancel_windows(moduleId, moduleName, {
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
		id : 'stockpayment.reconciliationSumMoneyShow',
		name : 'stockpayment.reconciliationSumMoneyShow',
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
		id : 'stockpayment.noKillSumMoneyShow',
		name : 'stockpayment.noKillSumMoneyShow',
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
		id : 'stockpayment.killSumMoneyShow',
		name : 'stockpayment.killSumMoneyShow',
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

	var paymentSumMoneyShow = new Ext.form.ERPShowTextField({
		id : 'stockpayment.paymentSumMoneyShow',
		name : 'stockpayment.paymentSumMoneyShow',
		fieldLabel : ' 付款金额',
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
		id : 'stockpayment.num',
		name : 'stockpayment.num',
		fieldLabel : '付款单号',
		xtype : 'ERPShowText',
		// style : NoAllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var otherSideReceiveNum = new Ext.form.ERPShowTextField({

		id : 'stockpayment.otherSideReceiveNum',
		name : 'stockpayment.otherSideReceiveNum',
		fieldLabel : ' 对方单号',
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

	var stock_payment_reconcile_handle_params = {
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
			name : 'stockpayment.num',
			mapping : 'num'
		}, {
			name : 'stockpayment.otherSideReceiveNum',
			mapping : 'otherSideReceiveNum'
		}, {
			name : 'stockpayment.paymentSumMoneyShow',
			mapping : 'paymentSumMoneyShow'
		}, {
			name : 'stockpayment.killSumMoneyShow',
			mapping : 'killSumMoneyShow'
		}, {
			name : 'stockpayment.noKillSumMoneyShow',
			mapping : 'noKillSumMoneyShow'
		}, {

			name : 'stockpayment.reconciliationSumMoneyShow',
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
				items : [otherSideReceiveNum]
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
				items : [paymentSumMoneyShow]
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

	var stock_payment_reconcile_handle_params_form = new Ext.form.ERPFormPanel({
		labelWidth : 55,
		frame : true,
		items : stock_payment_reconcile_handle_params.field,
		reader : stock_payment_reconcile_handle_params.reader,
		buttons : [{
			text : '提交',
			listeners : {
				'click' : function() {

					// ERPAjaxRequest({
					// url :
					// "./simple_StockInvoiceBillReconcile_checkAllReconcile.do",
					// params : {
					// "stockinvoice.id" : mainGridModule.payment.id
					// },
					// // async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
					// success : function(result) {
					// // checkAllReconcile
					// reStockInvoice(mainGridModule.payment);
					window.close();
					// }
					// });
				}
			}
		}, {
			text : '关闭',
			listeners : {
				'click' : function() {
					// ERPAjaxRequest({
					// url :
					// "./simple_StockInvoiceBillReconcile_checkAllReconcile.do",
					// params : {
					// "stockinvoice.id" : mainGridModule.payment.id
					// },
					// // async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
					// success : function(result) {
					window.close();
					// }
					// });

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
		items : [stock_payment_reconcile_handle_params_form]
	});

	window.showWin();

	stock_payment_reconcile_handle_params_form.load({
		url : './simple_StockPaymentReconcile_get.do?uuid=' + selectId,
		success : function(result) {
			var payment_ = result.result.result;
			mainGridModule.payment = payment_;
			mainGrid.load({
				params : {
					"searchBean.providerInfoId" : selection_rows[0].data.providerInfoId,
					"searchBean.stockPaymentId" : selection_rows[0].id
				}
			});
		}
	});

	function setStockInvoiceFormValue(stockInvoice) {
		mainGridModule.payment = stockInvoice;
		killSumMoneyShow.setValue(stockInvoice.killSumMoneyShow);
		noKillSumMoneyShow.setValue(stockInvoice.noKillSumMoneyShow);
		reconciliationSumMoneyShow.setValue(stockInvoice.reconciliationSumMoneyShow);
	}

	// ////////////////////////////////////////////////////////////////////////////////////////////////

	function stock_payment_reconcile_handle_cancel_windows(moduleId, moduleName, params) {
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

		var stockPaymentDetail = selection_rows[0].data["stockPaymentDetail.killSumMoneyShow"];

		if (stockPaymentDetail == null) {
			showErrorMsg("错误", "操作失败[该单据的对帐金额为空]");
			return;
		}

		showMsgYN({
			msg : "是否要取消对帐",
			yes : function(YN) {
				ERPAjaxRequest({
					url : "./simple_StockPaymentReconcileBillDetail_cancelReconcile.do",
					params : {
						"stockpaymentbilldetail.stockPaymentId" : selectId,
						"stockpaymentbilldetail.stockPaymentDetailId" : stockPaymentDetail.id,
						"stockpaymentbilldetail.id" : billDetailId
					},
					// async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
					success : function(result) {
						var stockpaymentbilldetail = result.result.result;
						grid.updateRow(stockpaymentbilldetail);
						var stockPayment = stockpaymentbilldetail.stockPayment;
						setFormValue(stockPayment);

					}
				});
			}
		});
	}

	function stock_payment_reconcile_cancel_all_windows(moduleId, moduleName) {

		showMsgYN({
			msg : "是否要取消全部对帐",
			yes : function(YN) {
				ERPAjaxRequest({
					url : "./simple_StockPaymentReconcile_cancelAllReconcile.do",
					params : {
						"stockpayment.id" : selectId
					},
					// async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
					success : function(result) {
						var stockPayment = result.result.result;

						mainGrid.reload({
							success : function() {
								setFormValue(stockPayment);
							}
						});
					}
				});
			}
		});

	}

	// /////////////////////////////////////////////////////////////////////////////////////////////////////

	function stock_payment_reconcile_auto_all_windows(moduleId, moduleName) {
		var selectId = selection_rows[0].id;
		showMsgYN({
			msg : "是否要自动完全对帐",
			yes : function(YN) {
				ERPAjaxRequest({
					url : "./simple_StockPaymentReconcile_autoAllReconcile.do",
					params : {
						"stockpayment.id" : selectId
					},
					// async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
					success : function(result) {
						var stockPayment = result.result.result;
						mainGrid.reload({
							success : function() {
								setFormValue(stockPayment);
							}
						});
					}
				});
			}
		});

	}

	function stock_payment_reconcile_handle_auto_windows(moduleId, moduleName, params) {

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
					url : "./simple_StockPaymentReconcileBillDetail_autoReconcile.do",
					params : {
						"stockpaymentbilldetail.stockPaymentId" : selectId,
						"stockpaymentbilldetail.id" : billDetailId
					},
					// async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
					success : function(result) {
						var stockpaymentbilldetail = result.result.result;
						grid.updateRow(stockpaymentbilldetail);
						var stockPayment = stockpaymentbilldetail.stockPayment;
						setFormValue(stockPayment);
					}
				});
			}
		});
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}