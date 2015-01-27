package com.airhacks.validation;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class ValidationWithNashornTest {

    private Validator validator;

    @Before
    public void init() {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        this.validator = vf.getValidator();
    }

    @Test
    public void prereqsMet() {
        Workshop validWorkshop = new Workshop(2, 2, true, 3);
        Set<ConstraintViolation<Workshop>> violations = this.validator.validate(validWorkshop);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void roomTooSmall() {
        Workshop validWorkshop = new Workshop(5, 2, true, 3);
        Set<ConstraintViolation<Workshop>> violations = this.validator.validate(validWorkshop);
        assertFalse(violations.isEmpty());
    }

}
