package  cn.zying.osales.service.baseinfo.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.ProductBrand ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.ProductBrandSearchBean ;


@Component("ProductBrandSearchUnits")
public class ProductBrandSearchUnits extends ABCommonsService {

    public SelectPage<ProductBrand> search(OptType optType,
		                            ProductBrandSearchBean searchBean,CommSearchBean commSearchBean ,int... startLimit) throws SystemOptServiceException {
        if(searchBean==null)searchBean=new ProductBrandSearchBean();
        SelectPage<ProductBrand> selectPage = new SelectPage<ProductBrand>() ;

		Map<String, Object> value=ToolsUnits.createSearchMap();
			
		 String sqlWhere=createWhere(value,searchBean,commSearchBean);
				
        List<ProductBrand> result = list(sqlWhere,value,startLimit) ;

        Long sum = sum(sqlWhere,value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

	 private  String sql ="select productBrand  from  ProductBrand as  productBrand  ";   
    private List<ProductBrand> list(String sqlWhere ,Map<String, Object> value ,int... startLimit) throws SystemOptServiceException {
   String sql_ =sql+ sqlWhere ;
        List<ProductBrand>  result = baseService.findByHSQL(sql_, value, startLimit);
        return result;
    }
 private  String sqlsum ="select count(productBrand.id)  from  ProductBrand as  productBrand";   
    private Long sum(String sqlWhere ,Map<String, Object> value) throws SystemOptServiceException {
 String sql_ =sqlsum+ sqlWhere ;
        Long  sum = baseService.findSinglenessByHSQL(sql_, value);
        return sum;
    }
	
	 private String createWhere(Map<String, Object> value,ProductBrandSearchBean searchBean ,CommSearchBean commSearchBean){
        String sqlWhere=" where  1=1 ";
        
        
        if(searchBean.getStatus()==null ){
            sqlWhere  = sqlWhere+"   and  productBrand.status ='"+Status.有效+"' ";
        }else
            if(searchBean.getStatus().equals(Status.全部) ){
//            sqlWhere  = sqlWhere+"   and  productBrand.status ='"+searchBean.getStatus()+"' ";
        }else{
            sqlWhere  = sqlWhere+"   and  productBrand.status ='"+searchBean.getStatus()+"' ";
        }
        return sqlWhere;
    }

}
