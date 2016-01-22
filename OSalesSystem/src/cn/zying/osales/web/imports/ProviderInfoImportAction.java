package cn.zying.osales.web.imports ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zying.osales.imports.ABImportService ;
import cn.zying.osales.imports.ProviderInfoImportService ;
import cn.zying.osales.pojos.ProviderInfo ;
import cn.zying.osales.web.OSalesSystemABAction ;
import cn.zying.osales.web.aop.IAopProviderInfoService ;

@Component("ProviderInfoImportAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class ProviderInfoImportAction extends ImportServiceAction<ProviderInfo> {

    @Autowired
    @Qualifier(IAopProviderInfoService.name)
    private IAopProviderInfoService service ;

    private static final long serialVersionUID = 1720447471636256118L ;

    @Override
    protected ABImportService<ProviderInfo> instanceImportService() {

        return new ProviderInfoImportService(emf, cacheFactory, service) ;
    }

}
