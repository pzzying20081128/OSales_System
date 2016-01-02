 package  cn.zying.osales.service.stocks;

 
 
 import java.util.List ;

import cn.zying.osales.infaces.InfaceStockAdjustBillService ;
import cn.zying.osales.service.SystemOptServiceException ;

public interface IStockAdjustBillService  extends InfaceStockAdjustBillService { 
    
            public String name="IStockAdjustBillService";
            
                
        
            
            public List<String>searchAdjustSubject(String adjustSubject , int... startLimit)throws SystemOptServiceException;
            

}
