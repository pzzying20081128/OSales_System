package  cn.zying.osales.service.basemanage.units ;

import org.springframework.stereotype.Component ;


import cn.zying.osales.pojos.StaffInfo ; 


@Component("StaffInfoSaveUpdateUnits")
public class StaffInfoSaveUpdateUnits extends ABCommonsService {

    public void saveUpdate(OptType optType, StaffInfo optStaffInfo) throws SystemOptServiceException {

        switch (optType) {
        case save:
            save(optStaffInfo) ;
            break ;
        case update:
            update(optStaffInfo) ;
            break ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public void save(StaffInfo optStaffInfo) throws SystemOptServiceException {

    }

    public void update(StaffInfo optStaffInfo) throws SystemOptServiceException {

    }

}
