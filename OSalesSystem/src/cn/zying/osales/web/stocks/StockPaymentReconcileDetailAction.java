package cn.zying.osales.web.stocks ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.StockPaymentDetail ;
import cn.zying.osales.units.search.bean.StockPaymentDetailSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopStockPaymentService ;

/**
 * 付款对帐明细
 * @author you
 *
 */

@Component("StockPaymentReconcileDetailAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class StockPaymentReconcileDetailAction extends OSalesSystemABAction<StockPaymentDetail> {

    private static final long serialVersionUID = 6707182343196098962L ;

    @Autowired
    @Qualifier(IAopStockPaymentService.name)
    private IAopStockPaymentService service ;

    private StockPaymentDetail stockpaymentdetail ;

    private StockPaymentDetailSearchBean searchBean ;

    public String list() throws Exception {
        try {
            SelectPage<StockPaymentDetail> selectPage = service.searchPaymentDetail(optType, searchBean, commSearchBean, start, limit) ;
            writeObjectService.intToPrpertiesUnits(selectPage) ;
            this.setSelectPage(selectPage) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public StockPaymentDetail getStockpaymentdetail() {
        return stockpaymentdetail ;
    }

    public void setStockpaymentdetail(StockPaymentDetail stockpaymentdetail) {
        this.stockpaymentdetail = stockpaymentdetail ;
    }

    public StockPaymentDetailSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(StockPaymentDetailSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
