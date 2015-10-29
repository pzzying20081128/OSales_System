package cn.zying.osales.service.stocks.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.StockOrder ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockOrderSearchBean ;

@Component("StockOrderSearchUnits")
public class StockOrderSearchUnits extends ABCommonsService {

    public SelectPage<StockOrder> search(OptType optType, StockOrderSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<StockOrder> selectPage = new SelectPage<StockOrder>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockOrder> result = list(sqlWhere, value, startLimit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<StockOrder> list(OptType optType, StockOrderSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<StockOrder> selectPage = new SelectPage<StockOrder>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockOrder> result = list(sqlWhere, value, startLimit) ;

        return result ;

    }

    private String sql = "select  stockOrder  from  StockOrder as  stockOrder " ;

    private List<StockOrder> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere ;
        List<StockOrder> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = "select  count(stockOrder.id)  from  StockOrder as  stockOrder                " ;

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, StockOrderSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = " where  1 = 1 " ;
        if (searchBean.getStatus() == null || !searchBean.getStatus().equals(Status.全部)) {
            sqlWhere = sqlWhere + "  and  stockOrder.status  ='" + searchBean.getStatus() + "'  " ;
        }

        return sqlWhere ;
    }

}
