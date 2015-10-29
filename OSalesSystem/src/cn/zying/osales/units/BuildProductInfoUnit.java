package cn.zying.osales.units ;

import java.beans.IntrospectionException ;
import java.beans.PropertyDescriptor ;
import java.lang.reflect.InvocationTargetException ;
import java.lang.reflect.Method ;

import org.apache.log4j.Logger ;

import cn.zy.apps.tools.logger.Loggerfactory ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.units.moneys.BuildMoneyFactory ;
import cn.zy.apps.tools.units.moneys.IBuildMoneyFactory ;
import cn.zying.osales.pojos.ProductInfo ;

public class BuildProductInfoUnit {

    public static String createBoxCount(Integer count, ProductInfo productInfo) {
        if (count == null || productInfo == null) return null ;
        Integer x = productInfo.getBoxCount() ;
        if (x == null) x = 1 ;
        String xx = count / x + productInfo.getBoxUnit() + (count % x != 0 ? count % x + productInfo.getBaseUnit() : "") ;
        return xx.trim() ;
    }

    private static IBuildMoneyFactory buildMoneyFactory = BuildMoneyFactory.getBuildMoney() ;

    private static Logger logger = Loggerfactory.instance(BuildProductInfoUnit.class) ;

    private static String[] moneyfields = new String[] { "maxStockPriceMoneyShow", "stockTaxRateTaxRateShow",

    "salesTaxPriceMoneyShow", "grossProfitRateTaxRateShow", "salesNoTaxPriceMoneyShow", "salesTaxRateTaxRateShow" } ;

    /**
     * 计算毛利率
     * @param productInfo
     */
    private static void buildGrossProfitRate(ProductInfo productInfo) {

        //        Long maxStockPrice = productInfo.getMaxStockPrice() ;
        //
        //        Long salesTaxPrice = productInfo.getSalesTaxPrice() ;
        //
        //        Long result = buildMoneyFactory.computeRate(salesTaxPrice, (salesTaxPrice - maxStockPrice)) ;
        //
        //        productInfo.setGrossProfitRate(result) ;

        Long salesBoxNoTaxPrice = productInfo.getSalesNoTaxPrice() * productInfo.getBoxCount() ;
        productInfo.setSalesBoxNoTaxPrice(salesBoxNoTaxPrice) ;

        Long salesBoxTaxPrice = productInfo.getSalesTaxPrice() * productInfo.getBoxCount() ;
        productInfo.setSalesBoxTaxPrice(salesBoxTaxPrice) ;
    }

    public static void buildToLong(ProductInfo productInfo) {

        for (String moneyfield : moneyfields) {
            try {

                if (moneyfield.endsWith("MoneyShow")) {
                    PropertyDescriptor moneyShow = new PropertyDescriptor(moneyfield, ProductInfo.class) ;

                    Method read = moneyShow.getReadMethod() ;

                    String moneyString = (String) read.invoke(productInfo) ;

                    if (!ToolsUnits.isNOtNulll(moneyString)) continue ;

                    Double money = Double.parseDouble(moneyString) ;

                    /////////////////////////////////////////////////////////////////////////////////////////////////

                    Long moneyLong_ = buildMoneyFactory.switchMoneyToLongPrecision(money) ;

                    String moneyfield_ = moneyfield.substring(0, moneyfield.length() - 9) ;

                    PropertyDescriptor moneyLong = new PropertyDescriptor(moneyfield_, ProductInfo.class) ;

                    moneyLong.getWriteMethod().invoke(productInfo, moneyLong_) ;
                }

                if (moneyfield.endsWith("TaxRateShow")) {

                    PropertyDescriptor moneyShow = new PropertyDescriptor(moneyfield, ProductInfo.class) ;

                    Method read = moneyShow.getReadMethod() ;

                    String moneyString = (String) read.invoke(productInfo) ;

                    if (!ToolsUnits.isNOtNulll(moneyString)) continue ;

                    Double taxRateShow = Double.parseDouble(moneyString) ;

                    /////////////////////////////////////////////////////////////////////////////////////////////////

                    Long moneyLong_ = buildMoneyFactory.switchRateToLongPercent(taxRateShow) ;

                    String moneyfield_ = moneyfield.substring(0, moneyfield.length() - 11) ;

                    PropertyDescriptor moneyLong = new PropertyDescriptor(moneyfield_, ProductInfo.class) ;

                    moneyLong.getWriteMethod().invoke(productInfo, moneyLong_) ;

                }

                ////////////////////////////////////////////////////////////////////////////////////////////////
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException e) {
                e.printStackTrace() ;
                Loggerfactory.error(logger, e) ;
            }

        }
        buildGrossProfitRate(productInfo) ;

    }

    public static void main(String[] args) {
        ProductInfo productInfo = new ProductInfo() ;

        productInfo.setMaxStockPriceMoneyShow("12") ;

        productInfo.setSalesTaxPriceMoneyShow("24") ;

        productInfo.setSalesTaxRateTaxRateShow("5.00") ;

        BuildProductInfoUnit.buildToLong(productInfo) ;

        System.out.println("-->  " + productInfo.getMaxStockPrice() + "   ->  " + productInfo.getSalesTaxPrice() + "    " + productInfo.getGrossProfitRate()) ;
        System.out.println("-->  " + productInfo.getSalesNoTaxPrice()) ;
        //        
        //        productInfo.setGrossProfitRateTaxRateShow("23.00");
        //
        //        BuildProductInfoUnit.buildToLong(productInfo) ;
        //
        //        System.out.println("============>   " + productInfo.getMaxStockPrice()+"   -->   "+productInfo.getGrossProfitRate()) ;

    }

}
