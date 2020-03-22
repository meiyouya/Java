package com.zql.validator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author lawliet.L
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotNull(message = "主键不能为null")
    private Long id;

    @NotEmpty(message = "用户名不能为空")
    private String username;

    @Email(message = "邮件格式不合法")
    @NotEmpty(message = "email不能为空")
    private String email;

}
