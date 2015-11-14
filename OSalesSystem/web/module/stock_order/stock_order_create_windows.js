function stock_order_create_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();

	var initOrder = params.order;

	var stockType = createLocalCombo({
		id : 'stockorder.stockType',
		name : 'stockorder.stockType',
		fieldLabel : ' 订单类型',
		storeData : [['采购订单', "采购订单"], ['直营采购订单', '直营采购订单']],
		defaultValue : null,
		allowBlank : false
		// disabled:true
	});

	var stock_order_params = {
		title : "新增" + moduleName,
		action : "save",
		grid : grid,
		// 结果路径
		pojo : "result",
		// url
		url : './simple_StockOrder_save.do',
		params : {
			optType : "save",
			'stockorder.id' : initOrder.id

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
					id : 'stockorder.number',
					name : 'stockorder.number',
					fieldLabel : ' 订单编号',
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
					id : 'stockorder.stockProductType',
					name : 'stockorder.stockProductType',
					fieldLabel : ' 采购类型',
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
					id : 'stockorder.providerInfoId',
					name : 'stockorder.providerInfoId',
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
				items : [createERPcombo({
					id : 'stockorder.stockManId',
					name : 'stockorder.stockManId',
					fieldLabel : ' 采购员',
					url : "./SysStaff_combo.do?searchBean.status=全部",
					allowBlank : true,
					forceSelection : false,
					width : 160
				})]
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
					id : 'stockorder.taxSumMoneyMoneyShow',
					name : 'stockorder.taxSumMoneyMoneyShow',
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
					id : 'stockorder.noTaxSumMoneyMoneyShow',
					name : 'stockorder.noTaxSumMoneyMoneyShow',
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
					id : 'stockorder.stockDate',
					name : 'stockorder.stockDate',
					fieldLabel : ' 采购日期',
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
					id : 'stockorder.orderCount',
					name : 'stockorder.orderCount',
					fieldLabel : ' 订购数量',
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
					id : 'stockorder.stockManId1',
					name : 'stockorder.stockManId1',
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
				items : [{
					id : 'stockorder.orderDate',
					name : 'stockorder.orderDate',
					fieldLabel : ' 订单日期',
					xtype : 'datefield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					format : 'Y-m-d',
					allowBlank : true,
					value : new Date(),
					listeners : {
						'specialkey' : function(field, e) {

						}
					}
				}]
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
					id : 'stockorder.text',
					name : 'stockorder.text',
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

	this.openWin = function(params) {
//		detailParams : {
//							stockdetail:stockdetail
//							//create_stock_order_detail_window
//						}
		var detailParams = params.detailParams; 
		var stock_order_create_window = new stock_order_save_update_form_panel_windows(stock_order_params,{
		detailParams:detailParams
		});
		return stock_order_create_window;
	}

}