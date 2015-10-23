package cn.zying.osales.infaces;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProductCategory ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.ProductCategorySearchBean ;

public interface InfaceProductCategoryService {
    
    
    /**
     *  增加或更新
     */
    public ProductCategory  saveUpdate(OptType optType, ProductCategory optProductCategory) throws SystemOptServiceException ;

    public SelectPage<ProductCategory> search(OptType optType, ProductCategorySearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public List<ProductCategory> searchList(OptType optType, ProductCategorySearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public ProductCategory  remove(OptType optType, ProductCategory optProductCategory) throws SystemOptServiceException ;

    public ProductCategory get(Integer id) throws SystemOptServiceException ;


}
