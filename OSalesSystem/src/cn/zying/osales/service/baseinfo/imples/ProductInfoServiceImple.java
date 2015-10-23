 package  cn.zying.osales.service.baseinfo.imples;
 

  import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProductInfo ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.baseinfo.IProductInfoService ;
import cn.zying.osales.service.baseinfo.units.ProductInfoRemoveUnits ;
import cn.zying.osales.service.baseinfo.units.ProductInfoSaveUpdateUnits ;
import cn.zying.osales.service.baseinfo.units.ProductInfoSearchUnits ;
import cn.zying.osales.units.search.bean.ProductInfoSearchBean ;
 

@Component(IProductInfoService.name)
public class ProductInfoServiceImple extends  ABCommonsService  implements IProductInfoService {

            //@Resource(name="ProductInfoSearchUnits")
			  @Autowired
            @Qualifier("ProductInfoSearchUnits")        
            private  ProductInfoSearchUnits  iProductInfoSearchUnits;
           
           //@Resource(name=" ProductInfoSaveUpdateUnits")
		     @Autowired
            @Qualifier("ProductInfoSaveUpdateUnits")      
           private ProductInfoSaveUpdateUnits  iProductInfoSaveUpdateUnits;
			
		   
		      @Autowired
    @Qualifier("ProductInfoRemoveUnits")
    private ProductInfoRemoveUnits iProductInfoRemoveUnits ;
		   
			@Override
            public ProductInfo saveUpdate(OptType  optType ,   ProductInfo   optProductInfo )throws SystemOptServiceException{
        	     return 	 iProductInfoSaveUpdateUnits.saveUpdate(optType, optProductInfo);
        		}
            
       	   @Override
            public SelectPage<ProductInfo > search(OptType  optType ,    
				   ProductInfoSearchBean  searchBean , CommSearchBean  commSearchBean ,int... startLimit)throws SystemOptServiceException{
				    return  iProductInfoSearchUnits.search(optType, searchBean,
					commSearchBean ,startLimit );
            }
			
			 @Override
			public List<ProductInfo > searchList(OptType  optType ,    
				           ProductInfoSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException{
             
			  return  iProductInfoSearchUnits.list(optType, searchBean,
					commSearchBean ,startLimit );
            
    }
            
			@Override
            public  ProductInfo   remove(OptType  optType ,   ProductInfo   optProductInfo)throws SystemOptServiceException{
			      return   iProductInfoRemoveUnits.remove(optType, optProductInfo);
			  }
			  
			   @Override
            public ProductInfo get(Integer id) throws SystemOptServiceException {
                
                return baseService.get(id, ProductInfo.class) ;
            }
            
            
}
