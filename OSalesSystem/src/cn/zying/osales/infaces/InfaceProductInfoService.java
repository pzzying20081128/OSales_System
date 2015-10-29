package cn.zying.osales.infaces ;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProductInfo ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.ProductInfoSearchBean ;

public interface InfaceProductInfoService {

    /**
          *  增加或更新
          */
    public ProductInfo saveUpdate(OptType optType, ProductInfo optProductInfo) throws SystemOptServiceException ;

    public SelectPage<ProductInfo> search(OptType optType, ProductInfoSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public List<ProductInfo> searchList(OptType optType, ProductInfoSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public ProductInfo remove(OptType optType, ProductInfo optProductInfo) throws SystemOptServiceException ;

    public ProductInfo get(Integer id) throws SystemOptServiceException ;

    public ProductInfo selectStockPrice(Integer id, Integer providerInfoId) throws SystemOptServiceException ;

}
