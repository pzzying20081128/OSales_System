 package  cn.zying.osales.service.basemanage.imples;;
 

 
 import cn.zy.apps.tools.web.SelectPage ;

import cn.zying.osales.pojos.SystemUser ; 

import  cn.zying.osales.service.basemanage.ISystemUserService ;

import cn.zying.osales.service.basemanage.units.SystemUserSearchBean ;
 

@Component(ISystemUserService.name)
public class SystemUserServiceImple extends  ABCommonsService  implements ISystemUserService {

            @Override
            public void saveUpdate(OptType  optType ,   SystemUser   optSystemUser )throws SystemOptServiceException{
        		
        		}
            
       	   @Override
            public SelectPage<SystemUser > search(OptType  optType ,    SystemUserSearchBean  searchBean )throws SystemOptServiceException{
				  
            }
            
			@Override
            public  void   remove(OptType  optType ,   SystemUser   optSystemUser)throws SystemOptServiceException{
			  
			  }
            
            
}
