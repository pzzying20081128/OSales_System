package cn.zying.osales.service.baseinfo.units ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.units.moneys.BuildMoneyFactory ;
import cn.zy.apps.tools.units.moneys.IBuildMoneyFactory ;
import cn.zying.osales.OSalesConfigProperties.OptSum ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.ProductInfoType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.CombinedProduct ;
import cn.zying.osales.pojos.CombinedProductDetails ;
import cn.zying.osales.pojos.ProductBrand ;
import cn.zying.osales.pojos.ProductCategory ;
import cn.zying.osales.pojos.ProviderInfo ;
import cn.zying.osales.pojos.StoreInfo ;
import cn.zying.osales.pojos.StorePosition ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("CombinedProductSaveUpdateUnits")
public class CombinedProductSaveUpdateUnits extends ABCommonsService {

    private static IBuildMoneyFactory buildMoneyFactory = BuildMoneyFactory.getBuildMoney() ;

    public CombinedProduct alculateSum(CombinedProduct combinedProduct, CombinedProductDetails combinedProductDetails, OptSum optSum) {

        Long stockPrice = combinedProduct.getStockPrice() == null ? 0L : combinedProduct.getStockPrice() ;

        Long salesTaxPrice = combinedProduct.getSalesTaxPrice() == null ? 0L : combinedProduct.getSalesTaxPrice() ;

        switch (optSum) {

        case add:
            stockPrice = stockPrice + combinedProductDetails.getStockMoneyPrice() ;

            salesTaxPrice = salesTaxPrice + combinedProductDetails.getSalesMoneyPrice() ;
            break ;
        case del:
            stockPrice = stockPrice - combinedProductDetails.getStockMoneyPrice() ;

            salesTaxPrice = salesTaxPrice - combinedProductDetails.getSalesMoneyPrice() ;
            break ;

        default:
            break ;
        }

        combinedProduct.setMaxStockPrice(stockPrice) ;

        combinedProduct.setSalesTaxPrice(salesTaxPrice) ;

        combinedProduct.setSalesNoTaxPrice(buildMoneyFactory.jsNoTaxPrice(salesTaxPrice, combinedProduct.getSalesTaxRate())) ;

        combinedProduct.setGrossProfitRate(buildMoneyFactory.jsGrossProfitRate(salesTaxPrice, stockPrice)) ;

        combinedProduct.setSalesBoxNoTaxPrice(combinedProduct.getSalesNoTaxPrice() * combinedProduct.getBoxCount()) ;

        combinedProduct.setSalesBoxTaxPrice(salesTaxPrice * combinedProduct.getBoxCount()) ;

        baseService.update(combinedProduct) ;
        return combinedProduct ;
    }

    public CombinedProduct saveUpdate(OptType optType, CombinedProduct optCombinedProduct) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return save(optCombinedProduct) ;

        case update:
            return update(optCombinedProduct) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public CombinedProduct save(CombinedProduct optCombinedProduct) throws SystemOptServiceException {

        ddd(optCombinedProduct) ;

        optCombinedProduct.setProductInfoType(ProductInfoType.组合产品) ;

        optCombinedProduct.setStatus(Status.有效) ;

        baseService.save(optCombinedProduct) ;

        return optCombinedProduct ;
    }

    private void ddd(CombinedProduct optCombinedProduct) {
        SysStaffUser recordMan = baseService.load(optCombinedProduct.getRecordManId(), SysStaffUser.class) ;

        optCombinedProduct.setRecordMan(recordMan) ;

        StoreInfo storeInfo = baseService.load(optCombinedProduct.getStoreInfoId(), StoreInfo.class) ;

        optCombinedProduct.setStoreInfo(storeInfo) ;

        StorePosition storePosition = baseService.load(optCombinedProduct.getStorePositionId(), StorePosition.class) ;

        optCombinedProduct.setStorePosition(storePosition) ;

        ProductCategory productCategory = baseService.load(optCombinedProduct.getProductCategoryId(), ProductCategory.class) ;

        optCombinedProduct.setProductCategory(productCategory) ;

        ProductBrand productBrand = baseService.load(optCombinedProduct.getProductBrandId(), ProductBrand.class) ;

        optCombinedProduct.setProductBrand(productBrand) ;

        ProviderInfo providerInfo = baseService.load(optCombinedProduct.getProviderInfoId(), ProviderInfo.class) ;

        optCombinedProduct.setProviderInfo(providerInfo) ;
    }

    public CombinedProduct update(CombinedProduct optCombinedProduct) throws SystemOptServiceException {

        ddd(optCombinedProduct) ;

        CombinedProduct ombinedProduct_ = baseService.get(optCombinedProduct.getId(), CombinedProduct.class) ;
        try {
            ToolsUnits.copyBeanProperties(ombinedProduct_, optCombinedProduct, "barCode", "baseUnit", "boxCount", "boxUnit", "grossProfitRate", "isBox", "maxStockPrice",

            "model", "barCode", "productBrand", "productBrandId", "productCategoryId", "providerInfo", "providerInfoId", "salesBoxNoTaxPrice", "name",

            "salesBoxTaxPrice", "salesNoTaxPrice", "salesTaxRate", "shelfLife", "shortName", "stockNoTaxPrice", "stockTaxRate", "storeInfo", "storeInfoId",

            "storePosition", "storePositionId", "text", "productInfoType", "salesTaxPrice") ;

            baseService.update(ombinedProduct_) ;

            return ombinedProduct_ ;
        } catch (Exception e) {
            throw new SystemOptServiceException(e) ;
        }

    }

}
