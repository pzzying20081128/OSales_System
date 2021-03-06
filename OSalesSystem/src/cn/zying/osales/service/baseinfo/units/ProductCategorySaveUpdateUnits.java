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

    public ProductCategory saveUpdate(OptType optType, ProductCategory optProductCategory) throws SystemOptServiceException {
        v(optType, optProductCategory) ;
        switch (optType) {
        case save:
            return save(optProductCategory) ;

        case update:

            return update(optProductCategory) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    private void v(OptType optType, ProductCategory optProductCategory) throws SystemOptServiceException {

        String sql = "select  optProductCategory  from   ProductCategory   as  optProductCategory  where optProductCategory.name ='"

        + optProductCategory.getName() + "'   " ;

        ProductCategory productCategory = baseService.findSinglenessByHSQL(sql) ;

        switch (optType) {
        case save:
            if (productCategory != null) {
                throw new SystemOptServiceException("类别名重复") ;
            }
            break ;
        case update:

            if (productCategory != null && !productCategory.getId().equals(optProductCategory.getId())) {
                throw new SystemOptServiceException("类别名重复") ;
            }
            break ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }

    }

    public ProductCategory save(ProductCategory optProductCategory) throws SystemOptServiceException {
        optProductCategory.setStatus(Status.有效) ;
        if (optProductCategory.getParentId() != null) {
            ProductCategory productCategoryParent = baseService.get(optProductCategory.getParentId(), ProductCategory.class) ;

            productCategoryParent.setIsChild(OSalesConfigProperties.isDefault_1) ;
            optProductCategory.setParent(productCategoryParent) ;
            productCategoryParent.setParentId(productCategoryParent.getParentId()) ;
            baseService.update(productCategoryParent) ;
        } else {
            optProductCategory.setParent(null) ;
        }
        baseService.save(optProductCategory) ;
        return optProductCategory ;

    }

    public ProductCategory update(ProductCategory optProductCategory) throws SystemOptServiceException {
        ProductCategory temp = baseService.get(optProductCategory.getId(), ProductCategory.class) ;
        temp.setName(optProductCategory.getName()) ;
        temp.setStatus(optProductCategory.getStatus()) ;
        ProductCategory oldProductCategory = temp.getParent() ;
        if (optProductCategory.getParentId() != null) {

            ProductCategory productCategoryParent = baseService.get(optProductCategory.getParentId(), ProductCategory.class) ;
            productCategoryParent.setIsChild(OSalesConfigProperties.isDefault_1) ;
            temp.setParent(productCategoryParent) ;
            temp.setParentId(productCategoryParent.getId()) ;
        } else {
            optProductCategory.setParent(null) ;
        }
        baseService.update(temp) ;
        if (oldProductCategory != null) {
            Integer size = temp.getParent().getChilds().size() ;
            if (size == 0) {
                oldProductCategory.setIsChild(OSalesConfigProperties.isDefault_0) ;
                baseService.update(oldProductCategory) ;
            }
        }

        switch (temp.getStatus()) {
        case 无效:
        case 删除:
            productCategoryRemoveUnits.removeChild(temp) ;
            break ;

        default:
            break ;
        }

        return temp ;
    }

}
