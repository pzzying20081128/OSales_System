package cn.zying.osales.service.sysmanage.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("SystemUserRemoveUnits")
public class SystemUserRemoveUnits extends ABCommonsService {

    public void remove(OptType optType, SysStaffUser optSystemUser) throws SystemOptServiceException {

        Integer id = optSystemUser.getId() ;

        SysStaffUser removeSystemUser = baseService.load(id, SysStaffUser.class) ;

        removeSystemUser.setStatus(Status.删除) ;

        baseService.update(removeSystemUser) ;

    }

}
