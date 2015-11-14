package cn.zying.osales.service.stocks.units ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.DateToolsUilts ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.OSalesConfigProperties.StockType ;
import cn.zying.osales.pojos.StockInStore ;
import cn.zying.osales.pojos.StockStoreReceive ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockInStoreCheckUnits")
public class StockInStoreCheckUnits extends ABCommonsService {

    @Autowired
    @Qualifier("StockStoreReceiveCreateUnits")
    private StockStoreReceiveCreateUnits stockStoreReceiveCreateUnits ;

    @Autowired
    @Qualifier("StockStoreReceiveCheckUnits")
    private StockStoreReceiveCheckUnits stockStoreReceiveCheckUnits ;

    @Autowired
    @Qualifier("StockStoreReceiveSearchUnits")
    private StockStoreReceiveSearchUnits stockStoreReceiveSearchUnits ;

    public void cancelCheckDel(StockInStore stockInStore, Integer checkManId) throws SystemOptServiceException {

        if (stockInStore == null) return ;

        StockStoreReceive stockStoreReceive = stockStoreReceiveSearchUnits.searchByStockInStoreId(stockInStore.getId()) ;

        stockStoreReceiveCheckUnits.cancelCheckDel(stockStoreReceive, checkManId) ;

        if (stockInStore.getStockType().equals(StockType.直营采购订单)) {
            baseService.remove(stockInStore) ;
        } else if (stockInStore.getStockType().equals(StockType.采购订单)) {
            if (stockInStore.getStatus().equals(Status.已审核)) {
                throw new SystemOptServiceException("此采购进货单[" + stockInStore.getNumber() + "]已被审核") ;
            } else {
                baseService.remove(stockInStore) ;
            }
        }
    }

    public void check(StockInStore stockInStore, Integer checkManId) throws SystemOptServiceException {

        switch (stockInStore.getStatus()) {
        case 已审核:
            cancalCheck(stockInStore, checkManId) ;
            break ;
        case 有效:
            checking(stockInStore, checkManId) ;
            break ;

        default:
            break ;
        }
    }

    private void cancalCheck(StockInStore stockInStore, Integer checkManId) throws SystemOptServiceException {
        if (stockInStore.getStockType().equals(StockType.直营采购订单)) {
            throw new SystemOptServiceException("此单是" + StockType.直营采购订单.name() + "不能取消审核") ;
        } else {
            StockStoreReceive stockStoreReceive = stockStoreReceiveSearchUnits.searchByStockInStoreId(stockInStore.getId()) ;
            stockStoreReceiveCheckUnits.cancelCheckDel(stockStoreReceive, checkManId) ;
            stockInStore.setCheckMan(null) ;
            stockInStore.setStatus(Status.有效) ;
            stockInStore.setCheckDate(null) ;
            baseService.update(stockInStore) ;

        }

    }

    public void check(Integer id, Integer checkManId) throws SystemOptServiceException {

        StockInStore stockInStore = baseService.load(id, StockInStore.class) ;

        check(stockInStore, checkManId) ;
    }

    private void checking(StockInStore stockInStore, Integer checkManId) throws SystemOptServiceException {
        stockInStore.setStatus(Status.已审核) ;
        SysStaffUser checkMan = baseService.load(checkManId, SysStaffUser.class) ;
        stockInStore.setCheckMan(checkMan) ;
        stockInStore.setCheckDate(DateToolsUilts.getnowDate()) ;
        baseService.update(stockInStore) ;
        if (stockInStore.getStockOrder().getStockType().equals(StockType.直营采购订单)) {
            StockStoreReceive stockStoreReceive = stockStoreReceiveCreateUnits.createStockInStore(stockInStore) ;
            stockStoreReceiveCheckUnits.check(stockStoreReceive, checkManId) ;
        }

    }

}
