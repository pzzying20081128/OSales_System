package cn.zying.osales.service.storehouse ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.infaces.InfaceStoreProductInfoStockService ;
import cn.zying.osales.pojos.StoreProductInfoDetail ;
import cn.zying.osales.service.SystemOptServiceException ;

public interface IStoreProductInfoStockService extends InfaceStoreProductInfoStockService {

    public String name = "IStoreProductInfoStockService" ;

    public SelectPage<StoreProductInfoDetail> searchDetail(Integer storeProductInfoStockId) throws SystemOptServiceException ;

}
