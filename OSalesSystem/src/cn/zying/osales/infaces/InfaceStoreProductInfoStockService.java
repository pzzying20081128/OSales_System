package cn.zying.osales.infaces ;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StoreProductInfoStock ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StoreProductInfoStockSearchBean ;

public interface InfaceStoreProductInfoStockService {

    /**
          *  增加或更新
          */
    public StoreProductInfoStock saveUpdate(OptType optType, StoreProductInfoStock optStoreProductInfoStock) throws SystemOptServiceException ;

    public SelectPage<StoreProductInfoStock> search(OptType optType, StoreProductInfoStockSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public List<StoreProductInfoStock> searchList(OptType optType, StoreProductInfoStockSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public StoreProductInfoStock remove(OptType optType, StoreProductInfoStock optStoreProductInfoStock) throws SystemOptServiceException ;

    public StoreProductInfoStock get(Integer id) throws SystemOptServiceException ;

}
