package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.units.ToolsUnitsException ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInStore ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockInStoreSaveUpdateUnits")
public class StockInStoreSaveUpdateUnits extends ABCommonsService {

    //    public void updateSumMoney(Integer optStockOrderId, StockInStoreDetail stockInStoreDetail) throws SystemOptServiceException {
    //
    //        StockInStore stockInStore = baseService.load(optStockOrderId, StockInStore.class) ;
    //
    //        stockInStore.setOrderCount((stockInStore.getOrderCount() == null ? 0 : stockInStore.getOrderCount()) + stockInStoreDetail.getOrderCount()) ;
    //
    //        stockInStore.setTaxSumMoney((stockInStore.getTaxSumMoney() == null ? 0 : stockInStore.getTaxSumMoney()) + stockInStoreDetail.getTaxMoney()) ;
    //
    //        stockInStore.setNoTaxSumMoney((stockInStore.getNoTaxSumMoney() == null ? 0 : stockInStore.getNoTaxSumMoney())
    //
    //        + stockInStoreDetail.getNoTaxMoney()) ;
    //
    //        baseService.update(stockInStore) ;
    //    }

    public void updateSumMoneys(Integer optStockOrderId) throws SystemOptServiceException {
        StockInStore stockInStore = baseService.load(optStockOrderId, StockInStore.class) ;
        String sql = "select  sum(stockOrderDetail.orderCount) ,sum(stockOrderDetail.taxMoney) ,sum(stockOrderDetail.noTaxMoney)   " +

        "   from    StockInStoreDetail as  stockOrderDetail    where stockOrderDetail.stockInStoreId = " + optStockOrderId ;

        Object[] result = baseService.findSinglenessByHSQL(sql) ;

        stockInStore.setOrderCount(result[0] == null ? null : ((Long) result[0]).intValue()) ;

        stockInStore.setTaxSumMoney(result[1] == null ? null : (Long) result[1]) ;

        stockInStore.setNoTaxSumMoney(result[2] == null ? null : (Long) result[2]) ;

        baseService.update(stockInStore) ;

    }

    public StockInStore saveUpdate(OptType optType, StockInStore optStockInStore) throws SystemOptServiceException {

        switch (optType) {

        case save:
            return save(optStockInStore) ;

        case update:
            return update(optStockInStore) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    private StockInStore save(StockInStore optStockInStore) throws SystemOptServiceException {
        baseService.save(optStockInStore) ;

        return optStockInStore ;
    }

    public StockInStore update(StockInStore optStockInStore) throws SystemOptServiceException {

        StockInStore stockInStore = baseService.get(optStockInStore.getId(), StockInStore.class) ;

        try {
            ToolsUnits.copyBeanProperties(stockInStore, optStockInStore, "remarks", "text") ;

            baseService.update(stockInStore) ;

            return stockInStore ;

        } catch (ToolsUnitsException e) {
            throw new SystemOptServiceException(e) ;
        }

    }

}
