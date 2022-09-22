package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import javax.lang.model.element.Name;
import javax.persistence.Id;
import java.sql.*;
import java.util.Collection;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {
        Util.getConnection();
        UserDao userDao = new UserDaoJDBCImpl();
//
//        userDao.createUsersTable();
//        userDao.saveUser("имя1", "фамилия1", (byte) 3);
//        userDao.saveUser("имя2", "фамилия2", (byte) 6);
//        userDao.saveUser("имя3", "фамилия3", (byte) 45);
//        userDao.saveUser("имя4", "фамилия4", (byte) 4);
//
//        userDao.removeUserById(2);
//        userDao.getAllUsers();
//        System.out.println(userDao.getAllUsers().toString());
//        userDao.cleanUsersTable();
//        userDao.dropUsersTable();
    }

}


