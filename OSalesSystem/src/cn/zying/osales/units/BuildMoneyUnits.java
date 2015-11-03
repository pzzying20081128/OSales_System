package cn.zying.osales.units ;

import java.beans.PropertyDescriptor ;
import java.lang.reflect.InvocationTargetException ;
import java.lang.reflect.Method ;

import org.apache.commons.beanutils.PropertyUtils ;
import org.apache.log4j.Logger ;

import cn.zy.apps.tools.logger.Loggerfactory ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.units.moneys.BuildMoneyFactory ;
import cn.zy.apps.tools.units.moneys.IBuildMoneyFactory ;
import cn.zying.osales.pojos.StockOrderDetail ;

public class BuildMoneyUnits {

    private static IBuildMoneyFactory buildMoneyFactory = BuildMoneyFactory.getBuildMoney() ;

    private static Logger logger = Loggerfactory.instance(BuildMoneyUnits.class) ;

    public static <V> void build(V result) {

        PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(result.getClass()) ;

        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            String fieldName = propertyDescriptor.getName() ;
            if (fieldName.endsWith("MoneyShow")) {
                handMoney(propertyDescriptor, fieldName, result) ;
            }

            if (fieldName.endsWith("TaxRateShow")) {
                handTaxRate(propertyDescriptor, fieldName, result) ;
            }
        }

    }

    private static void handTaxRate(PropertyDescriptor propertyDescriptor, String fieldName, Object result) {

        String taxRate_show = readFieldValue(propertyDescriptor, fieldName, result) ;
        if (!ToolsUnits.isNOtNulll(taxRate_show)) return ;
        Long money = buildMoneyFactory.switchRateToLongPercent(Double.parseDouble(taxRate_show)) ;

        String money_field = fieldName.substring(0, fieldName.length() - 11) ;

        writeFieldValue(result, money_field, money) ;
    }

    private static void handMoney(PropertyDescriptor propertyDescriptor, String fieldName, Object result) {

        String money_show = readFieldValue(propertyDescriptor, fieldName, result) ;

        if (!ToolsUnits.isNOtNulll(money_show)) return ;

        Long money = buildMoneyFactory.switchMoneyToLongPrecision(Double.parseDouble(money_show)) ;

        String money_field = fieldName.substring(0, fieldName.length() - 9) ;

        writeFieldValue(result, money_field, money) ;

    }

    private static <V> V readFieldValue(PropertyDescriptor propertyDescriptor, String fieldName, Object result) {
        try {
            PropertyDescriptor propertyRead = propertyDescriptor ;
            Method methodRead = propertyRead.getReadMethod() ;
            @SuppressWarnings("unchecked")
            V value = (V) methodRead.invoke(result) ;
            return value ;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            Loggerfactory.error(logger, " handusePosition -> " + e.getMessage()) ;
        }
        return null ;
    }

    private static <V> void writeFieldValue(Object result, String fieldName, V value) {
        try {
            PropertyDescriptor propertyDescriptor_w = PropertyUtils.getPropertyDescriptor(result, fieldName) ;
            Method methodWrite = propertyDescriptor_w.getWriteMethod() ;
            methodWrite.invoke(result, value) ;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException e) {
            Loggerfactory.error(logger, " handusePosition -> " + e.getMessage()) ;
        }
    }

    public static void main(String[] args) {
        StockOrderDetail stockOrderDetail = new StockOrderDetail() ;
        stockOrderDetail.setNoTaxMoneyMoneyShow("23.34") ;
        BuildMoneyUnits.build(stockOrderDetail) ;
        Long xx = stockOrderDetail.getNoTaxMoney() ;
        System.out.println("==>  " + xx) ;
    }

}
