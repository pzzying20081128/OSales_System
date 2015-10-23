package  cn.zying.osales.service.baseinfo.units ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.OSalesConfigProperties.OptType ;
import cn.zying.osales.OSalesConfigProperties.Status ;
import cn.zying.osales.pojos.ProviderInfo ;
import cn.zying.osales.service.ABCommonsService ;
import cn.zying.osales.service.SystemOptServiceException ;


@Component("ProviderInfoRemoveUnits")
public class ProviderInfoRemoveUnits extends ABCommonsService {

    public ProviderInfo  remove(OptType optType, ProviderInfo  optProviderInfo ) throws SystemOptServiceException {
        
         Integer id =optProviderInfo.getId() ;
        ProviderInfo   removeProviderInfo =baseService.get(id, ProviderInfo.class);
        removeProviderInfo.setStatus(Status.删除);
        baseService.update(removeProviderInfo);
        return  removeProviderInfo ;
    }

}
