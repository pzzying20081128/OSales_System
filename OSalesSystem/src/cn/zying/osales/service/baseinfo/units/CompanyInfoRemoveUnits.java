package cn.zying.osales.service.baseinfo.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.CompanyInfo ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("CompanyInfoRemoveUnits")
public class CompanyInfoRemoveUnits extends ABCommonsService {

    public CompanyInfo remove(OptType optType, CompanyInfo optCompanyInfo) throws SystemOptServiceException {

        Integer id = optCompanyInfo.getId() ;
        CompanyInfo removeCompanyInfo = baseService.get(id, CompanyInfo.class) ;
        removeCompanyInfo.setStatus(Status.删除) ;
        baseService.update(removeCompanyInfo) ;
        return removeCompanyInfo ;
    }

}
