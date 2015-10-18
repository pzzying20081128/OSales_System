package cn.zying.osales.web.search ;

import java.util.ArrayList ;
import java.util.List ;
import java.util.Map ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.ABSearchAction ;
import cn.zying.osales.pojos.SysOptHistory ;
import cn.zying.osales.units.search.bean.CombSearchBean ;
import cn.zying.osales.web.aop.IAopSysOptHistoryService ;

@Component("SysOptHistoryClassificationModuleSearchAction")
public class SysOptHistoryClassificationModuleSearchAction extends ABSearchAction {

    @Autowired
    @Qualifier(IAopSysOptHistoryService.name)
    private IAopSysOptHistoryService service ;

    private String type ;

    @Override
    protected List<CombSearchBean> searchResult() throws Exception {
        List<SysOptHistory> result = service.searchComb(type, name, 0, 20) ;
        List<CombSearchBean> combSearchBeans = new ArrayList<CombSearchBean>() ;
        for (SysOptHistory sysOptHistory : result) {
            CombSearchBean combSearchBean = new CombSearchBean() ;
            combSearchBeans.add(combSearchBean) ;
            switch (type) {
            case "classification": {
                combSearchBean.setId(sysOptHistory.getClassification()) ;
                combSearchBean.setName(sysOptHistory.getClassification()) ;
                break ;
            }
            case "module": {
                combSearchBean.setId(sysOptHistory.getModule()) ;
                combSearchBean.setName(sysOptHistory.getModule()) ;
                break ;
            }

            }

        }
        return combSearchBeans ;
    }

    public String getType() {
        return type ;
    }

    public void setType(String type) {
        this.type = type ;
    }

}
