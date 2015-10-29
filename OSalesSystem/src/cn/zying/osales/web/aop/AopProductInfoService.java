package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.ProductInfoType ;
import cn.zying.osales.pojos.ProductInfo ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.baseinfo.IProductInfoService ;
import cn.zying.osales.units.search.bean.ProductInfoSearchBean ;

@Component(IAopProductInfoService.name)
public class AopProductInfoService implements IAopProductInfoService {

    @Autowired
    @Qualifier(IProductInfoService.name)
    private IProductInfoService iProductInfoService ;

    public ProductInfo saveUpdate(OptType optType, ProductInfo optProductInfo) throws SystemOptServiceException {

        optProductInfo.setProductInfoType(ProductInfoType.普通产品) ;

        return iProductInfoService.saveUpdate(optType, optProductInfo) ;

    }

    public SelectPage<ProductInfo> search(OptType optType, ProductInfoSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iProductInfoService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    public List<ProductInfo> searchList(OptType optType, ProductInfoSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iProductInfoService.searchList(optType, searchBean, commSearchBean, startLimit) ;

    }

    public ProductInfo remove(OptType optType, ProductInfo optProductInfo) throws SystemOptServiceException {

        return iProductInfoService.remove(optType, optProductInfo) ;

    }

    public ProductInfo get(Integer id) throws SystemOptServiceException {
        return iProductInfoService.get(id) ;

    }

    @Override
    public ProductInfo selectStockPrice(Integer id, Integer providerInfoId) throws SystemOptServiceException {

        return iProductInfoService.selectStockPrice(id, providerInfoId) ;
    }

}
