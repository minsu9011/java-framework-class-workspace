package kr.ac.jejunu.userdao;

import java.sql.*;

public class HallaUserDao extends UserDao{
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/jeju?characterEncoding=utf-8", "jeju", "jejupw");
    }
}
