function base_product_category_create_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();

	var base_product_category_params = {
		title : "新增" + moduleName,
		action : "save",
		grid : grid,
		// 结果路径
		pojo : "result",
		// url
		url : './simple_ProductCategory_save.do',
		params : {
			optType : "save"
		},
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
					width : 200
				},
				items : [{
					id : 'productCategory.name',
					name : 'productCategory.name',
					fieldLabel : ' 类别',
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
			{
				columnWidth : .5,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 200
				},
				items : [createERPcombo({
					id : 'productCategory.parentId',
					name : 'productCategory.parentId',
					fieldLabel : ' 父类类别',
					url : "./ProductCategory_combo.do?searchBean.status=有效",
					allowBlank : true,
					forceSelection : false
				})]
			}]
		}, {// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
				columnWidth : 1,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 495
				},
				items : [{
					id : 'productCategory.text',
					name : 'productCategory.text',
					fieldLabel : ' 备注',
					xtype : 'textfield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}]
		}]

	}

	var base_product_category_create_window = new base_product_category_save_update_form_panel_windows(base_product_category_params);

}