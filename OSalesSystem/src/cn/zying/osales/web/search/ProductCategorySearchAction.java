package cn.zying.osales.web.search ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SearchUserPowerAction ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProductCategory ;
import cn.zying.osales.units.search.bean.ProductCategorySearchBean ;
import cn.zying.osales.web.aop.IAopProductCategoryService ;

@Component("ProductCategorySearchAction")
@org.springframework.context.annotation.Scope(SearchUserPowerAction.Scope)
public class ProductCategorySearchAction extends ABSalesSearchAction {

    @Autowired
    @Qualifier(IAopProductCategoryService.name)
    private IAopProductCategoryService service ;

    private ProductCategorySearchBean searchBean ;

    @Override
    protected List<ProductCategory> searchResult() throws Exception {
        try {
            searchBean.setName(name) ;
            searchBean.setId(uuid) ;
            return service.searchList(OptType.search, searchBean, null, 0, 20) ;

            //        if (searchBean.getId() != null) {
            //            for (StoreInfo result : results) {
            //                if (result.getId().equals(searchBean.getId())) return results ;
            //            }
            //            StoreInfo res = service.get(searchBean.getId()) ;
            //            results.add(0, res) ;
            //            return results ;
            //        } else {
            //            return results ;
            //        }
            //        

        } catch (Exception e) {
            this.msg = handError(e) ;
            this.success = false ;
        }
        return null ;
    }

    public ProductCategorySearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(ProductCategorySearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
