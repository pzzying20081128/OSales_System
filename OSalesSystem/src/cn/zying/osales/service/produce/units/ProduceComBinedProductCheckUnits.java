package cn.zying.osales.service.produce.units ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.DateToolsUilts ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.OSalesConfigProperties.StockType ;
import cn.zying.osales.pojos.ProduceComBinedProduct ;
import cn.zying.osales.pojos.StockInStore ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.units.StockInStoreCheckUnits ;
import cn.zying.osales.service.stocks.units.StockInStoreCreateUnits ;

@Component("ProduceComBinedProductCheckUnits")
public class ProduceComBinedProductCheckUnits extends ABCommonsService {

    @Autowired
    @Qualifier("StockInStoreCreateUnits")
    private StockInStoreCreateUnits stockInStoreCreateUnits ;

    @Autowired
    @Qualifier("StockInStoreCheckUnits")
    private StockInStoreCheckUnits stockInStoreCheckUnits ;

    public void cancelCheckDel(Integer stockOrderId, Class<?> clazz) throws SystemOptServiceException {
        String sql = "select  produceComBinedProduct   from    ProduceComBinedProduct    as    produceComBinedProduct   " +

        "  where produceComBinedProduct.stockOrderId  =  " + stockOrderId +

        "   and    produceComBinedProduct.status  ='" + Status.已审核 + "'  " ;

        Long count = baseService.findSinglenessByHSQL(sql) ;

        if (count > 0) {

        } else {
            String del = "delete  ProduceComBinedProduct    as    produceComBinedProduct    where produceComBinedProduct.stockOrderId  =  " + stockOrderId ;
            baseService.executeByHSQL(del) ;
        }

    }

    public void check(Integer id, Integer oSalsesLoginUserId) throws SystemOptServiceException {
        ProduceComBinedProduct produceComBinedProduct = baseService.load(id, ProduceComBinedProduct.class) ;
        produceComBinedProduct.setCheckManId(oSalsesLoginUserId) ;
        switch (produceComBinedProduct.getStatus()) {
        case 有效:
            checking(produceComBinedProduct) ;
            break ;

        default:
            break ;
        }
    }

    private void checking(ProduceComBinedProduct produceComBinedProduct) throws SystemOptServiceException {

        System.out.println("-->   " + produceComBinedProduct.getStockOrderDetail() + "                     ->  " + produceComBinedProduct.getStockOrderDetailId()) ;

        StockInStore stockInStore = stockInStoreCreateUnits.createStockInStore(produceComBinedProduct) ;

        SysStaffUser checkMan = baseService.load(produceComBinedProduct.getCheckManId(), SysStaffUser.class) ;

        produceComBinedProduct.setCheckMan(checkMan) ;

        produceComBinedProduct.setCheckDate(DateToolsUilts.getnowDate()) ;
        produceComBinedProduct.setStatus(Status.已审核) ;
        produceComBinedProduct.setStockInStore(stockInStore) ;
        baseService.update(produceComBinedProduct) ;
        if (produceComBinedProduct.getStockOrder().getStockType().equals(StockType.直营采购订单)) {
            stockInStoreCheckUnits.check(stockInStore, produceComBinedProduct.getCheckManId()) ;
        }
    }

}
