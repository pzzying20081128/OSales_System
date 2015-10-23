package cn.zying.osales.service.baseinfo.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.PaymentMethod ;
import cn.zying.osales.OSalesConfigProperties.ReturnType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.ProviderInfo ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.ProviderInfoSearchBean ;

@Component("ProviderInfoSearchUnits")
public class ProviderInfoSearchUnits extends ABCommonsService {

    public SelectPage<ProviderInfo> search(OptType optType, ProviderInfoSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<ProviderInfo> selectPage = new SelectPage<ProviderInfo>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<ProviderInfo> result = list(sqlWhere, value, startLimit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<ProviderInfo> list(OptType optType, ProviderInfoSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<ProviderInfo> result = list(sqlWhere, value, startLimit) ;

        return result ;

    }

    private String sql = "select providerInfo  from  ProviderInfo as  providerInfo   " ;

    private List<ProviderInfo> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere ;
        List<ProviderInfo> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = "select count(providerInfo.id)  from  ProviderInfo as  providerInfo " ;

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, ProviderInfoSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = "  where  1 =1 " ;
        if (searchBean.getStatus() == null) {
            sqlWhere = sqlWhere + "  and    providerInfo.status ='" + Status.有效 + "' " ;
        } else {
            if (!searchBean.getStatus().equals(Status.全部)) {
                sqlWhere = sqlWhere + "  and    providerInfo.status ='" + searchBean.getStatus() + "' " ;
            }

        }

        if (ToolsUnits.isNOtNulll(searchBean.getAddress())) {
            sqlWhere = sqlWhere + "  and    providerInfo.address like '%" + searchBean.getAddress() + "%' " ;
        }

        if (ToolsUnits.isNOtNulll(searchBean.getBank1())) {
            sqlWhere = sqlWhere + "  and    providerInfo.bank1 like '%" + searchBean.getBank1() + "%' " ;
        }

        if (ToolsUnits.isNOtNulll(searchBean.getBank2())) {
            sqlWhere = sqlWhere + "  and    providerInfo.bank2 like '%" + searchBean.getBank2() + "%' " ;
        }

        if (ToolsUnits.isNOtNulll(searchBean.getContactMan())) {
            sqlWhere = sqlWhere + "  and    providerInfo.contactMan like '%" + searchBean.getContactMan() + "%' " ;
        }
        if (ToolsUnits.isNOtNulll(searchBean.getFax())) {
            sqlWhere = sqlWhere + "  and    providerInfo.fax like '%" + searchBean.getFax() + "%' " ;
        }

        if (ToolsUnits.isNOtNulll(searchBean.getMail())) {
            sqlWhere = sqlWhere + "  and    providerInfo.mail  like '%" + searchBean.getMail() + "%' " ;
        }
        if (ToolsUnits.isNOtNulll(searchBean.getName())) {
            sqlWhere = sqlWhere + "  and    providerInfo.name like '%" + searchBean.getName() + "%' " ;
        }

        if (ToolsUnits.isNOtNulll(searchBean.getPhone())) {
            sqlWhere = sqlWhere + "  and    providerInfo.phone like '%" + searchBean.getPhone() + "%' " ;
        }

        if (ToolsUnits.isNOtNulll(searchBean.getQq())) {
            sqlWhere = sqlWhere + "  and    providerInfo.qq like '%" + searchBean.getQq() + "%' " ;
        }

        if (ToolsUnits.isNOtNulll(searchBean.getShortName())) {
            sqlWhere = sqlWhere + "  and    providerInfo.shortName  like '%" + searchBean.getShortName() + "%' " ;
        }

        if (ToolsUnits.isNOtNulll(searchBean.getText())) {
            sqlWhere = sqlWhere + "  and    providerInfo.text  like '%" + searchBean.getText() + "%' " ;
        }

        if (ToolsUnits.isNOtNulll(searchBean.getWeb())) {
            sqlWhere = sqlWhere + "  and    providerInfo.web  like '%" + searchBean.getWeb() + "%' " ;
        }

        if (searchBean.getPaymentMethod() != null && !searchBean.getPaymentMethod().equals(PaymentMethod.全部)) {
            sqlWhere = sqlWhere + "  and    providerInfo.paymentMethod  like '%" + searchBean.getPaymentMethod() + "%' " ;
        }

        if (searchBean.getReturnType() != null && !searchBean.getReturnType().equals(ReturnType.全部)) {
            sqlWhere = sqlWhere + "  and    providerInfo.returnType  like '%" + searchBean.getReturnType() + "%' " ;
        }

        if (searchBean.getSettleTime() != null) {
            sqlWhere = sqlWhere + "  and    providerInfo.settleTime = " + searchBean.getSettleTime() ;
        }

        if (searchBean.getStockManId() != null) {
            sqlWhere = sqlWhere + "  and    providerInfo.stockManId  = " + searchBean.getStockManId() ;
        }

        return sqlWhere ;
    }

}
