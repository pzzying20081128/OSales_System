package cn.zying.osales.web ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.GeneralAction ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SysStaffUser ;

public abstract class OSalesSystemABAction extends GeneralAction implements IOSalesSystemABAction {

    private static final long serialVersionUID = -2062527978326655709L ;

    private SelectPage<?> selectPage ;

    protected OptType opttype ;

    protected CommSearchBean commSearchBean ;

    public Integer getOSalsesLoginUserId() {
        Integer userId = Integer.parseInt(getLoginUserId()) ;
        return userId ;

    }

    public SelectPage<?> getSelectPage() {
        return selectPage ;
    }

    protected void setSelectPage(SelectPage<?> selectPage) {
        this.selectPage = selectPage ;
    }

    public void setOpttype(OptType opttype) {
        this.opttype = opttype ;
    }

    public void setCommSearchBean(CommSearchBean commSearchBean) {
        this.commSearchBean = commSearchBean ;
    }

}
