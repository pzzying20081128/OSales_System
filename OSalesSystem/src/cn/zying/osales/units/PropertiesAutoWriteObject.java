package cn.zying.osales.units ;

import cn.zy.apps.tools.units.AutoWriteObject ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.units.ToolsUnitsException ;

public class PropertiesAutoWriteObject extends AutoWriteObject {

    protected IPropertiesCacheFactory cacheFactory = new PropertiesCacheFactory() ;

    public void cacheObject(String key, Object object) {
       
        cacheFactory.cacheObject( key,object) ;
    }

    private String regexPackage ;

    public PropertiesAutoWriteObject(String regexPackage) {
        super() ;
        this.regexPackage = regexPackage ;
    }

    @Override
    protected String getFieldOfFieldId(String fieldName) {

        return fieldName + "Id" ;
    }

    @Override
    protected boolean filterSetProperties(Class<?> classes) {

        boolean result = ToolsUnits.regex(regexPackage, classes.getPackage().getName()) ;

        return result ;
    }

    @Override
    protected <V> V searchCacheObject(Object id, Class<V> cacheObject) throws ToolsUnitsException {

        String key = null ;

        if (id instanceof String) {
            key = (String) id ;
        } else if (id instanceof Integer) {
            key = ((Integer) id).toString() ;
        }
        if (key == null) throw new ToolsUnitsException("search   cache key error : " + key) ;
        return cacheFactory.searchCacheObject(id.toString(), cacheObject) ;

    }

}
