package cn.zying.osales.service.baseinfo.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.logger.Loggerfactory ;
import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.DateToolsUilts ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.SysOptHistory ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.SysOptHistorySearchBean ;

@Component("SysOptHistorySearchUnits")
public class SysOptHistorySearchUnits extends ABCommonsService {

    public SelectPage<SysOptHistory> search(OptType optType, SysOptHistorySearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<SysOptHistory> selectPage = new SelectPage<SysOptHistory>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<SysOptHistory> result = list(sqlWhere, value, startLimit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    private String sql = "select  sysOptHistory  from SysOptHistory as sysOptHistory  " ;

    private List<SysOptHistory> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere + "   order by  sysOptHistory.optTime  desc  " ;
        Loggerfactory.print(sql_) ;
        List<SysOptHistory> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = "select  count(sysOptHistory.id)  from SysOptHistory as sysOptHistory  " ;

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    //sysOptHistory
    private String createWhere(Map<String, Object> value, SysOptHistorySearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = " where 1=1 " ;
        if (ToolsUnits.isNOtNulll(searchBean.getClassification())) {
            sqlWhere = sqlWhere + "  and    sysOptHistory.classification ='" + searchBean.getClassification() + "' " ;
        }
        if (ToolsUnits.isNOtNulll(searchBean.getModule())) {
            sqlWhere = sqlWhere + "  and    sysOptHistory.module ='" + searchBean.getModule() + "' " ;
        }
        if (searchBean.getStartTime() != null) {
            sqlWhere = sqlWhere + "  and    sysOptHistory.optTime >= '" + DateToolsUilts.dateToString(searchBean.getStartTime(), "yyyy-MM-dd") + " 00:00:00'" ;
            //            value.put("optTime", searchBean.getOptTime()) ;
        }
        if (searchBean.getEndTime() != null) {
            sqlWhere = sqlWhere + "  and    sysOptHistory.optTime <= '" + DateToolsUilts.dateToString(searchBean.getEndTime(), "yyyy-MM-dd") + " 23:59:59'" ;
            //            value.put("optTime", searchBean.getOptTime()) ;
        }

        if (searchBean.getSysStaffUserId() != null) {
            sqlWhere = sqlWhere + "  and    sysOptHistory.sysStaffUserId = " + searchBean.getSysStaffUserId() ;
        }

        if (searchBean.getText() != null) {
            sqlWhere = sqlWhere + "  and    sysOptHistory.text  like '%" + searchBean.getText() + "%'" ;
        }

        return sqlWhere ;
    }

}
