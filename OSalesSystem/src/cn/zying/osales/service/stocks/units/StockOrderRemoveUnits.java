package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.StockOrder ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockOrderRemoveUnits")
public class StockOrderRemoveUnits extends ABCommonsService {

    public StockOrder remove(OptType optType, StockOrder optStockOrder) throws SystemOptServiceException {

        Integer id = optStockOrder.getId() ;
        StockOrder removeStockOrder = baseService.get(id, StockOrder.class) ;
        removeStockOrder.setStatus(Status.删除) ;
        baseService.update(removeStockOrder) ;
        return removeStockOrder ;
    }

}
