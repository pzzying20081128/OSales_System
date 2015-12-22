 package  cn.zying.osales.service.stocks.imples;
 

  import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;
 import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.StockInvoiceDetail ; 
import  cn.zying.osales.service.stocks.IStockInvoiceDetailService ;
import cn.zying.osales.service.stocks.units.StockInvoiceDetailSearchBean ;

import cn.zying.osales.service.stocks.units.StockInvoiceDetailSaveUpdateUnits ;

import cn.zying.osales.service.stocks.units.StockInvoiceDetailSearchUnits ;
 

@Component(IStockInvoiceDetailService.name)
public class StockInvoiceDetailServiceImple extends  ABCommonsService  implements IStockInvoiceDetailService {

            //@Resource(name="StockInvoiceDetailSearchUnits")
			  @Autowired
            @Qualifier("StockInvoiceDetailSearchUnits")        
            private  StockInvoiceDetailSearchUnits  iStockInvoiceDetailSearchUnits;
           
           //@Resource(name=" StockInvoiceDetailSaveUpdateUnits")
		     @Autowired
            @Qualifier("StockInvoiceDetailSaveUpdateUnits")      
           private StockInvoiceDetailSaveUpdateUnits  iStockInvoiceDetailSaveUpdateUnits;
			
		   
		      @Autowired
    @Qualifier("StockInvoiceDetailRemoveUnits")
    private StockInvoiceDetailRemoveUnits iStockInvoiceDetailRemoveUnits ;
		   
			@Override
            public StockInvoiceDetail saveUpdate(OptType  optType ,   StockInvoiceDetail   optStockInvoiceDetail )throws SystemOptServiceException{
        	     return 	 iStockInvoiceDetailSaveUpdateUnits.saveUpdate(optType, optStockInvoiceDetail);
        		}
            
       	   @Override
            public SelectPage<StockInvoiceDetail > search(OptType  optType ,    
				   StockInvoiceDetailSearchBean  searchBean , CommSearchBean  commSearchBean ,int... startLimit)throws SystemOptServiceException{
				    return  iStockInvoiceDetailSearchUnits.search(optType, searchBean,
					commSearchBean ,startLimit );
            }
			
			 @Override
			public List<StockInvoiceDetail > searchList(OptType  optType ,    
				           StockInvoiceDetailSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException{
             
			  return  iStockInvoiceDetailSearchUnits.list(optType, searchBean,
					commSearchBean ,startLimit );
            
    }
            
			@Override
            public  StockInvoiceDetail   remove(OptType  optType ,   StockInvoiceDetail   optStockInvoiceDetail)throws SystemOptServiceException{
			      return   iStockInvoiceDetailRemoveUnits.remove(optType, optStockInvoiceDetail);
			  }
			  
			   @Override
            public StockInvoiceDetail get(Integer id) throws SystemOptServiceException {
                
                return baseService.get(id, StockInvoiceDetail.class) ;
            }
            
            
}
