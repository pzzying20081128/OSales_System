package cn.zying.osales.historys ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.logger.Loggerfactory ;
import cn.zy.apps.tools.units.DateToolsUilts ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SysOptHistory ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.baseinfo.ISysOptHistoryService ;

@Component("RegBaseInfoModuleHistory")
public class RegBaseInfoModuleHistory extends ABBaseRegisterHistory {

    private static String classification = OSalesConfigProperties.classification_base_info ;

    @Autowired
    @Qualifier(ISysOptHistoryService.name)
    private ISysOptHistoryService sysOptHistoryService ;

    @Override
    protected void optafter(String module, String operate, String desc, Integer loginSysUserId, Object... args) {
        try {
            switch (module) {
            case OSalesConfigProperties.classification_base_info_module_base_info_sys_staff:
                regSysStaffHistory(loginSysUserId, operate, args) ;
                break ;

            default:
                break ;
            }
        } catch (Exception e) {
            Loggerfactory.error(logger, e) ;
        }
    }

    @Override
    public String getClassification() {
        return classification ;
    }

    /**
     * AttrIndex = "0;1;2" OptType optType, SysStaffUser optSystemUser
     */

    private void regSysStaffHistory(Integer loginSysUserId, String operate, Object... args) {
        OptType optType = (OptType) args[0] ;
        SysStaffUser optSystemUser = (SysStaffUser) args[1] ;
        SysOptHistory sysOptHistory = new SysOptHistory() ;
        sysOptHistory.setClassification(classification) ;
        sysOptHistory.setModule(OSalesConfigProperties.classification_base_info_module_base_info_sys_staff) ;
        sysOptHistory.setOptTime(DateToolsUilts.getnowDate()) ;
        sysOptHistory.setSysStaffUserId(loginSysUserId) ;
        switch (optType) {
        case save:
            sysOptHistory.setText("增加员工[" + optSystemUser.getName() + "] 系统用户[" + (ToolsUnits.isNOtNulll(optSystemUser.getAccount()) ? optSystemUser.getAccount() : "空") + "]信息") ;
            break ;
        case update:
            sysOptHistory.setText("更新员工[" + optSystemUser.getName() + "] 系统用户[" + (ToolsUnits.isNOtNulll(optSystemUser.getAccount()) ? optSystemUser.getAccount() : "空") + "]信息") ;
            break ;
        default:
            return ;
        }
        sysOptHistoryService.saveUpdate(OptType.save, sysOptHistory) ;
    }

}
