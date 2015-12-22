package cn.zying.osales.service.baseinfo.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.CompanyInfo ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("CompanyInfoSaveUpdateUnits")
public class CompanyInfoSaveUpdateUnits extends ABCommonsService {

    public CompanyInfo saveUpdate(OptType optType, CompanyInfo optCompanyInfo) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return save(optCompanyInfo) ;

        case update:
            return update(optCompanyInfo) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public CompanyInfo save(CompanyInfo optCompanyInfo) throws SystemOptServiceException {
        optCompanyInfo.setStatus(Status.有效) ;
        baseService.save(optCompanyInfo) ;
        return optCompanyInfo ;

    }

    public CompanyInfo update(CompanyInfo optCompanyInfo) throws SystemOptServiceException {
        return optCompanyInfo ;
    }

}
