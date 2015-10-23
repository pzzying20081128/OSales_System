package cn.zying.osales.web.search ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SearchUserPowerAction ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StoreInfo ;
import cn.zying.osales.units.search.bean.StoreInfoSearchBean ;
import cn.zying.osales.web.aop.IAopStoreInfoService ;

@Component("StoreInfoSearchAction")
@org.springframework.context.annotation.Scope(SearchUserPowerAction.Scope)
public class StoreInfoSearchAction extends ABSalesSearchAction {

    private static final long serialVersionUID = -5984497329454113843L ;

    @Autowired
    @Qualifier(IAopStoreInfoService.name)
    private IAopStoreInfoService service ;

    private StoreInfoSearchBean searchBean ;

    @Override
    protected List<StoreInfo> searchResult() throws Exception {
        try {
            List<StoreInfo> results = service.searchList(OptType.search, searchBean, null, 0, 20) ;
            if (searchBean.getId() != null) {
                for (StoreInfo result : results) {
                    if (result.getId().equals(searchBean.getId())) return results ;
                }
                StoreInfo res = service.get(searchBean.getId()) ;
                results.add(0, res) ;
                return results ;
            } else {
                return results ;
            }

        } catch (Exception e) {
            this.msg = handError(e) ;
            this.success = false ;
            return null ;
        }

    }

    public StoreInfoSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(StoreInfoSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
