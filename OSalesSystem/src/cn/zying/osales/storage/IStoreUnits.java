package cn.zying.osales.storage ;

import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.storage.IInStoreProductInfoStockService.StoreOptType ;

public interface IStoreUnits<V> {

    public void inStore(StoreOptType storeOptType, V bean) throws SystemOptServiceException ;
}
