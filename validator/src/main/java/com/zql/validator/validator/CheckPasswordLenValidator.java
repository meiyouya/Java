package com.zql.validator.validator;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author lawliet.L
 */
public class CheckPasswordLenValidator implements ConstraintValidator<CheckPasswordLen, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value) || value.length() < 8 || value.length() > 16) {
            return false;
        }
        return true;
    }
}
