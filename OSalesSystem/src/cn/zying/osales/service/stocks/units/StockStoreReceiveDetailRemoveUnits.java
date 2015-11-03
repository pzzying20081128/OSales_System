package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockStoreReceiveDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockStoreReceiveDetailRemoveUnits")
public class StockStoreReceiveDetailRemoveUnits extends ABCommonsService {

    public StockStoreReceiveDetail remove(OptType optType, StockStoreReceiveDetail optStockStoreReceiveDetail) throws SystemOptServiceException {

        Integer id = optStockStoreReceiveDetail.getId() ;
        StockStoreReceiveDetail removeStockStoreReceiveDetail = baseService.get(id, StockStoreReceiveDetail.class) ;
        baseService.update(removeStockStoreReceiveDetail) ;
        return removeStockStoreReceiveDetail ;
    }

}
