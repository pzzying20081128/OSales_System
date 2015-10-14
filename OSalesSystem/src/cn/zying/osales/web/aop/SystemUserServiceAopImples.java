package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.powers.UserOptPower ;
import cn.zy.apps.tools.units.powers.UserPower ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.sysmanage.ISystemUserService ;
import cn.zying.osales.service.sysmanage.units.SystemUserSearchBean ;

@Component(ISystemUserService.aop_name)
public class SystemUserServiceAopImples implements ISystemUserService {

    @Autowired
    @Qualifier(ISystemUserService.name)
    private ISystemUserService systemUserService ;

    @Override
    public void saveUpdate(OptType optType, SysStaffUser optSystemUser) throws SystemOptServiceException {
        systemUserService.saveUpdate(optType, optSystemUser) ;

    }

    @Override
    public SelectPage<SysStaffUser> search(OptType optType, SystemUserSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return systemUserService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    @Override
    public void remove(OptType optType, SysStaffUser optSystemUser) throws SystemOptServiceException {
        systemUserService.remove(optType, optSystemUser) ;

    }

    @Override
    public SysStaffUser get(Integer id) throws SystemOptServiceException {
        return systemUserService.get(id) ;
    }

    @Override
    public SysStaffUser searchByAccessName(String accessName) throws SystemOptServiceException {

        return systemUserService.searchByAccessName(accessName) ;
    }

    @Override
    public List<String> listUserModulePowerBySysUserId(String loginUserId) throws Exception {
        // TODO Auto-generated method stub
        return systemUserService.listUserModulePowerBySysUserId(loginUserId) ;
    }

    @Override
    public List<UserPower<UserOptPower>> searchUserPower(String moduleId, String loginUserId) throws Exception {
        // TODO Auto-generated method stub
        return systemUserService.searchUserPower(moduleId, loginUserId) ;
    }

}
