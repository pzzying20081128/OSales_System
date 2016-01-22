package cn.zying.osales.infaces ;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockContractDetail ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockContractDetailSearchBean ;

public interface InfaceStockContractDetailService {

    /**
          *  增加或更新
          */
    public StockContractDetail saveUpdate(OptType optType, StockContractDetail optStockContractDetail) throws SystemOptServiceException ;

    public SelectPage<StockContractDetail> search(OptType optType, StockContractDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public List<StockContractDetail> searchList(OptType optType, StockContractDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public StockContractDetail remove(OptType optType, StockContractDetail optStockContractDetail) throws SystemOptServiceException ;

    public StockContractDetail get(Integer id) throws SystemOptServiceException ;

}
