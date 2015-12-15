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
import cn.zying.osales.pojos.StockReturn ;
import cn.zying.osales.pojos.StockReturnDetail ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockReturnSaveUpdateUnits")
public class StockReturnSaveUpdateUnits extends ABCommonsService {

    public void updateSumMoney(StockReturn stockReturn, StockReturnDetail stockReturnDetail, OptSum optSum) throws SystemOptServiceException {

        Integer orderCount = stockReturn.getOrderCount() == null ? 0 : stockReturn.getOrderCount() ;

        Long noTaxSumMoney = stockReturn.getNoTaxSumMoney() == null ? 0 : stockReturn.getNoTaxSumMoney() ;

        Long taxSumMoney = stockReturn.getTaxSumMoney() == null ? 0 : stockReturn.getTaxSumMoney() ;

        switch (optSum) {
        case add:
            orderCount = orderCount + stockReturnDetail.getOrderCount() ;

            noTaxSumMoney = noTaxSumMoney + stockReturnDetail.getNoTaxMoney() ;

            taxSumMoney = taxSumMoney + stockReturnDetail.getTaxMoney() ;
            break ;
        case del:

            orderCount = orderCount - stockReturnDetail.getOrderCount() ;

            noTaxSumMoney = noTaxSumMoney - stockReturnDetail.getNoTaxMoney() ;

            taxSumMoney = taxSumMoney - stockReturnDetail.getTaxMoney() ;

            break ;

        default:
            throw new SystemOptServiceException("optSum  error !  " + optSum) ;
        }

        stockReturn.setOrderCount(orderCount) ;

        stockReturn.setTaxSumMoney(taxSumMoney) ;

        stockReturn.setNoTaxSumMoney(noTaxSumMoney) ;

        baseService.update(stockReturn) ;

    }

    public StockReturn saveUpdate(OptType optType, StockReturn optStockReturn) throws SystemOptServiceException {

        switch (optType) {

        case init:
            return init(optStockReturn) ;
        case save:
        case update:
            return saveUpdate(optStockReturn) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public StockReturn init(StockReturn optStockReturn) throws SystemOptServiceException {
        optStockReturn.setStatus(Status.初始化) ;
        baseService.save(optStockReturn) ;
        return optStockReturn ;

    }

    public StockReturn saveUpdate(StockReturn optStockReturn) throws SystemOptServiceException {
        try {

            //            check(optStockOrder) ;

            StockReturn stockReturn = baseService.load(optStockReturn.getId(), StockReturn.class) ;

            stockReturn.setStatus(Status.有效) ;

            stockReturn.setRecordDate(DateToolsUilts.getnowDate()) ;

            initOrder(optStockReturn) ;

            ToolsUnits.copyBeanProperties(stockReturn, optStockReturn, "returnDate", "number", "stockType", "providerInfo", "stockMan", "stockProductType", "remarks", "text", "recordMan", "returnType") ;

            baseService.update(stockReturn) ;

            return optStockReturn ;

        } catch (ToolsUnitsException e) {
            throw new SystemOptServiceException(e) ;
        }
    }

    private void initOrder(StockReturn optStockReturn) {

        Integer providerInfoId = optStockReturn.getProviderInfoId() ;

        ProviderInfo providerInfo = baseService.load(providerInfoId, ProviderInfo.class) ;

        optStockReturn.setProviderInfo(providerInfo) ;

        Integer recordManId = optStockReturn.getRecordManId() ;

        SysStaffUser recordMan = baseService.load(recordManId, SysStaffUser.class) ;

        optStockReturn.setRecordMan(recordMan) ;

        Integer stockManId = optStockReturn.getStockManId() ;
        if (stockManId != null) {
            SysStaffUser stockMan = baseService.load(stockManId, SysStaffUser.class) ;
            optStockReturn.setStockMan(stockMan) ;
        }

    }

    public void check(StockReturn stockReturn) throws SystemOptServiceException {

        String sql = "   select  count(stockOrder.id)  from  StockReturn as stockOrder   where  stockOrder.number='"

        + stockReturn.getNumber() + "'  "

        + "  and   stockOrder.id !=" + stockReturn.getId() ;

        Long cont = baseService.selectSumByHSQL(sql) ;

        if (cont == null || cont.intValue() == 0) {

        } else {
            throw new SystemOptServiceException("退货单号重复") ;
        }

        ProductInfoType productInfoType = stockReturn.getStockProductType() ;

        String productInfoTypeSql = "   select  count(stockOrderDetail.id)  from  StockReturnDetail  as stockOrderDetail   " +

        "    inner join  stockOrderDetail.productInfo as  productInfo  " +

        "    where  productInfo.productInfoType!='" + productInfoType.name() + "'  "

        + "  and   stockOrderDetail.stockReturnId =" + stockReturn.getId() ;

        cont = baseService.selectSumByHSQL(productInfoTypeSql) ;

        if (cont != null && cont.intValue() > 0) {

            throw new SystemOptServiceException("采购订单明细中包含有不是[" + productInfoType.name() + "]产品,不能修改采购类型为" + productInfoType.name()) ;
        }
    }

}
