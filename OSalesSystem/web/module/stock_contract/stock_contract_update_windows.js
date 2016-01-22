function stock_contract_update_windows(moduleId, moduleName, params) {

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
		id : 'stockcontract.providerInfoId',
		name : 'stockcontract.providerInfoId',
		fieldLabel : ' 供应商',
		url : "./ProviderInfo_combo.do?searchBean.status=有效",
		allowBlank : false,
		forceSelection : false
	});

	providerInfoId.load({
		params : {
			"searchBean.id" : selection_rows[0].data.providerInfoId
		}
	});

	var companyInfoId = createERPcombo({
		id : 'stockcontract.companyInfoId',
		name : 'stockcontract.companyInfoId',
		fieldLabel : ' 公司名称',
		url : "./CompanyInfo_combo.do?searchBean.status=有效",
		allowBlank : false,
		forceSelection : false
	})

	companyInfoId.load({
		params : {
			"searchBean.id" : selection_rows[0].data.companyInfoId
		}
	});
	
	var stockManId = createERPcombo({
					id : 'stockcontract.stockManId',
					name : 'stockcontract.stockManId',
					fieldLabel : ' 采购员',
					url : "./SysStaff_combo.do?searchBean.status=全部",
					allowBlank : true,
					forceSelection : false,
					width : 160
				}) ;
			
	stockManId.load({
	       		params : {
			"searchBean.id" : selection_rows[0].data.stockManId
		}     
	});

	var stock_contract_params = {
		title : "编辑" + moduleName,
		action : "update",
		grid : grid,
		// 结果路径
		pojo : "result",
		// url
		url : './simple_StockContract_saveUpdate.do',
		params : {
			optType : "update",
			"stockcontract.id" : selectId
		},
		reader : new Ext.data.JsonReader({
			successProperty : 'success',
			root : 'result',
			totalProperty : 'totalProperty'
		}, [{
			name : 'stockcontract.providerInfo',
			mapping : 'providerInfo'
		}, {
			name : 'stockcontract.providerInfoId',
			mapping : 'providerInfoId'
		}, {
			name : 'stockcontract.stockMan',
			mapping : 'stockMan'
		}, {
			name : 'stockcontract.stockManId',
			mapping : 'stockManId'
		},{
			name : 'stockcontract.companyInfoId',
			mapping : 'companyInfoId'
		}, {
			name : 'stockcontract.companyInfo',
			mapping : 'companyInfo'
		}, {
			name : 'stockcontract.contractStatus',
			mapping : 'contractStatus'
		}, {
			name : 'stockcontract.text',
			mapping : 'text'
		}, {
			name : 'stockcontract.signedDate',
			mapping : 'signedDate'
		}, {
			name : 'stockcontract.status',
			mapping : 'status'
		}

		]),
		// 字段
		field : [{// 第一排
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
				items : [providerInfoId]
			}, // 1-1 end
			{
				columnWidth : .28,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 160
				},
				items : [stockManId ]
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
				items : [companyInfoId]
			}, // 1-1 end
			{
				columnWidth : .28,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 160
				},
				items : [createLocalCombo({
					id : 'stockcontract.contractStatus',
					name : 'stockcontract.contractStatus',
					fieldLabel : ' 合同类型',
//					storeData : [['未启用合同', "未启用合同"], ['执行合同', '执行合同'], ['历史合同', '历史合同'], ['待定', '待定']],
					storeData : [['未启用合同', "未启用合同"] , ['历史合同', '历史合同'], ['待定', '待定']],
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					defaultValue : "未启用合同",
					allowBlank : false
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
				items : [{
					id : 'stockcontract.text',
					name : 'stockcontract.text',
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
			}, // 1-1 end
			{
				columnWidth : .28,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 160
				},
				items : [{

					id : 'stockcontract.signedDate',
					name : 'stockcontract.signedDate',
					fieldLabel : ' 签订日期',
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
			}// 1-2end
			]
		}

		]

	}

	var stock_contract_create_window = new stock_contract_save_update_form_panel_windows(stock_contract_params);
	
	stock_contract_create_window.load({
		url : './simple_StockContract_get.do?uuid=' + selectId,
		success : function(result) {
			json = result.result;
		}
	});

}