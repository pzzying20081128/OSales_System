package cn.zying.osales.web.bases;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.pojos.SysOptHistory ;
import cn.zying.osales.units.search.bean.SysOptHistorySearchBean ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopSysOptHistoryService ;


@Component("SysOptHistoryAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class SysOptHistoryAction extends OSalesSystemABAction {

    /**
     * 
     */
    private static final long serialVersionUID = -653939521179169869L ;

    @Autowired
    @Qualifier(IAopSysOptHistoryService.name)
    private IAopSysOptHistoryService  service ;
    
    private SysOptHistorySearchBean  searchBean;
    
    public String list() throws Exception {
        try {
            if(searchBean==null)searchBean=new SysOptHistorySearchBean();
            SelectPage<SysOptHistory> selectPage = service.search(optType, searchBean, commSearchBean, start, limit) ;
            this.setSelectPage(selectPage) ;
        } catch (Exception e) {
            this.success = false ;
            this.msg = handError(e) ;
        }
        return SUCCESS ;
    }

    public void setSearchBean(SysOptHistorySearchBean searchBean) {
        this.searchBean = searchBean ;
    }

    public SysOptHistorySearchBean getSearchBean() {
        return searchBean ;
    }
   
}
