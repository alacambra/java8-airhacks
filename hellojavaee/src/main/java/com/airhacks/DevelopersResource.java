package com.airhacks;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Path("developers")
public class DevelopersResource {

    @Inject
    DeveloperService ds;

    @Resource
    ManagedExecutorService mes;

    @GET
    public void all(@Suspended AsyncResponse ar) {
        ar.setTimeout(2, TimeUnit.SECONDS);
        ar.setTimeoutHandler((resp) -> {
            //handle timeout here
        });
        CompletableFuture.supplyAsync(ds::all, mes).
                thenAccept(ar::resume)
                .exceptionally((t) -> {
                    Response res = Response.status(Response.Status.INTERNAL_SERVER_ERROR).
                    header("x-reason", t.getMessage()).build();
                    ar.resume(res);
                    return null;
                });
    }

}
