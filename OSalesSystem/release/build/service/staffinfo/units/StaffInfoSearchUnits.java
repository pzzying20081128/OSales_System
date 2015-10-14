package  cn.zying.osales.service.basemanage.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;

import cn.zying.osales.pojos.StaffInfo ; 
import cn.zying.osales.service.ABCommonsService ;


@Component("StaffInfoSearchUnits")
public class StaffInfoSearchUnits extends ABCommonsService {

    public SelectPage<StaffInfo> search(OptType optType,
		                            StaffInfoSearchBean searchBean,CommSearchBean commSearchBean ,int... startLimit) throws SystemOptServiceException {
        SelectPage<StaffInfo> selectPage = new SelectPage<StaffInfo>() ;

		Map<String, Object> value=ToolsUnits.createSearchMap();
			
		 String sqlWhere=createWhere(value,searchBean,commSearchBean);
				
        List<StaffInfo> result = list(sqlWhere,value,startLimit) ;

        Long sum = sum(sqlWhere,value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }

	 private  String sql ="";   
    private List<StaffInfo> list(String sqlWhere ,Map<String, Object> value ,int... startLimit) throws SystemOptServiceException {
   String sql_ =sql+ sqlWhere ;
        List<StaffInfo>  result = baseService.findByHSQL(sql_, value, startLimit);
        return result;
    }
 private  String sqlsum ="";   
    private Long sum(String sqlWhere ,Map<String, Object> value) throws SystemOptServiceException {
 String sql_ =sqlsum+ sqlWhere ;
        Long  sum = baseService.findSinglenessByHSQL(sql_, value);
        return sum;
    }
	
	 private String createWhere(Map<String, Object> value,StaffInfoSearchBean searchBean ,CommSearchBean commSearchBean){
        String sqlWhere="";
        return sqlWhere;
    }

}
