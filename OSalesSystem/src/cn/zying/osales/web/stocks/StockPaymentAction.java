package cn.zying.osales.web.stocks ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockPayment ;
import cn.zying.osales.units.BuildMoneyUnits ;
import cn.zying.osales.units.search.bean.StockPaymentSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopStockPaymentService ;


@Component("StockPaymentAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class StockPaymentAction extends OSalesSystemABAction<StockPayment> {

    /**
     * 
     */
    private static final long serialVersionUID = -5279229564749454445L ;

    @Autowired
    @Qualifier(IAopStockPaymentService.name)
    private IAopStockPaymentService service ;

    private StockPayment stockpayment ;

    private StockPaymentSearchBean searchBean ;

    public String save() throws Exception {
        try {
            BuildMoneyUnits.build(stockpayment) ;
            stockpayment.setRecordManId(getOSalsesLoginUserId()) ;
            this.result = service.saveUpdate(optType, stockpayment) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public String check() throws Exception {
        try {
            stockpayment.setCheckManId(getOSalsesLoginUserId()) ;
            service.check(stockpayment) ;
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

    public String list() throws Exception {
        try {
            SelectPage<StockPayment> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
            writeObjectService.intToPrpertiesUnits(selectPage) ;
            this.setSelectPage(selectPage) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String remove() throws Exception {
        try {
            this.result = service.remove(OptType.delete, stockpayment) ;
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
