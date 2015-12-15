package cn.zying.osales.service.storehouse.imples ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StoreProductInfoDetail ;
import cn.zying.osales.pojos.StoreProductInfoStock ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.storehouse.IStoreProductInfoStockService ;
import cn.zying.osales.service.storehouse.units.StoreProductInfoStockRemoveUnits ;
import cn.zying.osales.service.storehouse.units.StoreProductInfoStockSaveUpdateUnits ;
import cn.zying.osales.service.storehouse.units.StoreProductInfoStockSearchUnits ;
import cn.zying.osales.units.search.bean.StoreProductInfoStockSearchBean ;

@Component(IStoreProductInfoStockService.name)
public class StoreProductInfoStockServiceImple extends ABCommonsService implements IStoreProductInfoStockService {

    //@Resource(name="StoreProductInfoStockSearchUnits")
    @Autowired
    @Qualifier("StoreProductInfoStockSearchUnits")
    private StoreProductInfoStockSearchUnits iStoreProductInfoStockSearchUnits ;

    //@Resource(name=" StoreProductInfoStockSaveUpdateUnits")
    @Autowired
    @Qualifier("StoreProductInfoStockSaveUpdateUnits")
    private StoreProductInfoStockSaveUpdateUnits iStoreProductInfoStockSaveUpdateUnits ;

    @Autowired
    @Qualifier("StoreProductInfoStockRemoveUnits")
    private StoreProductInfoStockRemoveUnits iStoreProductInfoStockRemoveUnits ;

    @Override
    public StoreProductInfoStock saveUpdate(OptType optType, StoreProductInfoStock optStoreProductInfoStock) throws SystemOptServiceException {
        return iStoreProductInfoStockSaveUpdateUnits.saveUpdate(optType, optStoreProductInfoStock) ;
    }

    @Override
    public SelectPage<StoreProductInfoStock> search(OptType optType, StoreProductInfoStockSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iStoreProductInfoStockSearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public List<StoreProductInfoStock> searchList(OptType optType, StoreProductInfoStockSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStoreProductInfoStockSearchUnits.list(optType, searchBean, commSearchBean, startLimit) ;

    }

    @Override
    public StoreProductInfoStock remove(OptType optType, StoreProductInfoStock optStoreProductInfoStock) throws SystemOptServiceException {
        return iStoreProductInfoStockRemoveUnits.remove(optType, optStoreProductInfoStock) ;
    }

    @Override
    public StoreProductInfoStock get(Integer id) throws SystemOptServiceException {

        return baseService.get(id, StoreProductInfoStock.class) ;
    }

    @Override
    public SelectPage<StoreProductInfoDetail> searchDetail(Integer storeProductInfoStockId) throws SystemOptServiceException {

        SelectPage<StoreProductInfoDetail> selectPage = new SelectPage<StoreProductInfoDetail>() ;

        String sql = "select storeProductInfoDetail   from  StoreProductInfoDetail as storeProductInfoDetail  " +

        "  where  storeProductInfoDetail.storeProductInfoStockId = " + storeProductInfoStockId ;
        List<StoreProductInfoDetail> result = baseService.findByHSQL(sql) ;

        selectPage.setResult(result) ;
        selectPage.setCount((long) result.size()) ;

        return selectPage ;
    }

}
