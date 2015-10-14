package cn.zying.osales.service ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;


public abstract class ABCommonsService {
    
    @Autowired
    @Qualifier(IABService.name)
    protected IABService baseService;

    

}
