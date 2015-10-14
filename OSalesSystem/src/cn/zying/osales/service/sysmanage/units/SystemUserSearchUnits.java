package cn.zying.osales.service.sysmanage.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;

@Component("SystemUserSearchUnits")
public class SystemUserSearchUnits extends ABCommonsService {

    private String sql = "select  sysStaffUser  from  SysStaffUser as  sysStaffUser  " ;

    private String sqlsum = "select  count(sysStaffUser.id)  from  SysStaffUser as  sysStaffUser" ;

    public SelectPage<SysStaffUser> search(OptType optType, SystemUserSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<SysStaffUser> selectPage = new SelectPage<SysStaffUser>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<SysStaffUser> result = list(sqlWhere, value, startLimit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    private List<SysStaffUser> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere ;
        List<SysStaffUser> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, SystemUserSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = "" ;
        return sqlWhere ;
    }

}
