package cn.zying.osales.infaces ;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockAdjustBill ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockAdjustBillSearchBean ;

public interface InfaceStockAdjustBillService {

    /**
          *  增加或更新
          */
    public StockAdjustBill saveUpdate(OptType optType, StockAdjustBill optStockAdjustBill) throws SystemOptServiceException ;

    public SelectPage<StockAdjustBill> search(OptType optType, StockAdjustBillSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public List<StockAdjustBill> searchList(OptType optType, StockAdjustBillSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public StockAdjustBill remove(OptType optType, StockAdjustBill optStockAdjustBill) throws SystemOptServiceException ;

    public StockAdjustBill get(Integer id) throws SystemOptServiceException ;

    public void check(StockAdjustBill stockadjustbill) throws SystemOptServiceException ;

}
