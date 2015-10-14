function createModule(node, userId, params) {
	var moduleId = node.id;
	var moduleName = node.text;
	var loadjs = ["./module/" + moduleId + "/index.js", "./module/" + moduleId + "/" + moduleId + "_action_properties.js", "./module/" + moduleId + "/" + moduleId + "_create_windows.js", "./module/" + moduleId + "/" + moduleId + "_save_update_windows.js", "./module/" + moduleId + "/" + moduleId + "_search_action_properties.js", "./module/" + moduleId + "/" + moduleId + "_search_windows.js", "./module/" + moduleId + "/" + moduleId + "_update_windows.js"

	];
	// alert("|"+moduleId+"|");
	switch (moduleId) {
		case "system_manager" : {
			loadjs.push("./ext3/privates/power/user_power_opt.js");
			break;
		}

		case "product_classification_management" : {
			// alert("dddd 1");
			break;
		}

		case "course_management" : {
			loadjs.push("./ext3/fileupload/FileUploadField.js");
			loadjs.push("./ext3/kindeditor/extke.js");
			loadjs.push("./module/" + moduleId + "/video_course/index.js");
			loadjs.push("./module/" + moduleId + "/video_course/video_course_action_properties.js");
			loadjs.push("./module/" + moduleId + "/video_course/video_course_create_windows.js");
			loadjs.push("./module/" + moduleId + "/video_course/video_course_save_update_windows.js");
			loadjs.push("./module/" + moduleId + "/video_course/video_course_search_action_properties.js");
			loadjs.push("./module/" + moduleId + "/video_course/video_course_search_windows.js");
			loadjs.push("./module/" + moduleId + "/video_course/video_course_update_windows.js");
			// alert(loadjs.length);
			break;

		}

		case "product_management" : {
			loadjs.push("./ext3/fileupload/FileUploadField.js");
			loadjs.push("./ext3/kindeditor/extke.js");
			loadjs.push("./module/" + moduleId + "/product_course/index.js");
			loadjs.push("./module/" + moduleId + "/product_course/product_course_action_properties.js");
			loadjs.push("./module/" + moduleId + "/product_course/product_course_create_windows.js");
			loadjs.push("./module/" + moduleId + "/product_course/product_course_save_update_windows.js");
			loadjs.push("./module/" + moduleId + "/product_course/product_course_search_action_properties.js");
			loadjs.push("./module/" + moduleId + "/product_course/product_course_search_windows.js");
			loadjs.push("./module/" + moduleId + "/product_course/product_course_update_windows.js");
		}
		default : {

		}
	}

	Ext.Loader.load(loadjs, function(success) {
		eval("create_" + moduleId + "_window" + "( '" + moduleId + "','" + moduleName + "')");
	});

}