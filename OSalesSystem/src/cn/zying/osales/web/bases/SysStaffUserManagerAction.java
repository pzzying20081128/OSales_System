package cn.zying.osales.web.bases ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.sysmanage.ISystemUserService ;
import cn.zying.osales.web.OSalesSystemABAction ;

/**
 * 
 * @author you
 *
 */
@Component("SysStaffUserManagerAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class SysStaffUserManagerAction extends OSalesSystemABAction {

    /**
     * 
     */
    private static final long serialVersionUID = 2456639902961437923L ;

    @Autowired
    @Qualifier(ISystemUserService.aop_name)
    private ISystemUserService systemUserService ;

    private SysStaffUser systemUserInfo ;

    public String updatePassword() throws Exception {
        try {
            SysStaffUser sysStaffUser_ = systemUserService.get(getOSalsesLoginUserId()) ;
            sysStaffUser_.setPwd(systemUserInfo.getAccessPassword()) ;
            systemUserService.saveUpdate(OptType.update, sysStaffUser_) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = OSalesConfigProperties.USER_UPDATE_PASSWORD_ERROR ;
        }

        return SUCCESS ;
    }

    public SysStaffUser getSystemUserInfo() {
        return systemUserInfo ;
    }

    public void setSystemUserInfo(SysStaffUser systemUserInfo) {
        this.systemUserInfo = systemUserInfo ;
    }

}
