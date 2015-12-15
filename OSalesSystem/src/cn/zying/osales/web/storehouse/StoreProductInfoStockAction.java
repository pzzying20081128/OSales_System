package cn.zying.osales.web.storehouse ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.StoreProductInfoDetail ;
import cn.zying.osales.pojos.StoreProductInfoStock ;
import cn.zying.osales.units.search.bean.StoreProductInfoStockSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopStoreProductInfoStockService ;

@Component("StoreProductInfoStockAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class StoreProductInfoStockAction extends OSalesSystemABAction<StoreProductInfoStock> {

    @Autowired
    @Qualifier(IAopStoreProductInfoStockService.name)
    private IAopStoreProductInfoStockService service ;

    private StoreProductInfoStock storeproductinfostock ;

    private StoreProductInfoStockSearchBean searchBean ;

    private SelectPage<StoreProductInfoDetail> selectDetailPage ;

    public String list() throws Exception {
        try {
            start = (start == null ? 0 : start) ;
            limit = (limit == null ? 40 : limit) ;
            SelectPage<StoreProductInfoStock> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
            writeObjectService.intToPrpertiesUnits(selectPage) ;
            this.setSelectPage(selectPage) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String listDetail() throws Exception {
        try {

            selectDetailPage = service.searchDetail(uuid) ;
            writeObjectService.intToPrpertiesUnits(selectDetailPage) ;

        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public StoreProductInfoStockSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(StoreProductInfoStockSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

    public SelectPage<StoreProductInfoDetail> getSelectDetailPage() {
        return selectDetailPage ;
    }

    public void setSelectDetailPage(SelectPage<StoreProductInfoDetail> selectDetailPage) {
        this.selectDetailPage = selectDetailPage ;
    }

}
