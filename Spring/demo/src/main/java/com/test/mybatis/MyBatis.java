package com.test.mybatis;

import com.test.mybatis.domain.User;
import java.io.InputStream;
import java.util.List;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import com.alibaba.fastjson.JSONObject;

public class MyBatis {

    /**
     * 根据id获取对应的用户信息
     */
    @Ignore
    @Test
    public void testFindUserById(){
        // mybatis配置文件
        String resource = "mybatis/Mybatis-config.xml";
        // 得到配置文件流
        InputStream inputStream = MyBatis.class.getClassLoader().getResourceAsStream(resource);
        // 创建会话工厂构造类
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 通过会话工厂构造类来和mybatis配置文件来获得会话工厂类
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        // 通过会话工厂类获取对应的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 通过会话操作数据库
        // 第一个参数：映射文件中的statement的id,格式=namespace+"."+id
        // 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
        // sqlSession.selectOne结果是映射文件中所匹配的resultType
        User user = sqlSession.selectOne("user.findUserById",1L);
        // 释放资源
        sqlSession.close();

        System.out.println(JSONObject.toJSONString(user));
    }


    /**
     * 根据用户名称获取多个用户
     */
    @Test
    public void testFindUserByName(){

        // mybatis配置文件
        String resource = "mybatis/Mybatis-config.xml";
        // 得到配置文件流
        InputStream inputStream = MyBatis.class.getClassLoader().getResourceAsStream(resource);
        // 创建会话工厂构造类
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 通过会话工厂构造类来和mybatis配置文件来获得会话工厂类
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        // 通过会话工厂类获取对应的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 通过sqlSession查询出多条数据
        List<User> list = sqlSession.selectList("user.findUserByName","小");

        System.out.println(JSONObject.toJSONString(list));

        sqlSession.close();
    }

    /**
     * 添加用户
     */
    @Test
    public void testInsertUser(){
        // mybatis配置文件
        String resource = "mybatis/Mybatis-config.xml";
        // 得到配置文件流
        InputStream inputStream = MyBatis.class.getClassLoader().getResourceAsStream(resource);
        // 创建会话工厂构造类
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 通过会话工厂构造类来和mybatis配置文件来获得会话工厂类
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        // 通过会话工厂类获取对应的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();

        user.setName("小蓝");
        user.setSex("男");

        // 通过SqlSession插入对象
        sqlSession.insert("user.insertUser",user);
        // 提交事务
        sqlSession.commit();

        // mysql自增主键，执行insert提交之前自动生成的一个自增主键，通过mysql函数last_insert_id()获取刚刚插入的自增主键

        // 获取用户信息的主键
        System.out.println(JSONObject.toJSONString(user));

        sqlSession.close();
    }


    /**
     * 根据id删除用户
     */
    @Test
    public void testDeleteUser(){
        // mybatis配置文件
        String resource = "mybatis/Mybatis-config.xml";
        // 得到配置文件流
        InputStream inputStream = MyBatis.class.getClassLoader().getResourceAsStream(resource);
        // 创建会话工厂构造类
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 通过会话工厂构造类来和mybatis配置文件来获得会话工厂类
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        // 通过会话工厂类获取对应的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Integer id = 21;
        // 根据传入的id删除用户信息
        sqlSession.delete("user.deleteUserById",id);
        // 提交事务
        sqlSession.commit();

        // 输出信息
        System.out.println("删除用户id为"+id);

        sqlSession.close();
    }


    /**
     * 根据id更新用户
     */
    @Test
    public void testUpdateUser(){
        // mybatis配置文件
        String resource = "mybatis/Mybatis-config.xml";
        // 得到配置文件流
        InputStream inputStream = MyBatis.class.getClassLoader().getResourceAsStream(resource);
        // 创建会话工厂构造类
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 通过会话工厂构造类来和mybatis配置文件来获得会话工厂类
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        // 通过会话工厂类获取对应的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();

        user.setName("小蓝");
        user.setSex("男");

        // id必须传入
        user.setId(22);

        // 更新用户信息
        sqlSession.update("updateUser",user);
        // 提交事务
        sqlSession.commit();

        sqlSession.close();
    }

}
