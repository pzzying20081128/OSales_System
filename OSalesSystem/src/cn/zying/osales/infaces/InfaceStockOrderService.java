package cn.zying.osales.infaces;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockOrder ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockOrderSearchBean ;

public interface InfaceStockOrderService {
    
    
       /**
             *  增加或更新
             */
            public StockOrder   saveUpdate(OptType  optType ,   StockOrder   optStockOrder )throws SystemOptServiceException;
            
       	  
            public SelectPage<StockOrder > search(OptType  optType ,    
				           StockOrderSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException;
            
			public List<StockOrder > searchList(OptType  optType ,    
				           StockOrderSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException;
            
            public  StockOrder    remove(OptType  optType ,  StockOrder   optStockOrder)throws SystemOptServiceException;
            
            
           public  StockOrder get(Integer id)throws SystemOptServiceException;


}
