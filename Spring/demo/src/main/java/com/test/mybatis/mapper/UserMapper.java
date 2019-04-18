package com.test.mybatis.mapper;

import com.test.mybatis.domain.User;

/**
 * 用户映射代理接口
 */
public interface UserMapper {

    /**
     * 根据id查找用户
     * @param userId
     * @return
     */
    User findUserById(int userId);

    /**
     * 根据名字模糊查询用户信息
     * @param name
     */
    void findUserByName(String name);

    /**
     * 插入用户
     * @param user
     */
    void insertUser(User user);

    /**
     * 根据id删除用户
     * @param userId
     */
    void deleteUserById(int userId);
}
