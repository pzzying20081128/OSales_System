package  cn.zying.osales.service.sysmanage.units ;

import org.springframework.stereotype.Component ;


import cn.zying.osales.pojos.SystemUser ; 


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
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public void save(SystemUser optSystemUser) throws SystemOptServiceException {

    }

    public void update(SystemUser optSystemUser) throws SystemOptServiceException {

    }

}
