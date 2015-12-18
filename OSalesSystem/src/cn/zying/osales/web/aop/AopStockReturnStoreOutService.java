package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockReturnStoreOut ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockReturnStoreOutService ;
import cn.zying.osales.units.search.bean.StockReturnStoreOutSearchBean ;

@Component(IAopStockReturnStoreOutService.name)
public class AopStockReturnStoreOutService implements IAopStockReturnStoreOutService {

    @Autowired
    @Qualifier(IStockReturnStoreOutService.name)
    private IStockReturnStoreOutService iStockReturnStoreOutService ;

    public StockReturnStoreOut saveUpdate(OptType optType, StockReturnStoreOut optStockReturnStoreOut) throws SystemOptServiceException {

        return iStockReturnStoreOutService.saveUpdate(optType, optStockReturnStoreOut) ;

    }

    public SelectPage<StockReturnStoreOut> search(OptType optType, StockReturnStoreOutSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockReturnStoreOutService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    public List<StockReturnStoreOut> searchList(OptType optType, StockReturnStoreOutSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockReturnStoreOutService.searchList(optType, searchBean, commSearchBean, startLimit) ;

    }

    public StockReturnStoreOut remove(OptType optType, StockReturnStoreOut optStockReturnStoreOut) throws SystemOptServiceException {

        return iStockReturnStoreOutService.remove(optType, optStockReturnStoreOut) ;

    }

    public StockReturnStoreOut get(Integer id) throws SystemOptServiceException {
        return iStockReturnStoreOutService.get(id) ;

    }

    @Override
    public void check(Integer id, Integer oSalsesLoginUserId) throws SystemOptServiceException {
        iStockReturnStoreOutService.check(id, oSalsesLoginUserId) ;

    }

}
