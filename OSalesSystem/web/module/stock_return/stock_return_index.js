function create_stock_return_window(moduleId, moduleName) {

	var checkButton = new Ext.Toolbar.Button({
		// id : moduleId + '_search',
		xtype : "tbbutton",
		text : "审核",
		key : "check",
		// keyBinding : createSearchKey(),
		handler : function() {

			var selection_rows = mainGrid.getSelectionModel().getSelections();

			if (selection_rows.length == 0) {
				showErrorMsg('提示信息', '请选择要审核的数据');
				return false;
			}

			if (selection_rows.length > 1) {
				showErrorMsg('提示信息', '只能选择一条数据进行审核');
				return false;
			}

			if (selection_rows[0].data.status == "删除") {
				showErrorMsg('提示信息', '本条信息的状态是[' + selection_rows[0].data.status + ']不能' + opt);
				return false;
			}

			var selectId = selection_rows[0].id;
			showMsgYN({
				msg : "是否要审核该条订单",
				yes : function(YN) {
					ERPAjaxRequest({
						url : "./simple_StockReturn_check.do",
						params : {
							"stockreturn.id" : selection_rows[0].id
						},
						success : function(response, options) {
							mainGrid.reload({
								success : function() {
									detailGrid.removeAll();
									detailGrid.openAllButton(false);
								}

							});
						}
					});
				}
			});

		}

	});

	var mainGridModule = new mainGridWindow({
		moduleId : moduleId,
		// list grid
		url : "./list_StockReturn_list.do",
		// grid_column.record
		record : stock_return_grid_column.record,
		// grid_column.column
		column : stock_return_grid_column.column,
		tbar : {
			// plugins : new Ext.ux.ToolbarKeyMap(),
			items : [{
				// id : moduleId + '_add',
				key : "add",
				xtype : "tbbutton",
				text : "增加",
				// keyBinding : createCreateKey(),
				handler : function(bt) {

					ERPAjaxRequest({
						url : "./simple_StockReturn_initOrder.do",
						// async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
						success : function(result) {
							// init order 都到订单编号
							order = result.result.result;
							stock_return_create_windows(moduleId, moduleName, {
								grid : mainGridModule,
								order : order
							});
						}

					});

				}
			}, {
				// id : moduleId + '_edit',
				xtype : "tbbutton",
				text : "编辑",
				key : "edit",
				// keyBinding : createEditKey(),
				handler : function(bt) {
					stock_return_update_windows(moduleId, moduleName, {
						grid : mainGridModule
					});
				}
			}, {
				// id : moduleId + '_delete',
				xtype : "tbbutton",
				text : "删除",
				key : "delete",
				// keyBinding : createDeleteKey(),
				handler : function(bt) {
					stock_return_delete_windows(moduleId, moduleName, {
						grid : mainGridModule
						,
					});
				}
			}, {
				// id : moduleId + '_search',
				xtype : "tbbutton",
				text : "查询",
				key : "search",
				// keyBinding : createSearchKey(),
				handler : function() {
					var searchWindex = stock_return_search_windows(moduleId, moduleName, {
						grid : mainGridModule,
						searchParams : stock_return_search_params,
						detailGrid : detailGrid
					});
				}
			}, checkButton]

		},
		init : {
			// 行被选择
			select : function(rowDataId, data, sm, rowIdx, r) {
				stockSelect(data, checkButton, detailGrid);
				detailGrid.load({
					params : {
						'searchBean.stockReturnId' : rowDataId
					}
				});

			},
			// 返回这一行的状态 1:OK -1 NO OK checkName:
			status : function(data) {

			}
		}
	});

	var mainGrid = mainGridModule.getGrid();

	var detailModule = new create_stock_return_detail_window(moduleId + "_detail", "明细", {
		mainGrid : mainGrid
	});

	var detailGrid = detailModule.getGrid();

	mainGridModule.setDetailGrid(detailGrid);

	var layout = new Ext.Panel({
		layout : 'border',
		width : 600,
		height : 600,
		minHeight : 100,
		maxHeight : 500,
		items : [new Ext.Panel({
			id : "111",
			layout : 'fit',
			region : 'north',
			margins : '0 0 0 0',
			split : true,
			height : 300,
			items : mainGrid
			// items : sales_order_store_out_panel_print
		})

		, new Ext.Panel({
			id : "222",
			layout : 'fit',
			region : 'center',
			margins : '0 0 0 0',

			// height : "atuo",
			title : '明细',
			items : detailGrid

		})

		]
	});

	var window = new Ext.ERPWindow({
		title : moduleName,
		items : [layout],// 里面所包含的组件
		// 用于权限
		grids : [mainGrid],
		moduleId : moduleId,
		listeners : {}
	});
	window.showWin();

	mainGrid.load({
		params : {
			'searchBean._dc' : "_dc"
		}
	});

	function stock_return_delete_windows(moduleId, moduleName, params) {
		var mainGridModule = params.grid;
		var mainGrid = mainGridModule.getGrid();
		var selection_rows = mainGrid.getSelectionModel().getSelections();

		if (selection_rows == null) {
			showErrorMsg('提示信息', '请选择要删除的数据记录！！');
			return false;
		}

		if (selection_rows.length != 1) {
			showErrorMsg('提示信息', '只能选择一行数据记录！！');
			return false;
		}
		var selectId = selection_rows[0].id;
		showMsgYN({
			msg : "是否要删除该条信息",
			yes : function(YN) {
				ERPAjaxRequest({
					url : "./simple_StockReturn_remove.do",
					params : {
						"stockreturn.id" : selectId
					},
					// async: false, //ASYNC 是否异步( TRUE 异步 , FALSE 同步)
					success : function(response, options) {
						mainGrid.reload();
					}
				});
			}
		});
	}

}