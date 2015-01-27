package com.airhacks;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

/**
 *
 * @author airhacks.com
 */
public class DeveloperService {

    public JsonArray all() {
        return Json
                .createArrayBuilder().
                add(create("age", 25)).
                add(create("age", 12)).build();

    }

    JsonObject create(String name, int age) {
        return Json.createObjectBuilder().add(name, age).build();
    }

}
