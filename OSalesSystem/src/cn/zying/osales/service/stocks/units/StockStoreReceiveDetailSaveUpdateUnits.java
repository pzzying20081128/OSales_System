package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockStoreReceiveDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockStoreReceiveDetailSaveUpdateUnits")
public class StockStoreReceiveDetailSaveUpdateUnits extends ABCommonsService {

    public StockStoreReceiveDetail saveUpdate(OptType optType, StockStoreReceiveDetail optStockStoreReceiveDetail) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return save(optStockStoreReceiveDetail) ;

        case update:
            return update(optStockStoreReceiveDetail) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public StockStoreReceiveDetail save(StockStoreReceiveDetail optStockStoreReceiveDetail) throws SystemOptServiceException {
        return optStockStoreReceiveDetail ;
    }

    public StockStoreReceiveDetail update(StockStoreReceiveDetail optStockStoreReceiveDetail) throws SystemOptServiceException {
        return optStockStoreReceiveDetail ;
    }

}
