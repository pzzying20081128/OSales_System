package cn.zying.osales.service.baseinfo.imples ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StoreInfo ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.baseinfo.IStoreInfoService ;
import cn.zying.osales.service.baseinfo.units.StoreInfoRemoveUnits ;
import cn.zying.osales.service.baseinfo.units.StoreInfoSaveUpdateUnits ;
import cn.zying.osales.service.baseinfo.units.StoreInfoSearchUnits ;
import cn.zying.osales.units.search.bean.StoreInfoSearchBean ;

@Component(IStoreInfoService.name)
public class StoreInfoServiceImple extends ABCommonsService implements IStoreInfoService {

    //@Resource(name="StoreInfoSearchUnits")
    @Autowired
    @Qualifier("StoreInfoSearchUnits")
    private StoreInfoSearchUnits iStoreInfoSearchUnits ;

    //@Resource(name=" StoreInfoSaveUpdateUnits")
    @Autowired
    @Qualifier("StoreInfoSaveUpdateUnits")
    private StoreInfoSaveUpdateUnits iStoreInfoSaveUpdateUnits ;

    @Autowired
    @Qualifier("StoreInfoRemoveUnits")
    private StoreInfoRemoveUnits iStoreInfoRemoveUnits ;

    @Override
    public StoreInfo saveUpdate(OptType optType, StoreInfo optStoreInfo) throws SystemOptServiceException {
        return iStoreInfoSaveUpdateUnits.saveUpdate(optType, optStoreInfo) ;
    }

    @Override
    public SelectPage<StoreInfo> search(OptType optType, StoreInfoSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iStoreInfoSearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public List<StoreInfo> searchList(OptType optType, StoreInfoSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStoreInfoSearchUnits.list(optType, searchBean, commSearchBean, startLimit) ;

    }

    @Override
    public StoreInfo remove(OptType optType, StoreInfo optStoreInfo) throws SystemOptServiceException {
        return iStoreInfoRemoveUnits.remove(optType, optStoreInfo) ;
    }

    @Override
    public StoreInfo get(Integer id) throws SystemOptServiceException {

        return baseService.get(id, StoreInfo.class) ;
    }

}
