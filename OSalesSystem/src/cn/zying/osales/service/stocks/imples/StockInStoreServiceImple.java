package cn.zying.osales.service.stocks.imples ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInStore ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockInStoreService ;
import cn.zying.osales.service.stocks.units.StockInStoreCheckUnits ;
import cn.zying.osales.service.stocks.units.StockInStoreRemoveUnits ;
import cn.zying.osales.service.stocks.units.StockInStoreSaveUpdateUnits ;
import cn.zying.osales.service.stocks.units.StockInStoreSearchUnits ;
import cn.zying.osales.units.search.bean.StockInStoreSearchBean ;

@Component(IStockInStoreService.name)
public class StockInStoreServiceImple extends ABCommonsService implements IStockInStoreService {

    //@Resource(name="StockInStoreSearchUnits")
    @Autowired
    @Qualifier("StockInStoreSearchUnits")
    private StockInStoreSearchUnits iStockInStoreSearchUnits ;

    //@Resource(name=" StockInStoreSaveUpdateUnits")
    @Autowired
    @Qualifier("StockInStoreSaveUpdateUnits")
    private StockInStoreSaveUpdateUnits iStockInStoreSaveUpdateUnits ;

    @Autowired
    @Qualifier("StockInStoreRemoveUnits")
    private StockInStoreRemoveUnits iStockInStoreRemoveUnits ;

    @Autowired
    @Qualifier("StockInStoreCheckUnits")
    private StockInStoreCheckUnits stockInStoreCheckUnits ;

    @Override
    public StockInStore saveUpdate(OptType optType, StockInStore optStockInStore) throws SystemOptServiceException {
        return iStockInStoreSaveUpdateUnits.saveUpdate(optType, optStockInStore) ;
    }

    @Override
    public SelectPage<StockInStore> search(OptType optType, StockInStoreSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iStockInStoreSearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public List<StockInStore> searchList(OptType optType, StockInStoreSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockInStoreSearchUnits.list(optType, searchBean, commSearchBean, startLimit) ;

    }

    @Override
    public StockInStore remove(OptType optType, StockInStore optStockInStore) throws SystemOptServiceException {
        return iStockInStoreRemoveUnits.remove(optType, optStockInStore) ;
    }

    @Override
    public StockInStore get(Integer id) throws SystemOptServiceException {

        return baseService.get(id, StockInStore.class) ;
    }

    @Override
    public void check(Integer id, Integer optUserId) throws SystemOptServiceException {
        stockInStoreCheckUnits.check(id, optUserId) ;

    }

}
