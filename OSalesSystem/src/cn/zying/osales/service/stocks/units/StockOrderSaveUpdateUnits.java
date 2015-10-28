package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.DateToolsUilts ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.ProviderInfo ;
import cn.zying.osales.pojos.StockOrder ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockOrderSaveUpdateUnits")
public class StockOrderSaveUpdateUnits extends ABCommonsService {

    public void updateSumMoney(Integer optStockOrderId) throws SystemOptServiceException {
        StockOrder stockOrder = baseService.load(optStockOrderId, StockOrder.class) ;
        String sql = "select  sum(stockOrderDetail.orderCount) ,sum(stockOrderDetail.taxMoney) ,sum(stockOrderDetail.noTaxMoney)      from    StockOrderDetail as  stockOrderDetail    where stockOrderDetail.stockOrderId = " + optStockOrderId ;

        Object[] result = baseService.findSinglenessByHSQL(sql) ;

        stockOrder.setOrderCount( result[0] ==null ? null : ((Long) result[0] ).intValue()) ;

        stockOrder.setTaxSumMoney( result[1] ==null ? null : (Long) result[1]) ;

        stockOrder.setNoTaxSumMoney( result[2] ==null ? null :(Long) result[2]) ;

        baseService.update(stockOrder) ;

    }

    public StockOrder saveUpdate(OptType optType, StockOrder optStockOrder) throws SystemOptServiceException {

        switch (optType) {

        case init:
            return init(optStockOrder) ;

        case update:
        case save:
            return saveUpdate(optStockOrder) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    private StockOrder init(StockOrder optStockOrder) {
        optStockOrder.setStatus(Status.初始化) ;
       
        baseService.save(optStockOrder) ;

        return optStockOrder ;
    }

    public StockOrder saveUpdate(StockOrder optStockOrder) throws SystemOptServiceException {
        try {
            StockOrder stockOrder = baseService.load(optStockOrder.getId(), StockOrder.class) ;

            optStockOrder.setStatus(Status.有效) ;

            optStockOrder.setRecordDate(DateToolsUilts.getnowDate()) ;

            initOrder(optStockOrder) ;

            ToolsUnits.copyBeanProperties(stockOrder, optStockOrder, "orderDate", "orderNumber", "stockType", "providerInfo", "stockMan", "stockDate") ;

            baseService.update(optStockOrder) ;

            return optStockOrder ;

        } catch (Exception e) {
            throw new SystemOptServiceException(e) ;
        }

    }

    private void initOrder(StockOrder optStockOrder) {

        Integer providerInfoId = optStockOrder.getProviderInfoId() ;

        ProviderInfo providerInfo = baseService.load(providerInfoId, ProviderInfo.class) ;

        optStockOrder.setProviderInfo(providerInfo) ;

        Integer recordManId = optStockOrder.getRecordManId() ;

        SysStaffUser recordMan = baseService.load(recordManId, SysStaffUser.class) ;

        optStockOrder.setRecordMan(recordMan) ;

        Integer stockManId = optStockOrder.getRecordManId() ;
        if (stockManId != null) {
            SysStaffUser stockMan = baseService.load(stockManId, SysStaffUser.class) ;

            optStockOrder.setStockMan(stockMan) ;
        }

    }

}
