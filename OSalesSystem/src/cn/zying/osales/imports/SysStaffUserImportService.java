package cn.zying.osales.imports ;

import javax.persistence.EntityManagerFactory ;

import cn.zying.osales.imports.paser.PaserExcelUnits ;
import cn.zying.osales.imports.paser.SysStaffUserPaserExcelUnits ;
import cn.zying.osales.pojos.SysStaffUser ;
import cn.zying.osales.units.IPropertiesCacheFactory ;

public class SysStaffUserImportService extends ABImportService<SysStaffUser> {

    private SysStaffUserPaserExcelUnits sysStaffUserPaserExcelUnits ;

    public SysStaffUserImportService(EntityManagerFactory entityManagerFactory, IPropertiesCacheFactory cacheFactory) {
        super(entityManagerFactory, cacheFactory) ;
        SysStaffUserPaserExcelUnits sysStaffUserPaserExcelUnits = new SysStaffUserPaserExcelUnits(entityManagerFactory, cacheFactory) ;
        this.sysStaffUserPaserExcelUnits = sysStaffUserPaserExcelUnits ;
    }

    @Override
    protected PaserExcelUnits<SysStaffUser> getPaserExcelUnits() {

        return sysStaffUserPaserExcelUnits ;
    }

}
