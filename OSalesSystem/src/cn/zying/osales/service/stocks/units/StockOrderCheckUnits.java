package cn.zying.osales.service.stocks.units ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.DateToolsUilts ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.StockOrder ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockOrderCheckUnits")
public class StockOrderCheckUnits extends ABCommonsService {

    @Autowired
    @Qualifier("StockInStoreCreateUnits")
    private StockInStoreCreateUnits stockInStoreCreateUnits ;

    public void check(Integer stockOrderId, Integer checkManId) throws SystemOptServiceException {

        StockOrder stockOrder = baseService.load(stockOrderId, StockOrder.class) ;

        switch (stockOrder.getStatus()) {
        case 已审核:

            break ;
        case 有效:
            check(stockOrder, checkManId) ;
            break ;

        default:
            break ;
        }
    }

    private void check(StockOrder stockOrder, Integer checkManId) throws SystemOptServiceException {
        stockOrder.setStatus(Status.已审核) ;
        SysStaffUser checkMan = baseService.load(checkManId, SysStaffUser.class) ;
        stockOrder.setCheckMan(checkMan) ;
        stockOrder.setCheckDate(DateToolsUilts.getnowDate()) ;
        baseService.update(stockOrder) ;
        stockInStoreCreateUnits.createStockInStore(OptType.check, stockOrder.getStockType(), stockOrder) ;

    }

}
