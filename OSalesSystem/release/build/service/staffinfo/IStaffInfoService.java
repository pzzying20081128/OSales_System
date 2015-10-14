 package  cn.zying.osales.service.basemanage;

 
 
 import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.StaffInfo ; 
import cn.zying.osales.service.basemanage.units.StaffInfoSearchBean ;

public interface IStaffInfoService {
    
            public String name="IStaffInfoService";
            
                
            /**
             *  增加或更新
             */
            public void saveUpdate(OptType  optType ,   StaffInfo   optStaffInfo )throws SystemOptServiceException;
            
       	  
            public SelectPage<StaffInfo > search(OptType  optType ,    
				           StaffInfoSearchBean  searchBean,CommSearchBean  commSearchBean ,int... startLimit )throws SystemOptServiceException;
            
            
            public  void   remove(OptType  optType ,  StaffInfo   optStaffInfo)throws SystemOptServiceException;
            
            
           
            
            
            

}
