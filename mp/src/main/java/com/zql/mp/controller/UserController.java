package com.zql.mp.controller;

import com.zql.mp.entity.User;
import com.zql.mp.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/insert")
    public void insert() {
        User user = new User();
        user.setUsername("zs");
        user.setPassword("123");
        user.setAddress("anhui");
        user.setSex("male");
        user.insert();
//        userService.insert(user);
    }

    @RequestMapping("/updateById")
    public void updateById() {
        User user = userService.selectById(5);
        user.setAddress("新地址");
        user.updateById();
//        userService.updateById(user);

    }

    @RequestMapping("/selectById")
    public void get() {
        User user = userService.selectById(1);
        
        System.out.println("查询结果为：" + user);
    }

    @RequestMapping("/selectList")
    public void selectList() {
        List<User> userList = userService.selectList();
        System.out.println("查询结果：" + userList);
    }

    @RequestMapping("/deleteById")
    public void deleteById() {
        userService.deleteById(1);
    }

    @RequestMapping("/selectPage")
    public void selectPage() {
        List<User> userList = userService.selectPage();
        System.out.println("分页查询结果：" + userList);
    }
}
