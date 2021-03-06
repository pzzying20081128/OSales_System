package cn.zying.osales.service.stocks.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StockContract ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockContractSearchBean ;

@Component("StockContractSearchUnits")
public class StockContractSearchUnits extends ABCommonsService {

    public SelectPage<StockContract> search(OptType optType, StockContractSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<StockContract> selectPage = new SelectPage<StockContract>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockContract> result = list(sqlWhere, value, startLimit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<StockContract> list(OptType optType, StockContractSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StockContract> result = list(sqlWhere, value, startLimit) ;

        return result ;

    }

    private String sql = "select  stockContract  from  StockContract  as stockContract  " ;

    private List<StockContract> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere ;
        List<StockContract> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = "select  count(stockContract.id)  from  StockContract  as stockContract" ;

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, StockContractSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = " where 1 =1 " ;
        if (!ToolsUnits.listIsNULL(searchBean.getStatuses())) {
            sqlWhere = sqlWhere + "  and   stockContract.status in (:statuses) " ;
            value.put("statuses", searchBean.getStatuses()) ;
        }

        if (searchBean.getStatus() != null) {
            sqlWhere = sqlWhere + "  and   stockContract.status  = :status " ;
            value.put("status", searchBean.getStatus()) ;
        }

        if (!ToolsUnits.listIsNULL(searchBean.getCompanyInfoIds())) {
            sqlWhere = sqlWhere + "  and   stockContract.companyInfoId  in( :companyInfoIds) " ;
            value.put("companyInfoIds", searchBean.getCompanyInfoIds()) ;
        }
        if (!ToolsUnits.listIsNULL(searchBean.getContractStatuses())) {
            sqlWhere = sqlWhere + "  and   stockContract.contractStatus  in( :contractStatuses) " ;
            value.put("contractStatuses", searchBean.getContractStatuses()) ;
        }
        if (!ToolsUnits.listIsNULL(searchBean.getProviderInfoIds())) {
            sqlWhere = sqlWhere + "  and   stockContract.providerInfoId  in( :providerInfoIds) " ;
            value.put("providerInfoIds", searchBean.getProviderInfoIds()) ;
        }
        
        if (searchBean.getStartTime() !=null) {
            sqlWhere = sqlWhere + "  and   stockContract.signedDate  >= :getStartTime " ;
            value.put("getStartTime", searchBean.getSignedDate() ) ;
        }
        if (searchBean.getEndTime() !=null) {
            sqlWhere = sqlWhere + "  and   stockContract.signedDate  <= :getEndTime " ;
            value.put("getEndTime", searchBean.getSignedDate() ) ;
        }

        return sqlWhere ;
    }
}
