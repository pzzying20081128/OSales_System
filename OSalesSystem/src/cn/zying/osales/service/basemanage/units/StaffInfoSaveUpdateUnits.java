package cn.zying.osales.service.basemanage.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StaffInfo ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

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
            throw new SystemOptServiceException("[opt type error ]") ;
        }
    }

    public void save(StaffInfo optStaffInfo) throws SystemOptServiceException {

    }

    public void update(StaffInfo optStaffInfo) throws SystemOptServiceException {

    }

}
