package cn.zying.osales.service.stocks.units ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.units.ToolsUnitsException ;
import cn.zying.osales.OSalesConfigProperties.OptSum ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProductInfo ;
import cn.zying.osales.pojos.StockOrder ;
import cn.zying.osales.pojos.StockOrderDetail ;
import cn.zying.osales.pojos.StoreInfo ;
import cn.zying.osales.pojos.StorePosition ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.storage.IInStoreProductInfoStockService.StoreOptType ;

@Component("StockOrderDetailSaveUpdateUnits")
public class StockOrderDetailSaveUpdateUnits extends ABCommonsService {
    @Autowired
    @Qualifier("StockOrderSaveUpdateUnits")
    private StockOrderSaveUpdateUnits stockOrderSaveUpdateUnits ;

    public StockOrderDetail saveUpdate(OptType optType, StockOrderDetail optStockOrderDetail) throws SystemOptServiceException {

        check(optType, optStockOrderDetail) ;

        StockOrderDetail stockOrderDetail ;
        switch (optType) {
        case save:
            stockOrderDetail = save(optStockOrderDetail) ;
            break ;
        case update:
            stockOrderDetail = update(optStockOrderDetail) ;
            break ;
        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }

        return stockOrderDetail ;
    }

    private void check(OptType optType, StockOrderDetail optStockOrderDetail) throws SystemOptServiceException {
        switch (optType) {
        case save: {
            String sql = "select  count(stockOrderDetail.id)   from  StockOrderDetail as  stockOrderDetail  where stockOrderDetail.productInfoId = " + optStockOrderDetail.getProductInfoId()

            + "  and   stockOrderDetail.stockOrderId = " + optStockOrderDetail.getStockOrderId() ;
            ;

            Long count = baseService.selectSumByHSQL(sql) ;

            if (count != null && count.intValue() > 0) {
                throw new SystemOptServiceException("该订单已包含此产品") ;
            }

        }

        case update: {
            String sql = "select  count(stockOrderDetail.id)   from  StockOrderDetail as  stockOrderDetail  where stockOrderDetail.productInfoId = "

            + optStockOrderDetail.getProductInfoId() + "  and  stockOrderDetail.id != " + optStockOrderDetail.getId()

            + "  and   stockOrderDetail.stockOrderId = " + optStockOrderDetail.getStockOrderId() ;
            ;

            Long count = baseService.selectSumByHSQL(sql) ;

            if (count != null && count.intValue() > 0) {
                throw new SystemOptServiceException("该订单已包含此产品") ;
            }
        }

        }
    }

    public StockOrderDetail save(StockOrderDetail optStockOrderDetail) throws SystemOptServiceException {
        Integer stockId = optStockOrderDetail.getStockOrderId() ;

        StockOrder stockOrder = baseService.load(stockId, StockOrder.class) ;
        optStockOrderDetail.setStockOrder(stockOrder) ;
        switchObject(optStockOrderDetail) ;
        baseService.save(optStockOrderDetail) ;
        stockOrderSaveUpdateUnits.updateSumMoney(stockOrder, optStockOrderDetail, OptSum.add) ;
        storeProductInfoStockService.inStore(StoreOptType.SaveAdd, optStockOrderDetail) ;
        return optStockOrderDetail ;
    }

    private void switchObject(StockOrderDetail optStockOrderDetail) {

        Integer productInfoId = optStockOrderDetail.getProductInfoId() ;

        ProductInfo productInfo = baseService.load(productInfoId, ProductInfo.class) ;

        optStockOrderDetail.setProductInfo(productInfo) ;

        Integer storeInfoId = optStockOrderDetail.getStoreInfoId() ;

        StoreInfo storeInfo = baseService.load(storeInfoId, StoreInfo.class) ;

        optStockOrderDetail.setStoreInfo(storeInfo) ;

        Integer storePositionId = optStockOrderDetail.getStorePositionId() ;

        StorePosition storePosition = baseService.load(storePositionId, StorePosition.class) ;

        optStockOrderDetail.setStorePosition(storePosition) ;

        optStockOrderDetail.setNoTaxMoney(optStockOrderDetail.getNoTaxPrice() * optStockOrderDetail.getOrderCount()) ;

        optStockOrderDetail.setTaxMoney(optStockOrderDetail.getTaxPrice() * optStockOrderDetail.getOrderCount()) ;

    }

    public StockOrderDetail update(StockOrderDetail optStockOrderDetail) throws SystemOptServiceException {

        switchObject(optStockOrderDetail) ;

        StockOrderDetail stockOrderDetail = baseService.get(optStockOrderDetail.getId(), StockOrderDetail.class) ;

        storeProductInfoStockService.inStore(StoreOptType.Del, stockOrderDetail) ;

        StockOrder stockOrder = baseService.load(stockOrderDetail.getStockOrderId(), StockOrder.class) ;

        stockOrderSaveUpdateUnits.updateSumMoney(stockOrder, stockOrderDetail, OptSum.del) ;

        try {
            ToolsUnits.copyBeanProperties(stockOrderDetail, optStockOrderDetail, "noTaxMoney"

            , "noTaxPrice", "orderBox", "orderCount", "productInfo", "taxMoney", "taxPrice", "taxRate", "text") ;

            baseService.update(stockOrderDetail) ;

            stockOrderSaveUpdateUnits.updateSumMoney(stockOrder, stockOrderDetail, OptSum.add) ;

            storeProductInfoStockService.inStore(StoreOptType.UpdateAdd, stockOrderDetail) ;

            return stockOrderDetail ;
        } catch (ToolsUnitsException e) {
            throw new SystemOptServiceException(e) ;
        }

    }

}
