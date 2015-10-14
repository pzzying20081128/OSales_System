package cn.zying.osales.web ;

import javax.annotation.Resource ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.powers.IUserPowerMdouleService ;
import cn.zy.apps.tools.web.SearchUserPowerAction ;
import cn.zy.apps.tools.web.SessionUser ;
import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.pojos.SysStaffUser ;

@Component("SalesUserPowerAction")
@org.springframework.context.annotation.Scope(SearchUserPowerAction.Scope)
public class SalesUserPowerAction extends SearchUserPowerAction {

    private static final long serialVersionUID = -2713760119222029287L ;

    @Resource(name = "IUserPowerMdouleService")
    private IUserPowerMdouleService userMdoulePowerService ;

    @Override
    protected IUserPowerMdouleService getIUserMdoulePowerService() {

        return userMdoulePowerService ;
    }

    @Override
    protected boolean isAdmin() {
        SessionUser<SysStaffUser> sessionUser = getSessionUserInfo() ;
        SysStaffUser systemUserInfo = sessionUser.getUserInfo() ;
        return systemUserInfo.getIsAdmin() == null ? false : (systemUserInfo.getIsAdmin() == OSalesConfigProperties.isDefault_1) ;
    }
    
    

}
