package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StorePosition ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.baseinfo.IStorePositionService ;
import cn.zying.osales.units.search.bean.StorePositionSearchBean ;

@Component(IAopStorePositionService.name)
public class AopStorePositionService implements IAopStorePositionService {

    @Autowired
    @Qualifier(IStorePositionService.name)
    private IStorePositionService iStorePositionService ;

    public StorePosition saveUpdate(OptType optType, StorePosition optStorePosition) throws SystemOptServiceException {

        return iStorePositionService.saveUpdate(optType, optStorePosition) ;

    }

    public SelectPage<StorePosition> search(OptType optType, StorePositionSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStorePositionService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    public List<StorePosition> searchList(OptType optType, StorePositionSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStorePositionService.searchList(optType, searchBean, commSearchBean, startLimit) ;

    }

    public StorePosition remove(OptType optType, StorePosition optStorePosition) throws SystemOptServiceException {

        return iStorePositionService.remove(optType, optStorePosition) ;

    }

    public StorePosition get(Integer id) throws SystemOptServiceException {
        return iStorePositionService.get(id) ;

    }

}
