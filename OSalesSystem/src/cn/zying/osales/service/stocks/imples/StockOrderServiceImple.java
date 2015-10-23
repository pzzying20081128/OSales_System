 package  cn.zying.osales.service.stocks.imples;
 

  import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockOrder ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockOrderService ;
import cn.zying.osales.service.stocks.units.StockOrderRemoveUnits ;
import cn.zying.osales.service.stocks.units.StockOrderSaveUpdateUnits ;
import cn.zying.osales.service.stocks.units.StockOrderSearchUnits ;
import cn.zying.osales.units.search.bean.StockOrderSearchBean ;
 

@Component(IStockOrderService.name)
public class StockOrderServiceImple extends  ABCommonsService  implements IStockOrderService {

            //@Resource(name="StockOrderSearchUnits")
			  @Autowired
            @Qualifier("StockOrderSearchUnits")        
            private  StockOrderSearchUnits  iStockOrderSearchUnits;
           
           //@Resource(name=" StockOrderSaveUpdateUnits")
		     @Autowired
            @Qualifier("StockOrderSaveUpdateUnits")      
           private StockOrderSaveUpdateUnits  iStockOrderSaveUpdateUnits;
			
		   
		      @Autowired
    @Qualifier("StockOrderRemoveUnits")
    private StockOrderRemoveUnits iStockOrderRemoveUnits ;
		   
			@Override
            public StockOrder saveUpdate(OptType  optType ,   StockOrder   optStockOrder )throws SystemOptServiceException{
        	     return 	 iStockOrderSaveUpdateUnits.saveUpdate(optType, optStockOrder);
        		}
            
       	   @Override
            public SelectPage<StockOrder > search(OptType  optType ,    
				   StockOrderSearchBean  searchBean , CommSearchBean  commSearchBean ,int... startLimit)throws SystemOptServiceException{
				    return  iStockOrderSearchUnits.search(optType, searchBean,
					commSearchBean ,startLimit );
            }
			
			 @Override
			public List<StockOrder > searchList(OptType  optType ,    
				           StockOrderSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException{
             
			  return  iStockOrderSearchUnits.list(optType, searchBean,
					commSearchBean ,startLimit );
            
    }
            
			@Override
            public  StockOrder   remove(OptType  optType ,   StockOrder   optStockOrder)throws SystemOptServiceException{
			      return   iStockOrderRemoveUnits.remove(optType, optStockOrder);
			  }
			  
			   @Override
            public StockOrder get(Integer id) throws SystemOptServiceException {
                
                return baseService.get(id, StockOrder.class) ;
            }
            
            
}
