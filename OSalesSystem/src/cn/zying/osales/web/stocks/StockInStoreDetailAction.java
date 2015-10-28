package cn.zying.osales.web.stocks ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInStore ;
import cn.zying.osales.pojos.StockInStoreDetail ;
import cn.zying.osales.pojos.StockOrder ;
import cn.zying.osales.pojos.StockOrderDetail ;
import cn.zying.osales.units.search.bean.StockInStoreDetailSearchBean ;
import cn.zying.osales.units.search.bean.StockInStoreSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopStockInStoreDetailService ;
import cn.zying.osales.web.aop.IAopStockInStoreService ;
import cn.zying.osales.web.aop.IAopStockOrderDetailService ;
import cn.zying.osales.web.aop.IAopStockOrderService ;

@Component("StockInStoreDetailAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class StockInStoreDetailAction extends OSalesSystemABAction<StockInStoreDetail> {

    @Autowired
    @Qualifier(IAopStockInStoreDetailService.name)
    private IAopStockInStoreDetailService service ;

    @Autowired
    @Qualifier(IAopStockOrderDetailService.name)
    private IAopStockOrderDetailService stockOrderDetailService ;

    private StockInStoreDetail stockInstoredetail ;

    private StockInStoreDetailSearchBean searchBean ;

    public String list() throws Exception {
        try {
            SelectPage<StockInStoreDetail> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
            writeObjectService.intToPrpertiesUnits(selectPage) ;
            this.setSelectPage(selectPage) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String saveUpdate() throws Exception {
        try {

            this.result = service.saveUpdate(optType, stockInstoredetail) ;
            StockOrderDetail stockOrderDetail = stockOrderDetailService.get(result.getStockOrderDetailId()) ;
            this.result.setStockOrderDetail(stockOrderDetail) ;
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
            StockOrderDetail stockOrderDetail = stockOrderDetailService.get(result.getStockOrderDetailId()) ;
            this.result.setStockOrderDetail(stockOrderDetail) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public String remove() throws Exception {
        try {
            this.result = service.remove(OptType.delete, stockInstoredetail) ;
            StockOrderDetail stockOrderDetail = stockOrderDetailService.get(result.getStockOrderDetailId()) ;
            this.result.setStockOrderDetail(stockOrderDetail) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public StockInStoreDetail getStockInstoredetail() {
        return stockInstoredetail ;
    }

    public void setStockInstoredetail(StockInStoreDetail stockInstoredetail) {
        this.stockInstoredetail = stockInstoredetail ;
    }

    public StockInStoreDetailSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(StockInStoreDetailSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

 

}
