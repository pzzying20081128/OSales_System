package  cn.zying.osales.service.sysmanage.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.pojos.SystemUser ; 


@Component("SystemUserRemoveUnits")
public class SystemUserRemoveUnits extends ABCommonsService {

    public void remove(OptType optType, SystemUser  optSystemUser ) throws SystemOptServiceException {
        
         Integer id =optSystemUser.get ;
        SystemUser   removeSystemUser =baseService.load(id, SystemUser.class);
        baseService.update(removeSystemUser);

    }

}
