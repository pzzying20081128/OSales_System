package cn.zy.apps.tools.dev.service.template ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;



@Component(IAopStockInvoiceDetailService.name)
public class AopStockInvoiceDetailService implements IAopStockInvoiceDetailService {

    @Autowired
    @Qualifier(IStockInvoiceDetailService.name)
    private IStockInvoiceDetailService iStockInvoiceDetailService ;

     public StockInvoiceDetail  saveUpdate(OptType  optType ,   StockInvoiceDetail   optStockInvoiceDetail )throws SystemOptServiceException{
	
	     return  iStockInvoiceDetailService.saveUpdate(  optType ,    optStockInvoiceDetail );
	 
	 }
            
       	  
     public SelectPage<StockInvoiceDetail > search(OptType  optType ,    
				           StockInvoiceDetailSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException{
	
	 return  iStockInvoiceDetailService.search(  optType ,    
				                                                          searchBean,  commSearchBean ,startLimit );
					
	}
	
	public List<StockInvoiceDetail > searchList(OptType  optType ,    
				           StockInvoiceDetailSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException{
             
			 return  iStockInvoiceDetailService.searchList(  optType ,    
				                                                          searchBean,  commSearchBean ,startLimit );
            
    }
            
    public  StockInvoiceDetail    remove(OptType  optType ,  StockInvoiceDetail   optStockInvoiceDetail)throws SystemOptServiceException{
			
			   return  iStockInvoiceDetailService.remove(  optType ,   optStockInvoiceDetail);
			
	}
            
            
           public  StockInvoiceDetail get(Integer id)throws SystemOptServiceException
		   {
		           return  iStockInvoiceDetailService.get( id);
		   
		   }

}
