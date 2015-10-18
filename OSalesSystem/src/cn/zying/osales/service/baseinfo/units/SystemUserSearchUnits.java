package cn.zying.osales.service.baseinfo.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.SystemUserSearchBean ;

@Component("SystemUserSearchUnits")
public class SystemUserSearchUnits extends ABCommonsService {

    public SysStaffUser searchByAccessName(String accessName) throws SystemOptServiceException {
        //                String sql ="select  systemUser from  SystemUser as  systemUser  where  systemUser.account =:account  ";
        Map<String, Object> value = ToolsUnits.createSearchMap() ;
        value.put("account", accessName.trim()) ;
        value.put("status", OSalesConfigProperties.Status.有效) ;
        return baseService.findSinglenessByQName(OSalesConfigProperties.query_sysStaffUser_searchByAccessName, value) ;
    }

    private static String searchByName = "select  sysStaffUser  from  SysStaffUser as  sysStaffUser  where sysStaffUser.name =:name" ;

    public SysStaffUser searchByName(String name) throws SystemOptServiceException {
        Map<String, Object> value = ToolsUnits.createSearchMap() ;
        value.put("name", name) ;
        return baseService.findSinglenessByHSQL(searchByName, value) ;

    }

    private String sql = "select  sysStaffUser  from  SysStaffUser as  sysStaffUser   " ;

    private String sqlsum = "select  count(sysStaffUser.id)  from  SysStaffUser as  sysStaffUser" ;

    public SelectPage<SysStaffUser> search(OptType optType, SystemUserSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<SysStaffUser> selectPage = new SelectPage<SysStaffUser>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<SysStaffUser> result = list(sqlWhere, value, startLimit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<SysStaffUser> list(OptType optType, SystemUserSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<SysStaffUser> result = list(sqlWhere, value, startLimit) ;

        return result ;
    }

    private List<SysStaffUser> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere ;
        System.out.println("==>  " + sql_) ;
        List<SysStaffUser> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, SystemUserSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = "  where 1=1 " ;
        if (searchBean == null) {
            sqlWhere = sqlWhere + " and  sysStaffUser.status ='" + Status.有效 + "'" ;
        } else {
            if (searchBean.getStatus() == null) {
                sqlWhere = sqlWhere + " and  sysStaffUser.status ='" + Status.有效 + "'" ;
            } else {
                if (searchBean.getStatus().equals(Status.全部)) {

                } else {
                    sqlWhere = sqlWhere + " and  sysStaffUser.status ='" + searchBean.getStatus() + "'" ;
                }

                if (searchBean.getIsBizMan() !=null && searchBean.getIsBizMan() != OSalesConfigProperties.isDefault_all) {
                    sqlWhere = sqlWhere + " and  sysStaffUser.isBizMan =" + searchBean.getIsBizMan() ;
                }
                if (searchBean.getIsGoodsMan() !=null && searchBean.getIsGoodsMan() != OSalesConfigProperties.isDefault_all) {
                    sqlWhere = sqlWhere + " and  sysStaffUser.isGoodsMan =" + searchBean.getIsGoodsMan() ;
                }
                if (searchBean.getIsStockMan() !=null && searchBean.getIsStockMan() != OSalesConfigProperties.isDefault_all) {
                    sqlWhere = sqlWhere + " and  sysStaffUser.isStockMan =" + searchBean.getIsStockMan() ;
                }
                if (searchBean.getIsTransportMan() !=null && searchBean.getIsTransportMan() != OSalesConfigProperties.isDefault_all) {
                    sqlWhere = sqlWhere + " and  sysStaffUser.isTransportMan =" + searchBean.getIsTransportMan() ;
                }
                if (searchBean.getSex() !=null && searchBean.getSex() != OSalesConfigProperties.isDefault_all) {
                    sqlWhere = sqlWhere + " and  sysStaffUser.sex =" + searchBean.getSex() ;
                }
                if (ToolsUnits.isNOtNulll(searchBean.getName())) {
                    sqlWhere = sqlWhere + " and  sysStaffUser.name like  '%" + searchBean.getName() + "%'" ;
                }
                if (ToolsUnits.isNOtNulll(searchBean.getAccount())) {
                    sqlWhere = sqlWhere + " and  sysStaffUser.account like  '%" + searchBean.getAccount() + "%'" ;
                }
                if (ToolsUnits.isNOtNulll(searchBean.getPhone())) {
                    sqlWhere = sqlWhere + " and  sysStaffUser.phone like  '%" + searchBean.getPhone() + "%'" ;
                }
                if (ToolsUnits.isNOtNulll(searchBean.getText())) {
                    sqlWhere = sqlWhere + " and  sysStaffUser.text like  '%" + searchBean.getText() + "%'" ;
                }
                if (ToolsUnits.isNOtNulll(searchBean.getAddress())) {
                    sqlWhere = sqlWhere + " and  sysStaffUser.address like '%" + searchBean.getAddress() + "%'" ;
                }
            }

        }

        return sqlWhere ;
    }

}
