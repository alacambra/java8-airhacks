package com.airhacks;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.validation.constraints.Size;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@RequestScoped
@Path("configuration")
public class ConfigurationResource {

    @Inject
    @Configured
    Instance<String> myScript;

    @GET
    public String script() {
        return myScript.get();
    }

    @POST
    public void save(@Size(min = 5) String script) {
        System.out.println("-- " + script);
    }

}
