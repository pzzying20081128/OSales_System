package cn.zying.osales.web.search ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SearchUserPowerAction ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.ProviderInfo ;
import cn.zying.osales.units.search.bean.ProviderInfoSearchBean ;
import cn.zying.osales.web.aop.IAopProviderInfoService ;

@Component("ProviderInfoSearchAction")
@org.springframework.context.annotation.Scope(SearchUserPowerAction.Scope)
public class ProviderInfoSearchAction extends ABSalesSearchAction {

    @Autowired
    @Qualifier(IAopProviderInfoService.name)
    private IAopProviderInfoService service ;

    private ProviderInfoSearchBean searchBean ;

    @Override
    protected List<ProviderInfo> searchResult() throws Exception {
        try {
            searchBean.setName(name) ;
            List<ProviderInfo> results = service.searchList(OptType.search, searchBean, null, 0, 20) ;
            if (searchBean.getId() != null) {
                for (ProviderInfo result : results) {
                    if (result.getId().equals(searchBean.getId())) return results ;
                }
                ProviderInfo providerInfo = service.get(searchBean.getId()) ;
                results.add(0, providerInfo) ;
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

    public void setSearchBean(ProviderInfoSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
