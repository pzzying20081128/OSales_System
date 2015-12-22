package  cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;


import cn.zying.osales.pojos.StockContract ; 


@Component("StockContractSaveUpdateUnits")
public class StockContractSaveUpdateUnits extends ABCommonsService {

    public StockContract saveUpdate(OptType optType, StockContract optStockContract) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return   save(optStockContract) ;
            break ;
        case update:
            return update(optStockContract) ;
            break ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public StockContract  save(StockContract optStockContract) throws SystemOptServiceException {

    }

    public StockContract  update(StockContract optStockContract) throws SystemOptServiceException {

    }

}
