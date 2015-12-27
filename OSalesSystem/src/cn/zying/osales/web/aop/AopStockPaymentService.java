package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockPayment ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockPaymentService ;
import cn.zying.osales.units.search.bean.StockPaymentSearchBean ;

@Component(IAopStockPaymentService.name)
public class AopStockPaymentService implements IAopStockPaymentService {

    @Autowired
    @Qualifier(IStockPaymentService.name)
    private IStockPaymentService iStockPaymentService ;

    public StockPayment saveUpdate(OptType optType, StockPayment optStockPayment) throws SystemOptServiceException {

        return iStockPaymentService.saveUpdate(optType, optStockPayment) ;

    }

    public SelectPage<StockPayment> search(OptType optType, StockPaymentSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockPaymentService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    public List<StockPayment> searchList(OptType optType, StockPaymentSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockPaymentService.searchList(optType, searchBean, commSearchBean, startLimit) ;

    }

    public StockPayment remove(OptType optType, StockPayment optStockPayment) throws SystemOptServiceException {

        return iStockPaymentService.remove(optType, optStockPayment) ;

    }

    public StockPayment get(Integer id) throws SystemOptServiceException {
        return iStockPaymentService.get(id) ;

    }

    public void check(StockPayment stockpayment) throws SystemOptServiceException {
        iStockPaymentService.check(stockpayment) ;
    }

}
