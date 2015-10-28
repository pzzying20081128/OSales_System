package cn.zying.osales.units ;


public interface IPropertiesCacheFactory {

    public void cacheObject(String key ,Object object) ;

    public <V> V searchCacheObject(String key, Class<V> object) ;
    

    
        

}
