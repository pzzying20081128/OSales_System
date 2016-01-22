package cn.zying.osales.imports ;

import javax.persistence.EntityManagerFactory ;

import cn.zying.osales.imports.paser.PaserExcelUnits ;
import cn.zying.osales.imports.paser.ProviderInfoPaserExcelUnits ;
import cn.zying.osales.pojos.ProviderInfo ;
import cn.zying.osales.units.IPropertiesCacheFactory ;
import cn.zying.osales.web.aop.IAopProviderInfoService ;

public class ProviderInfoImportService extends ABImportService<ProviderInfo> {

    private IAopProviderInfoService service ;

    private ProviderInfoPaserExcelUnits providerInfoPaserExcelUnits ;

    public ProviderInfoImportService(EntityManagerFactory entityManagerFactory, IPropertiesCacheFactory cacheFactory,
            IAopProviderInfoService service) {
        super(entityManagerFactory, cacheFactory) ;
        this.service = service ;
        ProviderInfoPaserExcelUnits providerInfoPaserExcelUnits = new ProviderInfoPaserExcelUnits(entityManagerFactory, cacheFactory) ;
        providerInfoPaserExcelUnits.setService(service) ;
        this.providerInfoPaserExcelUnits = providerInfoPaserExcelUnits ;

    }

    @Override
    protected PaserExcelUnits<ProviderInfo> getPaserExcelUnits() {

        return providerInfoPaserExcelUnits ;
    }

}
