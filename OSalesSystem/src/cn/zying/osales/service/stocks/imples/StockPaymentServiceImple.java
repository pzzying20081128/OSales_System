package cn.zying.osales.service.stocks.imples ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockPayment ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockPaymentService ;
import cn.zying.osales.service.stocks.units.StockPaymentCheckUnits ;
import cn.zying.osales.service.stocks.units.StockPaymentRemoveUnits ;
import cn.zying.osales.service.stocks.units.StockPaymentSaveUpdateUnits ;
import cn.zying.osales.service.stocks.units.StockPaymentSearchUnits ;
import cn.zying.osales.units.search.bean.StockPaymentSearchBean ;

@Component(IStockPaymentService.name)
public class StockPaymentServiceImple extends ABCommonsService implements IStockPaymentService {

    //@Resource(name="StockPaymentSearchUnits")
    @Autowired
    @Qualifier("StockPaymentSearchUnits")
    private StockPaymentSearchUnits iStockPaymentSearchUnits ;

    //@Resource(name=" StockPaymentSaveUpdateUnits")
    @Autowired
    @Qualifier("StockPaymentSaveUpdateUnits")
    private StockPaymentSaveUpdateUnits iStockPaymentSaveUpdateUnits ;

    @Autowired
    @Qualifier("StockPaymentRemoveUnits")
    private StockPaymentRemoveUnits iStockPaymentRemoveUnits ;
    
    @Autowired
    @Qualifier("StockPaymentCheckUnits")
    private StockPaymentCheckUnits iStockPaymentCheckUnits ;

    @Override
    public StockPayment saveUpdate(OptType optType, StockPayment optStockPayment) throws SystemOptServiceException {
        return iStockPaymentSaveUpdateUnits.saveUpdate(optType, optStockPayment) ;
    }

    @Override
    public SelectPage<StockPayment> search(OptType optType, StockPaymentSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iStockPaymentSearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public List<StockPayment> searchList(OptType optType, StockPaymentSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockPaymentSearchUnits.list(optType, searchBean, commSearchBean, startLimit) ;

    }

    @Override
    public StockPayment remove(OptType optType, StockPayment optStockPayment) throws SystemOptServiceException {
        return iStockPaymentRemoveUnits.remove(optType, optStockPayment) ;
    }

    @Override
    public StockPayment get(Integer id) throws SystemOptServiceException {

        return baseService.get(id, StockPayment.class) ;
    }

    @Override
    public void check(StockPayment stockpayment) throws SystemOptServiceException {
        iStockPaymentCheckUnits.check(stockpayment);
        
    }

}
