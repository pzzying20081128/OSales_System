package cn.zying.osales.service.baseinfo.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.ProviderInfo ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("ProviderInfoSaveUpdateUnits")
public class ProviderInfoSaveUpdateUnits extends ABCommonsService {

    public ProviderInfo saveUpdate(OptType optType, ProviderInfo optProviderInfo) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return save(optProviderInfo) ;

        case update:
            return update(optProviderInfo) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public ProviderInfo save(ProviderInfo optProviderInfo) throws SystemOptServiceException {

        if (optProviderInfo.getStockManId() != null) {

            Integer stockManId = optProviderInfo.getStockManId() ;

            SysStaffUser sysStaffUser = baseService.load(stockManId, SysStaffUser.class) ;

            optProviderInfo.setStockMan(sysStaffUser) ;
        }

        optProviderInfo.setStatus(Status.有效) ;

        baseService.save(optProviderInfo) ;

        return optProviderInfo ;
    }

    public ProviderInfo update(ProviderInfo optProviderInfo) throws SystemOptServiceException {

        if (optProviderInfo.getStockManId() != null) {

            Integer stockManId = optProviderInfo.getStockManId() ;

            SysStaffUser sysStaffUser = baseService.load(stockManId, SysStaffUser.class) ;

            optProviderInfo.setStockMan(sysStaffUser) ;
        }
        baseService.update(optProviderInfo) ;

        return optProviderInfo ;
    }

}
