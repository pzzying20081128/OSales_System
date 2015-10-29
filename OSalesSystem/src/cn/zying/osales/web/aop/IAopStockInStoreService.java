package cn.zying.osales.web.aop ;

import cn.zying.osales.infaces.InfaceStockInStoreService ;
import cn.zying.osales.pojos.StockInStore ;
import cn.zying.osales.service.SystemOptServiceException ;

public interface IAopStockInStoreService extends InfaceStockInStoreService {

    public String name = "IAopStockInStoreService" ;

    public StockInStore searchStockInStoreDetails(Integer id) throws SystemOptServiceException ;

}
