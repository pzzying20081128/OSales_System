package cn.zying.osales.service.baseinfo.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.ProductInfo ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.ProductInfoSearchBean ;

@Component("ProductInfoSearchUnits")
public class ProductInfoSearchUnits extends ABCommonsService {

    public SelectPage<ProductInfo> search(OptType optType, ProductInfoSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<ProductInfo> selectPage = new SelectPage<ProductInfo>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<ProductInfo> result = list(sqlWhere, value, startLimit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

    public List<ProductInfo> list(OptType optType, ProductInfoSearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<ProductInfo> result = list(sqlWhere, value, startLimit) ;

        return result ;

    }

    private String sql = " select    productInfo   from  ProductInfo as productInfo  " ;

    private List<ProductInfo> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere ;
        List<ProductInfo> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = "  select    count(productInfo.id)   from  ProductInfo as productInfo " ;

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, ProductInfoSearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = "  where   1 =1 " ;
        if (searchBean.getStatus() != null && !searchBean.getStatus().equals(Status.全部)) {
            sqlWhere = sqlWhere + "   and   productInfo.status  ='" + searchBean.getStatus() + "'  " ;
        }
        return sqlWhere ;
    }

}
