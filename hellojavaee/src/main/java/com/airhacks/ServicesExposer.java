package com.airhacks;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
public class ServicesExposer {

    @Inject
    Instance<Service> services;

    @Produces
    public List<Service> all() {
        return StreamSupport.stream(services.spliterator(), false).
                filter(s -> s.isActive()).
                collect(Collectors.toList());
    }

}
