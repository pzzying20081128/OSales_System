package cn.zying.osales.service.baseinfo ;

import java.util.List ;

import cn.zy.apps.tools.history.AnnRegisterHistory ;
import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.powers.UserOptPower ;
import cn.zy.apps.tools.units.powers.UserPower ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.pojos.SystemUserPower ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.SystemUserSearchBean ;

public interface ISystemUserService {

    public String name = "ISystemUserService" ;

    /**
     *  增加或更新
     */
    @AnnRegisterHistory(classification = OSalesConfigProperties.classification_base_info,
            module = OSalesConfigProperties.classification_base_info_module_base_info_sys_staff, desc = "", operate = "增加/更新",
            AttrIndex = "0;1;2", loginUserAttrIndex = "2")
    public void saveUpdate(OptType optType, SysStaffUser optSystemUser, Integer optUserId) throws SystemOptServiceException ;

    public SelectPage<SysStaffUser> search(OptType optType, SystemUserSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public List<SysStaffUser> searchList(OptType optType, SystemUserSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public void remove(OptType optType, SysStaffUser optSystemUser, Integer optUserId) throws SystemOptServiceException ;

    public SysStaffUser get(Integer id) throws SystemOptServiceException ;

    public SysStaffUser searchByAccessName(String accessName) throws SystemOptServiceException ;

    public List<String> listUserModulePowerBySysUserId(Integer loginUserId) throws SystemOptServiceException ;

    public List<SystemUserPower> listUserModulePowerByUserId(Integer loginUserId) throws SystemOptServiceException ;

    public List<UserPower<UserOptPower>> searchUserPower(String moduleId, Integer loginUserId) throws SystemOptServiceException ;

    public SysStaffUser searchByName(String name) throws SystemOptServiceException ;

}
