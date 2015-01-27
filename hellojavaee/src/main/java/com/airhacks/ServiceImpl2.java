package com.airhacks;

/**
 *
 * @author airhacks.com
 */
public class ServiceImpl2 implements Service {

    @Override
    public void serveMe() {
        System.out.println("Another one!");
    }

    @Override
    public boolean isActive() {
        return true;
    }

}
