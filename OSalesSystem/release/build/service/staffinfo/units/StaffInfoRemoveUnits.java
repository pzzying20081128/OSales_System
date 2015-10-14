package  cn.zying.osales.service.basemanage.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.pojos.StaffInfo ; 


@Component("StaffInfoRemoveUnits")
public class StaffInfoRemoveUnits extends ABCommonsService {

    public void remove(OptType optType, StaffInfo  optStaffInfo ) throws SystemOptServiceException {
        
        baseService.update(entity);

    }

}
