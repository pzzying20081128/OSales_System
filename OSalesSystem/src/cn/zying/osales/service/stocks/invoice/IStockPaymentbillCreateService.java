package cn.zying.osales.service.stocks.invoice;

import cn.zying.osales.OSalesConfigProperties.BillType ;
import cn.zying.osales.service.SystemOptServiceException ;

/**
 * 创建付款对帐明细
 * @author you
 *
 */
public interface IStockPaymentbillCreateService {
    
    public String name = "IStockPaymentbillCreateService" ;
    
    public <T> void createDetail(BillType billType, T bill) throws SystemOptServiceException ;

    public <T> void removeDetail(BillType billType, T bill) throws SystemOptServiceException ;

}
