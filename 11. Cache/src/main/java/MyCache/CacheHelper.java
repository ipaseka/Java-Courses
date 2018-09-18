package MyCache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;

public class CacheHelper {
    private static Cache cache;
    private static CacheManager cacheManager;
    static final String BASE_CACHE_NAME = "myCache";
    static final int BASE_LIFE_TIME = 5;

    public static Cache getCache() {
        if (cache == null)
            configurateBase();
        return cache;
    }

    public static CacheManager getCacheManager() {
        if(cacheManager == null)
            cacheManager = CacheManager.getInstance();
        return cacheManager;
    }
    public static void configurateBase() {
        configurateLifeCache(BASE_CACHE_NAME, BASE_LIFE_TIME);
    }
    public static void configurateLifeCache(String name, int lifeTime) {
        CacheConfiguration cacheConfiguration = new CacheConfiguration(name, 10);
        cacheConfiguration.memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.fromString("fifo"));
        cacheConfiguration.timeToLiveSeconds(lifeTime);

        cache = new Cache(cacheConfiguration);
        getCacheManager().addCache(cache);
    }

}
