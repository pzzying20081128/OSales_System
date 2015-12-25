package cn.zying.osales.service.stocks.units ;

import java.util.List ;

import org.codehaus.jackson.map.deser.ValueInstantiators.Base ;
import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.StockBillIsReconciliation ;
import cn.zying.osales.pojos.StockInvoice ;
import cn.zying.osales.pojos.StockInvoiceBillDetail ;
import cn.zying.osales.pojos.StockInvoiceDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

/**
 * 取消对帐
 * @author you
 *
 */
@Component("StockInvoiceDetailCancelReconcileUnits")
public class StockInvoiceDetailCancelReconcileUnits extends ABCommonsService {

    public StockInvoiceBillDetail cancelReconciles(StockInvoice stockInvoice, StockInvoiceDetail stockInvoiceDetail) throws SystemOptServiceException {
        if (stockInvoice.getReconciliationSum().longValue() == stockInvoice.getInvoiceSum()) {
            throw new SystemOptServiceException("该发票的对帐金额等于该发票金额") ;

        }

        if (stockInvoiceDetail == null) {
            throw new SystemOptServiceException("该单据的已对金额为空") ;
        }
        //        StockInvoiceBillDetail stockInvoiceBillDetail = baseService.get(StockInvoiceBillDetail.class, stockInvoiceDetail.getStockInvoiceBillDetailId()) ;

        StockInvoiceBillDetail stockInvoiceBillDetail = err(stockInvoice, stockInvoiceDetail) ;

        baseService.remove(stockInvoiceDetail) ;

        stockInvoiceBillDetail.setStockInvoiceDetail(stockInvoiceDetail) ;

        if (stockInvoice.getNoKillSum() == stockInvoice.getReconciliationSum()) {
            stockInvoice.setReconciliation(StockBillIsReconciliation.末对帐) ;
        } else if (stockInvoice.getNoKillSum() > 0 && stockInvoice.getNoKillSum() < stockInvoice.getReconciliationSum()) {
            stockInvoice.setReconciliation(StockBillIsReconciliation.已对帐) ;
        } else {
            stockInvoice.setReconciliation(StockBillIsReconciliation.全部对帐) ;
        }

        baseService.update(stockInvoice) ;

        return stockInvoiceBillDetail ;

    }

    public void cancelReconciles(StockInvoice stockInvoice) throws SystemOptServiceException {
        List<StockInvoiceDetail> stockInvoiceDetails = stockInvoice.getStockInvoiceDetails() ;
        for (StockInvoiceDetail stockInvoiceDetail : stockInvoiceDetails) {

            StockInvoiceBillDetail stockInvoiceBillDetail = stockInvoiceDetail.getStockInvoiceBillDetail() ;

            err(stockInvoice, stockInvoiceDetail) ;

        }

        String sql = "delete     StockInvoiceDetail  as  stockInvoiceDetail   where stockInvoiceDetail.stockInvoiceId = " + stockInvoice.getId() ;

        baseService.executeByHSQL(sql) ;

        if (stockInvoice.getNoKillSum() == stockInvoice.getReconciliationSum()) {
            stockInvoice.setReconciliation(StockBillIsReconciliation.末对帐) ;
        } else if (stockInvoice.getNoKillSum() > 0 && stockInvoice.getNoKillSum() < stockInvoice.getReconciliationSum()) {
            stockInvoice.setReconciliation(StockBillIsReconciliation.已对帐) ;
        } else {
            stockInvoice.setReconciliation(StockBillIsReconciliation.全部对帐) ;
        }

        baseService.update(stockInvoice) ;
    }

    private StockInvoiceBillDetail err(StockInvoice stockInvoice, StockInvoiceDetail stockInvoiceDetail) {

        Long killSum = stockInvoiceDetail.getKillSum() ;

        StockInvoiceBillDetail stockInvoiceBillDetail = stockInvoiceDetail.getStockInvoiceBillDetail() ;

        stockInvoiceBillDetail.setNoKillSum(stockInvoiceBillDetail.getNoKillSum() + killSum) ;

        stockInvoiceBillDetail.setKillSum(stockInvoiceBillDetail.getBillSum() - stockInvoiceBillDetail.getNoKillSum()) ;

        baseService.update(stockInvoiceBillDetail) ;

        stockInvoice.setNoKillSum(stockInvoice.getNoKillSum() + killSum) ;

        stockInvoice.setKillSum(stockInvoice.getInvoiceSum() - stockInvoice.getNoKillSum()) ;

        stockInvoice.setReconciliationSum(stockInvoice.getNoKillSum()) ;

        return stockInvoiceBillDetail ;

    }

}
