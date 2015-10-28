package cn.zying.osales.infaces;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInStore ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockInStoreSearchBean ;

public interface InfaceStockInStoreService {
    
    
       /**
             *  增加或更新
             */
            public StockInStore   saveUpdate(OptType  optType ,   StockInStore   optStockInStore )throws SystemOptServiceException;
            
       	  
            public SelectPage<StockInStore > search(OptType  optType ,    
				           StockInStoreSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException;
            
			public List<StockInStore > searchList(OptType  optType ,    
				           StockInStoreSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException;
            
            public  StockInStore    remove(OptType  optType ,  StockInStore   optStockInStore)throws SystemOptServiceException;
            
            
           public  StockInStore get(Integer id)throws SystemOptServiceException;


}
