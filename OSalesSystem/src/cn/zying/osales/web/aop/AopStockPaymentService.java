package cn.zying.osales.web.aop ;

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
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.stocks.IStockPaymentService ;
import cn.zying.osales.units.search.bean.StockPaymentBillDetailSearchBean ;
import cn.zying.osales.units.search.bean.StockPaymentDetailSearchBean ;
import cn.zying.osales.units.search.bean.StockPaymentSearchBean ;

@Component(IAopStockPaymentService.name)
public class AopStockPaymentService implements IAopStockPaymentService {

    @Autowired
    @Qualifier(IStockPaymentService.name)
    private IStockPaymentService iStockPaymentService ;

    public StockPayment saveUpdate(OptType optType, StockPayment optStockPayment) throws SystemOptServiceException {

        return iStockPaymentService.saveUpdate(optType, optStockPayment) ;

    }

    public SelectPage<StockPayment> search(OptType optType, StockPaymentSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockPaymentService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    public List<StockPayment> searchList(OptType optType, StockPaymentSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockPaymentService.searchList(optType, searchBean, commSearchBean, startLimit) ;

    }

    public StockPayment remove(OptType optType, StockPayment optStockPayment) throws SystemOptServiceException {

        return iStockPaymentService.remove(optType, optStockPayment) ;

    }

    public StockPayment get(Integer id) throws SystemOptServiceException {
        return iStockPaymentService.get(id) ;

    }

    public void check(StockPayment stockpayment) throws SystemOptServiceException {
        iStockPaymentService.check(stockpayment) ;
    }

    @Override
    public SelectPage<StockPayment> searchStockReconcilePayment(OptType optType, StockPaymentSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockPaymentService.searchStockReconcilePayment(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public SelectPage<StockPaymentDetail> searchPaymentDetail(OptType optType, StockPaymentDetailSearchBean searchBean, CommSearchBean commSearchBean, Integer start, Integer limit) throws SystemOptServiceException {

        return iStockPaymentService.searchPaymentDetail(optType, searchBean, commSearchBean, start, limit) ;
    }

    @Override
    public SelectPage<StockPaymentBillDetail> searchAllReconcileBillDetail(OptType optType, StockPaymentBillDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iStockPaymentService.searchAllReconcileBillDetail(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public StockPayment autoAllReconcile(StockPayment stockpayment) throws SystemOptServiceException {

        return iStockPaymentService.autoAllReconcile(stockpayment) ;
    }

    @Override
    public StockPaymentBillDetail autoReconcile(Integer stockpaymentId, Integer stockPaymentBillDetailId) throws SystemOptServiceException {

        return iStockPaymentService.autoReconcile(stockpaymentId, stockPaymentBillDetailId) ;
    }

    @Override
    public StockPaymentBillDetail manualReconcile(StockPayment stockpayment, StockPaymentBillDetail stockPaymentBillDetail) throws SystemOptServiceException {
        return iStockPaymentService.manualReconcile(stockpayment, stockPaymentBillDetail) ;
    }

    @Override
    public StockPayment cancelAllReconcile(StockPayment stockpayment) throws SystemOptServiceException {

        return iStockPaymentService.cancelAllReconcile(stockpayment) ;
    }

    @Override
    public StockPaymentBillDetail cancelReconcile(Integer stockpaymentId, StockPaymentBillDetail stockPaymentBillDetail) throws SystemOptServiceException {

        return iStockPaymentService.cancelReconcile(stockpaymentId, stockPaymentBillDetail) ;
    }

    @Override
    public StockPaymentBillDetail getStockPaymentBillDetail(Integer id) throws SystemOptServiceException {

        return iStockPaymentService.getStockPaymentBillDetail(id) ;
    }

    @Override
    public StockPaymentBillDetail handleReconcile(StockPaymentBillDetail stockPaymentBillDetail) throws SystemOptServiceException {

        return iStockPaymentService.handleReconcile(stockPaymentBillDetail) ;
    }

}
