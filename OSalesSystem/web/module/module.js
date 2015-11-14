function createModule(node, userId, params) {
	var moduleId = node.id;
	var moduleName = node.text;
	var loadjs = ["./module/" + moduleId + "/" + moduleId + "_index.js", "./module/" + moduleId + "/" + moduleId + "_action_properties.js", "./module/" + moduleId + "/" + moduleId + "_create_windows.js", "./module/" + moduleId + "/" + moduleId + "_save_update_windows.js", "./module/" + moduleId + "/" + moduleId + "_search_action_properties.js", "./module/" + moduleId + "/" + moduleId + "_search_windows.js", "./module/" + moduleId + "/" + moduleId + "_update_windows.js"

	];
//	alert(moduleId.substring(0,5));
	if(moduleId.substring(0,5)=='base_' || moduleId=='sys_opt_history' ){
		
	}else{
		    loadjs.push("./module/" + moduleId + "/"+moduleId+"_detail/"+moduleId+"_detail_index.js");
			loadjs.push("./module/" + moduleId + "/"+moduleId+"_detail/"+moduleId+"_detail_action_properties.js");
			loadjs.push("./module/" + moduleId + "/"+moduleId+"_detail/"+moduleId+"_detail_create_windows.js");
			loadjs.push("./module/" + moduleId + "/"+moduleId+"_detail/"+moduleId+"_detail_save_update_windows.js");
			loadjs.push("./module/" + moduleId + "/"+moduleId+"_detail/"+moduleId+"_detail_search_action_properties.js");
			loadjs.push("./module/" + moduleId + "/"+moduleId+"_detail/"+moduleId+"_detail_search_windows.js");
			loadjs.push("./module/" + moduleId + "/"+moduleId+"_detail/"+moduleId+"_detail_update_windows.js");
	}
	
	// alert("|"+moduleId+"|");
	switch (moduleId) {
		case "system_manager" : {
			loadjs.push("./ext3/privates/power/user_power_opt.js");
			break;
		}
		case "base_combined_product" :{
		    loadjs.push("./module/" + moduleId + "/"+moduleId+"_detail/"+moduleId+"_detail_index.js");
			loadjs.push("./module/" + moduleId + "/"+moduleId+"_detail/"+moduleId+"_detail_action_properties.js");
			loadjs.push("./module/" + moduleId + "/"+moduleId+"_detail/"+moduleId+"_detail_create_windows.js");
			loadjs.push("./module/" + moduleId + "/"+moduleId+"_detail/"+moduleId+"_detail_save_update_windows.js");
			loadjs.push("./module/" + moduleId + "/"+moduleId+"_detail/"+moduleId+"_detail_search_action_properties.js");
			loadjs.push("./module/" + moduleId + "/"+moduleId+"_detail/"+moduleId+"_detail_search_windows.js");
			loadjs.push("./module/" + moduleId + "/"+moduleId+"_detail/"+moduleId+"_detail_update_windows.js");	
		    break;
		}

//		case "product_classification_management" : {
//			// alert("dddd 1");
//			break;
//		}
//
//		case "course_management" : {
//			loadjs.push("./ext3/fileupload/FileUploadField.js");
//			loadjs.push("./ext3/kindeditor/extke.js");
//			loadjs.push("./module/" + moduleId + "/video_course/index.js");
//			loadjs.push("./module/" + moduleId + "/video_course/video_course_action_properties.js");
//			loadjs.push("./module/" + moduleId + "/video_course/video_course_create_windows.js");
//			loadjs.push("./module/" + moduleId + "/video_course/video_course_save_update_windows.js");
//			loadjs.push("./module/" + moduleId + "/video_course/video_course_search_action_properties.js");
//			loadjs.push("./module/" + moduleId + "/video_course/video_course_search_windows.js");
//			loadjs.push("./module/" + moduleId + "/video_course/video_course_update_windows.js");
//			// alert(loadjs.length);
//			break;
//
//		}
//
//		case "product_management" : {
//
//			loadjs.push("./ext3/fileupload/FileUploadField.js");
//			loadjs.push("./ext3/kindeditor/extke.js");
//			loadjs.push("./module/" + moduleId + "/product_course/index.js");
//			loadjs.push("./module/" + moduleId + "/product_course/product_course_action_properties.js");
//			loadjs.push("./module/" + moduleId + "/product_course/product_course_create_windows.js");
//			loadjs.push("./module/" + moduleId + "/product_course/product_course_save_update_windows.js");
//			loadjs.push("./module/" + moduleId + "/product_course/product_course_search_action_properties.js");
//			loadjs.push("./module/" + moduleId + "/product_course/product_course_search_windows.js");
//			loadjs.push("./module/" + moduleId + "/product_course/product_course_update_windows.js");
//			break;
//		}

		case "base_store_info" : {

			loadjs.push("./module/" + moduleId + "/base_store_position/base_store_position_index.js");
			loadjs.push("./module/" + moduleId + "/base_store_position/base_store_position_action_properties.js");
			loadjs.push("./module/" + moduleId + "/base_store_position/base_store_position_create_windows.js");
			loadjs.push("./module/" + moduleId + "/base_store_position/base_store_position_save_update_windows.js");
			loadjs.push("./module/" + moduleId + "/base_store_position/base_store_position_search_action_properties.js");
			loadjs.push("./module/" + moduleId + "/base_store_position/base_store_position_search_windows.js");
			loadjs.push("./module/" + moduleId + "/base_store_position/base_store_position_update_windows.js");

			break;
		}
//		case "stock_order" : {
//
//			loadjs.push("./module/" + moduleId + "/stock_order_detail/stock_order_detail_index.js");
//			loadjs.push("./module/" + moduleId + "/stock_order_detail/stock_order_detail_action_properties.js");
//			loadjs.push("./module/" + moduleId + "/stock_order_detail/stock_order_detail_create_windows.js");
//			loadjs.push("./module/" + moduleId + "/stock_order_detail/stock_order_detail_save_update_windows.js");
//			loadjs.push("./module/" + moduleId + "/stock_order_detail/stock_order_detail_search_action_properties.js");
//			loadjs.push("./module/" + moduleId + "/stock_order_detail/stock_order_detail_search_windows.js");
//			loadjs.push("./module/" + moduleId + "/stock_order_detail/stock_order_detail_update_windows.js");
//
//			break;
//		}
//
//		case "stock_in_store" : {
//
//			loadjs.push("./module/" + moduleId + "/stock_in_store_detail/stock_in_store_detail_index.js");
//			loadjs.push("./module/" + moduleId + "/stock_in_store_detail/stock_in_store_detail_action_properties.js");
//			loadjs.push("./module/" + moduleId + "/stock_in_store_detail/stock_in_store_detail_create_windows.js");
//			loadjs.push("./module/" + moduleId + "/stock_in_store_detail/stock_in_store_detail_save_update_windows.js");
//			loadjs.push("./module/" + moduleId + "/stock_in_store_detail/stock_in_store_detail_search_action_properties.js");
//			loadjs.push("./module/" + moduleId + "/stock_in_store_detail/stock_in_store_detail_search_windows.js");
//			loadjs.push("./module/" + moduleId + "/stock_in_store_detail/stock_in_store_detail_update_windows.js");
//
//			break;
//		}
	
		default : {

		}
	}

	Ext.Loader.load(loadjs, function(success) {
		eval("create_" + moduleId + "_window" + "( '" + moduleId + "','" + moduleName + "')");
	});

}