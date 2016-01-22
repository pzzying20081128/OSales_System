package cn.zying.osales.web.stocks ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.StockPayment ;
import cn.zying.osales.pojos.StockPaymentBillDetail ;
import cn.zying.osales.units.BuildMoneyUnits ;
import cn.zying.osales.units.search.bean.StockPaymentBillDetailSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopStockPaymentService ;

/**
 * 付款对帐票据明细
 * @author you
 *
 */

@Component("StockPaymentReconcileBillDetailAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class StockPaymentReconcileBillDetailAction extends OSalesSystemABAction<StockPaymentBillDetail> {

    private static final long serialVersionUID = 6707182343196098962L ;

    @Autowired
    @Qualifier(IAopStockPaymentService.name)
    private IAopStockPaymentService service ;

    private StockPayment stockpayment ;

    private StockPaymentBillDetail stockpaymentbilldetail ;

    private StockPaymentBillDetailSearchBean searchBean ;

    /**
     *   查询所有的票据明细包含已对帐单
     * @return
     * @throws Exception
     */
    public String searchAllReconcileBillDetail() throws Exception {
        try {
            SelectPage<StockPaymentBillDetail> selectPage = service.searchAllReconcileBillDetail(optType, searchBean, commSearchBean, start, limit) ;
            writeObjectService.intToPrpertiesUnits(selectPage) ;
            this.setSelectPage(selectPage) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String autoReconcile() throws Exception {
        try {
            this.result = service.autoReconcile(stockpaymentbilldetail.getStockPaymentId(), stockpaymentbilldetail.getId()) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public String cancelReconcile() throws Exception {
        try {
            StockPaymentBillDetail stockPaymentBillDetail = service.cancelReconcile(stockpaymentbilldetail.getStockPaymentId(), stockpaymentbilldetail) ;
            StockPaymentBillDetail stockPaymentBillDetail_ = service.getStockPaymentBillDetail(stockPaymentBillDetail.getId()) ;
            stockPaymentBillDetail_.setStockPayment(stockPaymentBillDetail.getStockPayment()) ;
            this.result = stockPaymentBillDetail_ ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    /**
     * 手工对帐
     * @return
     * @throws Exception
     */
    public String handleReconcile() throws Exception {
        try {
            BuildMoneyUnits.build(stockpaymentbilldetail) ;
            this.result = service.handleReconcile(stockpaymentbilldetail) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public StockPaymentBillDetail getStockpaymentbilldetail() {
        return stockpaymentbilldetail ;
    }

    public void setStockpaymentbilldetail(StockPaymentBillDetail stockpaymentbilldetail) {
        this.stockpaymentbilldetail = stockpaymentbilldetail ;
    }

    public StockPaymentBillDetailSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(StockPaymentBillDetailSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

    public StockPayment getStockpayment() {
        return stockpayment ;
    }

    public void setStockpayment(StockPayment stockpayment) {
        this.stockpayment = stockpayment ;
    }

}
