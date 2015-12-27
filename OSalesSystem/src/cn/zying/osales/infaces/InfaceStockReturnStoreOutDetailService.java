package cn.zying.osales.infaces ;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockReturnStoreOutDetail ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockReturnStoreOutDetailSearchBean ;

public interface InfaceStockReturnStoreOutDetailService {

    /**
          *  增加或更新
          */
    public StockReturnStoreOutDetail saveUpdate(OptType optType, StockReturnStoreOutDetail optStockReturnStoreOutDetail) throws SystemOptServiceException ;

    public SelectPage<StockReturnStoreOutDetail> search(OptType optType, StockReturnStoreOutDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public List<StockReturnStoreOutDetail> searchList(OptType optType, StockReturnStoreOutDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public StockReturnStoreOutDetail remove(OptType optType, StockReturnStoreOutDetail optStockReturnStoreOutDetail) throws SystemOptServiceException ;

    public StockReturnStoreOutDetail get(Integer id) throws SystemOptServiceException ;

}
