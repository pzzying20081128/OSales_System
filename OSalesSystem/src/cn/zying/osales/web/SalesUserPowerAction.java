package cn.zying.osales.web ;

import java.util.List ;

import javax.annotation.Resource ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.powers.IUserPowerMdouleService ;
import cn.zy.apps.tools.units.powers.MyPowerBean ;
import cn.zy.apps.tools.units.powers.SystemUserPowerTools ;
import cn.zy.apps.tools.units.powers.TreeData ;
import cn.zy.apps.tools.web.SearchUserPowerAction ;
import cn.zy.apps.tools.web.SessionUser ;
import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.pojos.SystemUserPower ;
import cn.zying.osales.web.aop.IAopSystemUserService ;

@Component("SalesUserPowerAction")
@org.springframework.context.annotation.Scope(SearchUserPowerAction.Scope)
public class SalesUserPowerAction extends SearchUserPowerAction {

    private static final long serialVersionUID = -2713760119222029287L ;

    @Resource(name = "IUserPowerMdouleService")
    private IUserPowerMdouleService userMdoulePowerService ;

    @Autowired
    @Qualifier(IAopSystemUserService.aop_name)
    private IAopSystemUserService systemUserService ;

    protected Integer uuid ;

    private MyPowerBean powerBean ;

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

    public String listPowerByUserId() throws Exception {
        try {
            MyPowerBean powerBean = new MyPowerBean() ;

            List<SystemUserPower> tmpUserPowerList = systemUserService.listUserModulePowerByUserId(uuid) ;

            List<TreeData> userPowerList = SystemUserPowerTools.switch2TreeData((List<SystemUserPower>) tmpUserPowerList) ;

            powerBean.setChildren(userPowerList) ;
            powerBean.setMsg(null) ;
            powerBean.setSuccess(true) ;
            this.powerBean = powerBean ;
            this.success = true ;
        } catch (Exception e) {
            this.msg = handError(e) ;
            this.success = false ;
        }
        return SUCCESS ;
    }

    


    public Integer getUuid() {
        return uuid ;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid ;
    }

    public MyPowerBean getPowerBean() {
        return powerBean ;
    }

    public void setPowerBean(MyPowerBean powerBean) {
        this.powerBean = powerBean ;
    }

}
