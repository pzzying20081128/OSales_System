package cn.zying.osales.service.baseinfo.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.pojos.CombinedProductDetails ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.CombinedProductDetailsSearchBean ;

@Component("CombinedProductDetailsSearchUnits")
public class CombinedProductDetailsSearchUnits extends ABCommonsService {

    public SelectPage<CombinedProductDetails> search(OptType optType, CombinedProductDetailsSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<CombinedProductDetails> selectPage = new SelectPage<CombinedProductDetails>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<CombinedProductDetails> result = list(sqlWhere, value, startLimit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<CombinedProductDetails> list(OptType optType, CombinedProductDetailsSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<CombinedProductDetails> result = list(sqlWhere, value, startLimit) ;

        return result ;

    }

    private String sql = "select combinedProductDetails    from  CombinedProductDetails as  combinedProductDetails      " ;

    private List<CombinedProductDetails> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere ;
        List<CombinedProductDetails> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = "select  count(combinedProductDetails.id)    from  CombinedProductDetails as  combinedProductDetails  " ;

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, CombinedProductDetailsSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = "  where combinedProductDetails.combinedProductId = " + searchBean.getCombinedProductId() ;
        return sqlWhere ;
    }

}
