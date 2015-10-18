package cn.zying.osales.service.baseinfo.units ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.ProductCategory ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("ProductCategorySaveUpdateUnits")
public class ProductCategorySaveUpdateUnits extends ABCommonsService {

    @Autowired
    @Qualifier("ProductCategoryRemoveUnits")
    private ProductCategoryRemoveUnits productCategoryRemoveUnits ;

    public void saveUpdate(OptType optType, ProductCategory optProductCategory) throws SystemOptServiceException {

        switch (optType) {
        case save:
            save(optProductCategory) ;
            break ;
        case update:
            update(optProductCategory) ;
            break ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public void save(ProductCategory optProductCategory) throws SystemOptServiceException {
        optProductCategory.setStatus(Status.有效) ;
        if (optProductCategory.getParentId() != null) {
            ProductCategory productCategoryParent = baseService.load(optProductCategory.getParentId(), ProductCategory.class) ;
            productCategoryParent.setIsChild(OSalesConfigProperties.isDefault_1) ;
            optProductCategory.setParent(productCategoryParent) ;
            baseService.update(productCategoryParent) ;
        }
        baseService.save(optProductCategory) ;

    }

    public void update(ProductCategory optProductCategory) throws SystemOptServiceException {
        ProductCategory temp = baseService.load(optProductCategory.getId(), ProductCategory.class) ;
        temp.setName(optProductCategory.getName()) ;
        temp.setStatus(optProductCategory.getStatus()) ;
        switch (temp.getStatus()) {
        case 无效:
        case 删除:
            productCategoryRemoveUnits.removeChild(temp) ;
            break ;

        default:
            break ;
        }
        baseService.update(temp) ;
    }

}
