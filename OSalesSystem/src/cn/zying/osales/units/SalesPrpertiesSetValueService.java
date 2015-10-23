package cn.zying.osales.units ;

import cn.zy.apps.tools.units.PrpertiesSetValueService ;
import cn.zy.apps.tools.units.moneys.BuildMoneyFactory ;
import cn.zy.apps.tools.units.moneys.IBuildMoneyFactory ;

public class SalesPrpertiesSetValueService extends PrpertiesSetValueService {

    private static IBuildMoneyFactory buildMoneyFactory = new BuildMoneyFactory() ;

    public static String regexPackage = "^cn.zying.osales(\\.\\D+)*(.pojos|.bean)$" ;

    public SalesPrpertiesSetValueService() {
        super(regexPackage) ;
    }

    @Override
    protected void handField(String fieldName, Object result) {
        //         System.out.println("-->  -------------------------------------------------- handField  "+fieldName) ;
        if (fieldName.endsWith("MoneyShow")) {
            handMoney(fieldName, result) ;
        }

        if (fieldName.endsWith("TaxRateShow")) {
            handTaxRate(fieldName, result) ;
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

    public static void main(String[] args) {

        String regexPackage = "^zy.apps.demo(\\.\\D+)*(.pojos|.views|.beans)$" ;

        //		PrpertiesSetValueService  prpertiesSetValueService  =new DemoPrpertiesSetValueService(regexPackage);
        //		Order  order=new Order();
        //		order.setMoney(1200L);
        //		List<Order>   orders=new ArrayList<Order>();
        //		order.setOrders(orders);
        //		{
        //			Order  order1=new Order();
        //			order1.setMoney(200L);
        //			orders.add(order1);
        //		}
        //		
        //		{
        //			Order  order2=new Order();
        //			order2.setMoney(100L);
        //			orders.add(order2);
        //		}
        //		
        //		try {
        //			prpertiesSetValueService.execactionaftereturn(order);
        //			String xx =order.getMoneyMoneyShow();
        //			System.out.println("==> "+xx);
        //			for(Order  order_:order.getOrders() ){
        //				String xx1 =order_.getMoneyMoneyShow();
        //				System.out.println("==> "+xx1);
        //			}
        //		} catch (Exception e) {
        //			// TODO Auto-generated catch block
        //			e.printStackTrace();
        //		}

    }

}
