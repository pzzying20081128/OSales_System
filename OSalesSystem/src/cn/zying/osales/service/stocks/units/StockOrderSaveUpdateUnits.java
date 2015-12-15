package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.DateToolsUilts ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.units.ToolsUnitsException ;
import cn.zying.osales.OSalesConfigProperties.OptSum ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.ProductInfoType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.ProviderInfo ;
import cn.zying.osales.pojos.StockOrder ;
import cn.zying.osales.pojos.StockOrderDetail ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockOrderSaveUpdateUnits")
public class StockOrderSaveUpdateUnits extends ABCommonsService {

    public void updateSumMoney(StockOrder stockOrder, StockOrderDetail stockOrderDetail, OptSum optSum) throws SystemOptServiceException {

        Integer orderCount = stockOrder.getOrderCount() == null ? 0 : stockOrder.getOrderCount() ;

        Long noTaxSumMoney = stockOrder.getNoTaxSumMoney() == null ? 0 : stockOrder.getNoTaxSumMoney() ;

        Long taxSumMoney = stockOrder.getTaxSumMoney() == null ? 0 : stockOrder.getTaxSumMoney() ;

        switch (optSum) {
        case add:
            orderCount = orderCount + stockOrderDetail.getOrderCount() ;

            noTaxSumMoney = noTaxSumMoney + stockOrderDetail.getNoTaxMoney() ;

            taxSumMoney = taxSumMoney + stockOrderDetail.getTaxMoney() ;
            break ;
        case del:

            orderCount = orderCount - stockOrderDetail.getOrderCount() ;

            noTaxSumMoney = noTaxSumMoney - stockOrderDetail.getNoTaxMoney() ;

            taxSumMoney = taxSumMoney - stockOrderDetail.getTaxMoney() ;

            break ;

        default:
            throw new SystemOptServiceException("optSum  error !  " + optSum) ;
        }

        stockOrder.setOrderCount(orderCount) ;

        stockOrder.setTaxSumMoney(taxSumMoney) ;

        stockOrder.setNoTaxSumMoney(noTaxSumMoney) ;

        baseService.update(stockOrder) ;

    }

    public StockOrder saveUpdate(OptType optType, StockOrder optStockOrder) throws SystemOptServiceException {

        switch (optType) {
        case init:
            return init(optStockOrder) ;

        case update:
        case save:
            return save_Update(optType, optStockOrder) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    private StockOrder init(StockOrder optStockOrder) {
        optStockOrder.setStatus(Status.初始化) ;

        baseService.save(optStockOrder) ;

        return optStockOrder ;
    }

    public void check(StockOrder optStockOrder) throws SystemOptServiceException {

        String sql = "   select  count(stockOrder.id)  from  StockOrder as stockOrder   where  stockOrder.number='"

        + optStockOrder.getNumber() + "'  "

        + "  and   stockOrder.id !=" + optStockOrder.getId() ;

        Long cont = baseService.selectSumByHSQL(sql) ;

        if (cont == null || cont.intValue() == 0) {

        } else {
            throw new SystemOptServiceException("采购单号重复") ;
        }

        ProductInfoType productInfoType = optStockOrder.getStockProductType() ;

        String productInfoTypeSql = "   select  count(stockOrderDetail.id)  from  StockOrderDetail  as stockOrderDetail   " +

        "    inner join  stockOrderDetail.productInfo as  productInfo  " +

        "    where  productInfo.productInfoType!='" + productInfoType.name() + "'  "

        + "  and   stockOrderDetail.stockOrderId =" + optStockOrder.getId() ;

        cont = baseService.selectSumByHSQL(productInfoTypeSql) ;

        if (cont != null && cont.intValue() > 0) {

            throw new SystemOptServiceException("采购订单明细中包含有不是[" + productInfoType.name() + "]产品,不能修改采购类型为" + productInfoType.name()) ;
        }
    }

    public StockOrder save_Update(OptType optType, StockOrder optStockOrder) throws SystemOptServiceException {

        try {

            check(optStockOrder) ;

            StockOrder stockOrder = baseService.load(optStockOrder.getId(), StockOrder.class) ;

            stockOrder.setStatus(Status.有效) ;

            stockOrder.setRecordDate(DateToolsUilts.getnowDate()) ;

            initOrder(optStockOrder) ;

            ToolsUnits.copyBeanProperties(stockOrder, optStockOrder, "orderDate", "number", "stockType", "providerInfo", "stockMan", "stockDate", "stockProductType", "remarks", "text", "recordMan") ;

            baseService.update(stockOrder) ;

            return optStockOrder ;

        } catch (ToolsUnitsException e) {
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

        Integer stockManId = optStockOrder.getStockManId() ;
        if (stockManId != null) {
            SysStaffUser stockMan = baseService.load(stockManId, SysStaffUser.class) ;

            optStockOrder.setStockMan(stockMan) ;
        }

    }

}
