package com.airhacks.jcache;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.FactoryBuilder;
import javax.cache.configuration.MutableCacheEntryListenerConfiguration;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class JSR107Test {

    private Cache<String, Registration> workshopsCache;
    private CachingProvider cachingProvider;
    private CacheManager cacheManager;
    static final String CACHE_NAME = "workshops";

    @Before
    public void initialize() {
        this.cachingProvider = Caching.getCachingProvider();
        this.cacheManager = cachingProvider.getCacheManager();
        MutableConfiguration<String, Registration> configuration = new MutableConfiguration<>();

        configuration.setStoreByValue(false).
                setTypes(String.class, Registration.class).
                setManagementEnabled(true);

        this.workshopsCache = cacheManager.
                createCache(CACHE_NAME, configuration);
    }

    @Test
    public void crud() {
        final Registration actual = new Registration("bootstrap", 2);
        workshopsCache.put("1", actual);
        Registration received = workshopsCache.get("1");
        assertThat(received, is(actual));
    }

    @Test
    public void cacheNames() {
        Iterable<String> names = this.cacheManager.getCacheNames();
        final String cacheName = names.iterator().next();
        assertThat(cacheName, is(CACHE_NAME));
    }

    @Test
    public void events() {
        final MutableCacheEntryListenerConfiguration listenerConfiguration
                = new MutableCacheEntryListenerConfiguration(FactoryBuilder.factoryOf(CacheUpdatedListener.class), null, true, true);
        this.workshopsCache.registerCacheEntryListener(listenerConfiguration);
    }

    @Test
    public void codeExecution() {
        final String valid = "1";
        final String invalid = "2";
        final Registration validValue = new Registration("bootstrap", 2);
        final Registration invalidValue = new Registration("gwt", 0);

        workshopsCache.put(valid, validValue);
        workshopsCache.put(invalid, invalidValue);

        Boolean result = this.workshopsCache.invoke(valid, new WorkshopValidator(), "sample parameter");
        assertTrue(result);

        result = this.workshopsCache.invoke(invalid, new WorkshopValidator(), "sample parameter");
        assertFalse(result);

    }

    @After
    public void cleanup() {
        this.cachingProvider.close();
    }

}
