package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockReturnStoreOutDetail ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockReturnStoreOutDetailService ;
import cn.zying.osales.units.search.bean.StockReturnStoreOutDetailSearchBean ;



@Component(IAopStockReturnStoreOutDetailService.name)
public class AopStockReturnStoreOutDetailService implements IAopStockReturnStoreOutDetailService {

    @Autowired
    @Qualifier(IStockReturnStoreOutDetailService.name)
    private IStockReturnStoreOutDetailService iStockReturnStoreOutDetailService ;

     public StockReturnStoreOutDetail  saveUpdate(OptType  optType ,   StockReturnStoreOutDetail   optStockReturnStoreOutDetail )throws SystemOptServiceException{
	
	     return  iStockReturnStoreOutDetailService.saveUpdate(  optType ,    optStockReturnStoreOutDetail );
	 
	 }
            
       	  
     public SelectPage<StockReturnStoreOutDetail > search(OptType  optType ,    
				           StockReturnStoreOutDetailSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException{
	
	 return  iStockReturnStoreOutDetailService.search(  optType ,    
				                                                          searchBean,  commSearchBean ,startLimit );
					
	}
	
	public List<StockReturnStoreOutDetail > searchList(OptType  optType ,    
				           StockReturnStoreOutDetailSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException{
             
			 return  iStockReturnStoreOutDetailService.searchList(  optType ,    
				                                                          searchBean,  commSearchBean ,startLimit );
            
    }
            
    public  StockReturnStoreOutDetail    remove(OptType  optType ,  StockReturnStoreOutDetail   optStockReturnStoreOutDetail)throws SystemOptServiceException{
			
			   return  iStockReturnStoreOutDetailService.remove(  optType ,   optStockReturnStoreOutDetail);
			
	}
            
            
           public  StockReturnStoreOutDetail get(Integer id)throws SystemOptServiceException
		   {
		           return  iStockReturnStoreOutDetailService.get( id);
		   
		   }

}
