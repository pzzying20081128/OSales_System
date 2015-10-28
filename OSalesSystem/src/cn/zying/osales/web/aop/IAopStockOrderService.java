 package  cn.zying.osales.web.aop;

 
 
 import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.infaces.InfaceStockOrderService ;
import cn.zying.osales.pojos.StockOrder ;
import cn.zying.osales.service.SystemOptServiceException ;

public interface IAopStockOrderService  extends InfaceStockOrderService   {
    
            public String name="IAopStockOrderService";
            
            
            public StockOrder   saveUpdate(OptType  optType ,   StockOrder   optStockOrder ,int optUserId )throws SystemOptServiceException;
            
                
            
            
       
            

}
