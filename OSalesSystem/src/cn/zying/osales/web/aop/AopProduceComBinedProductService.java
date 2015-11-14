package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProduceComBinedProduct ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.produce.IProduceComBinedProductService ;
import cn.zying.osales.units.search.bean.ProduceComBinedProductSearchBean ;

@Component(IAopProduceComBinedProductService.name)
public class AopProduceComBinedProductService implements IAopProduceComBinedProductService {

    @Autowired
    @Qualifier(IProduceComBinedProductService.name)
    private IProduceComBinedProductService iProduceComBinedProductService ;

    public ProduceComBinedProduct saveUpdate(OptType optType, ProduceComBinedProduct optProduceComBinedProduct) throws SystemOptServiceException {

        return iProduceComBinedProductService.saveUpdate(optType, optProduceComBinedProduct) ;

    }

    public SelectPage<ProduceComBinedProduct> search(OptType optType, ProduceComBinedProductSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iProduceComBinedProductService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    public List<ProduceComBinedProduct> searchList(OptType optType, ProduceComBinedProductSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iProduceComBinedProductService.searchList(optType, searchBean, commSearchBean, startLimit) ;

    }

    public ProduceComBinedProduct remove(OptType optType, ProduceComBinedProduct optProduceComBinedProduct) throws SystemOptServiceException {

        return iProduceComBinedProductService.remove(optType, optProduceComBinedProduct) ;

    }

    public ProduceComBinedProduct get(Integer id) throws SystemOptServiceException {
        return iProduceComBinedProductService.get(id) ;

    }

    @Override
    public void check(Integer uuid, Integer oSalsesLoginUserId) throws SystemOptServiceException {
        iProduceComBinedProductService.check(uuid, oSalsesLoginUserId) ;

    }

}
