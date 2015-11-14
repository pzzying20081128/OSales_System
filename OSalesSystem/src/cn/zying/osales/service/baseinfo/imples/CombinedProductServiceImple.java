package cn.zying.osales.service.baseinfo.imples ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.CombinedProduct ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.baseinfo.ICombinedProductService ;
import cn.zying.osales.service.baseinfo.units.CombinedProductCheckUnits ;
import cn.zying.osales.service.baseinfo.units.CombinedProductRemoveUnits ;
import cn.zying.osales.service.baseinfo.units.CombinedProductSaveUpdateUnits ;
import cn.zying.osales.service.baseinfo.units.CombinedProductSearchUnits ;
import cn.zying.osales.units.search.bean.CombinedProductSearchBean ;

@Component(ICombinedProductService.name)
public class CombinedProductServiceImple extends ABCommonsService implements ICombinedProductService {

    //@Resource(name="CombinedProductSearchUnits")
    @Autowired
    @Qualifier("CombinedProductSearchUnits")
    private CombinedProductSearchUnits iCombinedProductSearchUnits ;

    //@Resource(name=" CombinedProductSaveUpdateUnits")
    @Autowired
    @Qualifier("CombinedProductSaveUpdateUnits")
    private CombinedProductSaveUpdateUnits iCombinedProductSaveUpdateUnits ;

    @Autowired
    @Qualifier("CombinedProductRemoveUnits")
    private CombinedProductRemoveUnits iCombinedProductRemoveUnits ;

    @Autowired
    @Qualifier("CombinedProductCheckUnits")
    private CombinedProductCheckUnits iCombinedProductCheckUnits ;

    @Override
    public CombinedProduct saveUpdate(OptType optType, CombinedProduct optCombinedProduct) throws SystemOptServiceException {
        return iCombinedProductSaveUpdateUnits.saveUpdate(optType, optCombinedProduct) ;
    }

    @Override
    public SelectPage<CombinedProduct> search(OptType optType, CombinedProductSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iCombinedProductSearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public List<CombinedProduct> searchList(OptType optType, CombinedProductSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iCombinedProductSearchUnits.list(optType, searchBean, commSearchBean, startLimit) ;

    }

    @Override
    public CombinedProduct remove(OptType optType, CombinedProduct optCombinedProduct) throws SystemOptServiceException {
        return iCombinedProductRemoveUnits.remove(optType, optCombinedProduct) ;
    }

    @Override
    public CombinedProduct get(Integer id) throws SystemOptServiceException {

        return baseService.get(id, CombinedProduct.class) ;
    }

    @Override
    public void check(Integer uuid, Integer checkManId) throws SystemOptServiceException {
        iCombinedProductCheckUnits.check(uuid, checkManId) ;

    }

}
