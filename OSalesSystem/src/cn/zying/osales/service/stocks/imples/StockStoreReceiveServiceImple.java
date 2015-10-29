package cn.zying.osales.service.stocks.imples ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockStoreReceive ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockStoreReceiveService ;
import cn.zying.osales.service.stocks.units.StockStoreReceiveCheckUnits ;
import cn.zying.osales.service.stocks.units.StockStoreReceiveRemoveUnits ;
import cn.zying.osales.service.stocks.units.StockStoreReceiveSaveUpdateUnits ;
import cn.zying.osales.service.stocks.units.StockStoreReceiveSearchUnits ;
import cn.zying.osales.units.search.bean.StockStoreReceiveSearchBean ;

@Component(IStockStoreReceiveService.name)
public class StockStoreReceiveServiceImple extends ABCommonsService implements IStockStoreReceiveService {

    //@Resource(name="StockStoreReceiveSearchUnits")
    @Autowired
    @Qualifier("StockStoreReceiveSearchUnits")
    private StockStoreReceiveSearchUnits iStockStoreReceiveSearchUnits ;

    //@Resource(name=" StockStoreReceiveSaveUpdateUnits")
    @Autowired
    @Qualifier("StockStoreReceiveSaveUpdateUnits")
    private StockStoreReceiveSaveUpdateUnits iStockStoreReceiveSaveUpdateUnits ;

    @Autowired
    @Qualifier("StockStoreReceiveRemoveUnits")
    private StockStoreReceiveRemoveUnits iStockStoreReceiveRemoveUnits ;

    @Autowired
    @Qualifier("StockStoreReceiveCheckUnits")
    private StockStoreReceiveCheckUnits stockStoreReceiveCheckUnits ;

    @Override
    public StockStoreReceive saveUpdate(OptType optType, StockStoreReceive optStockStoreReceive) throws SystemOptServiceException {
        return iStockStoreReceiveSaveUpdateUnits.saveUpdate(optType, optStockStoreReceive) ;
    }

    @Override
    public SelectPage<StockStoreReceive> search(OptType optType, StockStoreReceiveSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iStockStoreReceiveSearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public List<StockStoreReceive> searchList(OptType optType, StockStoreReceiveSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockStoreReceiveSearchUnits.list(optType, searchBean, commSearchBean, startLimit) ;

    }

    @Override
    public StockStoreReceive remove(OptType optType, StockStoreReceive optStockStoreReceive) throws SystemOptServiceException {
        return iStockStoreReceiveRemoveUnits.remove(optType, optStockStoreReceive) ;
    }

    @Override
    public StockStoreReceive get(Integer id) throws SystemOptServiceException {

        return baseService.get(id, StockStoreReceive.class) ;
    }

    @Override
    public void check(Integer id, Integer optUserId) throws SystemOptServiceException {
        stockStoreReceiveCheckUnits.check(id, optUserId) ;
    }

}
