package com.airhacks.jcache;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author airhacks.com
 */
public class Registration implements Serializable {

    private String name;
    private int days;

    public Registration(String name, int days) {
        this.name = name;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public int getDays() {
        return days;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + this.days;
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
        final Registration other = (Registration) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.days != other.days) {
            return false;
        }
        return true;
    }

}
