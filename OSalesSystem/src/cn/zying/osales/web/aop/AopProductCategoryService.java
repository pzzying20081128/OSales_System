package cn.zying.osales.web.aop ;



import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProductCategory ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.baseinfo.IProductCategoryService ;
import cn.zying.osales.units.search.bean.ProductCategorySearchBean ;

@Component(IAopProductCategoryService.name)
public class AopProductCategoryService implements IAopProductCategoryService {

    @Autowired
    @Qualifier(IProductCategoryService.name)
    private IProductCategoryService iProductCategoryService ;

    public ProductCategory saveUpdate(OptType optType, ProductCategory optProductCategory) throws SystemOptServiceException {

       return  iProductCategoryService.saveUpdate(optType, optProductCategory) ;

    }

    public SelectPage<ProductCategory> search(OptType optType, ProductCategorySearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iProductCategoryService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    public List<ProductCategory> searchList(OptType optType, ProductCategorySearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iProductCategoryService.searchList(optType, searchBean, commSearchBean, startLimit) ;

    }

    public ProductCategory remove(OptType optType, ProductCategory optProductCategory) throws SystemOptServiceException {

       return   iProductCategoryService.remove(optType, optProductCategory) ;

    }

    public ProductCategory get(Integer id) throws SystemOptServiceException {
        return iProductCategoryService.get(id) ;

    }

}
