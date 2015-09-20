package cn.zying.osales.web ;

import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.LoginAction ;
import cn.zy.apps.tools.web.SessionUser ;
import cn.zying.osales.pojos.SystemUser ;

@Component("UserLoginAction")
@org.springframework.context.annotation.Scope(LoginAction.Scope)
public class UserLoginAction extends LoginAction<SystemUser> {

    private static final long serialVersionUID = 8564146055362445474L ;

    @Override
    protected SessionUser<SystemUser> isValidate(String userName, String userPasswd) {
      
        return null ;
    }

    @Override
    public void intoMain() {

    }

}
