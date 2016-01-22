package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockContractDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockContractDetailRemoveUnits")
public class StockContractDetailRemoveUnits extends ABCommonsService {

    public StockContractDetail remove(OptType optType, StockContractDetail optStockContractDetail) throws SystemOptServiceException {

        Integer id = optStockContractDetail.getId() ;
        StockContractDetail removeStockContractDetail = baseService.get(id, StockContractDetail.class) ;
        baseService.remove(removeStockContractDetail) ;
        return removeStockContractDetail ;
    }

}
