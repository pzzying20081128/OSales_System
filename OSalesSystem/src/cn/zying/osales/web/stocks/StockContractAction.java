package cn.zying.osales.web.stocks ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockContract ;
import cn.zying.osales.units.search.bean.StockContractSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopStockContractService ;

@Component("StockContractAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class StockContractAction extends OSalesSystemABAction<StockContract> {

    /**
     * 
     */
    private static final long serialVersionUID = -5279229564749454445L ;

    @Autowired
    @Qualifier(IAopStockContractService.name)
    private IAopStockContractService service ;

    private StockContract stockcontract ;

    private StockContractSearchBean searchBean ;

    public String saveUpdate() throws Exception {
        try {
//            stockcontract.setRecordManId(getOSalsesLoginUserId()) ;
            this.result = service.saveUpdate(OptType.save, stockcontract) ;
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
            this.result = service.saveUpdate(OptType.update, stockcontract) ;
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
            SelectPage<StockContract> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
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
            this.result = service.remove(OptType.delete, stockcontract) ;
            writeObjectService.intToPrpertiesUnits(result) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public StockContract getStockcontract() {
        return stockcontract ;
    }

    public void setStockcontract(StockContract stockcontract) {
        this.stockcontract = stockcontract ;
    }

    public StockContractSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(StockContractSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

   
}
