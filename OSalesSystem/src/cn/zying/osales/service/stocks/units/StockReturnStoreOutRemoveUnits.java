package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.StockReturn ;
import cn.zying.osales.pojos.StockReturnStoreOut ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockReturnStoreOutRemoveUnits")
public class StockReturnStoreOutRemoveUnits extends ABCommonsService {

    public void del(StockReturn stockReturn) throws SystemOptServiceException {
        String sql = " select  stockReturnStoreOut  from StockReturnStoreOut as  stockReturnStoreOut  where stockReturnStoreOut.stockReturnId = " + stockReturn.getId() ;
        StockReturnStoreOut stockReturnStoreOut = baseService.findSinglenessByHSQL(sql) ;
        if (stockReturnStoreOut.getStatus().equals(Status.已审核)) {
            throw new SystemOptServiceException("该出库单[" + stockReturnStoreOut.getNumber() + "]已经审核,不能取消审核") ;
        }
        String sql1 = "delete  StockReturnStoreOutDetail as stockReturnStoreOutDetail  where  stockReturnStoreOutDetail.stockReturnStoreOutId =  " + stockReturnStoreOut.getId() ;

        String sql2 = "delete  StockReturnStoreOut as stockReturnStoreOut  where  stockReturnStoreOut.id =  " + stockReturnStoreOut.getId() ;

        baseService.executeByHSQL(sql1) ;
        baseService.executeByHSQL(sql2) ;

    }

    public StockReturnStoreOut remove(OptType optType, StockReturnStoreOut optStockReturnStoreOut) throws SystemOptServiceException {

        Integer id = optStockReturnStoreOut.getId() ;
        StockReturnStoreOut removeStockReturnStoreOut = baseService.get(id, StockReturnStoreOut.class) ;
        removeStockReturnStoreOut.setStatus(Status.删除) ;
        baseService.update(removeStockReturnStoreOut) ;
        return removeStockReturnStoreOut ;
    }

}
