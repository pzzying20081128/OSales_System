package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInvoiceBillDetail ;
import cn.zying.osales.pojos.StockInvoiceDetail ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockInvoiceDetailService ;
import cn.zying.osales.units.search.bean.StockInvoiceBillDetailSearchBean ;
import cn.zying.osales.units.search.bean.StockInvoiceDetailSearchBean ;

@Component(IAopStockInvoiceDetailService.name)
public class AopStockInvoiceDetailService implements IAopStockInvoiceDetailService {

    @Autowired
    @Qualifier(IStockInvoiceDetailService.name)
    private IStockInvoiceDetailService iStockInvoiceDetailService ;

    //     public StockInvoiceDetail  saveUpdate(OptType  optType ,   StockInvoiceDetail   optStockInvoiceDetail )throws SystemOptServiceException{
    //	
    //	     return  iStockInvoiceDetailService.saveUpdate(  optType ,    optStockInvoiceDetail );
    //	 
    //	 }

    public SelectPage<StockInvoiceDetail> searchReconcile(OptType optType, StockInvoiceDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockInvoiceDetailService.searchReconcile(optType, searchBean, commSearchBean, startLimit) ;

    }

    public List<StockInvoiceDetail> searchReconcileList(OptType optType, StockInvoiceDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockInvoiceDetailService.searchReconcileList(optType, searchBean, commSearchBean, startLimit) ;

    }

    //    public  StockInvoiceDetail    remove(OptType  optType ,  StockInvoiceDetail   optStockInvoiceDetail)throws SystemOptServiceException{
    //			
    //			   return  iStockInvoiceDetailService.remove(  optType ,   optStockInvoiceDetail);
    //			
    //	}

    public StockInvoiceDetail get(Integer id) throws SystemOptServiceException {
        return iStockInvoiceDetailService.get(id) ;

    }

    @Override
    public SelectPage<StockInvoiceBillDetail> searchAllReconcileBill(OptType optType, StockInvoiceBillDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockInvoiceDetailService.searchAllReconcileBill(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public StockInvoiceBillDetail autoReconcile(StockInvoiceBillDetail stockinvoicebilldetail) throws SystemOptServiceException {
        return iStockInvoiceDetailService.autoReconcile(stockinvoicebilldetail) ;
    }

    @Override
    public StockInvoiceBillDetail cancelReconcile(StockInvoiceBillDetail stockinvoicebilldetail) throws SystemOptServiceException {
        return iStockInvoiceDetailService.cancelReconcile(stockinvoicebilldetail) ;
    }

    @Override
    public StockInvoiceBillDetail getStockInvoiceBillDetail(Integer stockInvoiceBillDetailId) throws SystemOptServiceException {
        return iStockInvoiceDetailService.getStockInvoiceBillDetail(stockInvoiceBillDetailId) ;
    }

    @Override
    public StockInvoiceBillDetail handleReconcile(StockInvoiceBillDetail stockinvoicebilldetail) throws SystemOptServiceException {
        return iStockInvoiceDetailService.handleReconcile(stockinvoicebilldetail) ;
    }

}
