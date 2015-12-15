package cn.zying.osales.service.stocks.units ;

import java.util.ArrayList ;
import java.util.List ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.DateToolsUilts ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.units.ToolsUnitsException ;
import cn.zy.apps.tools.units.moneys.BuildMoneyFactory ;
import cn.zy.apps.tools.units.moneys.IBuildMoneyFactory ;
import cn.zying.osales.OSalesConfigProperties.OrderSimpleName ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.ProduceComBinedProduct ;
import cn.zying.osales.pojos.ProductInfo ;
import cn.zying.osales.pojos.ProviderInfo ;
import cn.zying.osales.pojos.StockInStore ;
import cn.zying.osales.pojos.StockInStoreDetail ;
import cn.zying.osales.pojos.StockOrder ;
import cn.zying.osales.pojos.StockOrderDetail ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.BuildProductInfoUnit ;

@Component("StockInStoreCreateUnits")
public class StockInStoreCreateUnits extends ABCommonsService {

    private static IBuildMoneyFactory buildMoneyFactory = BuildMoneyFactory.getBuildMoney() ;

    public StockInStore createStockInStore(ProduceComBinedProduct produceComBinedProduct) throws SystemOptServiceException {

        //创建//   
        StockInStore stockInStore = new StockInStore() ;
        stockInStore.setCreateTime(DateToolsUilts.getnowDate()) ;
        stockInStore.setNumber(this.baseService.genSerialNum(OrderSimpleName.CGRK.name())) ;
        stockInStore.setStockOrder(produceComBinedProduct.getStockOrder()) ;
        stockInStore.setStatus(Status.有效) ;

        stockInStore.setOrderCount(produceComBinedProduct.getProduceCount()) ;

        stockInStore.setProviderInfo(produceComBinedProduct.getStockOrder().getProviderInfo()) ;
        stockInStore.setProviderInfoId(produceComBinedProduct.getStockOrder().getProviderInfoId()) ;

        stockInStore.setRecordDate(produceComBinedProduct.getCheckDate()) ;
        stockInStore.setRecordMan(produceComBinedProduct.getCheckMan()) ;
        stockInStore.setRemarks("组合生产审核自动生成") ;
        stockInStore.setText(null) ;
        stockInStore.setStockType(produceComBinedProduct.getStockOrder().getStockType()) ;
        List<StockInStoreDetail> stockInStoreDetails = new ArrayList<StockInStoreDetail>() ;
        stockInStore.setStockInStoreDetails(stockInStoreDetails) ;

        StockInStoreDetail stockInStoreDetail = new StockInStoreDetail() ;
        stockInStoreDetails.add(stockInStoreDetail) ;
        stockInStoreDetail.setOrderCount(produceComBinedProduct.getProduceCount()) ;
        stockInStoreDetail.setNoTaxPrice(produceComBinedProduct.getStockOrderDetail().getNoTaxPrice()) ;
        stockInStoreDetail.setTaxPrice(produceComBinedProduct.getStockOrderDetail().getTaxPrice()) ;
        stockInStoreDetail.setTaxRate(produceComBinedProduct.getStockOrderDetail().getTaxRate()) ;
        stockInStoreDetail.setNoTaxMoney(buildMoneyFactory.jsSumMoney(stockInStoreDetail.getNoTaxPrice(), stockInStoreDetail.getOrderCount())) ;
        stockInStoreDetail.setTaxMoney(buildMoneyFactory.jsSumMoney(stockInStoreDetail.getTaxPrice(), stockInStoreDetail.getOrderCount())) ;
        stockInStoreDetail.setOrderCount(produceComBinedProduct.getProduceCount()) ;
        stockInStoreDetail.setProductInfo(produceComBinedProduct.getProductInfo()) ;
        stockInStoreDetail.setOrderBox(BuildProductInfoUnit.createBoxCount(stockInStoreDetail.getOrderCount(), produceComBinedProduct.getProductInfo())) ;
        //        stockInStoreDetail.setProtectTime(protectTime);
        stockInStoreDetail.setStockInStore(stockInStore) ;
        stockInStoreDetail.setStoreInfo(produceComBinedProduct.getStoreInfo()) ;
        stockInStoreDetail.setStorePosition(produceComBinedProduct.getStorePosition()) ;
        stockInStoreDetail.setStockOrderDetail(produceComBinedProduct.getStockOrderDetail()) ;

        //////////////////////////////////////////////////////////////////////////////////////////////////
        stockInStore.setNoTaxSumMoney(stockInStoreDetail.getNoTaxMoney()) ;
        stockInStore.setTaxSumMoney(stockInStoreDetail.getTaxMoney()) ;
        baseService.save(stockInStore) ;
        return stockInStore ;
    }

    public StockInStore createStockInStore(StockOrder stockOrder) throws SystemOptServiceException {

        ProviderInfo providerInfo = baseService.load(stockOrder.getProviderInfoId(), ProviderInfo.class) ;

        StockInStore stockInStore = new StockInStore() ;

        stockInStore.setStockOrder(stockOrder) ;

        stockInStore.setNumber(baseService.genSerialNum(OrderSimpleName.CGRK.name())) ;

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

                stockInStoreDetail.setOrderSum(stockInStoreDetail.getOrderCount()) ;

            }
            baseService.save(stockInStore) ;

            return stockInStore ;

        } catch (ToolsUnitsException e) {
            throw new SystemOptServiceException(e) ;
        }

        //        try {
        //
        //            StockInStore stockInStore = createStockInStore(stockOrder) ;
        //
        //            if (stockType.equals(StockType.直营采购订单)) {
        //                stockInStore.setCheckDate(DateToolsUilts.getnowDate()) ;
        //                stockInStore.setCheckMan(stockOrder.getCheckMan()) ;
        //                stockInStore.setStatus(Status.已审核) ;
        //                baseService.update(stockInStore) ;
        //
        //                stockStoreReceiveCreateUnits.createStockInStore(optType, stockType, stockInStore) ;
        //            }
        //
        //        } catch (Exception e) {
        //            throw new SystemOptServiceException(e) ;
        //        }
    }

}
