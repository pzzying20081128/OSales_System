package cn.zying.osales.service ;

import javax.annotation.Resource ;

public abstract class ABCommonsService implements ICommonsService {

    @Resource(name = IERPBaseService.name)
    protected IERPBaseService baseService ;

    public void setBaseService(IERPBaseService baseService) {
        this.baseService = baseService ;
    }

}
