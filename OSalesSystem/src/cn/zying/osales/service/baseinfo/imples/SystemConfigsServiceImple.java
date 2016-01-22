package cn.zying.osales.service.baseinfo.imples ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SystemConfigs ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.baseinfo.ISystemConfigsService ;
import cn.zying.osales.service.baseinfo.units.SystemConfigsRemoveUnits ;
import cn.zying.osales.service.baseinfo.units.SystemConfigsSaveUpdateUnits ;
import cn.zying.osales.service.baseinfo.units.SystemConfigsSearchUnits ;
import cn.zying.osales.units.search.bean.SystemConfigsSearchBean ;

@Component(ISystemConfigsService.name)
public class SystemConfigsServiceImple extends ABCommonsService implements ISystemConfigsService {

    //@Resource(name="SystemConfigsSearchUnits")
    @Autowired
    @Qualifier("SystemConfigsSearchUnits")
    private SystemConfigsSearchUnits iSystemConfigsSearchUnits ;

    //@Resource(name=" SystemConfigsSaveUpdateUnits")
    @Autowired
    @Qualifier("SystemConfigsSaveUpdateUnits")
    private SystemConfigsSaveUpdateUnits iSystemConfigsSaveUpdateUnits ;

    @Autowired
    @Qualifier("SystemConfigsRemoveUnits")
    private SystemConfigsRemoveUnits iSystemConfigsRemoveUnits ;

    @Override
    public SystemConfigs saveUpdate(OptType optType, SystemConfigs optSystemConfigs) throws SystemOptServiceException {
        return iSystemConfigsSaveUpdateUnits.saveUpdate(optType, optSystemConfigs) ;
    }

    @Override
    public SelectPage<SystemConfigs> search(OptType optType, SystemConfigsSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iSystemConfigsSearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public List<SystemConfigs> searchList(OptType optType, SystemConfigsSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iSystemConfigsSearchUnits.list(optType, searchBean, commSearchBean, startLimit) ;

    }

    @Override
    public SystemConfigs get(Integer id) throws SystemOptServiceException {

        return baseService.get(id, SystemConfigs.class) ;
    }

}
