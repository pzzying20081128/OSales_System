package cn.zying.osales.infaces ;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockPayment ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockPaymentSearchBean ;

public interface InfaceStockPaymentService {

    /**
          *  增加或更新
          */
    public StockPayment saveUpdate(OptType optType, StockPayment optStockPayment) throws SystemOptServiceException ;

    public SelectPage<StockPayment> search(OptType optType, StockPaymentSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public List<StockPayment> searchList(OptType optType, StockPaymentSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public StockPayment remove(OptType optType, StockPayment optStockPayment) throws SystemOptServiceException ;

    public StockPayment get(Integer id) throws SystemOptServiceException ;
    
    public  void check(StockPayment stockpayment)  throws SystemOptServiceException ;

}
