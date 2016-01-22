package cn.zying.osales.service.stocks.summary ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.BillType ;
import cn.zying.osales.pojos.StockStoreReceive ;
import cn.zying.osales.pojos.StockStoreReceiveDetail ;
import cn.zying.osales.pojos.StockSummaryBill ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockStoreReceiveSummaryUnits")
public class StockStoreReceiveSummaryUnits extends ABCommonsService {

    public void summary(StockStoreReceive stockStoreReceive) throws SystemOptServiceException {

        for (StockStoreReceiveDetail stockStoreReceiveDetail : stockStoreReceive.getStockStoreReceiveDetails()) {

            StockSummaryBill stockSummaryBill = StockSummaryServiceImple.init(stockStoreReceive.getStockInStore().getStockOrder().getStockDate()) ;
            stockSummaryBill.setBillNum(stockStoreReceive.getNumber()) ;
            stockSummaryBill.setBillType(BillType.采购进货单) ;

            stockSummaryBill.setProductInfo(stockStoreReceiveDetail.getProductInfo()) ;
            stockSummaryBill.setProductInfoId(stockStoreReceiveDetail.getProductInfoId()) ;
            stockSummaryBill.setProviderInfo(stockStoreReceive.getProviderInfo()) ;
            stockSummaryBill.setProviderInfoId(stockStoreReceive.getProviderInfoId()) ;

            stockSummaryBill.setStockCount(stockStoreReceiveDetail.getOrderCount()) ;

            stockSummaryBill.setStockNoTaxSumMoney(stockStoreReceiveDetail.getNoTaxMoney()) ;

            stockSummaryBill.setStockTaxSumMoney(stockStoreReceiveDetail.getTaxMoney()) ;

            baseService.save(stockSummaryBill) ;

        }

    }

}
