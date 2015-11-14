package cn.zying.osales.service.baseinfo.imples ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.CombinedProductDetails ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.baseinfo.ICombinedProductDetailsService ;
import cn.zying.osales.service.baseinfo.units.CombinedProductDetailsRemoveUnits ;
import cn.zying.osales.service.baseinfo.units.CombinedProductDetailsSaveUpdateUnits ;
import cn.zying.osales.service.baseinfo.units.CombinedProductDetailsSearchUnits ;
import cn.zying.osales.units.search.bean.CombinedProductDetailsSearchBean ;

@Component(ICombinedProductDetailsService.name)
public class CombinedProductDetailsServiceImple extends ABCommonsService implements ICombinedProductDetailsService {

    //@Resource(name="CombinedProductDetailsSearchUnits")
    @Autowired
    @Qualifier("CombinedProductDetailsSearchUnits")
    private CombinedProductDetailsSearchUnits iCombinedProductDetailsSearchUnits ;

    //@Resource(name=" CombinedProductDetailsSaveUpdateUnits")
    @Autowired
    @Qualifier("CombinedProductDetailsSaveUpdateUnits")
    private CombinedProductDetailsSaveUpdateUnits iCombinedProductDetailsSaveUpdateUnits ;

    @Autowired
    @Qualifier("CombinedProductDetailsRemoveUnits")
    private CombinedProductDetailsRemoveUnits iCombinedProductDetailsRemoveUnits ;

    @Override
    public CombinedProductDetails saveUpdate(OptType optType, CombinedProductDetails optCombinedProductDetails) throws SystemOptServiceException {
        return iCombinedProductDetailsSaveUpdateUnits.saveUpdate(optType, optCombinedProductDetails) ;
    }

    @Override
    public SelectPage<CombinedProductDetails> search(OptType optType, CombinedProductDetailsSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iCombinedProductDetailsSearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public List<CombinedProductDetails> searchList(OptType optType, CombinedProductDetailsSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iCombinedProductDetailsSearchUnits.list(optType, searchBean, commSearchBean, startLimit) ;

    }

    @Override
    public CombinedProductDetails remove(OptType optType, CombinedProductDetails optCombinedProductDetails) throws SystemOptServiceException {
        return iCombinedProductDetailsRemoveUnits.remove(optType, optCombinedProductDetails) ;
    }

    @Override
    public CombinedProductDetails get(Integer id) throws SystemOptServiceException {

        return baseService.get(id, CombinedProductDetails.class) ;
    }

}
