package com.airhacks.jcache;

import javax.cache.processor.EntryProcessor;
import javax.cache.processor.EntryProcessorException;
import javax.cache.processor.MutableEntry;

/**
 *
 * @author airhacks.com
 */
public class WorkshopValidator implements EntryProcessor<String, Registration, Boolean> {

    @Override
    public Boolean process(MutableEntry<String, Registration> entry, Object... arguments) throws EntryProcessorException {
        String argument = (String) arguments[0];
        System.out.println("Got parameter: " + argument);
        Registration registration = entry.getValue();
        return registration.getDays() > 0;
    }

}
