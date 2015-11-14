package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.CombinedProductDetails ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.baseinfo.ICombinedProductDetailsService ;
import cn.zying.osales.units.search.bean.CombinedProductDetailsSearchBean ;

@Component(IAopCombinedProductDetailsService.name)
public class AopCombinedProductDetailsService implements IAopCombinedProductDetailsService {

    @Autowired
    @Qualifier(ICombinedProductDetailsService.name)
    private ICombinedProductDetailsService iCombinedProductDetailsService ;

    public CombinedProductDetails saveUpdate(OptType optType, CombinedProductDetails optCombinedProductDetails) throws SystemOptServiceException {

        return iCombinedProductDetailsService.saveUpdate(optType, optCombinedProductDetails) ;

    }

    public SelectPage<CombinedProductDetails> search(OptType optType, CombinedProductDetailsSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iCombinedProductDetailsService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    public List<CombinedProductDetails> searchList(OptType optType, CombinedProductDetailsSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iCombinedProductDetailsService.searchList(optType, searchBean, commSearchBean, startLimit) ;

    }

    public CombinedProductDetails remove(OptType optType, CombinedProductDetails optCombinedProductDetails) throws SystemOptServiceException {

        return iCombinedProductDetailsService.remove(optType, optCombinedProductDetails) ;

    }

    public CombinedProductDetails get(Integer id) throws SystemOptServiceException {
        return iCombinedProductDetailsService.get(id) ;

    }

}
