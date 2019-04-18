package com.test.mybatis.test;

import com.alibaba.fastjson.JSONObject;
import com.test.mybatis.MyBatis;
import com.test.mybatis.dao.UserDao;
import com.test.mybatis.dao.UserDaoImpl;
import com.test.mybatis.domain.User;
import java.io.InputStream;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class UserDaoImplTest {

    // 创建 sqlSessionFactory
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp(){

        // mybatis配置文件
        String resource = "mybatis/mybatis-config.xml";
        // 得到配置文件流
        InputStream inputStream = MyBatis.class.getClassLoader().getResourceAsStream(resource);
        // 创建会话工厂构造类
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 通过会话工厂构造类来和mybatis配置文件来获得会话工厂类
        sqlSessionFactory = builder.build(inputStream);
    }

    @Test
    public void testFindUserById(){
        // 创建UserDao的对象
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);

        User user = userDao.findUserById(1);

        System.out.println(JSONObject.toJSONString(user));

    }
}
