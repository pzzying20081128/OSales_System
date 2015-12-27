package cn.zying.osales.infaces ;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockReturnStoreOut ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockReturnStoreOutSearchBean ;

public interface InfaceStockReturnStoreOutService {

    /**
          *  增加或更新
          */
    public StockReturnStoreOut saveUpdate(OptType optType, StockReturnStoreOut optStockReturnStoreOut) throws SystemOptServiceException ;

    public SelectPage<StockReturnStoreOut> search(OptType optType, StockReturnStoreOutSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public List<StockReturnStoreOut> searchList(OptType optType, StockReturnStoreOutSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public StockReturnStoreOut remove(OptType optType, StockReturnStoreOut optStockReturnStoreOut) throws SystemOptServiceException ;

    public StockReturnStoreOut get(Integer id) throws SystemOptServiceException ;

    public void check(Integer id, Integer oSalsesLoginUserId) throws SystemOptServiceException ;

}
