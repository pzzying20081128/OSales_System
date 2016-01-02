package cn.zying.osales.web.stocks ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockAdjustBill ;
import cn.zying.osales.pojos.StockInvoice ;
import cn.zying.osales.units.BuildMoneyUnits ;
import cn.zying.osales.units.search.bean.StockAdjustBillSearchBean ;
import cn.zying.osales.units.search.bean.StockInvoiceSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopStockAdjustBillService ;
import cn.zying.osales.web.aop.IAopStockInvoiceService ;

@Component("StockAdjustBillAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class StockAdjustBillAction extends OSalesSystemABAction<StockAdjustBill> {

    /**
     * 
     */
    private static final long serialVersionUID = -5279229564749454445L ;

    @Autowired
    @Qualifier(IAopStockAdjustBillService.name)
    private IAopStockAdjustBillService service ;

    private StockAdjustBill stockadjustbill ;

    private StockAdjustBillSearchBean searchBean ;

    public String save() throws Exception {
        try {
            BuildMoneyUnits.build(stockadjustbill) ;
            stockadjustbill.setRecordManId(getOSalsesLoginUserId()) ;
            this.result = service.saveUpdate(optType, stockadjustbill) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public String check() throws Exception {
        try {
            stockadjustbill.setCheckManId(getOSalsesLoginUserId()) ;
//            service.check(stockadjustbill) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public String update() throws Exception {
        try {
            stockadjustbill.setRecordManId(getOSalsesLoginUserId()) ;
            this.result = service.saveUpdate(OptType.update, stockadjustbill) ;
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

    public String list() throws Exception {
        try {
            SelectPage<StockAdjustBill> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
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
            this.result = service.remove(OptType.delete, stockadjustbill) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public StockAdjustBill getStockadjustbill() {
        return stockadjustbill ;
    }

    public void setStockadjustbill(StockAdjustBill stockadjustbill) {
        this.stockadjustbill = stockadjustbill ;
    }

    public StockAdjustBillSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(StockAdjustBillSearchBean searchBean) {
        this.searchBean = searchBean ;
    }



}
