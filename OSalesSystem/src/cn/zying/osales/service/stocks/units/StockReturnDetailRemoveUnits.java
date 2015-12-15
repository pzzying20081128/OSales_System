package cn.zying.osales.service.stocks.units ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptSum ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockReturnDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockReturnDetailRemoveUnits")
public class StockReturnDetailRemoveUnits extends ABCommonsService {
    
    @Autowired
    @Qualifier("StockReturnSaveUpdateUnits")
    private StockReturnSaveUpdateUnits stockReturnSaveUpdateUnits;

    public StockReturnDetail remove(OptType optType, StockReturnDetail optStockReturnDetail) throws SystemOptServiceException {

        Integer id = optStockReturnDetail.getId() ;
        
        StockReturnDetail removeStockReturnDetail = baseService.get(id, StockReturnDetail.class) ;
        
        baseService.remove(removeStockReturnDetail);
        
        stockReturnSaveUpdateUnits.updateSumMoney(removeStockReturnDetail.getStockReturn(), removeStockReturnDetail, OptSum.del);
      
        return removeStockReturnDetail ;
    }

}
