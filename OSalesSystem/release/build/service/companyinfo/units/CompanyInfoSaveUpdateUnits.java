package  cn.zying.osales.service.baseinfo.units ;

import org.springframework.stereotype.Component ;


import cn.zying.osales.pojos.CompanyInfo ; 


@Component("CompanyInfoSaveUpdateUnits")
public class CompanyInfoSaveUpdateUnits extends ABCommonsService {

    public CompanyInfo saveUpdate(OptType optType, CompanyInfo optCompanyInfo) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return   save(optCompanyInfo) ;
            break ;
        case update:
            return update(optCompanyInfo) ;
            break ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public CompanyInfo  save(CompanyInfo optCompanyInfo) throws SystemOptServiceException {

    }

    public CompanyInfo  update(CompanyInfo optCompanyInfo) throws SystemOptServiceException {

    }

}
