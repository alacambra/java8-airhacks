package com.airhacks.plainjpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 *
 * @author adam-bien.com
 */
@Entity
@NamedQuery(name = Spaceship.findAll, query = "SELECT s from Spaceship s")
public class Spaceship {

    @Id
    private String name;
    private int speed;
    private boolean hyperspeed;

    public final static String findAll = "com.airhacks.plainjpa.Spaceship.all";

    public Spaceship() {
    }

    public Spaceship(String name, int speed, boolean hyperspeed) {
        this.name = name;
        this.speed = speed;
        this.hyperspeed = hyperspeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isHyperspeed() {
        return hyperspeed;
    }

    public void setHyperspeed(boolean hyperspeed) {
        this.hyperspeed = hyperspeed;
    }

    @Override
    public String toString() {
        return "Spaceship{" + "name=" + name + ", speed=" + speed + ", hyperspeed=" + hyperspeed + '}';
    }

}
