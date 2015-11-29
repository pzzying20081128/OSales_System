package cn.zying.osales.service.stocks.units ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptSum ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockOrder ;
import cn.zying.osales.pojos.StockOrderDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.storage.IInStoreProductInfoStockService.StoreOptType ;

@Component("StockOrderDetailRemoveUnits")
public class StockOrderDetailRemoveUnits extends ABCommonsService {

    @Autowired
    @Qualifier("StockOrderSaveUpdateUnits")
    private StockOrderSaveUpdateUnits stockOrderSaveUpdateUnits ;

    public StockOrderDetail remove(OptType optType, StockOrderDetail optStockOrderDetail) throws SystemOptServiceException {

        Integer id = optStockOrderDetail.getId() ;
        StockOrderDetail removeStockOrderDetail = baseService.get(id, StockOrderDetail.class) ;

        baseService.remove(removeStockOrderDetail) ;

        storeProductInfoStockService.inStore(StoreOptType.Del, removeStockOrderDetail) ;

        StockOrder stockOrder = baseService.load(removeStockOrderDetail.getStockOrderId(), StockOrder.class) ;

        stockOrderSaveUpdateUnits.updateSumMoney(stockOrder, removeStockOrderDetail, OptSum.del) ;

        return removeStockOrderDetail ;
    }

}
