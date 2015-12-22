package cn.zying.osales.infaces ;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProductCategory ;
import cn.zying.osales.pojos.StockInvoiceDetail ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.ProductCategorySearchBean ;
import cn.zying.osales.units.search.bean.StockInvoiceDetailSearchBean ;

public interface InfaceStockInvoiceDetailService {
 
    /**
          *  增加或更新
          */
//    public StockInvoiceDetail saveUpdate(OptType optType, StockInvoiceDetail optStockInvoiceDetail) throws SystemOptServiceException ;

    public SelectPage<StockInvoiceDetail> searchReconcile(OptType optType, StockInvoiceDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public List<StockInvoiceDetail> searchReconcileList(OptType optType, StockInvoiceDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

//    public StockInvoiceDetail remove(OptType optType, StockInvoiceDetail optStockInvoiceDetail) throws SystemOptServiceException ;

//    public StockInvoiceDetail get(Integer id) throws SystemOptServiceException ;

}