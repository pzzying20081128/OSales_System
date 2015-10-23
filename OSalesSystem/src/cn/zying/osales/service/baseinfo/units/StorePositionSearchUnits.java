package cn.zying.osales.service.baseinfo.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.StorePosition ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StorePositionSearchBean ;

@Component("StorePositionSearchUnits")
public class StorePositionSearchUnits extends ABCommonsService {

    public SelectPage<StorePosition> search(OptType optType, StorePositionSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<StorePosition> selectPage = new SelectPage<StorePosition>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StorePosition> result = list(sqlWhere, value, startLimit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<StorePosition> list(OptType optType, StorePositionSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StorePosition> result = list(sqlWhere, value, startLimit) ;

        return result ;

    }

    private String sql = "select  storePosition   from  StorePosition as  storePosition " ;

    private List<StorePosition> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere ;
        List<StorePosition> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = "select  count(storePosition.id)   from  StorePosition as  storePosition " ;

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, StorePositionSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = " where  1=1 " ;
        if (searchBean.getStoreInfoId() != null) {
            sqlWhere = sqlWhere + " and   storePosition.storeInfoId  = " + searchBean.getStoreInfoId() ;
        } else {
        }

        if (searchBean.getStatus() != null && !searchBean.getStatus().equals(Status.全部)) {
            sqlWhere = sqlWhere + "  and  storePosition.status ='" + searchBean.getStatus() + "'   " ;
        }
        if (ToolsUnits.isNOtNulll(searchBean.getName())) {
            sqlWhere = sqlWhere + "  and  storePosition.name like '%" + searchBean.getName() + "%'   " ;
        }
        return sqlWhere ;
    }

}
