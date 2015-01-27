package com.airhacks;

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
@Path("configuration")
public class ConfigurationResource {

    @Inject
    @Configured
    Instance<String> myScript;

    @GET
    public String script() {
        return myScript.get();
    }

}
