 package  cn.zying.osales.service.sysmanage.imples;
 

  import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;
 import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.SystemUser ; 
import  cn.zying.osales.service.sysmanage.ISystemUserService ;
import cn.zying.osales.service.sysmanage.units.SystemUserSearchBean ;

import cn.zying.osales.service.sysmanage.units.SystemUserSaveUpdateUnits ;

import cn.zying.osales.service.sysmanage.units.SystemUserSearchUnits ;
 

@Component(ISystemUserService.name)
public class SystemUserServiceImple extends  ABCommonsService  implements ISystemUserService {

            //@Resource(name="SystemUserSearchUnits")
			  @Autowired
            @Qualifier("SystemUserSearchUnits")        
            private  SystemUserSearchUnits  iSystemUserSearchUnits;
           
           //@Resource(name=" SystemUserSaveUpdateUnits")
		     @Autowired
            @Qualifier("SystemUserSaveUpdateUnits")      
           private SystemUserSaveUpdateUnits  iSystemUserSaveUpdateUnits;
			
		   
		      @Autowired
    @Qualifier("SystemUserRemoveUnits")
    private SystemUserRemoveUnits iSystemUserRemoveUnits ;
		   
			@Override
            public void saveUpdate(OptType  optType ,   SystemUser   optSystemUser )throws SystemOptServiceException{
        		 iSystemUserSaveUpdateUnits.saveUpdate(optType, optSystemUser);
        		}
            
       	   @Override
            public SelectPage<SystemUser > search(OptType  optType ,    
				   SystemUserSearchBean  searchBean , CommSearchBean  commSearchBean ,int... startLimit)throws SystemOptServiceException{
				    return  iSystemUserSearchUnits.search(optType, searchBean,
					commSearchBean ,startLimit );
            }
            
			@Override
            public  void   remove(OptType  optType ,   SystemUser   optSystemUser)throws SystemOptServiceException{
			    iSystemUserRemoveUnits.remove(optType, optSystemUser);
			  }
            
            
}
