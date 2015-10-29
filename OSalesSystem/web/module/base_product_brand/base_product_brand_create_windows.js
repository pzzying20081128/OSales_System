function base_product_brand_create_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();

	var base_product_brand_params = {
		title : "新增" + moduleName,
		action : "save",
		grid : grid,
		// 结果路径
		pojo : "result",
		// url
		url : "./simple_ProductBrand_save.do",
		params : {
			optType : "save"
		},
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
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}, // 1-1 end
			// {
			// columnWidth : 1,
			// layout : 'form',
			// defaultType : 'textfield',
			// baseCls : 'x-plain',
			// defaults : {
			// width : 300
			// },
			// items : [{
			// id : 'productbrand.status',
			// name : 'productbrand.status',
			// fieldLabel : ' 状态',
			// xtype : 'textfield',
			// style : NoAllowBlankStyle,
			// blankText : '不能为空！',
			// allowBlank : false,
			// listeners : {
			// 'specialkey' : function(field, e) {
			// }
			// }
			// }]
			// }// 1-2end
			]
		}]

	}

	var base_product_brand_create_window = new base_product_brand_save_update_form_panel_windows(base_product_brand_params);

}