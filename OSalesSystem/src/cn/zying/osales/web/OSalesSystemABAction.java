package cn.zying.osales.web ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.GeneralAction ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.service.IABService ;
import cn.zying.osales.units.PrpertiesAutoWriteObjectService ;

public abstract class OSalesSystemABAction<V> extends GeneralAction implements IOSalesSystemABAction {

    private static final long serialVersionUID = -2062527978326655709L ;

    @Autowired
    @Qualifier("PrpertiesAutoWriteObjectService")
    protected PrpertiesAutoWriteObjectService writeObjectService ;

    @Autowired
    @Qualifier(IABService.name)
    protected IABService baseService ;

    private SelectPage<V> selectPage ;

    protected OptType optType ;

    protected CommSearchBean commSearchBean ;

    protected Integer uuid ;

    protected V result ; ;

    public Integer getOSalsesLoginUserId() {
        Integer userId = Integer.parseInt(getLoginUserId()) ;
        return userId ;

    }

    public void setCommSearchBean(CommSearchBean commSearchBean) {
        this.commSearchBean = commSearchBean ;
    }

    public void setOptType(OptType optType) {
        this.optType = optType ;
    }

    public Integer getUuid() {
        return uuid ;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid ;
    }

    public SelectPage<V> getSelectPage() {
        return selectPage ;
    }

    public void setSelectPage(SelectPage<V> selectPage) {
        this.selectPage = selectPage ;
    }

    public V getResult() {
        return result ;
    }

    public void setResult(V result) {
        this.result = result ;
    }

    public OptType getOptType() {
        return optType ;
    }

    public CommSearchBean getCommSearchBean() {
        return commSearchBean ;
    }

}
