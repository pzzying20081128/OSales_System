package cn.zying.osales.web.stocks ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.OrderSimpleName ;
import cn.zying.osales.pojos.StockReturn ;
import cn.zying.osales.units.search.bean.StockReturnSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopStockReturnService ;

@Component("StockReturnAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class StockReturnAction extends OSalesSystemABAction<StockReturn> {

    /**
     * 
     */
    private static final long serialVersionUID = -5279229564749454445L ;

    @Autowired
    @Qualifier(IAopStockReturnService.name)
    private IAopStockReturnService service ;

    private StockReturn stockreturn ;

    private StockReturnSearchBean searchBean ;

    public String initOrder() throws Exception {
        try {
            StockReturn stockReturn = new StockReturn() ;
            String orderNumber = baseService.genSerialNum(OrderSimpleName.CGTH.name()) ;
            stockReturn.setNumber(orderNumber) ;
            this.result = service.saveUpdate(OptType.init, stockReturn, getOSalsesLoginUserId()) ;

        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public String save() throws Exception {
        try {
            stockreturn.setRecordManId(getOSalsesLoginUserId()) ;
            this.result = service.saveUpdate(optType, stockreturn, getOSalsesLoginUserId()) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public String check() throws Exception {
                try {
                    service.check(stockreturn.getId(), getOSalsesLoginUserId()) ;
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
            SelectPage<StockReturn> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
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
            this.result = service.remove(OptType.delete, stockreturn) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public StockReturn getStockreturn() {
        return stockreturn ;
    }

    public void setStockreturn(StockReturn stockreturn) {
        this.stockreturn = stockreturn ;
    }

    public StockReturnSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(StockReturnSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
