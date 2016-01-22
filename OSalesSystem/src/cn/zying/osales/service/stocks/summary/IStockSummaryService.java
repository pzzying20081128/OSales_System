package cn.zying.osales.service.stocks.summary ;

import cn.zying.osales.OSalesConfigProperties.BillType ;
import cn.zying.osales.service.SystemOptServiceException ;

/**
 * 采购汇总
 * @author you
 *
 */
public interface IStockSummaryService {

    public String name = "IStockSummaryService" ;

    public <T> void summary(BillType billType, T bill) throws SystemOptServiceException ;

    public <T> void removeSummary(BillType billType, T bill) throws SystemOptServiceException ;

}
