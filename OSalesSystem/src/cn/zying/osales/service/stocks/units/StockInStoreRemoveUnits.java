package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.StockInStore ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockInStoreRemoveUnits")
public class StockInStoreRemoveUnits extends ABCommonsService {

    public StockInStore remove(OptType optType, StockInStore optStockInStore) throws SystemOptServiceException {

        Integer id = optStockInStore.getId() ;
        StockInStore removeStockInStore = baseService.get(id, StockInStore.class) ;
        removeStockInStore.setStatus(Status.删除) ;
        baseService.update(removeStockInStore) ;
        return removeStockInStore ;
    }

}
