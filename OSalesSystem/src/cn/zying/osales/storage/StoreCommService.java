package cn.zying.osales.storage ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;

import cn.zying.osales.OSalesConfigProperties.StoreType ;
import cn.zying.osales.pojos.StoreProductInfoDetail ;
import cn.zying.osales.pojos.StoreProductInfoStock ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.storage.IInStoreProductInfoStockService.StoreOpt ;

public class StoreCommService extends ABCommonsService {

    @Autowired
    @Qualifier(IStoreProductInfoUnits.name)
    protected IStoreProductInfoUnits storeProductInfoUnits ;

    protected StoreProductInfoStock searchStoreProductInfoStock(StoreType storeType, Integer storeInfoId, Integer productInfoId, Integer guestInfoId) {
        StoreProductInfoStock storeProductInfoStock = storeProductInfoUnits.search(storeInfoId, productInfoId, guestInfoId) ;
        if (storeProductInfoStock == null) {
            storeProductInfoStock = storeProductInfoUnits.newStoreProductInfoStock(storeType, storeInfoId, productInfoId, guestInfoId) ;

        }
        return storeProductInfoStock ;
    }

    protected StoreProductInfoDetail searchStoreProductInfoDetail(StoreProductInfoStock storeProductInfoStock, Integer storePositionId) {
        if (storePositionId == null) return null ;
        StoreProductInfoDetail storeProductInfoDetail = storeProductInfoUnits.searchDetail(storeProductInfoStock.getId(), storePositionId) ;
        if (storeProductInfoDetail == null) {
            storeProductInfoDetail = storeProductInfoUnits.newStoreProductInfoDetail(storeProductInfoStock, storePositionId) ;
        }
        return storeProductInfoDetail ;
    }

    protected void purchaseSum(StoreProductInfoStock storeProductInfoStock, StoreProductInfoDetail storeProductInfoDetail, StoreOpt storeOpt, int sum, Long money) {
        switch (storeOpt) {
        case in: {
            if (storeProductInfoDetail != null) {
                storeProductInfoDetail.setPurchaseSum(storeProductInfoDetail.getPurchaseSum() + sum) ;
                storeProductInfoDetail.setPurchaseMoney(storeProductInfoDetail.getPurchaseMoney() + money) ;
            }

            storeProductInfoStock.setPurchaseSum(storeProductInfoStock.getPurchaseSum() + sum) ;
            storeProductInfoStock.setPurchaseMoney(storeProductInfoStock.getPurchaseMoney() + money) ;
        }
            break ;

        case out:
            if (storeProductInfoDetail != null) {
                storeProductInfoDetail.setPurchaseSum(storeProductInfoDetail.getPurchaseSum() - sum) ;
                storeProductInfoDetail.setPurchaseMoney(storeProductInfoDetail.getPurchaseMoney() - money) ;
            }

            storeProductInfoStock.setPurchaseSum(storeProductInfoStock.getPurchaseSum() - sum) ;
            storeProductInfoStock.setPurchaseMoney(storeProductInfoStock.getPurchaseMoney() - money) ;
            break ;

        }
    }

    protected void planOutStoreSum(StoreProductInfoStock storeProductInfoStock, StoreProductInfoDetail storeProductInfoDetail, StoreOpt storeOpt, int sum, Long money) {
        switch (storeOpt) {
        case in: {
            if (storeProductInfoDetail != null) {
                storeProductInfoDetail.setPlanOutStoreSum(storeProductInfoDetail.getPlanOutStoreSum() + sum) ;
                storeProductInfoDetail.setPlanOutStoreMoney(storeProductInfoDetail.getPlanOutStoreMoney() + money) ;
            }

            storeProductInfoStock.setPlanOutStoreSum(storeProductInfoStock.getPlanOutStoreSum() + sum) ;
            storeProductInfoStock.setPlanOutStoreMoney(storeProductInfoStock.getPlanOutStoreMoney() + money) ;
        }
            break ;

        case out:
            if (storeProductInfoDetail != null) {
                storeProductInfoDetail.setPlanOutStoreSum(storeProductInfoDetail.getPlanOutStoreSum() - sum) ;
                storeProductInfoDetail.setPlanOutStoreMoney(storeProductInfoDetail.getPlanOutStoreMoney() - money) ;
            }

            storeProductInfoStock.setPlanOutStoreSum(storeProductInfoStock.getPlanOutStoreSum() - sum) ;
            storeProductInfoStock.setPlanOutStoreMoney(storeProductInfoStock.getPlanOutStoreMoney() - money) ;
            break ;

        }
    }

    protected void planInStoreSum(StoreProductInfoStock storeProductInfoStock, StoreProductInfoDetail storeProductInfoDetail, StoreOpt storeOpt, int sum, Long money) {
        switch (storeOpt) {
        case in: {
            if (storeProductInfoDetail != null) {
                storeProductInfoDetail.setPlanInStoreSum(storeProductInfoDetail.getPlanInStoreSum() + sum) ;
                storeProductInfoDetail.setPlanInStoreMoney(storeProductInfoDetail.getPlanInStoreMoney() + money) ;
            }

            storeProductInfoStock.setPlanInStoreSum(storeProductInfoStock.getPlanInStoreSum() + sum) ;
            storeProductInfoStock.setPlanInStoreMoney(storeProductInfoStock.getPlanInStoreMoney() + money) ;
        }
            break ;

        case out:
            if (storeProductInfoDetail != null) {
                storeProductInfoDetail.setPlanInStoreSum(storeProductInfoDetail.getPlanInStoreSum() - sum) ;
                storeProductInfoDetail.setPlanInStoreMoney(storeProductInfoDetail.getPlanInStoreMoney() - money) ;
            }

            storeProductInfoStock.setPlanInStoreSum(storeProductInfoStock.getPlanInStoreSum() - sum) ;
            storeProductInfoStock.setPlanInStoreMoney(storeProductInfoStock.getPlanInStoreMoney() - money) ;
            break ;

        }
    }

    protected void approvaSum(StoreProductInfoStock storeProductInfoStock, StoreProductInfoDetail storeProductInfoDetail, StoreOpt storeOpt, int sum, Long money) {
        switch (storeOpt) {
        case in: {
            if (storeProductInfoDetail != null) {
                storeProductInfoDetail.setApprovalSum(storeProductInfoDetail.getApprovalSum() + sum) ;
                storeProductInfoDetail.setApprovalMoney(storeProductInfoDetail.getApprovalMoney() + money) ;
            }

            storeProductInfoStock.setApprovalSum(storeProductInfoStock.getApprovalSum() + sum) ;
            storeProductInfoStock.setApprovalMoney(storeProductInfoStock.getApprovalMoney() + money) ;
        }
            break ;

        case out:
            if (storeProductInfoDetail != null) {
                storeProductInfoDetail.setApprovalSum(storeProductInfoDetail.getApprovalSum() - sum) ;
                storeProductInfoDetail.setApprovalMoney(storeProductInfoDetail.getApprovalMoney() - money) ;
            }

            storeProductInfoStock.setApprovalSum(storeProductInfoStock.getApprovalSum() - sum) ;
            storeProductInfoStock.setApprovalMoney(storeProductInfoStock.getApprovalMoney() - money) ;
            break ;

        }
    }

}
