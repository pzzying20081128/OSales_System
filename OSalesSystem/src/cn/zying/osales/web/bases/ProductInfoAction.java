package cn.zying.osales.web.bases ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.ProductInfo ;
import cn.zying.osales.units.BuildProductInfoUnit ;
import cn.zying.osales.units.search.bean.ProductInfoSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopProductInfoService ;

@Component("ProductInfoAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class ProductInfoAction extends OSalesSystemABAction<ProductInfo> {

    private static final long serialVersionUID = 5097422831159826456L ;

    @Autowired
    @Qualifier(IAopProductInfoService.name)
    private IAopProductInfoService service ;

    private ProductInfo productinfo ;

    private ProductInfoSearchBean searchBean ;

    public String save() throws Exception {
        try {
            BuildProductInfoUnit.buildToLong(productinfo) ;
            this.result = service.saveUpdate(optType, productinfo) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String remove() throws Exception {
        try {
            this.result = service.remove(optType, productinfo) ;
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

    public String list() throws Exception {
        try {
            SelectPage<ProductInfo> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
            writeObjectService.intToPrpertiesUnits(selectPage) ;
            this.setSelectPage(selectPage) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    private Integer providerInfoId ;

    public String selectStockPrice() throws Exception {
        try {
            this.result = service.selectStockPrice(uuid, providerInfoId) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public ProductInfo getProductinfo() {
        return productinfo ;
    }

    public void setProductinfo(ProductInfo productinfo) {
        this.productinfo = productinfo ;
    }

    public ProductInfoSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(ProductInfoSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

    public Integer getProviderInfoId() {
        return providerInfoId ;
    }

    public void setProviderInfoId(Integer providerInfoId) {
        this.providerInfoId = providerInfoId ;
    }

}
