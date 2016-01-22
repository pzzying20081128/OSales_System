package cn.zying.osales.infaces ;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SystemConfigs ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.SystemConfigsSearchBean ;

public interface InfaceSystemConfigsService {

    /**
          *  增加或更新
          */
    public SystemConfigs saveUpdate(OptType optType, SystemConfigs optSystemConfigs) throws SystemOptServiceException ;

    public SelectPage<SystemConfigs> search(OptType optType, SystemConfigsSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public List<SystemConfigs> searchList(OptType optType, SystemConfigsSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    //    public SystemConfigs remove(OptType optType, SystemConfigs optSystemConfigs) throws SystemOptServiceException ;

    public SystemConfigs get(Integer id) throws SystemOptServiceException ;

}
