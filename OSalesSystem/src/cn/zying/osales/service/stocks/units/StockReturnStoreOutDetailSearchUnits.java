package cn.zying.osales.service.stocks.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockReturnStoreOutDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockReturnStoreOutDetailSearchBean ;

@Component("StockReturnStoreOutDetailSearchUnits")
public class StockReturnStoreOutDetailSearchUnits extends ABCommonsService {

    public SelectPage<StockReturnStoreOutDetail> search(OptType optType, StockReturnStoreOutDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<StockReturnStoreOutDetail> selectPage = new SelectPage<StockReturnStoreOutDetail>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockReturnStoreOutDetail> result = list(sqlWhere, value, startLimit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<StockReturnStoreOutDetail> list(OptType optType, StockReturnStoreOutDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<StockReturnStoreOutDetail> selectPage = new SelectPage<StockReturnStoreOutDetail>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockReturnStoreOutDetail> result = list(sqlWhere, value, startLimit) ;

        return result ;

    }

    private String sql = "select stockReturnStoreOutDetail  from  StockReturnStoreOutDetail as  stockReturnStoreOutDetail   " ;

    private List<StockReturnStoreOutDetail> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere ;
        List<StockReturnStoreOutDetail> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = "select  count(stockReturnStoreOutDetail.id)  from  StockReturnStoreOutDetail as  stockReturnStoreOutDetail  " ;

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, StockReturnStoreOutDetailSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = " where  stockReturnStoreOutDetail.stockReturnStoreOutId =  " + searchBean.getStockReturnStoreOutId() ;
        return sqlWhere ;
    }

}
