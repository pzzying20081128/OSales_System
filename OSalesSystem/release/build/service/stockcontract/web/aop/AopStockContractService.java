package cn.zy.apps.tools.dev.service.template ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;



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
