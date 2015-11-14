package cn.zying.osales.service.produce.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProduceComBinedProductDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("ProduceComBinedProductDetailSaveUpdateUnits")
public class ProduceComBinedProductDetailSaveUpdateUnits extends ABCommonsService {

    public ProduceComBinedProductDetail saveUpdate(OptType optType, ProduceComBinedProductDetail optProduceComBinedProductDetail) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return save(optProduceComBinedProductDetail) ;

        case update:
            return update(optProduceComBinedProductDetail) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public ProduceComBinedProductDetail save(ProduceComBinedProductDetail optProduceComBinedProductDetail) throws SystemOptServiceException {
        return optProduceComBinedProductDetail ;
    }

    public ProduceComBinedProductDetail update(ProduceComBinedProductDetail optProduceComBinedProductDetail) throws SystemOptServiceException {
        return optProduceComBinedProductDetail ;
    }

}
