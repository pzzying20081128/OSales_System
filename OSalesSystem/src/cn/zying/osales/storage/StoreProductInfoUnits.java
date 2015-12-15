package cn.zying.osales.storage ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.OSalesConfigProperties.StoreType ;
import cn.zying.osales.pojos.ProductInfo ;
import cn.zying.osales.pojos.StoreInfo ;
import cn.zying.osales.pojos.StorePosition ;
import cn.zying.osales.pojos.StoreProductInfoDetail ;
import cn.zying.osales.pojos.StoreProductInfoStock ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component(IStoreProductInfoUnits.name)
public class StoreProductInfoUnits extends ABCommonsService implements IStoreProductInfoUnits {

    @Override
    public StoreProductInfoDetail newStoreProductInfoDetail(StoreProductInfoStock storeProductInfoStock, Integer storePositionId) {
        StoreProductInfoDetail storeProductInfoDetail = new StoreProductInfoDetail() ;
        storeProductInfoDetail.setStoreProductInfoStock(storeProductInfoStock) ;
        storeProductInfoDetail.setStoreProductInfoStockId(storeProductInfoStock.getId()) ;

        storeProductInfoDetail.setApprovalMoney(OSalesConfigProperties.default_long_null) ;
        storeProductInfoDetail.setApprovalSum(OSalesConfigProperties.default_int_null) ;
        storeProductInfoDetail.setPlanOutStoreMoney(OSalesConfigProperties.default_long_null) ;
        storeProductInfoDetail.setPlanOutStoreSum(OSalesConfigProperties.default_int_null) ;
        storeProductInfoDetail.setPurchaseMoney(OSalesConfigProperties.default_long_null) ;
        storeProductInfoDetail.setPurchaseSum(OSalesConfigProperties.default_int_null) ;
        storeProductInfoDetail.setPlanInStoreMoney(OSalesConfigProperties.default_long_null) ;
        storeProductInfoDetail.setPlanInStoreSum(OSalesConfigProperties.default_int_null) ;

        StorePosition storePosition = baseService.load(storePositionId, StorePosition.class) ;

        storeProductInfoDetail.setStorePosition(storePosition) ;

        baseService.save(storeProductInfoDetail) ;

        return storeProductInfoDetail ;
    }

    public StoreProductInfoStock newStoreProductInfoStock(StoreType storeType, Integer storeInfoId, Integer productInfoId, Integer guestInfoId) {
        StoreProductInfoStock storeProductInfoStock = new StoreProductInfoStock() ;
        storeProductInfoStock.setApprovalMoney(OSalesConfigProperties.default_long_null) ;
        storeProductInfoStock.setApprovalSum(OSalesConfigProperties.default_int_null) ;
        storeProductInfoStock.setPlanOutStoreMoney(OSalesConfigProperties.default_long_null) ;
        storeProductInfoStock.setPlanOutStoreSum(OSalesConfigProperties.default_int_null) ;
        storeProductInfoStock.setPurchaseMoney(OSalesConfigProperties.default_long_null) ;
        storeProductInfoStock.setPurchaseSum(OSalesConfigProperties.default_int_null) ;
        storeProductInfoStock.setPlanInStoreMoney(OSalesConfigProperties.default_long_null) ;
        storeProductInfoStock.setPlanInStoreSum(OSalesConfigProperties.default_int_null) ;

        storeProductInfoStock.setStoreType(storeType) ;
        if (guestInfoId != null) {
            storeProductInfoStock.setGuestInfoId(guestInfoId) ;
        }

        ProductInfo productInfo = baseService.load(productInfoId, ProductInfo.class) ;
        storeProductInfoStock.setProductInfoId(productInfoId) ;
        storeProductInfoStock.setProductInfo(productInfo) ;
        StoreInfo storeInfo = baseService.load(storeInfoId, StoreInfo.class) ;
        storeProductInfoStock.setStoreInfoId(storeInfoId) ;
        storeProductInfoStock.setStoreInfo(storeInfo) ;
        baseService.save(storeProductInfoStock) ;
        return storeProductInfoStock ;
    }

    private StoreProductInfoStock searchFromDB(Integer storeInfoId, Integer productInfoId, Integer guestInfoId) throws SystemOptServiceException {

        String sql = "select  storeProductInfoStock   from  StoreProductInfoStock as storeProductInfoStock   " +

        "  where  storeProductInfoStock.storeInfoId =" + storeInfoId +

        "   and   storeProductInfoStock.productInfoId = " + productInfoId ;

        if (guestInfoId != null) {
            sql = sql + "    and  storeProductInfoStock.guestInfoId=" + guestInfoId ;
        }

        StoreProductInfoStock storeProductInfoStock = baseService.findSinglenessByHSQL(sql) ;

        return storeProductInfoStock ;

    }

    @Override
    public StoreProductInfoStock search(Integer storeInfoId, Integer productInfoId, Integer guestInfoId) throws SystemOptServiceException {

        StoreProductInfoStock storeProductInfoStock = searchFromDB(storeInfoId, productInfoId, guestInfoId) ;

        return storeProductInfoStock ;

    }

    private StoreProductInfoDetail searchdb(Integer storeProductInfoStockId, Integer storePositionId) throws SystemOptServiceException {

        String sql = "select  storeProductInfoDetail   from  StoreProductInfoDetail  as storeProductInfoDetail   " +

        "  where  storeProductInfoDetail.storeProductInfoStockId =" + storeProductInfoStockId +

        "   and   storeProductInfoDetail.storePositionId = " + storePositionId ;

        StoreProductInfoDetail storeProductInfoDetail = baseService.findSinglenessByHSQL(sql) ;

        return storeProductInfoDetail ;
    }

    @Override
    public StoreProductInfoDetail searchDetail(Integer storeProductInfoStockId, Integer storePositionId) throws SystemOptServiceException {

        StoreProductInfoDetail storeProductInfoDetail = searchdb(storeProductInfoStockId, storePositionId) ;

        return storeProductInfoDetail ;
    }

}
