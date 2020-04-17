package com.zql.validator.common;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * @author lawliet.L
 */
@RestControllerAdvice
@Component
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result defaultExceptionHandler(Exception e) {
        e.printStackTrace();

        if (e instanceof MethodArgumentNotValidException) { // 包装在请求体中的数据校验不通过触发这个异常
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) e;
            StringBuilder sb = new StringBuilder();
            methodArgumentNotValidException.getBindingResult().getAllErrors().forEach(error -> {
                sb.append(error.getDefaultMessage()).append(" ");
            });
            return new Result(403, sb.toString(), null);
        } else if (e instanceof BindException) {    // 放在url和表单中的数据触发这个异常
            BindException bindException = (BindException) e;
            StringBuilder sb = new StringBuilder();
            bindException.getBindingResult().getAllErrors().forEach(error -> {
                sb.append(error.getDefaultMessage()).append(" ");
            });
            return new Result(403, sb.toString(), null);
        } else if (e instanceof ConstraintViolationException) {    // 单参数校验触发这个异常
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) e;
            StringBuilder sb = new StringBuilder();
            constraintViolationException.getConstraintViolations().forEach(a -> {
                sb.append(a.getMessage()).append(" ");
            });
            return new Result(403, sb.toString(), null);
        }
        return null;
    }
}
