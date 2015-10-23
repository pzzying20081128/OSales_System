package cn.zying.osales.service.baseinfo.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StoreInfo ;
import cn.zying.osales.pojos.StorePosition ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StorePositionSaveUpdateUnits")
public class StorePositionSaveUpdateUnits extends ABCommonsService {

    public StorePosition saveUpdate(OptType optType, StorePosition optStorePosition) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return save(optStorePosition) ;

        case update:
            return update(optStorePosition) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public StorePosition save(StorePosition optStorePosition) throws SystemOptServiceException {
        Integer storeInfoId = optStorePosition.getStoreInfoId() ;
        StoreInfo storeInfo = baseService.load(storeInfoId, StoreInfo.class) ;
        optStorePosition.setStoreInfo(storeInfo) ;
        baseService.save(optStorePosition) ;
        return optStorePosition ;
    }

    public StorePosition update(StorePosition optStorePosition) throws SystemOptServiceException {
        StorePosition storePosition_ = baseService.get(optStorePosition.getId(), StorePosition.class) ;
        storePosition_.setName(optStorePosition.getName()) ;
        storePosition_.setText(optStorePosition.getText()) ;
        baseService.update(storePosition_) ;
        return storePosition_ ;
    }

}
