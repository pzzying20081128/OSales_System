package  cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockContract ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;


@Component("StockContractRemoveUnits")
public class StockContractRemoveUnits extends ABCommonsService {

    public StockContract  remove(OptType optType, StockContract  optStockContract ) throws SystemOptServiceException {
        
         Integer id =optStockContract.getId() ;
        StockContract   removeStockContract =baseService.get(id, StockContract.class);
        baseService.update(removeStockContract);
        return  removeStockContract ;
    }

}
