package cn.zying.osales.web.search ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.ABSearchAction ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.units.search.bean.SystemUserSearchBean ;
import cn.zying.osales.web.aop.IAopSystemUserService ;

@Component("SysStaffSearchAction")
public class SysStaffSearchAction extends ABSearchAction {
    
    private static final long serialVersionUID = -3839042551020091082L ;

    private SystemUserSearchBean searchBean ;
    
    @Autowired
    @Qualifier(IAopSystemUserService.aop_name)
    private IAopSystemUserService service;

    @SuppressWarnings("unchecked")
    @Override
    protected  List<SysStaffUser> searchResult() throws Exception {
        searchBean.setName(name);
         List<SysStaffUser>  sysStaffUsers =service.searchList(OptType.search, searchBean, null, 0,20);
        return sysStaffUsers ;
    }

    public void setSearchBean(SystemUserSearchBean searchBean) {
        this.searchBean = searchBean ;
    }

}
