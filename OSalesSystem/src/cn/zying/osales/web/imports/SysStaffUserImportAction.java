package cn.zying.osales.web.imports ;

import org.springframework.stereotype.Component ;

import cn.zying.osales.imports.ABImportService ;
import cn.zying.osales.imports.SysStaffUserImportService ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.web.OSalesSystemABAction ;

@Component("SysStaffUserImportAction")
@org.springframework.context.annotation.Scope(OSalesSystemABAction.Scope)
public class SysStaffUserImportAction extends ImportServiceAction<SysStaffUser> {

    private static final long serialVersionUID = -4616733048843623325L ;

    @Override
    protected ABImportService<SysStaffUser> instanceImportService() {

        return new SysStaffUserImportService(emf, cacheFactory) ;

    }

}
