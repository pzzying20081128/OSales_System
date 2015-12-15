package cn.zying.osales.web.aop ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.infaces.InfaceStoreProductInfoStockService ;
import cn.zying.osales.pojos.StoreProductInfoDetail ;
import cn.zying.osales.service.SystemOptServiceException ;

public interface IAopStoreProductInfoStockService extends InfaceStoreProductInfoStockService {

    public String name = "IAopStoreProductInfoStockService" ;

    public SelectPage<StoreProductInfoDetail> searchDetail(Integer storeProductInfoStockId) throws SystemOptServiceException ;

}
