package com.airhacks.el;

import java.util.Map;
import java.util.Set;
import javax.el.ELProcessor;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author adam-bien.com
 */
public class ELTest {

    private ELProcessor cut;

    @Before
    public void init() {
        this.cut = new ELProcessor();
    }

    @Test
    public void formula() {
        Long result = (Long) this.cut.eval("2*2");
        assertThat(result, is(4l));
    }

    @Test
    public void bean() {
        Workshop workshop = new Workshop("javaee airhacks");
        this.cut.defineBean("workshop", workshop);
        String title = (String) this.cut.eval("workshop.title");
        assertThat(title, is(workshop.getTitle()));
    }

    @Test
    public void listLiteral() {
        String listLiteral = "{1,2,3}";
        Set<Integer> list = (Set<Integer>) this.cut.eval(listLiteral);
        assertFalse(list.isEmpty());
        System.out.println("List: " + list);
    }

    @Test
    public void mapLiteral() {
        String listLiteral = "{\"one\":1,\"two\":2,\"three\":3}";
        Map<String, Long> map = (Map<String, Long>) this.cut.eval(listLiteral);
        assertFalse(map.isEmpty());
        System.out.println("Map: " + map);
    }
    
    @Test
    public void lambda(){
        Object result = this.cut.eval("[1,2,3,4,5,6,7,8].stream().filter(i->i%2 == 0).map(i->i*10).toList()");
        assertNotNull(result);
        System.out.println("Result: " + result);
        result = this.cut.eval("[1,5,3,7,4,2,8].stream().sorted((i,j)->j-i).toList()");
        System.out.println("Result: " + result);
    }

}
