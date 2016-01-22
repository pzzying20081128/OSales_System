package cn.zying.osales.web.aop ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockSummaryBill ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockSummaryBillService ;
import cn.zying.osales.units.search.bean.StockSummaryBillSearchBean ;

@Component(IAopStockSummaryBillService.name)
public class AopStockSummaryBillService implements IAopStockSummaryBillService {

    @Autowired
    @Qualifier(IStockSummaryBillService.name)
    private IStockSummaryBillService iStockSummaryBillService ;

    public SelectPage<StockSummaryBill> searchStockInOutDetail(OptType optType, StockSummaryBillSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockSummaryBillService.searchStockInOutDetail(optType, searchBean, commSearchBean, startLimit) ;

    }

}
