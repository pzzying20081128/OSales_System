package cn.zying.osales.service.stocks.units ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zying.osales.OSalesConfigProperties.OptSum ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockReturnStoreOutDetail ;
import cn.zying.osales.pojos.StoreInfo ;
import cn.zying.osales.pojos.StorePosition ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockReturnStoreOutDetailSaveUpdateUnits")
public class StockReturnStoreOutDetailSaveUpdateUnits extends ABCommonsService {
    @Autowired
    @Qualifier("StockReturnStoreOutSaveUpdateUnits")
    private StockReturnStoreOutSaveUpdateUnits stockReturnStoreOutSaveUpdateUnits ;

    public StockReturnStoreOutDetail saveUpdate(OptType optType, StockReturnStoreOutDetail optStockReturnStoreOutDetail) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return save(optStockReturnStoreOutDetail) ;

        case update:
            return update(optStockReturnStoreOutDetail) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public StockReturnStoreOutDetail save(StockReturnStoreOutDetail optStockReturnStoreOutDetail) throws SystemOptServiceException {
        return optStockReturnStoreOutDetail ;
    }

    public StockReturnStoreOutDetail update(StockReturnStoreOutDetail optStockReturnStoreOutDetail) throws SystemOptServiceException {

        StockReturnStoreOutDetail stockReturnStoreOutDetail = baseService.get(StockReturnStoreOutDetail.class, optStockReturnStoreOutDetail.getId()) ;

        stockReturnStoreOutSaveUpdateUnits.updateSumMoney(stockReturnStoreOutDetail.getStockReturnStoreOut(), stockReturnStoreOutDetail, OptSum.del) ;

        StoreInfo storeInfo = baseService.load(optStockReturnStoreOutDetail.getStoreInfoId(), StoreInfo.class) ;

        StorePosition storePosition = baseService.load(optStockReturnStoreOutDetail.getStorePositionId(), StorePosition.class) ;

        stockReturnStoreOutDetail.setStoreInfo(storeInfo) ;

        stockReturnStoreOutDetail.setStoreInfoId(storeInfo.getId()) ;

        stockReturnStoreOutDetail.setStorePosition(storePosition) ;

        stockReturnStoreOutDetail.setStorePositionId(storePosition.getId()) ;

        stockReturnStoreOutDetail.setOrderCount(optStockReturnStoreOutDetail.getOrderCount()) ;

        stockReturnStoreOutDetail.setOrderBox(optStockReturnStoreOutDetail.getOrderBox()) ;

        stockReturnStoreOutDetail.setNoTaxMoney(stockReturnStoreOutDetail.getNoTaxPrice() * optStockReturnStoreOutDetail.getOrderCount()) ;

        stockReturnStoreOutDetail.setTaxMoney(stockReturnStoreOutDetail.getTaxPrice() * optStockReturnStoreOutDetail.getOrderCount()) ;

        baseService.update(stockReturnStoreOutDetail) ;

        stockReturnStoreOutSaveUpdateUnits.updateSumMoney(stockReturnStoreOutDetail.getStockReturnStoreOut(), stockReturnStoreOutDetail, OptSum.add) ;

        return stockReturnStoreOutDetail ;
    }

}
