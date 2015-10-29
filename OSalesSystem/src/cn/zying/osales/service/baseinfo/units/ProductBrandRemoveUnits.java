package cn.zying.osales.service.baseinfo.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.ProductBrand ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("ProductBrandRemoveUnits")
public class ProductBrandRemoveUnits extends ABCommonsService {

    public void remove(OptType optType, ProductBrand optProductBrand) throws SystemOptServiceException {

        Integer id = optProductBrand.getId() ;
        ProductBrand removeProductBrand = baseService.load(id, ProductBrand.class) ;
        removeProductBrand.setStatus(Status.删除) ;
        baseService.update(removeProductBrand) ;

    }

}
