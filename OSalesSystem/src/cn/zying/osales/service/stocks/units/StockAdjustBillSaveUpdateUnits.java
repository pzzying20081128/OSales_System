package  cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockAdjustBill ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;


@Component("StockAdjustBillSaveUpdateUnits")
public class StockAdjustBillSaveUpdateUnits extends ABCommonsService {

    public StockAdjustBill saveUpdate(OptType optType, StockAdjustBill optStockAdjustBill) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return   save(optStockAdjustBill) ;

        case update:
            return update(optStockAdjustBill) ;
           

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public StockAdjustBill  save(StockAdjustBill optStockAdjustBill) throws SystemOptServiceException {
        return  optStockAdjustBill;
    }

    public StockAdjustBill  update(StockAdjustBill optStockAdjustBill) throws SystemOptServiceException {
        return  optStockAdjustBill;
    }

}
