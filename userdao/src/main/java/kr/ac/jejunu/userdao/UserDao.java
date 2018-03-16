package kr.ac.jejunu.userdao;

import java.sql.*;

public abstract class UserDao {
    public User get(int id) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from userinfo where id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return user;
    }

    public User add(User user) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into userinfo(name, password) values (?, ?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.executeUpdate();

        preparedStatement = connection.prepareStatement("select last_insert_id()");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        user.setId(resultSet.getInt(1));
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return user;
    }

    abstract public Connection getConnection() throws ClassNotFoundException, SQLException ;
//        Class.forName("com.mysql.jdbc.Driver");
//        return DriverManager.getConnection("jdbc:mysql://localhost/jeju?characterEncoding=utf-8", "jeju", "jejupw");
}
