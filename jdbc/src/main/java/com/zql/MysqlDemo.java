package com.zql;

import java.sql.*;

public class MysqlDemo {

    // JDBC驱动名及数据库URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://39.108.92.8:3306/test";

    // 数据库的用户名和密码
    static final String USER = "root";
    static final String PASS = "521xwl54zql@MYSQL";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // 注册驱动
            Class.forName(JDBC_DRIVER);

            // 打开连接
            System.out.println("开始连接数据库...");
            connection = DriverManager.getConnection(DB_URL,USER,PASS);

            // 声明SQL
            statement = connection.createStatement();
            // statement = connection.prepareStatement();   这种方式可以防止SQL注入
            String sql = "select * from user";

            // 执行SQL
            resultSet = statement.executeQuery(sql);

            // 处理结果集
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                System.out.println("id:" + id + "\tusername:" + username + "\tpassword:" + password);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 关闭资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
