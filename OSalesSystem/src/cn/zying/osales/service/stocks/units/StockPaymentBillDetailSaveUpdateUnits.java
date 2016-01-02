package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockPaymentBillDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockPaymentBillDetailSaveUpdateUnits")
public class StockPaymentBillDetailSaveUpdateUnits extends ABCommonsService {

    public StockPaymentBillDetail saveUpdate(OptType optType, StockPaymentBillDetail stockPaymentBillDetail) throws SystemOptServiceException {

        switch (optType) {

        case save:
            baseService.save(stockPaymentBillDetail) ;
            return stockPaymentBillDetail ;

            //        case update:
            //
            //            return update(optType, optStockOrder) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

}
