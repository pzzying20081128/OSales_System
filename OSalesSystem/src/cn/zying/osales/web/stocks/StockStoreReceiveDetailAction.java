package cn.zying.osales.web.stocks ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInStore ;
import cn.zying.osales.pojos.StockStoreReceive ;
import cn.zying.osales.pojos.StockStoreReceiveDetail ;
import cn.zying.osales.units.search.bean.StockStoreReceiveDetailSearchBean ;
import cn.zying.osales.units.search.bean.StockStoreReceiveSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopStockInStoreService ;
import cn.zying.osales.web.aop.IAopStockStoreReceiveDetailService ;
import cn.zying.osales.web.aop.IAopStockStoreReceiveService ;

@Component("StockStoreReceiveDetailAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class StockStoreReceiveDetailAction extends OSalesSystemABAction<StockStoreReceiveDetail> {

    @Autowired
    @Qualifier(IAopStockStoreReceiveDetailService.name)
    private IAopStockStoreReceiveDetailService service ;

    private StockStoreReceiveDetail stockstorereceivedetail ;

    private StockStoreReceiveDetailSearchBean searchBean ;

    public String list() throws Exception {
        try {
            SelectPage<StockStoreReceiveDetail> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
            writeObjectService.intToPrpertiesUnits(selectPage) ;
            this.setSelectPage(selectPage) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public StockStoreReceiveDetail getStockstorereceivedetail() {
        return stockstorereceivedetail ;
    }

    public void setStockstorereceivedetail(StockStoreReceiveDetail stockstorereceivedetail) {
        this.stockstorereceivedetail = stockstorereceivedetail ;
    }

    public StockStoreReceiveDetailSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(StockStoreReceiveDetailSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
