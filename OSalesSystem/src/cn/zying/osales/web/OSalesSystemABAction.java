package cn.zying.osales.web ;

import cn.zy.apps.tools.web.GeneralAction ;
import cn.zying.osales.pojos.SysStaffUser ;

public abstract class OSalesSystemABAction extends GeneralAction implements IOSalesSystemABAction {

    private static final long serialVersionUID = -2062527978326655709L ;
    


    public Integer getOSalsesLoginUserId() {
        Integer userId = Integer.parseInt(getLoginUserId()) ;
        return userId ;

    }

    

}
