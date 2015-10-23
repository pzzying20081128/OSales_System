 package  cn.zying.osales.service.baseinfo.imples;
 

  import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProviderInfo ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.IProviderInfoService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.baseinfo.units.ProviderInfoRemoveUnits ;
import cn.zying.osales.service.baseinfo.units.ProviderInfoSaveUpdateUnits ;
import cn.zying.osales.service.baseinfo.units.ProviderInfoSearchUnits ;
import cn.zying.osales.units.search.bean.ProviderInfoSearchBean ;
 

@Component(IProviderInfoService.name)
public class ProviderInfoServiceImple extends  ABCommonsService  implements IProviderInfoService {

            //@Resource(name="ProviderInfoSearchUnits")
			  @Autowired
            @Qualifier("ProviderInfoSearchUnits")        
            private  ProviderInfoSearchUnits  iProviderInfoSearchUnits;
           
           //@Resource(name=" ProviderInfoSaveUpdateUnits")
		     @Autowired
            @Qualifier("ProviderInfoSaveUpdateUnits")      
           private ProviderInfoSaveUpdateUnits  iProviderInfoSaveUpdateUnits;
			
		   
		      @Autowired
    @Qualifier("ProviderInfoRemoveUnits")
    private ProviderInfoRemoveUnits iProviderInfoRemoveUnits ;
		   
			@Override
            public ProviderInfo saveUpdate(OptType  optType ,   ProviderInfo   optProviderInfo )throws SystemOptServiceException{
        	     return 	 iProviderInfoSaveUpdateUnits.saveUpdate(optType, optProviderInfo);
        		}
            
       	   @Override
            public SelectPage<ProviderInfo > search(OptType  optType ,    
				   ProviderInfoSearchBean  searchBean , CommSearchBean  commSearchBean ,int... startLimit)throws SystemOptServiceException{
				    return  iProviderInfoSearchUnits.search(optType, searchBean,
					commSearchBean ,startLimit );
            }
			
			 @Override
			public List<ProviderInfo > searchList(OptType  optType ,    
				           ProviderInfoSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException{
             
			  return  iProviderInfoSearchUnits.list(optType, searchBean,
					commSearchBean ,startLimit );
            
    }
            
			@Override
            public  ProviderInfo   remove(OptType  optType ,   ProviderInfo   optProviderInfo)throws SystemOptServiceException{
			      return   iProviderInfoRemoveUnits.remove(optType, optProviderInfo);
			  }
			  
			   @Override
            public ProviderInfo get(Integer id) throws SystemOptServiceException {
                
                return baseService.get(id, ProviderInfo.class) ;
            }
            
            
}
