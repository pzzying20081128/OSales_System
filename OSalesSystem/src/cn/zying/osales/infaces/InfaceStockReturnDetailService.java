package cn.zying.osales.infaces ;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockReturnDetail ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockReturnDetailSearchBean ;

public interface InfaceStockReturnDetailService {

    /**
          *  增加或更新
          */
    public StockReturnDetail saveUpdate(OptType optType, StockReturnDetail optStockReturnDetail) throws SystemOptServiceException ;

    public SelectPage<StockReturnDetail> search(OptType optType, StockReturnDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public List<StockReturnDetail> searchList(OptType optType, StockReturnDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public StockReturnDetail remove(OptType optType, StockReturnDetail optStockReturnDetail) throws SystemOptServiceException ;

    public StockReturnDetail get(Integer id) throws SystemOptServiceException ;

}
