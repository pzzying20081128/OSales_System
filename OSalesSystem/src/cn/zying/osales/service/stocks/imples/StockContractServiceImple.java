 package  cn.zying.osales.service.stocks.imples;
 

  import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockContract ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockContractService ;
import cn.zying.osales.service.stocks.units.StockContractRemoveUnits ;
import cn.zying.osales.service.stocks.units.StockContractSaveUpdateUnits ;
import cn.zying.osales.service.stocks.units.StockContractSearchUnits ;
import cn.zying.osales.units.search.bean.StockContractSearchBean ;
 

@Component(IStockContractService.name)
public class StockContractServiceImple extends  ABCommonsService  implements IStockContractService {

            //@Resource(name="StockContractSearchUnits")
			  @Autowired
            @Qualifier("StockContractSearchUnits")        
            private  StockContractSearchUnits  iStockContractSearchUnits;
           
           //@Resource(name=" StockContractSaveUpdateUnits")
		     @Autowired
            @Qualifier("StockContractSaveUpdateUnits")      
           private StockContractSaveUpdateUnits  iStockContractSaveUpdateUnits;
			
		   
		      @Autowired
    @Qualifier("StockContractRemoveUnits")
    private StockContractRemoveUnits iStockContractRemoveUnits ;
		   
			@Override
            public StockContract saveUpdate(OptType  optType ,   StockContract   optStockContract )throws SystemOptServiceException{
        	     return 	 iStockContractSaveUpdateUnits.saveUpdate(optType, optStockContract);
        		}
            
       	   @Override
            public SelectPage<StockContract > search(OptType  optType ,    
				   StockContractSearchBean  searchBean , CommSearchBean  commSearchBean ,int... startLimit)throws SystemOptServiceException{
				    return  iStockContractSearchUnits.search(optType, searchBean,
					commSearchBean ,startLimit );
            }
			
			 @Override
			public List<StockContract > searchList(OptType  optType ,    
				           StockContractSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException{
             
			  return  iStockContractSearchUnits.list(optType, searchBean,
					commSearchBean ,startLimit );
            
    }
            
			@Override
            public  StockContract   remove(OptType  optType ,   StockContract   optStockContract)throws SystemOptServiceException{
			      return   iStockContractRemoveUnits.remove(optType, optStockContract);
			  }
			  
			   @Override
            public StockContract get(Integer id) throws SystemOptServiceException {
                
                return baseService.get(id, StockContract.class) ;
            }
            
            
}
