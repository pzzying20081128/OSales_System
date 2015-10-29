package cn.zying.osales.service.baseinfo.units ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.ToolsUnits ;
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

    public ProductInfo save(ProductInfo optProductInfo) throws SystemOptServiceException {

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
    }

    public ProductInfo update(ProductInfo optProductInfo) throws SystemOptServiceException {
        setProperties(optProductInfo) ;

        ProductInfo oldProductInfo = baseService.get(optProductInfo.getId(), ProductInfo.class) ;
        optProductInfo.getBarCode() ;
        optProductInfo.getBaseUnit() ;
        optProductInfo.getBoxCount() ;
        optProductInfo.getBoxUnit() ;
        optProductInfo.getGrossProfitRate() ;
        optProductInfo.getIsBox() ;
        optProductInfo.getMaxStockPrice() ;
        optProductInfo.getModel() ;
        optProductInfo.getName() ;
        optProductInfo.getProductBrand() ;
        optProductInfo.getProductInfoType() ;
        optProductInfo.getProviderInfo() ;
        optProductInfo.getSalesBoxNoTaxPrice() ;
        optProductInfo.getSalesBoxTaxPrice() ;
        optProductInfo.getSalesNoTaxPrice() ;
        optProductInfo.getSalesTaxPrice() ;
        optProductInfo.getSalesTaxRate() ;
        optProductInfo.getShelfLife() ;
        optProductInfo.getShortName() ;
        optProductInfo.getStockTaxRate() ;
        optProductInfo.getStoreInfo() ;
        optProductInfo.getStorePosition() ;
        optProductInfo.getText() ;

        try {
            ToolsUnits.copyBeanProperties(oldProductInfo, optProductInfo, "barCode",

            "baseUnit", "boxCount", "boxUnit", "grossProfitRate", "isBox", "maxStockPrice", "model",

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
