package cn.zying.osales.service.baseinfo.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.CombinedProductDetails ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("CombinedProductDetailsRemoveUnits")
public class CombinedProductDetailsRemoveUnits extends ABCommonsService {

    public CombinedProductDetails remove(OptType optType, CombinedProductDetails optCombinedProductDetails) throws SystemOptServiceException {

        Integer id = optCombinedProductDetails.getId() ;
        CombinedProductDetails removeCombinedProductDetails = baseService.get(id, CombinedProductDetails.class) ;
        baseService.update(removeCombinedProductDetails) ;
        return removeCombinedProductDetails ;
    }

}
