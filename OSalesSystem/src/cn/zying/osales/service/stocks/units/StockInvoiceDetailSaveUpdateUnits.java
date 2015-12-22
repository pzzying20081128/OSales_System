package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInvoiceDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockInvoiceDetailSaveUpdateUnits")
public class StockInvoiceDetailSaveUpdateUnits extends ABCommonsService {

    public StockInvoiceDetail saveUpdate(OptType optType, StockInvoiceDetail optStockInvoiceDetail) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return save(optStockInvoiceDetail) ;

        case update:
            return update(optStockInvoiceDetail) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    private StockInvoiceDetail save(StockInvoiceDetail optStockInvoiceDetail) throws SystemOptServiceException {
        baseService.save(optStockInvoiceDetail) ;
        return optStockInvoiceDetail ;
    }

    private StockInvoiceDetail update(StockInvoiceDetail optStockInvoiceDetail) throws SystemOptServiceException {
        throw new SystemOptServiceException(" this update no  run  ") ;

    }

}
