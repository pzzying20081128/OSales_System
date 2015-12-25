package cn.zying.osales.web.stocks ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.OrderSimpleName ;
import cn.zying.osales.pojos.StockOrder ;
import cn.zying.osales.units.search.bean.StockOrderSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopStockOrderService ;

@Component("StockOrderAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class StockOrderAction extends OSalesSystemABAction<StockOrder> {

    /**
     * 
     */
    private static final long serialVersionUID = -5279229564749454445L ;

    @Autowired
    @Qualifier(IAopStockOrderService.name)
    private IAopStockOrderService service ;

    private StockOrder stockorder ;

    private StockOrderSearchBean searchBean ;

//    public String initStockOrder() throws Exception {
//        try {
//            StockOrder stockorder = new StockOrder() ;
//            String orderNumber = baseService.genSerialNum(OrderSimpleName.CGSO.name()) ;
//            stockorder.setNumber(orderNumber) ;
//            this.result = service.saveUpdate(OptType.init, stockorder, getOSalsesLoginUserId()) ;
//
//        } catch (Exception e) {
//            this.success = false ;
//            this.msg = handError(e) ;
//        }
//        return SUCCESS ;
//    }

    public String save() throws Exception {
        try {
            stockorder.setRecordManId(getOSalsesLoginUserId()) ;
            this.result = service.saveUpdate(optType, stockorder, getOSalsesLoginUserId()) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public String check() throws Exception {
        try {
            service.check(stockorder.getId(), getOSalsesLoginUserId()) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public String update() throws Exception {
        try {
            stockorder.setRecordManId(getOSalsesLoginUserId()) ;
            this.result = service.saveUpdate(OptType.update, stockorder, getOSalsesLoginUserId()) ;
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
            SelectPage<StockOrder> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
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
            this.result = service.remove(OptType.delete, stockorder) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public StockOrder getStockorder() {
        return stockorder ;
    }

    public void setStockorder(StockOrder stockorder) {
        this.stockorder = stockorder ;
    }

    public StockOrderSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(StockOrderSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
