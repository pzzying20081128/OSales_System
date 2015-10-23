package cn.zying.osales.infaces;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StoreInfo ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StoreInfoSearchBean ;

public interface InfaceStoreInfoService {
    
    
       /**
             *  增加或更新
             */
            public StoreInfo   saveUpdate(OptType  optType ,   StoreInfo   optStoreInfo )throws SystemOptServiceException;
            
       	  
            public SelectPage<StoreInfo > search(OptType  optType ,    
				           StoreInfoSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException;
            
			public List<StoreInfo > searchList(OptType  optType ,    
				           StoreInfoSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException;
            
            public  StoreInfo    remove(OptType  optType ,  StoreInfo   optStoreInfo)throws SystemOptServiceException;
            
            
           public  StoreInfo get(Integer id)throws SystemOptServiceException;


}
