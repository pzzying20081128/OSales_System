package cn.zying.osales.web.search ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;

import cn.zy.apps.tools.web.ABSearchAction ;
import cn.zying.osales.units.PrpertiesAutoWriteObjectService ;

public abstract class ABSalesSearchAction extends ABSearchAction {

    @Autowired
    @Qualifier("PrpertiesAutoWriteObjectService")
    protected PrpertiesAutoWriteObjectService writeObjectService ;

    protected Integer uuid ;

    public Integer getUuid() {
        return uuid ;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid ;
    }

}
