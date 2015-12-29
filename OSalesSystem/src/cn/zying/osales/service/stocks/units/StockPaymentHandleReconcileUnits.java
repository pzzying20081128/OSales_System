package cn.zying.osales.service.stocks.units ;

import java.util.List ;

import org.hibernate.dialect.lock.OptimisticEntityLockException ;
import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.StockBillIsReconciliation ;
import cn.zying.osales.pojos.StockInvoice ;
import cn.zying.osales.pojos.StockInvoiceBillDetail ;
import cn.zying.osales.pojos.StockInvoiceDetail ;
import cn.zying.osales.pojos.StockPayment ;
import cn.zying.osales.pojos.StockPaymentBillDetail ;
import cn.zying.osales.pojos.StockPaymentDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

/**
 *  自动对帐
 * @author you
 *
 */
/**
 * 
 * @author you
 *
 */
@Component("StockPaymentHandleReconcileUnits")
public class StockPaymentHandleReconcileUnits extends ABCommonsService {

    private void update(StockPayment stockPayment) {
        baseService.update(stockPayment) ;

    }

    //    private StockPayment load(StockPayment stockPayment) throws SystemOptServiceException {
    //        return baseService.get(stockPayment.getId(), StockPayment.class) ;
    //    }

    private long auto_Reconcile(StockPayment stockPayment, long reconciliationSum, StockPaymentBillDetail stockPaymentBillDetail) {

        long kill = (reconciliationSum >= stockPaymentBillDetail.getNoKillSum()) ? stockPaymentBillDetail.getNoKillSum() : reconciliationSum ;

        reconciliationSum = reconcile(stockPayment, reconciliationSum, stockPaymentBillDetail, kill) ;

        return reconciliationSum ;
    }

    public StockPaymentBillDetail manualReconcile(Integer  stockPaymentId, StockPaymentBillDetail stockPaymentBillDetail) throws SystemOptServiceException {

        StockPayment stockPayment = baseService.get(stockPaymentId, StockPayment.class) ;

        long reconciliationSum = stockPayment.getReconciliationSum() ;

        long kill = stockPaymentBillDetail.getStockPaymentDetailKillSum() ;

        reconciliationSum = reconcile(stockPayment, reconciliationSum, stockPaymentBillDetail, kill) ;

        update(stockPayment) ;

        return stockPaymentBillDetail ;

    }

    public StockPaymentBillDetail autoReconcile(Integer stockPaymentId, Integer stockPaymentBillDetailId) throws SystemOptServiceException {
        StockPayment stockPayment = baseService.get(stockPaymentId, StockPayment.class) ;
        StockPaymentBillDetail stockPaymentBillDetail = baseService.get(stockPaymentBillDetailId, StockPaymentBillDetail.class) ;
        long reconciliationSum = stockPayment.getReconciliationSum() ;
        reconciliationSum = auto_Reconcile(stockPayment, reconciliationSum, stockPaymentBillDetail) ;
        update(stockPayment) ;
        stockPaymentBillDetail.setStockPayment(stockPayment);
        return stockPaymentBillDetail ;
    }

    private List<StockPaymentBillDetail> search(StockPayment stockPayment) throws SystemOptServiceException {
        String sql = "select  stockPaymentBillDetail   from  StockPaymentBillDetail as  stockPaymentBillDetail   " +

        " where  stockPaymentBillDetail.providerInfoId = " + stockPayment.getProviderInfoId() +

        " and   stockPaymentBillDetail.killSum  <  stockPaymentBillDetail.paymentSum " ;

        return baseService.findByHSQL(sql) ;
    }

    public StockPayment autoAllReconcile(Integer stockPaymentId) throws SystemOptServiceException {
        StockPayment stockPayment = baseService.get(stockPaymentId, StockPayment.class) ;

        long reconciliationSum = stockPayment.getReconciliationSum() ;

        List<StockPaymentBillDetail> stockPaymentBillDetails = search(stockPayment) ;

        for (StockPaymentBillDetail stockPaymentBillDetail : stockPaymentBillDetails) {

            reconciliationSum = auto_Reconcile(stockPayment, reconciliationSum, stockPaymentBillDetail) ;

            if (reconciliationSum == 0) break ;
        }
        update(stockPayment) ;
        return stockPayment ;

    }

    private long reconcile(StockPayment stockPayment, long reconciliationSum, StockPaymentBillDetail stockPaymentBillDetail, long kill) {

        StockPaymentDetail stockPaymentDetail = new StockPaymentDetail() ;

        stockPaymentDetail.setKillSum(kill) ;

        stockPaymentDetail.setStockPayment(stockPayment) ;

        stockPaymentDetail.setStockPaymentBillDetail(stockPaymentBillDetail) ;

        stockPaymentDetail.setStockPaymentBillDetailId(stockPaymentBillDetail.getId()) ;

        stockPaymentDetail.setStockPaymentId(stockPayment.getId()) ;

        stockPaymentDetail.setStockPayment(stockPayment) ;

        baseService.save(stockPaymentDetail) ;

        stockPaymentBillDetail.setKillSum(stockPaymentBillDetail.getKillSum() + kill) ;

        stockPaymentBillDetail.setNoKillSum(stockPaymentBillDetail.getPaymentSum() - stockPaymentBillDetail.getKillSum()) ;

        // 增加了 已对票
        stockPaymentBillDetail.setStockPaymentDetail(stockPaymentDetail) ;

        baseService.update(stockPaymentBillDetail) ;
        ////////////////////////////////////////////////////////////////////////////////
        stockPayment.setKillSum(stockPayment.getKillSum() + stockPaymentDetail.getKillSum()) ;

        stockPayment.setNoKillSum(stockPayment.getPaymentSum() - stockPayment.getKillSum()) ;

        stockPayment.setReconciliationSum(stockPayment.getNoKillSum()) ;

        if (stockPayment.getNoKillSum() > 0) {
            stockPayment.setReconciliation(StockBillIsReconciliation.已对帐) ;
        } else {
            stockPayment.setReconciliation(StockBillIsReconciliation.全部对帐) ;

        }

        reconciliationSum = reconciliationSum - kill ;
        return reconciliationSum ;
    }

}
