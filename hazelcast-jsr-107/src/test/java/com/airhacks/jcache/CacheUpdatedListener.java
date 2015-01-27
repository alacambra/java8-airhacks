package com.airhacks.jcache;

import javax.cache.event.CacheEntryEvent;
import javax.cache.event.CacheEntryListenerException;
import javax.cache.event.CacheEntryUpdatedListener;

/**
 *
 * @author airhacks.com
 */
public class CacheUpdatedListener implements CacheEntryUpdatedListener<String, Registration> {

    @Override
    public void onUpdated(Iterable<CacheEntryEvent<? extends String, ? extends Registration>> events) throws CacheEntryListenerException {
        events.forEach((t) -> {
            System.out.println("CacheEntryEvent = " + t);
        });
    }

}
