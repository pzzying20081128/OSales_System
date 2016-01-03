package cn.zying.osales.service.stocks.units ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.DateToolsUilts ;
import cn.zying.osales.OSalesConfigProperties.BillType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.OSalesConfigProperties.StockType ;
import cn.zying.osales.pojos.StockStoreReceive ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.invoice.IStockInvoiceDetailCreateService ;
import cn.zying.osales.service.stocks.summary.IStockSummaryService ;

@Component("StockStoreReceiveCheckUnits")
public class StockStoreReceiveCheckUnits extends ABCommonsService {

    @Autowired
    @Qualifier(IStockInvoiceDetailCreateService.name)
    private IStockInvoiceDetailCreateService iStockInvoiceDetailCreateService ;
    
    @Autowired
    @Qualifier(IStockSummaryService.name)
    private IStockSummaryService iStockSummaryService ;
    
    

    public void cancelCheckDel(StockStoreReceive stockStoreReceive, Integer optUserId) throws SystemOptServiceException {
        if (stockStoreReceive == null) return ;
        if (stockStoreReceive.getStockType().equals(StockType.直营采购订单)) {
            baseService.remove(stockStoreReceive) ;
        } else if (stockStoreReceive.getStockType().equals(StockType.采购订单)) {
            if (stockStoreReceive.getStatus().equals(Status.已审核)) {
                throw new SystemOptServiceException("此采购进货单[" + stockStoreReceive.getNumber() + "]已被审核") ;
            } else {
                baseService.remove(stockStoreReceive) ;
            }
        }
    }

    public void check(StockStoreReceive stockStoreReceive, Integer optUserId) throws SystemOptServiceException {
        switch (stockStoreReceive.getStatus()) {
        case 有效:
            checking(stockStoreReceive, optUserId) ;
            iStockInvoiceDetailCreateService.createInvoiceDetail(BillType.采购进货单, stockStoreReceive) ;
            iStockSummaryService.summary(BillType.采购进货单 , stockStoreReceive);
            break ;
        case 已审核:
            cancelCheck(stockStoreReceive, optUserId) ;
            iStockInvoiceDetailCreateService.removeInvoiceDetail(BillType.采购进货单, stockStoreReceive) ;
            iStockSummaryService.removeSummary(BillType.采购进货单, stockStoreReceive);
            break ;

        default:
            throw new SystemOptServiceException("status " + stockStoreReceive.getStatus() + " error") ;
        }
    }

    private void cancelCheck(StockStoreReceive stockStoreReceive, Integer optUserId) throws SystemOptServiceException {
        if (stockStoreReceive.getStockType().equals(StockType.直营采购订单)) {
            throw new SystemOptServiceException("此单是" + StockType.直营采购订单.name() + "不能取消审核") ;
        } else {
            stockStoreReceive.setCheckMan(null) ;
            stockStoreReceive.setStatus(Status.有效) ;
            stockStoreReceive.setCheckDate(null) ;
            baseService.update(stockStoreReceive) ;
        }

    }

    public void check(Integer id, Integer optUserId) throws SystemOptServiceException {
        StockStoreReceive stockStoreReceive = baseService.get(id, StockStoreReceive.class) ;
        check(stockStoreReceive, optUserId) ;
    }

    private void checking(StockStoreReceive stockStoreReceive, Integer optUserId) throws SystemOptServiceException {
        SysStaffUser checkMan = baseService.load(optUserId, SysStaffUser.class) ;
        stockStoreReceive.setCheckMan(checkMan) ;
        stockStoreReceive.setStatus(Status.已审核) ;
        stockStoreReceive.setCheckDate(DateToolsUilts.getnowDate()) ;
        baseService.update(stockStoreReceive) ;

    }
}
