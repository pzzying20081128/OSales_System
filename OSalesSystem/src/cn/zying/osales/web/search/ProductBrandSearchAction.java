package cn.zying.osales.web.search ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SearchUserPowerAction ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProductBrand ;
import cn.zying.osales.units.search.bean.ProductBrandSearchBean ;
import cn.zying.osales.web.aop.IAopProductBrandService ;

@Component("ProductBrandSearchAction")
@org.springframework.context.annotation.Scope(SearchUserPowerAction.Scope)
public class ProductBrandSearchAction extends ABSalesSearchAction {

    private static final long serialVersionUID = -4770542683936763149L ;

    @Autowired
    @Qualifier(IAopProductBrandService.name)
    private IAopProductBrandService service ;

    private ProductBrandSearchBean searchBean ;

    @Override
    protected List<ProductBrand> searchResult() throws Exception {
        try {
            List<ProductBrand> results = service.searchList(OptType.search, searchBean, null, 0, 20) ;
            if (searchBean.getId() != null) {
                for (ProductBrand result : results) {
                    if (result.getId().equals(searchBean.getId())) return results ;
                }
                ProductBrand res = service.get(searchBean.getId()) ;
                results.add(0, res) ;
                return results ;
            } else {
                return results ;
            }

        } catch (Exception e) {
            this.msg = handError(e) ;
            this.success = false ;
            return null ;
        }

    }

    public ProductBrandSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(ProductBrandSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
