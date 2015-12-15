package cn.zying.osales.service.stocks.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockReturnDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockReturnDetailSearchBean ;

@Component("StockReturnDetailSearchUnits")
public class StockReturnDetailSearchUnits extends ABCommonsService {

    public SelectPage<StockReturnDetail> search(OptType optType, StockReturnDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<StockReturnDetail> selectPage = new SelectPage<StockReturnDetail>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockReturnDetail> result = list(sqlWhere, value, startLimit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<StockReturnDetail> list(OptType optType, StockReturnDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockReturnDetail> result = list(sqlWhere, value, startLimit) ;

        return result ;

    }

    private String sql = " select  stockReturnDetail  from  StockReturnDetail as  stockReturnDetail   " ;

    private List<StockReturnDetail> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere ;
        List<StockReturnDetail> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = " select  count(stockReturnDetail.id)  from  StockReturnDetail as  stockReturnDetail  " ;

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, StockReturnDetailSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = "    where  stockReturnDetail.stockReturnId = " + searchBean.getStockReturnId() ;
        return sqlWhere ;
    }

}
