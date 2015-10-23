package cn.zying.osales.web.search ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SearchUserPowerAction ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.units.search.bean.SystemUserSearchBean ;
import cn.zying.osales.web.aop.IAopSystemUserService ;

@Component("SysStaffSearchAction")
@org.springframework.context.annotation.Scope(SearchUserPowerAction.Scope)
public class SysStaffSearchAction extends ABSalesSearchAction {

    private static final long serialVersionUID = -3839042551020091082L ;

    private SystemUserSearchBean searchBean ;

    @Autowired
    @Qualifier(IAopSystemUserService.aop_name)
    private IAopSystemUserService service ;

    @SuppressWarnings("unchecked")
    @Override
    protected List<SysStaffUser> searchResult() throws Exception {
        try {
            searchBean.setName(name) ;
            List<SysStaffUser> sysStaffUsers = service.searchList(OptType.search, searchBean, null, 0, 20) ;
            if (searchBean.getId() != null) {
                for (SysStaffUser result : sysStaffUsers) {
                    if (result.getId().equals(searchBean.getId())) return sysStaffUsers ;
                }
                SysStaffUser sysStaffUser = service.get(searchBean.getId()) ;
                sysStaffUsers.add(0, sysStaffUser) ;
                return sysStaffUsers ;
            } else {
                return sysStaffUsers ;
            }

        } catch (Exception e) {
            this.msg = handError(e) ;
            this.success = false ;
            return null ;
        }

    }

    public void setSearchBean(SystemUserSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
