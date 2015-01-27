package com.airhacks.validation;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author airhacks.com
 */
public class PrerequisitesValidator implements ConstraintValidator<Prerequisites, Workshop> {

    private ScriptEngine engine;
    private Prerequisites annotation;

    @Override
    public void initialize(Prerequisites annotation) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        this.engine = scriptEngineManager.getEngineByName("javascript");
        this.annotation = annotation;
    }

    @Override
    public boolean isValid(Workshop workshop, ConstraintValidatorContext context) {
        this.engine.put("workshop", workshop);
        try {
            return (boolean) this.engine.eval(annotation.value());
        } catch (ScriptException ex) {
            throw new IllegalStateException("Cannot validated workshop", ex);
        }
    }
}
