package cn.zying.osales.service.produce.imples ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProduceComBinedProduct ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.produce.IProduceComBinedProductService ;
import cn.zying.osales.service.produce.units.ProduceComBinedProductCheckUnits ;
import cn.zying.osales.service.produce.units.ProduceComBinedProductRemoveUnits ;
import cn.zying.osales.service.produce.units.ProduceComBinedProductSaveUpdateUnits ;
import cn.zying.osales.service.produce.units.ProduceComBinedProductSearchUnits ;
import cn.zying.osales.units.search.bean.ProduceComBinedProductSearchBean ;

@Component(IProduceComBinedProductService.name)
public class ProduceComBinedProductServiceImple extends ABCommonsService implements IProduceComBinedProductService {

    //@Resource(name="ProduceComBinedProductSearchUnits")
    @Autowired
    @Qualifier("ProduceComBinedProductSearchUnits")
    private ProduceComBinedProductSearchUnits iProduceComBinedProductSearchUnits ;

    //@Resource(name=" ProduceComBinedProductSaveUpdateUnits")
    @Autowired
    @Qualifier("ProduceComBinedProductSaveUpdateUnits")
    private ProduceComBinedProductSaveUpdateUnits iProduceComBinedProductSaveUpdateUnits ;

    @Autowired
    @Qualifier("ProduceComBinedProductRemoveUnits")
    private ProduceComBinedProductRemoveUnits iProduceComBinedProductRemoveUnits ;

    @Autowired
    @Qualifier("ProduceComBinedProductCheckUnits")
    private ProduceComBinedProductCheckUnits produceComBinedProductCheckUnits ;

    @Override
    public ProduceComBinedProduct saveUpdate(OptType optType, ProduceComBinedProduct optProduceComBinedProduct) throws SystemOptServiceException {
        return iProduceComBinedProductSaveUpdateUnits.saveUpdate(optType, optProduceComBinedProduct) ;
    }

    @Override
    public SelectPage<ProduceComBinedProduct> search(OptType optType, ProduceComBinedProductSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iProduceComBinedProductSearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public List<ProduceComBinedProduct> searchList(OptType optType, ProduceComBinedProductSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iProduceComBinedProductSearchUnits.list(optType, searchBean, commSearchBean, startLimit) ;

    }

    @Override
    public ProduceComBinedProduct remove(OptType optType, ProduceComBinedProduct optProduceComBinedProduct) throws SystemOptServiceException {
        return iProduceComBinedProductRemoveUnits.remove(optType, optProduceComBinedProduct) ;
    }

    @Override
    public ProduceComBinedProduct get(Integer id) throws SystemOptServiceException {

        return baseService.get(id, ProduceComBinedProduct.class) ;
    }

    @Override
    public void check(Integer uuid, Integer oSalsesLoginUserId) throws SystemOptServiceException {
        produceComBinedProductCheckUnits.check(uuid, oSalsesLoginUserId) ;

    }

}
