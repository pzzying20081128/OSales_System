package  cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;


import cn.zying.osales.pojos.StockInvoiceDetail ; 


@Component("StockInvoiceDetailSaveUpdateUnits")
public class StockInvoiceDetailSaveUpdateUnits extends ABCommonsService {

    public StockInvoiceDetail saveUpdate(OptType optType, StockInvoiceDetail optStockInvoiceDetail) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return   save(optStockInvoiceDetail) ;
            break ;
        case update:
            return update(optStockInvoiceDetail) ;
            break ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public StockInvoiceDetail  save(StockInvoiceDetail optStockInvoiceDetail) throws SystemOptServiceException {

    }

    public StockInvoiceDetail  update(StockInvoiceDetail optStockInvoiceDetail) throws SystemOptServiceException {

    }

}
