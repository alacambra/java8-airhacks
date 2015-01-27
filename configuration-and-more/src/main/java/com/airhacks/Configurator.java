package com.airhacks;

import java.util.Date;
import java.util.Optional;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author airhacks.com
 */
public class Configurator {

    @Produces
    @Configured
    public String lookup(InjectionPoint ip) {
        String className = ip.getMember().getDeclaringClass().getName();
        String key = ip.getMember().getName();
        return key + "->" + className + " " + new Date();
    }

    @Produces
    public Integer lookupInt(InjectionPoint ip) {
        String number = Optional.ofNullable(lookup(ip)).orElse("0");
        return Integer.parseInt(number);
    }

}
