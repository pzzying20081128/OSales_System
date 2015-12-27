package cn.zying.osales.web.stocks ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.StockInvoice ;
import cn.zying.osales.units.search.bean.StockInvoiceSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopStockInvoiceService ;

@Component("StockInvoiceBillReconcileAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class StockInvoiceBillReconcileAction extends OSalesSystemABAction<StockInvoice> {

    /**
     * 
     */
    private static final long serialVersionUID = -5279229564749454445L ;

    @Autowired
    @Qualifier(IAopStockInvoiceService.name)
    private IAopStockInvoiceService service ;

    private StockInvoice stockinvoice ;

    private StockInvoiceSearchBean searchBean ;

    public String autoReconcile() throws Exception {
        try {
            this.result = service.autoReconcile(stockinvoice) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public String cancelReconcile() throws Exception {
        try {
            this.result = service.cancelReconcile(stockinvoice) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    //    public String check() throws Exception {
    //        try {
    //            stockinvoice.setCheckManId(getOSalsesLoginUserId()) ;
    //            service.check(stockinvoice) ;
    //        } catch (Exception e) {
    //            this.success = false ;
    //            this.msg = handError(e) ;
    //        }
    //        return SUCCESS ;
    //    }

    //    public String update() throws Exception {
    //        try {
    //            stockinvoice.setRecordManId(getOSalsesLoginUserId()) ;
    //            this.result = service.saveUpdate(OptType.update, stockinvoice) ;
    //            writeObjectService.intToPrpertiesUnits(result) ;
    //        } catch (Exception e) {
    //            this.success = false ;
    //            this.msg = handError(e) ;
    //        }
    //        return SUCCESS ;
    //    }

    //    public String get() throws Exception {
    //        try {
    //
    //            this.result = service.get(uuid) ;
    //            writeObjectService.intToPrpertiesUnits(result) ;
    //        } catch (Exception e) {
    //            this.success = false ;
    //            this.msg = handError(e) ;
    //        }
    //        return SUCCESS ;
    //    }

    public String list() throws Exception {
        try {
            SelectPage<StockInvoice> selectPage = service.searchBillReconcile(optType, searchBean, commSearchBean, start, limit) ;
            writeObjectService.intToPrpertiesUnits(selectPage) ;
            this.setSelectPage(selectPage) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    //    public String remove() throws Exception {
    //        try {
    //            this.result = service.remove(OptType.delete, stockinvoice) ;
    //            writeObjectService.intToPrpertiesUnits(result) ;
    //        } catch (Exception e) {
    //            this.success = false ;
    //            this.msg = handError(e) ;
    //        }
    //
    //        return SUCCESS ;
    //    }

    public StockInvoice getStockinvoice() {
        return stockinvoice ;
    }

    public void setStockinvoice(StockInvoice stockinvoice) {
        this.stockinvoice = stockinvoice ;
    }

    public StockInvoiceSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(StockInvoiceSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
