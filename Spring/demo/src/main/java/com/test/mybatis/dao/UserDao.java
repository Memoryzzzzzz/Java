package com.test.mybatis.dao;

import com.test.mybatis.domain.User;

public interface UserDao {

    // 根据用户主键id获取用户
    User findUserById(int userId);

    // 插入用户
    void insertById(User user);

    // 根据用户id删除用户
    void deleteUserById(int userId);

}
