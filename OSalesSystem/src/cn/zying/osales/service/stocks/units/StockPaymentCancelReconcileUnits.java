package cn.zying.osales.service.stocks.units ;

import java.util.List ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.StockBillIsReconciliation ;
import cn.zying.osales.pojos.StockPayment ;
import cn.zying.osales.pojos.StockPaymentBillDetail ;
import cn.zying.osales.pojos.StockPaymentDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

/**
 * 取消对帐
 * @author you
 *
 */
@Component("StockPaymentCancelReconcileUnits")
public class StockPaymentCancelReconcileUnits extends ABCommonsService {

    //    @Autowired
    //    @Qualifier(IStockPaymentbillDetailService.name)
    //    private IStockPaymentbillDetailService iStockPaymentbillDetailService ;

    private void update(StockPayment stockPayment) throws SystemOptServiceException {
        baseService.update(stockPayment) ;
    }

    /**
     * 取消对帐
     * @param stockInvoice
     * @param stockInvoiceDetail
     * @return
     * @throws SystemOptServiceException
     */
    public StockPaymentBillDetail cancelReconcile(StockPayment stockPayment, StockPaymentDetail stockPaymentDetail) throws SystemOptServiceException {
        if (stockPayment.getReconciliationSum().longValue() == stockPayment.getPaymentSum()) {
            throw new SystemOptServiceException("该发票的对帐金额等于该发票金额") ;

        }

        if (stockPaymentDetail == null) {
            throw new SystemOptServiceException("该单据的已对金额为空") ;
        }
        //        StockInvoiceBillDetail stockInvoiceBillDetail = baseService.get(StockInvoiceBillDetail.class, stockInvoiceDetail.getStockInvoiceBillDetailId()) ;

        StockPaymentBillDetail stockPaymentBillDetail = cancel(stockPayment, stockPaymentDetail) ;

        baseService.remove(stockPaymentDetail) ;

        stockPaymentBillDetail.setStockPaymentDetail(null) ;

        if (stockPayment.getNoKillSum() == stockPayment.getReconciliationSum()) {
            stockPayment.setReconciliation(StockBillIsReconciliation.末对帐) ;
        } else if (stockPayment.getNoKillSum() > 0 && stockPayment.getNoKillSum() < stockPayment.getReconciliationSum()) {
            stockPayment.setReconciliation(StockBillIsReconciliation.已对帐) ;
        } else {
            stockPayment.setReconciliation(StockBillIsReconciliation.全部对帐) ;
        }

        update(stockPayment) ;

        return stockPaymentBillDetail ;

    }

    /**
     * 取消全部对帐
     * @param stockInvoice
     * @throws SystemOptServiceException
     */
    public StockPayment cancelAllReconcile(Integer  stockPaymentId) throws SystemOptServiceException {
        StockPayment stockPayment = baseService.get(stockPaymentId, StockPayment.class) ;
        List<StockPaymentDetail> stockPaymentDetails = stockPayment.getStockPaymentDetails() ;
        for (StockPaymentDetail stockPaymentDetail : stockPaymentDetails) {

            cancel(stockPayment, stockPaymentDetail) ;

        }

        String sql = "delete     StockPaymentDetail  as  stockPaymentDetail   where stockPaymentDetail.stockPaymentId = " + stockPayment.getId() ;

        baseService.executeByHSQL(sql) ;

        if (stockPayment.getNoKillSum() == stockPayment.getReconciliationSum()) {
            stockPayment.setReconciliation(StockBillIsReconciliation.末对帐) ;
        } else if (stockPayment.getNoKillSum() > 0 && stockPayment.getNoKillSum() < stockPayment.getReconciliationSum()) {
            stockPayment.setReconciliation(StockBillIsReconciliation.已对帐) ;
        } else {
            stockPayment.setReconciliation(StockBillIsReconciliation.全部对帐) ;
        }

        update(stockPayment) ;
        return stockPayment ;
    }

    private StockPaymentBillDetail cancel(StockPayment stockPayment, StockPaymentDetail stockPaymentDetail) {

        Long killSum = stockPaymentDetail.getKillSum() ;
        //stockPaymentDetail.getStockPaymentBillDetail() ;
        StockPaymentBillDetail stockPaymentBillDetail = baseService.get(stockPaymentDetail.getStockPaymentBillDetailId(), StockPaymentBillDetail.class) ;

        stockPaymentBillDetail.setNoKillSum(stockPaymentBillDetail.getNoKillSum() + killSum) ;

        stockPaymentBillDetail.setKillSum(stockPaymentBillDetail.getPaymentSum() - stockPaymentBillDetail.getNoKillSum()) ;

        baseService.update(stockPaymentBillDetail) ;

        stockPayment.setNoKillSum(stockPayment.getNoKillSum() + killSum) ;

        stockPayment.setKillSum(stockPayment.getPaymentSum() - stockPayment.getNoKillSum()) ;

        stockPayment.setReconciliationSum(stockPayment.getNoKillSum()) ;

        return stockPaymentBillDetail ;

    }

}
