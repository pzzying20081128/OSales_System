package cn.zying.osales.service.stocks.units ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.DateToolsUilts ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.StockPayment ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("StockPaymentCheckUnits")
public class StockPaymentCheckUnits extends ABCommonsService {

    public void check(StockPayment stockpayment_) throws SystemOptServiceException {
        StockPayment  stockpayment = baseService.load(stockpayment_.getId(), StockPayment.class) ;
        stockpayment.setCheckManId(stockpayment_.getCheckManId());
        switch (stockpayment.getStatus()) {
        case 有效:
            checking(stockpayment) ;
            break ;
        case 已审核:
            nochecking(stockpayment) ;
            break ;

        default:
            break ;
        }
    }

    private void checking(StockPayment stockpayment) throws SystemOptServiceException {
        SysStaffUser sysStaffUser = baseService.load(stockpayment.getCheckManId(), SysStaffUser.class) ;
        stockpayment.setCheckMan(sysStaffUser) ;
        stockpayment.setCheckedDate(DateToolsUilts.getnowDate()) ;
        stockpayment.setStatus(Status.已审核) ;
        baseService.update(stockpayment) ;

    }

    private void nochecking(StockPayment stockpayment) throws SystemOptServiceException {

        stockpayment.setCheckMan(null) ;
        stockpayment.setCheckedDate(null) ;
        stockpayment.setStatus(Status.有效) ;
        baseService.update(stockpayment) ;

    }
}
