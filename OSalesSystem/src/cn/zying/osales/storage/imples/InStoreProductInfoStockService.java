package cn.zying.osales.storage.imples ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zying.osales.pojos.StockOrderDetail ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.storage.IInStoreProductInfoStockService ;
import cn.zying.osales.storage.IStoreUnits ;

@Component(IInStoreProductInfoStockService.name)
public class InStoreProductInfoStockService implements IInStoreProductInfoStockService {

    @Autowired
    @Qualifier("StockOrderUnits")
    private IStoreUnits<StockOrderDetail> stockOrderUnits ;

    @Override
    public <V> void inStore(StoreOptType storeOptType, V bean) throws SystemOptServiceException {
        if (bean instanceof StockOrderDetail) {
            stockOrderUnits.inStore(storeOptType, (StockOrderDetail) bean) ;
        }
    }

}
