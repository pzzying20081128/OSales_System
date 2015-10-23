package cn.zying.osales.service.baseinfo.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.StoreInfo ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StoreInfoSearchBean ;

@Component("StoreInfoSearchUnits")
public class StoreInfoSearchUnits extends ABCommonsService {

    public SelectPage<StoreInfo> search(OptType optType, StoreInfoSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<StoreInfo> selectPage = new SelectPage<StoreInfo>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StoreInfo> result = list(sqlWhere, value, startLimit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<StoreInfo> list(OptType optType, StoreInfoSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<StoreInfo> selectPage = new SelectPage<StoreInfo>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StoreInfo> result = list(sqlWhere, value, startLimit) ;

        return result ;

    }

    private String sql = "select  storeInfo from  StoreInfo as  storeInfo       " ;

    private List<StoreInfo> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere ;
        List<StoreInfo> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = "select  count(storeInfo.id) from  StoreInfo as  storeInfo       " ;

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, StoreInfoSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = "  where  1=1 " ;
        if (ToolsUnits.isNOtNulll(searchBean.getName())) {
            sqlWhere = sqlWhere + "   and   storeInfo.name like '%" + searchBean.getName() + "%'  " ;
        }
        if (ToolsUnits.isNOtNulll(searchBean.getPhone())) {
            sqlWhere = sqlWhere + "   and   storeInfo.phone like '%" + searchBean.getPhone() + "%'  " ;
        }
        if (ToolsUnits.isNOtNulll(searchBean.getText())) {
            sqlWhere = sqlWhere + "   and   storeInfo.text like '%" + searchBean.getText() + "%'  " ;
        }
        if (ToolsUnits.isNOtNulll(searchBean.getAddress())) {
            sqlWhere = sqlWhere + "   and   storeInfo.address like '%" + searchBean.getAddress() + "%'  " ;
        }
        if (searchBean.getStatus() != null && !searchBean.getStatus().equals(Status.全部)) {
            sqlWhere = sqlWhere + "   and   storeInfo.status = '" + searchBean.getStatus() + "'  " ;
        }
        return sqlWhere ;
    }

}
