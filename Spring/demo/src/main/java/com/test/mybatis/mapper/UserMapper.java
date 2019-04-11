package com.test.mybatis.mapper;

import com.test.mybatis.domain.User;

public interface UserMapper {

    User findUserById(int id,String name);

}
