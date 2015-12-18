package cn.zying.osales.service.stocks.units ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zying.osales.OSalesConfigProperties.OptSum ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProductInfo ;
import cn.zying.osales.pojos.StockReturn ;
import cn.zying.osales.pojos.StockReturnDetail ;
import cn.zying.osales.pojos.StoreInfo ;
import cn.zying.osales.pojos.StorePosition ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockReturnDetailSaveUpdateUnits")
public class StockReturnDetailSaveUpdateUnits extends ABCommonsService {

    @Autowired
    @Qualifier("StockReturnSaveUpdateUnits")
    private StockReturnSaveUpdateUnits stockReturnSaveUpdateUnits ;

    public StockReturnDetail saveUpdate(OptType optType, StockReturnDetail optStockReturnDetail) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return save(optStockReturnDetail) ;

        case update:
            return update(optStockReturnDetail) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    /*
     * stockreturndetail.stockReturnId:3
    stockreturndetail.productInfoId:10
    stockreturndetail.taxPriceMoneyShow:23.45
    stockreturndetail.noTaxPriceMoneyShow:21.81
    stockreturndetail.taxRateTaxRateShow:7.00
    stockreturndetail.orderCount:21
    stockreturndetail.orderBox:1
    stockreturndetail.storeInfoId:1
    stockreturndetail.storePositionId:1
    stockreturndetail.text:12
     * 
     * 
     */
    public StockReturnDetail save(StockReturnDetail stockReturnDetail) throws SystemOptServiceException {
        setPropertis(stockReturnDetail) ;
        baseService.save(stockReturnDetail) ;
        stockReturnSaveUpdateUnits.updateSumMoney(stockReturnDetail.getStockReturn(), stockReturnDetail, OptSum.add) ;
        return stockReturnDetail ;

    }

    public StockReturnDetail update(StockReturnDetail optStockReturnDetail) throws SystemOptServiceException {
        setPropertis(optStockReturnDetail) ;
        StockReturnDetail stockReturnDetail = baseService.get(optStockReturnDetail.getId(), StockReturnDetail.class) ;
        stockReturnSaveUpdateUnits.updateSumMoney(stockReturnDetail.getStockReturn(), stockReturnDetail, OptSum.del) ;
        ToolsUnits.copyBeanProperties(stockReturnDetail, optStockReturnDetail, "productInfo", "productInfoId", "taxPrice", "taxRate", "taxMoney", "noTaxPrice", "noTaxMoney", "orderCount", "orderBox", "text", "storeInfo", "storeInfoId", "storePosition", "storePositionId") ;
        baseService.update(stockReturnDetail) ;
        stockReturnSaveUpdateUnits.updateSumMoney(stockReturnDetail.getStockReturn(), stockReturnDetail, OptSum.add) ;
        return stockReturnDetail ;
    }

    private void setPropertis(StockReturnDetail optStockReturnDetail) {
        if (optStockReturnDetail.getStockReturnId() != null) {
            StockReturn stockReturn = baseService.load(optStockReturnDetail.getStockReturnId(), StockReturn.class) ;
            optStockReturnDetail.setStockReturn(stockReturn) ;
        }

        ProductInfo productInfo = baseService.load(optStockReturnDetail.getProductInfoId(), ProductInfo.class) ;
        optStockReturnDetail.setProductInfo(productInfo) ;

        StoreInfo storeInfo = baseService.load(optStockReturnDetail.getStoreInfoId(), StoreInfo.class) ;
        optStockReturnDetail.setStoreInfo(storeInfo) ;

        StorePosition storePosition = baseService.load(optStockReturnDetail.getStorePositionId(), StorePosition.class) ;
        optStockReturnDetail.setStorePosition(storePosition) ;

        optStockReturnDetail.setTaxMoney(optStockReturnDetail.getTaxPrice() * optStockReturnDetail.getOrderCount()) ;

        optStockReturnDetail.setNoTaxMoney(optStockReturnDetail.getNoTaxPrice() * optStockReturnDetail.getOrderCount()) ;
    }

}
