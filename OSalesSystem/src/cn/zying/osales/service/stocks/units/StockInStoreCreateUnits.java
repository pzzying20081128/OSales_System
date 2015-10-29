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
import cn.zying.osales.pojos.StockOrder ;
import cn.zying.osales.pojos.StockOrderDetail ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockInStoreCreateUnits")
public class StockInStoreCreateUnits extends ABCommonsService {

    public void createStockInStore(StockType stockType, StockOrder stockOrder_) throws SystemOptServiceException {

        StockOrder stockOrder = stockOrder_ ;

        ProviderInfo providerInfo = baseService.load(stockOrder.getProviderInfoId(), ProviderInfo.class) ;

        StockInStore stockInStore = new StockInStore() ;

        stockInStore.setStockOrder(stockOrder) ;

        stockInStore.setNumber(baseService.genSerialNum(OSalesConfigProperties.CODE_STOCK_IN_STORE)) ;

        stockInStore.setStatus(Status.有效) ;

        stockInStore.setProviderInfo(providerInfo) ;

        SysStaffUser recordMan = baseService.load(stockOrder.getRecordManId(), SysStaffUser.class) ;

        stockInStore.setRecordMan(recordMan) ;

        stockInStore.setRecordDate(DateToolsUilts.getnowDate()) ;

        try {

            ToolsUnits.copyBeanProperties(stockInStore, stockOrder, "noTaxSumMoney", "orderCount", "remarks", "taxSumMoney", "stockType") ;

            List<StockInStoreDetail> stockInStoreDetails = new ArrayList<StockInStoreDetail>() ;

            stockInStore.setStockInStoreDetails(stockInStoreDetails) ;

            for (StockOrderDetail stockOrderDetail : stockOrder.getStockOrderDetails()) {

                StockInStoreDetail stockInStoreDetail = new StockInStoreDetail() ;

                stockInStoreDetails.add(stockInStoreDetail) ;

                stockInStoreDetail.setStockInStore(stockInStore) ;

                stockInStoreDetail.setStockOrderDetail(stockOrderDetail) ;

                ProductInfo productInfo = baseService.load(stockOrderDetail.getProductInfoId(), ProductInfo.class) ;

                stockInStoreDetail.setProductInfo(productInfo) ;

                stockInStoreDetail.setStoreInfo(stockOrderDetail.getStoreInfo()) ;

                stockInStoreDetail.setStorePosition(stockOrderDetail.getStorePosition()) ;

                ToolsUnits.copyBeanProperties(stockInStoreDetail, stockOrderDetail, "noTaxMoney", "taxMoney", "noTaxPrice", "taxPrice", "orderBox", "orderCount", "taxRate") ;

            }
            baseService.save(stockInStore) ;
        } catch (Exception e) {
            throw new SystemOptServiceException(e) ;
        }

    }

}
