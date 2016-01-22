package cn.zying.osales.service.stocks.summary ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.BillType ;
import cn.zying.osales.pojos.StockAdjustBill ;
import cn.zying.osales.pojos.StockSummaryBill ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

/**
 * 采购调整单
 * @author you
 *
 */
@Component("StockAdjustSummaryUnits")
public class StockAdjustSummaryUnits extends ABCommonsService {

    public void summary(StockAdjustBill stockAdjustBill) throws SystemOptServiceException {

        {

            StockSummaryBill stockSummaryBill = StockSummaryServiceImple.init(stockAdjustBill.getCheckedTime()) ;

            stockSummaryBill.setBillNum(stockAdjustBill.getAdjustNum()) ;

            stockSummaryBill.setBillType(BillType.采购调整单) ;
            stockSummaryBill.setProviderInfo(stockAdjustBill.getProviderInfo()) ;
            stockSummaryBill.setProviderInfoId(stockAdjustBill.getProviderInfoId()) ;
            stockSummaryBill.setStockAdjustSumMoney(stockAdjustBill.getAdjustSum()) ;
            baseService.save(stockSummaryBill) ;

        }

    }

}
