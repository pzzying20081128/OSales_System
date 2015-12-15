function stock_return_create_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();

	var initOrder = params.order;

	var stockType = createLocalCombo({
		id : 'stockreturn.stockType',
		name : 'stockreturn.stockType',
		fieldLabel : ' 退货单类别',
		storeData : [['采购退货单', "采购退货单"], ['直营采购退货单', '直营采购退货单']],
		defaultValue : null,
		allowBlank : false
		// disabled:true
	});

	var stock_return_params = {
		title : "新增" + moduleName,
		action : "save",
		grid : grid,
		// 结果路径
		pojo : "result",
		// url
		url : "./simple_StockReturn_save.do",
		params : {
			optType : "save",
			"stockreturn.id" : initOrder.id
		},
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
				items : [{
					id : 'stockreturn.number',
					name : 'stockreturn.number',
					fieldLabel : ' 退货单编号',
					xtype : 'textfield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
					value : initOrder.number,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, // 1-1 end
			{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [

				createLocalCombo({
					id : 'stockreturn.stockProductType',
					name : 'stockreturn.stockProductType',
					fieldLabel : ' 产品类型',
					storeData : [['普通产品', "普通产品"], ['组合产品', '组合产品']],
					defaultValue : null,
					allowBlank : false

				})

				]
			}, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [stockType]
			}]
		},
		// ////////////////////////////////////////////////////////
		{// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 70,
			items : [{
				columnWidth : .66,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 455
				},
				items : [createERPcombo({
					id : 'stockreturn.providerInfoId',
					name : 'stockreturn.providerInfoId',
					fieldLabel : ' 供应商',
					url : "./ProviderInfo_combo.do?searchBean.status=有效",
					allowBlank : false,
					forceSelection : false
					// select : function(combo, record, index) {
					// id = record.id;
					// storePosition.load({
					// params : {
					// 'searchBean.storeInfoId' : id,
					// 'searchBean.status' : '有效'
					// }
					//
					// });
					// }
				})]
			},

			{
				columnWidth : .34,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [

				createLocalCombo({
					id : 'stockreturn.returnType',
					name : 'stockreturn.returnType',
					fieldLabel : ' 退货类型', // 不确定, 开票前退货, 开票后退货
					storeData : [['不确定', "不确定"], ['开票前退货', '开票前退货'], ['开票后退货', '开票后退货']],
					defaultValue : null,
					allowBlank : false

				})

				]
			}]
		}, {// 第二排
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
				items : [{
					id : 'stockreturn.taxSumMoneyMoneyShow',
					name : 'stockreturn.taxSumMoneyMoneyShow',
					fieldLabel : ' 含税总金额',
					xtype : 'ERPShowText',
					// style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'stockreturn.noTaxSumMoneyMoneyShow',
					name : 'stockreturn.noTaxSumMoneyMoneyShow',
					fieldLabel : ' 没税总金额',
					xtype : 'ERPShowText',
					// style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, {

				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'stockreturn.returnDate',
					name : 'stockreturn.returnDate',
					fieldLabel : ' 退货日期',
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
		}, {// 第二排
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
				items : [{
					id : 'stockreturn.orderCount',
					name : 'stockreturn.orderCount',
					fieldLabel : ' 退货数量',
					xtype : 'ERPShowText',
					// style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, // 1-1 end
			{
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [{
					id : 'stockreturn.stockManId1',
					name : 'stockreturn.stockManId1',
					fieldLabel : ' 合同',
					xtype : 'ERPShowText',
					// style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}// 1-2end
			, {
				columnWidth : .33,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 180
				},
				items : [createERPcombo({
					id : 'stockreturn.stockManId',
					name : 'stockreturn.stockManId',
					fieldLabel : ' 采购员',
					url : "./SysStaff_combo.do?searchBean.status=全部",
					allowBlank : true,
					forceSelection : false,
					width : 160
				})]
			}]
		}, {
			layout : 'column',
			baseCls : 'x-plain',
			labelWidth : 70,
			items : [{
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 725
				},
				items : [{
					id : 'stockreturn.text',
					name : 'stockreturn.text',
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
			}]
		}

		]

	}

	var stock_return_create_window = new stock_return_save_update_form_panel_windows(stock_return_params);

}