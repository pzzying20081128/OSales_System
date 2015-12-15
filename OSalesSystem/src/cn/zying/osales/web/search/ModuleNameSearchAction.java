package cn.zying.osales.web.search ;

import java.util.ArrayList ;
import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SearchUserPowerAction ;
import cn.zying.osales.pojos.SysGridConfigs ;
import cn.zying.osales.service.baseinfo.ISysGridConfigsService ;
import cn.zying.osales.units.search.bean.CombSearchBean ;

@Component("ModuleNameSearchAction")
@org.springframework.context.annotation.Scope(SearchUserPowerAction.Scope)
public class ModuleNameSearchAction extends ABSalesSearchAction {

    @Autowired
    @Qualifier(ISysGridConfigsService.name)
    private ISysGridConfigsService sysGridConfigsService ;

    @Override
    protected List<CombSearchBean> searchResult() throws Exception {
        List<SysGridConfigs> results = sysGridConfigsService.search(name, 0, 20) ;

        List<CombSearchBean> lists = new ArrayList<CombSearchBean>() ;

        for (SysGridConfigs result : results) {
            CombSearchBean combSearchBean = new CombSearchBean() ;
            lists.add(combSearchBean) ;
            combSearchBean.setId(result.getModuleKey()) ;
            combSearchBean.setName(result.getModuleName()) ;

        }
        return lists ;
    }

}
