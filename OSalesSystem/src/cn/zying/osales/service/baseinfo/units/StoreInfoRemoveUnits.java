package cn.zying.osales.service.baseinfo.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StoreInfo ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StoreInfoRemoveUnits")
public class StoreInfoRemoveUnits extends ABCommonsService {

    public StoreInfo remove(OptType optType, StoreInfo optStoreInfo) throws SystemOptServiceException {

        Integer id = optStoreInfo.getId() ;
        StoreInfo removeStoreInfo = baseService.get(id, StoreInfo.class) ;
        baseService.update(removeStoreInfo) ;
        return removeStoreInfo ;
    }

}
