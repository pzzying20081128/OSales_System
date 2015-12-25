package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInvoiceBillDetail ;
import cn.zying.osales.pojos.StockInvoiceDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockInvoiceBillDetailSaveUpdateUnits")
public class StockInvoiceBillDetailSaveUpdateUnits extends ABCommonsService {

    public StockInvoiceBillDetail saveUpdate(OptType optType, StockInvoiceBillDetail stockInvoiceBillDetail) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return save(stockInvoiceBillDetail) ;

        case update:
            return update(stockInvoiceBillDetail) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    private StockInvoiceBillDetail save(StockInvoiceBillDetail stockInvoiceBillDetail) throws SystemOptServiceException {
        baseService.save(stockInvoiceBillDetail) ;
        return stockInvoiceBillDetail ;
    }

    private StockInvoiceBillDetail update(StockInvoiceBillDetail optStockInvoiceDetail) throws SystemOptServiceException {
        throw new SystemOptServiceException(" this update no  run  ") ;

    }

}
