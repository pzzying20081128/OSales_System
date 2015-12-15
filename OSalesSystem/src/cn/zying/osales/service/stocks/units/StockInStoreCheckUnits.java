package cn.zying.osales.service.stocks.units ;

import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.DateToolsUilts ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.OSalesConfigProperties.StockType ;
import cn.zying.osales.pojos.ProductInfo ;
import cn.zying.osales.pojos.StockInStore ;
import cn.zying.osales.pojos.StockInStoreDetail ;
import cn.zying.osales.pojos.StockOrder ;
import cn.zying.osales.pojos.StockOrderDetail ;
import cn.zying.osales.pojos.StockStoreReceive ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.BuildProductInfoUnit ;
import cn.zying.osales.units.OSToolsUnits ;

@Component("StockInStoreCheckUnits")
public class StockInStoreCheckUnits extends ABCommonsService {

    @Autowired
    @Qualifier("StockStoreReceiveCreateUnits")
    private StockStoreReceiveCreateUnits stockStoreReceiveCreateUnits ;

    @Autowired
    @Qualifier("StockStoreReceiveCheckUnits")
    private StockStoreReceiveCheckUnits stockStoreReceiveCheckUnits ;

    @Autowired
    @Qualifier("StockStoreReceiveSearchUnits")
    private StockStoreReceiveSearchUnits stockStoreReceiveSearchUnits ;

    public void cancelCheckDel(List<StockInStore> stockInStores, Integer checkManId) throws SystemOptServiceException {

        if (stockInStores == null) return ;
        String number = null ;
        for (StockInStore stockInStore : stockInStores) {

            if (stockInStore.getStockType().equals(StockType.直营采购订单)) {

                StockStoreReceive stockStoreReceive = stockStoreReceiveSearchUnits.searchByStockInStoreId(stockInStore.getId()) ;

                stockStoreReceiveCheckUnits.cancelCheckDel(stockStoreReceive, checkManId) ;

                baseService.remove(stockInStore) ;

            } else if (stockInStore.getStockType().equals(StockType.采购订单)) {

                if (stockInStore.getStatus().equals(Status.已审核)) {
                    if (number == null) number = stockInStore.getNumber() ;
                    else
                        number = number + "," + stockInStore.getNumber() ;
                } else {
                    //                    baseService.remove(stockInStore) ;
                }
            }
        }
        if (number != null) throw new SystemOptServiceException("采购入库单[" + number + "]已经审核") ;
        else {
            String del = "delete  from  StockInStore  as  stockInStore  where stockInStore in (:stockInStore) " ;

            String del1 = "delete  from  StockInStoreDetail  as  stockInStoreDetail  where stockInStoreDetail.stockInStore in (:stockInStore) " ;

            Map<String, Object> values = ToolsUnits.createSearchMap() ;
            values.put("stockInStore", stockInStores) ;
            baseService.executeByHSQL(del1, values) ;
            baseService.executeByHSQL(del, values) ;

        }

    }

    public void check(StockInStore stockInStore, Integer checkManId) throws SystemOptServiceException {

        switch (stockInStore.getStatus()) {
        case 已审核:
            cancalCheck(stockInStore, checkManId) ;
            break ;
        case 有效:
            checking(stockInStore, checkManId) ;
            break ;

        default:
            break ;
        }
    }

    private void cancalCheck(StockInStore stockInStore, Integer checkManId) throws SystemOptServiceException {
        if (stockInStore.getStockType().equals(StockType.直营采购订单)) {
            throw new SystemOptServiceException("此单是" + StockType.直营采购订单.name() + "不能取消审核") ;
        } else {
            StockStoreReceive stockStoreReceive = stockStoreReceiveSearchUnits.searchByStockInStoreId(stockInStore.getId()) ;
            stockStoreReceiveCheckUnits.cancelCheckDel(stockStoreReceive, checkManId) ;
            stockInStore.setCheckMan(null) ;
            stockInStore.setStatus(Status.有效) ;
            stockInStore.setCheckDate(null) ;
            baseService.update(stockInStore) ;

        }

    }

    public void check(Integer id, Integer checkManId) throws SystemOptServiceException {

        StockInStore stockInStore = baseService.load(id, StockInStore.class) ;

        check(stockInStore, checkManId) ;
    }

    private void checking(StockInStore stockInStore, Integer checkManId) throws SystemOptServiceException {
        stockInStore.setStatus(Status.已审核) ;
        SysStaffUser checkMan = baseService.load(checkManId, SysStaffUser.class) ;
        stockInStore.setCheckMan(checkMan) ;
        stockInStore.setCheckDate(DateToolsUilts.getnowDate()) ;
        baseService.update(stockInStore) ;

        if (stockInStore.getStockOrder().getStockType().equals(StockType.直营采购订单)) {
            StockStoreReceive stockStoreReceive = stockStoreReceiveCreateUnits.createStockInStore(stockInStore) ;
            stockStoreReceiveCheckUnits.check(stockStoreReceive, checkManId) ;
        } else {
            createNoContain(stockInStore) ;
            stockStoreReceiveCreateUnits.createStockInStore(stockInStore) ;
        }
    }

    private void createNoContain(StockInStore stockInStore) throws SystemOptServiceException {

        StockOrder stockOrder = stockInStore.getStockOrder() ;

        Map<Integer, Object[]> ckeckedProductInfoSum = searchCkeckedProductInfoSum(stockOrder) ;

        List<StockInStoreDetail> createNoContainStockInStoreDetail = new ArrayList<StockInStoreDetail>() ;

        for (Map.Entry<Integer, Object[]> productInfoSum : ckeckedProductInfoSum.entrySet()) {
            Integer productInfoId = productInfoSum.getKey() ;
            Integer product_order_sum = OSToolsUnits.toIntBigDecimal(productInfoSum.getValue()[1]) ;
            Integer product_instore_sum = OSToolsUnits.toIntBigDecimal(productInfoSum.getValue()[2]) == null ? 0 : OSToolsUnits.toIntBigDecimal(productInfoSum.getValue()[2]) ;
            //已全部入库
            if (product_order_sum.intValue() == product_instore_sum.intValue()) continue ;

            StockInStoreDetail stockInStoreDetail = noAllInStore(productInfoId, productInfoSum.getValue(), stockInStore) ;
            if (stockInStoreDetail != null) createNoContainStockInStoreDetail.add(stockInStoreDetail) ;
        }

        if (createNoContainStockInStoreDetail.size() == 0) return ;

        StockInStore createNoContainStockInStore = new StockInStore() ;
        createNoContainStockInStore.setStockOrder(stockInStore.getStockOrder()) ;
        createNoContainStockInStore.setCreateTime(stockInStore.getCreateTime()) ;
        createNoContainStockInStore.setNumber(stockInStore.getNumber() + "-1") ;
        createNoContainStockInStore.setProviderInfo(stockInStore.getProviderInfo()) ;
        createNoContainStockInStore.setRecordDate(stockInStore.getRecordDate()) ;
        createNoContainStockInStore.setRecordMan(stockInStore.getRecordMan()) ;
        createNoContainStockInStore.setRemarks(ToolsUnits.isNOtNulll(stockOrder.getRemarks()) ? stockOrder.getRemarks() + "[采购订单前期没入库产品]" : "[采购订单前期没入库产品]") ;
        createNoContainStockInStore.setStatus(Status.有效) ;
        createNoContainStockInStore.setStockOrder(createNoContainStockInStore.getStockOrder()) ;
        createNoContainStockInStore.setStockType(createNoContainStockInStore.getStockType()) ;
        createNoContainStockInStore.setText(stockInStore.getText()) ;
        createNoContainStockInStore.setStockType(stockInStore.getStockType()) ;
        createNoContainStockInStore.setStockInStoreDetails(createNoContainStockInStoreDetail) ;
        Long taxSumMoney = 0L ;

        Integer orderCount = 0 ;

        Long noTaxSumMoney = 0L ;

        for (StockInStoreDetail stockInStoreDetail : createNoContainStockInStoreDetail) {
            stockInStoreDetail.setStockInStore(createNoContainStockInStore) ;
            taxSumMoney = taxSumMoney + stockInStoreDetail.getTaxMoney() ;
            orderCount = orderCount + stockInStoreDetail.getOrderCount() ;
            noTaxSumMoney = noTaxSumMoney + stockInStoreDetail.getNoTaxMoney() ;
        }
        createNoContainStockInStore.setTaxSumMoney(taxSumMoney) ;
        createNoContainStockInStore.setOrderCount(orderCount) ;
        createNoContainStockInStore.setNoTaxSumMoney(noTaxSumMoney) ;
        baseService.save(createNoContainStockInStore) ;

        // 
    }

    private StockInStoreDetail noAllInStore(Integer productInfoId, Object[] detail, StockInStore stockInStore) {

        Integer product_order_sum = OSToolsUnits.toIntBigDecimal(detail[1]) ;
        Integer product_instore_sum = OSToolsUnits.toIntBigDecimal(detail[2]) == null ? 0 : OSToolsUnits.toIntBigDecimal(detail[2]) ;

        for (StockInStoreDetail stockInStoreDetail : stockInStore.getStockInStoreDetails()) {
            if (productInfoId.intValue() == stockInStoreDetail.getProductInfoId()) {
                if (product_order_sum > product_instore_sum) {
                    StockInStoreDetail createStockInStoreDetail = new StockInStoreDetail() ;
                    createStockInStoreDetail.setNoTaxPrice(stockInStoreDetail.getNoTaxPrice()) ;
                    createStockInStoreDetail.setTaxPrice(stockInStoreDetail.getTaxPrice()) ;
                    createStockInStoreDetail.setOrderCount(product_order_sum - product_instore_sum) ;
                    createStockInStoreDetail.setOrderSum(createStockInStoreDetail.getOrderCount()) ;
                    createStockInStoreDetail.setOrderBox(BuildProductInfoUnit.createBoxCount(createStockInStoreDetail.getOrderCount(), stockInStoreDetail.getProductInfo())) ;

                    createStockInStoreDetail.setProductInfo(stockInStoreDetail.getProductInfo()) ;
                    createStockInStoreDetail.setProductInfoId(stockInStoreDetail.getProductInfo().getId()) ;
                    createStockInStoreDetail.setProtectTime(stockInStoreDetail.getProtectTime()) ;
                    createStockInStoreDetail.setStockOrderDetail(stockInStoreDetail.getStockOrderDetail()) ;

                    createStockInStoreDetail.setStoreInfo(stockInStoreDetail.getStoreInfo()) ;

                    createStockInStoreDetail.setStorePosition(stockInStoreDetail.getStorePosition()) ;

                    createStockInStoreDetail.setTaxRate(stockInStoreDetail.getTaxRate()) ;

                    createStockInStoreDetail.setText(null) ;

                    createStockInStoreDetail.setNoTaxMoney(createStockInStoreDetail.getOrderCount() * createStockInStoreDetail.getNoTaxPrice()) ;
                    createStockInStoreDetail.setTaxMoney(createStockInStoreDetail.getOrderCount() * createStockInStoreDetail.getTaxPrice()) ;
                    return createStockInStoreDetail ;
                } else {
                    return null ;
                }
            }
        }
        //没有在入库单的
        {
            //            3 stock_order_detail.`no_tax_price`,
            //            4 stock_order_detail.`tax_price`,
            //            5stock_order_detail.`protect_time`,
            //             6stock_order_detail.`store_id` ,
            //            7 stock_order_detail.`store_position_id`,
            //            8 stock_order_detail.`taxRate`,

            Long no_tax_price = OSToolsUnits.toLong(detail[3]) ;
            Long tax_price = OSToolsUnits.toLong(detail[4]) ;
            Integer protect_time = OSToolsUnits.toIntBigDecimal(detail[5]) ;
            Integer store_id = OSToolsUnits.toInteger(detail[6]) ;
            Integer store_position_id = OSToolsUnits.toInteger(detail[7]) ;
            Long taxRate = OSToolsUnits.toLong(detail[8]) ;
            Integer stock_order_detail_id = OSToolsUnits.toInteger(detail[9]) ;

            StockInStoreDetail createStockInStoreDetail = new StockInStoreDetail() ;
            createStockInStoreDetail.setNoTaxPrice(no_tax_price) ;
            createStockInStoreDetail.setTaxPrice(tax_price) ;
            createStockInStoreDetail.setOrderCount(product_order_sum) ;
            createStockInStoreDetail.setOrderSum(createStockInStoreDetail.getOrderCount()) ;
            ProductInfo productInfo = baseService.load(productInfoId, ProductInfo.class) ;
            createStockInStoreDetail.setOrderBox(BuildProductInfoUnit.createBoxCount(createStockInStoreDetail.getOrderCount(), productInfo)) ;

            createStockInStoreDetail.setProductInfo(productInfo) ;
            createStockInStoreDetail.setProductInfoId(productInfo.getId()) ;
            createStockInStoreDetail.setProtectTime(protect_time) ;
            createStockInStoreDetail.setStockOrderDetail(baseService.load(stock_order_detail_id, StockOrderDetail.class)) ;

            createStockInStoreDetail.setStoreInfo(loadStore(store_id)) ;

            createStockInStoreDetail.setStorePosition(loadStorePosition(store_position_id)) ;

            createStockInStoreDetail.setTaxRate(taxRate) ;

            createStockInStoreDetail.setText(null) ;

            createStockInStoreDetail.setNoTaxMoney(createStockInStoreDetail.getOrderCount() * createStockInStoreDetail.getNoTaxPrice()) ;
            createStockInStoreDetail.setTaxMoney(createStockInStoreDetail.getOrderCount() * createStockInStoreDetail.getTaxPrice()) ;
            return createStockInStoreDetail ;
        }
    }

    /**
     * 
     *     stock_order_detail_view.`product_info_id` AS product_info_id ,
     *         stock_order_detail_view.product_order_sum AS product_order_sum,
                product_instore_sum
           3 stock_order_detail.`no_tax_price`,
           4 stock_order_detail.`tax_price`,
           5stock_order_detail.`protect_time`,
            6stock_order_detail.`store_id` ,
           7 stock_order_detail.`store_position_id`,
           8 stock_order_detail.`taxRate`,
        
     * 
     *   //查询采购单
     * @param stockOrder
     * @return   productInfoId   ,  value : product_info_id ,  product_order_sum ,  product_instore_sum
     * @throws SystemOptServiceException
     */
    private Map<Integer, Object[]> searchCkeckedProductInfoSum(StockOrder stockOrder) throws SystemOptServiceException {

        Map<String, Object> value = ToolsUnits.createSearchMap() ;
        value.put("stock_order_id", stockOrder.getId()) ;

        List<Object[]> result = baseService.findByQName("searchCkeckedProductInfoSum", value) ;

        Map<Integer, Object[]> productInfoSum = new HashMap<Integer, Object[]>() ;
        for (Object[] x : result) {
            productInfoSum.put((Integer) x[0], x) ;
        }

        return productInfoSum ;
    }

    //    private void createNoContain(StockInStore stockInStore) {
    //        StockInStore createNoContainStockInStore = new StockInStore() ;
    //        createNoContainStockInStore.setStockOrder(stockInStore.getStockOrder());
    //        createNoContainStockInStore.setCreateTime(stockInStore.getCreateTime()) ;
    //        createNoContainStockInStore.setNumber(stockInStore.getNumber() + "-1") ;
    //        createNoContainStockInStore.setProviderInfo(stockInStore.getProviderInfo()) ;
    //        createNoContainStockInStore.setRecordDate(stockInStore.getRecordDate()) ;
    //        createNoContainStockInStore.setRecordMan(stockInStore.getRecordMan()) ;
    //        createNoContainStockInStore.setRemarks(  ToolsUnits.isNOtNulll(stockInStore.getRemarks() ) ?  stockInStore.getRemarks() + "[采购订单中没有收到的产品]" :  "[采购订单中没有收到的产品]") ;
    //        createNoContainStockInStore.setStatus(Status.有效) ;
    //        createNoContainStockInStore.setStockOrder(createNoContainStockInStore.getStockOrder()) ;
    //        createNoContainStockInStore.setStockType(createNoContainStockInStore.getStockType()) ;
    //        createNoContainStockInStore.setText(stockInStore.getText()) ;
    //        createNoContainStockInStore.setStockType(stockInStore.getStockType());
    //
    //        //        createNoContainStockInStore.setTaxSumMoney(taxSumMoney) ;
    //        //        createNoContainStockInStore.setOrderCount(orderCount) ;
    //        //        createNoContainStockInStore.setNoTaxSumMoney(noTaxSumMoney) ;
    //
    //        List<StockInStoreDetail> stockInStoreDetailses = stockInStore.getStockInStoreDetails() ;
    //
    //        Long taxSumMoney = 0L ;
    //
    //        Integer orderCount = 0 ;
    //
    //        Long noTaxSumMoney = 0L ;
    //        
    //        List<StockInStoreDetail> createNoContainStockInStoreDetail =new ArrayList<StockInStoreDetail>();
    //        createNoContainStockInStore.setStockInStoreDetails(createNoContainStockInStoreDetail);
    //        // 到货少的
    //        for (StockInStoreDetail stockInStoreDetail : stockInStoreDetailses) {
    ////            StockOrderDetail stockOrderDetail = stockInStoreDetail.getStockOrderDetail() ;
    //            if (stockInStoreDetail.getOrderSum().intValue() != stockInStoreDetail.getOrderCount().intValue() ) {
    //                StockInStoreDetail createStockInStoreDetail = new StockInStoreDetail() ;
    //                createNoContainStockInStoreDetail.add(createStockInStoreDetail) ;
    //
    //                createStockInStoreDetail.setNoTaxPrice(stockInStoreDetail.getNoTaxPrice()) ;
    //                createStockInStoreDetail.setTaxPrice(stockInStoreDetail.getTaxPrice());
    //                createStockInStoreDetail.setOrderCount(stockInStoreDetail.getOrderSum().intValue() - stockInStoreDetail.getOrderCount()  ) ;
    //                createStockInStoreDetail.setOrderSum(createStockInStoreDetail.getOrderCount());
    //                createStockInStoreDetail.setOrderBox(BuildProductInfoUnit.createBoxCount(createStockInStoreDetail.getOrderCount(), stockInStoreDetail.getProductInfo())) ;
    //
    //                createStockInStoreDetail.setProductInfo(stockInStoreDetail.getProductInfo()) ;
    //                createStockInStoreDetail.setProductInfoId(stockInStoreDetail.getProductInfo().getId()) ;
    //                createStockInStoreDetail.setProtectTime(stockInStoreDetail.getProtectTime()) ;
    //                createStockInStoreDetail.setStockOrderDetail(stockInStoreDetail.getStockOrderDetail()) ;
    //                createStockInStoreDetail.setStockInStore(createNoContainStockInStore) ;
    //                createStockInStoreDetail.setStoreInfo(stockInStoreDetail.getStoreInfo()) ;
    //                createStockInStoreDetail.setStorePosition(stockInStoreDetail.getStorePosition()) ;
    //
    //                createStockInStoreDetail.setTaxRate(stockInStoreDetail.getTaxRate()) ;
    //
    //                createStockInStoreDetail.setText(null) ;
    //
    //                createStockInStoreDetail.setNoTaxMoney(createStockInStoreDetail.getOrderCount() * createStockInStoreDetail.getNoTaxPrice()) ;
    //                createStockInStoreDetail.setTaxMoney(createStockInStoreDetail.getOrderCount() * createStockInStoreDetail.getTaxPrice()) ;
    //                taxSumMoney = taxSumMoney + createStockInStoreDetail.getTaxMoney() ;
    //                orderCount = orderCount + createStockInStoreDetail.getOrderCount() ;
    //                noTaxSumMoney = noTaxSumMoney + createStockInStoreDetail.getNoTaxMoney() ;
    //
    //            }
    //        }
    //
    //        // 没到货的
    //        ///////////////////////////////////////////////////////////////////////////////////////////////////
    //        StockOrder stockOrder = stockInStore.getStockOrder() ;
    //
    //        List<StockOrderDetail> stockOrderDetails = stockOrder.getStockOrderDetails() ;
    //        boolean isHave = false ;
    //        for (StockOrderDetail stockOrderDetail : stockOrderDetails) {
    //            isHave = false ;
    //            for (StockInStoreDetail stockInStoreDetail : stockInStoreDetailses) {
    //                if (stockOrderDetail.getProductInfoId().intValue() == stockInStoreDetail.getProductInfoId()) {
    //                    isHave = true ;
    //                    break ;
    //                }
    //            }
    //
    //            if (isHave == true) continue ;
    //            ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //            StockInStoreDetail createStockInStoreDetail = new StockInStoreDetail() ;
    //            createNoContainStockInStoreDetail.add(createStockInStoreDetail) ;
    //
    //            createStockInStoreDetail.setNoTaxPrice(stockOrderDetail.getNoTaxPrice()) ;
    //            createStockInStoreDetail.setTaxPrice(stockOrderDetail.getTaxPrice());
    //            createStockInStoreDetail.setOrderCount(stockOrderDetail.getOrderCount().intValue()) ;
    //            createStockInStoreDetail.setOrderSum(createStockInStoreDetail.getOrderCount());
    //            createStockInStoreDetail.setOrderBox(BuildProductInfoUnit.createBoxCount(createStockInStoreDetail.getOrderCount(), stockOrderDetail.getProductInfo())) ;
    //
    //            createStockInStoreDetail.setProductInfo(stockOrderDetail.getProductInfo()) ;
    //            createStockInStoreDetail.setProductInfoId(stockOrderDetail.getProductInfo().getId()) ;
    //            createStockInStoreDetail.setProtectTime(stockOrderDetail.getProtectTime()) ;
    //            createStockInStoreDetail.setStockOrderDetail(stockOrderDetail) ;
    //            createStockInStoreDetail.setStockInStore(createNoContainStockInStore) ;
    //            createStockInStoreDetail.setStoreInfo(stockOrderDetail.getStoreInfo()) ;
    //            createStockInStoreDetail.setStorePosition(stockOrderDetail.getStorePosition()) ;
    //
    //            createStockInStoreDetail.setTaxRate(stockOrderDetail.getTaxRate()) ;
    //            
    //            
    //
    //            createStockInStoreDetail.setText(null) ;
    //
    //            createStockInStoreDetail.setNoTaxMoney(createStockInStoreDetail.getOrderCount() * createStockInStoreDetail.getNoTaxPrice()) ;
    //            createStockInStoreDetail.setTaxMoney(createStockInStoreDetail.getOrderCount() * createStockInStoreDetail.getTaxPrice()) ;
    //            taxSumMoney = taxSumMoney + createStockInStoreDetail.getTaxMoney() ;
    //            orderCount = orderCount + createStockInStoreDetail.getOrderCount() ;
    //            noTaxSumMoney = noTaxSumMoney + createStockInStoreDetail.getNoTaxMoney() ;
    //
    //            /////////////////////////////////////////--------------------------------------/////////////////////////////////////////////////////
    //        }
    //
    //        //////////////////////////////////////////////////////////////////////////////////////////////
    //
    //        createNoContainStockInStore.setTaxSumMoney(taxSumMoney) ;
    //        createNoContainStockInStore.setOrderCount(orderCount) ;
    //        createNoContainStockInStore.setNoTaxSumMoney(noTaxSumMoney) ;
    //        baseService.save(createNoContainStockInStore);
    //    }

}
