package jm.task.core.jdbc;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        Util.getInstance().getConnection();
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("имя1", "фамилия1", (byte) 3);
        userService.saveUser("имя2", "фамилия2", (byte) 6);
        userService.saveUser("имя3", "фамилия3", (byte) 45);
        userService.saveUser("имя4", "фамилия4", (byte) 4);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }

}


