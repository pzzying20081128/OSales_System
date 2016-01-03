package cn.zying.osales.service.stocks.units ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.DateToolsUilts ;
import cn.zying.osales.OSalesConfigProperties.BillType ;
import cn.zying.osales.OSalesConfigProperties.ReturnType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.OSalesConfigProperties.StockType ;
import cn.zying.osales.pojos.StockReturnStoreOut ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.invoice.IStockInvoiceDetailCreateService ;
import cn.zying.osales.service.stocks.invoice.IStockPaymentbillCreateService ;
import cn.zying.osales.service.stocks.summary.IStockSummaryService ;

@Component("StockReturnStoreOutCheckUnits")
public class StockReturnStoreOutCheckUnits extends ABCommonsService {

    //    public void cancelCheckDel(StockReturnStoreOut stockReturnStoreOut, Integer optUserId) throws SystemOptServiceException {
    //        if (stockStoreReceive == null) return ;
    //        if (stockStoreReceive.getStockType().equals(StockType.直营采购订单)) {
    //            baseService.remove(stockStoreReceive) ;
    //        } else if (stockStoreReceive.getStockType().equals(StockType.采购订单)) {
    //            if (stockStoreReceive.getStatus().equals(Status.已审核)) {
    //                throw new SystemOptServiceException("此采购进货单[" + stockStoreReceive.getNumber() + "]已被审核") ;
    //            } else {
    //                baseService.remove(stockStoreReceive) ;
    //            }
    //        }
    //    }

    @Autowired
    @Qualifier(IStockSummaryService.name)
    private IStockSummaryService iStockSummaryService ;

    @Autowired
    @Qualifier(IStockInvoiceDetailCreateService.name)
    private IStockInvoiceDetailCreateService iStockInvoiceDetailCreateService ;

    @Autowired
    @Qualifier(IStockPaymentbillCreateService.name)
    private IStockPaymentbillCreateService iStockPaymentbillCreateService ;

    public void check(Integer stockReturnStoreOutId, Integer optUserId) throws SystemOptServiceException {

        StockReturnStoreOut stockReturnStoreOut = baseService.load(stockReturnStoreOutId, StockReturnStoreOut.class) ;

        switch (stockReturnStoreOut.getStatus()) {
        case 有效:
            checking(stockReturnStoreOut, optUserId) ;
            if (stockReturnStoreOut.getStockReturn().getReturnType().equals(ReturnType.开票前退货)) {
                iStockInvoiceDetailCreateService.createInvoiceDetail(BillType.采购退货出库单, stockReturnStoreOut) ;
            } else if (stockReturnStoreOut.getStockReturn().getReturnType().equals(ReturnType.开票后退货)) {
                iStockPaymentbillCreateService.createDetail(BillType.采购退货出库单, stockReturnStoreOut) ;
            }

            iStockSummaryService.summary(BillType.采购退货出库单, stockReturnStoreOut) ;
            break ;
        case 已审核:
            cancelCheck(stockReturnStoreOut, optUserId) ;

            if (stockReturnStoreOut.getStockReturn().getReturnType().equals(ReturnType.开票前退货)) {
                iStockInvoiceDetailCreateService.removeInvoiceDetail(BillType.采购退货出库单, stockReturnStoreOut) ;
            } else if (stockReturnStoreOut.getStockReturn().getReturnType().equals(ReturnType.开票后退货)) {
                iStockPaymentbillCreateService.removeDetail(BillType.采购退货出库单, stockReturnStoreOut) ;
            }

            iStockSummaryService.summary(BillType.采购退货出库单, stockReturnStoreOut) ;
            break ;

        default:
            throw new SystemOptServiceException("status " + stockReturnStoreOut.getStatus() + " error") ;
        }
    }

    private void cancelCheck(StockReturnStoreOut stockReturnStoreOut, Integer optUserId) throws SystemOptServiceException {
        if (stockReturnStoreOut.getStockType().equals(StockType.直营采购退货单)) {
            throw new SystemOptServiceException("此单是" + StockType.直营采购退货单.name() + "不能取消审核") ;
        } else {
            stockReturnStoreOut.setCheckMan(null) ;
            stockReturnStoreOut.setStatus(Status.有效) ;
            stockReturnStoreOut.setCheckDate(null) ;
            baseService.update(stockReturnStoreOut) ;
        }

    }

    //    public void check(Integer id, Integer optUserId) throws SystemOptServiceException {
    //        StockStoreReceive stockStoreReceive = baseService.get(id, StockStoreReceive.class) ;
    //        check(stockStoreReceive, optUserId) ;
    //    }

    private void checking(StockReturnStoreOut stockReturnStoreOut, Integer optUserId) throws SystemOptServiceException {
        SysStaffUser checkMan = baseService.load(optUserId, SysStaffUser.class) ;
        stockReturnStoreOut.setCheckMan(checkMan) ;
        stockReturnStoreOut.setStatus(Status.已审核) ;
        stockReturnStoreOut.setCheckDate(DateToolsUilts.getnowDate()) ;
        baseService.update(stockReturnStoreOut) ;

    }
}
