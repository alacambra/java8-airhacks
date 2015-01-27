package com.airhacks;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author airhacks.com
 */
public class SlowMessageProducer {

    public static String getMessageSlowly() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            Logger.getLogger(SlowMessageProducer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "slow " + new Date();
    }
}
