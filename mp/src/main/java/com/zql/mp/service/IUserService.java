package com.zql.mp.service;

import com.zql.mp.entity.User;

import java.util.List;

public interface IUserService {

    /**
     * 插入用户
     * @param user
     */
    void insert(User user);

    /**
     * 根据id查询用户
     * @param id
     */
    User selectById(int id);

    /**
     * 更新user
     * @param user
     */
    void updateById(User user);

    /**
     * 查询用户存放在list里
     * @return
     */
    List<User> selectList();

    /**
     * 根据id删除
     * @param id
     */
    void deleteById(int id);

    /**
     * 分页查询
     * @return
     */
    List<User> selectPage();
}
