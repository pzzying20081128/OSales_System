package cn.zying.osales.storage ;

import cn.zying.osales.service.SystemOptServiceException ;

public interface IInStoreProductInfoStockService {

    public String name = "IInStoreProductInfoStockService" ;

    public static enum StoreOptType {
        SaveAdd, Del, UpdateAdd, Check, CancelCheck
    }

    public static enum SumType {
        planOutStoreSum, purchaseSum, approvaSum
    }

    public static enum StoreOpt {
        in, out
    }

    //    @Transactional(propagation = Propagation., rollbackFor = { AppBizExeA.class })  
    public <V> void inStore(StoreOptType storeOptType, V bean) throws SystemOptServiceException ;

}
