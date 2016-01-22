package cn.zying.osales.imports ;

import java.io.File ;

import javax.persistence.EntityManagerFactory ;

import cn.zying.osales.imports.paser.ImportServiceResult ;
import cn.zying.osales.imports.paser.PaserExcelUnits ;
import cn.zying.osales.units.IPropertiesCacheFactory ;

public abstract class ABImportService<V> implements ImportService<V> {

    protected EntityManagerFactory entityManagerFactory ;

    protected IPropertiesCacheFactory cacheFactory ;

    protected abstract PaserExcelUnits<V> getPaserExcelUnits() ;

    public ABImportService(EntityManagerFactory entityManagerFactory, IPropertiesCacheFactory cacheFactory) {
        super() ;
        this.entityManagerFactory = entityManagerFactory ;
        this.cacheFactory = cacheFactory ;
    }

    @Override
    public ImportServiceResult<V> imports(File file) throws ImportServiceException {
        PaserExcelUnits<V> units = getPaserExcelUnits() ;
        return units.paserExcel(file) ;
    }

}
