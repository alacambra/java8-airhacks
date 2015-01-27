package com.airhacks.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author airhacks.com
 */
@Documented
@Constraint(validatedBy = PrerequisitesValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Prerequisites {

    String message() default "Workshop cannot take place";

    String value();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
