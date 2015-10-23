package  cn.zying.osales.service.baseinfo.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.ProductInfo ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;


@Component("ProductInfoRemoveUnits")
public class ProductInfoRemoveUnits extends ABCommonsService {

    public ProductInfo  remove(OptType optType, ProductInfo  optProductInfo ) throws SystemOptServiceException {
        
         Integer id =optProductInfo.getId() ;
        ProductInfo   removeProductInfo =baseService.get(id, ProductInfo.class);
        removeProductInfo.setStatus(Status.删除);
        baseService.update(removeProductInfo);
        return  removeProductInfo ;
    }

}
