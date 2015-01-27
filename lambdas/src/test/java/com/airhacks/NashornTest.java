package com.airhacks;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class NashornTest {

    private ScriptEngine engine;

    @Before
    public void initEngine() {
        ScriptEngineManager sem = new ScriptEngineManager();
        this.engine = sem.getEngineByName("javascript");
    }

    @Test
    public void bootAndUse() throws ScriptException {
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");
        assertNotNull(engine);
        final String name = engine.getClass().getName();
        System.out.println("-- " + name);
        assertTrue(name.toLowerCase().contains("nashorn"));
        engine.put("duke", new Developer("duke", "nashorn", 3));

        Integer result = (Integer) engine.eval("2 * 3 + duke.age");
        assertThat(result, is(6));
    }

    @Test
    public void jsInterfaces() throws ScriptException {
        Runnable runnable = getRunnable();
        assertNotNull(runnable);
        runnable.run();
        System.out.println("runnable = " + runnable);
    }

    public Runnable getRunnable() throws ScriptException {
        Invocable invocable = (Invocable) this.engine;
        this.engine.eval("function run(){ print('Here is JavaScript');}");
        return invocable.getInterface(Runnable.class);
    }

}
