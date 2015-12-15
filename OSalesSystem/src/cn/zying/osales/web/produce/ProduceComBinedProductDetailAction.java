package cn.zying.osales.web.produce ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProduceComBinedProductDetail ;
import cn.zying.osales.units.BuildMoneyUnits ;
import cn.zying.osales.units.search.bean.ProduceComBinedProductDetailSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopProduceComBinedProductDetailService ;

@Component("ProduceComBinedProductDetailAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class ProduceComBinedProductDetailAction extends OSalesSystemABAction<ProduceComBinedProductDetail> {

    private static final long serialVersionUID = 6504438201408756157L ;

    @Autowired
    @Qualifier(IAopProduceComBinedProductDetailService.name)
    private IAopProduceComBinedProductDetailService service ;

    private ProduceComBinedProductDetail producecombinedproductdetail ;

    private ProduceComBinedProductDetailSearchBean searchBean ;

    public String list() throws Exception {
        try {
            SelectPage<ProduceComBinedProductDetail> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
            writeObjectService.intToPrpertiesUnits(selectPage) ;
            this.setSelectPage(selectPage) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String saveUpdate() throws Exception {
        try {
            BuildMoneyUnits.build(producecombinedproductdetail) ;
            this.result = service.saveUpdate(optType, producecombinedproductdetail) ;

            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public String get() throws Exception {
        try {

            this.result = service.get(uuid) ;

            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public String remove() throws Exception {
        try {
            this.result = service.remove(OptType.delete, producecombinedproductdetail) ;

            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public ProduceComBinedProductDetail getProducecombinedproductdetail() {
        return producecombinedproductdetail ;
    }

    public void setProducecombinedproductdetail(ProduceComBinedProductDetail producecombinedproductdetail) {
        this.producecombinedproductdetail = producecombinedproductdetail ;
    }

    public ProduceComBinedProductDetailSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(ProduceComBinedProductDetailSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
