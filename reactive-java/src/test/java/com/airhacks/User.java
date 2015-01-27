package com.airhacks;

import javafx.beans.property.StringProperty;

/**
 *
 * @author airhacks.com
 * @Entity
 */
public class User {

    private StringProperty name;

    //@Id
    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }
}
