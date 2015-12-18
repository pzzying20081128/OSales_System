package  cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockReturnStoreOutDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;


@Component("StockReturnStoreOutDetailRemoveUnits")
public class StockReturnStoreOutDetailRemoveUnits extends ABCommonsService {

    public StockReturnStoreOutDetail  remove(OptType optType, StockReturnStoreOutDetail  optStockReturnStoreOutDetail ) throws SystemOptServiceException {
        
         Integer id =optStockReturnStoreOutDetail.getId() ;
        StockReturnStoreOutDetail   removeStockReturnStoreOutDetail =baseService.get(id, StockReturnStoreOutDetail.class);
        baseService.remove(removeStockReturnStoreOutDetail);
        return  removeStockReturnStoreOutDetail ;
    }

}
