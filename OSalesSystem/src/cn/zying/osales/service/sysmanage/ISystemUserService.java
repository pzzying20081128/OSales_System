 package  cn.zying.osales.service.sysmanage;

 
 
 import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.powers.UserOptPower ;
import cn.zy.apps.tools.units.powers.UserPower ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.sysmanage.units.SystemUserSearchBean ;

public interface ISystemUserService {
    
            public String name="ISystemUserService";
            
            public String aop_name="AopISystemUserService";
            
                
            /**
             *  增加或更新
             */
            public void saveUpdate(OptType  optType ,   SysStaffUser   optSystemUser )throws SystemOptServiceException;
            
       	  
            public SelectPage<SysStaffUser > search(OptType  optType ,    
				           SystemUserSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException;
            
            
            public  void   remove(OptType  optType ,  SysStaffUser   optSystemUser)throws SystemOptServiceException;
            
            
           public SysStaffUser get(Integer id)throws SystemOptServiceException;
           
           public SysStaffUser  searchByAccessName(String accessName)throws SystemOptServiceException;
            
           public List<String> listUserModulePowerBySysUserId(String loginUserId) throws Exception ;
           
           public   List<UserPower<UserOptPower>>  searchUserPower(String moduleId ,String loginUserId ) throws Exception;
            

}
