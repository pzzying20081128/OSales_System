package cn.zying.osales.web.stocks ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.StockInvoice ;
import cn.zying.osales.pojos.StockInvoiceBillDetail ;
import cn.zying.osales.pojos.StockInvoiceDetail ;
import cn.zying.osales.units.search.bean.StockInvoiceBillDetailSearchBean ;
import cn.zying.osales.units.search.bean.StockInvoiceDetailSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopStockInvoiceDetailService ;

@Component("StockInvoiceBillDetailAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class StockInvoiceBillDetailAction extends OSalesSystemABAction<StockInvoiceBillDetail> {

    @Autowired
    @Qualifier(IAopStockInvoiceDetailService.name)
    private IAopStockInvoiceDetailService service ;

    private StockInvoiceBillDetail stockinvoicebilldetail ;

    private StockInvoiceBillDetailSearchBean searchBean ;

    /**
     * 列出所有的单据
     * @return
     * @throws Exception
     */
    public String listAllBill() throws Exception {
        try {
            SelectPage<StockInvoiceBillDetail> result = service.searchAllReconcileBill(optType, searchBean, commSearchBean, start, limit) ;
            writeObjectService.intToPrpertiesUnits(result) ;
            this.setSelectPage(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String autoReconcile() throws Exception {
        try {
            StockInvoiceBillDetail stockInvoiceBillDetail   = service.autoReconcile(stockinvoicebilldetail) ;
            
            this.result= stockInvoiceBillDetail;
            
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }
    
    /**
     * 取消单据对帐
     * @return
     * @throws Exception
     */
    
    public String cancelReconcile() throws Exception {
        try {
            StockInvoiceBillDetail  stockInvoiceBillDetail   = service.cancelReconcile(stockinvoicebilldetail) ;
            this.result = service.getStockInvoiceBillDetail(stockinvoicebilldetail.getId());
            this.result .setStockInvoice(stockInvoiceBillDetail.getStockInvoice());
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public StockInvoiceBillDetail getStockinvoicebilldetail() {
        return stockinvoicebilldetail ;
    }

    public void setStockinvoicebilldetail(StockInvoiceBillDetail stockinvoicebilldetail) {
        this.stockinvoicebilldetail = stockinvoicebilldetail ;
    }

    public StockInvoiceBillDetailSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(StockInvoiceBillDetailSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
