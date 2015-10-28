package cn.zying.osales.units ;

import javax.persistence.Table ;

import cn.zy.apps.tools.units.AutoWriteObject ;
import cn.zy.apps.tools.units.ToolsUnits ;
import cn.zy.apps.tools.units.ToolsUnitsException ;
import cn.zying.osales.pojos.SysStaffUser ;

public class PropertiesAutoWriteObject extends AutoWriteObject {

    protected IPropertiesCacheFactory cacheFactory = new PropertiesCacheFactory() ;

    public void cacheObject(String key, Object object) {

        cacheFactory.cacheObject(key, object) ;
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

        if (result == true) {
            //SysStaffUser
            {
                Table table = classes.getAnnotation(Table.class) ;
                if (table != null) {
                    String name = table.name() ;
                    if (name.startsWith("base_")) result = true ;
                    else
                        result = false ;
                }
            }

        }
        if (result == false) {
            result = filterClass(classes) ;
        }
        return result ;
    }

    private boolean filterClass(Class<?> classes) {
        boolean result = classes.equals(SysStaffUser.class) ;
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
