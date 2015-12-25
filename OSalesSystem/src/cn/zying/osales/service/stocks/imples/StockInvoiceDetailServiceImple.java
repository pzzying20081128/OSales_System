package cn.zying.osales.service.stocks.imples ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInvoice ;
import cn.zying.osales.pojos.StockInvoiceBillDetail ;
import cn.zying.osales.pojos.StockInvoiceDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockInvoiceDetailService ;
import cn.zying.osales.service.stocks.units.StockInvoiceBillDetailSaveUpdateUnits ;
import cn.zying.osales.service.stocks.units.StockInvoiceBillSearchAllReconcileSearchUnits ;
import cn.zying.osales.service.stocks.units.StockInvoiceDetailAutoReconcileUnits ;
import cn.zying.osales.service.stocks.units.StockInvoiceDetailCancelReconcileUnits ;
import cn.zying.osales.service.stocks.units.StockInvoiceDetailReconcileSearchUnits ;
import cn.zying.osales.service.stocks.units.StockInvoiceDetailRemoveUnits ;
import cn.zying.osales.units.search.bean.StockInvoiceBillDetailSearchBean ;
import cn.zying.osales.units.search.bean.StockInvoiceDetailSearchBean ;

@Component(IStockInvoiceDetailService.name)
public class StockInvoiceDetailServiceImple extends ABCommonsService implements IStockInvoiceDetailService {

    //@Resource(name="StockInvoiceDetailSearchUnits")
    @Autowired
    @Qualifier("StockInvoiceDetailReconcileSearchUnits")
    private StockInvoiceDetailReconcileSearchUnits iStockInvoiceDetailReconcileSearchUnits ;

    //@Resource(name=" StockInvoiceDetailSaveUpdateUnits")
    @Autowired
    @Qualifier("StockInvoiceBillDetailSaveUpdateUnits")
    private StockInvoiceBillDetailSaveUpdateUnits iStockInvoiceBillDetailSaveUpdateUnits ;

    @Autowired
    @Qualifier("StockInvoiceDetailRemoveUnits")
    private StockInvoiceDetailRemoveUnits iStockInvoiceDetailRemoveUnits ;

    //    @Override
    //    public StockInvoiceDetail saveUpdate(OptType optType, StockInvoiceDetail optStockInvoiceDetail) throws SystemOptServiceException {
    //        return iStockInvoiceDetailSaveUpdateUnits.saveUpdate(optType, optStockInvoiceDetail) ;
    //    }

    @Override
    public SelectPage<StockInvoiceDetail> searchReconcile(OptType optType, StockInvoiceDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iStockInvoiceDetailReconcileSearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public List<StockInvoiceDetail> searchReconcileList(OptType optType, StockInvoiceDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockInvoiceDetailReconcileSearchUnits.list(optType, searchBean, commSearchBean, startLimit) ;

    }

    //    @Override
    //    public StockInvoiceDetail remove(OptType optType, StockInvoiceDetail optStockInvoiceDetail) throws SystemOptServiceException {
    //        //			      return   iStockInvoiceDetailRemoveUnits.remove(optType, optStockInvoiceDetail);
    //        return null ;
    //    }
    //
    @Override
    public StockInvoiceDetail get(Integer id) throws SystemOptServiceException {

        return baseService.get(id, StockInvoiceDetail.class) ;
    }

    @Autowired
    @Qualifier("StockInvoiceBillSearchAllReconcileSearchUnits")
    private StockInvoiceBillSearchAllReconcileSearchUnits stockInvoiceBillSearchAllReconcileSearchUnits ;

    @Override
    public SelectPage<StockInvoiceBillDetail> searchAllReconcileBill(OptType optType, StockInvoiceBillDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return stockInvoiceBillSearchAllReconcileSearchUnits.searchAllReconcileBill(optType, searchBean, commSearchBean) ;
    }

    @Autowired
    @Qualifier("StockInvoiceDetailAutoReconcileUnits")
    private StockInvoiceDetailAutoReconcileUnits iStockInvoiceDetailAutoReconcileUnits ;

    @Override
    public StockInvoiceBillDetail autoReconcile(StockInvoiceBillDetail stockinvoicebilldetail) throws SystemOptServiceException {

        StockInvoice stockInvoice = baseService.get(stockinvoicebilldetail.getStockInvoiceId(), StockInvoice.class) ;

        StockInvoiceBillDetail stockInvoiceBillDetail = baseService.get(StockInvoiceBillDetail.class, stockinvoicebilldetail.getId()) ;

        stockInvoiceBillDetail = iStockInvoiceDetailAutoReconcileUnits.autoReconcile(stockInvoice, stockInvoiceBillDetail) ;

        stockInvoiceBillDetail.setStockInvoice(stockInvoice) ;
        return stockInvoiceBillDetail ;

    }

    @Autowired
    @Qualifier("StockInvoiceDetailCancelReconcileUnits")
    private StockInvoiceDetailCancelReconcileUnits iStockInvoiceDetailCancelReconcileUnits ;

    @Override
    public StockInvoiceBillDetail cancelReconcile(StockInvoiceBillDetail stockinvoicebilldetail) throws SystemOptServiceException {
        StockInvoice stockInvoice = baseService.get(stockinvoicebilldetail.getStockInvoiceId(), StockInvoice.class) ;

        StockInvoiceDetail stockInvoiceDetail = baseService.load(stockinvoicebilldetail.getStockInvoiceDetailId(), StockInvoiceDetail.class) ;
        
        StockInvoiceBillDetail  stockinvoicebilldetail_ = iStockInvoiceDetailCancelReconcileUnits.cancelReconciles(stockInvoice, stockInvoiceDetail) ;
        
        stockinvoicebilldetail_ =baseService.get(stockinvoicebilldetail.getId(), StockInvoiceBillDetail.class);
        
        stockinvoicebilldetail_.setStockInvoice(stockInvoice) ;
        
        return stockinvoicebilldetail_ ;
    }

    @Override
    public StockInvoiceBillDetail getStockInvoiceBillDetail(Integer stockInvoiceBillDetailId) throws SystemOptServiceException {
       
        return baseService.get(stockInvoiceBillDetailId, StockInvoiceBillDetail.class) ;
    }

}
