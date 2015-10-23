package cn.zying.osales.web.search ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SearchUserPowerAction ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StorePosition ;
import cn.zying.osales.units.search.bean.StorePositionSearchBean ;
import cn.zying.osales.web.aop.IAopStorePositionService ;

@Component("StorePositionSearchAction")
@org.springframework.context.annotation.Scope(SearchUserPowerAction.Scope)
public class StorePositionSearchAction extends ABSalesSearchAction {

  
    private static final long serialVersionUID = 6608488468321414319L ;

    @Autowired
    @Qualifier(IAopStorePositionService.name)
    private IAopStorePositionService service ;

    private StorePositionSearchBean searchBean ;

    @Override
    protected List<StorePosition> searchResult() throws Exception {
        try {
            List<StorePosition>  results =   service.searchList(OptType.search, searchBean, null, 0, 20) ;
        
        if (searchBean.getId() != null) {
            for (StorePosition result : results) {
                if (result.getId().equals(searchBean.getId())) return results ;
            }
            StorePosition res = service.get(searchBean.getId()) ;
            results.add(0, res) ;
            return results ;
        } else {
            return results ;
        }
        
    } catch (Exception e) {
        this.msg = handError(e) ;
        this.success = false ;
        return null;
    }
   

    }

    public void setSearchBean(StorePositionSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
