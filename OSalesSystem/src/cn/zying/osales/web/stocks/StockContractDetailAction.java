package cn.zying.osales.web.stocks ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockContract ;
import cn.zying.osales.pojos.StockContractDetail ;
import cn.zying.osales.units.BuildMoneyUnits ;
import cn.zying.osales.units.search.bean.StockContractDetailSearchBean ;
import cn.zying.osales.units.search.bean.StockContractSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopStockContractDetailService ;
import cn.zying.osales.web.aop.IAopStockContractService ;

@Component("StockContractDetailAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class StockContractDetailAction extends OSalesSystemABAction<StockContractDetail> {

    /**
     * 
     */
    private static final long serialVersionUID = -5279229564749454445L ;

    @Autowired
    @Qualifier(IAopStockContractDetailService.name)
    private IAopStockContractDetailService service ;

    private StockContractDetail   stockcontractdetail ;

    private StockContractDetailSearchBean searchBean ;

    public String saveUpdate() throws Exception {
        try {
            //            stockcontract.setRecordManId(getOSalsesLoginUserId()) ;
            BuildMoneyUnits.build(stockcontractdetail);
            this.result = service.saveUpdate(optType, stockcontractdetail) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public String check() throws Exception {
        try {
            //            service.check(stockcontract.getId(), getOSalsesLoginUserId()) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public String update() throws Exception {
        try {
            //            stockorder.setRecordManId(getOSalsesLoginUserId()) ;
            this.result = service.saveUpdate(OptType.update, stockcontractdetail) ;
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
            SelectPage<StockContractDetail> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
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
            this.result = service.remove(OptType.delete, stockcontractdetail) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public StockContractDetail getStockcontractdetail() {
        return stockcontractdetail ;
    }

    public void setStockcontractdetail(StockContractDetail stockcontractdetail) {
        this.stockcontractdetail = stockcontractdetail ;
    }

    public StockContractDetailSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(StockContractDetailSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

   

}
