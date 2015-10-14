package cn.zying.osales.web ;

import java.util.Map ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.LoginAction ;
import cn.zy.apps.tools.web.SessionUser ;
import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.sysmanage.ISystemUserService ;

@Component("UserLoginAction")
@org.springframework.context.annotation.Scope(LoginAction.Scope)
public class UserLoginAction extends LoginAction<SysStaffUser> {

    private static final long serialVersionUID = 8564146055362445474L ;

    @Autowired
    @Qualifier(ISystemUserService.aop_name)
    private ISystemUserService systemUserService ;

    private SysStaffUser systemUser ;

    @Override
    protected SessionUser<SysStaffUser> isValidate(String userName, String userPasswd) {
        SysStaffUser systemUser = systemUserService.searchByAccessName(userName) ;
        if (systemUser == null || !systemUser.getPwd().equals(userPasswd)) {
            this.msg = OSalesConfigProperties.USER_PASSWORD_ERROR ;
            return null ;
        } else {
            SessionUser<SysStaffUser> sessionUser = new SessionUser<SysStaffUser>() ;
            sessionUser.setLoginUserName(userName) ;
            sessionUser.setUserId(systemUser.getId().toString()) ;
            sessionUser.setUserInfo(systemUser) ;
            return sessionUser ;
        }
    }

    @Override
    public void intoMain() {
        String loginUserId = getLoginUserId() ;
        Integer loginUserId_ = Integer.parseInt(loginUserId) ;
        systemUser = systemUserService.get(loginUserId_) ;

    }

    public SysStaffUser getSystemUser() {
        return systemUser ;
    }

}
