package jm.task.core.jdbc;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        Util.getConnection();
        UserServiceImpl usi = new UserServiceImpl();
        usi.createUsersTable();
        usi.saveUser("имя1", "фамилия1", (byte) 3);
        usi.saveUser("имя2", "фамилия2", (byte) 6);
        usi.saveUser("имя3", "фамилия3", (byte) 45);
        usi.saveUser("имя4", "фамилия4", (byte) 4);
        usi.getAllUsers();
//      System.out.println(userDao.getAllUsers().toString());
        usi.cleanUsersTable();
        usi.dropUsersTable();
//      userDao.removeUserById(2);
    }

}


