package jm.task.core.jdbc.service;

import jm.task.core.jdbc.Main;
import jm.task.core.jdbc.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getConnection;

public class UserServiceImpl extends Main implements UserService {
    Connection connection = getConnection();

    public UserServiceImpl() throws SQLException {
    }

    public void createUsersTable() {

    }

    public void dropUsersTable() {

    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() throws SQLException {
        Statement statement = null;
        String sql = "TRUNCATE  user";
        statement.executeUpdate(sql);
    }
}