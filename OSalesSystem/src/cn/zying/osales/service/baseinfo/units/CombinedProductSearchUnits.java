package cn.zying.osales.service.baseinfo.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.CombinedProduct ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.CombinedProductSearchBean ;

@Component("CombinedProductSearchUnits")
public class CombinedProductSearchUnits extends ABCommonsService {

    public CombinedProduct searchByProductInfoId(Integer productInfoId) throws SystemOptServiceException {
        String sql = "select  combinedProduct  from  CombinedProduct as combinedProduct   " +

        "inner join fetch  combinedProduct.combinedProductDetailses  " +

        "  where combinedProduct.productInfoId = " + productInfoId ;
        return baseService.findSinglenessByHSQL(sql) ;
    }

    public SelectPage<CombinedProduct> search(OptType optType, CombinedProductSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<CombinedProduct> selectPage = new SelectPage<CombinedProduct>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<CombinedProduct> result = list(sqlWhere, value, startLimit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<CombinedProduct> list(OptType optType, CombinedProductSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<CombinedProduct> result = list(sqlWhere, value, startLimit) ;

        return result ;

    }

    private String sql = "select  combinedProduct   from  CombinedProduct as combinedProduct  " ;

    private List<CombinedProduct> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere ;
        List<CombinedProduct> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = "select  count(combinedProduct.id)   from  CombinedProduct as combinedProduct " ;

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, CombinedProductSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = " where 1 =1 " ;
        if (searchBean.getStatus() == null || searchBean.getStatus().equals(Status.全部)) {

        } else {
            sqlWhere = sqlWhere + "   and    combinedProduct.status  ='" + searchBean.getStatus() + "'   " ;
        }

        return sqlWhere ;
    }

}
