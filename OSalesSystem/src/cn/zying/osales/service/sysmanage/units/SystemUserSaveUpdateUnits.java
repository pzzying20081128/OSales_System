package  cn.zying.osales.service.sysmanage.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SystemUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;


@Component("SystemUserSaveUpdateUnits")
public class SystemUserSaveUpdateUnits extends ABCommonsService {

    public void saveUpdate(OptType optType, SystemUser optSystemUser) throws SystemOptServiceException {

        switch (optType) {
        case save:
            save(optSystemUser) ;
            break ;
        case update:
            update(optSystemUser) ;
            break ;

        default:
            throw new SystemOptServiceException("[opt type error ]") ;
        }
    }

    public void save(SystemUser optSystemUser) throws SystemOptServiceException {

    }

    public void update(SystemUser optSystemUser) throws SystemOptServiceException {

    }

}
