package jm.task.core.jdbc.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final Connection connection;
    static {
        try {
            final String connectionUrl = "jdbc:mysql://localhost:3306/test";
            final String userName = "root";
            final String passWord = "root";
            connection = DriverManager.getConnection(connectionUrl, userName, passWord);
            connection.setAutoCommit(false);
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() {
        return connection;
    }
//    public static Connection getConnection() throws SQLException {
//        final String userName = "root";
//        final String passWord = "root";
//        final String connectionUrl = "jdbc:mysql://localhost:3306/test";
//        Connection connection = DriverManager.getConnection(connectionUrl, userName, passWord);
//        connection.setAutoCommit(false);
//        connection.commit();
//        return connection;
//    }
}

