package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static Connection getConnection() throws SQLException {
        String sqlCommand = "CREATE TABLE IF NOT EXISTS User (id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50), lastName VARCHAR(50), age TINYINT )";
        String userName = "root";
        String passWord = "root";
        String connectionUrl = "jdbc:mysql://localhost:3306/test";
        Connection connection = DriverManager.getConnection(connectionUrl, userName, passWord);
        return connection;
    }
}
