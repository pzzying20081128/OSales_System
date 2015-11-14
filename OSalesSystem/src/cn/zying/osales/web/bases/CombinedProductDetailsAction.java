package cn.zying.osales.web.bases ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.CombinedProduct ;
import cn.zying.osales.pojos.CombinedProductDetails ;
import cn.zying.osales.units.BuildMoneyUnits ;
import cn.zying.osales.units.search.bean.CombinedProductDetailsSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopCombinedProductDetailsService ;
import cn.zying.osales.web.aop.IAopCombinedProductService ;

@Component("CombinedProductDetailsAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class CombinedProductDetailsAction extends OSalesSystemABAction<CombinedProductDetails> {

    private static final long serialVersionUID = 5097422831159826456L ;

    @Autowired
    @Qualifier(IAopCombinedProductDetailsService.name)
    private IAopCombinedProductDetailsService service ;

    @Autowired
    @Qualifier(IAopCombinedProductService.name)
    private IAopCombinedProductService combinedProductService ;

    private CombinedProductDetails combinedproductdetails ;

    private CombinedProductDetailsSearchBean searchBean ;

    public String save() throws Exception {
        try {

            BuildMoneyUnits.build(combinedproductdetails) ;
            this.result = service.saveUpdate(optType, combinedproductdetails) ;
            CombinedProduct combinedProduct = combinedProductService.get(combinedproductdetails.getCombinedProductId()) ;
            combinedproductdetails.setCombinedProduct(combinedProduct) ;
            writeObjectService.intToPrpertiesUnits(this.result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String remove() throws Exception {
        try {
            CombinedProductDetails combinedProductDetails = service.remove(optType, combinedproductdetails) ;
            writeObjectService.intToPrpertiesUnits(combinedProductDetails) ;
            this.result = combinedProductDetails ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String get() throws Exception {
        try {
            CombinedProductDetails combinedProductDetails = service.get(uuid) ;
            writeObjectService.intToPrpertiesUnits(combinedProductDetails) ;
            this.result = combinedProductDetails ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String list() throws Exception {
        try {
            SelectPage<CombinedProductDetails> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
            writeObjectService.intToPrpertiesUnits(selectPage) ;
            this.setSelectPage(selectPage) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public CombinedProductDetails getCombinedproductdetails() {
        return combinedproductdetails ;
    }

    public void setCombinedproductdetails(CombinedProductDetails combinedproductdetails) {
        this.combinedproductdetails = combinedproductdetails ;
    }

    public CombinedProductDetailsSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(CombinedProductDetailsSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
