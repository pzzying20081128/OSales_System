package cn.zying.osales.imports ;

import javax.persistence.EntityManagerFactory ;

import cn.zying.osales.imports.paser.PaserExcelUnits ;
import cn.zying.osales.pojos.ProductInfo ;
import cn.zying.osales.units.IPropertiesCacheFactory ;

public class ProductInfoImportService extends ABImportService<ProductInfo> {

    public ProductInfoImportService(EntityManagerFactory entityManagerFactory, IPropertiesCacheFactory cacheFactory) {
        super(entityManagerFactory, cacheFactory) ;
    }

    @Override
    protected PaserExcelUnits<ProductInfo> getPaserExcelUnits() {

        return null ;
    }

}
