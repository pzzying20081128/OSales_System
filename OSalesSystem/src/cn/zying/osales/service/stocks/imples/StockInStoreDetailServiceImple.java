 package  cn.zying.osales.service.stocks.imples;
 

  import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInStoreDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockInStoreDetailService ;
import cn.zying.osales.service.stocks.units.StockInStoreDetailRemoveUnits ;
import cn.zying.osales.service.stocks.units.StockInStoreDetailSaveUpdateUnits ;
import cn.zying.osales.service.stocks.units.StockInStoreDetailSearchUnits ;
import cn.zying.osales.units.search.bean.StockInStoreDetailSearchBean ;
 

@Component(IStockInStoreDetailService.name)
public class StockInStoreDetailServiceImple extends  ABCommonsService  implements IStockInStoreDetailService {

            //@Resource(name="StockInStoreDetailSearchUnits")
			  @Autowired
            @Qualifier("StockInStoreDetailSearchUnits")        
            private  StockInStoreDetailSearchUnits  iStockInStoreDetailSearchUnits;
           
           //@Resource(name=" StockInStoreDetailSaveUpdateUnits")
		     @Autowired
            @Qualifier("StockInStoreDetailSaveUpdateUnits")      
           private StockInStoreDetailSaveUpdateUnits  iStockInStoreDetailSaveUpdateUnits;
			
		   
		      @Autowired
    @Qualifier("StockInStoreDetailRemoveUnits")
    private StockInStoreDetailRemoveUnits iStockInStoreDetailRemoveUnits ;
		   
			@Override
            public StockInStoreDetail saveUpdate(OptType  optType ,   StockInStoreDetail   optStockInStoreDetail )throws SystemOptServiceException{
        	     return 	 iStockInStoreDetailSaveUpdateUnits.saveUpdate(optType, optStockInStoreDetail);
        		}
            
       	   @Override
            public SelectPage<StockInStoreDetail > search(OptType  optType ,    
				   StockInStoreDetailSearchBean  searchBean , CommSearchBean  commSearchBean ,int... startLimit)throws SystemOptServiceException{
				    return  iStockInStoreDetailSearchUnits.search(optType, searchBean,
					commSearchBean ,startLimit );
            }
			
			 @Override
			public List<StockInStoreDetail > searchList(OptType  optType ,    
				           StockInStoreDetailSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException{
             
			  return  iStockInStoreDetailSearchUnits.list(optType, searchBean,
					commSearchBean ,startLimit );
            
    }
            
			@Override
            public  StockInStoreDetail   remove(OptType  optType ,   StockInStoreDetail   optStockInStoreDetail)throws SystemOptServiceException{
			      return   iStockInStoreDetailRemoveUnits.remove(optType, optStockInStoreDetail);
			  }
			  
			   @Override
            public StockInStoreDetail get(Integer id) throws SystemOptServiceException {
                
                return baseService.get(id, StockInStoreDetail.class) ;
            }
            
            
}
