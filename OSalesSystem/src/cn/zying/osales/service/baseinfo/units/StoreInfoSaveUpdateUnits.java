package cn.zying.osales.service.baseinfo.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StoreInfo ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StoreInfoSaveUpdateUnits")
public class StoreInfoSaveUpdateUnits extends ABCommonsService {

    public StoreInfo saveUpdate(OptType optType, StoreInfo optStoreInfo) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return save(optStoreInfo) ;

        case update:
            return update(optStoreInfo) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public StoreInfo save(StoreInfo optStoreInfo) throws SystemOptServiceException {
        baseService.save(optStoreInfo) ;
        return optStoreInfo ;

    }

    public StoreInfo update(StoreInfo optStoreInfo) throws SystemOptServiceException {
        baseService.update(optStoreInfo) ;
        return optStoreInfo ;
    }

}
