package cn.zying.osales.service.baseinfo.units ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.DateToolsUilts ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.CombinedProduct ;
import cn.zying.osales.pojos.ProductInfo ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("CombinedProductCheckUnits")
public class CombinedProductCheckUnits extends ABCommonsService {

    @Autowired
    @Qualifier("ProductInfoSaveUpdateUnits")
    private ProductInfoSaveUpdateUnits productInfoSaveUpdateUnits ;

    public void check(Integer uuid, Integer checkManId) throws SystemOptServiceException {

        CombinedProduct combinedProduct = baseService.load(uuid, CombinedProduct.class) ;
        combinedProduct.setCheckManId(checkManId) ;

        switch (combinedProduct.getStatus()) {
        case 有效:
            check(combinedProduct) ;
            break ;
        case 已审核:

            break ;

        default:
            throw new SystemOptServiceException(" status  error " + combinedProduct.getStatus()) ;
        }

    }

    private void check(CombinedProduct combinedProduct) throws SystemOptServiceException {

        ProductInfo productInfo = combinedProduct.getProductInfo() ;

        if (productInfo == null) {
            productInfo = new ProductInfo() ;
            combinedProduct.setProductInfo(productInfo) ;
            try {

                ToolsUnits.copyBeanProperties(productInfo, combinedProduct, "barCode", "baseUnit", "boxCount", "boxUnit", "grossProfitRate", "isBox", "maxStockPrice",

                "model", "barCode", "productBrand", "productBrandId", "productCategoryId", "providerInfo", "providerInfoId", "salesBoxNoTaxPrice", "name",

                "salesBoxTaxPrice", "salesNoTaxPrice", "salesTaxRate", "shelfLife", "shortName", "stockNoTaxPrice", "stockTaxRate", "storeInfo", "storeInfoId",

                "storePosition", "storePositionId", "text", "productInfoType", "salesTaxPrice") ;

                productInfoSaveUpdateUnits.saveUpdate(OptType.save, productInfo) ;
            } catch (Exception e) {
                throw new SystemOptServiceException(e) ;
            }
        } else {
            try {
                ToolsUnits.copyBeanProperties(productInfo, combinedProduct, "barCode", "baseUnit", "boxCount", "boxUnit", "grossProfitRate", "isBox", "maxStockPrice",

                "model", "barCode", "productBrand", "productBrandId", "productCategoryId", "providerInfo", "providerInfoId", "salesBoxNoTaxPrice", "name",

                "salesBoxTaxPrice", "salesNoTaxPrice", "salesTaxRate", "shelfLife", "shortName", "stockNoTaxPrice", "stockTaxRate", "storeInfo", "storeInfoId",

                "storePosition", "storePositionId", "text", "productInfoType", "salesTaxPrice") ;

                productInfoSaveUpdateUnits.saveUpdate(OptType.update, productInfo) ;
            } catch (Exception e) {
                throw new SystemOptServiceException(e) ;
            }
        }
        Integer checkManId = combinedProduct.getCheckManId() ;
        SysStaffUser checkMan = baseService.load(checkManId, SysStaffUser.class) ;
        combinedProduct.setCheckMan(checkMan) ;
        combinedProduct.setCheckDate(DateToolsUilts.getnowDate()) ;
        combinedProduct.setStatus(Status.已审核) ;
        baseService.update(combinedProduct) ;

    }

}
