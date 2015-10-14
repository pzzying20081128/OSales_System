 package  cn.zying.osales.service.sysmanage;

 
 
 import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.SystemUser ; 
import cn.zying.osales.service.sysmanage.units.SystemUserSearchBean ;

public interface ISystemUserService {
    
            public String name="ISystemUserService";
            
                
            /**
             *  增加或更新
             */
            public void saveUpdate(OptType  optType ,   SystemUser   optSystemUser )throws SystemOptServiceException;
            
       	  
            public SelectPage<SystemUser > search(OptType  optType ,    
				           SystemUserSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException;
            
            
            public  void   remove(OptType  optType ,  SystemUser   optSystemUser)throws SystemOptServiceException;
            
            
           
            
            
            

}
