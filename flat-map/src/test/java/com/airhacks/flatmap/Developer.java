package com.airhacks.flatmap;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author airhacks.com
 */
public class Developer {

    private String name;
    private Set<String> languages;

    public Developer(String name) {
        this.languages = new HashSet<>();
        this.name = name;
    }

    public void add(String language) {
        this.languages.add(language);
    }

    public Set<String> getLanguages() {
        return languages;
    }
}
