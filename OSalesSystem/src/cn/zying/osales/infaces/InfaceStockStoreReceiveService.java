package cn.zying.osales.infaces ;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockStoreReceive ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockStoreReceiveSearchBean ;

public interface InfaceStockStoreReceiveService {

    /**
          *  增加或更新
          */
    public StockStoreReceive saveUpdate(OptType optType, StockStoreReceive optStockStoreReceive) throws SystemOptServiceException ;

    public SelectPage<StockStoreReceive> search(OptType optType, StockStoreReceiveSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public List<StockStoreReceive> searchList(OptType optType, StockStoreReceiveSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public StockStoreReceive remove(OptType optType, StockStoreReceive optStockStoreReceive) throws SystemOptServiceException ;

    public StockStoreReceive get(Integer id) throws SystemOptServiceException ;

    public void check(Integer id, Integer optUserId) throws SystemOptServiceException ;

}
