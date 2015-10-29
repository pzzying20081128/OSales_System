package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.DateToolsUilts ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.StockStoreReceive ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockStoreReceiveCheckUnits")
public class StockStoreReceiveCheckUnits extends ABCommonsService {

    public void check(Integer id, Integer optUserId) throws SystemOptServiceException {
        StockStoreReceive stockStoreReceive = baseService.get(id, StockStoreReceive.class) ;
        switch (stockStoreReceive.getStatus()) {
        case 有效:
            check(stockStoreReceive, optUserId) ;
            break ;
        case 已审核:
           
            break ;

        default:
            throw new SystemOptServiceException("status " + stockStoreReceive.getStatus() + " error") ;
        }
    }

    private void check(StockStoreReceive stockStoreReceive, Integer optUserId) throws SystemOptServiceException {
        SysStaffUser checkMan = baseService.load(optUserId, SysStaffUser.class) ;
        stockStoreReceive.setCheckMan(checkMan) ;
        stockStoreReceive.setStatus(Status.已审核);
        stockStoreReceive.setCheckDate(DateToolsUilts.getnowDate()) ;
        baseService.update(stockStoreReceive) ;

    }
}
