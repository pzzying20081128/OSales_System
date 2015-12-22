function stock_invoice_update_windows(moduleId, moduleName, params) {

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

	var providerInfoId = createERPcombo({
		id : 'stockinvoice.providerInfoId',
		name : 'stockinvoice.providerInfoId',
		fieldLabel : ' 供应商',
		url : "./ProviderInfo_combo.do?searchBean.status=有效",
		allowBlank : false,
		forceSelection : false
	});

	providerInfoId.load({
		params : {
			'searchBean.id' : selection_rows[0].providerInfoId
		}
	});

	var stock_invoice_params = {
		title : "编辑" + moduleName,
		action : "update",
		grid : grid,
		// 结果路径
		pojo : "result",
		// url
		url : './simple_StockInvoice_save.do',
		params : {
			optType : "update",
			"stockinvoice.id" : selectId
		},
		reader : new Ext.data.JsonReader({
			successProperty : 'success',
			root : 'result',
			totalProperty : 'totalProperty'
		}, [{
			name : 'stockinvoice.num',
			mapping : 'num'
		}, {
			name : 'stockinvoice.invoiceNum',
			mapping : 'invoiceNum'
		}, {
			name : 'stockinvoice.providerInfo',
			mapping : 'providerInfo'
		}, {
			name : 'stockinvoice.providerInfoId',
			mapping : 'providerInfoId'
		}, {
			name : 'stockinvoice.invoiceDate',
			mapping : 'invoiceDate'
		}, {
			name : 'stockinvoice.paymentDate',
			mapping : 'paymentDate'
		}, {
			name : 'stockinvoice.invoiceSumMoneyShow',
			mapping : 'invoiceSumMoneyShow'
		}, {
			name : 'stockinvoice.invoiceSum',
			mapping : 'invoiceSum'
		}, {
			name : 'stockinvoice.text',
			mapping : 'text'
		}, {
			name : 'stockinvoice.recordMan',
			mapping : 'recordMan'
		}, {
			name : 'stockinvoice.checkMan',
			mapping : 'checkMan'
		}, {
			name : 'stockinvoice.checkedDate',
			mapping : 'checkedDate'
		}, {
			name : 'stockinvoice.killSumMoneyShow',
			mapping : 'killSumMoneyShow'
		}, {
			name : 'stockinvoice.noKillSumMoneyShow',
			mapping : 'noKillSumMoneyShow'
		}, {
			name : 'stockinvoice.reconciliationSumMoneyShow',
			mapping : 'reconciliationSumMoneyShow'
		}, {
			name : 'stockinvoice.status',
			mapping : 'status'
		}]),
		// 字段
		field : [{// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 250
				},
				items : [{
					id : 'stockinvoice.num',
					name : 'stockinvoice.num',
					fieldLabel : ' 发票编号',
					xtype : 'textfield',
					// style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, // 1-1 end
			{
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 250
				},
				items : [{
					id : 'stockinvoice.invoiceNum',
					name : 'stockinvoice.invoiceNum',
					fieldLabel : ' 发票号',
					xtype : 'textfield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}// 1-2en
			]
		}, {// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 250
				},
				items : [providerInfoId]
			}, // 1-1 end
			{
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 250
				},
				items : [{
					id : 'stockinvoice.invoiceSumMoneyShow',
					name : 'stockinvoice.invoiceSumMoneyShow',
					fieldLabel : ' 发票金额',
					xtype : 'textfield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}// 1-2en
			]
		},// 第一排
		{
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 250
				},
				items : [{
					id : 'stockinvoice.invoiceDate',
					name : 'stockinvoice.invoiceDate',
					fieldLabel : ' 发票日期',
					xtype : 'datefield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					format : 'Y-m-d',
					allowBlank : false,
					value : new Date(),
					listeners : {
						'specialkey' : function(field, e) {

						}
					}

				}]
			}, // 1-1 end
			{

				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 250
				},
				items : [{
					id : 'stockinvoice.paymentDate',
					name : 'stockinvoice.paymentDate',
					fieldLabel : ' 付款日期',
					xtype : 'datefield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					format : 'Y-m-d',
					allowBlank : false,
					value : new Date(),
					listeners : {
						'specialkey' : function(field, e) {

						}
					}
				}]
			}]
		}, {
			columnWidth : 1,
			layout : 'form',
			defaultType : 'textfield',
			baseCls : 'x-plain',
			defaults : {
				width : 585
			},
			items : [{
				id : 'stockinvoice.text',
				name : 'stockinvoice.text',
				fieldLabel : '  备注',
				xtype : 'textfield',
				style : AllowBlankStyle,
				blankText : '不能为空！',
				allowBlank : true,
				listeners : {
					'specialkey' : function(field, e) {
					}
				}
			}]
		}// 1-2en
		]

	}

	var stock_invoice_create_window = new stock_invoice_save_update_form_panel_windows(stock_invoice_params);

	stock_invoice_create_window.load({
		url : './simple_StockInvoice_get.do?uuid=' + selectId,
		success : function(result) {
			json = result.result;
		}
	});

}