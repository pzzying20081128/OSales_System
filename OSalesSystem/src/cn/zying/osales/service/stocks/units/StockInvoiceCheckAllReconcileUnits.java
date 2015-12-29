package cn.zying.osales.service.stocks.units ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.BillType ;
import cn.zying.osales.OSalesConfigProperties.StockBillIsReconciliation ;
import cn.zying.osales.pojos.StockInvoice ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.invoice.IStockPaymentbillDetailService ;

@Component("StockInvoiceCheckAllReconcileUnits")
public class StockInvoiceCheckAllReconcileUnits extends ABCommonsService {

    @Autowired
    @Qualifier(IStockPaymentbillDetailService.name)
    private IStockPaymentbillDetailService stockPaymentbillDetailService ;

    public void checkAllReconcile(StockInvoice stockinvoice) throws SystemOptServiceException {

        StockInvoice stockinvoice_ = baseService.load(stockinvoice.getId(), StockInvoice.class) ;

        if (stockinvoice_.getReconciliation().equals(StockBillIsReconciliation.全部对帐)) {
            stockPaymentbillDetailService.createDetail(BillType.采购付款, stockinvoice_) ;
        } else {
            stockPaymentbillDetailService.removeDetail(BillType.采购付款, stockinvoice_) ;
        }

    }
}
