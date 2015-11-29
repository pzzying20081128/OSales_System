package cn.zying.osales.service.stocks.units ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.units.ToolsUnitsException ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProductInfo ;
import cn.zying.osales.pojos.StockInStoreDetail ;
import cn.zying.osales.pojos.StoreInfo ;
import cn.zying.osales.pojos.StorePosition ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockInStoreDetailSaveUpdateUnits")
public class StockInStoreDetailSaveUpdateUnits extends ABCommonsService {

    @Autowired
    @Qualifier("StockInStoreSaveUpdateUnits")
    private StockInStoreSaveUpdateUnits stockInStoreSaveUpdateUnits ;

    public StockInStoreDetail saveUpdate(OptType optType, StockInStoreDetail optStockInStoreDetail) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return save(optStockInStoreDetail) ;

        case update:
            return update(optStockInStoreDetail) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public StockInStoreDetail save(StockInStoreDetail optStockInStoreDetail) throws SystemOptServiceException {
        return optStockInStoreDetail ;
    }

    public StockInStoreDetail update(StockInStoreDetail optStockInStoreDetail) throws SystemOptServiceException {

      

        try {
//            ToolsUnits.copyBeanProperties(stockInStoreDetail, optStockInStoreDetail, "noTaxMoney"
//
//            , "noTaxPrice", "orderBox", "orderCount", "productInfo", "taxMoney", "taxPrice", "taxRate", "text") ;
            
            StockInStoreDetail stockInStoreDetail = baseService.get(optStockInStoreDetail.getId(), StockInStoreDetail.class) ;
            
            switchObjects(stockInStoreDetail , optStockInStoreDetail) ;

            ToolsUnits.copyBeanProperties(stockInStoreDetail, optStockInStoreDetail, "noTaxMoney" ,  "orderBox", "orderCount", "productInfo", "taxMoney",  "text") ;

            baseService.update(stockInStoreDetail) ;

            stockInStoreSaveUpdateUnits.updateSumMoneys(stockInStoreDetail.getStockInStoreId()) ;

            return stockInStoreDetail ;

        } catch (ToolsUnitsException e) {
            throw new SystemOptServiceException(e) ;
        }

    }

    private void switchObjects( StockInStoreDetail stockInStoreDetailOld  , StockInStoreDetail stockInStoreDetail) {
        
        int x = stockInStoreDetail.getId();
        
        StockInStoreDetail stockInStoreDetail_ = stockInStoreDetailOld;

        Integer productInfoId = stockInStoreDetail_.getProductInfoId() ;

        ProductInfo productInfo = baseService.load(productInfoId, ProductInfo.class) ;

        stockInStoreDetail.setProductInfo(productInfo) ;

        Integer storeInfoId = stockInStoreDetail.getStoreInfoId() ;

        StoreInfo storeInfo = baseService.load(storeInfoId, StoreInfo.class) ;

        stockInStoreDetail.setStoreInfo(storeInfo) ;

        Integer storePositionId = stockInStoreDetail.getStorePositionId() ;

        StorePosition storePosition = baseService.load(storePositionId, StorePosition.class) ;

        stockInStoreDetail.setStorePosition(storePosition) ;

        stockInStoreDetail.setNoTaxMoney(stockInStoreDetail_.getNoTaxPrice() * stockInStoreDetail.getOrderCount()) ;

        stockInStoreDetail.setTaxMoney(stockInStoreDetail_.getTaxPrice() * stockInStoreDetail.getOrderCount()) ;

    }

}
