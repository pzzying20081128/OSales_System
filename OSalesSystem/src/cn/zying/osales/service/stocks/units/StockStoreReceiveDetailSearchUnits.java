package cn.zying.osales.service.stocks.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockStoreReceiveDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockStoreReceiveDetailSearchBean ;

@Component("StockStoreReceiveDetailSearchUnits")
public class StockStoreReceiveDetailSearchUnits extends ABCommonsService {

    public SelectPage<StockStoreReceiveDetail> search(OptType optType, StockStoreReceiveDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<StockStoreReceiveDetail> selectPage = new SelectPage<StockStoreReceiveDetail>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockStoreReceiveDetail> result = list(sqlWhere, value, startLimit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<StockStoreReceiveDetail> list(OptType optType, StockStoreReceiveDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockStoreReceiveDetail> result = list(sqlWhere, value, startLimit) ;

        return result ;

    }

    private String sql = "select  stockStoreReceiveDetail   from  StockStoreReceiveDetail as  stockStoreReceiveDetail   " ;

    private List<StockStoreReceiveDetail> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere ;
        List<StockStoreReceiveDetail> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = " select  count(stockStoreReceiveDetail.id)   from  StockStoreReceiveDetail as  stockStoreReceiveDetail  " ;

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, StockStoreReceiveDetailSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = " where   stockStoreReceiveDetail.stockStoreReceiveId = " + searchBean.getStockStoreReceiveId() ;
        return sqlWhere ;
    }

}
