package cn.zying.osales.web.stocks ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInvoice ;
import cn.zying.osales.pojos.StockInvoiceDetail ;
import cn.zying.osales.units.BuildMoneyUnits ;
import cn.zying.osales.units.search.bean.StockInvoiceDetailSearchBean ;
import cn.zying.osales.units.search.bean.StockInvoiceSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopStockInvoiceDetailService ;
import cn.zying.osales.web.aop.IAopStockInvoiceService ;

@Component("StockInvoiceBillReconcileDetailAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class StockInvoiceBillReconcileDetailAction extends OSalesSystemABAction<StockInvoiceDetail> {

    /**
     * 
     */
    private static final long serialVersionUID = -5279229564749454445L ;

    @Autowired
    @Qualifier(IAopStockInvoiceDetailService.name)
    private IAopStockInvoiceDetailService service ;

    private StockInvoiceDetail stockinvoicedetail ;

    private StockInvoiceDetailSearchBean searchBean ;

    public String listReconcile() throws Exception {
        try {
            SelectPage<StockInvoiceDetail> selectPage = service.searchReconcile(optType, searchBean, commSearchBean, start, limit) ;
            writeObjectService.intToPrpertiesUnits(selectPage) ;
            this.setSelectPage(selectPage) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public StockInvoiceDetail getStockinvoicedetail() {
        return stockinvoicedetail ;
    }

    public void setStockinvoicedetail(StockInvoiceDetail stockinvoicedetail) {
        this.stockinvoicedetail = stockinvoicedetail ;
    }

    public StockInvoiceDetailSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(StockInvoiceDetailSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
