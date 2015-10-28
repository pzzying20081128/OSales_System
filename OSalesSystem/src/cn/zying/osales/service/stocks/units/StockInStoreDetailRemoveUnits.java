package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInStoreDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockInStoreDetailRemoveUnits")
public class StockInStoreDetailRemoveUnits extends ABCommonsService {

    public StockInStoreDetail remove(OptType optType, StockInStoreDetail optStockInStoreDetail) throws SystemOptServiceException {

        Integer id = optStockInStoreDetail.getId() ;
        StockInStoreDetail removeStockInStoreDetail = baseService.get(id, StockInStoreDetail.class) ;

        baseService.remove(removeStockInStoreDetail) ;

        return removeStockInStoreDetail ;
    }

}
