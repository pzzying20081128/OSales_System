package  cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.pojos.StockInvoice ; 


@Component("StockInvoiceRemoveUnits")
public class StockInvoiceRemoveUnits extends ABCommonsService {

    public StockInvoice  remove(OptType optType, StockInvoice  optStockInvoice ) throws SystemOptServiceException {
        
         Integer id =optStockInvoice.getId() ;
        StockInvoice   removeStockInvoice =baseService.get(id, StockInvoice.class);
        baseService.update(removeStockInvoice);
        return  removeStockInvoice ;
    }

}
