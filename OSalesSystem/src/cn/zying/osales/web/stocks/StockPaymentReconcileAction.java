package cn.zying.osales.web.stocks ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.StockPayment ;
import cn.zying.osales.units.search.bean.StockPaymentSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopStockPaymentService ;

/**
 * 付款对帐
 * @author you
 *
 */

@Component("StockPaymentReconcileAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class StockPaymentReconcileAction extends OSalesSystemABAction<StockPayment> {

    @Autowired
    @Qualifier(IAopStockPaymentService.name)
    private IAopStockPaymentService service ;

    private StockPayment stockpayment ;

    private StockPaymentSearchBean searchBean ;

    public String list() throws Exception {
        try {
            SelectPage<StockPayment> selectPage = service.searchStockReconcilePayment(optType, searchBean, commSearchBean, start, limit) ;
            writeObjectService.intToPrpertiesUnits(selectPage) ;
            this.setSelectPage(selectPage) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    /**
     * 自动全部对帐
     * @return
     * @throws Exception
     */
    public String autoAllReconcile() throws Exception {
        try {
            this.result = service.autoAllReconcile(stockpayment) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }
    

    

    public String cancelAllReconcile() throws Exception {
        try {
            this.result = service.cancelAllReconcile(stockpayment) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public String get() throws Exception {
        try {

            this.result = service.get(uuid) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public StockPayment getStockpayment() {
        return stockpayment ;
    }

    public void setStockpayment(StockPayment stockpayment) {
        this.stockpayment = stockpayment ;
    }

    public StockPaymentSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(StockPaymentSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
