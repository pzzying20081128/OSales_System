package cn.zying.osales.service.baseinfo.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.ProductCategory ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.ProductCategorySearchBean ;

@Component("ProductCategorySearchUnits")
public class ProductCategorySearchUnits extends ABCommonsService {

    public SelectPage<ProductCategory> search(OptType optType, ProductCategorySearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
        SelectPage<ProductCategory> selectPage = new SelectPage<ProductCategory>() ;

        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<ProductCategory> result = list(sqlWhere, value, startLimit) ;

        Long sum = sum(sqlWhere, value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }
    
    public List<ProductCategory> list(OptType optType, ProductCategorySearchBean searchBean, CommSearchBean commSearchBean, int... startLimit) throws SystemOptServiceException {
       
        Map<String, Object> value = ToolsUnits.createSearchMap() ;

        String sqlWhere = createWhere(value, searchBean, commSearchBean) ;

        List<ProductCategory> result = list(sqlWhere, value, startLimit) ;


        return result ;

    }
    
    

    private String sql = "select   productCategory  from  ProductCategory as  productCategory  " ;

    private List<ProductCategory> list(String sqlWhere, Map<String, Object> value, int... startLimit) throws SystemOptServiceException {
        String sql_ = sql + sqlWhere ;
        List<ProductCategory> result = baseService.findByHSQL(sql_, value, startLimit) ;
        return result ;
    }

    private String sqlsum = "select   count(productCategory.id)  from  ProductCategory as  productCategory " ;

    private Long sum(String sqlWhere, Map<String, Object> value) throws SystemOptServiceException {
        String sql_ = sqlsum + sqlWhere ;
        Long sum = baseService.findSinglenessByHSQL(sql_, value) ;
        return sum ;
    }

    private String createWhere(Map<String, Object> value, ProductCategorySearchBean searchBean, CommSearchBean commSearchBean) {
        String sqlWhere = " where     1 =1  " ;
        if (!searchBean.getStatus().equals(Status.全部)) {
            sqlWhere = sqlWhere + " and  productCategory.status ='" + searchBean.getStatus() + "'  " ;
        }
        if(ToolsUnits.isNOtNulll(searchBean.getName()))
        sqlWhere = sqlWhere + " and  productCategory.name  like '%" + searchBean.getName()+ "%'  " ;
        
        if(searchBean.getId() !=null )
            sqlWhere = sqlWhere + " or   productCategory.id  =" +searchBean.getId();
        
       
        return sqlWhere ;
    }

}
