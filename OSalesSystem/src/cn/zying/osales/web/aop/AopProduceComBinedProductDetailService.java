package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProduceComBinedProductDetail ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.produce.IProduceComBinedProductDetailService ;
import cn.zying.osales.units.search.bean.ProduceComBinedProductDetailSearchBean ;

@Component(IAopProduceComBinedProductDetailService.name)
public class AopProduceComBinedProductDetailService implements IAopProduceComBinedProductDetailService {

    @Autowired
    @Qualifier(IProduceComBinedProductDetailService.name)
    private IProduceComBinedProductDetailService iProduceComBinedProductDetailService ;

    public ProduceComBinedProductDetail saveUpdate(OptType optType, ProduceComBinedProductDetail optProduceComBinedProductDetail) throws SystemOptServiceException {

        return iProduceComBinedProductDetailService.saveUpdate(optType, optProduceComBinedProductDetail) ;

    }

    public SelectPage<ProduceComBinedProductDetail> search(OptType optType, ProduceComBinedProductDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iProduceComBinedProductDetailService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    public List<ProduceComBinedProductDetail> searchList(OptType optType, ProduceComBinedProductDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iProduceComBinedProductDetailService.searchList(optType, searchBean, commSearchBean, startLimit) ;

    }

    public ProduceComBinedProductDetail remove(OptType optType, ProduceComBinedProductDetail optProduceComBinedProductDetail) throws SystemOptServiceException {

        return iProduceComBinedProductDetailService.remove(optType, optProduceComBinedProductDetail) ;

    }

    public ProduceComBinedProductDetail get(Integer id) throws SystemOptServiceException {
        return iProduceComBinedProductDetailService.get(id) ;

    }

}
