package cn.zying.osales.web.bases ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.ProductBrand ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.units.search.bean.ProductBrandSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopProductBrandService ;

@Component("ProductBrandAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class ProductBrandAction extends OSalesSystemABAction<ProductBrand> {

    private static final long serialVersionUID = 5097422831159826456L ;

    @Autowired
    @Qualifier(IAopProductBrandService.name)
    private IAopProductBrandService aopProductBrandService ;

    private ProductBrand productBrand ;

    private ProductBrandSearchBean searchBean ;
    
    public String save() throws Exception {
        try {
            aopProductBrandService.saveUpdate(optType, productBrand) ;
            this.result = productBrand;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String remove() throws Exception {
        try {
            aopProductBrandService.remove(optType, productBrand) ;
            this.result = productBrand;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String get() throws Exception {
        try {
            productBrand = aopProductBrandService.get(uuid) ;
            this.result = productBrand;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String list() throws Exception {
        try {
            SelectPage<ProductBrand> selectPage = aopProductBrandService.search(optType, searchBean, commSearchBean, start, limit) ;
            this.setSelectPage(selectPage) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public ProductBrand getProductBrand() {
        return productBrand ;
    }

    public void setProductBrand(ProductBrand productBrand) {
        this.productBrand = productBrand ;
    }

    public ProductBrandSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(ProductBrandSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

    public ProductBrand getResult() {
        return result ;
    }

    public void setResult(ProductBrand result) {
        this.result = result ;
    }
    
    
}
