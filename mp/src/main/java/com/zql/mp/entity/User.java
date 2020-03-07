package com.zql.mp.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("user")
public class User extends Model<User> {

    private int id;

    private String username;

    private String password;

    private String address;

    private String sex;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
