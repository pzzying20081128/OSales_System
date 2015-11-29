package cn.zying.osales.units ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.beans.factory.annotation.Qualifier ;
import org.springframework.stereotype.Component ;

import cn.zy.apps.tools.units.AutoWriteObject ;
import cn.zy.apps.tools.units.PrpertiesSetValueService ;
import cn.zy.apps.tools.units.SimpleAutoWritePrpertiesObjectService ;
import cn.zy.apps.tools.units.ToolsUnitsException ;

@Component("PrpertiesAutoWriteObjectService")
public class PrpertiesAutoWriteObjectService extends SimpleAutoWritePrpertiesObjectService {

    @Autowired
    @Qualifier("SalesPrpertiesSetValueService")
    private SalesPrpertiesSetValueService salesPrpertiesSetValueService ;

    public static String regexPackage = "^cn.zying.osales(\\.\\D+)*(.pojos|.bean)$" ;

    private static String idfield = "id" ;

    private PropertiesAutoWriteObject demoAutoWriteObject ;

    public PrpertiesAutoWriteObjectService() {
        super(regexPackage, idfield) ;
        PropertiesAutoWriteObject demoAutoWriteObject = new PropertiesAutoWriteObject(regexPackage) ;
        this.demoAutoWriteObject = demoAutoWriteObject ;
    }

    @Override
    protected AutoWriteObject searchAutoWriteObject() {
        return demoAutoWriteObject ;
    }

    public void cacheObject(String key, Object object) {
        demoAutoWriteObject.cacheObject(key, object) ;
    }

    protected <V> V searchCacheObject(Object id, Class<V> cacheObject) throws ToolsUnitsException {

        return demoAutoWriteObject.searchCacheObject(id, cacheObject) ;

    }

    @Override
    protected PrpertiesSetValueService autoPrpertiesSetValueService() {

        return salesPrpertiesSetValueService ;
    }

    protected boolean isEqualsParents(Object child, Object parents) {

        Object id = readFieldValue(idfield, child) ;

        Object parentsId = readFieldValue(idfield, parents) ;

        return id.equals(parentsId) ;
    }

    public PropertiesAutoWriteObject getDemoAutoWriteObject() {
        return demoAutoWriteObject ;
    }

    public void setDemoAutoWriteObject(PropertiesAutoWriteObject demoAutoWriteObject) {
        this.demoAutoWriteObject = demoAutoWriteObject ;
    }

}
