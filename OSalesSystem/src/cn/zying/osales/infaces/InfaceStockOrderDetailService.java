package cn.zying.osales.infaces ;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockOrderDetail ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockOrderDetailSearchBean ;

public interface InfaceStockOrderDetailService {

    /**
          *  增加或更新
          */
    public StockOrderDetail saveUpdate(OptType optType, StockOrderDetail optStockOrderDetail) throws SystemOptServiceException ;

    public SelectPage<StockOrderDetail> search(OptType optType, StockOrderDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public List<StockOrderDetail> searchList(OptType optType, StockOrderDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public StockOrderDetail remove(OptType optType, StockOrderDetail optStockOrderDetail) throws SystemOptServiceException ;

    public StockOrderDetail get(Integer id) throws SystemOptServiceException ;

}
