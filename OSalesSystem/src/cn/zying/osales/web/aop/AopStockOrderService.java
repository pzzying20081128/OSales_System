package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockOrder ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockOrderService ;
import cn.zying.osales.units.search.bean.StockOrderSearchBean ;

@Component(IAopStockOrderService.name)
public class AopStockOrderService implements IAopStockOrderService {

    @Autowired
    @Qualifier(IStockOrderService.name)
    private IStockOrderService iStockOrderService ;

    public StockOrder saveUpdate(OptType optType, StockOrder optStockOrder) throws SystemOptServiceException {

        return iStockOrderService.saveUpdate(optType, optStockOrder) ;

    }

    public SelectPage<StockOrder> search(OptType optType, StockOrderSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockOrderService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    public List<StockOrder> searchList(OptType optType, StockOrderSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockOrderService.searchList(optType, searchBean, commSearchBean, startLimit) ;

    }

    public StockOrder remove(OptType optType, StockOrder optStockOrder) throws SystemOptServiceException {

        return iStockOrderService.remove(optType, optStockOrder) ;

    }

    public StockOrder get(Integer id) throws SystemOptServiceException {
        return iStockOrderService.get(id) ;

    }

    @Override
    public StockOrder saveUpdate(OptType optType, StockOrder optStockOrder, int optUserId) throws SystemOptServiceException {
        return this.saveUpdate(optType, optStockOrder) ;

    }

}
