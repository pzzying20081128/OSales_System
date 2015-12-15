package cn.zying.osales.service.storehouse.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.StoreProductInfoStock ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StoreProductInfoStockSearchBean ;

@Component("StoreProductInfoStockSearchUnits")
public class StoreProductInfoStockSearchUnits extends ABCommonsService {

    public SelectPage<StoreProductInfoStock> search(OptType optType, StoreProductInfoStockSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<StoreProductInfoStock> selectPage = new SelectPage<StoreProductInfoStock>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StoreProductInfoStock> result = list(sqlWhere, value, startLimit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<StoreProductInfoStock> list(OptType optType, StoreProductInfoStockSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<StoreProductInfoStock> result = list(sqlWhere, value, startLimit) ;

        return result ;

    }

    private String sql = "select  storeProductInfoStock   from  StoreProductInfoStock as  storeProductInfoStock   " ;

    private List<StoreProductInfoStock> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere ;
        List<StoreProductInfoStock> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = "select  count(storeProductInfoStock.id)   from  StoreProductInfoStock as  storeProductInfoStock" ;

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, StoreProductInfoStockSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = " where  1=1 " ;
        if (searchBean.getProductInfoIds() != null && searchBean.getProductInfoIds().size() > 0) {
            sqlWhere = sqlWhere + "  and   storeProductInfoStock.productInfoId in (:productInfoId) " ;
            value.put("productInfoId", searchBean.getProductInfoIds()) ;
        }

        if (searchBean.getStoreInfoIds() != null && searchBean.getStoreInfoIds().size() > 0) {
            sqlWhere = sqlWhere + "  and   storeProductInfoStock.storeInfoId in (:storeInfoId) " ;
            value.put("storeInfoId", searchBean.getStoreInfoIds()) ;
        }

        if (searchBean.getStoreTypes() != null && searchBean.getStoreTypes().size() > 0) {
            sqlWhere = sqlWhere + "  and   storeProductInfoStock.storeType in (:getStoreTypes) " ;
            value.put("getStoreTypes", searchBean.getStoreTypes()) ;
        }

        return sqlWhere ;
    }

}
