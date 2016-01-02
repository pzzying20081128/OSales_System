package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockAdjustBill ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockAdjustBillRemoveUnits")
public class StockAdjustBillRemoveUnits extends ABCommonsService {

    public StockAdjustBill remove(OptType optType, StockAdjustBill optStockAdjustBill) throws SystemOptServiceException {

        Integer id = optStockAdjustBill.getId() ;
        StockAdjustBill removeStockAdjustBill = baseService.get(id, StockAdjustBill.class) ;
        removeStockAdjustBill.setStatus(OSalesConfigProperties.Status.删除) ;
        baseService.update(removeStockAdjustBill) ;
        return removeStockAdjustBill ;
    }

}
