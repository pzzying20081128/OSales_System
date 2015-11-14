package cn.zying.osales.service.produce.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProduceComBinedProduct ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("ProduceComBinedProductSaveUpdateUnits")
public class ProduceComBinedProductSaveUpdateUnits extends ABCommonsService {

    public ProduceComBinedProduct saveUpdate(OptType optType, ProduceComBinedProduct optProduceComBinedProduct) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return save(optProduceComBinedProduct) ;

        case update:
            return update(optProduceComBinedProduct) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public ProduceComBinedProduct save(ProduceComBinedProduct optProduceComBinedProduct) throws SystemOptServiceException {
        return optProduceComBinedProduct ;
    }

    public ProduceComBinedProduct update(ProduceComBinedProduct optProduceComBinedProduct) throws SystemOptServiceException {
        return optProduceComBinedProduct ;
    }

}
