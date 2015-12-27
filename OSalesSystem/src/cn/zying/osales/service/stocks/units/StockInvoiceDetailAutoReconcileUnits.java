package cn.zying.osales.service.stocks.units ;

import java.util.List ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.StockBillIsReconciliation ;
import cn.zying.osales.pojos.StockInvoice ;
import cn.zying.osales.pojos.StockInvoiceBillDetail ;
import cn.zying.osales.pojos.StockInvoiceDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

/**
 * 发票自动对票
 * @author you
 *
 */
@Component("StockInvoiceDetailAutoReconcileUnits")
public class StockInvoiceDetailAutoReconcileUnits extends ABCommonsService {

    public StockInvoiceBillDetail handleReconcile(StockInvoice stockInvoice, StockInvoiceBillDetail stockInvoiceBillDetail) throws SystemOptServiceException {
        if (stockInvoice.getReconciliationSum().longValue() == 0) {
            throw new SystemOptServiceException("该发票的对帐金额为零") ;
        }
        long reconciliationSum = stockInvoice.getReconciliationSum() ;
        reconciliationSum = handleReconcile(stockInvoice, reconciliationSum, stockInvoiceBillDetail) ;
        baseService.update(stockInvoice) ;
        return stockInvoiceBillDetail ;
    }

    public StockInvoiceBillDetail autoReconcile(StockInvoice stockInvoice, StockInvoiceBillDetail stockInvoiceBillDetail) throws SystemOptServiceException {
        if (stockInvoice.getReconciliationSum().longValue() == 0) {
            throw new SystemOptServiceException("该发票的对帐金额为零") ;
        }
        long reconciliationSum = stockInvoice.getReconciliationSum() ;
        reconciliationSum = autoReconcile(stockInvoice, reconciliationSum, stockInvoiceBillDetail) ;
        baseService.update(stockInvoice) ;
        return stockInvoiceBillDetail ;
    }

    public void autoReconciles(StockInvoice stockInvoice) throws SystemOptServiceException {
        //查询统一供应商
        long reconciliationSum = stockInvoice.getReconciliationSum() ;

        List<StockInvoiceBillDetail> stockInvoiceBillDetailes = search(stockInvoice) ;

        for (StockInvoiceBillDetail stockInvoiceBillDetail : stockInvoiceBillDetailes) {

            reconciliationSum = autoReconcile(stockInvoice, reconciliationSum, stockInvoiceBillDetail) ;

            if (reconciliationSum == 0) break ;
        }
        baseService.update(stockInvoice) ;
    }

    private long handleReconcile(StockInvoice stockInvoice, long reconciliationSum, StockInvoiceBillDetail stockInvoiceBillDetail) {

        long kill = stockInvoiceBillDetail.getStockInvoiceDetailKillSum() ;

        reconciliationSum = reconcile(stockInvoice, reconciliationSum, stockInvoiceBillDetail, kill) ;

        return reconciliationSum ;
    }

    private long reconcile(StockInvoice stockInvoice, long reconciliationSum, StockInvoiceBillDetail stockInvoiceBillDetail, long kill) {

        StockInvoiceDetail stockInvoiceDetail = new StockInvoiceDetail() ;

        stockInvoiceDetail.setKillSum(kill) ;

        stockInvoiceDetail.setStockInvoice(stockInvoice) ;

        stockInvoiceDetail.setStockInvoiceBillDetail(stockInvoiceBillDetail) ;

        stockInvoiceDetail.setStockInvoiceBillDetailId(stockInvoiceBillDetail.getId()) ;

        stockInvoiceDetail.setStockInvoiceId(stockInvoice.getId()) ;

        stockInvoiceDetail.setStockInvoice(stockInvoice) ;

        baseService.save(stockInvoiceDetail) ;

        stockInvoiceBillDetail.setKillSum(stockInvoiceBillDetail.getKillSum() + kill) ;

        stockInvoiceBillDetail.setNoKillSum(stockInvoiceBillDetail.getBillSum() - stockInvoiceBillDetail.getKillSum()) ;

        // 增加了 已对票
        stockInvoiceBillDetail.setStockInvoiceDetail(stockInvoiceDetail) ;

        baseService.update(stockInvoiceBillDetail) ;
        ////////////////////////////////////////////////////////////////////////////////
        stockInvoice.setKillSum(stockInvoice.getKillSum() + stockInvoiceDetail.getKillSum()) ;

        stockInvoice.setNoKillSum(stockInvoice.getInvoiceSum() - stockInvoice.getKillSum()) ;

        stockInvoice.setReconciliationSum(stockInvoice.getNoKillSum()) ;

        if (stockInvoice.getNoKillSum() > 0) {
            stockInvoice.setReconciliation(StockBillIsReconciliation.已对帐) ;
        } else {
            stockInvoice.setReconciliation(StockBillIsReconciliation.全部对帐) ;
        }

        reconciliationSum = reconciliationSum - kill ;
        return reconciliationSum ;
    }

    private long autoReconcile(StockInvoice stockInvoice, long reconciliationSum, StockInvoiceBillDetail stockInvoiceBillDetail) {

        long kill = (reconciliationSum >= stockInvoiceBillDetail.getNoKillSum()) ? stockInvoiceBillDetail.getNoKillSum() : reconciliationSum ;

        reconciliationSum = reconcile(stockInvoice, reconciliationSum, stockInvoiceBillDetail, kill) ;

        return reconciliationSum ;
    }

    private List<StockInvoiceBillDetail> search(StockInvoice stockInvoice) throws SystemOptServiceException {
        String sql = "select  stockInvoiceBillDetail   from  StockInvoiceBillDetail as  stockInvoiceBillDetail   " +

        " where  stockInvoiceBillDetail.providerInfoId = " + stockInvoice.getProviderInfoId() +

        " and   stockInvoiceBillDetail.killSum  <  stockInvoiceBillDetail.billSum " ;

        return baseService.findByHSQL(sql) ;
    }

}
