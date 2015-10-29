package cn.zying.osales.service ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;

import cn.zying.osales.units.PrpertiesAutoWriteObjectService ;

public abstract class ABCommonsService {

    @Autowired
    @Qualifier(IABService.name)
    protected IABService baseService ;

    @Autowired
    @Qualifier("PrpertiesAutoWriteObjectService")
    protected PrpertiesAutoWriteObjectService prpertiesAutoWriteObjectService ;

}
