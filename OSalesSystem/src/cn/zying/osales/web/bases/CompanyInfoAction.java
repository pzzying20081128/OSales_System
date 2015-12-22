package cn.zying.osales.web.bases ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.CompanyInfo ;
import cn.zying.osales.units.search.bean.CompanyInfoSearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopCompanyInfoService ;

@Component("CompanyInfoAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class CompanyInfoAction extends OSalesSystemABAction<CompanyInfo> {

    private static final long serialVersionUID = 5097422831159826456L ;

    @Autowired
    @Qualifier(IAopCompanyInfoService.name)
    private IAopCompanyInfoService service ;

    private CompanyInfo companyinfo ;

    private CompanyInfoSearchBean searchBean ;

    public String save() throws Exception {
        try {
            this.result = service.saveUpdate(optType, companyinfo) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String remove() throws Exception {
        try {
            this.result = service.remove(optType, companyinfo) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String get() throws Exception {
        try {
            this.result = service.get(uuid) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public String list() throws Exception {
        try {
            SelectPage<CompanyInfo> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
            writeObjectService.intToPrpertiesUnits(selectPage) ;
            this.setSelectPage(selectPage) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }

        return SUCCESS ;
    }

    public CompanyInfo getCompanyinfo() {
        return companyinfo ;
    }

    public void setCompanyinfo(CompanyInfo companyinfo) {
        this.companyinfo = companyinfo ;
    }

    public CompanyInfoSearchBean getSearchBean() {
        return searchBean ;
    }

    public void setSearchBean(CompanyInfoSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
