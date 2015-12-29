package cn.zying.osales.service.stocks.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.OSalesConfigProperties.StockBillIsReconciliation ;
import cn.zying.osales.pojos.StockPayment ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockPaymentSearchBean ;

@Component("StockPaymentBillReconcileUnits")
public class StockPaymentBillReconcileSearchUnits extends ABCommonsService {

    public SelectPage<StockPayment> search(OptType optType, StockPaymentSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<StockPayment> selectPage = new SelectPage<StockPayment>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockPayment> result = list(sqlWhere, value, startLimit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<StockPayment> list(OptType optType, StockPaymentSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockPayment> result = list(sqlWhere, value, startLimit) ;

        return result ;

    }

    private String sql = "select  stockPayment  from  StockPayment as  stockPayment " ;

    private List<StockPayment> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere ;
        List<StockPayment> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = "select  count(stockPayment.id)  from  StockPayment as  stockPayment " ;

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, StockPaymentSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = " where  stockPayment.status =:status " ;
        value.put("status", Status.已审核) ;

        if (!ToolsUnits.listIsNULL(searchBean.getReconciliationes())) {
            sqlWhere = sqlWhere + "  and   stockPayment.reconciliation in(:reconciliationes) " ;
            value.put("reconciliationes", searchBean.getReconciliationes()) ;
        }

        if (searchBean.getReconciliation() != null) {
            if (searchBean.getReconciliation().equals(StockBillIsReconciliation.查询非全部对帐)) {
                sqlWhere = sqlWhere + "  and   stockPayment.reconciliation  != (:reconciliation) " ;
                value.put("reconciliation", StockBillIsReconciliation.查询非全部对帐) ;
            } else {
                sqlWhere = sqlWhere + "  and   stockPayment.reconciliation  = (:reconciliation) " ;
                value.put("reconciliation", searchBean.getReconciliation()) ;
            }

        }

        if (ToolsUnits.isNOtNulll(searchBean.getNum())) {
            sqlWhere = sqlWhere + "  and   stockPayment.num  like (:getNum) " ;
            value.put("getNum", "%" + searchBean.getNum() + "%") ;
        }
        if (ToolsUnits.isNOtNulll(searchBean.getOtherSideReceiveNum())) {
            sqlWhere = sqlWhere + "  and   stockPayment.otherSideReceiveNum  like (:getOtherSideReceiveNum) " ;
            value.put("getOtherSideReceiveNum", "%" + searchBean.getOtherSideReceiveNum() + "%") ;
        }

        if (ToolsUnits.isNOtNulll(searchBean.getOtherSideBank())) {
            sqlWhere = sqlWhere + "  and   stockPayment.otherSideBank  like (:getOtherSideBank) " ;
            value.put("getOtherSideBank", "%" + searchBean.getOtherSideBank() + "%") ;
        }

        if (ToolsUnits.isNOtNulll(searchBean.getOurBank())) {
            sqlWhere = sqlWhere + "  and   stockPayment.ourBank  like (:getOurBank) " ;
            value.put("getOurBank", "%" + searchBean.getOurBank() + "%") ;
        }

        if (ToolsUnits.isNOtNulll(searchBean.getOtherSideReceiveNum())) {
            sqlWhere = sqlWhere + "  and   stockPayment.num  like (:getOtherSideReceiveNum) " ;
            value.put("getOtherSideReceiveNum", "%" + searchBean.getOtherSideReceiveNum() + "%") ;
        }

        if (!ToolsUnits.listIsNULL(searchBean.getPaymentTypes())) {
            sqlWhere = sqlWhere + "  and   stockPayment.paymentType in(:getPaymentTypes) " ;
            value.put("getPaymentTypes", searchBean.getPaymentTypes()) ;
        }

        if (!ToolsUnits.listIsNULL(searchBean.getIsPrePayments())) {
            sqlWhere = sqlWhere + "  and   stockPayment.isPrePayment in(:getIsPrePayments) " ;
            value.put("getIsPrePayments", searchBean.getIsPrePayments()) ;
        }

        if (searchBean.getStartTime() != null) {
            sqlWhere = sqlWhere + "  and   stockPayment.paymentDate   > = (:getStartTime) " ;
            value.put("getStartTime", searchBean.getPaymentDate()) ;
        }

        if (searchBean.getEndTime() != null) {
            sqlWhere = sqlWhere + "  and   stockPayment.paymentDate    <= (:getEndTime) " ;
            value.put("getEndTime", searchBean.getPaymentDate()) ;
        }

        return sqlWhere ;
    }

}
