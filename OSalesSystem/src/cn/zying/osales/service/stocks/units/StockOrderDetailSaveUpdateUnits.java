package cn.zying.osales.service.stocks.units ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProductInfo ;
import cn.zying.osales.pojos.StockOrder ;
import cn.zying.osales.pojos.StockOrderDetail ;
import cn.zying.osales.pojos.StoreInfo ;
import cn.zying.osales.pojos.StorePosition ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockOrderDetailSaveUpdateUnits")
public class StockOrderDetailSaveUpdateUnits extends ABCommonsService {
    @Autowired
    @Qualifier("StockOrderSaveUpdateUnits")
    private StockOrderSaveUpdateUnits stockOrderSaveUpdateUnits ;

    public StockOrderDetail saveUpdate(OptType optType, StockOrderDetail optStockOrderDetail) throws SystemOptServiceException {
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
        stockOrderSaveUpdateUnits.updateSumMoney(stockOrderDetail.getStockOrderId()) ;
        return stockOrderDetail ;
    }

    public StockOrderDetail save(StockOrderDetail optStockOrderDetail) throws SystemOptServiceException {
        Integer stockId = optStockOrderDetail.getStockOrderId() ;

        StockOrder stockOrder = baseService.load(stockId, StockOrder.class) ;
        optStockOrderDetail.setStockOrder(stockOrder) ;
        switchObject(optStockOrderDetail) ;
        baseService.save(optStockOrderDetail) ;

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

        optStockOrderDetail.getNoTaxMoney() ;
        optStockOrderDetail.getNoTaxPrice() ;
        optStockOrderDetail.getOrderBox() ;
        optStockOrderDetail.getOrderCount() ;
        optStockOrderDetail.getProductInfo() ;
        optStockOrderDetail.getTaxMoney() ;
        optStockOrderDetail.getTaxPrice() ;
        optStockOrderDetail.getTaxRate() ;
        optStockOrderDetail.getText() ;

        try {
            ToolsUnits.copyBeanProperties(stockOrderDetail, optStockOrderDetail, "noTaxMoney"

            , "noTaxPrice", "orderBox", "orderCount", "productInfo", "taxMoney", "taxPrice", "taxRate", "text") ;

            baseService.update(stockOrderDetail) ;
            return stockOrderDetail ;
        } catch (Exception e) {
            throw new SystemOptServiceException(e) ;
        }

    }

}
