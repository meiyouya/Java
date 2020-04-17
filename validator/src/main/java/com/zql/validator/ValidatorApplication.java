package com.zql.validator;

import com.zql.validator.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author lawliet.L
 */
@SpringBootApplication
public class ValidatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidatorApplication.class, args);
        /*Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        User user = new User();
        user.setId(null);
        user.setUsername("");
        user.setEmail("213");
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        violations.forEach(a -> System.out.println(a.getPropertyPath() + "\t" + a.getMessage()));*/
    }

}
