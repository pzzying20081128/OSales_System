 package  cn.zying.osales.service.stocks.imples;
 

  import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockAdjustBill ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockAdjustBillService ;
import cn.zying.osales.service.stocks.units.StockAdjustBillRemoveUnits ;
import cn.zying.osales.service.stocks.units.StockAdjustBillSaveUpdateUnits ;
import cn.zying.osales.service.stocks.units.StockAdjustBillSearchUnits ;
import cn.zying.osales.units.search.bean.StockAdjustBillSearchBean ;
 

@Component(IStockAdjustBillService.name)
public class StockAdjustBillServiceImple extends  ABCommonsService  implements IStockAdjustBillService {

            //@Resource(name="StockAdjustBillSearchUnits")
			  @Autowired
            @Qualifier("StockAdjustBillSearchUnits")        
            private  StockAdjustBillSearchUnits  iStockAdjustBillSearchUnits;
           
           //@Resource(name=" StockAdjustBillSaveUpdateUnits")
		     @Autowired
            @Qualifier("StockAdjustBillSaveUpdateUnits")      
           private StockAdjustBillSaveUpdateUnits  iStockAdjustBillSaveUpdateUnits;
			
		   
		      @Autowired
    @Qualifier("StockAdjustBillRemoveUnits")
    private StockAdjustBillRemoveUnits iStockAdjustBillRemoveUnits ;
		   
			@Override
            public StockAdjustBill saveUpdate(OptType  optType ,   StockAdjustBill   optStockAdjustBill )throws SystemOptServiceException{
        	     return 	 iStockAdjustBillSaveUpdateUnits.saveUpdate(optType, optStockAdjustBill);
        		}
            
       	   @Override
            public SelectPage<StockAdjustBill > search(OptType  optType ,    
				   StockAdjustBillSearchBean  searchBean , CommSearchBean  commSearchBean ,int... startLimit)throws SystemOptServiceException{
				    return  iStockAdjustBillSearchUnits.search(optType, searchBean,
					commSearchBean ,startLimit );
            }
			
			 @Override
			public List<StockAdjustBill > searchList(OptType  optType ,    
				           StockAdjustBillSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException{
             
			  return  iStockAdjustBillSearchUnits.list(optType, searchBean,
					commSearchBean ,startLimit );
            
    }
            
			@Override
            public  StockAdjustBill   remove(OptType  optType ,   StockAdjustBill   optStockAdjustBill)throws SystemOptServiceException{
			      return   iStockAdjustBillRemoveUnits.remove(optType, optStockAdjustBill);
			  }
			  
			   @Override
            public StockAdjustBill get(Integer id) throws SystemOptServiceException {
                
                return baseService.get(id, StockAdjustBill.class) ;
            }
            
            
}
