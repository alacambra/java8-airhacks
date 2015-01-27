package com.airhacks;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class ReactiveTest {

    @Test
    public void reactive() {
        IntegerProperty result = new SimpleIntegerProperty();
        IntegerProperty a = new SimpleIntegerProperty(2);
        IntegerProperty b = new SimpleIntegerProperty(11);
        result.bind(a.multiply(b));
        result.addListener((observable, oldValue, newValue) -> {
            System.out.println("-- " + newValue);
        });
        a.set(4);
    }

    @Test
    public void objectBinding() {
        SimpleObjectProperty<String> holder = new SimpleObjectProperty<>();

    }

}
