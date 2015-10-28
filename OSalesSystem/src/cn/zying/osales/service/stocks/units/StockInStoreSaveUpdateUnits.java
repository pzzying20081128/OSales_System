package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInStore ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockInStoreSaveUpdateUnits")
public class StockInStoreSaveUpdateUnits extends ABCommonsService {

    public StockInStore saveUpdate(OptType optType, StockInStore optStockInStore) throws SystemOptServiceException {

        switch (optType) {

        case update:
            return update(optStockInStore) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public StockInStore update(StockInStore optStockInStore) throws SystemOptServiceException {

        StockInStore stockInStore = baseService.get(optStockInStore.getId(), StockInStore.class) ;

        try {
            ToolsUnits.copyBeanProperties(stockInStore, optStockInStore, "remarks", "text") ;

            baseService.update(stockInStore) ;

            return stockInStore ;

        } catch (Exception e) {
            throw new SystemOptServiceException(e) ;
        }

    }

}
