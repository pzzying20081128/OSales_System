package cn.zying.osales.web.stocks ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockOrder ;
import cn.zying.osales.pojos.StockOrderDetail ;
import cn.zying.osales.units.BuildMoneyUnits ;
import cn.zying.osales.units.search.bean.StockOrderDetailSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopStockOrderDetailService ;
import cn.zying.osales.web.aop.IAopStockOrderService ;

@Component("StockOrderDetailAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class StockOrderDetailAction extends OSalesSystemABAction<StockOrderDetail> {

    /**
     * 
     */
    private static final long serialVersionUID = -5279229564749454445L ;

    @Autowired
    @Qualifier(IAopStockOrderDetailService.name)
    private IAopStockOrderDetailService service ;

    @Autowired
    @Qualifier(IAopStockOrderService.name)
    private IAopStockOrderService stockOrderService ;

    private StockOrderDetail stockorderdetail ;

    private StockOrderDetailSearchBean searchBean ;

    public String save() throws Exception {
        try {

            BuildMoneyUnits.build(stockorderdetail) ;
            this.result = service.saveUpdate(OptType.save, stockorderdetail) ;
            StockOrder stockOrder = stockOrderService.get(this.result.getStockOrderId()) ;
            this.result.setStockOrder(stockOrder) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public String update() throws Exception {
        try {
            BuildMoneyUnits.build(stockorderdetail) ;
            this.result = service.saveUpdate(OptType.update, stockorderdetail) ;
            StockOrder stockOrder = stockOrderService.get(this.result.getStockOrderId()) ;
            this.result.setStockOrder(stockOrder) ;
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
            SelectPage<StockOrderDetail> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
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
            this.result = service.remove(OptType.delete, stockorderdetail) ;
            StockOrder stockOrder = stockOrderService.get(this.result.getStockOrderId()) ;
            this.result.setStockOrder(stockOrder) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public StockOrderDetail getStockorderdetail() {
        return stockorderdetail ;
    }

    public void setStockorderdetail(StockOrderDetail stockorderdetail) {
        this.stockorderdetail = stockorderdetail ;
    }

    public StockOrderDetailSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(StockOrderDetailSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
