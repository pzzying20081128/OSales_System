package  cn.zying.osales.service.baseinfo.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.pojos.CompanyInfo ; 


@Component("CompanyInfoRemoveUnits")
public class CompanyInfoRemoveUnits extends ABCommonsService {

    public CompanyInfo  remove(OptType optType, CompanyInfo  optCompanyInfo ) throws SystemOptServiceException {
        
         Integer id =optCompanyInfo.getId() ;
        CompanyInfo   removeCompanyInfo =baseService.get(id, CompanyInfo.class);
        baseService.update(removeCompanyInfo);
        return  removeCompanyInfo ;
    }

}
