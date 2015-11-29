package cn.zying.osales.service.stocks.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.logger.Loggerfactory ;
import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.StockInStore ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockInStoreSearchBean ;

@Component("StockInStoreSearchUnits")
public class StockInStoreSearchUnits extends ABCommonsService {

    /**
     * 查询已审核的入库单
     * @param stockOrderId
     * @return
     * @throws SystemOptServiceException
     */
    public List<StockInStore> searchByStockOrderId(Integer stockOrderId) throws SystemOptServiceException {
        String sql = "select stockInStore   from StockInStore as  stockInStore   where stockInStore.stockOrderId  = " + stockOrderId  ;
        return baseService.findByHSQL(sql) ;
    }

    public SelectPage<StockInStore> search(OptType optType, StockInStoreSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        SelectPage<StockInStore> selectPage = new SelectPage<StockInStore>() ;

        List<StockInStore> result = list(optType, searchBean, commSearchBean, startLimit) ;

        Long sum = sum(optType, searchBean, commSearchBean) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<StockInStore> list(OptType optType, StockInStoreSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sql = "select  stockInStore   from  StockInStore as  stockInStore   inner join  fetch stockInStore.stockOrder     " ;

        if (searchBean.getProductInfoIds() != null && searchBean.getProductInfoIds().size() > 0) {
            sql = sql + "   inner  join  stockInStore.stockInStoreDetails as  stockInStoreDetails    " ;
        }

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        String sql_ = sql + sqlWhere ;
         Loggerfactory.print(sql_);
        List<StockInStore> result = baseService.findByHSQL(sql_, value, startLimit) ;

        return result ;

    }

    private Long sum(OptType optType, StockInStoreSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        String sqlsum = " select  count(stockInStore.id)   from  StockInStore as  stockInStore inner join   stockInStore.stockOrder  " ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        if (searchBean.getProductInfoIds() != null && searchBean.getProductInfoIds().size() > 0) {
            sqlsum = sqlsum + "   inner  join  stockInStore.stockInStoreDetails as  stockInStoreDetails    " ;
        }

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        sqlsum = sqlsum + sqlWhere ;

        Long sum = baseService.findSinglenessByHSQL(sqlsum, value) ;

        return sum ;

    }

    private String createWhere(Map<String, Object> value, StockInStoreSearchBean searchBean, CommSearchBean commSearchBean) {

        String sqlWhere = " where  1 =1 " ;

        if (searchBean.getStatus() == null || searchBean.getStatus().equals(Status.全部)) {

        } else {
            sqlWhere = sqlWhere + "   and   stockInStore.status ='" + searchBean.getStatus() + "'  " ;
        }

        if (searchBean.getStatuses() != null && searchBean.getStatuses().size() > 0) {
            sqlWhere = sqlWhere + "   and   stockInStore.status  in (:status)  " ;
            value.put("status", searchBean.getStatuses()) ;
        }

        if (searchBean.getProviderInfoIds() != null && searchBean.getProviderInfoIds().size() > 0) {
            sqlWhere = sqlWhere + "   and   stockInStore.providerInfoId  in (:providerInfoId)  " ;
            value.put("providerInfoId", searchBean.getProviderInfoIds()) ;
        }

        //
        if (searchBean.getProductInfoIds() != null && searchBean.getProductInfoIds().size() > 0) {
            sqlWhere = sqlWhere + "   and   stockInStoreDetails.productInfoId  in (:productInfoId)  " ;
            value.put("productInfoId", searchBean.getProductInfoIds()) ;
        }

        if (searchBean.getStatuses() != null && searchBean.getStatuses().size() > 0) {
            sqlWhere = sqlWhere + "   and   stockInStore.status  in (:status)  " ;
            value.put("status", searchBean.getStatuses()) ;
        }

        if (ToolsUnits.isNOtNulll(searchBean.getRemarks())) {
            sqlWhere = sqlWhere + "   and   stockInStore.remarks  in (:remarks)  " ;
            value.put("remarks", searchBean.getRemarks()) ;
        }

        if (ToolsUnits.isNOtNulll(searchBean.getText())) {
            sqlWhere = sqlWhere + "   and   stockInStore.text  in (:text)  " ;
            value.put("text", searchBean.getText()) ;
        }

        return sqlWhere ;
    }

}
