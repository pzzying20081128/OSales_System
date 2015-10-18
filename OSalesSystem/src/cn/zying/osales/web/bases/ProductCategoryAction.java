package cn.zying.osales.web.bases ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.ProductCategory ;
import cn.zying.osales.units.search.bean.ProductCategorySearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopProductCategoryService ;

@Component("ProductCategoryAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class ProductCategoryAction extends OSalesSystemABAction<ProductCategory> {

    private static final long serialVersionUID = 5097422831159826456L ;

    @Autowired
    @Qualifier(IAopProductCategoryService.name)
    private IAopProductCategoryService service ;

    private ProductCategory productCategory ;

    private ProductCategorySearchBean searchBean ;

    public String save() throws Exception {
        try {
            service.saveUpdate(optType, productCategory) ;
            this.result = productCategory ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String remove() throws Exception {
        try {
            service.remove(optType, productCategory) ;
            this.result = productCategory ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String get() throws Exception {
        try {
            productCategory = service.get(uuid) ;
            this.result = productCategory ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String list() throws Exception {
        try {
            SelectPage<ProductCategory> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
            this.setSelectPage(selectPage) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public IAopProductCategoryService getService() {
        return service ;
    }

    public void setService(IAopProductCategoryService service) {
        this.service = service ;
    }

    public ProductCategory getProductCategory() {
        return productCategory ;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory ;
    }

    public ProductCategorySearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(ProductCategorySearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
