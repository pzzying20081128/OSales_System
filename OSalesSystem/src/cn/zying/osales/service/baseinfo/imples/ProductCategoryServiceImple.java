package cn.zying.osales.service.baseinfo.imples ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProductCategory ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.baseinfo.IProductCategoryService ;
import cn.zying.osales.service.baseinfo.units.ProductCategoryRemoveUnits ;
import cn.zying.osales.service.baseinfo.units.ProductCategorySaveUpdateUnits ;
import cn.zying.osales.service.baseinfo.units.ProductCategorySearchUnits ;
import cn.zying.osales.units.search.bean.ProductCategorySearchBean ;

@Component(IProductCategoryService.name)
public class ProductCategoryServiceImple extends ABCommonsService implements IProductCategoryService {

    //@Resource(name="ProductCategorySearchUnits")
    @Autowired
    @Qualifier("ProductCategorySearchUnits")
    private ProductCategorySearchUnits iProductCategorySearchUnits ;

    //@Resource(name=" ProductCategorySaveUpdateUnits")
    @Autowired
    @Qualifier("ProductCategorySaveUpdateUnits")
    private ProductCategorySaveUpdateUnits iProductCategorySaveUpdateUnits ;

    @Autowired
    @Qualifier("ProductCategoryRemoveUnits")
    private ProductCategoryRemoveUnits iProductCategoryRemoveUnits ;

    @Override
    public ProductCategory  saveUpdate(OptType optType, ProductCategory optProductCategory) throws SystemOptServiceException {
        ProductCategory productCategory = iProductCategorySaveUpdateUnits.saveUpdate(optType, optProductCategory) ;
        prpertiesAutoWriteObjectService.cacheObject(productCategory.getId().toString(), productCategory) ;
       return  productCategory;
    }

    @Override
    public SelectPage<ProductCategory> search(OptType optType, ProductCategorySearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iProductCategorySearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public List<ProductCategory> searchList(OptType optType, ProductCategorySearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iProductCategorySearchUnits.list(optType, searchBean, commSearchBean, startLimit) ;

    }

    @Override
    public ProductCategory  remove(OptType optType, ProductCategory optProductCategory) throws SystemOptServiceException {
         return   iProductCategoryRemoveUnits.remove(optType, optProductCategory) ;
    }

    @Override
    public ProductCategory get(Integer id) throws SystemOptServiceException {

        return baseService.get(id, ProductCategory.class) ;
    }

}
