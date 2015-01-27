package com.airhacks;

import java.util.function.Consumer;
import java.util.logging.Logger;

/**
 *
 * @author airhacks.com
 */
public class LogProvider {

    public static Consumer<String> get() {
        return Logger.getGlobal()::info;
    }

}
