package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.ProviderInfo ;
import cn.zying.osales.pojos.StockPayment ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockPaymentSaveUpdateUnits")
public class StockPaymentSaveUpdateUnits extends ABCommonsService {

    public StockPayment saveUpdate(OptType optType, StockPayment optStockPayment) throws SystemOptServiceException {

        switch (optType) {
        case save:
            return save(optStockPayment) ;

        case update:
            return update(optStockPayment) ;

        default:
            throw new SystemOptServiceException("[操作类型错误]") ;
        }
    }

    public StockPayment save(StockPayment optStockPayment) throws SystemOptServiceException {
        if (!ToolsUnits.isNOtNulll(optStockPayment.getNum())) {
            optStockPayment.setNum(baseService.genSerialNum(OSalesConfigProperties.OrderSimpleName.CGFK.name())) ;
        }
        optStockPayment.setStatus(Status.有效) ;
        setProperties(optStockPayment) ;

        baseService.save(optStockPayment) ;
        return optStockPayment ;
    }

    public StockPayment update(StockPayment optStockPayment) throws SystemOptServiceException {
        setProperties(optStockPayment) ;
        StockPayment stockPayment = baseService.get(optStockPayment.getId(), StockPayment.class) ;

        ToolsUnits.copyBeanProperties(stockPayment, optStockPayment,

        "num", "otherSideReceiveNum", "providerInfo", "providerInfoId", "isPrePayment",

        "paymentDate", "paymentSum", "text", "otherSideBank", "ourBank", "paymentType",

        "noKillSum", "killSum", "reconciliationSum") ;

        return optStockPayment ;
    }

    private void setProperties(StockPayment stockPayment) {
        if (stockPayment.getRecordManId() != null) {
            stockPayment.setRecordMan(baseService.load(stockPayment.getRecordManId(), SysStaffUser.class)) ;
        }

        if (stockPayment.getStockManId() != null) {
            stockPayment.setStockMan(baseService.load(stockPayment.getStockManId(), SysStaffUser.class)) ;
        }

        if (stockPayment.getProviderInfoId() != null) {
            stockPayment.setProviderInfo(baseService.load(stockPayment.getProviderInfoId(), ProviderInfo.class)) ;
        }

        stockPayment.setNoKillSum(stockPayment.getPaymentSum()) ;
        stockPayment.setKillSum(OSalesConfigProperties.default_long_null) ;
        stockPayment.setReconciliationSum(stockPayment.getNoKillSum()) ;

    }

}
