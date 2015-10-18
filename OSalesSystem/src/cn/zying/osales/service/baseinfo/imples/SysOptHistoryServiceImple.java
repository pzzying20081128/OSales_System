package cn.zying.osales.service.baseinfo.imples ;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SysOptHistory ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.service.baseinfo.ISysOptHistoryService ;
import cn.zying.osales.service.baseinfo.units.SysOptHistorySaveUpdateUnits ;
import cn.zying.osales.service.baseinfo.units.SysOptHistorySearchUnits ;
import cn.zying.osales.units.search.bean.SysOptHistorySearchBean ;

@Component(ISysOptHistoryService.name)
public class SysOptHistoryServiceImple extends ABCommonsService implements ISysOptHistoryService {

    //@Resource(name="SysOptHistorySearchUnits")
    @Autowired
    @Qualifier("SysOptHistorySearchUnits")
    private SysOptHistorySearchUnits iSysOptHistorySearchUnits ;

    @Autowired
    @Qualifier("SysOptHistorySaveUpdateUnits")
    private SysOptHistorySaveUpdateUnits sysOptHistorySaveUpdateUnits ;

    @Override
    public SelectPage<SysOptHistory> search(OptType optType, SysOptHistorySearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        return iSysOptHistorySearchUnits.search(optType, searchBean, commSearchBean, startLimit) ;
    }

    @Override
    public void saveUpdate(OptType optType, SysOptHistory optSysOptHistory) throws SystemOptServiceException {
        sysOptHistorySaveUpdateUnits.saveUpdate(optType, optSysOptHistory) ;
    }

    @Override
    public List<SysOptHistory> searchComb(String type, String name, int... startLimit) throws SystemOptServiceException {

        switch (type) {
        case "classification": {
            String sql = "select  sysOptHistory  from  SysOptHistory as  sysOptHistory  where sysOptHistory.classification like '%"

            + (ToolsUnits.isNOtNulll(name) ? name : "") + "%'   " ;

            return baseService.findByHSQL(sql, startLimit) ;

        }
        case "module": {
            String sql = "select  sysOptHistory  from  SysOptHistory as  sysOptHistory  where sysOptHistory.module like '%"

            + (ToolsUnits.isNOtNulll(name) ? name : "") + "%'   " ;

            return baseService.findByHSQL(sql, startLimit) ;
        }
        default:
            throw new SystemOptServiceException("type error ") ;
        }

    }
}
