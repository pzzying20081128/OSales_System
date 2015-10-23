package cn.zying.osales.web.bases ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.StoreInfo ;
import cn.zying.osales.units.search.bean.StoreInfoSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopStoreInfoService ;

@Component("StoreInfoAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class StoreInfoAction extends OSalesSystemABAction<StoreInfo> {

    private static final long serialVersionUID = 5097422831159826456L ;

    @Autowired
    @Qualifier(IAopStoreInfoService.name)
    private IAopStoreInfoService service ;

    private StoreInfo storeinfo ;

    private StoreInfoSearchBean searchBean ;

    public String save() throws Exception {
        try {
            this.result = service.saveUpdate(optType, storeinfo) ;
            writeObjectService.intToPrpertiesUnits(this.result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String remove() throws Exception {
        try {
            service.remove(optType, storeinfo) ;
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
            SelectPage<StoreInfo> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
            writeObjectService.intToPrpertiesUnits(selectPage) ;
            this.setSelectPage(selectPage) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public StoreInfo getStoreinfo() {
        return storeinfo ;
    }

    public void setStoreinfo(StoreInfo storeinfo) {
        this.storeinfo = storeinfo ;
    }

    public StoreInfoSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(StoreInfoSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
