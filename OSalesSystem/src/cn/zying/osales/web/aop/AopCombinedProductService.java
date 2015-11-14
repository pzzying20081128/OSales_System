package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.CombinedProduct ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.baseinfo.ICombinedProductService ;
import cn.zying.osales.units.search.bean.CombinedProductSearchBean ;

@Component(IAopCombinedProductService.name)
public class AopCombinedProductService implements IAopCombinedProductService {

    @Autowired
    @Qualifier(ICombinedProductService.name)
    private ICombinedProductService iCombinedProductService ;

    public CombinedProduct saveUpdate(OptType optType, CombinedProduct optCombinedProduct) throws SystemOptServiceException {

        return iCombinedProductService.saveUpdate(optType, optCombinedProduct) ;

    }

    public SelectPage<CombinedProduct> search(OptType optType, CombinedProductSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iCombinedProductService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    public List<CombinedProduct> searchList(OptType optType, CombinedProductSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iCombinedProductService.searchList(optType, searchBean, commSearchBean, startLimit) ;

    }

    public CombinedProduct remove(OptType optType, CombinedProduct optCombinedProduct) throws SystemOptServiceException {

        return iCombinedProductService.remove(optType, optCombinedProduct) ;

    }

    public CombinedProduct get(Integer id) throws SystemOptServiceException {
        return iCombinedProductService.get(id) ;

    }

    @Override
    public void check(Integer uuid, Integer checkManId) throws SystemOptServiceException {
        iCombinedProductService.check(uuid, checkManId) ;

    }

}
