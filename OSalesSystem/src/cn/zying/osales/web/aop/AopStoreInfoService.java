package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StoreInfo ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.baseinfo.IStoreInfoService ;
import cn.zying.osales.units.search.bean.StoreInfoSearchBean ;

@Component(IAopStoreInfoService.name)
public class AopStoreInfoService implements IAopStoreInfoService {

    @Autowired
    @Qualifier(IStoreInfoService.name)
    private IStoreInfoService iStoreInfoService ;

    public StoreInfo saveUpdate(OptType optType, StoreInfo optStoreInfo) throws SystemOptServiceException {

        return iStoreInfoService.saveUpdate(optType, optStoreInfo) ;

    }

    public SelectPage<StoreInfo> search(OptType optType, StoreInfoSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStoreInfoService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    public List<StoreInfo> searchList(OptType optType, StoreInfoSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStoreInfoService.searchList(optType, searchBean, commSearchBean, startLimit) ;

    }

    public StoreInfo remove(OptType optType, StoreInfo optStoreInfo) throws SystemOptServiceException {

        return iStoreInfoService.remove(optType, optStoreInfo) ;

    }

    public StoreInfo get(Integer id) throws SystemOptServiceException {
        return iStoreInfoService.get(id) ;

    }

}
