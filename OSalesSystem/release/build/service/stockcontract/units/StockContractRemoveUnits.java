package  cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.pojos.StockContract ; 


@Component("StockContractRemoveUnits")
public class StockContractRemoveUnits extends ABCommonsService {

    public StockContract  remove(OptType optType, StockContract  optStockContract ) throws SystemOptServiceException {
        
         Integer id =optStockContract.getId() ;
        StockContract   removeStockContract =baseService.get(id, StockContract.class);
        baseService.update(removeStockContract);
        return  removeStockContract ;
    }

}
