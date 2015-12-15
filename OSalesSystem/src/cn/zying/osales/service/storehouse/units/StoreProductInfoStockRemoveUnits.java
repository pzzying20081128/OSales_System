package cn.zying.osales.service.storehouse.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StoreProductInfoStock ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StoreProductInfoStockRemoveUnits")
public class StoreProductInfoStockRemoveUnits extends ABCommonsService {

    public StoreProductInfoStock remove(OptType optType, StoreProductInfoStock optStoreProductInfoStock) throws SystemOptServiceException {

        Integer id = optStoreProductInfoStock.getId() ;
        StoreProductInfoStock removeStoreProductInfoStock = baseService.get(id, StoreProductInfoStock.class) ;
        baseService.update(removeStoreProductInfoStock) ;
        return removeStoreProductInfoStock ;
    }

}
