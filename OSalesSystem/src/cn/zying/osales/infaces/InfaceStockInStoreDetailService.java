package cn.zying.osales.infaces;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInStoreDetail ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockInStoreDetailSearchBean ;

public interface InfaceStockInStoreDetailService {
    
    
       /**
             *  增加或更新
             */
            public StockInStoreDetail   saveUpdate(OptType  optType ,   StockInStoreDetail   optStockInStoreDetail )throws SystemOptServiceException;
            
       	  
            public SelectPage<StockInStoreDetail > search(OptType  optType ,    
				           StockInStoreDetailSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException;
            
			public List<StockInStoreDetail > searchList(OptType  optType ,    
				           StockInStoreDetailSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException;
            
            public  StockInStoreDetail    remove(OptType  optType ,  StockInStoreDetail   optStockInStoreDetail)throws SystemOptServiceException;
            
            
           public  StockInStoreDetail get(Integer id)throws SystemOptServiceException;


}
