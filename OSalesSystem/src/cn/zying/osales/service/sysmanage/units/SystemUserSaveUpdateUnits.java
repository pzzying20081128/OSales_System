package cn.zying.osales.service.sysmanage.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("SystemUserSaveUpdateUnits")
public class SystemUserSaveUpdateUnits extends ABCommonsService {

    public void saveUpdate(OptType optType, SysStaffUser optSystemUser) throws SystemOptServiceException {

        switch (optType) {
        case save:
            save(optSystemUser) ;
            break ;
        case update:
            update(optSystemUser) ;
            break ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public void save(SysStaffUser optSystemUser) throws SystemOptServiceException {
        baseService.save(optSystemUser) ;
    }

    public void update(SysStaffUser optSystemUser) throws SystemOptServiceException {
        baseService.update(optSystemUser) ;
    }

}
