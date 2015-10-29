package cn.zying.osales.service.baseinfo.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.ProductBrand ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("ProductBrandSaveUpdateUnits")
public class ProductBrandSaveUpdateUnits extends ABCommonsService {

    public void saveUpdate(OptType optType, ProductBrand optProductBrand) throws SystemOptServiceException {

        switch (optType) {
        case save:
            save(optProductBrand) ;
            break ;
        case update:
            update(optProductBrand) ;
            break ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public void save(ProductBrand optProductBrand) throws SystemOptServiceException {
        optProductBrand.setStatus(Status.有效) ;
        baseService.save(optProductBrand) ;
    }

    public void update(ProductBrand optProductBrand) throws SystemOptServiceException {
        ProductBrand productBrand = baseService.load(optProductBrand.getId(), ProductBrand.class) ;
        productBrand.setName(optProductBrand.getName()) ;
        productBrand.setStatus(optProductBrand.getStatus()) ;
        baseService.update(productBrand) ;
    }

}
