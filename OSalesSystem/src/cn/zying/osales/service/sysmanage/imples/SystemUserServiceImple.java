package cn.zying.osales.service.sysmanage.imples ;

import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.units.powers.UserOptPower ;
import cn.zy.apps.tools.units.powers.UserPower ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.pojos.SystemUserOptPower ;
import cn.zying.osales.pojos.SystemUserPower ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.sysmanage.ISystemUserService ;
import cn.zying.osales.service.sysmanage.units.SystemUserRemoveUnits ;
import cn.zying.osales.service.sysmanage.units.SystemUserSaveUpdateUnits ;
import cn.zying.osales.service.sysmanage.units.SystemUserSearchBean ;
import cn.zying.osales.service.sysmanage.units.SystemUserSearchUnits ;

@Component(ISystemUserService.name)
public class SystemUserServiceImple extends ABCommonsService implements ISystemUserService {

    //@Resource(name="SystemUserSearchUnits")
    @Autowired
    @Qualifier("SystemUserSearchUnits")
    private SystemUserSearchUnits iSystemUserSearchUnits ;

    //@Resource(name=" SystemUserSaveUpdateUnits")
    @Autowired
    @Qualifier("SystemUserSaveUpdateUnits")
    private SystemUserSaveUpdateUnits iSystemUserSaveUpdateUnits ;

    @Autowired
    @Qualifier("SystemUserRemoveUnits")
    private SystemUserRemoveUnits iSystemUserRemoveUnits ;

    @Override
    public void saveUpdate(OptType optType, SysStaffUser optSystemUser) throws SystemOptServiceException {
        iSystemUserSaveUpdateUnits.saveUpdate(optType, optSystemUser) ;
    }

    @Override
    public SelectPage<SysStaffUser> search(OptType optType, SystemUserSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iSystemUserSearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public void remove(OptType optType, SysStaffUser optSystemUser) throws SystemOptServiceException {
        iSystemUserRemoveUnits.remove(optType, optSystemUser) ;
    }

    @Override
    public SysStaffUser get(Integer id) throws SystemOptServiceException {

        return baseService.get(id, SysStaffUser.class) ;
    }

    @Override
    public SysStaffUser searchByAccessName(String accessName) throws SystemOptServiceException {
        //                String sql ="select  systemUser from  SystemUser as  systemUser  where  systemUser.account =:account  ";
        Map<String, Object> value = ToolsUnits.createSearchMap() ;
        value.put("account", accessName.trim()) ;
        value.put("status", OSalesConfigProperties.Status.正常) ;
        return baseService.findSinglenessByQName(OSalesConfigProperties.query_sysStaffUser_searchByAccessName, value) ;
    }

    @Override
    public List<String> listUserModulePowerBySysUserId(String loginUserId) throws Exception {

        Map<String, Object> values = new HashMap<String, Object>() ;
        values.put("systemUserInfoId", Integer.parseInt(loginUserId)) ;
        List<SystemUserPower> result = baseService.findByQName(OSalesConfigProperties.query_sysStaffUser_searchUserPower_userId, values) ;
        List<String> xx = new ArrayList<String>() ;

        for (SystemUserPower systemUserPower : result) {
            xx.add(systemUserPower.getModuleId()) ;
        }
        return xx ;
    }

    @Override
    public List<UserPower<UserOptPower>> searchUserPower(String moduleId, String loginUserId) throws Exception {
        Map<String, Object> values = new HashMap<String, Object>() ;
        values.put("systemUserInfoId", Integer.parseInt(loginUserId)) ;
        values.put("moduleId", moduleId) ;
        List<SystemUserPower> results = baseService.findByQName(OSalesConfigProperties.query_sysStaffUser_searchUserPower_userId_moduleId, values) ;

        List<UserPower<UserOptPower>> userPowers = new ArrayList<UserPower<UserOptPower>>() ;

        for (SystemUserPower systemUserPower : results) {

            UserPower<UserOptPower> userPower = new UserPower<UserOptPower>() ;
            userPowers.add(userPower) ;
            ToolsUnits.copyBeanProperties(userPower, systemUserPower, "moduleId", "moduleName") ;

            List<UserOptPower> userOptPowers = new ArrayList<UserOptPower>() ;

            userPower.setUserOptPowers(userOptPowers) ;

            for (SystemUserOptPower systemUserOptPower : systemUserPower.getUserOptPowers()) {

                UserOptPower userOptPower = new UserOptPower() ;

                userOptPowers.add(userOptPower) ;

                ToolsUnits.copyBeanProperties(userOptPower, systemUserOptPower, "powerName", "powerCode", "isUse") ;

            }
        }

        return userPowers ;
    }

}
