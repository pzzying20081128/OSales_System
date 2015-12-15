package cn.zying.osales.service.stocks.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.StockReturn ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockReturnSearchBean ;

@Component("StockReturnSearchUnits")
public class StockReturnSearchUnits extends ABCommonsService {

    public SelectPage<StockReturn> search(OptType optType, StockReturnSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        SelectPage<StockReturn> selectPage = new SelectPage<StockReturn>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockReturn> result = list(sqlWhere, searchBean, value, startLimit) ;

        Long sum = sum(sqlWhere, searchBean, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<StockReturn> list(OptType optType, StockReturnSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockReturn> result = list(sqlWhere, searchBean, value, startLimit) ;

        return result ;

    }

    private String sql = " select  stockReturn   from  StockReturn as  stockReturn   " ;

    private List<StockReturn> list(String sqlWhere, StockReturnSearchBean searchBean, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql ;
        if (searchBean.getProductInfoIds() != null && searchBean.getProductInfoIds().size() > 0) {
            sql_ = sql_ + "  inner join   stockReturn.stockReturnDetails as stockReturnDetails   " ;
        }

        sql_ = sql_ + sqlWhere ;

        List<StockReturn> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = "select  count(stockReturn.id)   from  StockReturn as  stockReturn" ;

    private Long sum(String sqlWhere, StockReturnSearchBean searchBean, Map<String, Object> value) throws SystemOptServiceException {
        //        String sql_ = sqlsum + sqlWhere ;

        String sql_ = sqlsum ;
        if (searchBean.getProductInfoIds() != null && searchBean.getProductInfoIds().size() > 0) {
            sql_ = sql_ + "  inner join   stockReturn.stockReturnDetails as stockReturnDetails   " ;
        }

        sql_ = sql_ + sqlWhere ;

        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, StockReturnSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = "   where  1=1" ;
        if (searchBean.getStatuses() == null || searchBean.getStatuses().size() == 0) {
            sqlWhere = sqlWhere + "   and  stockReturn.status ='" + Status.有效 + "' " ;
        } else {
            sqlWhere = sqlWhere + "   and  stockReturn.status  in(:status) " ;
            value.put("status", searchBean.getStatuses()) ;
        }
        
        if (searchBean.getProductInfoIds() != null && searchBean.getProductInfoIds().size() > 0) {
            sqlWhere = sqlWhere + "   and  stockReturnDetails.productInfoId  in(:productInfoId) " ;
            value.put("productInfoId", searchBean.getProductInfoIds()) ;
        }

        if (searchBean.getStockProductTypes() != null && searchBean.getStockProductTypes().size() > 0) {
            sqlWhere = sqlWhere + "   and  stockReturn.stockProductType  in(:stockProductType) " ;
            value.put("stockProductType", searchBean.getStockProductTypes()) ;
        }

        if (searchBean.getStockTypes() != null && searchBean.getStockTypes().size() > 0) {
            sqlWhere = sqlWhere + "   and  stockReturn.stockProductType  in(:stockType) " ;
            value.put("stockType", searchBean.getStockTypes()) ;
        }

        if (searchBean.getProviderInfoIds() != null && searchBean.getProviderInfoIds().size() > 0) {
            sqlWhere = sqlWhere + "   and  stockReturn.stockProductType  in(:getProviderInfoIds) " ;
            value.put("getProviderInfoIds", searchBean.getProviderInfoIds()) ;
        }

        if (searchBean.getReturnTypes() != null && searchBean.getReturnTypes().size() > 0) {
            sqlWhere = sqlWhere + "   and  stockReturn.returnType  in(:getReturnTypes) " ;
            value.put("getReturnTypes", searchBean.getReturnTypes()) ;
        }

        if (searchBean.getStockManId() != null) {
            sqlWhere = sqlWhere + "   and  stockReturn.stockManId = " + searchBean.getStockManId() ;
            //            value.put("getReturnTypes", searchBean.getReturnTypes()) ;
        }

        if (ToolsUnits.isNOtNulll(searchBean.getRemarks())) {
            sqlWhere = sqlWhere + "   and  stockReturn.remarks  like (:getRemarks) " ;
            value.put("getRemarks", "%" + searchBean.getRemarks() + "%") ;

        }

        if (ToolsUnits.isNOtNulll(searchBean.getText())) {
            sqlWhere = sqlWhere + "   and  stockReturn.text  like (:getText) " ;
            value.put("getText", "%" + searchBean.getText() + "%") ;

        }

        return sqlWhere ;
    }

}
