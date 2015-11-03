package cn.zying.osales.service.stocks.units ;

import java.util.ArrayList ;
import java.util.List ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.DateToolsUilts ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.OrderSimpleName ;
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

    public void createStockInStore(OptType optType, StockType stockType, StockInStore stockInStoreImtp) throws SystemOptServiceException {

        ProviderInfo providerInfo = stockInStoreImtp.getProviderInfo() ;

        StockStoreReceive stockStoreReceive = new StockStoreReceive() ;

        stockStoreReceive.setStockInStore(stockInStoreImtp) ;

        stockStoreReceive.setNumber(baseService.genSerialNum(OrderSimpleName.CGSR.name())) ;

        stockStoreReceive.setStatus(Status.有效) ;

        stockStoreReceive.setProviderInfo(providerInfo) ;

        SysStaffUser recordMan = stockInStoreImtp.getRecordMan() ;

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

                ProductInfo productInfo = stockInStoreDetail.getProductInfo() ;

                stockStoreReceiveDetail.setProductInfo(productInfo) ;

                stockStoreReceiveDetail.setStoreInfo(stockInStoreDetail.getStoreInfo()) ;

                stockStoreReceiveDetail.setStorePosition(stockInStoreDetail.getStorePosition()) ;

                ToolsUnits.copyBeanProperties(stockStoreReceiveDetail, stockInStoreDetail, "noTaxMoney", "taxMoney", "noTaxPrice", "taxPrice", "orderBox", "orderCount", "taxRate") ;

            }
            baseService.save(stockStoreReceive) ;

            if (stockType.equals(StockType.直营采购订单)) {
                stockStoreReceive.setCheckDate(DateToolsUilts.getnowDate()) ;
                stockStoreReceive.setCheckMan(stockInStoreImtp.getCheckMan()) ;
                stockStoreReceive.setStatus(Status.已审核) ;
                baseService.update(stockStoreReceive) ;

            }

        } catch (Exception e) {
            throw new SystemOptServiceException(e) ;
        }

    }

}
