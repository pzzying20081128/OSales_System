package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProviderInfo ;
import cn.zying.osales.service.IProviderInfoService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.ProviderInfoSearchBean ;

@Component(IAopProviderInfoService.name)
public class AopProviderInfoService implements IAopProviderInfoService {

    @Autowired
    @Qualifier(IProviderInfoService.name)
    private IProviderInfoService iProviderInfoService ;

    public ProviderInfo saveUpdate(OptType optType, ProviderInfo optProviderInfo) throws SystemOptServiceException {

        return iProviderInfoService.saveUpdate(optType, optProviderInfo) ;

    }

    public SelectPage<ProviderInfo> search(OptType optType, ProviderInfoSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iProviderInfoService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    public List<ProviderInfo> searchList(OptType optType, ProviderInfoSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iProviderInfoService.searchList(optType, searchBean, commSearchBean, startLimit) ;

    }

    public ProviderInfo remove(OptType optType, ProviderInfo optProviderInfo) throws SystemOptServiceException {

        return iProviderInfoService.remove(optType, optProviderInfo) ;

    }

    public ProviderInfo get(Integer id) throws SystemOptServiceException {
        return iProviderInfoService.get(id) ;

    }

}
