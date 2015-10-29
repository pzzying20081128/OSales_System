package cn.zying.osales.service.baseinfo ;

import java.util.List ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SysOptHistory ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.SysOptHistorySearchBean ;

public interface ISysOptHistoryService {

    public String name = "ISysOptHistoryService" ;

    /**
     *  增加或更新
     */
    public void saveUpdate(OptType optType, SysOptHistory optSysOptHistory) throws SystemOptServiceException ;

    public SelectPage<SysOptHistory> search(OptType optType, SysOptHistorySearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException ;

    public List<SysOptHistory> searchComb(String type, String name, int... startLimit) throws SystemOptServiceException ;
}
