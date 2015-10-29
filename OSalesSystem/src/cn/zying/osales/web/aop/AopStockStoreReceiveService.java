package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockStoreReceive ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockStoreReceiveService ;
import cn.zying.osales.units.search.bean.StockStoreReceiveSearchBean ;

@Component(IAopStockStoreReceiveService.name)
public class AopStockStoreReceiveService implements IAopStockStoreReceiveService {

    @Autowired
    @Qualifier(IStockStoreReceiveService.name)
    private IStockStoreReceiveService iStockStoreReceiveService ;

    public StockStoreReceive saveUpdate(OptType optType, StockStoreReceive optStockStoreReceive) throws SystemOptServiceException {

        return iStockStoreReceiveService.saveUpdate(optType, optStockStoreReceive) ;

    }

    public SelectPage<StockStoreReceive> search(OptType optType, StockStoreReceiveSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockStoreReceiveService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    public List<StockStoreReceive> searchList(OptType optType, StockStoreReceiveSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockStoreReceiveService.searchList(optType, searchBean, commSearchBean, startLimit) ;

    }

    public StockStoreReceive remove(OptType optType, StockStoreReceive optStockStoreReceive) throws SystemOptServiceException {

        return iStockStoreReceiveService.remove(optType, optStockStoreReceive) ;

    }

    public StockStoreReceive get(Integer id) throws SystemOptServiceException {
        return iStockStoreReceiveService.get(id) ;

    }

    @Override
    public void check(Integer id, Integer optUserId) throws SystemOptServiceException {
        iStockStoreReceiveService.check(id, optUserId) ;

    }

}
