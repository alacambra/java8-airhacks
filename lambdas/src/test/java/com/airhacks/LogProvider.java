package com.airhacks;

import java.util.function.Consumer;
import java.util.logging.Logger;

/**
 *
 * @author airhacks.com
 */
public class LogProvider {

    public static Consumer<String> get() {
        return new Consumer<String>() {

            @Override
            public void accept(String t) {
                Logger.getGlobal().info(t);
            }
        };
    }

}
