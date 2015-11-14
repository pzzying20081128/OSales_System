package cn.zying.osales.service.baseinfo.units ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptSum ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.CombinedProduct ;
import cn.zying.osales.pojos.CombinedProductDetails ;
import cn.zying.osales.pojos.ProductInfo ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("CombinedProductDetailsSaveUpdateUnits")
public class CombinedProductDetailsSaveUpdateUnits extends ABCommonsService {

    @Autowired
    @Qualifier("CombinedProductSaveUpdateUnits")
    private CombinedProductSaveUpdateUnits combinedProductSaveUpdateUnits ;

    public CombinedProductDetails saveUpdate(OptType optType, CombinedProductDetails optCombinedProductDetails) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return save(optCombinedProductDetails) ;

        case update:
            return update(optCombinedProductDetails) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public CombinedProductDetails save(CombinedProductDetails optCombinedProductDetails) throws SystemOptServiceException {

        ProductInfo productInfo = baseService.load(optCombinedProductDetails.getProductInfoId(), ProductInfo.class) ;

        optCombinedProductDetails.setProductInfo(productInfo) ;

        CombinedProduct combinedProduct = baseService.load(optCombinedProductDetails.getCombinedProductId(), CombinedProduct.class) ;

        optCombinedProductDetails.setCombinedProduct(combinedProduct) ;

        baseService.save(optCombinedProductDetails) ;

        combinedProductSaveUpdateUnits.alculateSum(combinedProduct, optCombinedProductDetails, OptSum.add) ;
        return optCombinedProductDetails ;
    }

    public CombinedProductDetails update(CombinedProductDetails optCombinedProductDetails) throws SystemOptServiceException {
        return optCombinedProductDetails ;
    }

}
