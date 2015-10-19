package cn.zying.osales.service.baseinfo.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.ProductCategory ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("ProductCategoryRemoveUnits")
public class ProductCategoryRemoveUnits extends ABCommonsService {

    public ProductCategory remove(OptType optType, ProductCategory optProductCategory) throws SystemOptServiceException {

        Integer id = optProductCategory.getId() ;
        ProductCategory removeProductCategory = baseService.get(id, ProductCategory.class) ;
        removeProductCategory.setStatus(Status.删除) ;

        baseService.update(removeProductCategory) ;

        removeChild(removeProductCategory) ;
        return removeProductCategory ;

    }

    public void removeChild(ProductCategory removeProductCategory) throws SystemOptServiceException {
        for (ProductCategory productCategory : removeProductCategory.getChilds()) {
            productCategory.setStatus(removeProductCategory.getStatus()) ;
            baseService.update(productCategory) ;
            removeChild(productCategory) ;

        }
    }

}
