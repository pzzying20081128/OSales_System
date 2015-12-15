package cn.zying.osales.storage ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.StoreType ;
import cn.zying.osales.pojos.StockOrderDetail ;
import cn.zying.osales.pojos.StoreProductInfoDetail ;
import cn.zying.osales.pojos.StoreProductInfoStock ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.storage.IInStoreProductInfoStockService.StoreOpt ;
import cn.zying.osales.storage.IInStoreProductInfoStockService.StoreOptType ;

@Component("StockOrderUnits")
public class StockOrderUnits extends StoreUnits<StockOrderDetail> {

    @Override
    public void inStore(StoreOptType storeOptType, StockOrderDetail stockOrderDetail) throws SystemOptServiceException {

        {
            int sum = stockOrderDetail.getOrderCount() ;

            Long money = stockOrderDetail.getTaxMoney() ;

            StoreProductInfoStock storeProductInfoStock = searchStoreProductInfoStock(StoreType.一般仓库, stockOrderDetail.getStoreInfoId(), stockOrderDetail.getProductInfoId(), null) ;

            StoreProductInfoDetail storeProductInfoDetail = searchStoreProductInfoDetail(storeProductInfoStock, stockOrderDetail.getStorePositionId()) ;

            switch (storeOptType) {
            case SaveAdd:
                planInStoreSum(storeProductInfoStock, storeProductInfoDetail, StoreOpt.in, sum, money) ;
                break ;
            case Del:
                planInStoreSum(storeProductInfoStock, storeProductInfoDetail, StoreOpt.out, sum, money) ;
                break ;
            case UpdateAdd:
                planInStoreSum(storeProductInfoStock, storeProductInfoDetail, StoreOpt.in, sum, money) ;
                break ;
            case Check:
                planInStoreSum(storeProductInfoStock, storeProductInfoDetail, StoreOpt.out, sum, money) ;

                break ;
            case CancelCheck:
                purchaseSum(storeProductInfoStock, storeProductInfoDetail, StoreOpt.in, sum, money) ;
                break ;

            }

        }
    }

}
