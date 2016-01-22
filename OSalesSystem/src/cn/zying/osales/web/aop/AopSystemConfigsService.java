package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SystemConfigs ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.baseinfo.ISystemConfigsService ;
import cn.zying.osales.units.search.bean.SystemConfigsSearchBean ;

@Component(IAopSystemConfigsService.name)
public class AopSystemConfigsService implements IAopSystemConfigsService {

    @Autowired
    @Qualifier(ISystemConfigsService.name)
    private ISystemConfigsService iSystemConfigsService ;

    public SystemConfigs saveUpdate(OptType optType, SystemConfigs optSystemConfigs) throws SystemOptServiceException {

        return iSystemConfigsService.saveUpdate(optType, optSystemConfigs) ;

    }

    public SelectPage<SystemConfigs> search(OptType optType, SystemConfigsSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iSystemConfigsService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    public List<SystemConfigs> searchList(OptType optType, SystemConfigsSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iSystemConfigsService.searchList(optType, searchBean, commSearchBean, startLimit) ;

    }

    public SystemConfigs get(Integer id) throws SystemOptServiceException {
        return iSystemConfigsService.get(id) ;

    }

}
