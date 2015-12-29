package cn.zying.osales.service.stocks.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockPaymentDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockPaymentDetailSearchBean ;

@Component("StockPaymentDetailSearchUnits")
public class StockPaymentDetailSearchUnits extends ABCommonsService {

    public SelectPage<StockPaymentDetail> searchPaymentDetail(OptType optType, StockPaymentDetailSearchBean searchBean, CommSearchBean commSearchBean, Integer start, Integer limit) throws SystemOptServiceException {

        SelectPage<StockPaymentDetail> selectPage = new SelectPage<StockPaymentDetail>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockPaymentDetail> result = list(sqlWhere, value, start, limit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<StockPaymentDetail> list(OptType optType, StockPaymentDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockPaymentDetail> result = list(sqlWhere, value, startLimit) ;

        return result ;

    }

    private String sql = "select  stockPaymentDetail   from  StockPaymentDetail as  stockPaymentDetail   " ;

    private List<StockPaymentDetail> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere ;
        List<StockPaymentDetail> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = "select  count(stockPaymentDetail.id)   from  StockPaymentDetail as  stockPaymentDetail " ;

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, StockPaymentDetailSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = " where  stockPaymentDetail.stockPaymentId =  " + searchBean.getStockPaymentId() ;

        return sqlWhere ;
    }

}
