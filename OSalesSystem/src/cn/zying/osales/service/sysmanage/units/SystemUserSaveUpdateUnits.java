package cn.zying.osales.service.sysmanage.units ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.sysmanage.ISystemUserService ;

@Component("SystemUserSaveUpdateUnits")
public class SystemUserSaveUpdateUnits extends ABCommonsService {

    @Autowired
    @Qualifier("SystemUserSearchUnits")
    private SystemUserSearchUnits systemUserSearchUnits ;

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
        if (ToolsUnits.isNOtNulll(optSystemUser.getAccount())) {
            SysStaffUser sysStaffUser = systemUserSearchUnits.searchByAccessName(optSystemUser.getAccount()) ;
            if (sysStaffUser != null) {
                throw new SystemOptServiceException("[" + optSystemUser.getAccount() + "]系统用户重复") ;
            }
        }
//        {
//            SysStaffUser sysStaffUser = systemUserSearchUnits.searchByName(optSystemUser.getName()) ;
//            if (sysStaffUser != null) {
//                throw new SystemOptServiceException("[" + sysStaffUser.getName() + "]重复") ;
//            }
//        }

        baseService.save(optSystemUser) ;
    }

    public void update(SysStaffUser optSystemUser) throws SystemOptServiceException {
        baseService.update(optSystemUser) ;
    }

}
