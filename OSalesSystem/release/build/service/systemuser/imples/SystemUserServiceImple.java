 package  cn.zying.osales.service.sysmanage.imples;
 

  import org.springframework.stereotype.Component ;
 import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.SystemUser ; 
import  cn.zying.osales.service.sysmanage.ISystemUserService ;
import cn.zying.osales.service.sysmanage.units.SystemUserSearchBean ;

import cn.zying.osales.service.sysmanage.units.SystemUserSaveUpdateUnits ;

import cn.zying.osales.service.sysmanage.units.SystemUserSearchUnits ;
 

@Component(ISystemUserService.name)
public class SystemUserServiceImple extends  ABCommonsService  implements ISystemUserService {

            @Resource(name=" SystemUserSearchUnits")
            private  SystemUserSearchUnits  iSystemUserSearchUnits;
           
           @Resource(name=" SystemUserSaveUpdateUnits")
           private SystemUserSaveUpdateUnits  iSystemUserSaveUpdateUnits;
			
			@Override
            public void saveUpdate(OptType  optType ,   SystemUser   optSystemUser )throws SystemOptServiceException{
        		 iSystemUserSaveUpdateUnits.saveUpdate(optType, optSystemUser);
        		}
            
       	   @Override
            public SelectPage<SystemUser > search(OptType  optType ,    SystemUserSearchBean  searchBean )throws SystemOptServiceException{
				    return  iSystemUserSearchUnits.search(optType, searchBean);
            }
            
			@Override
            public  void   remove(OptType  optType ,   SystemUser   optSystemUser)throws SystemOptServiceException{
			  
			  }
            
            
}
