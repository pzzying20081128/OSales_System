package  cn.zying.osales.service.sysmanage.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;

import cn.zying.osales.pojos.SystemUser ; 
import cn.zying.osales.service.ABCommonsService ;


@Component("SystemUserSearchUnits")
public class SystemUserSearchUnits extends ABCommonsService {

    public SelectPage<SystemUser> search(OptType optType,
		                            SystemUserSearchBean searchBean,CommSearchBean commSearchBean ,int... startLimit) throws SystemOptServiceException {
        SelectPage<SystemUser> selectPage = new SelectPage<SystemUser>() ;

		Map<String, Object> value=ToolsUnits.createSearchMap();
			
		 String sqlWhere=createWhere(value,searchBean,commSearchBean);
				
        List<SystemUser> result = list(sqlWhere,value,startLimit) ;

        Long sum = sum(sqlWhere,value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

	 private  String sql ="";   
    private List<SystemUser> list(String sqlWhere ,Map<String, Object> value ,int... startLimit) throws SystemOptServiceException {
   String sql_ =sql+ sqlWhere ;
        List<SystemUser>  result = baseService.findByHSQL(sql_, value, startLimit);
        return result;
    }
 private  String sqlsum ="";   
    private Long sum(String sqlWhere ,Map<String, Object> value) throws SystemOptServiceException {
 String sql_ =sqlsum+ sqlWhere ;
        Long  sum = baseService.findSinglenessByHSQL(sql_, value);
        return sum;
    }
	
	 private String createWhere(Map<String, Object> value,SystemUserSearchBean searchBean ,CommSearchBean commSearchBean){
        String sqlWhere="";
        return sqlWhere;
    }

}
