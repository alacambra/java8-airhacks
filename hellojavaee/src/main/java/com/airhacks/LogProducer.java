package com.airhacks;

import java.util.function.Consumer;
import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author airhacks.com
 */
public class LogProducer {

    @Produces
    @Info
    public Consumer<String> info(InjectionPoint ip, Stage stage) {
        return Logger.getLogger(stage + "--" + ip.getMember().getDeclaringClass().
                getName())::info;
    }

}
