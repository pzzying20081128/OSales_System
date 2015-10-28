package cn.zying.osales.service.baseinfo.units ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.SQLUilts ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.pojos.SystemUserOptPower ;
import cn.zying.osales.pojos.SystemUserPower ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

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
//        optSystemUser.setId(SQLUilts.getIUniqueId()) ;
        optSystemUser.setStatus(Status.有效) ;
        optSystemUser.setIsAdmin(OSalesConfigProperties.isDefault_0);
        List<SystemUserPower> userPowers = optSystemUser.getSystemUserPowers() ;
        userPowers = setId(userPowers, optSystemUser) ;
        optSystemUser.setSystemUserPowers(userPowers) ;
        baseService.save(optSystemUser) ;

    }

    private List<SystemUserPower> setId(List<SystemUserPower> systemUserPowers, SysStaffUser optSystemUser) {
        if(systemUserPowers ==null) return systemUserPowers;
        for (SystemUserPower systemUserPower : systemUserPowers) {
            systemUserPower.setIds(SQLUilts.getIUniqueId()) ;
            systemUserPower.setSysStaffUser(optSystemUser) ;
            List<SystemUserOptPower> systemUserOptPowers = systemUserPower.getUserOptPowers() ;
            for (SystemUserOptPower systemUserOptPower : systemUserOptPowers) {
                systemUserOptPower.setIds(SQLUilts.getIUniqueId()) ;
            }
        }
        return systemUserPowers ;
    }

    private void removePower(SysStaffUser optSystemUser) {

        for (SystemUserPower systemUserPower : optSystemUser.getSystemUserPowers()) {
            baseService.remove(systemUserPower) ;
        }

    }

    public void update(SysStaffUser optSystemUser) throws SystemOptServiceException {
        SysStaffUser optSystemUser_ = baseService.load(optSystemUser.getId(), SysStaffUser.class) ;
        optSystemUser.setStatus(optSystemUser_.getStatus()) ;
        optSystemUser.setIsAdmin(optSystemUser_.getIsAdmin());
        if(ToolsUnits.isNOtNulll(optSystemUser.getPwd()))
        optSystemUser.setPwd(optSystemUser.getPwd());
        else{
            optSystemUser.setPwd(optSystemUser_.getPwd());
        }
        if (optSystemUser.getSystemUserPowers().size() != 0) {
            removePower(optSystemUser_) ;
            List<SystemUserPower> userPowers = optSystemUser.getSystemUserPowers() ;
            userPowers = setId(userPowers, optSystemUser) ;
            optSystemUser.setSystemUserPowers(userPowers) ;
        } else {
            optSystemUser.setSystemUserPowers(optSystemUser_.getSystemUserPowers()) ;
        }

        baseService.update(optSystemUser) ;
    }

}
