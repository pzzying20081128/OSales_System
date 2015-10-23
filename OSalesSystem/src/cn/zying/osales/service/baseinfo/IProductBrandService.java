 package  cn.zying.osales.service.baseinfo;

 
 
 import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProductBrand ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.ProductBrandSearchBean ;

public interface IProductBrandService {
    
            public String name="IProductBrandService";
            
                
            /**
             *  增加或更新
             */
            public void saveUpdate(OptType  optType ,   ProductBrand   optProductBrand )throws SystemOptServiceException;
            
       	  
            public SelectPage<ProductBrand > search(OptType  optType ,    
				           ProductBrandSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException;
            
            public List<ProductBrand > searchList(OptType  optType ,    
                    ProductBrandSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException;
            
            public  void   remove(OptType  optType ,  ProductBrand   optProductBrand)throws SystemOptServiceException;
            
            
           public  ProductBrand get(Integer id)throws SystemOptServiceException;
            
            
            

}
