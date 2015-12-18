package cn.zying.osales ;

public class MeunsTree {

    private static MeunsTree meunsTree = new MeunsTree() ;

    private MeunsTree() {

    }

    public static MeunsTree instance() {
        return meunsTree ;
    }

    public static String[][] initTreeDatas() {
        return meunsTree.initTreeData() ;
    }

    private String p0[] = { "sys_info", "系统信息", "false", "font_weight", "0", "0", "[]" } ;

    private String p0001[] = { "sys_opt_history", "操作日志", "true", "", "sys_info", "0", "[{search:1,label:'查询'}]" } ;

    private String p0002[] = { "sys_print_template", "打印/导出设置", "true", "", "sys_info", "0", "[{search:1,label:'查询'}]" } ;

    private String p1[] = { "base_info", "基础信息", "false", "font_weight", "0", "0", "[]" } ;

    private String p1001[] = { "base_info_staff", "员工管理", "true", "", "base_info", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'}]" } ;

    private String p1002[] = { "base_product_brand", "产品品牌", "true", "", "base_info", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'}]" } ;

    private String p1003[] = { "base_product_category", "产品类型", "true", "", "base_info", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'}]" } ;

    private String p1004[] = { "base_provider_info", "供应商", "true", "", "base_info", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'}]" } ;

    private String p1005[] = { "base_store_info", "仓库", "true", "", "base_info", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'}]" } ;

    private String p1006[] = { "base_product_info", "产品信息", "true", "", "base_info", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'}]" } ;

    private String p1007[] = { "base_combined_product", "组合产品", "true", "", "base_info", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'},{check:1,label:'审核'}]" } ;

    private String p2[] = { "stock_manage", "采购信息", "false", "font_weight", "0", "0", "[]" } ;

    private String p2001[] = { "stock_order", "采购订单", "true", "", "stock_manage", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'},{check:1,label:'审核'} ]" } ;

    private String p2002[] = { "stock_store_reveive", "采购进货单", "true", "", "stock_manage", "0", "[{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'},{check:1,label:'审核'},{print:1,label:'打印'},{export:1,label:'导出'}    ]" } ;

    private String p2003[] = { "stock_return", "采购退货单", "true", "", "stock_manage", "0", "[{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'},{check:1,label:'审核'},{print:1,label:'打印'},{export:1,label:'导出'}    ]" } ;

    private String p6[] = { "storage_room_manage", "仓库管理", "false", "font_weight", "0", "0", "[]" } ;

    private String p6000[] = { "store_product_info_stock", "库存信息", "true", "", "storage_room_manage", "0", "[{search:1,label:'查询'}]" } ;

    private String p6001[] = { "stock_in_store", "采购入库单", "true", "", "storage_room_manage", "0", "[{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'},{check:1,label:'审核'}]" } ;

    private String p6002[] = { "stock_return_store_out", "采购退货出库单", "true", "", "storage_room_manage", "0", "[{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'},{check:1,label:'审核'}]" } ;

    private String p7[] = { "produce_manage", "生产管理", "false", "font_weight", "0", "0", "[]" } ;

    private String p7001[] = { "produce_combined_product", "组合产品生产", "true", "", "produce_manage", "0", "[{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'},{check:1,label:'审核'}]" } ;

    //    private String p80[] = { "store_house", "仓库管理", "false", "font_weight", "0", "0", "[]" } ;

    //    

    //   
    //    private String p3[] = { "product_classification_management", "产品管理", "false", "font_weight", "0", "0", "[]" } ;
    //    
    //     private String p4[] = { "classification_management", "类别管理", "true", "", "product_classification_management", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'}]" } ;
    //     
    //     private String p6[] = { "course_management", "课程管理", "true", "", "product_classification_management", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'} ,{up_shelves:1,label:'上/下架'} ,{popular_recommend:1,label:'热门推荐'} ,{home_recommend:1,label:'首页推荐'} ,{is_free:1,label:'收费'}   ]" } ;
    //     
    //     private String p7[] = { "product_management", "产品管理", "true", "", "product_classification_management", "0", "" +
    //     		"[ {add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'} ,{up_shelves:1,label:'上下架'} ," +
    //     		"{popular_recommend:1,label:'热门推荐'} ,{home_recommend:1,label:'首页推荐'} ,{navigation:1,label:'导航推荐'}  ]"
    //             } ;
    //    
    //     private String p8[] = { "order_manage", "订单管理", "false", "font_weight", "0", "0", "[]" } ;
    //     
    //     private String p81[] = { "package_order_manage", "产品包订单管理", "true", "", "order_manage", "0", "[{search:1,label:'查询'}]" } ;

    //     package_order_manage

    // ==========================================================================

    //    private String p100[] = { "BASE_DATA", "基础数据", "false", "font_weight", "0", "0", "[]" } ;
    //
    //    private String p106[] = { "SIGN_IN_AND_SIGN_OUT", "签到管理", "true", "", "BASE_DATA", "0", "[{signIn:1,label:'签到'},{search:1,label:'查询'},{export:1,label:'导出'},{passWord:1,label:'修改密码'}]" } ;
    //
    //    private String p101[] = { "BASE_DATA_MATERIAL", "物料管理", "true", "", "BASE_DATA", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'},{export:1,label:'导出'},{import:1,label:'导入'}]" } ;
    //
    //    private String p102[] = { "BASE_DATA_MACHINE", "整机管理", "true", "", "BASE_DATA", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'},{export:1,label:'导出'},{import:1,label:'导入'}]" } ;
    //
    //    private String p103[] = { "BASE_DATA_STORE", "仓库信息", "true", "", "BASE_DATA", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'},{export:1,label:'导出'},{import:1,label:'导入'}]" } ;
    //
    //    private String p104[] = { "BASE_DATA_PROVIDER", "供应商信息", "true", "", "BASE_DATA", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'},{export:1,label:'导出'},{import:1,label:'导入'}]" } ;
    //
    //    private String p105[] = { "BASE_DATA_SERVICE_STATION", "区域/服务站信息", "true", "", "BASE_DATA", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'},{export:1,label:'导出'},{import:1,label:'导入'}]" } ;
    //
    //
    //    private String p107[] = { "DIVERSITY_MANAGE", "多元化管理", "true", "", "BASE_DATA", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'},{export:1,label:'导出'},{import:1,label:'导入'}]" } ;
    //
    //
    //
    //    // ==========================================================================
    //
    //    private String p200[] = { "WORK_ORDER_MANAGEMENT", "工单管理", "false", "font_weight", "0", "0", "[]" } ;
    //
    //    private String p201[] = { "WORK_ORDER_MANAGEMENT_SERVICE_STATION", "服务站工单管理", "true", "", "WORK_ORDER_MANAGEMENT", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'},{export:1,label:'导出'},{import:1,label:'导入'}]" } ;
    //
    //    private String p202[] = { "WORK_ORDER_MANAGEMENT_REPAIR", "维修工单管理", "true", "", "WORK_ORDER_MANAGEMENT", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'},{export:1,label:'导出'}]" } ;
    //
    //    private String p203[] = { "WORK_ORDER_MANAGEMENT_CHECK", "检测工单管理", "true", "", "WORK_ORDER_MANAGEMENT", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'},{export:1,label:'导出'}]" } ;
    //
    //
    //
    //    // ==========================================================================
    //           private String p204[] = { "STORE_MANAGE", "仓库管理", "false", "font_weight", "0", "0", "[]" } ;
    //
    //    private String p205[] = { "STORE_ALLOCATION", "调拨仓库", "true", "", "STORE_MANAGE", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'},{checked:1,label:'审核'},{print:1,label:'打印'}]" } ;
    //
    //    private String p206[] = { "STORE_STATISTICAL_REPORT", "仓库统计", "true", "", "STORE_MANAGE", "0", "[{search:1,label:'查询'},{export:1,label:'导出'},{import:1,label:'导入'}]" } ;
    //
    //    private String p207[] = { "STOCK_STORE_IN", "采购入库单", "true", "", "STORE_MANAGE", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'},{checked:1,label:'审核'},{print:1,label:'打印'}]" } ;
    //
    //    private String p208[] = { "SALES_STORE_OUT", "销售出库单", "true", "", "STORE_MANAGE", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'},{checked:1,label:'审核'},{print:1,label:'打印'}]" } ;
    //
    //    private String p209[] = { "GOODS_DAMAGE", "报损单据", "true", "", "STORE_MANAGE", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'},{checked:1,label:'审核'},{print:1,label:'打印'}]" } ;
    //
    //    private String p210[] = { "UNASSEMBLED_GOODS", "拆装单据", "true", "", "STORE_MANAGE", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'},{checked:1,label:'审核'},{print:1,label:'打印'}]" } ;
    //
    //    private String p211[] = { "BORROW_OWE", "借欠单据", "true", "", "STORE_MANAGE", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'},{checked:1,label:'审核'},{print:1,label:'打印'}]" } ;
    //
    //    private String p212[] = { "SERVICE_STATION_APPLY", "服务站申请单", "true", "", "STORE_MANAGE", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'},{checked:1,label:'审核'},{print:1,label:'打印'}]" } ;
    //
    //    private String p213[] = { "STORE_WARNING", "库存预警", "true", "", "STORE_MANAGE", "0", "[{search:1,label:'查询'},{export:1,label:'导出'}]" } ;
    //
    //    private String p214[] = { "STORE_ALLOCATION_ROAD", "调拨汇总", "true", "", "STORE_MANAGE", "0", "[{search:1,label:'查询'},{export:1,label:'导出'},{print:1,label:'打印'}]" } ;
    //
    //    private String p215[] = { "STORE_CHECKED", "库存盘点", "true", "", "STORE_MANAGE", "0", "[{add:1,label:'增加'},{edit:1,label:'编辑'},{delete:1,label:'删除'},{search:1,label:'查询'},{checked:1,label:'审核'},{print:1,label:'打印'}]" } ;
    //
    //
    //    // ==========================================================================
    //
    //    private String p500[] = { "REPORT_MANAGEMENT", "统计", "false", "font_weight", "0", "0", "[]" } ;
    //
    //    private String p501[] = { "REPORT_SERVICE_STATION_WORK_ORDER", "服务站维修工单", "true", "", "REPORT_MANAGEMENT", "0", "[{search:1,label:'查询'},{export:1,label:'导出'}]" } ;
    //
    //    private String p502[] = { "REPORT_WORKSHOP_REPAIR_WORK_ORDER", "车间维修工单", "true", "", "REPORT_MANAGEMENT", "0", "[{search:1,label:'查询'},{export:1,label:'导出'}]" } ;
    //
    //    private String p503[] = { "REPORT_WORKSHOP_CHECK_WORK_ORDER", "检测工单", "true", "", "REPORT_MANAGEMENT", "0", "[{search:1,label:'查询'},{export:1,label:'导出'}]" } ;
    //
    //    private String p504[] = { "WARRANTY_USERS", "延保用户", "true", "", "REPORT_MANAGEMENT", "0", "[{search:1,label:'查询'},{export:1,label:'导出'}]" } ;

    //    private String[][] treeData = { p1, p2,p3, p100, p106,p101, p102, p103,p104, p105,p107, p200, p201, p202, p203, p204,p207 ,p208,p209,p210,p211,p212, p205,p214, p206,p213,p215,p500,p501,p502,p503,p504} ;
    private String[][] treeData = { p0, p0001, p0002, p1, p1001, p1002, p1003, p1004, p1005, p1006, p1007, p2, p2001, p2002, p2003, p6, p6000, p6001, p6002, p7, p7001 } ;

    private String[][] initTreeData() {
        return treeData ;
    }

}
