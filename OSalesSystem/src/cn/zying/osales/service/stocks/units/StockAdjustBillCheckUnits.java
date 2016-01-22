package cn.zying.osales.service.stocks.units ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.DateToolsUilts ;
import cn.zying.osales.OSalesConfigProperties.AdjustType ;
import cn.zying.osales.OSalesConfigProperties.BillType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.StockAdjustBill ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.invoice.IStockInvoiceDetailCreateService ;
import cn.zying.osales.service.stocks.invoice.IStockPaymentbillCreateService ;

@Component("StockAdjustBillCheckUnits")
public class StockAdjustBillCheckUnits extends ABCommonsService {

    @Autowired
    @Qualifier(IStockInvoiceDetailCreateService.name)
    private IStockInvoiceDetailCreateService stockInvoiceDetailCreateService ;

    @Autowired
    @Qualifier(IStockPaymentbillCreateService.name)
    private IStockPaymentbillCreateService stockPaymentbillDetailService ;

    public void check(StockAdjustBill stockadjustbill_) throws SystemOptServiceException {

        StockAdjustBill stockadjustbill = baseService.load(stockadjustbill_.getId(), StockAdjustBill.class) ;

        switch (stockadjustbill.getStatus()) {
        case 有效:
            checking(stockadjustbill, stockadjustbill_.getCheckManId()) ;
            break ;

        case 已审核:
            cancelChecking(stockadjustbill) ;
            break ;

        default:
            break ;
        }
    }

    private void checking(StockAdjustBill stockadjustbill, Integer checkManId) throws SystemOptServiceException {

        stockadjustbill.setStatus(Status.已审核) ;

        stockadjustbill.setCheckMan(baseService.load(checkManId, SysStaffUser.class)) ;

        stockadjustbill.setCheckedTime(DateToolsUilts.getnowDate()) ;

        baseService.update(stockadjustbill) ;

        if (stockadjustbill.getAdjustType().equals(AdjustType.票前)) {
            stockInvoiceDetailCreateService.createInvoiceDetail(BillType.采购调整单, stockadjustbill) ;
        } else if (stockadjustbill.getAdjustType().equals(AdjustType.票后)) {
            stockPaymentbillDetailService.createDetail(BillType.采购调整单, stockadjustbill) ;
        }

    }

    private void cancelChecking(StockAdjustBill stockadjustbill) throws SystemOptServiceException {

        stockadjustbill.setStatus(Status.有效) ;

        stockadjustbill.setCheckedTime(null) ;

        stockadjustbill.setCheckMan(null) ;

        baseService.update(stockadjustbill) ;

        if (stockadjustbill.getAdjustType().equals(AdjustType.票前)) {
            stockInvoiceDetailCreateService.removeInvoiceDetail(BillType.采购调整单, stockadjustbill) ;
        } else if (stockadjustbill.getAdjustType().equals(AdjustType.票后)) {
            stockPaymentbillDetailService.removeDetail(BillType.采购调整单, stockadjustbill) ;
        }

    }

}
