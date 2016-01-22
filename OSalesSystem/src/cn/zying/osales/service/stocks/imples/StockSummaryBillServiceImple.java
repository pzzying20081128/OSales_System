package cn.zying.osales.service.stocks.imples ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockSummaryBill ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockSummaryBillService ;
import cn.zying.osales.service.stocks.units.StockInOutDetailSummarySearchUnits ;
import cn.zying.osales.units.search.bean.StockSummaryBillSearchBean ;

@Component(IStockSummaryBillService.name)
public class StockSummaryBillServiceImple extends ABCommonsService implements IStockSummaryBillService {

    //@Resource(name="StockSummaryBillSearchUnits")
    @Autowired
    @Qualifier("StockInOutDetailSummarySearchUnits")
    private StockInOutDetailSummarySearchUnits iStockInOutDetailSummarySearchUnits ;

    @Override
    public SelectPage<StockSummaryBill> searchStockInOutDetail(OptType optType, StockSummaryBillSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iStockInOutDetailSummarySearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

}
