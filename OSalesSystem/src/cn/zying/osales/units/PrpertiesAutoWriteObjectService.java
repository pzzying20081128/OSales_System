package cn.zying.osales.units ;

import cn.zy.apps.tools.units.AutoWriteObject ;
import cn.zy.apps.tools.units.SimpleAutoWritePrpertiesObjectService ;

public class PrpertiesAutoWriteObjectService extends SimpleAutoWritePrpertiesObjectService {

    public static String regexPackage = "^cn.zying.osales(\\.\\D+)*(.pojos|.bean)$" ;

    private static String idfield = "id" ;

    private PropertiesAutoWriteObject demoAutoWriteObject ;

    public PrpertiesAutoWriteObjectService() {
        super(regexPackage, idfield) ;
        PropertiesAutoWriteObject demoAutoWriteObject = new PropertiesAutoWriteObject(regexPackage) ;
        this.demoAutoWriteObject = demoAutoWriteObject;
    }

    @Override
    protected AutoWriteObject searchAutoWriteObject() {
        return demoAutoWriteObject ;
    }
    
    public void cacheObject(String key, Object object) {
        demoAutoWriteObject.cacheObject(key,object) ;
    }


}
