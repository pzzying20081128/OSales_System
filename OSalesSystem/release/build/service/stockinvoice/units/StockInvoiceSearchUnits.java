package  cn.zying.osales.service.stocks.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.web.SelectPage ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;

import cn.zying.osales.pojos.StockInvoice ; 
import cn.zying.osales.service.ABCommonsService ;


@Component("StockInvoiceSearchUnits")
public class StockInvoiceSearchUnits extends ABCommonsService {

    public SelectPage<StockInvoice> search(OptType optType,
		                            StockInvoiceSearchBean searchBean,CommSearchBean commSearchBean ,int... startLimit) throws SystemOptServiceException {
        SelectPage<StockInvoice> selectPage = new SelectPage<StockInvoice>() ;

		Map<String, Object> value=ToolsUnits.createSearchMap();
			
		 String sqlWhere=createWhere(value,searchBean,commSearchBean);
				
        List<StockInvoice> result = list(sqlWhere,value,startLimit) ;

        Long sum = sum(sqlWhere,value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }
	
	
	    public List<StockInvoice> list(OptType optType,
		                            StockInvoiceSearchBean searchBean,CommSearchBean commSearchBean ,int... startLimit) throws SystemOptServiceException {
        SelectPage<StockInvoice> selectPage = new SelectPage<StockInvoice>() ;

		Map<String, Object> value=ToolsUnits.createSearchMap();
			
		 String sqlWhere=createWhere(value,searchBean,commSearchBean);
				
        List<StockInvoice> result = list(sqlWhere,value,startLimit) ;

     

        return result ;

    }
	

	 private  String sql ="";   
    private   List<StockInvoice> list(String sqlWhere ,Map<String, Object> value ,int... startLimit) throws SystemOptServiceException {
   String sql_ =sql+ sqlWhere ;
        List<StockInvoice>  result = baseService.findByHSQL(sql_, value, startLimit);
        return result;
    }
 private  String sqlsum ="";   
    private Long sum(String sqlWhere ,Map<String, Object> value) throws SystemOptServiceException {
 String sql_ =sqlsum+ sqlWhere ;
        Long  sum = baseService.findSinglenessByHSQL(sql_, value);
        return sum;
    }
	
	 private String createWhere(Map<String, Object> value,StockInvoiceSearchBean searchBean ,CommSearchBean commSearchBean){
        String sqlWhere="";
        return sqlWhere;
    }

}
