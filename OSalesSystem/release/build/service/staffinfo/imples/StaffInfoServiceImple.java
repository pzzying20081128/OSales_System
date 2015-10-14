 package  cn.zying.osales.service.basemanage.imples;
 

  import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;
 import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.StaffInfo ; 
import  cn.zying.osales.service.basemanage.IStaffInfoService ;
import cn.zying.osales.service.basemanage.units.StaffInfoSearchBean ;

import cn.zying.osales.service.basemanage.units.StaffInfoSaveUpdateUnits ;

import cn.zying.osales.service.basemanage.units.StaffInfoSearchUnits ;
 

@Component(IStaffInfoService.name)
public class StaffInfoServiceImple extends  ABCommonsService  implements IStaffInfoService {

            //@Resource(name="StaffInfoSearchUnits")
			  @Autowired
            @Qualifier("StaffInfoSearchUnits")        
            private  StaffInfoSearchUnits  iStaffInfoSearchUnits;
           
           //@Resource(name=" StaffInfoSaveUpdateUnits")
		     @Autowired
            @Qualifier("StaffInfoSaveUpdateUnits")      
           private StaffInfoSaveUpdateUnits  iStaffInfoSaveUpdateUnits;
			
		   
		      @Autowired
    @Qualifier("StaffInfoRemoveUnits")
    private StaffInfoRemoveUnits iStaffInfoRemoveUnits ;
		   
			@Override
            public void saveUpdate(OptType  optType ,   StaffInfo   optStaffInfo )throws SystemOptServiceException{
        		 iStaffInfoSaveUpdateUnits.saveUpdate(optType, optStaffInfo);
        		}
            
       	   @Override
            public SelectPage<StaffInfo > search(OptType  optType ,    
				   StaffInfoSearchBean  searchBean , CommSearchBean  commSearchBean ,int... startLimit)throws SystemOptServiceException{
				    return  iStaffInfoSearchUnits.search(optType, searchBean,
					commSearchBean ,startLimit );
            }
            
			@Override
            public  void   remove(OptType  optType ,   StaffInfo   optStaffInfo)throws SystemOptServiceException{
			    iStaffInfoRemoveUnits.remove(optType, optStaffInfo);
			  }
            
            
}
