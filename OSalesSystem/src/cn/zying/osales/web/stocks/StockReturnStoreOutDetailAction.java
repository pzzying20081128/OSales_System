package cn.zying.osales.web.stocks ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockReturnStoreOut ;
import cn.zying.osales.pojos.StockReturnStoreOutDetail ;
import cn.zying.osales.units.BuildMoneyUnits ;
import cn.zying.osales.units.search.bean.StockReturnStoreOutDetailSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopStockReturnStoreOutDetailService ;
import cn.zying.osales.web.aop.IAopStockReturnStoreOutService ;

@Component("StockReturnStoreOutDetailAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class StockReturnStoreOutDetailAction extends OSalesSystemABAction<StockReturnStoreOutDetail> {

    /**
     * 
     */
    private static final long serialVersionUID = -5279229564749454445L ;

    @Autowired
    @Qualifier(IAopStockReturnStoreOutDetailService.name)
    private IAopStockReturnStoreOutDetailService service ;

    @Autowired
    @Qualifier(IAopStockReturnStoreOutService.name)
    private IAopStockReturnStoreOutService stockReturnStoreOutService ;

    private StockReturnStoreOutDetail stockreturnstoreoutdetail ;

    private StockReturnStoreOutDetailSearchBean searchBean ;

    public String saveUpdate() throws Exception {
        try {
            BuildMoneyUnits.build(stockreturnstoreoutdetail) ;
            this.result = service.saveUpdate(optType, stockreturnstoreoutdetail) ;
            StockReturnStoreOut stockReturnStoreOut = stockReturnStoreOutService.get(this.result.getStockReturnStoreOutId()) ;
            this.result.setStockReturnStoreOut(stockReturnStoreOut) ;
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
            SelectPage<StockReturnStoreOutDetail> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
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
            this.result = service.remove(OptType.delete, stockreturnstoreoutdetail) ;
            StockReturnStoreOut stockReturnStoreOut = stockReturnStoreOutService.get(this.result.getStockReturnStoreOutId()) ;
            this.result.setStockReturnStoreOut(stockReturnStoreOut) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public StockReturnStoreOutDetail getStockreturnstoreoutdetail() {
        return stockreturnstoreoutdetail ;
    }

    public void setStockreturnstoreoutdetail(StockReturnStoreOutDetail stockreturnstoreoutdetail) {
        this.stockreturnstoreoutdetail = stockreturnstoreoutdetail ;
    }

    public StockReturnStoreOutDetailSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(StockReturnStoreOutDetailSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
