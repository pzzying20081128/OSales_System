package cn.zying.osales.service.stocks.units ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.logger.Loggerfactory ;
import cn.zy.apps.tools.units.DateToolsUilts ;
import cn.zying.osales.OSalesConfigProperties.ProductInfoType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.OSalesConfigProperties.StockType ;
import cn.zying.osales.pojos.StockInStore ;
import cn.zying.osales.pojos.StockOrder ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.produce.units.ProduceComBinedProductCheckUnits ;
import cn.zying.osales.service.produce.units.ProduceComBinedProductCreateUnits ;

@Component("StockOrderCheckUnits")
public class StockOrderCheckUnits extends ABCommonsService {

    @Autowired
    @Qualifier("StockInStoreCreateUnits")
    private StockInStoreCreateUnits stockInStoreCreateUnits ;

    @Autowired
    @Qualifier("StockInStoreSearchUnits")
    private StockInStoreSearchUnits stockInStoreSearchUnits ;

    @Autowired
    @Qualifier("StockInStoreCheckUnits")
    private StockInStoreCheckUnits stockInStoreCheckUnits ;

    @Autowired
    @Qualifier("ProduceComBinedProductCreateUnits")
    private ProduceComBinedProductCreateUnits produceComBinedProductCreateUnits ;

    @Autowired
    @Qualifier("ProduceComBinedProductCheckUnits")
    private ProduceComBinedProductCheckUnits produceComBinedProductCheckUnits ;

    private void check(StockOrder stockOrder) throws SystemOptServiceException {
        String sql = "select  count(stockOrderDetail.id) from  StockOrderDetail  as    stockOrderDetail  " +

        "  where stockOrderDetail.stockOrderId = " + stockOrder.getId() ;

        Long count = baseService.selectSumByHSQL(sql) ;

        if (count != null && count.intValue() == 0) {
            throw new SystemOptServiceException("该订单没有包含任何明细,不能审核") ;
        }

    }

    public void check(StockOrder stockOrder, Integer checkManId) throws SystemOptServiceException {
        Loggerfactory.info(logger, "StockOrderCheckUnits  status  " + stockOrder.getStatus()) ;
        switch (stockOrder.getStatus()) {
        case 已审核:
            cancalCheck(stockOrder, checkManId) ;
            break ;
        case 有效:
            checking(stockOrder, checkManId) ;
            break ;

        default:
            break ;
        }
    }

    private void cancalCheck(StockOrder stockOrder, Integer checkManId) throws SystemOptServiceException {
        ProductInfoType productInfoType = stockOrder.getStockProductType() ;
        switch (productInfoType) {
        case 普通产品: {

            List<StockInStore> stockInStore = stockInStoreSearchUnits.searchByStockOrderId(stockOrder.getId()) ;
            if (stockInStore != null) stockInStoreCheckUnits.cancelCheckDel(stockInStore, checkManId) ;
            stockOrder.setStatus(Status.有效) ;
            stockOrder.setCheckMan(null) ;
            stockOrder.setCheckDate(null) ;
            baseService.update(stockOrder) ;
            break ;
        }
        case 组合产品: {
            produceComBinedProductCheckUnits.cancelCheckDel(stockOrder.getId(), StockOrder.class) ;

        }

        }

    }

    public void check(Integer stockOrderId, Integer checkManId) throws SystemOptServiceException {

        StockOrder stockOrder = baseService.load(stockOrderId, StockOrder.class) ;

        check(stockOrder, checkManId) ;
    }

    private void checking(StockOrder stockOrder, Integer checkManId) throws SystemOptServiceException {
        check(stockOrder) ;
        ProductInfoType productInfoType = stockOrder.getStockProductType() ;

        switch (productInfoType) {
        case 普通产品: {
            stockOrder.setStatus(Status.已审核) ;
            SysStaffUser checkMan = baseService.load(checkManId, SysStaffUser.class) ;
            stockOrder.setCheckMan(checkMan) ;
            stockOrder.setCheckDate(DateToolsUilts.getnowDate()) ;
            baseService.update(stockOrder) ;
            StockInStore stockInStore = stockInStoreCreateUnits.createStockInStore(stockOrder) ;
            if (stockInStore.getStockType().equals(StockType.直营采购订单)) {
                stockInStoreCheckUnits.check(stockInStore, checkManId) ;
            }
        }
            break ;

        case 组合产品: {
            stockOrder.setStatus(Status.已审核) ;
            SysStaffUser checkMan = baseService.load(checkManId, SysStaffUser.class) ;
            stockOrder.setCheckMan(checkMan) ;
            stockOrder.setCheckDate(DateToolsUilts.getnowDate()) ;
            baseService.update(stockOrder) ;
            produceComBinedProductCreateUnits.create(stockOrder) ;
        }
            break ;

        default:
            throw new SystemOptServiceException("ProductInfoType  ERROR ! " + productInfoType) ;
        }

    }
}
