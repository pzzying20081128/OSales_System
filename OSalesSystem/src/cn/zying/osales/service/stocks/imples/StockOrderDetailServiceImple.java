 package  cn.zying.osales.service.stocks.imples;
 

  import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockOrderDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockOrderDetailService ;
import cn.zying.osales.service.stocks.units.StockOrderDetailRemoveUnits ;
import cn.zying.osales.service.stocks.units.StockOrderDetailSaveUpdateUnits ;
import cn.zying.osales.service.stocks.units.StockOrderDetailSearchUnits ;
import cn.zying.osales.units.search.bean.StockOrderDetailSearchBean ;
 

@Component(IStockOrderDetailService.name)
public class StockOrderDetailServiceImple extends  ABCommonsService  implements IStockOrderDetailService {

            //@Resource(name="StockOrderDetailSearchUnits")
			  @Autowired
            @Qualifier("StockOrderDetailSearchUnits")        
            private  StockOrderDetailSearchUnits  iStockOrderDetailSearchUnits;
           
           //@Resource(name=" StockOrderDetailSaveUpdateUnits")
		     @Autowired
            @Qualifier("StockOrderDetailSaveUpdateUnits")      
           private StockOrderDetailSaveUpdateUnits  iStockOrderDetailSaveUpdateUnits;
			
		   
		      @Autowired
    @Qualifier("StockOrderDetailRemoveUnits")
    private StockOrderDetailRemoveUnits iStockOrderDetailRemoveUnits ;
		   
			@Override
            public StockOrderDetail saveUpdate(OptType  optType ,   StockOrderDetail   optStockOrderDetail )throws SystemOptServiceException{
        	     return 	 iStockOrderDetailSaveUpdateUnits.saveUpdate(optType, optStockOrderDetail);
        		}
            
       	   @Override
            public SelectPage<StockOrderDetail > search(OptType  optType ,    
				   StockOrderDetailSearchBean  searchBean , CommSearchBean  commSearchBean ,int... startLimit)throws SystemOptServiceException{
				    return  iStockOrderDetailSearchUnits.search(optType, searchBean,
					commSearchBean ,startLimit );
            }
			
			 @Override
			public List<StockOrderDetail > searchList(OptType  optType ,    
				           StockOrderDetailSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException{
             
			  return  iStockOrderDetailSearchUnits.list(optType, searchBean,
					commSearchBean ,startLimit );
            
    }
            
			@Override
            public  StockOrderDetail   remove(OptType  optType ,   StockOrderDetail   optStockOrderDetail)throws SystemOptServiceException{
			      return   iStockOrderDetailRemoveUnits.remove(optType, optStockOrderDetail);
			  }
			  
			   @Override
            public StockOrderDetail get(Integer id) throws SystemOptServiceException {
                
                return baseService.get(id, StockOrderDetail.class) ;
            }
            
            
}
