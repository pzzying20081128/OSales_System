package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.StockInvoice ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockInvoiceRemoveUnits")
public class StockInvoiceRemoveUnits extends ABCommonsService {

    public StockInvoice remove(OptType optType, StockInvoice optStockInvoice) throws SystemOptServiceException {

        Integer id = optStockInvoice.getId() ;
        StockInvoice removeStockInvoice = baseService.get(id, StockInvoice.class) ;
        removeStockInvoice.setStatus(Status.删除) ;
        baseService.update(removeStockInvoice) ;
        return removeStockInvoice ;
    }

}
