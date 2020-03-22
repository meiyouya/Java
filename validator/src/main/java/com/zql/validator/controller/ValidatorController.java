package com.zql.validator.controller;

import com.zql.validator.common.Result;
import com.zql.validator.entity.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author lawliet.L
 */
@RestController
@RequestMapping("/validator")
@Validated  // 如果类中的方法有单参数校验，则需要加此注解
public class ValidatorController {

    @GetMapping("/login")
    public User login(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            FieldError error = bindingResult.getFieldError();
            System.out.println(error.getField() + "\t" + error.getDefaultMessage());
            return null;
        }
        return user;
    }

    @GetMapping("/login2")
    public Result<User> login2(@Valid User user) {
        return Result.success(user);
    }

    @GetMapping("/username")
    public Result<User> getByUsername(@NotNull(message = "用户名不能为空") String username) {
        return Result.success(new User(1L, username, "123@11.com"));
    }
}
