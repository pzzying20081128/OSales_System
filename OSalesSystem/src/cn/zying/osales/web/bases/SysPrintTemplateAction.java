package cn.zying.osales.web.bases ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.StoreInfo ;
import cn.zying.osales.pojos.SysGridConfigs ;
import cn.zying.osales.service.baseinfo.ISysGridConfigsService ;
import cn.zying.osales.units.search.bean.StoreInfoSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopStoreInfoService ;

@Component("SysPrintTemplateAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class SysPrintTemplateAction extends OSalesSystemABAction<SysGridConfigs> {

    private static final long serialVersionUID = 5097422831159826456L ;

    @Autowired
    @Qualifier(ISysGridConfigsService.name)
    private ISysGridConfigsService service ;

    private String moduleKey ;

    private SysGridConfigs sysgridconfigs ;

    //    sort:colIndex
    //    dir:ASC

    //
    //    private StoreInfoSearchBean searchBean ;

    public String save() throws Exception {
        try {
            this.result = service.saveUpdate(optType, sysgridconfigs) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    //    public String remove() throws Exception {
    //        try {
    //            service.remove(optType, storeinfo) ;
    //        } catch (Exception e) {
    //            this.success = false ;
    //            this.msg = handError(e) ;
    //        }
    //
    //        return SUCCESS ;
    //    }

    public String get() throws Exception {
        try {
            this.result = service.get(uuid) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String list() throws Exception {
        try {
            SelectPage<SysGridConfigs> selectPage = service.search(moduleKey, commSearchBean) ;
            writeObjectService.intToPrpertiesUnits(selectPage) ;
            this.setSelectPage(selectPage) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String getModuleKey() {
        return moduleKey ;
    }

    public void setModuleKey(String moduleKey) {
        this.moduleKey = moduleKey ;
    }

    public SysGridConfigs getSysgridconfigs() {
        return sysgridconfigs ;
    }

    public void setSysgridconfigs(SysGridConfigs sysgridconfigs) {
        this.sysgridconfigs = sysgridconfigs ;
    }

    //    public StoreInfo getStoreinfo() {
    //        return storeinfo ;
    //    }
    //
    //    public void setStoreinfo(StoreInfo storeinfo) {
    //        this.storeinfo = storeinfo ;
    //    }
    //
    //    public StoreInfoSearchBean getSearchBean() {
    //        return searchBean ;
    //    }
    //
    //    public void setSearchBean(StoreInfoSearchBean searchBean) {
    //        this.searchBean = searchBean ;
    //    }

}
