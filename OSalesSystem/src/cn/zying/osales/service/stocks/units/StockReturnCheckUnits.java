package cn.zying.osales.service.stocks.units ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.DateToolsUilts ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.OSalesConfigProperties.StockType ;
import cn.zying.osales.pojos.StockReturn ;
import cn.zying.osales.pojos.StockReturnStoreOut ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockReturnCheckUnits")
public class StockReturnCheckUnits extends ABCommonsService {

    @Autowired
    @Qualifier("StockReturnStoreOutSaveUpdateUnits")
    private StockReturnStoreOutSaveUpdateUnits stockReturnStoreOutSaveUpdateUnits ;

    @Autowired
    @Qualifier("StockReturnStoreOutRemoveUnits")
    private StockReturnStoreOutRemoveUnits stockReturnStoreOutRemoveUnits ;
    
    @Autowired
    @Qualifier("StockReturnStoreOutCheckUnits")
    private StockReturnStoreOutCheckUnits  iStockReturnStoreOutCheckUnits;

    public void check(Integer stockReturnId, int optUser) throws SystemOptServiceException {
        StockReturn stockReturn = baseService.load(stockReturnId, StockReturn.class) ;
        stockReturn.setCheckManId(optUser) ;
        Status status = stockReturn.getStatus() ;
        switch (status) {
        case 有效:
            check(stockReturn) ;
            break ;
        case 已审核:
            noCheck(stockReturn) ;
            break ;

        default:
            throw new SystemOptServiceException("Status[" + stockReturn.getStatus() + "]ERROR") ;
        }
    }

    private void check(StockReturn stockReturn) throws SystemOptServiceException {
        stockReturn.setCheckDate(DateToolsUilts.getnowDate()) ;
        SysStaffUser sysStaffUser = baseService.load(stockReturn.getCheckManId(), SysStaffUser.class) ;
        stockReturn.setCheckMan(sysStaffUser) ;
        stockReturn.setStatus(Status.已审核) ;
        baseService.update(stockReturn) ;
        StockReturnStoreOut  stockReturnStoreOut  = stockReturnStoreOutSaveUpdateUnits.create(stockReturn) ;
        if(stockReturn.getStockType().equals(StockType.直营采购退货单)){
            iStockReturnStoreOutCheckUnits.check(stockReturnStoreOut.getId(), stockReturn.getCheckManId());        
        }
    
    }

    private void noCheck(StockReturn stockReturn) throws SystemOptServiceException {
        stockReturn.setCheckDate(null) ;
        stockReturn.setCheckMan(null) ;
        stockReturn.setStatus(Status.有效) ;
        baseService.update(stockReturn) ;
        stockReturnStoreOutRemoveUnits.del(stockReturn) ;

    }

}
