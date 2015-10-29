package cn.zying.osales.service.stocks.units ;

import java.util.ArrayList ;
import java.util.List ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.DateToolsUilts ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.OSalesConfigProperties.StockType ;
import cn.zying.osales.pojos.ProductInfo ;
import cn.zying.osales.pojos.ProviderInfo ;
import cn.zying.osales.pojos.StockInStore ;
import cn.zying.osales.pojos.StockInStoreDetail ;
import cn.zying.osales.pojos.StockStoreReceive ;
import cn.zying.osales.pojos.StockStoreReceiveDetail ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockStoreReceiveCreateUnits")
public class StockStoreReceiveCreateUnits extends ABCommonsService {

    public void createStockInStore(StockType stockType, StockInStore stockInStoreImtp) throws SystemOptServiceException {

        ProviderInfo providerInfo = baseService.load(stockInStoreImtp.getProviderInfoId(), ProviderInfo.class) ;

        StockStoreReceive stockStoreReceive = new StockStoreReceive() ;

        stockStoreReceive.setStockInStore(stockInStoreImtp) ;

        stockStoreReceive.setNumber(baseService.genSerialNum(OSalesConfigProperties.CODE_STOCK_STORE_RECEIVE)) ;

        stockStoreReceive.setStatus(Status.有效) ;

        stockStoreReceive.setProviderInfo(providerInfo) ;

        SysStaffUser recordMan = baseService.load(stockInStoreImtp.getRecordManId(), SysStaffUser.class) ;

        stockStoreReceive.setRecordMan(recordMan) ;

        stockStoreReceive.setRecordDate(DateToolsUilts.getnowDate()) ;

        try {

            ToolsUnits.copyBeanProperties(stockStoreReceive, stockInStoreImtp, "noTaxSumMoney", "orderCount", "remarks", "taxSumMoney", "stockType") ;

            List<StockStoreReceiveDetail> stockStoreReceiveDetails = new ArrayList<StockStoreReceiveDetail>() ;

            stockStoreReceive.setStockStoreReceiveDetails(stockStoreReceiveDetails) ;

            for (StockInStoreDetail stockInStoreDetail : stockInStoreImtp.getStockInStoreDetails()) {

                StockStoreReceiveDetail stockStoreReceiveDetail = new StockStoreReceiveDetail() ;

                stockStoreReceiveDetails.add(stockStoreReceiveDetail) ;

                stockStoreReceiveDetail.setStockInStoreDetail(stockInStoreDetail) ;

                stockStoreReceiveDetail.setStockStoreReceive(stockStoreReceive) ;

                ProductInfo productInfo = baseService.load(stockInStoreDetail.getProductInfoId(), ProductInfo.class) ;

                stockStoreReceiveDetail.setProductInfo(productInfo) ;

                stockStoreReceiveDetail.setStoreInfo(stockInStoreDetail.getStoreInfo()) ;

                stockStoreReceiveDetail.setStorePosition(stockInStoreDetail.getStorePosition()) ;

                ToolsUnits.copyBeanProperties(stockStoreReceiveDetail, stockInStoreDetail, "noTaxMoney", "taxMoney", "noTaxPrice", "taxPrice", "orderBox", "orderCount", "taxRate") ;

            }
            baseService.save(stockStoreReceive) ;
        } catch (Exception e) {
            throw new SystemOptServiceException(e) ;
        }

    }

}
