package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInStore ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockInStoreService ;
import cn.zying.osales.units.search.bean.StockInStoreSearchBean ;

@Component(IAopStockInStoreService.name)
public class AopStockInStoreService implements IAopStockInStoreService {

    @Autowired
    @Qualifier(IStockInStoreService.name)
    private IStockInStoreService iStockInStoreService ;

    public StockInStore saveUpdate(OptType optType, StockInStore optStockInStore) throws SystemOptServiceException {

        return iStockInStoreService.saveUpdate(optType, optStockInStore) ;

    }

    public SelectPage<StockInStore> search(OptType optType, StockInStoreSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockInStoreService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    public List<StockInStore> searchList(OptType optType, StockInStoreSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockInStoreService.searchList(optType, searchBean, commSearchBean, startLimit) ;

    }

    public StockInStore remove(OptType optType, StockInStore optStockInStore) throws SystemOptServiceException {

        return iStockInStoreService.remove(optType, optStockInStore) ;

    }

    public StockInStore get(Integer id) throws SystemOptServiceException {
        return iStockInStoreService.get(id) ;

    }

}
