package cn.zying.osales.service.stocks.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.OSalesConfigProperties.StockType ;
import cn.zying.osales.pojos.StockStoreReceive ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockStoreReceiveSearchBean ;

@Component("StockStoreReceiveSearchUnits")
public class StockStoreReceiveSearchUnits extends ABCommonsService {

    public StockStoreReceive searchByStockInStoreId(Integer stockInStoreId) throws SystemOptServiceException {
                String sql ="select  stockStoreReceive    from  StockStoreReceive  as  stockStoreReceive   where stockStoreReceive.stockInStoreId = "+stockInStoreId;
                return baseService.findSinglenessByHSQL(sql);
    }

    public SelectPage<StockStoreReceive> search(OptType optType, StockStoreReceiveSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<StockStoreReceive> selectPage = new SelectPage<StockStoreReceive>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockStoreReceive> result = list(sqlWhere, value, startLimit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<StockStoreReceive> list(OptType optType, StockStoreReceiveSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockStoreReceive> result = list(sqlWhere, value, startLimit) ;

        return result ;

    }

    private String sql = "select  stockStoreReceive   from   StockStoreReceive  as  stockStoreReceive   " +

    "  inner join  fetch   stockStoreReceive.stockInStore  as stockInStore   " +

    " inner join   fetch   stockInStore.stockOrder as  stockOrder   " ;

    private List<StockStoreReceive> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere ;
        List<StockStoreReceive> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = "select  count(stockStoreReceive.id)   from   StockStoreReceive  as  stockStoreReceive   " +

    "  inner join     stockStoreReceive.stockInStore  as stockInStore   " +

    " inner join      stockInStore.stockOrder as  stockOrder   " ;

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, StockStoreReceiveSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = " where  1= 1 " ;
        if (searchBean.getStatus() == null || searchBean.getStatus().equals(Status.全部)) {

        } else {
            sqlWhere = sqlWhere + "  and   stockStoreReceive.status ='" + searchBean.getStatus() + "' " ;
        }

        if (searchBean.getStatuses() == null || searchBean.getStatuses().size() == 0) {

        } else {
            sqlWhere = sqlWhere + "  and   stockStoreReceive.status  in (:status) " ;
            value.put("status", searchBean.getStatuses()) ;
        }

        if (ToolsUnits.isNOtNulll(searchBean.getStockOrderNumber())) {
            sqlWhere = sqlWhere + "   and  stockOrder.number  like '%" + searchBean.getStockOrderNumber() + "%'" ;
        }

        if (ToolsUnits.isNOtNulll(searchBean.getStockInStoreNumber())) {
            sqlWhere = sqlWhere + "   and  stockInStore.number  like '%" + searchBean.getStockInStoreNumber() + "%'" ;
        }

        if (ToolsUnits.isNOtNulll(searchBean.getNumber())) {
            sqlWhere = sqlWhere + "   and  stockStoreReceive.number  like '%" + searchBean.getNumber() + "%'" ;
        }

        List<Integer> providerInfoIds = ToolsUnits.filterNULL(searchBean.getProviderInfoIds()) ;
        if (providerInfoIds != null && providerInfoIds.size() > 0) {
            sqlWhere = sqlWhere + "   and  stockStoreReceive.providerInfoId  in (:providerInfoIds)" ;
            value.put("providerInfoIds", searchBean.getProviderInfoIds()) ;
        }

        List<StockType> stockType = ToolsUnits.filterNULL(searchBean.getStockTypes()) ;
        if (stockType != null && stockType.size() > 0) {
            sqlWhere = sqlWhere + "   and  stockStoreReceive.stockType in ( :stockTypes )" ;
            value.put("stockTypes", searchBean.getStockTypes()) ;
        }

        return sqlWhere ;
    }

}
