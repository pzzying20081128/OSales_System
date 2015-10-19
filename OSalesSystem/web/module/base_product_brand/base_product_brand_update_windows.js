function base_product_brand_update_windows(moduleId, moduleName, params) {

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

	var base_product_brand_params = {
		title : "编辑" + moduleName,
		action : "update",
		grid : grid,
		// 结果路径
		pojo : "result",
		// url
		url : "./simple_ProductBrand_save.do",
		params : {
			optType : "update",
			"productBrand.id":selectId
		},
		reader : new Ext.data.JsonReader({
			successProperty : 'success',
			root : 'result',
			totalProperty : 'totalProperty'
		}, [{
			name : 'productBrand.name',
			mapping : 'name'
		}, {
			name : 'productBrand.status',
			mapping : 'status'
		}]),
		// 字段
		field : [{// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 300
				},
				items : [{
					id : 'productBrand.name',
					name : 'productBrand.name',
					fieldLabel : ' 品牌',
					xtype : 'textfield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, // 1-1 end
			{
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 300
				},
				items : [createLocalCombo({
					id : 'productBrand.status',
					name : 'productBrand.status',
					fieldLabel : ' 状态',
					storeData : [["无效", "无效"], ["删除", "删除"], ["有效", "有效"] ],
					defaultValue : null,
					allowBlank : true
				})]
			}// 1-2end
			]
		}]

	}

	var base_product_brand_create_window = new base_product_brand_save_update_form_panel_windows(base_product_brand_params);

	base_product_brand_create_window.load({
		url : "./simple_ProductBrand_get.do?uuid=" + selectId,
		success : function(result) {

		}
	});

}