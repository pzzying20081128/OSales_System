package cn.zying.osales ;

public class SystemConfigsProperties {

    /**
     * 采购订单的默认订单类型
     */
    public static String key_stock_order_default_order_type = "stock_order_default_order_type" ;

    public enum stock_order_default_order_type {
        采购订单, 直营采购订单
    }

    public static String[] defaultConfigs = { key_stock_order_default_order_type } ;
}
