package cn.zying.osales.service.baseinfo.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.pojos.ProductInfo ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("SelectProductStockPriceUnit")
public class SelectProductStockPriceUnit extends ABCommonsService {

    public ProductInfo selectStockPrice(Integer id, Integer providerInfoId) throws SystemOptServiceException {

        ProductInfo productInfo = baseService.get(id, ProductInfo.class) ;
        
        productInfo.setStockPrice(productInfo.getMaxStockPrice());
        productInfo.setStockTaxRate(productInfo.getStockTaxRate());
        productInfo.setStockNoTaxPrice(23456789L);

        return productInfo ;
    }
}
