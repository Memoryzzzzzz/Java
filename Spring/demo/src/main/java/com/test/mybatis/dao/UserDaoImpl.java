package com.test.mybatis.dao;

import com.test.mybatis.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDaoImpl implements UserDao {

    private SqlSessionFactory sqlSessionFactory;
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        // 需要向dao实现类中注入SqlSessionFactory
        // 这里通过构造方法进行注入
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(int userId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("user.findUserById",userId);
        sqlSession.close();
        return user;
    }

    @Override
    public void insertById(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("user.insertUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteUserById(int userId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("user.deleteUserById",userId);
        sqlSession.commit();
        sqlSession.close();
    }
}
