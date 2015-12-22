package cn.zying.osales.service.stocks.invoice;

import cn.zying.osales.OSalesConfigProperties.BillType ;
import cn.zying.osales.service.SystemOptServiceException ;

/**
 * 采购发票对帐明细的创建和删除
 * @author you
 *
 */
public interface IStockInvoiceDetailCreateService {
    
    public String name ="IStockInvoiceDetailCreateService";
    
    public  <T>  void createInvoiceDetail(BillType billType , T bill )throws SystemOptServiceException;
    
    public  <T>  void removeInvoiceDetail(BillType billType , T bill )throws SystemOptServiceException;

}
