package com.airhacks;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
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
    List<Service> services;

    @Inject
    @Info
    Consumer<String> LOG;

    @GET
    public String all() {
        LOG.accept("In method all");
        return services.stream().
                map(s -> s.getClass().getName()).
                collect(Collectors.joining(","));

    }
}
