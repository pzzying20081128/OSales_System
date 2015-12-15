package cn.zying.osales.web.stocks ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.OrderSimpleName ;
import cn.zying.osales.pojos.StockReturn ;
import cn.zying.osales.pojos.StockReturnDetail ;
import cn.zying.osales.units.BuildMoneyUnits ;
import cn.zying.osales.units.search.bean.StockReturnDetailSearchBean ;
import cn.zying.osales.units.search.bean.StockReturnSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopStockReturnDetailService ;
import cn.zying.osales.web.aop.IAopStockReturnService ;

@Component("StockReturnDetailAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class StockReturnDetailAction extends OSalesSystemABAction<StockReturnDetail> {

    /**
     * 
     */
    private static final long serialVersionUID = -5279229564749454445L ;

    @Autowired
    @Qualifier(IAopStockReturnDetailService.name)
    private IAopStockReturnDetailService service ;

    @Autowired
    @Qualifier(IAopStockReturnService.name)
    private IAopStockReturnService returnService ;

    private StockReturnDetail stockreturndetail ;

    private StockReturnDetailSearchBean searchBean ;

    public String saveUpdate() throws Exception {
        try {
            BuildMoneyUnits.build(stockreturndetail) ;
            this.result = service.saveUpdate(optType, stockreturndetail) ;
            StockReturn stockReturn = returnService.get(this.result.getStockReturnId()) ;
            this.result.setStockReturn(stockReturn) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    //    public String update() throws Exception {
    //        //        try {
    //        //            stockorder.setRecordManId(getOSalsesLoginUserId()) ;
    //        //            this.result = service.saveUpdate(OptType.update, stockorder, getOSalsesLoginUserId()) ;
    //        //            writeObjectService.intToPrpertiesUnits(result) ;
    //        //        } catch (Exception e) {
    //        //            this.success = false ;
    //        //            this.msg = handError(e) ;
    //        //        }
    //        return SUCCESS ;
    //    }

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
            SelectPage<StockReturnDetail> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
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
            this.result = service.remove(OptType.delete, stockreturndetail) ;
            StockReturn stockReturn = returnService.get(this.result.getStockReturnId()) ;
            this.result.setStockReturn(stockReturn) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public StockReturnDetail getStockreturndetail() {
        return stockreturndetail ;
    }

    public void setStockreturndetail(StockReturnDetail stockreturndetail) {
        this.stockreturndetail = stockreturndetail ;
    }

    public StockReturnDetailSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(StockReturnDetailSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
