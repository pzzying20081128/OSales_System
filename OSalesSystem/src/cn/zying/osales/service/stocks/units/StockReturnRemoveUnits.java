package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.StockReturn ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockReturnRemoveUnits")
public class StockReturnRemoveUnits extends ABCommonsService {

    public StockReturn remove(OptType optType, StockReturn optStockReturn) throws SystemOptServiceException {

        Integer id = optStockReturn.getId() ;
        StockReturn removeStockReturn = baseService.get(id, StockReturn.class) ;
        removeStockReturn.setStatus(Status.删除) ;
        baseService.update(removeStockReturn) ;
        return removeStockReturn ;
    }

}
