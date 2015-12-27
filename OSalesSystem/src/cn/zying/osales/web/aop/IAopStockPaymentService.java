package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.infaces.InfaceStockPaymentService ;
import cn.zying.osales.pojos.StockPayment ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockPaymentService ;
import cn.zying.osales.units.search.bean.StockPaymentSearchBean ;

public interface IAopStockPaymentService extends InfaceStockPaymentService {

    public String name = "IAopStockPaymentService" ;

   
}
