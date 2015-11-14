package cn.zying.osales.web.produce ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProduceComBinedProduct ;
import cn.zying.osales.units.BuildMoneyUnits ;
import cn.zying.osales.units.search.bean.ProduceComBinedProductSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopProduceComBinedProductService ;

@Component("ProduceComBinedProductAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class ProduceComBinedProductAction extends OSalesSystemABAction<ProduceComBinedProduct> {

    private static final long serialVersionUID = 6504438201408756157L ;

    @Autowired
    @Qualifier(IAopProduceComBinedProductService.name)
    private IAopProduceComBinedProductService service ;

    private ProduceComBinedProduct producecombinedproduct ;

    private ProduceComBinedProductSearchBean searchBean ;

    public String list() throws Exception {
        try {
            SelectPage<ProduceComBinedProduct> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
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
            BuildMoneyUnits.build(producecombinedproduct) ;
            this.result = service.saveUpdate(optType, producecombinedproduct) ;

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
            this.result = service.remove(OptType.delete, producecombinedproduct) ;

            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String check() throws Exception {
        try {
            service.check(uuid, getOSalsesLoginUserId()) ;

        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public ProduceComBinedProduct getProducecombinedproduct() {
        return producecombinedproduct ;
    }

    public void setProducecombinedproduct(ProduceComBinedProduct producecombinedproduct) {
        this.producecombinedproduct = producecombinedproduct ;
    }

    public ProduceComBinedProductSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(ProduceComBinedProductSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
