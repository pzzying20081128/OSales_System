package cn.zying.osales.service.stocks.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockInvoice ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.OSToolsUnits ;
import cn.zying.osales.units.search.bean.StockInvoiceSearchBean ;

@Component("StockInvoiceSearchUnits")
public class StockInvoiceSearchUnits extends ABCommonsService {

    public SelectPage<StockInvoice> search(OptType optType, StockInvoiceSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<StockInvoice> selectPage = new SelectPage<StockInvoice>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockInvoice> result = list(sqlWhere, value, startLimit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<StockInvoice> list(OptType optType, StockInvoiceSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        
        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockInvoice> result = list(sqlWhere, value, startLimit) ;

        return result ;

    }

    private String sql = "select  stockInvoice   from  StockInvoice as  stockInvoice   " ;

    private List<StockInvoice> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere ;
        List<StockInvoice> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = "select  count(stockInvoice.id)   from  StockInvoice as  stockInvoice " ;

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, StockInvoiceSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = " where  1= 1 " ;
        if (!OSToolsUnits.listIsNull(searchBean.getStatuses())) {
            sqlWhere = sqlWhere + "  and    stockInvoice.status in(:statuses)" ;
            value.put("statuses", searchBean.getStatuses()) ;
        }

        if (searchBean.getStatus() != null) {
            sqlWhere = sqlWhere + "  and    stockInvoice.status  = :status " ;
            value.put("status", searchBean.getStatus()) ;
        }

        if (ToolsUnits.isNOtNulll(searchBean.getNum())) {
            sqlWhere = sqlWhere + "  and    stockInvoice.num  like :num " ;
            value.put("num", "%" + searchBean.getNum() + "%") ;
        }

        if (ToolsUnits.isNOtNulll(searchBean.getInvoiceNum())) {
            sqlWhere = sqlWhere + "  and    stockInvoice.invoiceNum  like  :invoiceNum " ;
            value.put("invoiceNum", "%" + searchBean.getInvoiceNum() + "%") ;
        }
        if (!OSToolsUnits.listIsNull(searchBean.getProviderInfoIds())) {
            sqlWhere = sqlWhere + "  and    stockInvoice.providerInfoId in(:providerInfoId)" ;
            value.put("providerInfoId", searchBean.getProviderInfoIds()) ;
        }

        if (searchBean.getOpenStartTime() != null) {
            sqlWhere = sqlWhere + "  and    stockInvoice.invoiceDate >= :invoiceDateStart" ;
            value.put("invoiceDateStart", searchBean.getOpenStartTime()) ;
        }

        if (searchBean.getOpenEndTime() != null) {
            sqlWhere = sqlWhere + "  and    stockInvoice.invoiceDate <= :invoiceDateEnd" ;
            value.put("invoiceDateEnd", searchBean.getOpenEndTime()) ;
        }
        if (searchBean.getOpenStartTime() != null) {
            sqlWhere = sqlWhere + "  and    stockInvoice.paymentDate >= :paymentDateStart" ;
            value.put("paymentDateStart", searchBean.getPaymentStartTime()) ;
        }

        if (searchBean.getOpenEndTime() != null) {
            sqlWhere = sqlWhere + "  and    stockInvoice.paymentDate <= :paymentDateEnd" ;
            value.put("paymentDateEnd", searchBean.getPaymentEndTime()) ;
        }
        
        if (ToolsUnits.isNOtNulll(searchBean.getText())) {
            sqlWhere = sqlWhere + "  and    stockInvoice.text  like  :text " ;
            value.put("text", "%" + searchBean.getText() + "%") ;
        }

        return sqlWhere ;
    }

}
