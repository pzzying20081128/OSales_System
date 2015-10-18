package cn.zying.osales.web.search ;

import java.util.List ;
import java.util.Map ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.ABSearchAction ;
import cn.zy.apps.tools.web.SearchUserPowerAction ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProductCategory ;
import cn.zying.osales.units.search.bean.ProductCategorySearchBean ;
import cn.zying.osales.web.aop.IAopProductCategoryService ;

@Component("ProductCategorySearchAction")
@org.springframework.context.annotation.Scope(SearchUserPowerAction.Scope)
public class ProductCategorySearchAction extends ABSearchAction {

    @Autowired
    @Qualifier(IAopProductCategoryService.name)
    private IAopProductCategoryService service ;
    
    private ProductCategorySearchBean  searchBean;

    @Override
    protected List<ProductCategory> searchResult() throws Exception {
        
        searchBean.setName(name);

        return service.searchList(OptType.search, searchBean, null, 0, 20) ;
    }

    public ProductCategorySearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(ProductCategorySearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
