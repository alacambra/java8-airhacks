package com.airhacks;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class SerializationTest {

    @Test
    public void serialization() {
        JsonObject json = Json.createObjectBuilder().add("hey", "joe").build();
        JsonWriter writer = Json.createWriter(System.out);
        writer.write(json);
        writer.close();
    }

}
