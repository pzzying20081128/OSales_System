package cn.zying.osales.service.stocks.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockOrderDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockOrderDetailSearchBean ;

@Component("StockOrderDetailSearchUnits")
public class StockOrderDetailSearchUnits extends ABCommonsService {

    public SelectPage<StockOrderDetail> search(OptType optType, StockOrderDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<StockOrderDetail> selectPage = new SelectPage<StockOrderDetail>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockOrderDetail> result = list(sqlWhere, value, startLimit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<StockOrderDetail> list(OptType optType, StockOrderDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockOrderDetail> result = list(sqlWhere, value, startLimit) ;

        return result ;

    }

    private String sql = "  select  stockOrderDetail    from     StockOrderDetail as stockOrderDetail  " ;

    private List<StockOrderDetail> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere ;
        List<StockOrderDetail> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = "select  count(stockOrderDetail.id)    from     StockOrderDetail as stockOrderDetail  " ;

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, StockOrderDetailSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = " where  stockOrderDetail.stockOrderId = " + searchBean.getStockOrderId() ;
        return sqlWhere ;
    }

}
