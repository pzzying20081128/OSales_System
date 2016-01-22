package cn.zying.osales.service.baseinfo.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SystemConfigs ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("SystemConfigsRemoveUnits")
public class SystemConfigsRemoveUnits extends ABCommonsService {

    public SystemConfigs remove(OptType optType, SystemConfigs optSystemConfigs) throws SystemOptServiceException {

        Integer id = optSystemConfigs.getId() ;
        SystemConfigs removeSystemConfigs = baseService.get(id, SystemConfigs.class) ;
        baseService.update(removeSystemConfigs) ;
        return removeSystemConfigs ;
    }

}
