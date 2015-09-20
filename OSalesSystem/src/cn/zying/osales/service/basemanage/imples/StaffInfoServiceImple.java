 package  cn.zying.osales.service.basemanage.imples;
 

  import javax.annotation.Resource ;

import org.springframework.stereotype.Component ;
 import cn.zy.apps.tools.web.SelectPage ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StaffInfo ; 

import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import  cn.zying.osales.service.basemanage.IStaffInfoService ;

import cn.zying.osales.service.basemanage.units.StaffInfoSaveUpdateUnits ;
import cn.zying.osales.service.basemanage.units.StaffInfoSearchBean ;
import cn.zying.osales.service.basemanage.units.StaffInfoSearchUnits ;
 

@Component(IStaffInfoService.name)
public class StaffInfoServiceImple extends  ABCommonsService  implements IStaffInfoService {
    
           @Resource(name="StaffInfoSearchUnits")
            private StaffInfoSearchUnits  iStaffInfoSearchUnits;
           
           @Resource(name="StaffInfoSaveUpdateUnits")
           private StaffInfoSaveUpdateUnits  iStaffInfoSaveUpdateUnits;

            @Override
            public void saveUpdate(OptType  optType ,   StaffInfo   optStaffInfo )throws SystemOptServiceException{
                iStaffInfoSaveUpdateUnits.saveUpdate(optType, optStaffInfo);
        		}
            
       	   @Override
            public SelectPage<StaffInfo > search(OptType  optType ,    StaffInfoSearchBean  searchBean )throws SystemOptServiceException{
				  return iStaffInfoSearchUnits.search(optType, searchBean);
            }
            
			@Override
            public  void   remove(OptType  optType ,   StaffInfo   optStaffInfo)throws SystemOptServiceException{
			  
			  }
            
            
}
