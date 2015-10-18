package cn.zying.osales.web.aop ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProductBrand ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.baseinfo.IProductBrandService ;
import cn.zying.osales.units.search.bean.ProductBrandSearchBean ;



@Component(IAopProductBrandService.name)
public class AopProductBrandService implements IAopProductBrandService {

    @Autowired
    @Qualifier(IProductBrandService.name)
    private IProductBrandService iProductBrandService ;

     public void saveUpdate(OptType  optType ,   ProductBrand   optProductBrand )throws SystemOptServiceException{
	
	 iProductBrandService.saveUpdate(  optType ,    optProductBrand );
	 
	 }
            
       	  
     public SelectPage<ProductBrand > search(OptType  optType ,    
				           ProductBrandSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException{
	
	 return  iProductBrandService.search(  optType ,    
				                                                          searchBean,  commSearchBean ,startLimit );
					
	}
            
            
    public  void   remove(OptType  optType ,  ProductBrand   optProductBrand)throws SystemOptServiceException{
			
			   iProductBrandService.remove(  optType ,   optProductBrand);
			
	}
            
            
           public  ProductBrand get(Integer id)throws SystemOptServiceException
		   {
		           return  iProductBrandService.get(id);
		   
		   }

}
