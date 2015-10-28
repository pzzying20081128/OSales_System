package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInStoreDetail ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockInStoreDetailService ;
import cn.zying.osales.units.search.bean.StockInStoreDetailSearchBean ;



@Component(IAopStockInStoreDetailService.name)
public class AopStockInStoreDetailService implements IAopStockInStoreDetailService {

    @Autowired
    @Qualifier(IStockInStoreDetailService.name)
    private IStockInStoreDetailService iStockInStoreDetailService ;

     public StockInStoreDetail  saveUpdate(OptType  optType ,   StockInStoreDetail   optStockInStoreDetail )throws SystemOptServiceException{
	
	     return  iStockInStoreDetailService.saveUpdate(  optType ,    optStockInStoreDetail );
	 
	 }
            
       	  
     public SelectPage<StockInStoreDetail > search(OptType  optType ,    
				           StockInStoreDetailSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException{
	
	 return  iStockInStoreDetailService.search(  optType ,    
				                                                          searchBean,  commSearchBean ,startLimit );
					
	}
	
	public List<StockInStoreDetail > searchList(OptType  optType ,    
				           StockInStoreDetailSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException{
             
			 return  iStockInStoreDetailService.searchList(  optType ,    
				                                                          searchBean,  commSearchBean ,startLimit );
            
    }
            
    public  StockInStoreDetail    remove(OptType  optType ,  StockInStoreDetail   optStockInStoreDetail)throws SystemOptServiceException{
			
			   return  iStockInStoreDetailService.remove(  optType ,   optStockInStoreDetail);
			
	}
            
            
           public  StockInStoreDetail get(Integer id)throws SystemOptServiceException
		   {
		           return  iStockInStoreDetailService.get( id);
		   
		   }

}
