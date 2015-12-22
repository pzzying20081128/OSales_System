package  cn.zying.osales.service.baseinfo.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;

import cn.zying.osales.pojos.CompanyInfo ; 
import cn.zying.osales.service.ABCommonsService ;


@Component("CompanyInfoSearchUnits")
public class CompanyInfoSearchUnits extends ABCommonsService {

    public SelectPage<CompanyInfo> search(OptType optType,
		                            CompanyInfoSearchBean searchBean,CommSearchBean commSearchBean ,int... startLimit) throws SystemOptServiceException {
        SelectPage<CompanyInfo> selectPage = new SelectPage<CompanyInfo>() ;

		Map<String, Object> value=ToolsUnits.createSearchMap();
			
		 String sqlWhere=createWhere(value,searchBean,commSearchBean);
				
        List<CompanyInfo> result = list(sqlWhere,value,startLimit) ;

        Long sum = sum(sqlWhere,value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }
	
	
	    public List<CompanyInfo> list(OptType optType,
		                            CompanyInfoSearchBean searchBean,CommSearchBean commSearchBean ,int... startLimit) throws SystemOptServiceException {
        SelectPage<CompanyInfo> selectPage = new SelectPage<CompanyInfo>() ;

		Map<String, Object> value=ToolsUnits.createSearchMap();
			
		 String sqlWhere=createWhere(value,searchBean,commSearchBean);
				
        List<CompanyInfo> result = list(sqlWhere,value,startLimit) ;

     

        return result ;

    }
	

	 private  String sql ="";   
    private   List<CompanyInfo> list(String sqlWhere ,Map<String, Object> value ,int... startLimit) throws SystemOptServiceException {
   String sql_ =sql+ sqlWhere ;
        List<CompanyInfo>  result = baseService.findByHSQL(sql_, value, startLimit);
        return result;
    }
 private  String sqlsum ="";   
    private Long sum(String sqlWhere ,Map<String, Object> value) throws SystemOptServiceException {
 String sql_ =sqlsum+ sqlWhere ;
        Long  sum = baseService.findSinglenessByHSQL(sql_, value);
        return sum;
    }
	
	 private String createWhere(Map<String, Object> value,CompanyInfoSearchBean searchBean ,CommSearchBean commSearchBean){
        String sqlWhere="";
        return sqlWhere;
    }

}
