package cn.zying.osales.units ;

import java.util.HashMap ;
import java.util.Map ;

import cn.zying.osales.pojos.ProductCategory ;
import cn.zying.osales.pojos.ProductInfo ;
import cn.zying.osales.pojos.StoreInfo ;
import cn.zying.osales.pojos.StorePosition ;
import cn.zying.osales.pojos.SysStaffUser ;

public class PropertiesCacheFactory implements IPropertiesCacheFactory {

    private Map<String, Object> aloneObjectCache = new HashMap<String, Object>() ;

    //一码多品
    private Map<String, Map<Integer, ProductInfo>> productInfoCache = new HashMap<String, Map<Integer, ProductInfo>>() ;

    @Override
    public void cacheObject(String key, Object object) {
        //        Loggerfactory.print("PropertiesAutoWriteObject   key " + key + "   object  " + object.toString()) ;
        if (object instanceof SysStaffUser) {
            cacheSysStaffUser((SysStaffUser) object) ;
        } else

        if (object instanceof ProductCategory) {
            cacheProductCategory(key, (ProductCategory) object) ;
        } else

        if (object instanceof StoreInfo) {
            cacheStoreInfo(key, (StoreInfo) object) ;
        } else

        if (object instanceof StorePosition) {
            cacheStorePosition(key, (StorePosition) object) ;
        } else if (object instanceof ProductInfo) {
            cacheProductInfo(key, (ProductInfo) object) ;
        }

        else {
            cacheAloneObject(key, object) ;
        }

    }

    private void cacheProductInfo(String key, ProductInfo object) {

        cacheAloneObject(key, object) ;

        String barCode = object.getBarCode() ;
        Map<Integer, ProductInfo> caches = productInfoCache.get(barCode) ;
        if (caches == null) {
            caches = new HashMap<Integer, ProductInfo>() ;
            productInfoCache.put(barCode, caches) ;
        }
        caches.put(object.getId(), object) ;

    }

    private void cacheAloneObject(String key, Object object) {
        String key_ = createAloneObjectKey(key, object.getClass()) ;
        aloneObjectCache.put(key_, object) ;
    }

    private void cacheStorePosition(String key, StorePosition object) {
        String key_ = createAloneObjectKey(key, StorePosition.class) ;
        aloneObjectCache.put(key_, object) ;
    }

    private void cacheStoreInfo(String key, StoreInfo object) {
        String key_ = createAloneObjectKey(key, StoreInfo.class) ;
        aloneObjectCache.put(key_, object) ;

    }

    private void cacheProductCategory(String key, ProductCategory productCategory) {
        String key_ = createAloneObjectKey(key, ProductCategory.class) ;
        aloneObjectCache.put(key_, productCategory) ;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <V> V searchCacheObject(String key, Class<V> clazz) {

        return (V) searchAloneObject(key, clazz) ;
    }

    private Object searchAloneObject(String key, Class<?> clazz) {
        String keys = createAloneObjectKey(key, clazz) ;
        //        System.out.println("================= searchAloneObject  > keys  " + keys + "         clazz    " + clazz.getClass().getSimpleName()) ;
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
