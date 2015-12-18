package cn.zying.osales.service.stocks.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.StockReturnStoreOut ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockReturnStoreOutSearchBean ;

@Component("StockReturnStoreOutSearchUnits")
public class StockReturnStoreOutSearchUnits extends ABCommonsService {

    public SelectPage<StockReturnStoreOut> search(OptType optType, StockReturnStoreOutSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<StockReturnStoreOut> selectPage = new SelectPage<StockReturnStoreOut>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockReturnStoreOut> result = list(searchBean, sqlWhere, value, startLimit) ;

        Long sum = sum(searchBean, sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<StockReturnStoreOut> list(OptType optType, StockReturnStoreOutSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockReturnStoreOut> result = list(searchBean, sqlWhere, value, startLimit) ;

        return result ;

    }

    private String sql = " select stockReturnStoreOut  from  StockReturnStoreOut as  stockReturnStoreOut   inner join  fetch  stockReturnStoreOut.stockReturn  " ;

    private List<StockReturnStoreOut> list(StockReturnStoreOutSearchBean searchBean, String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        //        String sql_ = sql + sqlWhere ;

        String sql_ = sql ;

        if (searchBean.getProductInfoIds() != null && searchBean.getProductInfoIds().size() > 0) {
            sql_ = sql_ + "inner join  stockReturnStoreOut.stockReturnStoreOutDetails as   stockReturnStoreOutDetails " ;
            sqlWhere = sqlWhere + " and   stockReturnStoreOutDetails.productInfoId in (:productInfoIds) " ;
            value.put("productInfoIds", searchBean.getProductInfoIds()) ;

            sql_ = sql_ + sqlWhere ;

        }else{
            sql_ = sql_ + sqlWhere ;
        }

        List<StockReturnStoreOut> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = " select  count(stockReturnStoreOut.id)  from  StockReturnStoreOut as  stockReturnStoreOut   inner join    stockReturnStoreOut.stockReturn " ;

    private Long sum(StockReturnStoreOutSearchBean searchBean, String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        //        String sql_ = sqlsum + sqlWhere ;

        String sql_ = sqlsum ;

        if (searchBean.getProductInfoIds() != null && searchBean.getProductInfoIds().size() > 0) {
            sql_ = sql_ + "inner join  stockReturnStoreOut.stockReturnStoreOutDetails as   stockReturnStoreOutDetails " ;
            sqlWhere = sqlWhere + " and   stockReturnStoreOutDetails.productInfoId in (:productInfoIds) " ;
            value.put("productInfoIds", searchBean.getProductInfoIds()) ;

            sql_ = sql_ + sqlWhere ;

        }else{
            sql_ = sql_ + sqlWhere ;
        }


        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, StockReturnStoreOutSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = "  where  1=1 " ;
        if (searchBean.getStatuses() != null && searchBean.getStatuses().size() > 0) {
            sqlWhere = sqlWhere + " and   stockReturnStoreOut.status in (:status) " ;
            value.put("status", searchBean.getStatuses()) ;
        } else {
            if(searchBean.getStatus()!=null){
                sqlWhere = sqlWhere + " and   stockReturnStoreOut.status ='" + (searchBean.getStatus() != null ? searchBean.getStatus().name() : Status.有效.name()) + "'" ;     
            }
           
        }
        if (ToolsUnits.isNOtNulll(searchBean.getNumber())) {
            sqlWhere = sqlWhere + " and   stockReturnStoreOut.number like (:number) " ;
            value.put("number", "%" + searchBean.getNumber() + "%") ;
        }
        if (ToolsUnits.isNOtNulll(searchBean.getStockReturnNumber())) {
            sqlWhere = sqlWhere + " and   stockReturn.number like (:getStockReturnNumber) " ;
            value.put("getStockReturnNumber", "%" + searchBean.getStockReturnNumber() + "%") ;
        }
        //
        if (ToolsUnits.isNOtNulll(searchBean.getRemarks())) {
            sqlWhere = sqlWhere + " and   stockReturnStoreOut.remarks like (:remarks) " ;
            value.put("remarks", "%" + searchBean.getRemarks() + "%") ;
        }
        if (ToolsUnits.isNOtNulll(searchBean.getText())) {
            sqlWhere = sqlWhere + " and   stockReturn.text like (:getText) " ;
            value.put("getText", "%" + searchBean.getText() + "%") ;
        }
        //

        if (searchBean.getStockTypes() != null && searchBean.getStockTypes().size() > 0) {
            sqlWhere = sqlWhere + " and   stockReturn.stockType in (:stockType) " ;
            value.put("stockType", searchBean.getStockTypes()) ;
        }

        if (searchBean.getStockTypes() != null && searchBean.getStockTypes().size() > 0) {
            sqlWhere = sqlWhere + " and   stockReturn.stockType in (:stockType) " ;
            value.put("stockType", searchBean.getStockTypes()) ;
        }

        if (searchBean.getProviderInfoIds() != null && searchBean.getProviderInfoIds().size() > 0) {
            sqlWhere = sqlWhere + " and   stockReturn.providerInfoId in (:providerInfoId) " ;
            value.put("providerInfoId", searchBean.getProviderInfoIds()) ;
        }

        if (searchBean.getStartTime() != null) {
            sqlWhere = sqlWhere + " and   stockReturn.outStoreDate  >= (:getStartTime) " ;
            value.put("getStartTime", searchBean.getStartTime()) ;
        }

        if (searchBean.getEndTime() != null) {
            sqlWhere = sqlWhere + " and   stockReturn.outStoreDate  <= (:getEndTime) " ;
            value.put("getEndTime", searchBean.getEndTime()) ;
        }

        return sqlWhere ;
    }

}
