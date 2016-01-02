
/**
 * 手工单据对帐
 * 
 * @param {}
 *            moduleId
 * @param {}
 *            moduleName
 * @param {}
 *            params
 */

function stock_payment_reconcile_bill_handle_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();

	var payment = params.grid.payment;

	var setFormValue = params.setFormValue;

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

	var billdetail = selection_rows[0].data;

	billdetail.id = selectId;

	var billType = new Ext.form.ERPShowTextField({
		id : 'stockpaymentbilldetail.billType',
		name : 'stockpaymentbilldetail.billType',
		fieldLabel : ' 单据类型',
		xtype : 'ERPShowText',
		// style : NoAllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		value : billdetail.billType,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var billNum = new Ext.form.ERPShowTextField({
		id : 'stockpaymentbilldetail.billNum',
		name : 'stockpaymentbilldetail.billNum',
		fieldLabel : ' 单据编号',
		xtype : 'ERPShowText',
		// style : NoAllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		value : billdetail.billNum,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var billSumMoneyShow = new Ext.form.ERPShowTextField({
		id : 'stockpaymentbilldetail.paymentSumMoneyShow',
		name : 'stockpaymentbilldetail.paymentSumMoneyShow',
		fieldLabel : ' 单据金额',
		xtype : 'ERPShowText',
		// style : NoAllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		value : billdetail.paymentSumMoneyShow,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var reconciliationSumMoneyShow = new Ext.form.ERPShowTextField({
		id : 'reconciliationSumMoneyShow',
		name : 'reconciliationSumMoneyShow',
		fieldLabel : ' 对账余额',
		xtype : 'ERPShowText',
		// style : NoAllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		value : payment.reconciliationSumMoneyShow,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var noKillSumMoneyShow = new Ext.form.ERPShowTextField({
		id : 'stockpaymentbilldetail.noKillSumMoneyShow',
		name : 'stockpaymentbilldetail.noKillSumMoneyShow',
		fieldLabel : ' 剩余金额',
		xtype : 'ERPShowText',
		// style : NoAllowBlankStyle,
		blankText : '不能为空！',
		value : billdetail.noKillSumMoneyShow,
		allowBlank : false,
		listeners : {
			'specialkey' : function(field, e) {
			}
		}
	});

	var stockInvoiceDetailKillSumMoneyShow = new Ext.form.TextField({
		id : 'stockpaymentbilldetail.stockPaymentDetailKillSumMoneyShow',
		name : 'stockpaymentbilldetail.stockPaymentDetailKillSumMoneyShow',
		fieldLabel : ' 抵消金额',
		// xtype : 'ERPShowText',
		vtype : "money",
		style : NoAllowBlankStyle,
		blankText : '不能为空！',
		allowBlank : false,
		enableKeyEvents : true,
		listeners : {
			'keyup' : function(field, e) {
				computeCountMoney();
			}
		}
	});

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	var stock_payment_reconcile_handle_params = {
		title : moduleName,
		action : "save",
		grid : grid,
		// 结果路径
		pojo : "result",
		// url
		url : './simple_StockPaymentReconcileBillDetail_handleReconcile.do',
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

			name : 'stockinvoice.stockInvoiceDetailKillSumMoneyShow',
			mapping : 'stockInvoiceDetailKillSumMoneyShow'

		}]),
		// 字段
		field : [{// 第一排
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
				items : [billType]
			}, // 1-1 end
			{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [billNum]
			}, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [billSumMoneyShow]
			}

			]
		}, {// 第一排
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
				items : [reconciliationSumMoneyShow]
			}, // 1-1 end
			{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [noKillSumMoneyShow]
			}, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [stockInvoiceDetailKillSumMoneyShow]
			}

			]
		}]

	}

	var stock_payment_reconcile_handle_params_form = new Ext.form.ERPFormPanel({
		labelWidth : 55,
		frame : true,

		// bodyStyle : 'padding:5px 5px 0',
		// height : 900,
		// autoHeight : false,
		items : stock_payment_reconcile_handle_params.field,
		reader : stock_payment_reconcile_handle_params.reader,
		buttons : [{
			text : '提交',
			listeners : {
				'click' : function() {
					var stockInvoiceDetailKillSum_ = parseFloat(stockInvoiceDetailKillSumMoneyShow.getValue());
					var reconciliationSumMoneyShow_ = parseFloat(payment.reconciliationSumMoneyShow);

					if (reconciliationSumMoneyShow_ < retention_accuracy(stockInvoiceDetailKillSum_)) {
						showErrorMsg("错误", "单据对帐金额不能大于发票对帐余额");
						return;
					}
					var noKillSumMoneyShow_ = parseFloat(billdetail.noKillSumMoneyShow);
					if (noKillSumMoneyShow_ < retention_accuracy(stockInvoiceDetailKillSum_)) {
						showErrorMsg("错误", "单据对帐金额不能大于单据剩余金额");
						return;
					}

					stock_payment_reconcile_handle_params_form.submit({
						url : stock_payment_reconcile_handle_params.url,
						waitMsg : '正在提交...',
						submitEmptyText : false,
						params : {
							'stockpaymentbilldetail.id' : billdetail.id,
							"stockpaymentbilldetail.stockPaymentId" : payment.id
						},
						success : function(result) {
							var stockpaymentbilldetail = result.result.result;
							grid.updateRow(stockpaymentbilldetail);
							setFormValue(stockpaymentbilldetail.stockPayment);
							window.close();
						}
					});
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
		width : 900,
		// height : 400,
		// autoHeight : false,
		items : [stock_payment_reconcile_handle_params_form]
	});

	window.showWin();

	// stock_invoice_reconcile_handle_params_form.load({
	// url : './simple_StockInvoice_get.do?uuid=' + selectId,
	// success : function(result) {
	// mainGrid.load({
	// params : {
	// "searchBean.providerInfoId" : selection_rows[0].data.providerInfoId,
	// "searchBean.stockInvoiceId" : selection_rows[0].id
	// }
	// });
	// }
	// });

	function computeCountMoney() {
		// 发票对帐余额
		var reconciliationSumMoneyShow_r = payment.reconciliationSumMoneyShow;
		// 单据余额
		var noKillSumMoneyShow_r = billdetail.noKillSumMoneyShow;
		// 抵消金额
		var stockInvoiceDetailKillSum_ = stockInvoiceDetailKillSumMoneyShow.getValue();

		var noKillSumMoneyShow_ = noKillSumMoneyShow_r - stockInvoiceDetailKillSum_;

		noKillSumMoneyShow.setValue(retention_accuracy(noKillSumMoneyShow_));

		var _reconciliationSumMoneyShow_ = reconciliationSumMoneyShow_r - stockInvoiceDetailKillSum_;

		reconciliationSumMoneyShow.setValue(retention_accuracy(_reconciliationSumMoneyShow_));

	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}