package cn.zying.osales.service.stocks.units ;

import java.util.ArrayList ;
import java.util.List ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.DateToolsUilts ;
import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockReturn ;
import cn.zying.osales.pojos.StockReturnDetail ;
import cn.zying.osales.pojos.StockReturnStoreOut ;
import cn.zying.osales.pojos.StockReturnStoreOutDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockReturnStoreOutSaveUpdateUnits")
public class StockReturnStoreOutSaveUpdateUnits extends ABCommonsService {

    public StockReturnStoreOut create(StockReturn stockReturn) throws SystemOptServiceException {
        StockReturnStoreOut stockReturnStoreOut = new StockReturnStoreOut() ;
        stockReturnStoreOut.setNumber(baseService.genSerialNum(OSalesConfigProperties.OrderSimpleName.CGTHCK.name())) ;
        stockReturnStoreOut.setCreateTime(DateToolsUilts.getnowDate()) ;
        stockReturnStoreOut.setNoTaxSumMoney(stockReturn.getNoTaxSumMoney()) ;
        stockReturnStoreOut.setTaxSumMoney(stockReturn.getTaxSumMoney()) ;
        stockReturnStoreOut.setOrderCount(stockReturn.getOrderCount()) ;
        stockReturnStoreOut.setOutStoreDate(stockReturn.getReturnDate()) ;
        stockReturnStoreOut.setProviderInfo(stockReturn.getProviderInfo()) ;
        stockReturnStoreOut.setRecordDate(DateToolsUilts.getnowDate()) ;
        stockReturnStoreOut.setStatus(OSalesConfigProperties.Status.有效) ;
        stockReturnStoreOut.setStockMan(stockReturn.getStockMan()) ;
        stockReturnStoreOut.setStockReturn(stockReturn) ;

        List<StockReturnStoreOutDetail> stockReturnStoreOutDetails = new ArrayList<StockReturnStoreOutDetail>() ;
        stockReturnStoreOut.setStockReturnStoreOutDetails(stockReturnStoreOutDetails) ;
        for (StockReturnDetail stockReturnDetail : stockReturn.getStockReturnDetails()) {
            StockReturnStoreOutDetail stockReturnStoreOutDetail = new StockReturnStoreOutDetail() ;
            stockReturnStoreOutDetails.add(stockReturnStoreOutDetail) ;
            stockReturnStoreOutDetail.setNoTaxMoney(stockReturnDetail.getNoTaxMoney()) ;
            stockReturnStoreOutDetail.setNoTaxPrice(stockReturnDetail.getNoTaxPrice()) ;
            stockReturnStoreOutDetail.setOrderBox(stockReturnDetail.getOrderBox()) ;
            stockReturnStoreOutDetail.setOrderCount(stockReturnDetail.getOrderCount()) ;
            stockReturnStoreOutDetail.setProductInfo(stockReturnDetail.getProductInfo()) ;
            stockReturnStoreOutDetail.setStockReturnDetail(stockReturnDetail) ;
            stockReturnStoreOutDetail.setStockReturnStoreOut(stockReturnStoreOut) ;
            stockReturnStoreOutDetail.setStoreInfo(stockReturnDetail.getStoreInfo()) ;
            stockReturnStoreOutDetail.setStorePosition(stockReturnDetail.getStorePosition()) ;
            stockReturnStoreOutDetail.setTaxMoney(stockReturnDetail.getTaxMoney()) ;
            stockReturnStoreOutDetail.setTaxPrice(stockReturnDetail.getTaxPrice()) ;
            stockReturnStoreOutDetail.setTaxRate(stockReturnDetail.getTaxRate()) ;
        }
        baseService.save(stockReturnStoreOut) ;
        return stockReturnStoreOut;
    }

    public StockReturnStoreOut saveUpdate(OptType optType, StockReturnStoreOut optStockReturnStoreOut) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return save(optStockReturnStoreOut) ;

        case update:
            return update(optStockReturnStoreOut) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public StockReturnStoreOut save(StockReturnStoreOut optStockReturnStoreOut) throws SystemOptServiceException {
        return optStockReturnStoreOut ;
    }

    public StockReturnStoreOut update(StockReturnStoreOut optStockReturnStoreOut) throws SystemOptServiceException {
        return optStockReturnStoreOut ;
    }

}
