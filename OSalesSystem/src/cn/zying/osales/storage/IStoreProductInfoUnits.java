package cn.zying.osales.storage ;

import cn.zying.osales.OSalesConfigProperties.StoreType ;
import cn.zying.osales.pojos.StoreProductInfoDetail ;
import cn.zying.osales.pojos.StoreProductInfoStock ;
import cn.zying.osales.service.SystemOptServiceException ;

public interface IStoreProductInfoUnits {

    public StoreProductInfoStock newStoreProductInfoStock(StoreType storeType, Integer storeInfoId, Integer productInfoId, Integer guestInfoId) ;

    public StoreProductInfoDetail newStoreProductInfoDetail(StoreProductInfoStock storeProductInfoStock, Integer storePositionId) ;

    public String name = "IStoreProductInfoService" ;

    public StoreProductInfoStock search(Integer storeInfoId, Integer productInfoId, Integer guestInfoId) throws SystemOptServiceException ;

    public StoreProductInfoDetail searchDetail(Integer storeProductInfoStockId, Integer storePositionId) throws SystemOptServiceException ;

}
