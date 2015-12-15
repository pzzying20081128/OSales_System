package cn.zying.osales.service.storehouse.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StoreProductInfoStock ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StoreProductInfoStockSaveUpdateUnits")
public class StoreProductInfoStockSaveUpdateUnits extends ABCommonsService {

    public StoreProductInfoStock saveUpdate(OptType optType, StoreProductInfoStock optStoreProductInfoStock) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return save(optStoreProductInfoStock) ;

        case update:
            return update(optStoreProductInfoStock) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public StoreProductInfoStock save(StoreProductInfoStock optStoreProductInfoStock) throws SystemOptServiceException {
        return null ;
    }

    public StoreProductInfoStock update(StoreProductInfoStock optStoreProductInfoStock) throws SystemOptServiceException {
        return null ;
    }

}
