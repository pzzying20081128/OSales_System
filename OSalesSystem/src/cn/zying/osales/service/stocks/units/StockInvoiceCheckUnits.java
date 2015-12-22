package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.DateToolsUilts ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.OSalesConfigProperties.StockBillIsReconciliation ;
import cn.zying.osales.pojos.StockInvoice ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockInvoiceCheckUnits")
public class StockInvoiceCheckUnits extends ABCommonsService {

    public StockInvoice check(StockInvoice stockInvoice_) throws SystemOptServiceException {

        StockInvoice stockInvoice = baseService.get(stockInvoice_.getId(), StockInvoice.class) ;
        
        stockInvoice.setCheckManId(stockInvoice_.getCheckManId());

        Status status = stockInvoice.getStatus() ;
        switch (status) {
        case 有效:
            checking(stockInvoice) ;
            break ;
        case 已审核:
            checkNo(stockInvoice);
            break ;

        default:
            break ;
        }
        return stockInvoice ;
    }

    private void checking(StockInvoice stockInvoice) throws SystemOptServiceException {
        SysStaffUser checkMan = baseService.load(stockInvoice.getCheckManId(), SysStaffUser.class) ;
        stockInvoice.setStatus(Status.已审核) ;
        stockInvoice.setReconciliation(StockBillIsReconciliation.末对帐);
        stockInvoice.setCheckMan(checkMan) ;
        stockInvoice.setCheckedDate(DateToolsUilts.getnowDate()) ;
        baseService.update(stockInvoice) ;
    }
    
    private void checkNo(StockInvoice stockInvoice) throws SystemOptServiceException {
 
        stockInvoice.setStatus(Status.有效) ;
        stockInvoice.setReconciliation(null);
        stockInvoice.setCheckMan(null) ;
        stockInvoice.setCheckedDate(null) ;
        baseService.update(stockInvoice) ;
    }
}
