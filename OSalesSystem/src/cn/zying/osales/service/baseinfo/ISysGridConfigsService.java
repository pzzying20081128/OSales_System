package cn.zying.osales.service.baseinfo ;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SysGridConfigs ;
import cn.zying.osales.service.SystemOptServiceException ;

public interface ISysGridConfigsService {

    public String name = "ISysGridConfigsService" ;

    public void addUpdate(String module_key, List<SysGridConfigs> sysGridConfig) throws SystemOptServiceException ;

    public List<SysGridConfigs> search(String name, int... startSize) throws SystemOptServiceException ;

    public SelectPage<SysGridConfigs> search(String moduleKey,CommSearchBean commSearchBean) throws SystemOptServiceException ;

    public SysGridConfigs saveUpdate(OptType optype, SysGridConfigs sysGridConfigs) throws SystemOptServiceException ;

    public SysGridConfigs get(Integer id) throws SystemOptServiceException ;
}
