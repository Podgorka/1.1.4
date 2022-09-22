package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.Main;
import jm.task.core.jdbc.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getConnection;

public class UserDaoJDBCImpl extends Main implements UserDao {


    public UserDaoJDBCImpl() throws SQLException {

    }
        Connection connection = getConnection();
    List <User> users = new ArrayList<>();
    public void createUsersTable() throws SQLException {
        Statement statement = connection.createStatement();
        String sqlCommand = "CREATE TABLE IF NOT EXISTS User (id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50), lastName VARCHAR(50), age TINYINT )";
        statement.executeUpdate(sqlCommand);
    }

    public void dropUsersTable() throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "DROP TABLE user";
        statement.executeUpdate(sql);
        System.out.println("drop");
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO user(name, lastName, age) VALUES (?, ?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, lastName);
        preparedStatement.setByte(3, age);
        preparedStatement.executeUpdate();
        final String QUERY = "SELECT id, name, lastName, age FROM user";
        ResultSet rs = preparedStatement.executeQuery(QUERY);
        System.out.println("User с именем – " + name + " добавлен в базу данных");
    }

    public void removeUserById(long id) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "DELETE FROM user " +
                "WHERE id = id";
        statement.executeUpdate(sql);
    }

    public List<User> getAllUsers() throws SQLException {
        Statement statement = null;
        String sql = "SELECT id, name, lastName, age FROM user";
        List <User> users = new ArrayList<>();
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            User classUser = new User();
            classUser.setName(resultSet.getString(2));
            classUser.setLastName(resultSet.getString(3));
            classUser.setAge(resultSet.getByte(4));
            users.add(classUser);
        }
        return users;
    }

    public void cleanUsersTable() throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "TRUNCATE  user";
        statement.executeUpdate(sql);

    }
}
