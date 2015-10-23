package cn.zying.osales.web.bases ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.ProviderInfo ;
import cn.zying.osales.units.search.bean.ProviderInfoSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopProviderInfoService ;

@Component("ProviderInfoAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class ProviderInfoAction extends OSalesSystemABAction<ProviderInfo> {

    private static final long serialVersionUID = 5097422831159826456L ;

    @Autowired
    @Qualifier(IAopProviderInfoService.name)
    private IAopProviderInfoService service ;

    private ProviderInfo providerinfo ;

    private ProviderInfoSearchBean searchBean ;

    public String save() throws Exception {
        try {
            this.result = service.saveUpdate(optType, providerinfo) ;

            writeObjectService.intToPrpertiesUnits(this.result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String remove() throws Exception {
        try {
            this.result = service.remove(optType, providerinfo) ;
            writeObjectService.intToPrpertiesUnits(this.result) ;

        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

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
            SelectPage<ProviderInfo> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
            writeObjectService.intToPrpertiesUnits(selectPage) ;
            this.setSelectPage(selectPage) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public ProviderInfoSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(ProviderInfoSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

    public ProviderInfo getProviderinfo() {
        return providerinfo ;
    }

    public void setProviderinfo(ProviderInfo providerinfo) {
        this.providerinfo = providerinfo ;
    }

}
