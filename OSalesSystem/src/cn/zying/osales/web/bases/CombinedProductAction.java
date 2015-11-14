package cn.zying.osales.web.bases ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.CombinedProduct ;
import cn.zying.osales.units.BuildMoneyUnits ;
import cn.zying.osales.units.search.bean.CombinedProductSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopCombinedProductService ;

@Component("CombinedProductAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class CombinedProductAction extends OSalesSystemABAction<CombinedProduct> {

    private static final long serialVersionUID = 5097422831159826456L ;

    @Autowired
    @Qualifier(IAopCombinedProductService.name)
    private IAopCombinedProductService service ;

    private CombinedProduct combinedproduct ;

    private CombinedProductSearchBean searchBean ;

    public String save() throws Exception {
        try {
            combinedproduct.setRecordManId(getOSalsesLoginUserId()) ;
            BuildMoneyUnits.build(combinedproduct) ;
            this.result = service.saveUpdate(optType, combinedproduct) ;
            writeObjectService.intToPrpertiesUnits(this.result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String remove() throws Exception {
        try {
            this.result = service.remove(optType, combinedproduct) ;
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
            SelectPage<CombinedProduct> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
            writeObjectService.intToPrpertiesUnits(selectPage) ;
            this.setSelectPage(selectPage) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String check() throws Exception {
        try {

            Integer checkManId = getOSalsesLoginUserId() ;
            service.check(uuid, checkManId) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public CombinedProduct getCombinedproduct() {
        return combinedproduct ;
    }

    public void setCombinedproduct(CombinedProduct combinedproduct) {
        this.combinedproduct = combinedproduct ;
    }

    public CombinedProductSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(CombinedProductSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
