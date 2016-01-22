function stock_contract_create_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();

	var stock_contract_params = {
		title : "新增" + moduleName,
		action : "save",
		grid : grid,
		// 结果路径
		pojo : "result",
		// url
		url : './simple_StockContract_saveUpdate.do',
		params : {
			optType : "save"
		},
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
				items : [createERPcombo({
					id : 'stockcontract.providerInfoId',
					name : 'stockcontract.providerInfoId',
					fieldLabel : ' 供应商',
					url : "./ProviderInfo_combo.do?searchBean.status=有效",
					allowBlank : false,
					forceSelection : false
				})]
			}, // 1-1 end
			{
				columnWidth : .28,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 160
				},
				items : [createERPcombo({
					id : 'stockcontract.stockManId',
					name : 'stockcontract.stockManId',
					fieldLabel : ' 采购员',
					url : "./SysStaff_combo.do?searchBean.status=全部",
					allowBlank : true,
					forceSelection : false,
					width : 160
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
				items : [createERPcombo({
					id : 'stockcontract.companyInfoId',
					name : 'stockcontract.companyInfoId',
					fieldLabel : ' 公司名称',
					url : "./CompanyInfo_combo.do?searchBean.status=有效",
					allowBlank : false,
					forceSelection : false
				})

				]
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
					storeData : [['未启用合同', "未启用合同"], ['历史合同', '历史合同'], ['待定', '待定']],
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

}