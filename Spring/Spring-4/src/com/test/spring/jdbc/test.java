package com.test.spring.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {

    // JDBC驱动
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
    // 数据库的账户密码
    static final String USER = "root";
    static final String PASS = "123456";
    static ResultSet rs = null;

    public static void main(String[] args) throws SQLException {
        // 第一步，加载一个Driver驱动
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            // 这里会发生类没有找到的异常
            e.printStackTrace();
        }
        try {
            // 第二步，创建数据库连接
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            // 第三步，创建SQL命令发送器statement
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM tb_student";
            // 第四步，通过statement发送SQL命令并得到结果
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                // 第五步，处理结果
                String id = rs.getString("id");
                System.out.println(id);
            }
            // 第六步，关闭数据库资源
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // 这里会发生SQL异常，因为我们提供的账户和密码不一定能连接成功
        } finally {
            rs.close();
        }
    }
}
