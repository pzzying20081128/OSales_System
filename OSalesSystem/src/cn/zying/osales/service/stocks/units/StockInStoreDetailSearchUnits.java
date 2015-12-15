package cn.zying.osales.service.stocks.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInStoreDetail ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockInStoreDetailSearchBean ;

@Component("StockInStoreDetailSearchUnits")
public class StockInStoreDetailSearchUnits extends ABCommonsService {

    public SelectPage<StockInStoreDetail> search(OptType optType, StockInStoreDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<StockInStoreDetail> selectPage = new SelectPage<StockInStoreDetail>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockInStoreDetail> result = list(sqlWhere, value, startLimit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<StockInStoreDetail> list(OptType optType, StockInStoreDetailSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockInStoreDetail> result = list(sqlWhere, value, startLimit) ;

        return result ;

    }

    private String sql = "   select  stockInStoreDetail    from   StockInStoreDetail  as  stockInStoreDetail  " ;

    private List<StockInStoreDetail> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere ;
        List<StockInStoreDetail> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = " select  count(stockInStoreDetail.id)   from   StockInStoreDetail  as  stockInStoreDetail  " ;

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, StockInStoreDetailSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = "  where  stockInStoreDetail.stockInStoreId = " + searchBean.getStockInStoreId() ;
        if (searchBean.getProductInfoIds() != null && searchBean.getProductInfoIds().size() > 0) {
            sqlWhere = sqlWhere + "   and   stockInStoreDetail.productInfoId in(:productInfoId)  " ;
            value.put("productInfoId", searchBean.getProductInfoIds()) ;
        }
        return sqlWhere ;
    }

}
