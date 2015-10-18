package cn.zying.osales.web.aop ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SysOptHistory ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.baseinfo.ISysOptHistoryService ;
import cn.zying.osales.units.search.bean.SysOptHistorySearchBean ;

@Component(IAopSysOptHistoryService.name)
public class AopSysOptHistoryService implements IAopSysOptHistoryService {

    @Autowired
    @Qualifier(ISysOptHistoryService.name)
    private ISysOptHistoryService iSysOptHistoryService ;

    public void saveUpdate(OptType optType, SysOptHistory optSysOptHistory) throws SystemOptServiceException {

        iSysOptHistoryService.saveUpdate(optType, optSysOptHistory) ;

    }

    public SelectPage<SysOptHistory> search(OptType optType, SysOptHistorySearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        return iSysOptHistoryService.search(optType, searchBean, commSearchBean, startLimit) ;

    }

    @Override
    public List<SysOptHistory> searchComb(String type, String name, int... startLimit) throws SystemOptServiceException {
        return iSysOptHistoryService.searchComb(type, name, startLimit) ;
    }

}
