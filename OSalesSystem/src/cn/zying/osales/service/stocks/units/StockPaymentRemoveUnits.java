package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.StockPayment ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockPaymentRemoveUnits")
public class StockPaymentRemoveUnits extends ABCommonsService {

    public StockPayment remove(OptType optType, StockPayment optStockPayment) throws SystemOptServiceException {

        Integer id = optStockPayment.getId() ;
        StockPayment removeStockPayment = baseService.get(id, StockPayment.class) ;
        removeStockPayment.setStatus(Status.删除) ;
        baseService.update(removeStockPayment) ;
        return removeStockPayment ;
    }

}
