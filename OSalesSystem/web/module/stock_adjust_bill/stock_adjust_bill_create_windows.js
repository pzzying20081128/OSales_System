function stock_adjust_bill_create_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();

	var stock_adjust_bill_params = {
		title : "新增" + moduleName,
		action : "save",
		grid : grid,
		// 结果路径
		pojo : "result",
		// url
		url : './simple_StockAdjustBill_save.do',
		params : {
			optType : "save"
		},
		// 字段
		field : [{// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [{
					id : 'stockadjustbill.adjustNum',
					name : 'stockadjustbill.adjustNum',
					fieldLabel : '调整单号',
					xtype : 'textfield',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, // 1-1 end
			{
				columnWidth : .67,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 500
				},
				items : [createERPcombo({
					id : 'stockadjustbill.providerInfoId',
					name : 'stockadjustbill.providerInfoId',
					fieldLabel : ' 供应商',
					url : "./ProviderInfo_combo.do?searchBean.status=有效",
					allowBlank : false,
					forceSelection : false
				})]
			}// 1-2end
			]
		}, {// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [createLocalCombo({
					id : 'stockadjustbill.adjustType',
					name : 'stockadjustbill.adjustType',
					fieldLabel : ' 调整类型',
					defaultValue : null,
					storeData : [['票前', "票前"], ['票后', "票后"]],
					allowBlank : false
				})]
			}, // 1-1 end
			{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [createERPcombo({
					id : 'stockadjustbill.adjustSubject',
					name : 'stockadjustbill.adjustSubject',
					fieldLabel : ' 调整科目',
					url : "./AdjustSubject_combo.do",
					allowBlank : false,
					forceSelection : false
				})
				]
			}// 1-2end
			, {
				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 214
				},
				items : [{
					id : 'stockadjustbill.adjustSumMoneyShow',
					name : 'stockadjustbill.adjustSumMoneyShow',
					fieldLabel : ' 调整金额',
					xtype : 'textfield',
					vtype : "money",
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}// 1-3 end
			]
		}, {// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [{
					id : 'stockadjusfalsetbill.adjustDate',
					name : 'stockadjustbill.adjustDate',
					fieldLabel : ' 调整日期',
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
				columnWidth : .67,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 500
				},
				items : [{
					id : 'stockadjustbill.text',
					name : 'stockadjustbill.text',
					fieldLabel : ' 备注',
					xtype : 'textfield',
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}// 1-3 end
			]
		}]

	}

	var stock_adjust_bill_create_window = new stock_adjust_bill_save_update_form_panel_windows(stock_adjust_bill_params);

}