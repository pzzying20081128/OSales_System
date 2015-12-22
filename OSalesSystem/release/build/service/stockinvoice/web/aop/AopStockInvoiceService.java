package cn.zy.apps.tools.dev.service.template ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;



@Component(IAopStockInvoiceService.name)
public class AopStockInvoiceService implements IAopStockInvoiceService {

    @Autowired
    @Qualifier(IStockInvoiceService.name)
    private IStockInvoiceService iStockInvoiceService ;

     public StockInvoice  saveUpdate(OptType  optType ,   StockInvoice   optStockInvoice )throws SystemOptServiceException{
	
	     return  iStockInvoiceService.saveUpdate(  optType ,    optStockInvoice );
	 
	 }
            
       	  
     public SelectPage<StockInvoice > search(OptType  optType ,    
				           StockInvoiceSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException{
	
	 return  iStockInvoiceService.search(  optType ,    
				                                                          searchBean,  commSearchBean ,startLimit );
					
	}
	
	public List<StockInvoice > searchList(OptType  optType ,    
				           StockInvoiceSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException{
             
			 return  iStockInvoiceService.searchList(  optType ,    
				                                                          searchBean,  commSearchBean ,startLimit );
            
    }
            
    public  StockInvoice    remove(OptType  optType ,  StockInvoice   optStockInvoice)throws SystemOptServiceException{
			
			   return  iStockInvoiceService.remove(  optType ,   optStockInvoice);
			
	}
            
            
           public  StockInvoice get(Integer id)throws SystemOptServiceException
		   {
		           return  iStockInvoiceService.get( id);
		   
		   }

}
