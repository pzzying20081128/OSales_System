package cn.zying.osales.service.baseinfo.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SystemConfigs ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("SystemConfigsSaveUpdateUnits")
public class SystemConfigsSaveUpdateUnits extends ABCommonsService {

    public SystemConfigs saveUpdate(OptType optType, SystemConfigs optSystemConfigs) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return save(optSystemConfigs) ;

        case update:
            return update(optSystemConfigs) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public SystemConfigs save(SystemConfigs optSystemConfigs) throws SystemOptServiceException {
        return optSystemConfigs ;
    }

    public SystemConfigs update(SystemConfigs optSystemConfigs) throws SystemOptServiceException {
        return optSystemConfigs ;
    }

}
