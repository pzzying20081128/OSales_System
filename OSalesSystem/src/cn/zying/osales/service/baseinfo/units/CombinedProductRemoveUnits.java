package cn.zying.osales.service.baseinfo.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.CombinedProduct ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("CombinedProductRemoveUnits")
public class CombinedProductRemoveUnits extends ABCommonsService {

    public CombinedProduct remove(OptType optType, CombinedProduct optCombinedProduct) throws SystemOptServiceException {

        Integer id = optCombinedProduct.getId() ;
        CombinedProduct removeCombinedProduct = baseService.get(id, CombinedProduct.class) ;
        removeCombinedProduct.setStatus(Status.删除) ;
        baseService.update(removeCombinedProduct) ;
        return removeCombinedProduct ;
    }

}
