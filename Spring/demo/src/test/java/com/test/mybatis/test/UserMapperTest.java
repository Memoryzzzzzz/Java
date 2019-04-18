package com.test.mybatis.test;

import com.alibaba.fastjson.JSONObject;
import com.test.mybatis.MyBatis;
import com.test.mybatis.mapper.UserMapper;
import java.io.InputStream;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class UserMapperTest {

    // 创建sqlSessionFactory
    private SqlSessionFactory sqlSessionFactory;

    @Before
        public void setUp(){

            // mybatis配置文件
            String resource = "mybatis/mybatis-config-new.xml";
            // 得到配置文件流
            InputStream inputStream = MyBatis.class.getClassLoader().getResourceAsStream(resource);
            // 创建会话工厂构造器
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            // 通过会话工厂构造类和mybatis配置文件来获取会话工厂类
            sqlSessionFactory = builder.build(inputStream);
    }

    @Test
    public void testFindUserById(){
        // 通过 SqlSessionFactory 获取 SqlSession
        System.out.println(sqlSessionFactory);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 通过 SqlSession 获取 userMapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(JSONObject.toJSONString(userMapper.findUserById(1)));

        sqlSession.close();
    }

}
