package cn.zying.osales.service.baseinfo.imples ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StorePosition ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.baseinfo.IStorePositionService ;
import cn.zying.osales.service.baseinfo.units.StorePositionRemoveUnits ;
import cn.zying.osales.service.baseinfo.units.StorePositionSaveUpdateUnits ;
import cn.zying.osales.service.baseinfo.units.StorePositionSearchUnits ;
import cn.zying.osales.units.search.bean.StorePositionSearchBean ;

@Component(IStorePositionService.name)
public class StorePositionServiceImple extends ABCommonsService implements IStorePositionService {

    //@Resource(name="StorePositionSearchUnits")
    @Autowired
    @Qualifier("StorePositionSearchUnits")
    private StorePositionSearchUnits iStorePositionSearchUnits ;

    //@Resource(name=" StorePositionSaveUpdateUnits")
    @Autowired
    @Qualifier("StorePositionSaveUpdateUnits")
    private StorePositionSaveUpdateUnits iStorePositionSaveUpdateUnits ;

    @Autowired
    @Qualifier("StorePositionRemoveUnits")
    private StorePositionRemoveUnits iStorePositionRemoveUnits ;

    @Override
    public StorePosition saveUpdate(OptType optType, StorePosition optStorePosition) throws SystemOptServiceException {
        return iStorePositionSaveUpdateUnits.saveUpdate(optType, optStorePosition) ;
    }

    @Override
    public SelectPage<StorePosition> search(OptType optType, StorePositionSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iStorePositionSearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public List<StorePosition> searchList(OptType optType, StorePositionSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStorePositionSearchUnits.list(optType, searchBean, commSearchBean, startLimit) ;

    }

    @Override
    public StorePosition remove(OptType optType, StorePosition optStorePosition) throws SystemOptServiceException {
        return iStorePositionRemoveUnits.remove(optType, optStorePosition) ;
    }

    @Override
    public StorePosition get(Integer id) throws SystemOptServiceException {

        return baseService.get(id, StorePosition.class) ;
    }

}
