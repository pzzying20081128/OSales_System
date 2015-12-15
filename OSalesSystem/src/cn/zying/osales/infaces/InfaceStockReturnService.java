package cn.zying.osales.infaces ;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockReturn ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockReturnSearchBean ;

public interface InfaceStockReturnService {

    /**
          *  增加或更新
          */
    public StockReturn saveUpdate(OptType optType, StockReturn optStockReturn, int optUser) throws SystemOptServiceException ;

    public SelectPage<StockReturn> search(OptType optType, StockReturnSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public List<StockReturn> searchList(OptType optType, StockReturnSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public StockReturn remove(OptType optType, StockReturn optStockReturn) throws SystemOptServiceException ;

    public StockReturn get(Integer id) throws SystemOptServiceException ;
    
    public void check(Integer stockReturnId, int optUser)throws SystemOptServiceException ;

}
