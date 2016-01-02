package cn.zying.osales.infaces ;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockPayment ;
import cn.zying.osales.pojos.StockPaymentBillDetail ;
import cn.zying.osales.pojos.StockPaymentDetail ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockPaymentBillDetailSearchBean ;
import cn.zying.osales.units.search.bean.StockPaymentDetailSearchBean ;
import cn.zying.osales.units.search.bean.StockPaymentSearchBean ;

public interface InfaceStockPaymentService {

    /**
          *  增加或更新
          */
    public StockPayment saveUpdate(OptType optType, StockPayment optStockPayment) throws SystemOptServiceException ;

    public SelectPage<StockPayment> search(OptType optType, StockPaymentSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public List<StockPayment> searchList(OptType optType, StockPaymentSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public StockPayment remove(OptType optType, StockPayment optStockPayment) throws SystemOptServiceException ;

    public StockPayment get(Integer id) throws SystemOptServiceException ;

    public void check(StockPayment stockpayment) throws SystemOptServiceException ;

    /**
     * 查询能对帐的采购付款单
     * @param optType
     * @param searchBean
     * @param commSearchBean
     * @param startLimit
     * @return
     * @throws SystemOptServiceException
     */
    public SelectPage<StockPayment> searchStockReconcilePayment(OptType optType, StockPaymentSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    /**
     * 查询已付款对帐细节
     * @param optType
     * @param searchBean
     * @param commSearchBean
     * @param start
     * @param limit
     * @return
     * @throws SystemOptServiceException
     */
    public SelectPage<StockPaymentDetail> searchPaymentDetail(OptType optType, StockPaymentDetailSearchBean searchBean, CommSearchBean commSearchBean, Integer start, Integer limit) throws SystemOptServiceException ;

    /**
     * 查询所有的票据明细包含已对帐单
     */
    public SelectPage<StockPaymentBillDetail> searchAllReconcileBillDetail(OptType optType, StockPaymentBillDetailSearchBean searchBean,

    CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    /**
     * 自动全部对帐
     * @param stockpayment
     * @return
     * @throws SystemOptServiceException
     */
    public StockPayment autoAllReconcile(StockPayment stockpayment) throws SystemOptServiceException ;

    /**
     * 单据全部对帐
     * @param stockpayment
     * @return
     * @throws SystemOptServiceException
     */
    public StockPaymentBillDetail autoReconcile(Integer stockpaymentId, Integer stockPaymentBillDetailId) throws SystemOptServiceException ;

    /**
     * 手动对帐
     * @param stockpayment
     * @return
     * @throws SystemOptServiceException
     */
    public StockPaymentBillDetail manualReconcile(StockPayment stockpayment, StockPaymentBillDetail stockPaymentBillDetail) throws SystemOptServiceException ;

    /**
     * 自动全部取消对帐
     * @param stockpayment
     * @return
     */
    public StockPayment cancelAllReconcile(StockPayment stockpayment) throws SystemOptServiceException ;

    /**
     * 自动全部取消对帐
     * @param stockpayment
     * @return
     */
    public StockPaymentBillDetail cancelReconcile(Integer stockpaymentId, StockPaymentBillDetail stockPaymentBillDetail) throws SystemOptServiceException ;

    /**
     * 手动对帐
     * @param stockPaymentBillDetail
     * @return
     * @throws SystemOptServiceException
     */
    public StockPaymentBillDetail handleReconcile(StockPaymentBillDetail stockPaymentBillDetail) throws SystemOptServiceException ;

    public StockPaymentBillDetail getStockPaymentBillDetail(Integer id) throws SystemOptServiceException ;
}
