 package  cn.zying.osales.service.stocks.imples;
 

  import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;
 import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.StockInvoice ; 
import  cn.zying.osales.service.stocks.IStockInvoiceService ;
import cn.zying.osales.service.stocks.units.StockInvoiceSearchBean ;

import cn.zying.osales.service.stocks.units.StockInvoiceSaveUpdateUnits ;

import cn.zying.osales.service.stocks.units.StockInvoiceSearchUnits ;
 

@Component(IStockInvoiceService.name)
public class StockInvoiceServiceImple extends  ABCommonsService  implements IStockInvoiceService {

            //@Resource(name="StockInvoiceSearchUnits")
			  @Autowired
            @Qualifier("StockInvoiceSearchUnits")        
            private  StockInvoiceSearchUnits  iStockInvoiceSearchUnits;
           
           //@Resource(name=" StockInvoiceSaveUpdateUnits")
		     @Autowired
            @Qualifier("StockInvoiceSaveUpdateUnits")      
           private StockInvoiceSaveUpdateUnits  iStockInvoiceSaveUpdateUnits;
			
		   
		      @Autowired
    @Qualifier("StockInvoiceRemoveUnits")
    private StockInvoiceRemoveUnits iStockInvoiceRemoveUnits ;
		   
			@Override
            public StockInvoice saveUpdate(OptType  optType ,   StockInvoice   optStockInvoice )throws SystemOptServiceException{
        	     return 	 iStockInvoiceSaveUpdateUnits.saveUpdate(optType, optStockInvoice);
        		}
            
       	   @Override
            public SelectPage<StockInvoice > search(OptType  optType ,    
				   StockInvoiceSearchBean  searchBean , CommSearchBean  commSearchBean ,int... startLimit)throws SystemOptServiceException{
				    return  iStockInvoiceSearchUnits.search(optType, searchBean,
					commSearchBean ,startLimit );
            }
			
			 @Override
			public List<StockInvoice > searchList(OptType  optType ,    
				           StockInvoiceSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException{
             
			  return  iStockInvoiceSearchUnits.list(optType, searchBean,
					commSearchBean ,startLimit );
            
    }
            
			@Override
            public  StockInvoice   remove(OptType  optType ,   StockInvoice   optStockInvoice)throws SystemOptServiceException{
			      return   iStockInvoiceRemoveUnits.remove(optType, optStockInvoice);
			  }
			  
			   @Override
            public StockInvoice get(Integer id) throws SystemOptServiceException {
                
                return baseService.get(id, StockInvoice.class) ;
            }
            
            
}
