package cn.zying.osales.service.stocks.summary ;

import java.util.Date ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.OSalesConfigProperties.BillType ;
import cn.zying.osales.pojos.StockAdjustBill ;
import cn.zying.osales.pojos.StockReturnStoreOut ;
import cn.zying.osales.pojos.StockStoreReceive ;
import cn.zying.osales.pojos.StockSummaryBill ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component(IStockSummaryService.name)
public class StockSummaryServiceImple extends ABCommonsService implements IStockSummaryService {

    public static StockSummaryBill init(Date createTime) {
        StockSummaryBill stockSummaryBill = new StockSummaryBill() ;
        stockSummaryBill.setReturnGoodsCount(OSalesConfigProperties.isDefault_0) ;
        stockSummaryBill.setReturnGoodsNoTaxSumMoney(OSalesConfigProperties.default_long_null) ;
        stockSummaryBill.setReturnGoodsTaxSumMoney(OSalesConfigProperties.default_long_null) ;

        stockSummaryBill.setStockAdjustSumMoney(OSalesConfigProperties.default_long_null) ;

        stockSummaryBill.setStockCount(OSalesConfigProperties.default_int_null) ;
        stockSummaryBill.setStockTaxSumMoney(OSalesConfigProperties.default_long_null) ;
        stockSummaryBill.setStockNoTaxSumMoney(OSalesConfigProperties.default_long_null) ;

        stockSummaryBill.setBillTime(createTime) ;

        return stockSummaryBill ;
    }

    @Autowired
    @Qualifier("StockStoreReceiveSummaryUnits")
    private StockStoreReceiveSummaryUnits stockStoreReceiveSummaryUnits ;

    @Autowired
    @Qualifier("StockReturnStoreOutSummaryUnits")
    private StockReturnStoreOutSummaryUnits stockReturnStoreOutSummaryUnits ;

    @Autowired
    @Qualifier("StockAdjustSummaryUnits")
    private StockAdjustSummaryUnits stockAdjustSummaryUnits ;

    @Override
    public <T> void summary(BillType billType, T bill) throws SystemOptServiceException {
        switch (billType) {
        case 采购进货单:
            stockStoreReceiveSummaryUnits.summary((StockStoreReceive) bill) ;
            break ;
        case 采购退货出库单:
            stockReturnStoreOutSummaryUnits.summary((StockReturnStoreOut) bill) ;
            break ;
        case 采购调整单:
            stockAdjustSummaryUnits.summary((StockAdjustBill) bill) ;
            break ;

        default:
            throw new SystemOptServiceException("StockSummaryService BillType [" + billType.name() + "] Error ") ;
        }

    }

    @Override
    public <T> void removeSummary(BillType billType, T bill) throws SystemOptServiceException {
        String num = null ;
        switch (billType) {
        case 采购进货单:
            StockStoreReceive StockStoreReceive = (StockStoreReceive) bill ;
            num = StockStoreReceive.getNumber() ;
            break ;
        case 采购退货出库单:
            StockReturnStoreOut stockReturnStoreOut = (StockReturnStoreOut) bill ;
            num = stockReturnStoreOut.getNumber() ;

            break ;
        case 采购调整单:
            StockAdjustBill stockAdjustBill = (StockAdjustBill) bill ;
            num = stockAdjustBill.getAdjustNum() ;
            break ;

        default:
            throw new SystemOptServiceException("StockSummaryService BillType [" + billType.name() + "] Error ") ;
        }

        String sql = "delete  StockSummaryBill  as   stockSummaryBill    " +

        "    where     stockSummaryBill.billType ='" + billType.name() + "'     " +

        "     and    stockSummaryBill.billNum ='" + num + "'" ;

        baseService.executeByHSQL(sql) ;

    }

}
