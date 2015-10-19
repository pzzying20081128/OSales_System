package cn.zying.osales.web.aop ;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.infaces.InfaceProductCategoryService ;
import cn.zying.osales.pojos.ProductCategory ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.ProductCategorySearchBean ;

public interface IAopProductCategoryService extends InfaceProductCategoryService  {

    public String name = "IAopProductCategoryService" ;
    
    
}
