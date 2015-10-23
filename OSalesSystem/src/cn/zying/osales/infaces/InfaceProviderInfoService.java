package cn.zying.osales.infaces;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProviderInfo ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.ProviderInfoSearchBean ;

public interface InfaceProviderInfoService {
    
    
       /**
             *  增加或更新
             */
            public ProviderInfo   saveUpdate(OptType  optType ,   ProviderInfo   optProviderInfo )throws SystemOptServiceException;
            
       	  
            public SelectPage<ProviderInfo > search(OptType  optType ,    
				           ProviderInfoSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException;
            
			public List<ProviderInfo > searchList(OptType  optType ,    
				           ProviderInfoSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException;
            
            public  ProviderInfo    remove(OptType  optType ,  ProviderInfo   optProviderInfo)throws SystemOptServiceException;
            
            
           public  ProviderInfo get(Integer id)throws SystemOptServiceException;


}
