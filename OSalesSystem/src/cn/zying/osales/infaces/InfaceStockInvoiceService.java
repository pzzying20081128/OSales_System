package cn.zying.osales.infaces ;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInvoice ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockInvoiceSearchBean ;

public interface InfaceStockInvoiceService {

    /**
          *  增加或更新
          */
    public StockInvoice saveUpdate(OptType optType, StockInvoice optStockInvoice) throws SystemOptServiceException ;

    public SelectPage<StockInvoice> search(OptType optType, StockInvoiceSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public List<StockInvoice> searchList(OptType optType, StockInvoiceSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public StockInvoice remove(OptType optType, StockInvoice optStockInvoice) throws SystemOptServiceException ;

    public StockInvoice get(Integer id) throws SystemOptServiceException ;

    public StockInvoice check(StockInvoice stockinvoice) throws SystemOptServiceException ;

    public SelectPage<StockInvoice> searchBillReconcile(OptType optType, StockInvoiceSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    /**
     * 自动对帐
     */
    public StockInvoice autoReconcile(StockInvoice stockinvoice) throws SystemOptServiceException ;

    /**
     * 取消对帐
     * @param stockinvoice
     * @return
     * @throws SystemOptServiceException
     */
    public StockInvoice cancelReconcile(StockInvoice stockinvoice) throws SystemOptServiceException ;

}
