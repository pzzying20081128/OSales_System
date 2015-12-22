package  cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.pojos.StockInvoiceDetail ; 


@Component("StockInvoiceDetailRemoveUnits")
public class StockInvoiceDetailRemoveUnits extends ABCommonsService {

    public StockInvoiceDetail  remove(OptType optType, StockInvoiceDetail  optStockInvoiceDetail ) throws SystemOptServiceException {
        
         Integer id =optStockInvoiceDetail.getId() ;
        StockInvoiceDetail   removeStockInvoiceDetail =baseService.get(id, StockInvoiceDetail.class);
        baseService.update(removeStockInvoiceDetail);
        return  removeStockInvoiceDetail ;
    }

}
