package cn.zying.osales.web.search ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SearchUserPowerAction ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.CompanyInfo ;
import cn.zying.osales.service.baseinfo.ICompanyInfoService ;
import cn.zying.osales.units.search.bean.CompanyInfoSearchBean ;

@Component("CompanyInfoSearchAction")
@org.springframework.context.annotation.Scope(SearchUserPowerAction.Scope)
public class CompanyInfoSearchAction extends ABSalesSearchAction {

    private static final long serialVersionUID = 5133365354050393220L ;

    @Autowired
    @Qualifier(ICompanyInfoService.name)
    private ICompanyInfoService iCompanyInfoService ;

    private CompanyInfoSearchBean searchBean ;

    @Override
    protected List<CompanyInfo> searchResult() throws Exception {
        try {
            searchBean.setName(name) ;
            List<CompanyInfo> result = iCompanyInfoService.searchList(OptType.search, searchBean, null, 0, 20) ;
            return result ;
        } catch (Exception e) {
            this.msg = handError(e) ;
            this.success = false ;
            return null ;
        }
    }

    public CompanyInfoSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(CompanyInfoSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
