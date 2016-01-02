package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockAdjustBill ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockAdjustBillService ;
import cn.zying.osales.units.search.bean.StockAdjustBillSearchBean ;



@Component(IAopStockAdjustBillService.name)
public class AopStockAdjustBillService implements IAopStockAdjustBillService {

    @Autowired
    @Qualifier(IStockAdjustBillService.name)
    private IStockAdjustBillService iStockAdjustBillService ;

     public StockAdjustBill  saveUpdate(OptType  optType ,   StockAdjustBill   optStockAdjustBill )throws SystemOptServiceException{
	
	     return  iStockAdjustBillService.saveUpdate(  optType ,    optStockAdjustBill );
	 
	 }
            
       	  
     public SelectPage<StockAdjustBill > search(OptType  optType ,    
				           StockAdjustBillSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException{
	
	 return  iStockAdjustBillService.search(  optType ,    
				                                                          searchBean,  commSearchBean ,startLimit );
					
	}
	
	public List<StockAdjustBill > searchList(OptType  optType ,    
				           StockAdjustBillSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException{
             
			 return  iStockAdjustBillService.searchList(  optType ,    
				                                                          searchBean,  commSearchBean ,startLimit );
            
    }
            
    public  StockAdjustBill    remove(OptType  optType ,  StockAdjustBill   optStockAdjustBill)throws SystemOptServiceException{
			
			   return  iStockAdjustBillService.remove(  optType ,   optStockAdjustBill);
			
	}
            
            
           public  StockAdjustBill get(Integer id)throws SystemOptServiceException
		   {
		           return  iStockAdjustBillService.get( id);
		   
		   }

}
