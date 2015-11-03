package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.StockStoreReceive ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockStoreReceiveRemoveUnits")
public class StockStoreReceiveRemoveUnits extends ABCommonsService {

    public StockStoreReceive remove(OptType optType, StockStoreReceive optStockStoreReceive) throws SystemOptServiceException {

        Integer id = optStockStoreReceive.getId() ;
        StockStoreReceive removeStockStoreReceive = baseService.get(id, StockStoreReceive.class) ;
        removeStockStoreReceive.setStatus(Status.删除) ;
        baseService.update(removeStockStoreReceive) ;
        return removeStockStoreReceive ;
    }

}
