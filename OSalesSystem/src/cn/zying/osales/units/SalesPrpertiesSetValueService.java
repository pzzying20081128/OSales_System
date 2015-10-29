package cn.zying.osales.units ;

import java.beans.PropertyDescriptor ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.logger.Loggerfactory ;
import cn.zy.apps.tools.units.PrpertiesSetValueService ;
import cn.zy.apps.tools.units.moneys.BuildMoneyFactory ;
import cn.zy.apps.tools.units.moneys.IBuildMoneyFactory ;
import cn.zying.osales.pojos.ProductInfo ;

@Component("SalesPrpertiesSetValueService")
public class SalesPrpertiesSetValueService extends PrpertiesSetValueService {

    private static IBuildMoneyFactory buildMoneyFactory = BuildMoneyFactory.getBuildMoney() ;

    public static String regexPackage = "^cn.zying.osales(\\.\\D+)*(.pojos|.bean)$" ;

    public SalesPrpertiesSetValueService() {
        super(regexPackage) ;
    }

    @Override
    protected void handField(String fieldName, Object result) {

        if (fieldName.endsWith("MoneyShow")) {
            handMoney(fieldName, result) ;
        }

        if (fieldName.endsWith("TaxRateShow")) {
            handTaxRate(fieldName, result) ;
        }

        //orderCount BoxShow
        if (fieldName.endsWith("BoxShow")) {
            handBoxShow(fieldName, result) ;
        }
    }

    private void handBoxShow(String fieldName, Object result) {
        try {
            PropertyDescriptor[] propertyDescriptors = searchAll(result.getClass()) ;
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                if (!propertyDescriptor.getPropertyType().equals(ProductInfo.class)) continue ;

                String fieldProductInfo = propertyDescriptor.getDisplayName() ;

                ProductInfo productInfo = readFieldValue(fieldProductInfo, result) ;

                String orderCountFieldName = fieldName.substring(0, fieldName.length() - 7) ;
                Integer orderCount = readFieldValue(orderCountFieldName, result) ;
                String boxCount = BuildProductInfoUnit.createBoxCount(orderCount, productInfo) ;
                writeFieldValue(fieldName, result, boxCount) ;

            }
        } catch (IllegalArgumentException e) {
            Loggerfactory.error(logger, " handusePosition -> " + e.getMessage()) ;
        }

    }

    private void handTaxRate(String fieldName, Object result) {
        String money_field = fieldName.substring(0, fieldName.length() - 11) ;

        Long rate = readFieldValue(money_field, result) ;
        if (rate != null) {

            String rate_show = buildMoneyFactory.switchLongPercentToRate(rate.longValue(), String.class) ;

            writeFieldValue(fieldName, result, rate_show) ;
        }

    }

    private void handMoney(String fieldName, Object result) {

        String money_field = fieldName.substring(0, fieldName.length() - 9) ;

        Long money = readFieldValue(money_field, result) ;

        String money_show = buildMoneyFactory.switchLongPrecisionToMoney(money, String.class) ;

        writeFieldValue(fieldName, result, money_show) ;

    }

}
