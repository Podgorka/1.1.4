package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class UserDaoJDBCImpl implements UserDao {


    public UserDaoJDBCImpl() {

    }

    Connection connection = Util.getInstance().getConnection();
    public void createUsersTable() throws SQLException {
        Statement statement;
        try {
            statement = connection.createStatement();
            String sqlCommand = "CREATE TABLE IF NOT EXISTS User (id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50), lastName VARCHAR(50), age TINYINT )";
            statement.executeUpdate(sqlCommand);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() throws SQLException {
        Statement statement;
        try {
            statement = connection.createStatement();
            String sql = "DROP TABLE IF EXISTS user";
            statement.execute(sql);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        PreparedStatement preparedStatement;
        String sql = "INSERT INTO user(name, lastName, age) VALUES (?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.println("User с именем – " + name + " добавлен в базу данных");
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) throws SQLException {
        Statement statement;
        try {
            statement = connection.createStatement();
            String sql = "DELETE FROM user " +
                    "WHERE id = id";
            statement.executeUpdate(sql);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() throws SQLException {
        Statement statement;
        String sql = "SELECT id, name, lastName, age FROM user";
        List <User> users = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User classUser = new User();
                classUser.setName(resultSet.getString(2));
                classUser.setLastName(resultSet.getString(3));
                classUser.setAge(resultSet.getByte(4));
                users.add(classUser);
            }
            System.out.println(users);
            connection.commit();
            return users;
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException(e);
        }
    }

    public void cleanUsersTable() throws SQLException {
        Statement statement;
        try {
            statement = connection.createStatement();
            String sql = "TRUNCATE  user";
            statement.executeUpdate(sql);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException(e);
        }
    }
}
