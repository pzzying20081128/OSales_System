package cn.zying.osales.service.baseinfo.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.CompanyInfo ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.OSToolsUnits ;
import cn.zying.osales.units.search.bean.CompanyInfoSearchBean ;

@Component("CompanyInfoSearchUnits")
public class CompanyInfoSearchUnits extends ABCommonsService {

    public SelectPage<CompanyInfo> search(OptType optType, CompanyInfoSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<CompanyInfo> selectPage = new SelectPage<CompanyInfo>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<CompanyInfo> result = list(sqlWhere, value, startLimit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<CompanyInfo> list(OptType optType, CompanyInfoSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<CompanyInfo> result = list(sqlWhere, value, startLimit) ;

        return result ;

    }

    private String sql = "select companyInfo   from  CompanyInfo  as  companyInfo  " ;

    private List<CompanyInfo> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere ;
        List<CompanyInfo> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = "select    count(companyInfo.id)  from  CompanyInfo  as  companyInfo  " ;

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, CompanyInfoSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = " where  1=1 " ;
        if (!OSToolsUnits.listIsNull(searchBean.getStatuses())) {
            sqlWhere = sqlWhere + " and  companyInfo.status in (:statuses) " ;
            value.put("statuses", searchBean.getStatuses()) ;
        }

        if (searchBean.getStatus() != null && ! searchBean.getStatus().equals(Status.全部) ) {
            sqlWhere = sqlWhere + " and  companyInfo.status = (:status) " ;
            value.put("status", searchBean.getStatus()) ;
        }
        return sqlWhere ;
    }

}
