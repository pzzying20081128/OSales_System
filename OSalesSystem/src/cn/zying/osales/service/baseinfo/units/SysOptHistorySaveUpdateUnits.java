package cn.zying.osales.service.baseinfo.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SysOptHistory ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("SysOptHistorySaveUpdateUnits")
public class SysOptHistorySaveUpdateUnits extends ABCommonsService {

    public void saveUpdate(OptType optType, SysOptHistory optSysOptHistory) throws SystemOptServiceException {

        switch (optType) {
        case save:
            save(optSysOptHistory) ;
            break ;
        case update:
            update(optSysOptHistory) ;
            break ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public void save(SysOptHistory optSysOptHistory) throws SystemOptServiceException {

        Integer sysStaffUserId = optSysOptHistory.getSysStaffUserId() ;

        SysStaffUser sysStaffUser = baseService.load(sysStaffUserId, SysStaffUser.class) ;

        optSysOptHistory.setSysStaffUser(sysStaffUser) ;

        baseService.save(optSysOptHistory) ;

    }

    public void update(SysOptHistory optSysOptHistory) throws SystemOptServiceException {

    }

}
