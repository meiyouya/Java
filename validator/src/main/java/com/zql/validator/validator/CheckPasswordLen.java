package com.zql.validator.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author lawliet.L
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckPasswordLenValidator.class)
public @interface CheckPasswordLen {

    String message() default "密码长度不规范";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
