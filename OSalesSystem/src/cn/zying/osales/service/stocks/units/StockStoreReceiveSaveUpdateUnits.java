package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockStoreReceive ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockStoreReceiveSaveUpdateUnits")
public class StockStoreReceiveSaveUpdateUnits extends ABCommonsService {

    public StockStoreReceive saveUpdate(OptType optType, StockStoreReceive optStockStoreReceive) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return save(optStockStoreReceive) ;

        case update:
            return update(optStockStoreReceive) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public StockStoreReceive save(StockStoreReceive optStockStoreReceive) throws SystemOptServiceException {
        return optStockStoreReceive ;
    }

    public StockStoreReceive update(StockStoreReceive optStockStoreReceive) throws SystemOptServiceException {

        StockStoreReceive stockStoreReceive = baseService.get(optStockStoreReceive.getId(), StockStoreReceive.class) ;

        stockStoreReceive.setText(optStockStoreReceive.getText()) ;

        stockStoreReceive.setRemarks(optStockStoreReceive.getRemarks()) ;

        baseService.update(stockStoreReceive) ;

        return stockStoreReceive ;
    }

}
