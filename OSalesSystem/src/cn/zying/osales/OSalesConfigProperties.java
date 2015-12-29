package cn.zying.osales ;

public interface OSalesConfigProperties {
    public static enum BillType {

        采购进货单, 采购票前调整单, 采购退货单 ,采购付款
    }

    
    // 采购单是否对过账
    public enum StockBillIsReconciliation {
        已对帐, 末对帐, 全部对帐, 删除, 查询非全部对帐,付款已对帐
    }

    // 采购付款 付款方式
    public static enum StockPaymentType {
        现金, 银行转账, 支票
    }

    public enum ContractStatus {
        未启用合同, 执行合同, 历史合同, 待定

    }

    //    退货类型

    public enum OptSum {
        add, del
    }

    //采购订单代号 CGSO

    //采购退货单代号 CGTH
    // 采购退货出库单CGTHCK

    //采购入库单CGRK 

    //采购进货单 CGSR

    //快速生产 CGSR

    // 采购发票 SGFP
    
    //采购付款 CGFK

    // 单据简称
    public enum OrderSimpleName {
        KSSC, CGSR, CGRK, CGSO, CGTH, CGTHCK, SGFP, CGDD,CGFK
    }

    public enum StockType {
        采购订单, 直营采购订单, 采购退货单, 直营采购退货单
    }

    public enum ProductInfoType {
        普通产品, 组合产品
    }

    public enum StoreType {
        一般仓库, 专柜, 样品
    }

    public enum CommodityType {
        正常商品, 赠品, 均价商品, 券类商品,
    }

    public enum ReturnType {
        不确定, 开票前退货, 开票后退货

    }

    public enum PaymentMethod {
        月结, 到付, 预付, 全部

    }

    ///////////////////////////////////////////////////////////
    public static String classification_base_info = "基础信息" ;

    public static String classification_base_info_module_base_info_sys_staff = "员工信息" ;

    ////////////////////////////////////////////////////////////
    public static int isDefault_1 = 1 ;

    public static int isDefault_0 = 0 ;

    public static int isDefault_all = -1 ;

    public static long default_long_null = 0 ;

    public static int default_int_null = 0 ;

    /////////////////// error///////////////////////////////////
    String USER_PASSWORD_ERROR = "用户名或密码错误" ;

    String USER_UPDATE_PASSWORD_ERROR = "更新密码错误" ;

    /////////////////////////////////////////////////////////////

    String query_sysStaffUser_searchByAccessName = "sysStaffUser_searchByAccessName" ;

    String query_sysStaffUser_searchUserPower_userId = "sysStaffUser_searchUserPower_userId" ;

    String query_sysStaffUser_searchUserPower_userId_moduleId = "sysStaffUser_searchUserPower_userId_moduleId" ;

    public enum OptType {
        save, update, check, delete, list, search, searchLike, init
    }

    public enum Status {
        无效, 删除, 有效, 全部, 初始化, 已审核, 等待其他审核
    }

}
