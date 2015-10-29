package cn.zying.osales.web.stocks ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInStore ;
import cn.zying.osales.pojos.StockStoreReceive ;
import cn.zying.osales.units.search.bean.StockStoreReceiveSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopStockInStoreService ;
import cn.zying.osales.web.aop.IAopStockStoreReceiveService ;

@Component("StockStoreReceiveAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class StockStoreReceiveAction extends OSalesSystemABAction<StockStoreReceive> {

    @Autowired
    @Qualifier(IAopStockStoreReceiveService.name)
    private IAopStockStoreReceiveService service ;

    @Autowired
    @Qualifier(IAopStockInStoreService.name)
    private IAopStockInStoreService stockInStoreService ;

    private StockStoreReceive stockstorereceive ;

    private StockStoreReceiveSearchBean searchBean ;

    public String list() throws Exception {
        try {
            SelectPage<StockStoreReceive> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
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

            this.result = service.saveUpdate(OptType.update, stockstorereceive) ;
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
            StockInStore stockInStore = stockInStoreService.get(this.result.getStockInStoreId()) ;
            this.result.setStockInStore(stockInStore) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public String remove() throws Exception {
        try {
            this.result = service.remove(OptType.delete, stockstorereceive) ;
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

    public StockStoreReceive getStockstorereceive() {
        return stockstorereceive ;
    }

    public void setStockstorereceive(StockStoreReceive stockstorereceive) {
        this.stockstorereceive = stockstorereceive ;
    }

    public StockStoreReceiveSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(StockStoreReceiveSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
