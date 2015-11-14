package cn.zying.osales.service.produce.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProduceComBinedProductDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("ProduceComBinedProductDetailRemoveUnits")
public class ProduceComBinedProductDetailRemoveUnits extends ABCommonsService {

    public ProduceComBinedProductDetail remove(OptType optType, ProduceComBinedProductDetail optProduceComBinedProductDetail) throws SystemOptServiceException {

        Integer id = optProduceComBinedProductDetail.getId() ;
        ProduceComBinedProductDetail removeProduceComBinedProductDetail = baseService.get(id, ProduceComBinedProductDetail.class) ;
        baseService.update(removeProduceComBinedProductDetail) ;
        return removeProduceComBinedProductDetail ;
    }

}
