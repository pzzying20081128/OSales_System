package cn.zying.osales.service.stocks.imples ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInvoice ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockInvoiceService ;
import cn.zying.osales.service.stocks.units.StockInvoiceBillReconcileSearchUnits ;
import cn.zying.osales.service.stocks.units.StockInvoiceCheckUnits ;
import cn.zying.osales.service.stocks.units.StockInvoiceDetailAutoReconcileUnits ;
import cn.zying.osales.service.stocks.units.StockInvoiceDetailCancelReconcileUnits ;
import cn.zying.osales.service.stocks.units.StockInvoiceRemoveUnits ;
import cn.zying.osales.service.stocks.units.StockInvoiceSaveUpdateUnits ;
import cn.zying.osales.service.stocks.units.StockInvoiceSearchUnits ;
import cn.zying.osales.units.search.bean.StockInvoiceSearchBean ;

@Component(IStockInvoiceService.name)
public class StockInvoiceServiceImple extends ABCommonsService implements IStockInvoiceService {

    //@Resource(name="StockInvoiceSearchUnits")
    @Autowired
    @Qualifier("StockInvoiceSearchUnits")
    private StockInvoiceSearchUnits iStockInvoiceSearchUnits ;

    //@Resource(name=" StockInvoiceSaveUpdateUnits")
    @Autowired
    @Qualifier("StockInvoiceSaveUpdateUnits")
    private StockInvoiceSaveUpdateUnits iStockInvoiceSaveUpdateUnits ;

    @Autowired
    @Qualifier("StockInvoiceRemoveUnits")
    private StockInvoiceRemoveUnits iStockInvoiceRemoveUnits ;

    @Autowired
    @Qualifier("StockInvoiceCheckUnits")
    private StockInvoiceCheckUnits iStockInvoiceCheckUnits ;

    @Autowired
    @Qualifier("StockInvoiceBillReconcileSearchUnits")
    private StockInvoiceBillReconcileSearchUnits iStockInvoiceBillReconcileSearchUnits ;

    @Autowired
    @Qualifier("StockInvoiceDetailAutoReconcileUnits")
    private StockInvoiceDetailAutoReconcileUnits iStockInvoiceDetailAutoReconcileUnits ;

    @Autowired
    @Qualifier("StockInvoiceDetailCancelReconcileUnits")
    private StockInvoiceDetailCancelReconcileUnits iStockInvoiceDetailCancelReconcileUnits ;

    @Override
    public StockInvoice saveUpdate(OptType optType, StockInvoice optStockInvoice) throws SystemOptServiceException {
        return iStockInvoiceSaveUpdateUnits.saveUpdate(optType, optStockInvoice) ;
    }

    @Override
    public SelectPage<StockInvoice> search(OptType optType, StockInvoiceSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iStockInvoiceSearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public List<StockInvoice> searchList(OptType optType, StockInvoiceSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockInvoiceSearchUnits.list(optType, searchBean, commSearchBean, startLimit) ;

    }

    @Override
    public StockInvoice remove(OptType optType, StockInvoice optStockInvoice) throws SystemOptServiceException {
        return iStockInvoiceRemoveUnits.remove(optType, optStockInvoice) ;
    }

    @Override
    public StockInvoice get(Integer id) throws SystemOptServiceException {

        return baseService.get(id, StockInvoice.class) ;
    }

    @Override
    public StockInvoice check(StockInvoice stockinvoice) throws SystemOptServiceException {

        return iStockInvoiceCheckUnits.check(stockinvoice) ;
    }

    @Override
    public SelectPage<StockInvoice> searchBillReconcile(OptType optType, StockInvoiceSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iStockInvoiceBillReconcileSearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public StockInvoice autoReconcile(StockInvoice stockinvoice) throws SystemOptServiceException {
        StockInvoice stockinvoice_ = baseService.get(StockInvoice.class, stockinvoice.getId()) ;
        iStockInvoiceDetailAutoReconcileUnits.autoReconciles(stockinvoice_) ;
        return stockinvoice_ ;
    }

    @Override
    public StockInvoice cancelReconcile(StockInvoice stockinvoice) throws SystemOptServiceException {
        StockInvoice stockinvoice_ = baseService.get(StockInvoice.class, stockinvoice.getId()) ;
        iStockInvoiceDetailCancelReconcileUnits.cancelReconciles(stockinvoice_) ;
        return stockinvoice_ ;
    }

}
