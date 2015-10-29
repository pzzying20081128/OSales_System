package cn.zying.osales.web ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.logger.Loggerfactory ;
import cn.zy.apps.tools.web.LoginAction ;
import cn.zy.apps.tools.web.SessionUser ;
import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.web.aop.IAopSystemUserService ;

@Component("UserLoginAction")
@org.springframework.context.annotation.Scope(LoginAction.Scope)
public class UserLoginAction extends LoginAction<SysStaffUser> {

    private static final long serialVersionUID = 8564146055362445474L ;

    @Autowired
    @Qualifier(IAopSystemUserService.aop_name)
    private IAopSystemUserService systemUserService ;

    private SysStaffUser systemUser ;

    @Override
    protected SessionUser<SysStaffUser> isValidate(String userName, String userPasswd) {
        SysStaffUser systemUser = systemUserService.searchByAccessName(userName) ;
        if (systemUser == null || !systemUser.getPwd().equals(userPasswd)) {
            Loggerfactory.error(logger, " systemUser " + systemUser + "     " + (systemUser != null ? systemUser.getPwd() : "空")) ;
            this.msg = (systemUser == null ? OSalesConfigProperties.USER_PASSWORD_ERROR + "[0]" : OSalesConfigProperties.USER_PASSWORD_ERROR + "[1]") ;
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
