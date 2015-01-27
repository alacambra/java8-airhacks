package com.airhacks.plainjpa;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 *
 * @author adam-bien.com
 */
@Entity
public class Spaceship {

    @Id
    private long id;
    private String name;
    private int speed;
    private LocalDate arrival;
    @Version
    private long version;

    public Spaceship(long id, String name, int speed, LocalDate arrival) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.arrival = arrival;
    }

    public Spaceship() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getVersion() {
        return version;
    }

    public LocalDate getArrival() {
        return arrival;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 61 * hash + Objects.hashCode(this.name);
        hash = 61 * hash + this.speed;
        hash = 61 * hash + Objects.hashCode(this.arrival);
        hash = 61 * hash + (int) (this.version ^ (this.version >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Spaceship other = (Spaceship) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.speed != other.speed) {
            return false;
        }
        if (!Objects.equals(this.arrival, other.arrival)) {
            return false;
        }
        if (this.version != other.version) {
            return false;
        }
        return true;
    }

}
