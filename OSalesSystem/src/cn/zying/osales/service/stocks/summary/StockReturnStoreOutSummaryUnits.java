package cn.zying.osales.service.stocks.summary ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.BillType ;
import cn.zying.osales.pojos.StockReturnStoreOut ;
import cn.zying.osales.pojos.StockReturnStoreOutDetail ;
import cn.zying.osales.pojos.StockSummaryBill ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockReturnStoreOutSummaryUnits")
public class StockReturnStoreOutSummaryUnits extends ABCommonsService {

    public void summary(StockReturnStoreOut stockReturnStoreOut) throws SystemOptServiceException {

        for (StockReturnStoreOutDetail stockReturnStoreOutDetail : stockReturnStoreOut.getStockReturnStoreOutDetails()) {

            StockSummaryBill stockSummaryBill = StockSummaryServiceImple.init(stockReturnStoreOut.getCheckDate()) ;

            stockSummaryBill.setBillNum(stockReturnStoreOut.getNumber()) ;

            stockSummaryBill.setBillType(BillType.采购退货出库单) ;

            stockSummaryBill.setProductInfo(stockReturnStoreOutDetail.getProductInfo()) ;
            stockSummaryBill.setProductInfoId(stockReturnStoreOutDetail.getProductInfoId()) ;
            stockSummaryBill.setProviderInfo(stockReturnStoreOut.getProviderInfo()) ;
            stockSummaryBill.setProviderInfoId(stockReturnStoreOut.getProviderInfoId()) ;

            stockSummaryBill.setReturnGoodsCount(stockReturnStoreOutDetail.getOrderCount()) ;

            stockSummaryBill.setReturnGoodsNoTaxSumMoney(stockReturnStoreOutDetail.getNoTaxMoney()) ;

            stockSummaryBill.setReturnGoodsTaxSumMoney(stockReturnStoreOutDetail.getTaxMoney()) ;

            baseService.save(stockSummaryBill) ;

        }

    }

}
