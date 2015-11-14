package cn.zying.osales.service.produce.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProduceComBinedProduct ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("ProduceComBinedProductRemoveUnits")
public class ProduceComBinedProductRemoveUnits extends ABCommonsService {

    public ProduceComBinedProduct remove(OptType optType, ProduceComBinedProduct optProduceComBinedProduct) throws SystemOptServiceException {

        Integer id = optProduceComBinedProduct.getId() ;
        ProduceComBinedProduct removeProduceComBinedProduct = baseService.get(id, ProduceComBinedProduct.class) ;
        baseService.update(removeProduceComBinedProduct) ;
        return removeProduceComBinedProduct ;
    }

}
