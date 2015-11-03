package cn.zying.osales.service.stocks.units ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.DateToolsUilts ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.StockInStore ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockInStoreCheckUnits")
public class StockInStoreCheckUnits extends ABCommonsService {

    @Autowired
    @Qualifier("StockStoreReceiveCreateUnits")
    private StockStoreReceiveCreateUnits stockStoreReceiveCreateUnits ;

    public void check(Integer id, Integer checkManId) throws SystemOptServiceException {

        StockInStore stockInStore = baseService.load(id, StockInStore.class) ;

        switch (stockInStore.getStatus()) {
        case 已审核:

            break ;
        case 有效:
            check(stockInStore, checkManId) ;
            break ;

        default:
            break ;
        }
    }

    private void check(StockInStore stockInStore, Integer checkManId) throws SystemOptServiceException {
        stockInStore.setStatus(Status.已审核) ;
        SysStaffUser checkMan = baseService.load(checkManId, SysStaffUser.class) ;
        stockInStore.setCheckMan(checkMan) ;
        stockInStore.setCheckDate(DateToolsUilts.getnowDate()) ;
        baseService.update(stockInStore) ;
        stockStoreReceiveCreateUnits.createStockInStore(OptType.check, stockInStore.getStockType(), stockInStore) ;

    }

}
