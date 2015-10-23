package cn.zying.osales.web.bases ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.StorePosition ;
import cn.zying.osales.units.search.bean.StorePositionSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopStorePositionService ;

@Component("StorePositionAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class StorePositionAction extends OSalesSystemABAction<StorePosition> {

    private static final long serialVersionUID = 5097422831159826456L ;

    @Autowired
    @Qualifier(IAopStorePositionService.name)
    private IAopStorePositionService service ;

    private StorePosition storeposition ;

    private StorePositionSearchBean searchBean ;

    public String save() throws Exception {
        try {
            this.result = service.saveUpdate(optType, storeposition) ;
            writeObjectService.intToPrpertiesUnits(this.result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String remove() throws Exception {
        try {
            service.remove(optType, storeposition) ;
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
            SelectPage<StorePosition> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
            writeObjectService.intToPrpertiesUnits(selectPage) ;
            this.setSelectPage(selectPage) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

   

    public StorePositionSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(StorePositionSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

    public StorePosition getStoreposition() {
        return storeposition ;
    }

    public void setStoreposition(StorePosition storeposition) {
        this.storeposition = storeposition ;
    }

  
}
