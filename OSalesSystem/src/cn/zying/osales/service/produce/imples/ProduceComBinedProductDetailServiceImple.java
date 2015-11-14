package cn.zying.osales.service.produce.imples ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProduceComBinedProductDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.produce.IProduceComBinedProductDetailService ;
import cn.zying.osales.service.produce.units.ProduceComBinedProductDetailRemoveUnits ;
import cn.zying.osales.service.produce.units.ProduceComBinedProductDetailSaveUpdateUnits ;
import cn.zying.osales.service.produce.units.ProduceComBinedProductDetailSearchUnits ;
import cn.zying.osales.units.search.bean.ProduceComBinedProductDetailSearchBean ;

@Component(IProduceComBinedProductDetailService.name)
public class ProduceComBinedProductDetailServiceImple extends ABCommonsService implements IProduceComBinedProductDetailService {

    //@Resource(name="ProduceComBinedProductDetailSearchUnits")
    @Autowired
    @Qualifier("ProduceComBinedProductDetailSearchUnits")
    private ProduceComBinedProductDetailSearchUnits iProduceComBinedProductDetailSearchUnits ;

    //@Resource(name=" ProduceComBinedProductDetailSaveUpdateUnits")
    @Autowired
    @Qualifier("ProduceComBinedProductDetailSaveUpdateUnits")
    private ProduceComBinedProductDetailSaveUpdateUnits iProduceComBinedProductDetailSaveUpdateUnits ;

    @Autowired
    @Qualifier("ProduceComBinedProductDetailRemoveUnits")
    private ProduceComBinedProductDetailRemoveUnits iProduceComBinedProductDetailRemoveUnits ;

    @Override
    public ProduceComBinedProductDetail saveUpdate(OptType optType, ProduceComBinedProductDetail optProduceComBinedProductDetail) throws SystemOptServiceException {
        return iProduceComBinedProductDetailSaveUpdateUnits.saveUpdate(optType, optProduceComBinedProductDetail) ;
    }

    @Override
    public SelectPage<ProduceComBinedProductDetail> search(OptType optType, ProduceComBinedProductDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iProduceComBinedProductDetailSearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public List<ProduceComBinedProductDetail> searchList(OptType optType, ProduceComBinedProductDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iProduceComBinedProductDetailSearchUnits.list(optType, searchBean, commSearchBean, startLimit) ;

    }

    @Override
    public ProduceComBinedProductDetail remove(OptType optType, ProduceComBinedProductDetail optProduceComBinedProductDetail) throws SystemOptServiceException {
        return iProduceComBinedProductDetailRemoveUnits.remove(optType, optProduceComBinedProductDetail) ;
    }

    @Override
    public ProduceComBinedProductDetail get(Integer id) throws SystemOptServiceException {

        return baseService.get(id, ProduceComBinedProductDetail.class) ;
    }

}
