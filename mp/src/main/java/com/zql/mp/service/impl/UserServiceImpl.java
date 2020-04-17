package com.zql.mp.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zql.mp.entity.User;
import com.zql.mp.mapper.UserMapper;
import com.zql.mp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insert(User user) {
        Integer insert = userMapper.insert(user);
        System.out.println("影响行数：" + insert);
    }

    @Override
    public User selectById(int id) {
        User user = userMapper.selectById(id);
        System.out.println("查询结果：" + user);
        return user;
    }

    @Override
    public void updateById(User user) {
        Integer integer = userMapper.updateById(user);
        System.out.println("影响行数：" + integer);
    }

    @Override
    public List<User> selectList() {
        return userMapper.selectList(new EntityWrapper<User>().eq("address","anhui"));
    }

    @Override
    public void deleteById(int id) {
        Integer integer = userMapper.deleteById(id);
        System.out.println("影响行数：" + integer);
    }

    @Override
    public List<User> selectPage() {
        return userMapper.selectPage(new Page<User>(1,2),new EntityWrapper<User>().eq("username","zs"));
    }
}
