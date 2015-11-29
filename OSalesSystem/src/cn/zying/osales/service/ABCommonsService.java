package cn.zying.osales.service ;

import org.apache.log4j.Logger ;
import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;

import cn.zy.apps.tools.logger.Loggerfactory ;
import cn.zying.osales.pojos.StoreInfo ;
import cn.zying.osales.pojos.StorePosition ;
import cn.zying.osales.storage.IInStoreProductInfoStockService ;
import cn.zying.osales.units.PrpertiesAutoWriteObjectService ;

public abstract class ABCommonsService {
    
    protected  Logger  logger = Loggerfactory.instance("service");

    @Autowired
    @Qualifier(IABService.name)
    protected IABService baseService ;

    @Autowired
    @Qualifier("PrpertiesAutoWriteObjectService")
    protected PrpertiesAutoWriteObjectService prpertiesAutoWriteObjectService ;
    
    @Autowired
    @Qualifier(IInStoreProductInfoStockService.name)
    protected IInStoreProductInfoStockService storeProductInfoStockService ;
    
    protected StoreInfo  loadStore(Integer id){
         return   baseService.load(id, StoreInfo.class);
    }
    
    protected StorePosition  loadStorePosition(Integer id){
        return   baseService.load(id, StorePosition.class);
   }

}
