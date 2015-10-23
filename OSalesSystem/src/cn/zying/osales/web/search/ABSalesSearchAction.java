package cn.zying.osales.web.search;

import cn.zy.apps.tools.web.ABSearchAction ;

public abstract  class ABSalesSearchAction extends ABSearchAction {

    protected  Integer  uuid;

    public Integer getUuid() {
        return uuid ;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid ;
    }
    
    

}
