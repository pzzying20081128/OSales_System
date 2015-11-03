package cn.zying.osales.web.bases ;

import java.util.ArrayList ;
import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.SQLUilts ;
import cn.zy.apps.tools.units.powers.SystemUserPowerTools ;
import cn.zy.apps.tools.units.powers.UserOptPower ;
import cn.zy.apps.tools.units.powers.UserPower ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.pojos.SystemUserOptPower ;
import cn.zying.osales.pojos.SystemUserPower ;
import cn.zying.osales.pojos.UserGridConfigs ;
import cn.zying.osales.service.baseinfo.ISystemGridColConfigService ;
import cn.zying.osales.units.search.bean.SystemUserSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopSystemUserService ;

/**
 * 
 * @author you
 *
 */
@Component("SysStaffUserManagerAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class SysStaffUserManagerAction extends OSalesSystemABAction<SysStaffUser> {

    /**
     * 
     */
    private static final long serialVersionUID = 2456639902961437923L ;

    @Autowired
    @Qualifier(IAopSystemUserService.aop_name)
    private IAopSystemUserService systemUserService ;

    private SysStaffUser systemUserInfo ;

    private SystemUserSearchBean searchBean ;

    private String power ;

    public String remove() throws Exception {
        try {
            systemUserService.remove(optType, systemUserInfo, getOSalsesLoginUserId()) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public String save() throws Exception {
        try {

            List<UserPower<UserOptPower>> userPowers = SystemUserPowerTools.paserUserPower(power) ;
            List<SystemUserPower> systemUserPowers = new ArrayList<SystemUserPower>() ;
            for (UserPower<UserOptPower> userPower : userPowers) {
                SystemUserPower systemUserPower = new SystemUserPower() ;
                systemUserPowers.add(systemUserPower) ;
                systemUserPower.setIds(SQLUilts.getIUniqueId()) ;
                systemUserPower.setModuleId(userPower.getModuleId()) ;
                systemUserPower.setModuleName(userPower.getModuleName()) ;
                List<SystemUserOptPower> systemUserOptPowers = new ArrayList<SystemUserOptPower>() ;
                systemUserPower.setUserOptPowers(systemUserOptPowers) ;
                for (UserOptPower userOptPower : userPower.getUserOptPowers()) {
                    SystemUserOptPower systemUserOptPower = new SystemUserOptPower() ;
                    systemUserOptPower.setIds(SQLUilts.getIUniqueId()) ;
                    systemUserOptPower.setIsUse(userOptPower.getIsUse()) ;
                    systemUserOptPower.setPowerCode(userOptPower.getPowerCode()) ;
                    systemUserOptPower.setPowerName(userOptPower.getPowerName()) ;
                    systemUserOptPowers.add(systemUserOptPower) ;
                }
            }
            systemUserInfo.setSystemUserPowers(systemUserPowers) ;
            systemUserService.saveUpdate(optType, systemUserInfo, getOSalsesLoginUserId()) ;
            writeObjectService.intToPrpertiesUnits(systemUserInfo) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public String get() throws Exception {
        try {
            systemUserInfo = systemUserService.get(uuid) ;
            writeObjectService.intToPrpertiesUnits(systemUserInfo) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public String list() throws Exception {
        try {
            SelectPage<SysStaffUser> selectPage = systemUserService.search(optType, searchBean, commSearchBean, start, limit) ;

            writeObjectService.intToPrpertiesUnits(selectPage) ;

            this.setSelectPage(selectPage) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public String updatePassword() throws Exception {
        try {
            SysStaffUser sysStaffUser_ = systemUserService.get(getOSalsesLoginUserId()) ;
            sysStaffUser_.setPwd(systemUserInfo.getAccessPassword()) ;
            systemUserService.saveUpdate(OptType.update, sysStaffUser_, getOSalsesLoginUserId()) ;
        } catch (Exception e) {
            handError(e) ;
            this.success = false ;
            this.msg = OSalesConfigProperties.USER_UPDATE_PASSWORD_ERROR ;
        }

        return SUCCESS ;
    }

    private String module_name ;

    private String data_indexs ;

    private String col_names ;

    private String col_hiddens ;

    private String col_widths ;

    private String col_indexs ;

    @Autowired
    @Qualifier(ISystemGridColConfigService.name)
    private ISystemGridColConfigService systemGridColConfigService ;

    public String col_chonig_grid() throws Exception {

        Integer user_actor = this.getOSalsesLoginUserId() ;
        try {
            systemGridColConfigService.saveUserGridConfig(module_name, data_indexs, col_names, col_hiddens, col_widths, col_indexs, user_actor) ;
        } catch (Exception e) {
            this.msg = handError(e) ;
            this.success = false ;
        }
        success = true ;
        return SUCCESS ;
    }

    private List<UserGridConfigs> userGridConfigs ;

    public String fetch_hidden_col() throws Exception {
        try {
            Integer user_actor = this.getOSalsesLoginUserId() ;
            userGridConfigs = systemGridColConfigService.find(module_name, user_actor) ;
            writeObjectService.intToPrpertiesUnits(userGridConfigs) ;

        } catch (Exception e) {
            this.msg = handError(e) ;
            this.success = false ;
        }
        success = true ;
        return SUCCESS ;
    }

    public SysStaffUser getSystemUserInfo() {
        return systemUserInfo ;
    }

    public void setSystemUserInfo(SysStaffUser systemUserInfo) {
        this.systemUserInfo = systemUserInfo ;
    }

    public void setPower(String power) {
        this.power = power ;
    }

    public void setSearchBean(SystemUserSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

    public SystemUserSearchBean getSearchBean() {
        return searchBean ;
    }

    public String getModule_name() {
        return module_name ;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name ;
    }

    public String getData_indexs() {
        return data_indexs ;
    }

    public void setData_indexs(String data_indexs) {
        this.data_indexs = data_indexs ;
    }

    public String getCol_names() {
        return col_names ;
    }

    public void setCol_names(String col_names) {
        this.col_names = col_names ;
    }

    public String getCol_hiddens() {
        return col_hiddens ;
    }

    public void setCol_hiddens(String col_hiddens) {
        this.col_hiddens = col_hiddens ;
    }

    public String getCol_widths() {
        return col_widths ;
    }

    public void setCol_widths(String col_widths) {
        this.col_widths = col_widths ;
    }

    public String getCol_indexs() {
        return col_indexs ;
    }

    public void setCol_indexs(String col_indexs) {
        this.col_indexs = col_indexs ;
    }

    public List<UserGridConfigs> getUserGridConfigs() {
        return userGridConfigs ;
    }

    public void setUserGridConfigs(List<UserGridConfigs> userGridConfigs) {
        this.userGridConfigs = userGridConfigs ;
    }

}
