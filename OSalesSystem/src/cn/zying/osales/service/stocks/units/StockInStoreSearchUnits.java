package  cn.zying.osales.service.stocks.units ;

import java.util.List ;
import java.util.Map ;

import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.CommSearchBean ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.web.SelectPage ;
import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.StockInStore ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;
import cn.zying.osales.units.search.bean.StockInStoreSearchBean ;


@Component("StockInStoreSearchUnits")
public class StockInStoreSearchUnits extends ABCommonsService {

    public SelectPage<StockInStore> search(OptType optType,
		                            StockInStoreSearchBean searchBean,CommSearchBean commSearchBean ,int... startLimit) throws SystemOptServiceException {
        SelectPage<StockInStore> selectPage = new SelectPage<StockInStore>() ;

		Map<String, Object> value=ToolsUnits.createSearchMap();
			
		 String sqlWhere=createWhere(value,searchBean,commSearchBean);
				
        List<StockInStore> result = list(sqlWhere,value,startLimit) ;

        Long sum = sum(sqlWhere,value) ;

        selectPage.setCount(sum) ;

        selectPage.setResult(result) ;

        return selectPage ;

    }
	
	
	    public List<StockInStore> list(OptType optType,
		                            StockInStoreSearchBean searchBean,CommSearchBean commSearchBean ,int... startLimit) throws SystemOptServiceException {
        SelectPage<StockInStore> selectPage = new SelectPage<StockInStore>() ;

		Map<String, Object> value=ToolsUnits.createSearchMap();
			
		 String sqlWhere=createWhere(value,searchBean,commSearchBean);
				
        List<StockInStore> result = list(sqlWhere,value,startLimit) ;

     

        return result ;

    }
	

	 private  String sql ="select  stockInStore   from  StockInStore as  stockInStore   inner join  fetch stockInStore.stockOrder     ";   
    private   List<StockInStore> list(String sqlWhere ,Map<String, Object> value ,int... startLimit) throws SystemOptServiceException {
   String sql_ =sql+ sqlWhere ;
        List<StockInStore>  result = baseService.findByHSQL(sql_, value, startLimit);
        return result;
    }
 private  String sqlsum =" select  count(stockInStore.id)   from  StockInStore as  stockInStore inner join   stockInStore.stockOrder  ";   
    private Long sum(String sqlWhere ,Map<String, Object> value) throws SystemOptServiceException {
 String sql_ =sqlsum+ sqlWhere ;
        Long  sum = baseService.findSinglenessByHSQL(sql_, value);
        return sum;
    }
	
	 private String createWhere(Map<String, Object> value,StockInStoreSearchBean searchBean ,CommSearchBean commSearchBean){
        String sqlWhere=" where  1 =1 ";
        if(searchBean.getStatus() ==null  || searchBean.getStatus().equals(Status.全部)){
            
        }else{
            sqlWhere = sqlWhere+"   and   stockInStore.status ='"+searchBean.getStatus()+"'  ";
        }
        return sqlWhere;
    }

}
