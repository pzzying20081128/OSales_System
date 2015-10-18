package cn.zying.osales.units ;

import java.util.HashMap ;
import java.util.Map ;

import cn.zying.osales.pojos.SysStaffUser ;

public class PropertiesCacheFactory implements IPropertiesCacheFactory {

    private Map<String, Object> aloneObjectCache = new HashMap<String, Object>() ;

    @Override
    public void cacheObject(Object object) {
        if (object instanceof SysStaffUser) {
            cacheSysStaffUser((SysStaffUser) object) ;
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public <V> V searchCacheObject(String key, Class<V> clazz) {
        return (V) searchAloneObject(key, clazz) ;
    }

    private Object searchAloneObject(String key, Class<?> clazz) {
        String keys = createAloneObjectKey(key, clazz) ;
        return aloneObjectCache.get(keys) ;
    }

    private String createAloneObjectKey(String key, Class<?> clazz) {
        return clazz.getSimpleName() + "_id_" + key ;
    }

    private void cacheSysStaffUser(SysStaffUser sysStaffUser) {
        String key = createAloneObjectKey(sysStaffUser.getId().toString(), SysStaffUser.class) ;
        aloneObjectCache.put(key, sysStaffUser) ;
    }
}
