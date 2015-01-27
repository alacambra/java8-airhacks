package com.airhacks;

import javax.enterprise.inject.Produces;

/**
 *
 * @author airhacks.com
 */
public class StageProvider {

    @Produces
    public Stage current() {
        String configured = System.getProperty("stage", Stage.DEVELOPMENT.name());
        return Stage.valueOf(configured);
    }

}
