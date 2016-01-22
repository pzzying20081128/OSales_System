package cn.zying.osales.web.bases ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.SystemConfigs ;
import cn.zying.osales.service.baseinfo.ISystemConfigsService ;
import cn.zying.osales.units.search.bean.SystemConfigsSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;

@Component("SystemConfigsAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class SystemConfigsAction extends OSalesSystemABAction<SystemConfigs> {

    private static final long serialVersionUID = 5097422831159826456L ;

    @Autowired
    @Qualifier(ISystemConfigsService.name)
    private ISystemConfigsService service ;

    private SystemConfigs systemconfigs ;

    private SystemConfigsSearchBean searchBean ;

    public String get() throws Exception {
        try {
            this.result = service.get(uuid) ;
            writeObjectService.intToPrpertiesUnits(this.result) ;

        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String list() throws Exception {
        try {
            SelectPage<SystemConfigs> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
            writeObjectService.intToPrpertiesUnits(selectPage) ;
            this.setSelectPage(selectPage) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public SystemConfigs getSystemconfigs() {
        return systemconfigs ;
    }

    public void setSystemconfigs(SystemConfigs systemconfigs) {
        this.systemconfigs = systemconfigs ;
    }

    public SystemConfigsSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(SystemConfigsSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
