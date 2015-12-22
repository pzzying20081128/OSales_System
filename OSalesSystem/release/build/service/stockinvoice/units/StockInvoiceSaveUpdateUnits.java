package  cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;


import cn.zying.osales.pojos.StockInvoice ; 


@Component("StockInvoiceSaveUpdateUnits")
public class StockInvoiceSaveUpdateUnits extends ABCommonsService {

    public StockInvoice saveUpdate(OptType optType, StockInvoice optStockInvoice) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return   save(optStockInvoice) ;
            break ;
        case update:
            return update(optStockInvoice) ;
            break ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public StockInvoice  save(StockInvoice optStockInvoice) throws SystemOptServiceException {

    }

    public StockInvoice  update(StockInvoice optStockInvoice) throws SystemOptServiceException {

    }

}
