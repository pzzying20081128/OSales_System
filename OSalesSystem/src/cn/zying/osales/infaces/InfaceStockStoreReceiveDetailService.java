package cn.zying.osales.infaces;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockStoreReceiveDetail ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockStoreReceiveDetailSearchBean ;

public interface InfaceStockStoreReceiveDetailService {
    
    
       /**
             *  增加或更新
             */
            public StockStoreReceiveDetail   saveUpdate(OptType  optType ,   StockStoreReceiveDetail   optStockStoreReceiveDetail )throws SystemOptServiceException;
            
       	  
            public SelectPage<StockStoreReceiveDetail > search(OptType  optType ,    
				           StockStoreReceiveDetailSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException;
            
			public List<StockStoreReceiveDetail > searchList(OptType  optType ,    
				           StockStoreReceiveDetailSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException;
            
            public  StockStoreReceiveDetail    remove(OptType  optType ,  StockStoreReceiveDetail   optStockStoreReceiveDetail)throws SystemOptServiceException;
            
            
           public  StockStoreReceiveDetail get(Integer id)throws SystemOptServiceException;


}
