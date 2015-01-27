package com.airhacks;

/**
 *
 * @author airhacks.com
 */
public class ServiceImpl implements Service {

    @Override
    public void serveMe() {
        System.out.println("Extensible!");
    }

    @Override
    public boolean isActive() {
        return false;
    }

}
