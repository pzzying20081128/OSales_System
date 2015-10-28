package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInStoreDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockInStoreDetailSaveUpdateUnits")
public class StockInStoreDetailSaveUpdateUnits extends ABCommonsService {

    public StockInStoreDetail saveUpdate(OptType optType, StockInStoreDetail optStockInStoreDetail) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return save(optStockInStoreDetail) ;

        case update:
            return update(optStockInStoreDetail) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public StockInStoreDetail save(StockInStoreDetail optStockInStoreDetail) throws SystemOptServiceException {
      return optStockInStoreDetail;
    }

    public StockInStoreDetail update(StockInStoreDetail optStockInStoreDetail) throws SystemOptServiceException {
        return optStockInStoreDetail;
    }

}
