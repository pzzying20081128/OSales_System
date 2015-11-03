function base_product_category_update_windows(moduleId, moduleName, params) {

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

	var productCategoryParent = createERPcombo({
		id : 'productCategory.parentId',
		name : 'productCategory.parentId',
		fieldLabel : ' 父类类别',
		url : "./ProductCategory_combo.do",
		params : {
			"searchBean.status" : "有效"
		},
		allowBlank : true,
		forceSelection : false
	});

	var base_product_category_params = {
		title : "编辑" + moduleName,
		action : "update",
		grid : grid,
		// 结果路径
		pojo : "result",
		// url
		url : './simple_ProductCategory_save.do',
		params : {
			optType : "update",
			"productCategory.id" : selectId
		},
		reader : new Ext.data.JsonReader({
			successProperty : 'success',
			root : 'result',
			totalProperty : 'totalProperty'
		}, [{
			name : 'productCategory.parent',
			mapping : 'parent'
		}, {
			name : 'productCategory.name',
			mapping : 'name'
		}, {
			name : 'productCategory.text',
			mapping : 'text'
		}, {
			name : 'productCategory.isChild',
			mapping : 'isChild'
		}, {
			name : 'productCategory.status',
			mapping : 'status'
		},]),
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
				items : [productCategoryParent]
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
					style : AllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : true,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			}]
		}, {// 第二排
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
				items : [createLocalCombo({
					id : 'productCategory.status',
					name : 'productCategory.status',
					fieldLabel : ' 状态',
					storeData : [['有效', "有效"], ['删除', '删除']],
					defaultValue : null,
					allowBlank : false
				})]

			}]
		}]

	}

	var base_product_category_create_window = new base_product_category_save_update_form_panel_windows(base_product_category_params);

	base_product_category_create_window.load({
		url : './simple_ProductCategory_get.do?uuid=' + selectId,
		success : function(result) {
			_result_ = result.result;
			productCategoryParent.load({
				params : {
					uuid : _result_.result.parentId,
					"searchBean.status" : "有效"
					,
				},
				success : function() {
					productCategoryParent.setValue(_result_.result.parentId);
				}
			});
		}
	});

}