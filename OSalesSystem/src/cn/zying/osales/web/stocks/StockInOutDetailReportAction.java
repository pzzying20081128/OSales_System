package cn.zying.osales.web.stocks ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.StockSummaryBill ;
import cn.zying.osales.units.search.bean.StockSummaryBillSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopStockSummaryBillService ;

@Component("StockInOutDetailReportAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class StockInOutDetailReportAction extends OSalesSystemABAction<StockSummaryBill> {

    /**
     * 
     */
    private static final long serialVersionUID = 5959036891921569777L ;

    @Autowired
    @Qualifier(IAopStockSummaryBillService.name)
    private IAopStockSummaryBillService service ;

    private StockSummaryBillSearchBean searchBean ;

    public String list() throws Exception {
        try {
            SelectPage<StockSummaryBill> selectPage = service.searchStockInOutDetail(optType, searchBean, commSearchBean, start, limit) ;
            writeObjectService.intToPrpertiesUnits(selectPage) ;
            this.setSelectPage(selectPage) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public StockSummaryBillSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(StockSummaryBillSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
