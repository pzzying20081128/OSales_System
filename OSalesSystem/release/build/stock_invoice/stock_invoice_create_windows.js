function stock_invoice_create_windows(moduleId, moduleName, params) {

	var grid = params.grid.getGrid();

	var stock_invoice_params = {
		title : "新增" + moduleName,
		action : "save",
		grid : grid,
		// 结果路径
		pojo : "sss",
		// url
		url : './saveUpdateMaterialManage.action',
		params : {
			optType : "save"
		},
		// 字段
		field : [
		{// 第一排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
			}, // 1-1 end
			{
			
			}// 1-2end
			, {
			
			}// 1-3 end
			, {
			
			}// 1-3 end
			]
		},
			{// 第二排
			layout : 'column',
			baseCls : 'x-plain',
			items : [{
			}, // 1-1 end
			{
			
			}// 1-2end
			, {
			
			}// 1-3 end
			,{
			
			}// 1-3 end
			]
		}
		]
		
	}

	var stock_invoice_create_window = new stock_invoice_save_update_form_panel_windows(stock_invoice_params);

}