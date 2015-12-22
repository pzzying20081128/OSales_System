package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockContract ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockContractService ;
import cn.zying.osales.units.search.bean.StockContractSearchBean ;



@Component(IAopStockContractService.name)
public class AopStockContractService implements IAopStockContractService {

    @Autowired
    @Qualifier(IStockContractService.name)
    private IStockContractService iStockContractService ;

     public StockContract  saveUpdate(OptType  optType ,   StockContract   optStockContract )throws SystemOptServiceException{
	
	     return  iStockContractService.saveUpdate(  optType ,    optStockContract );
	 
	 }
            
       	  
     public SelectPage<StockContract > search(OptType  optType ,    
				           StockContractSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException{
	
	 return  iStockContractService.search(  optType ,    
				                                                          searchBean,  commSearchBean ,startLimit );
					
	}
	
	public List<StockContract > searchList(OptType  optType ,    
				           StockContractSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException{
             
			 return  iStockContractService.searchList(  optType ,    
				                                                          searchBean,  commSearchBean ,startLimit );
            
    }
            
    public  StockContract    remove(OptType  optType ,  StockContract   optStockContract)throws SystemOptServiceException{
			
			   return  iStockContractService.remove(  optType ,   optStockContract);
			
	}
            
            
           public  StockContract get(Integer id)throws SystemOptServiceException
		   {
		           return  iStockContractService.get( id);
		   
		   }

}
