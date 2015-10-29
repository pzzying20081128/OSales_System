package cn.zying.osales.service.baseinfo.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.StorePosition ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StorePositionRemoveUnits")
public class StorePositionRemoveUnits extends ABCommonsService {

    public StorePosition remove(OptType optType, StorePosition optStorePosition) throws SystemOptServiceException {

        Integer id = optStorePosition.getId() ;
        StorePosition removeStorePosition = baseService.get(id, StorePosition.class) ;
        removeStorePosition.setStatus(Status.删除) ;
        baseService.update(removeStorePosition) ;
        return removeStorePosition ;
    }

}
