package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.CompanyInfo ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.baseinfo.ICompanyInfoService ;
import cn.zying.osales.units.search.bean.CompanyInfoSearchBean ;

@Component(IAopCompanyInfoService.name)
public class AopCompanyInfoService implements IAopCompanyInfoService {

    @Autowired
    @Qualifier(ICompanyInfoService.name)
    private ICompanyInfoService iCompanyInfoService ;

    public CompanyInfo saveUpdate(OptType optType, CompanyInfo optCompanyInfo) throws SystemOptServiceException {

        return iCompanyInfoService.saveUpdate(optType, optCompanyInfo) ;

    }

    public SelectPage<CompanyInfo> search(OptType optType, CompanyInfoSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iCompanyInfoService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    public List<CompanyInfo> searchList(OptType optType, CompanyInfoSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iCompanyInfoService.searchList(optType, searchBean, commSearchBean, startLimit) ;

    }

    public CompanyInfo remove(OptType optType, CompanyInfo optCompanyInfo) throws SystemOptServiceException {

        return iCompanyInfoService.remove(optType, optCompanyInfo) ;

    }

    public CompanyInfo get(Integer id) throws SystemOptServiceException {
        return iCompanyInfoService.get(id) ;

    }

}
