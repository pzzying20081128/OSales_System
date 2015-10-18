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
import cn.zying.osales.pojos.SystemUserPower ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.baseinfo.ISystemUserService ;
import cn.zying.osales.units.search.bean.SystemUserSearchBean ;

@Component(IAopSystemUserService.aop_name)
public class AopSystemUserService implements IAopSystemUserService {

    @Autowired
    @Qualifier(ISystemUserService.name)
    private ISystemUserService systemUserService ;

    @Override
    public void saveUpdate(OptType optType, SysStaffUser optSystemUser, Integer optUserId) throws SystemOptServiceException {
        systemUserService.saveUpdate(optType, optSystemUser, optUserId) ;

    }

    @Override
    public SelectPage<SysStaffUser> search(OptType optType, SystemUserSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return systemUserService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    @Override
    public void remove(OptType optType, SysStaffUser optSystemUser, Integer optUserId) throws SystemOptServiceException {
        systemUserService.remove(optType, optSystemUser, optUserId) ;

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
    public List<String> listUserModulePowerBySysUserId(Integer loginUserId) throws Exception {

        return systemUserService.listUserModulePowerBySysUserId(loginUserId) ;
    }

    @Override
    public List<SystemUserPower> listUserModulePowerByUserId(Integer loginUserId) throws Exception {

        return systemUserService.listUserModulePowerByUserId(loginUserId) ;
    }

    @Override
    public List<UserPower<UserOptPower>> searchUserPower(String moduleId, Integer loginUserId) throws Exception {

        return systemUserService.searchUserPower(moduleId, loginUserId) ;
    }

    @Override
    public List<SysStaffUser> searchList(OptType optType, SystemUserSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return systemUserService.searchList(optType, searchBean, commSearchBean, startLimit) ;
    }

}
