package cn.zying.osales.service.baseinfo.units ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.units.moneys.BuildMoneyFactory ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.ProductBrand ;
import cn.zying.osales.pojos.ProductCategory ;
import cn.zying.osales.pojos.ProductInfo ;
import cn.zying.osales.pojos.ProviderInfo ;
import cn.zying.osales.pojos.StoreInfo ;
import cn.zying.osales.pojos.StorePosition ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("ProductInfoSaveUpdateUnits")
public class ProductInfoSaveUpdateUnits extends ABCommonsService {

    public ProductInfo saveUpdate(OptType optType, ProductInfo optProductInfo) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return save(optProductInfo) ;

        case update:
            return update(optProductInfo) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    private ProductInfo save(ProductInfo optProductInfo) throws SystemOptServiceException {

        setProperties(optProductInfo) ;

        optProductInfo.setStatus(Status.有效) ;

        baseService.save(optProductInfo) ;
        return optProductInfo ;
    }

    private void setProperties(ProductInfo optProductInfo) {
        
        StoreInfo storeInfo = baseService.load(optProductInfo.getStoreInfoId(), StoreInfo.class) ;

        optProductInfo.setStoreInfo(storeInfo) ;

        StorePosition storePosition = baseService.load(optProductInfo.getStorePositionId(), StorePosition.class) ;

        optProductInfo.setStorePosition(storePosition) ;

        ProductBrand productBrand = baseService.load(optProductInfo.getProductBrandId(), ProductBrand.class) ;

        optProductInfo.setProductBrand(productBrand) ;

        ProductCategory productCategory = baseService.load(optProductInfo.getProductCategoryId(), ProductCategory.class) ;

        optProductInfo.setProductCategory(productCategory) ;

        ProviderInfo providerInfo = baseService.load(optProductInfo.getProviderInfoId(), ProviderInfo.class) ;

        optProductInfo.setProviderInfo(providerInfo) ;
        
//        long maxNoTaxStockPrice= optProductInfo.getMaxStockPrice() *(100 - optProductInfo.getStockTaxRate() )
//        BuildMoneyUnits.
        Long   maxNoTaxStockPrice =  BuildMoneyFactory.getBuildMoney().jsNoTaxPrice(optProductInfo.getMaxStockPrice(), optProductInfo.getStockTaxRate());  
        
        optProductInfo.setMaxNoTaxStockPrice(maxNoTaxStockPrice);
        
    }

    public ProductInfo update(ProductInfo optProductInfo) throws SystemOptServiceException {
        setProperties(optProductInfo) ;

        ProductInfo oldProductInfo = baseService.get(optProductInfo.getId(), ProductInfo.class) ;
        
        try {
            ToolsUnits.copyBeanProperties(oldProductInfo, optProductInfo, "barCode",

            "baseUnit", "boxCount", "boxUnit", "grossProfitRate", "isBox", "maxStockPrice", "model","maxNoTaxStockPrice",

            "name", "productBrand", "productInfoType", "providerInfo", "salesBoxNoTaxPrice", "salesBoxTaxPrice",

            "salesNoTaxPrice", "salesTaxPrice", "shelfLife", "shortName", "stockTaxRate", "storeInfo", "storePosition", "text"

            ) ;
            baseService.update(oldProductInfo) ;
        } catch (Exception e) {
            throw new SystemOptServiceException(e) ;
        }

        return optProductInfo ;
    }
}
