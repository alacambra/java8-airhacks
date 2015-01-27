package com.airhacks;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.ejb.Stateless;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Path("services")
public class ServicesResource {

    @Inject
    Instance<Service> services;

    @GET
    public String all() {
        return StreamSupport.stream(services.spliterator(), false).
                filter(s -> s.isActive()).
                map(s -> s.getClass().
                        getName()).collect(Collectors.joining(","));

    }
}
