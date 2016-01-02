package cn.zying.osales.service.stocks.imples ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockPayment ;
import cn.zying.osales.pojos.StockPaymentBillDetail ;
import cn.zying.osales.pojos.StockPaymentDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockPaymentService ;
import cn.zying.osales.service.stocks.units.StockPaymentBillDetailSearchUnits ;
import cn.zying.osales.service.stocks.units.StockPaymentBillReconcileSearchUnits ;
import cn.zying.osales.service.stocks.units.StockPaymentCancelReconcileUnits ;
import cn.zying.osales.service.stocks.units.StockPaymentCheckUnits ;
import cn.zying.osales.service.stocks.units.StockPaymentDetailSearchUnits ;
import cn.zying.osales.service.stocks.units.StockPaymentHandleReconcileUnits ;
import cn.zying.osales.service.stocks.units.StockPaymentRemoveUnits ;
import cn.zying.osales.service.stocks.units.StockPaymentSaveUpdateUnits ;
import cn.zying.osales.service.stocks.units.StockPaymentSearchUnits ;
import cn.zying.osales.units.search.bean.StockPaymentBillDetailSearchBean ;
import cn.zying.osales.units.search.bean.StockPaymentDetailSearchBean ;
import cn.zying.osales.units.search.bean.StockPaymentSearchBean ;

@Component(IStockPaymentService.name)
public class StockPaymentServiceImple extends ABCommonsService implements IStockPaymentService {

    //@Resource(name="StockPaymentSearchUnits")
    @Autowired
    @Qualifier("StockPaymentSearchUnits")
    private StockPaymentSearchUnits iStockPaymentSearchUnits ;

    //@Resource(name=" StockPaymentSaveUpdateUnits")
    @Autowired
    @Qualifier("StockPaymentSaveUpdateUnits")
    private StockPaymentSaveUpdateUnits iStockPaymentSaveUpdateUnits ;

    @Autowired
    @Qualifier("StockPaymentRemoveUnits")
    private StockPaymentRemoveUnits iStockPaymentRemoveUnits ;

    @Autowired
    @Qualifier("StockPaymentCheckUnits")
    private StockPaymentCheckUnits iStockPaymentCheckUnits ;

    @Autowired
    @Qualifier("StockPaymentDetailSearchUnits")
    private StockPaymentDetailSearchUnits iStockPaymentDetailSearchUnits ;

    @Autowired
    @Qualifier("StockPaymentBillReconcileUnits")
    private StockPaymentBillReconcileSearchUnits iStockPaymentBillReconcileUnits ;

    @Autowired
    @Qualifier("StockPaymentBillDetailSearchUnits")
    private StockPaymentBillDetailSearchUnits iStockPaymentBillDetailSearchUnits ;

    @Autowired
    @Qualifier("StockPaymentHandleReconcileUnits")
    private StockPaymentHandleReconcileUnits stockPaymentHandleReconcileUnits ;

    @Autowired
    @Qualifier("StockPaymentCancelReconcileUnits")
    private StockPaymentCancelReconcileUnits iStockPaymentCancelReconcileUnits ; ;

    @Override
    public StockPayment saveUpdate(OptType optType, StockPayment optStockPayment) throws SystemOptServiceException {
        return iStockPaymentSaveUpdateUnits.saveUpdate(optType, optStockPayment) ;
    }

    @Override
    public SelectPage<StockPayment> search(OptType optType, StockPaymentSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iStockPaymentSearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public List<StockPayment> searchList(OptType optType, StockPaymentSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockPaymentSearchUnits.list(optType, searchBean, commSearchBean, startLimit) ;

    }

    @Override
    public StockPayment remove(OptType optType, StockPayment optStockPayment) throws SystemOptServiceException {
        return iStockPaymentRemoveUnits.remove(optType, optStockPayment) ;
    }

    @Override
    public StockPayment get(Integer id) throws SystemOptServiceException {

        return baseService.get(id, StockPayment.class) ;
    }

    @Override
    public void check(StockPayment stockpayment) throws SystemOptServiceException {
        iStockPaymentCheckUnits.check(stockpayment) ;

    }

    @Override
    public SelectPage<StockPayment> searchStockReconcilePayment(OptType optType, StockPaymentSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockPaymentBillReconcileUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public SelectPage<StockPaymentDetail> searchPaymentDetail(OptType optType, StockPaymentDetailSearchBean searchBean, CommSearchBean commSearchBean, Integer start, Integer limit) throws SystemOptServiceException {

        return iStockPaymentDetailSearchUnits.searchPaymentDetail(optType, searchBean, commSearchBean, start, limit) ;
    }

    @Override
    public SelectPage<StockPaymentBillDetail> searchAllReconcileBillDetail(OptType optType, StockPaymentBillDetailSearchBean searchBean,

    CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockPaymentBillDetailSearchUnits.searchAllBillDetail(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public StockPayment autoAllReconcile(StockPayment stockpayment) throws SystemOptServiceException {

        return stockPaymentHandleReconcileUnits.autoAllReconcile(stockpayment.getId()) ;
    }

    @Override
    public StockPaymentBillDetail autoReconcile(Integer stockpaymentId, Integer stockPaymentBillDetailId) throws SystemOptServiceException {

        return stockPaymentHandleReconcileUnits.autoReconcile(stockpaymentId, stockPaymentBillDetailId) ;
    }

    @Override
    public StockPaymentBillDetail manualReconcile(StockPayment stockpayment, StockPaymentBillDetail stockPaymentBillDetail) throws SystemOptServiceException {
        return stockPaymentHandleReconcileUnits.manualReconcile(stockpayment.getId(), stockPaymentBillDetail) ;
    }

    @Override
    public StockPayment cancelAllReconcile(StockPayment stockpayment) throws SystemOptServiceException {

        return iStockPaymentCancelReconcileUnits.cancelAllReconcile(stockpayment.getId()) ;
    }

    @Override
    public StockPaymentBillDetail cancelReconcile(Integer stockpaymentId, StockPaymentBillDetail stockPaymentBillDetail) throws SystemOptServiceException {

        StockPayment stockPayment_ = baseService.get(stockpaymentId, StockPayment.class) ;

        StockPaymentDetail stockPaymentDetail = baseService.load(stockPaymentBillDetail.getStockPaymentDetailId(), StockPaymentDetail.class) ;

        StockPaymentBillDetail stockPaymentBillDetail_ = iStockPaymentCancelReconcileUnits.cancelReconcile(stockPayment_, stockPaymentDetail) ;

        stockPaymentBillDetail_.setStockPayment(stockPayment_) ;

        return stockPaymentBillDetail_ ;

    }

    @Override
    public StockPaymentBillDetail getStockPaymentBillDetail(Integer id) throws SystemOptServiceException {

        return baseService.get(id, StockPaymentBillDetail.class) ;
    }

    @Override
    public StockPaymentBillDetail handleReconcile(StockPaymentBillDetail stockPaymentBillDetail) throws SystemOptServiceException {
        // TODO Auto-generated method stub
        return stockPaymentHandleReconcileUnits.handleReconcile(stockPaymentBillDetail.getStockPaymentId(), stockPaymentBillDetail) ;
    }

}
