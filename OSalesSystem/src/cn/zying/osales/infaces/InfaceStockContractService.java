package cn.zying.osales.infaces ;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockContract ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockContractSearchBean ;

public interface InfaceStockContractService {

    /**
          *  增加或更新
          */
    public StockContract saveUpdate(OptType optType, StockContract optStockContract) throws SystemOptServiceException ;

    public SelectPage<StockContract> search(OptType optType, StockContractSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public List<StockContract> searchList(OptType optType, StockContractSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public StockContract remove(OptType optType, StockContract optStockContract) throws SystemOptServiceException ;

    public StockContract get(Integer id) throws SystemOptServiceException ;

}
