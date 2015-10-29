package cn.zying.osales.web.stocks ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInStore ;
import cn.zying.osales.pojos.StockOrder ;
import cn.zying.osales.units.search.bean.StockInStoreSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopStockInStoreService ;
import cn.zying.osales.web.aop.IAopStockOrderService ;

@Component("StockInStoreAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class StockInStoreAction extends OSalesSystemABAction<StockInStore> {

    @Autowired
    @Qualifier(IAopStockInStoreService.name)
    private IAopStockInStoreService service ;

    @Autowired
    @Qualifier(IAopStockOrderService.name)
    private IAopStockOrderService stockOrderService ;

    private StockInStore stockinstore ;

    private StockInStoreSearchBean searchBean ;

    public String list() throws Exception {
        try {
            SelectPage<StockInStore> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
            writeObjectService.intToPrpertiesUnits(selectPage) ;
            this.setSelectPage(selectPage) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String update() throws Exception {
        try {

            this.result = service.saveUpdate(OptType.update, stockinstore) ;
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
            StockOrder stockOrder = stockOrderService.get(this.result.getStockOrderId()) ;
            this.result.setStockOrder(stockOrder) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public String remove() throws Exception {
        try {
            this.result = service.remove(OptType.delete, stockinstore) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String check() throws Exception {
        try {
            service.check(uuid, getOSalsesLoginUserId()) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public StockInStore getStockinstore() {
        return stockinstore ;
    }

    public void setStockinstore(StockInStore stockinstore) {
        this.stockinstore = stockinstore ;
    }

    public StockInStoreSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(StockInStoreSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
