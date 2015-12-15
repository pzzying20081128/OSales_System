package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StoreProductInfoDetail ;
import cn.zying.osales.pojos.StoreProductInfoStock ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.storehouse.IStoreProductInfoStockService ;
import cn.zying.osales.units.search.bean.StoreProductInfoStockSearchBean ;

@Component(IAopStoreProductInfoStockService.name)
public class AopStoreProductInfoStockService implements IAopStoreProductInfoStockService {

    @Autowired
    @Qualifier(IStoreProductInfoStockService.name)
    private IStoreProductInfoStockService iStoreProductInfoStockService ;

    public StoreProductInfoStock saveUpdate(OptType optType, StoreProductInfoStock optStoreProductInfoStock) throws SystemOptServiceException {

        return iStoreProductInfoStockService.saveUpdate(optType, optStoreProductInfoStock) ;

    }

    public SelectPage<StoreProductInfoStock> search(OptType optType, StoreProductInfoStockSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStoreProductInfoStockService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    public List<StoreProductInfoStock> searchList(OptType optType, StoreProductInfoStockSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStoreProductInfoStockService.searchList(optType, searchBean, commSearchBean, startLimit) ;

    }

    public StoreProductInfoStock remove(OptType optType, StoreProductInfoStock optStoreProductInfoStock) throws SystemOptServiceException {

        return iStoreProductInfoStockService.remove(optType, optStoreProductInfoStock) ;

    }

    public StoreProductInfoStock get(Integer id) throws SystemOptServiceException {
        return iStoreProductInfoStockService.get(id) ;

    }

    @Override
    public SelectPage<StoreProductInfoDetail> searchDetail(Integer storeProductInfoStockId) throws SystemOptServiceException {
        // TODO Auto-generated method stub
        return iStoreProductInfoStockService.searchDetail(storeProductInfoStockId) ;
    }

}
