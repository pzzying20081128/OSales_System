package cn.zying.osales.service.stocks.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockAdjustBill ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockAdjustBillSearchBean ;

@Component("StockAdjustBillSearchUnits")
public class StockAdjustBillSearchUnits extends ABCommonsService {

    public SelectPage<StockAdjustBill> search(OptType optType, StockAdjustBillSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<StockAdjustBill> selectPage = new SelectPage<StockAdjustBill>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockAdjustBill> result = list(sqlWhere, value, startLimit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<StockAdjustBill> list(OptType optType, StockAdjustBillSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockAdjustBill> result = list(sqlWhere, value, startLimit) ;

        return result ;

    }

    private String sql = " select  stockAdjustBill   from  StockAdjustBill as stockAdjustBill   " ;

    private List<StockAdjustBill> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere ;
        List<StockAdjustBill> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = "select  count(stockAdjustBill.id)   from  StockAdjustBill as stockAdjustBill " ;

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, StockAdjustBillSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = " where  1 =1 " ;
        if (!ToolsUnits.listIsNULL(searchBean.getStatuses())) {
            sqlWhere = sqlWhere + "  and  stockAdjustBill.status in (:getStatuses) " ;
            value.put("getStatuses", searchBean.getStatuses()) ;
        }

        if (searchBean.getStatus() != null) {
            sqlWhere = sqlWhere + "  and  stockAdjustBill.status =  (:getStatus) " ;
            value.put("getStatus", searchBean.getStatus()) ;
        }

        if (!ToolsUnits.listIsNULL(searchBean.getProviderInfoIds())) {
            sqlWhere = sqlWhere + "  and  stockAdjustBill.providerInfoId in (:getProviderInfoIds) " ;
            value.put("getProviderInfoIds", searchBean.getProviderInfoIds()) ;
        }

        if (!ToolsUnits.listIsNULL(searchBean.getAdjustSubjects())) {
            sqlWhere = sqlWhere + "  and  stockAdjustBill.adjustSubject in (:getAdjustSubjects) " ;
            value.put("getAdjustSubjects", searchBean.getAdjustSubjects()) ;
        }

        if (!ToolsUnits.listIsNULL(searchBean.getAdjustTypes())) {
            sqlWhere = sqlWhere + "  and  stockAdjustBill.adjustType  in (:getAdjustTypes) " ;
            value.put("getAdjustTypes", searchBean.getAdjustTypes()) ;
        }

        if (ToolsUnits.isNOtNulll(searchBean.getAdjustNum())) {
            sqlWhere = sqlWhere + "  and  stockAdjustBill.adjustNum  like  (:getAdjustNum) " ;
            value.put("getAdjustNum", "%" + searchBean.getAdjustNum() + "%") ;
        }

        if (ToolsUnits.isNOtNulll(searchBean.getText())) {
            sqlWhere = sqlWhere + "  and  stockAdjustBill.text  like  (:getText) " ;
            value.put("getText", "%" + searchBean.getText() + "%") ;
        }

        if (searchBean.getStartTime() != null) {
            sqlWhere = sqlWhere + "  and  stockAdjustBill.adjustDate >= :getStartTime " ;
            value.put("getStartTime", searchBean.getStartTime()) ;
        }
        if (searchBean.getEndTime() != null) {
            sqlWhere = sqlWhere + "  and  stockAdjustBill.adjustDate <= :getEndTime " ;
            value.put("getEndTime", searchBean.getEndTime()) ;
        }

        return sqlWhere ;
    }

}
