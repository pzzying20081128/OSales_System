package cn.zying.osales.infaces ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockSummaryBill ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockSummaryBillSearchBean ;

public interface InfaceStockSummaryBillService {

    public SelectPage<StockSummaryBill> searchStockInOutDetail(OptType optType, StockSummaryBillSearchBean searchBean,

    CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

}
