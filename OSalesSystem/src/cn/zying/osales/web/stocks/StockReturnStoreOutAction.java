package cn.zying.osales.web.stocks ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockReturn ;
import cn.zying.osales.pojos.StockReturnStoreOut ;
import cn.zying.osales.units.search.bean.StockReturnStoreOutSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopStockReturnService ;
import cn.zying.osales.web.aop.IAopStockReturnStoreOutService ;

@Component("StockReturnStoreOutAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class StockReturnStoreOutAction extends OSalesSystemABAction<StockReturnStoreOut> {

    /**
     * 
     */
    private static final long serialVersionUID = -5279229564749454445L ;

    @Autowired
    @Qualifier(IAopStockReturnStoreOutService.name)
    private IAopStockReturnStoreOutService service ;

    @Autowired
    @Qualifier(IAopStockReturnService.name)
    private IAopStockReturnService stockReturnService ;

    private StockReturnStoreOut stockreturnstoreout ;

    private StockReturnStoreOutSearchBean searchBean ;

    public String save() throws Exception {
        try {
            stockreturnstoreout.setRecordManId(getOSalsesLoginUserId()) ;
            this.result = service.saveUpdate(optType, stockreturnstoreout) ;
            StockReturn stockReturn = stockReturnService.get(this.result.getStockReturnId()) ;
            this.result.setStockReturn(stockReturn) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public String check() throws Exception {
        try {
            service.check(stockreturnstoreout.getId(), getOSalsesLoginUserId()) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public String get() throws Exception {
        try {

            this.result = service.get(uuid) ;
            StockReturn stockReturn = stockReturnService.get(this.result.getStockReturnId()) ;
            this.result.setStockReturn(stockReturn) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public String list() throws Exception {
        try {
            SelectPage<StockReturnStoreOut> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
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
            this.result = service.remove(OptType.delete, stockreturnstoreout) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public StockReturnStoreOut getStockreturnstoreout() {
        return stockreturnstoreout ;
    }

    public void setStockreturnstoreout(StockReturnStoreOut stockreturnstoreout) {
        this.stockreturnstoreout = stockreturnstoreout ;
    }

    public StockReturnStoreOutSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(StockReturnStoreOutSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
