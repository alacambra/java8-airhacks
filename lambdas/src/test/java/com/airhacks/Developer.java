package com.airhacks;

/**
 *
 * @author airhacks.com
 */
public class Developer {

    private String name;
    private String language;
    private int age;

    public Developer(String name, String language, int age) {
        this.name = name;
        this.language = language;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public int getAge() {
        return age;
    }

}
